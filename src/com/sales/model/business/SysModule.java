package com.sales.model.business;

import java.util.Date;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sales.model.basic.BasicModel;
import com.sales.model.business.SysParameter;



//t_sys_module
//模块信息
public class SysModule extends BasicModel{

		//主键
		private Long id;
		
		//模块唯一编码
		@Length(max=50)
		private String code;
		
		//名称
		@NotBlank(message="名称不能为空！") 
		@Length(max=40)
		private String name;
		
		//关联父模块编号
		private Long parentId;
		
		//链接地址
		@Length(max=300)
		private String url;
		
		//序列号
		@NotNull(message="序列号不能为空！") 
		private Long sequenceId;
		
		//描述
		@Length(max=100)
		private String description;
		
		//对应的控制器编号
		@Length(max=60)
		private String controller;
		
		//对应操作
		@Length(max=30)
		private String action;
		
		//是否菜单项
		@NotNull(message="是否菜单项不能为空！") 
		private Long menuFlag;
		
		//是否有效?,1，是；0，否
		@NotNull(message="是否有效?,1，是；0，否不能为空！") 
		private Long status;
		



		private SysModule parentIdRef;






		private SysParameter menuFlagRef;

		private SysParameter statusRef;

		public Long getId() {
	        return id;
	    }
	    
	    public void setId(Long id) {
	        this.id = id;	
	    }
	    
		public String getCode() {
	        return code;
	    }
	    
	    public void setCode(String code) {
	        this.code = code == null ? null : code.trim();
	    }
	    
		public String getName() {
	        return name;
	    }
	    
	    public void setName(String name) {
	        this.name = name == null ? null : name.trim();
	    }
	    
		public Long getParentId() {
	        return parentId;
	    }
	    
	    public void setParentId(Long parentId) {
	        this.parentId = parentId;	
	    }
	    
		public String getUrl() {
	        return url;
	    }
	    
	    public void setUrl(String url) {
	        this.url = url == null ? null : url.trim();
	    }
	    
		public Long getSequenceId() {
	        return sequenceId;
	    }
	    
	    public void setSequenceId(Long sequenceId) {
	        this.sequenceId = sequenceId;	
	    }
	    
		public String getDescription() {
	        return description;
	    }
	    
	    public void setDescription(String description) {
	        this.description = description == null ? null : description.trim();
	    }
	    
		public String getController() {
	        return controller;
	    }
	    
	    public void setController(String controller) {
	        this.controller = controller == null ? null : controller.trim();
	    }
	    
		public String getAction() {
	        return action;
	    }
	    
	    public void setAction(String action) {
	        this.action = action == null ? null : action.trim();
	    }
	    
		public Long getMenuFlag() {
	        return menuFlag;
	    }
	    
	    public void setMenuFlag(Long menuFlag) {
	        this.menuFlag = menuFlag;	
	    }
	    
		public Long getStatus() {
	        return status;
	    }
	    
	    public void setStatus(Long status) {
	        this.status = status;	
	    }
	    
		public SysModule getParentIdRef() {
	        return parentIdRef;
	    }
	    
	    public void setParentIdRef(SysModule parentIdRef) {
	        this.parentIdRef = parentIdRef;	
	    }
		public SysParameter getMenuFlagRef() {
	        return menuFlagRef;
	    }
	    
	    public void setMenuFlagRef(SysParameter menuFlagRef) {
	        this.menuFlagRef = menuFlagRef;	
	    }
		public SysParameter getStatusRef() {
	        return statusRef;
	    }
	    
	    public void setStatusRef(SysParameter statusRef) {
	        this.statusRef = statusRef;	
	    }
	    
	    //临时字段
  		private java.util.List<SysModule> children; //子节点
  		private Boolean root = false;

  		public java.util.List<SysModule> getChildren() {
  			return children; 
  		}

  		public void setChildren(java.util.List<SysModule> children) {
  			this.children = children;
  		}

  		public Boolean getRoot() {
  			return root;
  		}

  		public void setRoot(Boolean root) {
  			this.root = root;
  		}
	    

}