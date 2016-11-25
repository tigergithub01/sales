package com.sales.model.business;

import java.util.Date;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sales.model.basic.BasicModel;
import com.sales.model.business.DrpMaterial;
import com.sales.model.business.Organization;



//t_drp_mat_price
//门店价格信息
public class DrpMatPrice extends BasicModel{

		//主键
		private Long id;
		
		//商品编号
		@NotNull(message="商品编号不能为空！") 
		private Long materialId;
		
		//组织机构编号
		@NotNull(message="组织机构编号不能为空！") 
		private Long organizationId;
		
		//批发价
		private Double salePrice;
		
		//零售价
		@NotNull(message="零售价不能为空！") 
		private Double retailPrice;
		
		//会员价
		@NotNull(message="会员价不能为空！") 
		private Double vipPrice;
		
		//会员价2
		@NotNull(message="会员价2不能为空！") 
		private Double vipPrice2;
		
		//会员价3
		@NotNull(message="会员价3不能为空！") 
		private Double vipPrice3;
		
		//会员价4
		@NotNull(message="会员价4不能为空！") 
		private Double vipPrice4;
		
		//会员价5
		@NotNull(message="会员价5不能为空！") 
		private Double vipPrice5;
		
		//截至日期（调价申请通过后，价格的生效日期）
		@DateTimeFormat(pattern = "yyyy-MM-dd")
		@JsonFormat(pattern = "yyyy-MM-dd")
		private Date effectiveStartDate;
		
		//截至日期（调价申请通过后，价格的有效截至日期）
		@DateTimeFormat(pattern = "yyyy-MM-dd")
		@JsonFormat(pattern = "yyyy-MM-dd")
		private Date effectiveEndDate;
		

		private DrpMaterial materialIdRef;

		private Organization organizationIdRef;










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
	    
		public Double getSalePrice() {
	        return salePrice;
	    }
	    
	    public void setSalePrice(Double salePrice) {
	        this.salePrice = salePrice;	
	    }
	    
		public Double getRetailPrice() {
	        return retailPrice;
	    }
	    
	    public void setRetailPrice(Double retailPrice) {
	        this.retailPrice = retailPrice;	
	    }
	    
		public Double getVipPrice() {
	        return vipPrice;
	    }
	    
	    public void setVipPrice(Double vipPrice) {
	        this.vipPrice = vipPrice;	
	    }
	    
		public Double getVipPrice2() {
	        return vipPrice2;
	    }
	    
	    public void setVipPrice2(Double vipPrice2) {
	        this.vipPrice2 = vipPrice2;	
	    }
	    
		public Double getVipPrice3() {
	        return vipPrice3;
	    }
	    
	    public void setVipPrice3(Double vipPrice3) {
	        this.vipPrice3 = vipPrice3;	
	    }
	    
		public Double getVipPrice4() {
	        return vipPrice4;
	    }
	    
	    public void setVipPrice4(Double vipPrice4) {
	        this.vipPrice4 = vipPrice4;	
	    }
	    
		public Double getVipPrice5() {
	        return vipPrice5;
	    }
	    
	    public void setVipPrice5(Double vipPrice5) {
	        this.vipPrice5 = vipPrice5;	
	    }
	    
		public Date getEffectiveStartDate() {
	        return effectiveStartDate;
	    }
	    
	    public void setEffectiveStartDate(Date effectiveStartDate) {
	        this.effectiveStartDate = effectiveStartDate;	
	    }
	    
		public Date getEffectiveEndDate() {
	        return effectiveEndDate;
	    }
	    
	    public void setEffectiveEndDate(Date effectiveEndDate) {
	        this.effectiveEndDate = effectiveEndDate;	
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

}