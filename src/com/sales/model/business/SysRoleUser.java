package com.sales.model.business;

import java.util.Date;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sales.model.basic.BasicModel;
import com.sales.model.business.SysUser;
import com.sales.model.business.SysRole;



//t_sys_role_user
//用户角色关系
public class SysRoleUser extends BasicModel{

		//主键
		private Long id;
		
		//关联角色编号
		@NotNull(message="关联角色编号不能为空！") 
		private Long roleId;
		
		//关联用户编号
		@NotNull(message="关联用户编号不能为空！") 
		private Long userId;
		

		private SysRole roleIdRef;

		private SysUser userIdRef;

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
	    
		public Long getUserId() {
	        return userId;
	    }
	    
	    public void setUserId(Long userId) {
	        this.userId = userId;	
	    }
	    
		public SysRole getRoleIdRef() {
	        return roleIdRef;
	    }
	    
	    public void setRoleIdRef(SysRole roleIdRef) {
	        this.roleIdRef = roleIdRef;	
	    }
		public SysUser getUserIdRef() {
	        return userIdRef;
	    }
	    
	    public void setUserIdRef(SysUser userIdRef) {
	        this.userIdRef = userIdRef;	
	    }

}