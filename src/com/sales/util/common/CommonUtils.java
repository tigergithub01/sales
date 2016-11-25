package com.sales.util.common;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sales.model.basic.Const;
import com.sales.model.basic.JsonObj;
import com.sales.model.basic.ValidErrObj;
import com.sales.util.pager.helper.PageInfo;

public class CommonUtils {
	
	private static CommonUtils instance = null;
	
	public static CommonUtils getInstance(){
		if(instance==null){
			instance =  new CommonUtils();
		}
		return instance;
	}
	
	/**
	 * get current login uid
	 * @return
	 */
	public Long getLoginUserid(){
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		HttpSession session = request.getSession();
		return (Long)(session.getAttribute(Const.session_uid));
	}
	
	
	/**
	 * get current login uid
	 * @return
	 */
	public Long getLoginUserid(HttpSession session){
		return (Long)(session.getAttribute(Const.session_uid));
	}
	
	/**
	 * 判断是否为ajax请求
	 * @param request
	 * @return
	 */
	public static boolean isAjax(HttpServletRequest request) {  
        return "XMLHttpRequest".equals(request.getHeader("X-Requested-With"));  
    } 
	
	public static PrintWriter getPrintWriter() {
		HttpServletResponse response = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getResponse(); 
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter writer;
		try {
			writer = response.getWriter();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		return writer;
	}
	
	
	public JsonObj failed(String message){
		JsonObj json = new JsonObj(false, message);
		return json;
	}
	
	
	public JsonObj success(Object value){
		JsonObj json = new JsonObj(true, "操作成功！", value);
		return json;
	}
	
	public JsonObj success(){
		return this.success(null);
	}
	
	
	
	public void jsonFailed(){
		jsonFailed("请求出错!");
	}	
	
	public void jsonFailed(String message){
		jsonFailed(message, 0);
	}	
	
	public void jsonFailed(String message, int errCode){
		JsonObj json = new JsonObj(false, message);
		json.setErrCode(errCode);
		writeValueAsString(json);
	}
	
	
	public void jsonSuccess(Object value){
		JsonObj json = new JsonObj(true, "请求成功!", value);
		writeValueAsString(json);
	}
	
	public void jsonSuccess(String message, Object value){
		JsonObj json = new JsonObj(true, message, value);
		writeValueAsString(json);
	}
	
	public void writeValueAsString(Object value){
		try {
			PrintWriter printer = getPrintWriter();
			ObjectMapper mapper = new  ObjectMapper();
			String jsonStr = mapper.writeValueAsString(value);
			printer.print(jsonStr);
		} catch (JsonProcessingException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	/**
	 * 获取分页与排序信息，针对jquery easyui data list框架
	 * @param request
	 */
	public PageInfo getPageInfo(HttpServletRequest request){
		
		String sortColumn = (String) request.getParameter("sort");
		String sortOrder = (String) request.getParameter("order");
		String page = (String) request.getParameter("page");
		String rows = (String) request.getParameter("rows");
		int pageNumber = StringUtils.isEmpty(page)?1:Integer.valueOf(page).intValue();
		int pageSize =  StringUtils.isEmpty(rows)?20:Integer.valueOf(rows).intValue();
		
		PageInfo pageInfo = new PageInfo();
		pageInfo.setSortColumn(sortColumn);
		pageInfo.setSortOrder(sortOrder);
		pageInfo.setPageNumber(pageNumber);
		pageInfo.setPageSize(pageSize);
		 
		return pageInfo;
	}
	
	public List<ValidErrObj> getValidErrors(BindingResult br){
		List<ValidErrObj> validErrList = new ArrayList<ValidErrObj>();
		for (ObjectError err : br.getAllErrors()) {
			ValidErrObj errObj = new ValidErrObj();
			errObj.setMessage(err.getDefaultMessage());
			errObj.setFiledName((String)(((DefaultMessageSourceResolvable)(err.getArguments()[0])).getCodes()[1]));
			validErrList.add(errObj);
		} 
		return validErrList;
	}
	
	public ValidErrObj getFirstValidError(BindingResult br){
		List<ValidErrObj> validErrList = this.getValidErrors(br);
		if(validErrList.isEmpty()){
			return null;
		}else{
			return validErrList.get(0);
		}
	}
	
	public String getFirstValidErrMsg(BindingResult br){
		ValidErrObj errObj = this.getFirstValidError(br);
		return (errObj==null)?null:errObj.getMessage();
	}
	
	public String getUid(){
		String uuid = UUID.randomUUID().toString(); //获取UUID并转化为String对象  
        uuid = uuid.replace("-", "");
        return uuid;
	}
	
	
	
}
