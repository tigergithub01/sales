package com.sales.model.business;

import java.util.Date;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sales.model.basic.BasicModel;



//t_sys_area
//区域信息（华东，华北地区等信息）
public class SysArea extends BasicModel{

		//主键
		private Long id;
		
		//区域编码
		@NotBlank(message="区域编码不能为空！") 
		@Length(max=20)
		private String code;
		
		//区域名称
		@NotBlank(message="区域名称不能为空！") 
		@Length(max=30)
		private String name;
		
		//关联父区域
		private Long parentId;
		



		private SysArea parentIdRef;

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
	    
		public SysArea getParentIdRef() {
	        return parentIdRef;
	    }
	    
	    public void setParentIdRef(SysArea parentIdRef) {
	        this.parentIdRef = parentIdRef;	
	    }

}