package com.sales.model.business;

import java.util.Date;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sales.model.basic.BasicModel;
import com.sales.model.business.DrpPosTransInfo;
import com.sales.model.business.DrpMaterial;
import com.sales.model.business.Organization;
import com.sales.model.business.Vip;
import com.sales.model.business.SysParameter;



//t_vip_deposit
//会员寄存
public class VipDeposit extends BasicModel{

		//主键
		private Long id;
		
		//关联会员编号
		@NotNull(message="关联会员编号不能为空！") 
		private Long vipId;
		
		//商品编号
		@NotNull(message="商品编号不能为空！") 
		private Long materialId;
		
		//关联门店编号
		@NotNull(message="关联门店编号不能为空！") 
		private Long organizationId;
		
		//寄存商品对应的交易流水号
		@NotNull(message="寄存商品对应的交易流水号不能为空！") 
		private Long transactionId;
		
		//寄存日期
		@DateTimeFormat(pattern = "yyyy-MM-dd")
		@JsonFormat(pattern = "yyyy-MM-dd")
		@NotNull(message="寄存日期不能为空！") 
		private Date depositDate;
		
		//寄存数量
		@NotNull(message="寄存数量不能为空！") 
		private Long quantity;
		
		//已领取数量
		@NotNull(message="已领取数量不能为空！") 
		private Long fetchQuantity;
		
		//寄存状态：寄存中，部分领取，已领取
		@NotNull(message="寄存状态：寄存中，部分领取，已领取不能为空！") 
		private Long status;
		

		private Vip vipIdRef;

		private DrpMaterial materialIdRef;

		private Organization organizationIdRef;

		private DrpPosTransInfo transactionIdRef;




		private SysParameter statusRef;

		public Long getId() {
	        return id;
	    }
	    
	    public void setId(Long id) {
	        this.id = id;	
	    }
	    
		public Long getVipId() {
	        return vipId;
	    }
	    
	    public void setVipId(Long vipId) {
	        this.vipId = vipId;	
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
	    
		public Long getTransactionId() {
	        return transactionId;
	    }
	    
	    public void setTransactionId(Long transactionId) {
	        this.transactionId = transactionId;	
	    }
	    
		public Date getDepositDate() {
	        return depositDate;
	    }
	    
	    public void setDepositDate(Date depositDate) {
	        this.depositDate = depositDate;	
	    }
	    
		public Long getQuantity() {
	        return quantity;
	    }
	    
	    public void setQuantity(Long quantity) {
	        this.quantity = quantity;	
	    }
	    
		public Long getFetchQuantity() {
	        return fetchQuantity;
	    }
	    
	    public void setFetchQuantity(Long fetchQuantity) {
	        this.fetchQuantity = fetchQuantity;	
	    }
	    
		public Long getStatus() {
	        return status;
	    }
	    
	    public void setStatus(Long status) {
	        this.status = status;	
	    }
	    
		public Vip getVipIdRef() {
	        return vipIdRef;
	    }
	    
	    public void setVipIdRef(Vip vipIdRef) {
	        this.vipIdRef = vipIdRef;	
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
		public DrpPosTransInfo getTransactionIdRef() {
	        return transactionIdRef;
	    }
	    
	    public void setTransactionIdRef(DrpPosTransInfo transactionIdRef) {
	        this.transactionIdRef = transactionIdRef;	
	    }
		public SysParameter getStatusRef() {
	        return statusRef;
	    }
	    
	    public void setStatusRef(SysParameter statusRef) {
	        this.statusRef = statusRef;	
	    }

}