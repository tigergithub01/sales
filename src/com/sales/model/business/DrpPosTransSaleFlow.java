package com.sales.model.business;

import java.util.Date;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sales.model.basic.BasicModel;
import com.sales.model.business.SysUnit;
import com.sales.model.business.DrpMatBatch;
import com.sales.model.business.DrpMaterial;
import com.sales.model.business.DrpPosTransInfo;



//t_drp_pos_trans_sale_flow
//pos销售流水
public class DrpPosTransSaleFlow extends BasicModel{

		//主键
		private Long id;
		
		//关联交易号
		@NotNull(message="关联交易号不能为空！") 
		private Long transactionId;
		
		//关联商品编号
		@NotNull(message="关联商品编号不能为空！") 
		private Long materialId;
		
		//数量
		@NotNull(message="数量不能为空！") 
		private Double quantity;
		
		//售价
		@NotNull(message="售价不能为空！") 
		private Double price;
		
		//销售金额
		@NotNull(message="销售金额不能为空！") 
		private Double amount;
		
		//计量单位
		@NotNull(message="计量单位不能为空！") 
		private Long unitId;
		
		//折扣
		private Double discount;
		
		//商品批号
		private Long batchId;
		
		//序号
		@NotNull(message="序号不能为空！") 
		private Long sequenceId;
		

		private DrpPosTransInfo transactionIdRef;

		private DrpMaterial materialIdRef;




		private SysUnit unitIdRef;


		private DrpMatBatch batchIdRef;


		public Long getId() {
	        return id;
	    }
	    
	    public void setId(Long id) {
	        this.id = id;	
	    }
	    
		public Long getTransactionId() {
	        return transactionId;
	    }
	    
	    public void setTransactionId(Long transactionId) {
	        this.transactionId = transactionId;	
	    }
	    
		public Long getMaterialId() {
	        return materialId;
	    }
	    
	    public void setMaterialId(Long materialId) {
	        this.materialId = materialId;	
	    }
	    
		public Double getQuantity() {
	        return quantity;
	    }
	    
	    public void setQuantity(Double quantity) {
	        this.quantity = quantity;	
	    }
	    
		public Double getPrice() {
	        return price;
	    }
	    
	    public void setPrice(Double price) {
	        this.price = price;	
	    }
	    
		public Double getAmount() {
	        return amount;
	    }
	    
	    public void setAmount(Double amount) {
	        this.amount = amount;	
	    }
	    
		public Long getUnitId() {
	        return unitId;
	    }
	    
	    public void setUnitId(Long unitId) {
	        this.unitId = unitId;	
	    }
	    
		public Double getDiscount() {
	        return discount;
	    }
	    
	    public void setDiscount(Double discount) {
	        this.discount = discount;	
	    }
	    
		public Long getBatchId() {
	        return batchId;
	    }
	    
	    public void setBatchId(Long batchId) {
	        this.batchId = batchId;	
	    }
	    
		public Long getSequenceId() {
	        return sequenceId;
	    }
	    
	    public void setSequenceId(Long sequenceId) {
	        this.sequenceId = sequenceId;	
	    }
	    
		public DrpPosTransInfo getTransactionIdRef() {
	        return transactionIdRef;
	    }
	    
	    public void setTransactionIdRef(DrpPosTransInfo transactionIdRef) {
	        this.transactionIdRef = transactionIdRef;	
	    }
		public DrpMaterial getMaterialIdRef() {
	        return materialIdRef;
	    }
	    
	    public void setMaterialIdRef(DrpMaterial materialIdRef) {
	        this.materialIdRef = materialIdRef;	
	    }
		public SysUnit getUnitIdRef() {
	        return unitIdRef;
	    }
	    
	    public void setUnitIdRef(SysUnit unitIdRef) {
	        this.unitIdRef = unitIdRef;	
	    }
		public DrpMatBatch getBatchIdRef() {
	        return batchIdRef;
	    }
	    
	    public void setBatchIdRef(DrpMatBatch batchIdRef) {
	        this.batchIdRef = batchIdRef;	
	    }

}