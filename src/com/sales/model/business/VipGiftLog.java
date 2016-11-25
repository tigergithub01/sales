package com.sales.model.business;

import java.util.Date;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sales.model.basic.BasicModel;
import com.sales.model.business.Vip;
import com.sales.model.business.Activity;
import com.sales.model.business.DrpMaterial;
import com.sales.model.business.Organization;
import com.sales.model.business.DrpPosTransInfo;



//t_vip_gift_log
//会员无偿赠送记录
public class VipGiftLog extends BasicModel{

		//主键
		private Long id;
		
		//关联会员编号
		@NotNull(message="关联会员编号不能为空！") 
		private Long vipId;
		
		//关联活动编号
		@NotNull(message="关联活动编号不能为空！") 
		private Long activityId;
		
		//关联门店编号
		@NotNull(message="关联门店编号不能为空！") 
		private Long organizationId;
		
		//赠送商品对应的交易流水号
		private Long transactionId;
		
		//商品编号
		@NotNull(message="商品编号不能为空！") 
		private Long materialId;
		
		//领取数量
		@NotNull(message="领取数量不能为空！") 
		private Long quantity;
		
		//赠品领取时间
		@DateTimeFormat(pattern = "yyyy-MM-dd")
		@JsonFormat(pattern = "yyyy-MM-dd")
		private Date givenDate;
		
		//交易流水号
		@NotBlank(message="交易流水号不能为空！") 
		@Length(max=30)
		private String flowNo;
		

		private Vip vipIdRef;

		private Activity activityIdRef;

		private Organization organizationIdRef;

		private DrpPosTransInfo transactionIdRef;

		private DrpMaterial materialIdRef;




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
	    
		public Long getMaterialId() {
	        return materialId;
	    }
	    
	    public void setMaterialId(Long materialId) {
	        this.materialId = materialId;	
	    }
	    
		public Long getQuantity() {
	        return quantity;
	    }
	    
	    public void setQuantity(Long quantity) {
	        this.quantity = quantity;	
	    }
	    
		public Date getGivenDate() {
	        return givenDate;
	    }
	    
	    public void setGivenDate(Date givenDate) {
	        this.givenDate = givenDate;	
	    }
	    
		public String getFlowNo() {
	        return flowNo;
	    }
	    
	    public void setFlowNo(String flowNo) {
	        this.flowNo = flowNo == null ? null : flowNo.trim();
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
		public DrpMaterial getMaterialIdRef() {
	        return materialIdRef;
	    }
	    
	    public void setMaterialIdRef(DrpMaterial materialIdRef) {
	        this.materialIdRef = materialIdRef;	
	    }

}