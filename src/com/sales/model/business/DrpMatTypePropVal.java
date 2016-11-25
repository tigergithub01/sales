package com.sales.model.business;

import java.util.Date;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sales.model.basic.BasicModel;
import com.sales.model.business.DrpMatTypeProp;



//t_drp_mat_type_prop_val
//商品属性值
public class DrpMatTypePropVal extends BasicModel{

		//主键
		private Long id;
		
		//属性类型编号
		@NotNull(message="属性类型编号不能为空！") 
		private Long propertyTypeId;
		
		//属性值
		@NotBlank(message="属性值不能为空！") 
		@Length(max=50)
		private String propertyValue;
		

		private DrpMatTypeProp propertyTypeIdRef;


		public Long getId() {
	        return id;
	    }
	    
	    public void setId(Long id) {
	        this.id = id;	
	    }
	    
		public Long getPropertyTypeId() {
	        return propertyTypeId;
	    }
	    
	    public void setPropertyTypeId(Long propertyTypeId) {
	        this.propertyTypeId = propertyTypeId;	
	    }
	    
		public String getPropertyValue() {
	        return propertyValue;
	    }
	    
	    public void setPropertyValue(String propertyValue) {
	        this.propertyValue = propertyValue == null ? null : propertyValue.trim();
	    }
	    
		public DrpMatTypeProp getPropertyTypeIdRef() {
	        return propertyTypeIdRef;
	    }
	    
	    public void setPropertyTypeIdRef(DrpMatTypeProp propertyTypeIdRef) {
	        this.propertyTypeIdRef = propertyTypeIdRef;	
	    }

}