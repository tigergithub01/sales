package com.sales.model.business;

import java.util.Date;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sales.model.basic.BasicModel;
import com.sales.model.business.SysUser;
import com.sales.model.business.SysModule;
import com.sales.model.business.SysOperation;



//t_sys_operation_log
//用户操作日志
public class SysOperationLog extends BasicModel{

		//主键
		private Long id;
		
		//操作用户
		@NotNull(message="操作用户不能为空！") 
		private Long userId;
		
		//操作日期
		@DateTimeFormat(pattern = "yyyy-MM-dd")
		@JsonFormat(pattern = "yyyy-MM-dd")
		@NotNull(message="操作日期不能为空！") 
		private Date operateDate;
		
		//操作模块
		private Long moduleId;
		
		//操作
		private Long operationId;
		
		//操作描述
		@Length(max=65535)
		private String operateDesc;
		
		//请求机器名
		@Length(max=50)
		private String remoteServer;
		
		//请求ip地址
		@Length(max=50)
		private String remoteAddr;
		
		//请求URL
		@Length(max=200)
		private String requestUrl;
		
		//类名
		@Length(max=50)
		private String controllerName;
		
		//方法名
		@Length(max=50)
		private String methodName;
		
		//错误编号，根据错误编号可以在日志文件中查看详细错误
		@Length(max=50)
		private String errorId;
		
		//错误信息
		@Length(max=4000)
		private String errorMessage;
		
		//操作系统
		@Length(max=200)
		private String osType;
		
		//浏览器
		@Length(max=200)
		private String browserType;
		

		private SysUser userIdRef;


		private SysModule moduleIdRef;

		private SysOperation operationIdRef;











		public Long getId() {
	        return id;
	    }
	    
	    public void setId(Long id) {
	        this.id = id;	
	    }
	    
		public Long getUserId() {
	        return userId;
	    }
	    
	    public void setUserId(Long userId) {
	        this.userId = userId;	
	    }
	    
		public Date getOperateDate() {
	        return operateDate;
	    }
	    
	    public void setOperateDate(Date operateDate) {
	        this.operateDate = operateDate;	
	    }
	    
		public Long getModuleId() {
	        return moduleId;
	    }
	    
	    public void setModuleId(Long moduleId) {
	        this.moduleId = moduleId;	
	    }
	    
		public Long getOperationId() {
	        return operationId;
	    }
	    
	    public void setOperationId(Long operationId) {
	        this.operationId = operationId;	
	    }
	    
		public String getOperateDesc() {
	        return operateDesc;
	    }
	    
	    public void setOperateDesc(String operateDesc) {
	        this.operateDesc = operateDesc == null ? null : operateDesc.trim();
	    }
	    
		public String getRemoteServer() {
	        return remoteServer;
	    }
	    
	    public void setRemoteServer(String remoteServer) {
	        this.remoteServer = remoteServer == null ? null : remoteServer.trim();
	    }
	    
		public String getRemoteAddr() {
	        return remoteAddr;
	    }
	    
	    public void setRemoteAddr(String remoteAddr) {
	        this.remoteAddr = remoteAddr == null ? null : remoteAddr.trim();
	    }
	    
		public String getRequestUrl() {
	        return requestUrl;
	    }
	    
	    public void setRequestUrl(String requestUrl) {
	        this.requestUrl = requestUrl == null ? null : requestUrl.trim();
	    }
	    
		public String getControllerName() {
	        return controllerName;
	    }
	    
	    public void setControllerName(String controllerName) {
	        this.controllerName = controllerName == null ? null : controllerName.trim();
	    }
	    
		public String getMethodName() {
	        return methodName;
	    }
	    
	    public void setMethodName(String methodName) {
	        this.methodName = methodName == null ? null : methodName.trim();
	    }
	    
		public String getErrorId() {
	        return errorId;
	    }
	    
	    public void setErrorId(String errorId) {
	        this.errorId = errorId == null ? null : errorId.trim();
	    }
	    
		public String getErrorMessage() {
	        return errorMessage;
	    }
	    
	    public void setErrorMessage(String errorMessage) {
	        this.errorMessage = errorMessage == null ? null : errorMessage.trim();
	    }
	    
		public String getOsType() {
	        return osType;
	    }
	    
	    public void setOsType(String osType) {
	        this.osType = osType == null ? null : osType.trim();
	    }
	    
		public String getBrowserType() {
	        return browserType;
	    }
	    
	    public void setBrowserType(String browserType) {
	        this.browserType = browserType == null ? null : browserType.trim();
	    }
	    
		public SysUser getUserIdRef() {
	        return userIdRef;
	    }
	    
	    public void setUserIdRef(SysUser userIdRef) {
	        this.userIdRef = userIdRef;	
	    }
		public SysModule getModuleIdRef() {
	        return moduleIdRef;
	    }
	    
	    public void setModuleIdRef(SysModule moduleIdRef) {
	        this.moduleIdRef = moduleIdRef;	
	    }
		public SysOperation getOperationIdRef() {
	        return operationIdRef;
	    }
	    
	    public void setOperationIdRef(SysOperation operationIdRef) {
	        this.operationIdRef = operationIdRef;	
	    }

}