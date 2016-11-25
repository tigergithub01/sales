package com.sales.model.business;

import java.util.Date;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sales.model.basic.BasicModel;
import com.sales.model.business.SysParameterType;



//t_sys_parameter
//参数表
public class SysParameter extends BasicModel{

		//主键
		private Long id;
		
		//关联所属类别编号
		@NotNull(message="关联所属类别编号不能为空！") 
		private Long typeId;
		
		//参数值
		@NotBlank(message="参数值不能为空！") 
		@Length(max=100)
		private String paramVal;
		
		//序列号
		@NotNull(message="序列号不能为空！") 
		private Long sequenceId;
		
		//字典描述
		@Length(max=200)
		private String description;
		
		//1,有效；0,无效
		@NotNull(message="1,有效；0,无效不能为空！") 
		private Long status;
		

		private SysParameterType typeIdRef;





		public Long getId() {
	        return id;
	    }
	    
	    public void setId(Long id) {
	        this.id = id;	
	    }
	    
		public Long getTypeId() {
	        return typeId;
	    }
	    
	    public void setTypeId(Long typeId) {
	        this.typeId = typeId;	
	    }
	    
		public String getParamVal() {
	        return paramVal;
	    }
	    
	    public void setParamVal(String paramVal) {
	        this.paramVal = paramVal == null ? null : paramVal.trim();
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
	    
		public Long getStatus() {
	        return status;
	    }
	    
	    public void setStatus(Long status) {
	        this.status = status;	
	    }
	    
		public SysParameterType getTypeIdRef() {
	        return typeIdRef;
	    }
	    
	    public void setTypeIdRef(SysParameterType typeIdRef) {
	        this.typeIdRef = typeIdRef;	
	    }

}