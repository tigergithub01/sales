package com.sales.model.business;

import java.util.Date;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sales.model.basic.BasicModel;
import com.sales.model.business.SysRole;
import com.sales.model.business.SysModule;
import com.sales.model.business.SysOperation;



//t_sys_role_rights
//角色权限
public class SysRoleRights extends BasicModel{

		//主键
		private Long id;
		
		//关联角色编号
		@NotNull(message="关联角色编号不能为空！") 
		private Long roleId;
		
		//关联模块编号
		@NotNull(message="关联模块编号不能为空！") 
		private Long moduleId;
		
		//关联操作编号
		@NotNull(message="关联操作编号不能为空！") 
		private Long operationId;
		

		private SysRole roleIdRef;

		private SysModule moduleIdRef;

		private SysOperation operationIdRef;

		public Long getId() {
	        return id;
	    }
	    
	    public void setId(Long id) {
	        this.id = id;	
	    }
	    
		public Long getRoleId() {
	        return roleId;
	    }
	    
	    public void setRoleId(Long roleId) {
	        this.roleId = roleId;	
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
	    
		public SysRole getRoleIdRef() {
	        return roleIdRef;
	    }
	    
	    public void setRoleIdRef(SysRole roleIdRef) {
	        this.roleIdRef = roleIdRef;	
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