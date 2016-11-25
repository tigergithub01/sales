package com.sales.model.business;

import java.util.Date;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sales.model.basic.BasicModel;
import com.sales.model.business.Organization;
import com.sales.model.business.DrpMaterial;
import com.sales.model.business.DrpBrand;
import com.sales.model.business.DrpMatType;



//t_drp_mat_warn_rule
//商品保质期警告规则，商品库存警告规则
public class DrpMatWarnRule extends BasicModel{

		//主键
		private Long id;
		
		//关联商品编号
		private Long materialId;
		
		//关联门店编号
		private Long organizationId;
		
		//关联商品类别编号
		private Long matTypeId;
		
		//关联商品品牌编号
		private Long brandId;
		
		//库存警告数量
		private Long warnQuantity;
		
		//剩余天数（保质期警告）
		private Long warnDays;
		

		private DrpMaterial materialIdRef;

		private Organization organizationIdRef;

		private DrpMatType matTypeIdRef;

		private DrpBrand brandIdRef;



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
	    
		public Long getOrganizationId() {
	        return organizationId;
	    }
	    
	    public void setOrganizationId(Long organizationId) {
	        this.organizationId = organizationId;	
	    }
	    
		public Long getMatTypeId() {
	        return matTypeId;
	    }
	    
	    public void setMatTypeId(Long matTypeId) {
	        this.matTypeId = matTypeId;	
	    }
	    
		public Long getBrandId() {
	        return brandId;
	    }
	    
	    public void setBrandId(Long brandId) {
	        this.brandId = brandId;	
	    }
	    
		public Long getWarnQuantity() {
	        return warnQuantity;
	    }
	    
	    public void setWarnQuantity(Long warnQuantity) {
	        this.warnQuantity = warnQuantity;	
	    }
	    
		public Long getWarnDays() {
	        return warnDays;
	    }
	    
	    public void setWarnDays(Long warnDays) {
	        this.warnDays = warnDays;	
	    }
	    
		public DrpMaterial getMaterialIdRef() {
	        return materialIdRef;
	    }
	    
	    public void setMaterialIdRef(DrpMaterial materialIdRef) {
	        this.materialIdRef = materialIdRef;	
	    }
		public Organization getOrganizationIdRef() {
	        return organizationIdRef;
	    }
	    
	    public void setOrganizationIdRef(Organization organizationIdRef) {
	        this.organizationIdRef = organizationIdRef;	
	    }
		public DrpMatType getMatTypeIdRef() {
	        return matTypeIdRef;
	    }
	    
	    public void setMatTypeIdRef(DrpMatType matTypeIdRef) {
	        this.matTypeIdRef = matTypeIdRef;	
	    }
		public DrpBrand getBrandIdRef() {
	        return brandIdRef;
	    }
	    
	    public void setBrandIdRef(DrpBrand brandIdRef) {
	        this.brandIdRef = brandIdRef;	
	    }

}