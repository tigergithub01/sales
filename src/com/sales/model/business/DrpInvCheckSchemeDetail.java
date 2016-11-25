package com.sales.model.business;

import java.util.Date;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sales.model.basic.BasicModel;
import com.sales.model.business.DrpMaterial;
import com.sales.model.business.DrpInvCheckScheme;
import com.sales.model.business.DrpBrand;
import com.sales.model.business.DrpMatType;



//t_drp_inv_check_scheme_detail
//盘点方案明细
public class DrpInvCheckSchemeDetail extends BasicModel{

		//主键
		private Long id;
		
		//关联盘点编号
		@NotNull(message="关联盘点编号不能为空！") 
		private Long schemeId;
		
		//商品编号
		private Long materialId;
		
		//品牌编号
		@NotNull(message="品牌编号不能为空！") 
		private Long brandId;
		
		//关联商品类别编号
		private Long matTypeId;
		

		private DrpInvCheckScheme schemeIdRef;

		private DrpMaterial materialIdRef;

		private DrpBrand brandIdRef;

		private DrpMatType matTypeIdRef;

		public Long getId() {
	        return id;
	    }
	    
	    public void setId(Long id) {
	        this.id = id;	
	    }
	    
		public Long getSchemeId() {
	        return schemeId;
	    }
	    
	    public void setSchemeId(Long schemeId) {
	        this.schemeId = schemeId;	
	    }
	    
		public Long getMaterialId() {
	        return materialId;
	    }
	    
	    public void setMaterialId(Long materialId) {
	        this.materialId = materialId;	
	    }
	    
		public Long getBrandId() {
	        return brandId;
	    }
	    
	    public void setBrandId(Long brandId) {
	        this.brandId = brandId;	
	    }
	    
		public Long getMatTypeId() {
	        return matTypeId;
	    }
	    
	    public void setMatTypeId(Long matTypeId) {
	        this.matTypeId = matTypeId;	
	    }
	    
		public DrpInvCheckScheme getSchemeIdRef() {
	        return schemeIdRef;
	    }
	    
	    public void setSchemeIdRef(DrpInvCheckScheme schemeIdRef) {
	        this.schemeIdRef = schemeIdRef;	
	    }
		public DrpMaterial getMaterialIdRef() {
	        return materialIdRef;
	    }
	    
	    public void setMaterialIdRef(DrpMaterial materialIdRef) {
	        this.materialIdRef = materialIdRef;	
	    }
		public DrpBrand getBrandIdRef() {
	        return brandIdRef;
	    }
	    
	    public void setBrandIdRef(DrpBrand brandIdRef) {
	        this.brandIdRef = brandIdRef;	
	    }
		public DrpMatType getMatTypeIdRef() {
	        return matTypeIdRef;
	    }
	    
	    public void setMatTypeIdRef(DrpMatType matTypeIdRef) {
	        this.matTypeIdRef = matTypeIdRef;	
	    }

}