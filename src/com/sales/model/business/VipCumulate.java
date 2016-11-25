package com.sales.model.business;

import java.util.Date;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sales.model.basic.BasicModel;
import com.sales.model.business.DrpPosTransInfo;
import com.sales.model.business.Activity;
import com.sales.model.business.DrpMaterial;
import com.sales.model.business.Organization;
import com.sales.model.business.Vip;
import com.sales.model.business.SysParameter;



//t_vip_cumulate
//会员商品累积
public class VipCumulate extends BasicModel{

		//主键
		private Long id;
		
		//关联会员编号
		@NotNull(message="关联会员编号不能为空！") 
		private Long vipId;
		
		//关联活动编号
		@NotNull(message="关联活动编号不能为空！") 
		private Long activityId;
		
		//开始累积商品对应的交易流水号
		@NotNull(message="开始累积商品对应的交易流水号不能为空！") 
		private Long transactionId;
		
		//关联门店编号
		@NotNull(message="关联门店编号不能为空！") 
		private Long organizationId;
		
		//商品编号
		@NotNull(message="商品编号不能为空！") 
		private Long materialId;
		
		//累积开始日期
		@DateTimeFormat(pattern = "yyyy-MM-dd")
		@JsonFormat(pattern = "yyyy-MM-dd")
		@NotNull(message="累积开始日期不能为空！") 
		private Date cumulateStartDate;
		
		//已经累积数量
		@NotNull(message="已经累积数量不能为空！") 
		private Long quantity;
		
		//累积状态：累积中，已赠送
		@NotNull(message="累积状态：累积中，已赠送不能为空！") 
		private Long status;
		
		//赠品领取时间
		@DateTimeFormat(pattern = "yyyy-MM-dd")
		@JsonFormat(pattern = "yyyy-MM-dd")
		private Date givenDate;
		

		private Vip vipIdRef;

		private Activity activityIdRef;

		private DrpPosTransInfo transactionIdRef;

		private Organization organizationIdRef;

		private DrpMaterial materialIdRef;



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
	    
		public Long getActivityId() {
	        return activityId;
	    }
	    
	    public void setActivityId(Long activityId) {
	        this.activityId = activityId;	
	    }
	    
		public Long getTransactionId() {
	        return transactionId;
	    }
	    
	    public void setTransactionId(Long transactionId) {
	        this.transactionId = transactionId;	
	    }
	    
		public Long getOrganizationId() {
	        return organizationId;
	    }
	    
	    public void setOrganizationId(Long organizationId) {
	        this.organizationId = organizationId;	
	    }
	    
		public Long getMaterialId() {
	        return materialId;
	    }
	    
	    public void setMaterialId(Long materialId) {
	        this.materialId = materialId;	
	    }
	    
		public Date getCumulateStartDate() {
	        return cumulateStartDate;
	    }
	    
	    public void setCumulateStartDate(Date cumulateStartDate) {
	        this.cumulateStartDate = cumulateStartDate;	
	    }
	    
		public Long getQuantity() {
	        return quantity;
	    }
	    
	    public void setQuantity(Long quantity) {
	        this.quantity = quantity;	
	    }
	    
		public Long getStatus() {
	        return status;
	    }
	    
	    public void setStatus(Long status) {
	        this.status = status;	
	    }
	    
		public Date getGivenDate() {
	        return givenDate;
	    }
	    
	    public void setGivenDate(Date givenDate) {
	        this.givenDate = givenDate;	
	    }
	    
		public Vip getVipIdRef() {
	        return vipIdRef;
	    }
	    
	    public void setVipIdRef(Vip vipIdRef) {
	        this.vipIdRef = vipIdRef;	
	    }
		public Activity getActivityIdRef() {
	        return activityIdRef;
	    }
	    
	    public void setActivityIdRef(Activity activityIdRef) {
	        this.activityIdRef = activityIdRef;	
	    }
		public DrpPosTransInfo getTransactionIdRef() {
	        return transactionIdRef;
	    }
	    
	    public void setTransactionIdRef(DrpPosTransInfo transactionIdRef) {
	        this.transactionIdRef = transactionIdRef;	
	    }
		public Organization getOrganizationIdRef() {
	        return organizationIdRef;
	    }
	    
	    public void setOrganizationIdRef(Organization organizationIdRef) {
	        this.organizationIdRef = organizationIdRef;	
	    }
		public DrpMaterial getMaterialIdRef() {
	        return materialIdRef;
	    }
	    
	    public void setMaterialIdRef(DrpMaterial materialIdRef) {
	        this.materialIdRef = materialIdRef;	
	    }
		public SysParameter getStatusRef() {
	        return statusRef;
	    }
	    
	    public void setStatusRef(SysParameter statusRef) {
	        this.statusRef = statusRef;	
	    }

}