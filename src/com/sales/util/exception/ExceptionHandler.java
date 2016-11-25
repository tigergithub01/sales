package com.sales.util.exception;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import com.sales.util.common.CommonUtils;

@Component
/*SimpleMappingExceptionResolver 
 * HandlerExceptionResolver*/
public class ExceptionHandler implements  HandlerExceptionResolver {
	private Logger logger =  Logger.getLogger(HandlerExceptionResolver.class);

	@Override
	public ModelAndView resolveException(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex) {
		ModelAndView mv = new ModelAndView();
		if(CommonUtils.isAjax(request)){
			//ajax请求出错处理
			MappingJackson2JsonView view = new MappingJackson2JsonView();
			Map<String, Object> attributes = new java.util.HashMap<String, Object>();
			attributes.put("status", false);
			attributes.put("message", ex.getMessage());
			attributes.put("total",0);
			attributes.put("rows", new java.util.ArrayList());
			view.setAttributesMap(attributes);
//			CommonUtils.getInstance().jsonFailed(ex.getMessage());
			mv.setView(view);
			return mv;
		}
		
		//request 清出错处理
		mv.setViewName("/error/error");
		mv.addObject("exception", ex);
		System.out.println("exceptionHandler req" + ex.getMessage());
		// ex.printStackTrace();
		logger.error(ex);
		return mv;
	}

	
	/**
	 * TODO return ajax validation error 
	 * @param ex
	 * @return
	 */
	public List<Map<String,Object>> ConstraintViolationExceptionHandler(Exception ex){
		ConstraintViolationException e=(ConstraintViolationException)ex;
        Set<ConstraintViolation<?>> constraintViolations = e.getConstraintViolations();

         List<Map<String,Object>> validateInfos =new ArrayList<Map<String,Object>>();
         if(constraintViolations!=null && !constraintViolations.isEmpty()){
            for(ConstraintViolation<?> violation : constraintViolations){
                Map<String,Object> info = new HashMap<String,Object>();
                info.put("field", violation.getPropertyPath().toString().replaceAll("\\.","_"));
                info.put("message", violation.getPropertyPath().toString().replaceAll("\\.","_"));
                Class<? extends Object> class1 = violation.getRootBean().getClass();
//                String simpleName =StringUtils.getSpringName(class1); 
                String simpleName =class1.getName(); 
                if(simpleName.indexOf("$pcsubclass")>-1){  //这个判断是openjpa的代理类型,带$的不光是代理类型,内部类的名称同样有,所以编码上要约束
                     String[] ss = simpleName.split("\\$");
                     if(ss.length>1){
                         simpleName = ss[ss.length-2];
                         simpleName = simpleName.substring(0,1).toLowerCase()+simpleName.substring(1);
                     }
                }
                
                info.put("className", simpleName);
                Object ov =violation.getInvalidValue();
                if(ov==null){
                	info.put("value", "");
                }else{
                	info.put("value", ov.toString());
                }
                
                validateInfos.add(info);
            }
            
         }
        return validateInfos;
	}
}
