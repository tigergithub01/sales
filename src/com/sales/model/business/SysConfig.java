package com.sales.model.business;

import java.util.Date;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sales.model.basic.BasicModel;



//t_sys_config
//系统配置表(保质期警告默认天数，库存警告默认数量，消费多少元赠送消费积分数1分）
public class SysConfig extends BasicModel{

		//主键
		private Long id;
		
		//编码
		@NotBlank(message="编码不能为空！") 
		@Length(max=50)
		private String code;
		
		//值
		@NotBlank(message="值不能为空！") 
		@Length(max=100)
		private String value;
		
		//描述
		@Length(max=200)
		private String description;
		




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
	    

}