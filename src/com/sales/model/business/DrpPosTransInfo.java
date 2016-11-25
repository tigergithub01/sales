package com.sales.model.business;

import java.util.Date;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sales.model.basic.BasicModel;
import com.sales.model.business.Vip;
import com.sales.model.business.SysParameter;
import com.sales.model.business.DrpPosMachine;
import com.sales.model.business.Organization;
import com.sales.model.business.SysUser;



//t_drp_pos_trans_info
//交易流水
public class DrpPosTransInfo extends BasicModel{

		//主键
		private Long id;
		
		//交易方式：销售、退货、赠送
		@NotNull(message="交易方式：销售、退货、赠送不能为空！") 
		private Long transactionType;
		
		//收银机编号
		@NotNull(message="收银机编号不能为空！") 
		private Long machineId;
		
		//收银员编号
		@NotNull(message="收银员编号不能为空！") 
		private Long userId;
		
		//操作时间
		@DateTimeFormat(pattern = "yyyy-MM-dd")
		@JsonFormat(pattern = "yyyy-MM-dd")
		@NotNull(message="操作时间不能为空！") 
		private Date operationDate;
		
		//销售总数量
		@NotNull(message="销售总数量不能为空！") 
		private Double quantity;
		
		//销售总金额
		@NotNull(message="销售总金额不能为空！") 
		private Double amount;
		
		//交易流水号
		@NotBlank(message="交易流水号不能为空！") 
		@Length(max=30)
		private String flowNo;
		
		//关联会员编号
		private Long vipId;
		
		//班次(系统预定义班次如A、B、C等)
		private Long ondutyPeriod;
		
		//门店编号
		@NotNull(message="门店编号不能为空！") 
		private Long organizationId;
		

		private SysParameter transactionTypeRef;

		private DrpPosMachine machineIdRef;

		private SysUser userIdRef;





		private Vip vipIdRef;


		private Organization organizationIdRef;

		public Long getId() {
	        return id;
	    }
	    
	    public void setId(Long id) {
	        this.id = id;	
	    }
	    
		public Long getTransactionType() {
	        return transactionType;
	    }
	    
	    public void setTransactionType(Long transactionType) {
	        this.transactionType = transactionType;	
	    }
	    
		public Long getMachineId() {
	        return machineId;
	    }
	    
	    public void setMachineId(Long machineId) {
	        this.machineId = machineId;	
	    }
	    
		public Long getUserId() {
	        return userId;
	    }
	    
	    public void setUserId(Long userId) {
	        this.userId = userId;	
	    }
	    
		public Date getOperationDate() {
	        return operationDate;
	    }
	    
	    public void setOperationDate(Date operationDate) {
	        this.operationDate = operationDate;	
	    }
	    
		public Double getQuantity() {
	        return quantity;
	    }
	    
	    public void setQuantity(Double quantity) {
	        this.quantity = quantity;	
	    }
	    
		public Double getAmount() {
	        return amount;
	    }
	    
	    public void setAmount(Double amount) {
	        this.amount = amount;	
	    }
	    
		public String getFlowNo() {
	        return flowNo;
	    }
	    
	    public void setFlowNo(String flowNo) {
	        this.flowNo = flowNo == null ? null : flowNo.trim();
	    }
	    
		public Long getVipId() {
	        return vipId;
	    }
	    
	    public void setVipId(Long vipId) {
	        this.vipId = vipId;	
	    }
	    
		public Long getOndutyPeriod() {
	        return ondutyPeriod;
	    }
	    
	    public void setOndutyPeriod(Long ondutyPeriod) {
	        this.ondutyPeriod = ondutyPeriod;	
	    }
	    
		public Long getOrganizationId() {
	        return organizationId;
	    }
	    
	    public void setOrganizationId(Long organizationId) {
	        this.organizationId = organizationId;	
	    }
	    
		public SysParameter getTransactionTypeRef() {
	        return transactionTypeRef;
	    }
	    
	    public void setTransactionTypeRef(SysParameter transactionTypeRef) {
	        this.transactionTypeRef = transactionTypeRef;	
	    }
		public DrpPosMachine getMachineIdRef() {
	        return machineIdRef;
	    }
	    
	    public void setMachineIdRef(DrpPosMachine machineIdRef) {
	        this.machineIdRef = machineIdRef;	
	    }
		public SysUser getUserIdRef() {
	        return userIdRef;
	    }
	    
	    public void setUserIdRef(SysUser userIdRef) {
	        this.userIdRef = userIdRef;	
	    }
		public Vip getVipIdRef() {
	        return vipIdRef;
	    }
	    
	    public void setVipIdRef(Vip vipIdRef) {
	        this.vipIdRef = vipIdRef;	
	    }
		public Organization getOrganizationIdRef() {
	        return organizationIdRef;
	    }
	    
	    public void setOrganizationIdRef(Organization organizationIdRef) {
	        this.organizationIdRef = organizationIdRef;	
	    }

}