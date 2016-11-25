package com.sales.controller.common;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sales.model.basic.JsonObj;
import com.sales.model.business.SysUser;
import com.sales.util.common.CommonUtils;

public class BasicController {
	/**
	 * 优先级高于HandlerExceptionResolver
	 */
	/*@ExceptionHandler*/  
    public String exp(HttpServletRequest request, Exception ex) {  
        request.setAttribute("exception", ex);  
        return "/error/error";  
    }     
    
    @ModelAttribute("auth")
    public Map<String,Object> auth(){
    	//compare with privilege stored in session with operation code and method.
    	Map<String,Object> auth =  new HashMap<String,Object>();
    	auth.put("add", true);
    	auth.put("edit", true);
    	auth.put("delete", true);
    	auth.put("view", true);
    	auth.put("index", true);
    	auth.put("print", true);
    	auth.put("export", true);
    	auth.put("audit", true);
    	auth.put("controller", getClass().getSimpleName());
    	return auth;
    }
    
    @ModelAttribute("uuid")
    public String uuid(HttpServletRequest request, @ModelAttribute("uid") String uid){
    	if(StringUtils.isEmpty(uid)){
    		return CommonUtils.getInstance().getUid();
    	}else{
    		return uid;
    	}
    }
    
    @ResponseBody
	@RequestMapping(value = "/print")
	public JsonObj print(@ModelAttribute("sysUser") SysUser sysUser,
			BindingResult br,Model model){
    	return new JsonObj(true);
    }
    
    @ResponseBody
	@RequestMapping(value = "/export")
	public JsonObj export(@ModelAttribute("sysUser") SysUser sysUser,
			BindingResult br,Model model){
    	return new JsonObj(true);
    }
    
    
}
