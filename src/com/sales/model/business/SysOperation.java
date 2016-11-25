package com.sales.model.business;

import java.util.Date;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sales.model.basic.BasicModel;



//t_sys_operation
//模块操作
public class SysOperation extends BasicModel{

		//主键
		private Long id;
		
		//操作编码，add-增加，del-删除，view-查看，save-修改，print-打印，list-浏览
		@NotBlank(message="操作编码，add-增加，del-删除，view-查看，save-修改，print-打印，list-浏览不能为空！") 
		@Length(max=20)
		private String code;
		
		//增加，删除，查看，修改，打印，浏览，导出
		@NotBlank(message="增加，删除，查看，修改，打印，浏览，导出不能为空！") 
		@Length(max=30)
		private String name;
		
		//显示顺序
		@NotNull(message="显示顺序不能为空！") 
		private Long sequenceId;
		
		//方法名
		@Length(max=30)
		private String methodName;
		





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
	    
		public Long getSequenceId() {
	        return sequenceId;
	    }
	    
	    public void setSequenceId(Long sequenceId) {
	        this.sequenceId = sequenceId;	
	    }
	    
		public String getMethodName() {
	        return methodName;
	    }
	    
	    public void setMethodName(String methodName) {
	        this.methodName = methodName == null ? null : methodName.trim();
	    }
	    

}