package com.sales.model.business;

import java.util.Date;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sales.model.basic.BasicModel;
import com.sales.model.business.Vip;
import com.sales.model.business.ActRule;
import com.sales.model.business.Organization;
import com.sales.model.business.DrpPosTransInfo;



//t_vip_coupon
//现金券
public class VipCoupon extends BasicModel{

		//主键
		private Long id;
		
		//所属会员
		private Long vipId;
		
		//发送活动
		@NotNull(message="发送活动不能为空！") 
		private Long activityId;
		
		//发放门店
		@NotNull(message="发放门店不能为空！") 
		private Long organizationId;
		
		//发送现金券对应的交易流水号
		private Long transactionId;
		
		//交易流水号
		@NotBlank(message="交易流水号不能为空！") 
		@Length(max=30)
		private String flowNo;
		
		//现金券编号
		@NotBlank(message="现金券编号不能为空！") 
		@Length(max=20)
		private String couponSn;
		
		//发送时间
		@DateTimeFormat(pattern = "yyyy-MM-dd")
		@JsonFormat(pattern = "yyyy-MM-dd")
		@NotNull(message="发送时间不能为空！") 
		private Date issueDate;
		
		//使用时间
		@DateTimeFormat(pattern = "yyyy-MM-dd")
		@JsonFormat(pattern = "yyyy-MM-dd")
		private Date usedTime;
		
		//现金券面值
		@NotNull(message="现金券面值不能为空！") 
		private Double couponAmount;
		
		//已使用金额
		@NotNull(message="已使用金额不能为空！") 
		private Double usedAmount;
		

		private Vip vipIdRef;

		private ActRule activityIdRef;

		private Organization organizationIdRef;

		private DrpPosTransInfo transactionIdRef;







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
	    
		public String getFlowNo() {
	        return flowNo;
	    }
	    
	    public void setFlowNo(String flowNo) {
	        this.flowNo = flowNo == null ? null : flowNo.trim();
	    }
	    
		public String getCouponSn() {
	        return couponSn;
	    }
	    
	    public void setCouponSn(String couponSn) {
	        this.couponSn = couponSn == null ? null : couponSn.trim();
	    }
	    
		public Date getIssueDate() {
	        return issueDate;
	    }
	    
	    public void setIssueDate(Date issueDate) {
	        this.issueDate = issueDate;	
	    }
	    
		public Date getUsedTime() {
	        return usedTime;
	    }
	    
	    public void setUsedTime(Date usedTime) {
	        this.usedTime = usedTime;	
	    }
	    
		public Double getCouponAmount() {
	        return couponAmount;
	    }
	    
	    public void setCouponAmount(Double couponAmount) {
	        this.couponAmount = couponAmount;	
	    }
	    
		public Double getUsedAmount() {
	        return usedAmount;
	    }
	    
	    public void setUsedAmount(Double usedAmount) {
	        this.usedAmount = usedAmount;	
	    }
	    
		public Vip getVipIdRef() {
	        return vipIdRef;
	    }
	    
	    public void setVipIdRef(Vip vipIdRef) {
	        this.vipIdRef = vipIdRef;	
	    }
		public ActRule getActivityIdRef() {
	        return activityIdRef;
	    }
	    
	    public void setActivityIdRef(ActRule activityIdRef) {
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

}