package com.sales.model.business;

import java.util.Date;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sales.model.basic.BasicModel;
import com.sales.model.business.Vip;
import com.sales.model.business.DrpMaterial;
import com.sales.model.business.Organization;
import com.sales.model.business.DrpPosTransInfo;



//t_vip_integral_log
//会员积分日志（会员退货的时候，也需要扣减相应的积分）
public class VipIntegralLog extends BasicModel{

		//主键
		private Long id;
		
		//关联会员编号
		@NotNull(message="关联会员编号不能为空！") 
		private Long vipId;
		
		//关联门店编号
		@NotNull(message="关联门店编号不能为空！") 
		private Long orgranizationId;
		
		//购买商品
		@NotNull(message="购买商品不能为空！") 
		private Long materialId;
		
		//关联交易流水号(因为交易流水可能被定期清理掉，所以数据的完整性可能已经被破坏，再关联交易流水的主键已经没有意义）
		private Long transactionId;
		
		//交易流水号
		@NotBlank(message="交易流水号不能为空！") 
		@Length(max=30)
		private String flowNo;
		
		//发生日期
		@DateTimeFormat(pattern = "yyyy-MM-dd")
		@JsonFormat(pattern = "yyyy-MM-dd")
		@NotNull(message="发生日期不能为空！") 
		private Date businessDate;
		
		//积分数（增加，减少加分数）
		@NotNull(message="积分数（增加，减少加分数）不能为空！") 
		private Long integral;
		

		private Vip vipIdRef;

		private Organization orgranizationIdRef;

		private DrpMaterial materialIdRef;

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
	    
		public Long getOrgranizationId() {
	        return orgranizationId;
	    }
	    
	    public void setOrgranizationId(Long orgranizationId) {
	        this.orgranizationId = orgranizationId;	
	    }
	    
		public Long getMaterialId() {
	        return materialId;
	    }
	    
	    public void setMaterialId(Long materialId) {
	        this.materialId = materialId;	
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
	    
		public Date getBusinessDate() {
	        return businessDate;
	    }
	    
	    public void setBusinessDate(Date businessDate) {
	        this.businessDate = businessDate;	
	    }
	    
		public Long getIntegral() {
	        return integral;
	    }
	    
	    public void setIntegral(Long integral) {
	        this.integral = integral;	
	    }
	    
		public Vip getVipIdRef() {
	        return vipIdRef;
	    }
	    
	    public void setVipIdRef(Vip vipIdRef) {
	        this.vipIdRef = vipIdRef;	
	    }
		public Organization getOrgranizationIdRef() {
	        return orgranizationIdRef;
	    }
	    
	    public void setOrgranizationIdRef(Organization orgranizationIdRef) {
	        this.orgranizationIdRef = orgranizationIdRef;	
	    }
		public DrpMaterial getMaterialIdRef() {
	        return materialIdRef;
	    }
	    
	    public void setMaterialIdRef(DrpMaterial materialIdRef) {
	        this.materialIdRef = materialIdRef;	
	    }
		public DrpPosTransInfo getTransactionIdRef() {
	        return transactionIdRef;
	    }
	    
	    public void setTransactionIdRef(DrpPosTransInfo transactionIdRef) {
	        this.transactionIdRef = transactionIdRef;	
	    }

}