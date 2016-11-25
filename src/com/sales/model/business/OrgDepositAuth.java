package com.sales.model.business;

import java.util.Date;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sales.model.basic.BasicModel;
import com.sales.model.business.SysUser;
import com.sales.model.business.Organization;



//t_org_deposit_auth
//门店寄存授权规则
public class OrgDepositAuth extends BasicModel{

		//门店编号
		private Long id;
		
		//门店编号
		private Long organizationId;
		
		//授权开始日期
		@DateTimeFormat(pattern = "yyyy-MM-dd")
		@JsonFormat(pattern = "yyyy-MM-dd")
		private Date startDate;
		
		//授权结束日期
		@DateTimeFormat(pattern = "yyyy-MM-dd")
		@JsonFormat(pattern = "yyyy-MM-dd")
		private Date endDate;
		
		//门店可寄存金额
		private Double depositAmt;
		
		//记录创建人
		private Long createUserId;
		
		//记录创建时间
		@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
		@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
		private Date createDate;
		
		//记录最后一次更新人
		private Long updateUserId;
		
		//记录最后一次更新时间
		@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
		@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
		private Date updateDate;
		

		private Organization organizationIdRef;




		private SysUser createUserIdRef;


		private SysUser updateUserIdRef;


		public Long getId() {
	        return id;
	    }
	    
	    public void setId(Long id) {
	        this.id = id;	
	    }
	    
		public Long getOrganizationId() {
	        return organizationId;
	    }
	    
	    public void setOrganizationId(Long organizationId) {
	        this.organizationId = organizationId;	
	    }
	    
		public Date getStartDate() {
	        return startDate;
	    }
	    
	    public void setStartDate(Date startDate) {
	        this.startDate = startDate;	
	    }
	    
		public Date getEndDate() {
	        return endDate;
	    }
	    
	    public void setEndDate(Date endDate) {
	        this.endDate = endDate;	
	    }
	    
		public Double getDepositAmt() {
	        return depositAmt;
	    }
	    
	    public void setDepositAmt(Double depositAmt) {
	        this.depositAmt = depositAmt;	
	    }
	    
		public Long getCreateUserId() {
	        return createUserId;
	    }
	    
	    public void setCreateUserId(Long createUserId) {
	        this.createUserId = createUserId;	
	    }
	    
		public Date getCreateDate() {
	        return createDate;
	    }
	    
	    public void setCreateDate(Date createDate) {
	        this.createDate = createDate;	
	    }
	    
		public Long getUpdateUserId() {
	        return updateUserId;
	    }
	    
	    public void setUpdateUserId(Long updateUserId) {
	        this.updateUserId = updateUserId;	
	    }
	    
		public Date getUpdateDate() {
	        return updateDate;
	    }
	    
	    public void setUpdateDate(Date updateDate) {
	        this.updateDate = updateDate;	
	    }
	    
		public Organization getOrganizationIdRef() {
	        return organizationIdRef;
	    }
	    
	    public void setOrganizationIdRef(Organization organizationIdRef) {
	        this.organizationIdRef = organizationIdRef;	
	    }
		public SysUser getCreateUserIdRef() {
	        return createUserIdRef;
	    }
	    
	    public void setCreateUserIdRef(SysUser createUserIdRef) {
	        this.createUserIdRef = createUserIdRef;	
	    }
		public SysUser getUpdateUserIdRef() {
	        return updateUserIdRef;
	    }
	    
	    public void setUpdateUserIdRef(SysUser updateUserIdRef) {
	        this.updateUserIdRef = updateUserIdRef;	
	    }

}