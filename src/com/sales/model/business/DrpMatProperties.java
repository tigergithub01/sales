package com.sales.model.business;

import java.util.Date;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sales.model.basic.BasicModel;
import com.sales.model.business.DrpMaterial;
import com.sales.model.business.DrpMatTypePropVal;
import com.sales.model.business.DrpMatTypeProp;



//t_drp_mat_properties
//商品自定义属性（普通属性）
public class DrpMatProperties extends BasicModel{

		//主键
		private Long id;
		
		//商品编号
		@NotNull(message="商品编号不能为空！") 
		private Long materialId;
		
		//属性编号
		@NotNull(message="属性编号不能为空！") 
		private Long propId;
		
		//属性值
		@NotNull(message="属性值不能为空！") 
		private Long propVal;
		
		//属性输入值
		@Length(max=50)
		private String propInputVal;
		

		private DrpMaterial materialIdRef;

		private DrpMatTypeProp propIdRef;

		private DrpMatTypePropVal propValRef;


		public Long getId() {
	        return id;
	    }
	    
	    public void setId(Long id) {
	        this.id = id;	
	    }
	    
		public Long getMaterialId() {
	        return materialId;
	    }
	    
	    public void setMaterialId(Long materialId) {
	        this.materialId = materialId;	
	    }
	    
		public Long getPropId() {
	        return propId;
	    }
	    
	    public void setPropId(Long propId) {
	        this.propId = propId;	
	    }
	    
		public Long getPropVal() {
	        return propVal;
	    }
	    
	    public void setPropVal(Long propVal) {
	        this.propVal = propVal;	
	    }
	    
		public String getPropInputVal() {
	        return propInputVal;
	    }
	    
	    public void setPropInputVal(String propInputVal) {
	        this.propInputVal = propInputVal == null ? null : propInputVal.trim();
	    }
	    
		public DrpMaterial getMaterialIdRef() {
	        return materialIdRef;
	    }
	    
	    public void setMaterialIdRef(DrpMaterial materialIdRef) {
	        this.materialIdRef = materialIdRef;	
	    }
		public DrpMatTypeProp getPropIdRef() {
	        return propIdRef;
	    }
	    
	    public void setPropIdRef(DrpMatTypeProp propIdRef) {
	        this.propIdRef = propIdRef;	
	    }
		public DrpMatTypePropVal getPropValRef() {
	        return propValRef;
	    }
	    
	    public void setPropValRef(DrpMatTypePropVal propValRef) {
	        this.propValRef = propValRef;	
	    }

}