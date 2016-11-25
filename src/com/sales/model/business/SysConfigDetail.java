package com.sales.model.business;

import java.util.Date;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sales.model.basic.BasicModel;
import com.sales.model.business.SysConfig;



//t_sys_config_detail
//系统配置明细，有多个值时适用
public class SysConfigDetail extends BasicModel{

		//主键编号
		private Long id;
		
		//关联配置编号
		@NotNull(message="关联配置编号不能为空！") 
		private Long configId;
		
		//值
		@NotBlank(message="值不能为空！") 
		@Length(max=60)
		private String value;
		
		//描述
		@Length(max=200)
		private String description;
		

		private SysConfig configIdRef;



		public Long getId() {
	        return id;
	    }
	    
	    public void setId(Long id) {
	        this.id = id;	
	    }
	    
		public Long getConfigId() {
	        return configId;
	    }
	    
	    public void setConfigId(Long configId) {
	        this.configId = configId;	
	    }
	    
		public String getValue() {
	        return value;
	    }
	    
	    public void setValue(String value) {
	        this.value = value == null ? null : value.trim();
	    }
	    
		public String getDescription() {
	        return description;
	    }
	    
	    public void setDescription(String description) {
	        this.description = description == null ? null : description.trim();
	    }
	    
		public SysConfig getConfigIdRef() {
	        return configIdRef;
	    }
	    
	    public void setConfigIdRef(SysConfig configIdRef) {
	        this.configIdRef = configIdRef;	
	    }

}