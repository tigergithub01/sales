package com.sales.model.business;

import java.util.Date;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sales.model.basic.BasicModel;
import com.sales.model.business.Organization;
import com.sales.model.business.DrpMatBatch;
import com.sales.model.business.DrpMaterial;



//t_drp_mat_inventory
//商品库存信息
public class DrpMatInventory extends BasicModel{

		//主键编号
		private Long id;
		
		//商品编号
		@NotNull(message="商品编号不能为空！") 
		private Long materialId;
		
		//组织机构编号
		@NotNull(message="组织机构编号不能为空！") 
		private Long organizationId;
		
		//商品批号
		private Long batchId;
		
		//库存数量
		@NotNull(message="库存数量不能为空！") 
		private Double quantity;
		
		//寄存数量
		@NotNull(message="寄存数量不能为空！") 
		private Double depositQuantity;
		
		//自采数量（门店自己采购商品数量）
		@NotNull(message="自采数量（门店自己采购商品数量）不能为空！") 
		private Double orgQuantity;
		
		//成本价
		private Double costPrice;
		
		//库存金额
		private Double stockAmount;
		

		private DrpMaterial materialIdRef;

		private Organization organizationIdRef;

		private DrpMatBatch batchIdRef;






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
	    
		public Long getBatchId() {
	        return batchId;
	    }
	    
	    public void setBatchId(Long batchId) {
	        this.batchId = batchId;	
	    }
	    
		public Double getQuantity() {
	        return quantity;
	    }
	    
	    public void setQuantity(Double quantity) {
	        this.quantity = quantity;	
	    }
	    
		public Double getDepositQuantity() {
	        return depositQuantity;
	    }
	    
	    public void setDepositQuantity(Double depositQuantity) {
	        this.depositQuantity = depositQuantity;	
	    }
	    
		public Double getOrgQuantity() {
	        return orgQuantity;
	    }
	    
	    public void setOrgQuantity(Double orgQuantity) {
	        this.orgQuantity = orgQuantity;	
	    }
	    
		public Double getCostPrice() {
	        return costPrice;
	    }
	    
	    public void setCostPrice(Double costPrice) {
	        this.costPrice = costPrice;	
	    }
	    
		public Double getStockAmount() {
	        return stockAmount;
	    }
	    
	    public void setStockAmount(Double stockAmount) {
	        this.stockAmount = stockAmount;	
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
		public DrpMatBatch getBatchIdRef() {
	        return batchIdRef;
	    }
	    
	    public void setBatchIdRef(DrpMatBatch batchIdRef) {
	        this.batchIdRef = batchIdRef;	
	    }

}