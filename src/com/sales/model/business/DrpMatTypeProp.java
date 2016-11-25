package com.sales.model.business;

import java.util.Date;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sales.model.basic.BasicModel;
import com.sales.model.business.SysParameter;
import com.sales.model.business.DrpMatType;



//t_drp_mat_type_prop
//商品分类自定义属性
public class DrpMatTypeProp extends BasicModel{

		//主键
		private Long id;
		
		//商品类别编号
		@NotNull(message="商品类别编号不能为空！") 
		private Long materialTypeId;
		
		//属性名
		@NotBlank(message="属性名不能为空！") 
		@Length(max=30)
		private String propName;
		
		//是否销售属性?1:是；0：否
		@NotNull(message="是否销售属性?1:是；0：否不能为空！") 
		private Long isSaleProp;
		
		//是否必填项？1：是；0：否
		@NotNull(message="是否必填项？1：是；0：否不能为空！") 
		private Long isRequired;
		
		//录入类型：输入，从列表中选取
		@NotNull(message="录入类型：输入，从列表中选取不能为空！") 
		private Long inputType;
		
		//是否可以多选？1：是，0：否
		@NotNull(message="是否可以多选？1：是，0：否不能为空！") 
		private Long multiSelect;
		

		private DrpMatType materialTypeIdRef;


		private SysParameter isSalePropRef;

		private SysParameter isRequiredRef;

		private SysParameter inputTypeRef;

		private SysParameter multiSelectRef;

		public Long getId() {
	        return id;
	    }
	    
	    public void setId(Long id) {
	        this.id = id;	
	    }
	    
		public Long getMaterialTypeId() {
	        return materialTypeId;
	    }
	    
	    public void setMaterialTypeId(Long materialTypeId) {
	        this.materialTypeId = materialTypeId;	
	    }
	    
		public String getPropName() {
	        return propName;
	    }
	    
	    public void setPropName(String propName) {
	        this.propName = propName == null ? null : propName.trim();
	    }
	    
		public Long getIsSaleProp() {
	        return isSaleProp;
	    }
	    
	    public void setIsSaleProp(Long isSaleProp) {
	        this.isSaleProp = isSaleProp;	
	    }
	    
		public Long getIsRequired() {
	        return isRequired;
	    }
	    
	    public void setIsRequired(Long isRequired) {
	        this.isRequired = isRequired;	
	    }
	    
		public Long getInputType() {
	        return inputType;
	    }
	    
	    public void setInputType(Long inputType) {
	        this.inputType = inputType;	
	    }
	    
		public Long getMultiSelect() {
	        return multiSelect;
	    }
	    
	    public void setMultiSelect(Long multiSelect) {
	        this.multiSelect = multiSelect;	
	    }
	    
		public DrpMatType getMaterialTypeIdRef() {
	        return materialTypeIdRef;
	    }
	    
	    public void setMaterialTypeIdRef(DrpMatType materialTypeIdRef) {
	        this.materialTypeIdRef = materialTypeIdRef;	
	    }
		public SysParameter getIsSalePropRef() {
	        return isSalePropRef;
	    }
	    
	    public void setIsSalePropRef(SysParameter isSalePropRef) {
	        this.isSalePropRef = isSalePropRef;	
	    }
		public SysParameter getIsRequiredRef() {
	        return isRequiredRef;
	    }
	    
	    public void setIsRequiredRef(SysParameter isRequiredRef) {
	        this.isRequiredRef = isRequiredRef;	
	    }
		public SysParameter getInputTypeRef() {
	        return inputTypeRef;
	    }
	    
	    public void setInputTypeRef(SysParameter inputTypeRef) {
	        this.inputTypeRef = inputTypeRef;	
	    }
		public SysParameter getMultiSelectRef() {
	        return multiSelectRef;
	    }
	    
	    public void setMultiSelectRef(SysParameter multiSelectRef) {
	        this.multiSelectRef = multiSelectRef;	
	    }

}