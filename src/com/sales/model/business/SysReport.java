package com.sales.model.business;

import java.util.Date;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sales.model.basic.BasicModel;
import com.sales.model.business.SysParameter;



//t_sys_report
//报表
public class SysReport extends BasicModel{

		//主键
		private Long id;
		
		//报表编码
		@NotBlank(message="报表编码不能为空！") 
		@Length(max=30)
		private String code;
		
		//报表名称
		@NotBlank(message="报表名称不能为空！") 
		@Length(max=100)
		private String name;
		
		//报表地址
		@NotBlank(message="报表地址不能为空！") 
		@Length(max=255)
		private String path;
		
		//是否有效？1：是；0：否
		@NotNull(message="是否有效？1：是；0：否不能为空！") 
		private Long status;
		




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
	    
		public String getPath() {
	        return path;
	    }
	    
	    public void setPath(String path) {
	        this.path = path == null ? null : path.trim();
	    }
	    
		public Long getStatus() {
	        return status;
	    }
	    
	    public void setStatus(Long status) {
	        this.status = status;	
	    }
	    
		public SysParameter getStatusRef() {
	        return statusRef;
	    }
	    
	    public void setStatusRef(SysParameter statusRef) {
	        this.statusRef = statusRef;	
	    }

}