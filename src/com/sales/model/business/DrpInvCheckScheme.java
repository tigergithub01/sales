package com.sales.model.business;

import java.util.Date;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sales.model.basic.BasicModel;
import com.sales.model.business.SysUser;
import com.sales.model.business.SysParameter;
import com.sales.model.business.Organization;



//t_drp_inv_check_scheme
//盘点方案（盘点流程：门店制定盘点方案->门店提交审核->总部审核->门店选择盘点方案制作盘点录入单（可以查看盘点差异）-
public class DrpInvCheckScheme extends BasicModel{

		//主键
		private Long id;
		
		//盘点方案名称
		@Length(max=100)
		private String name;
		
		//方案描述
		@Length(max=200)
		private String description;
		
		//盘点范围（品牌，类别，单品，全店）
		@NotNull(message="盘点范围（品牌，类别，单品，全店）不能为空！") 
		private Long checkExtend;
		
		//审核状态：待审核，已审核
		@NotNull(message="审核状态：待审核，已审核不能为空！") 
		private Long auditStatus;
		
		//盘点状态（总部指定多门店盘点时，控制状态比较麻烦）：未执行，执行中，已执行（客户提供：盘点中，确认中，已完成）
		private Long checkStatus;
		
		//创建人
		@NotNull(message="创建人不能为空！") 
		private Long createUserId;
		
		//创建时间
		@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
		@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
		private Date createDate;
		
		//更新人
		@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
		@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
		private Date updateDate;
		
		//更新时间
		private Long updateUserId;
		
		//组织机构编号
		private Long organizationId;
		



		private SysParameter checkExtendRef;

		private SysParameter auditStatusRef;

		private SysParameter checkStatusRef;

		private SysUser createUserIdRef;



		private SysUser updateUserIdRef;

		private Organization organizationIdRef;

		public Long getId() {
	        return id;
	    }
	    
	    public void setId(Long id) {
	        this.id = id;	
	    }
	    
		public String getName() {
	        return name;
	    }
	    
	    public void setName(String name) {
	        this.name = name == null ? null : name.trim();
	    }
	    
		public String getDescription() {
	        return description;
	    }
	    
	    public void setDescription(String description) {
	        this.description = description == null ? null : description.trim();
	    }
	    
		public Long getCheckExtend() {
	        return checkExtend;
	    }
	    
	    public void setCheckExtend(Long checkExtend) {
	        this.checkExtend = checkExtend;	
	    }
	    
		public Long getAuditStatus() {
	        return auditStatus;
	    }
	    
	    public void setAuditStatus(Long auditStatus) {
	        this.auditStatus = auditStatus;	
	    }
	    
		public Long getCheckStatus() {
	        return checkStatus;
	    }
	    
	    public void setCheckStatus(Long checkStatus) {
	        this.checkStatus = checkStatus;	
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
	    
		public Date getUpdateDate() {
	        return updateDate;
	    }
	    
	    public void setUpdateDate(Date updateDate) {
	        this.updateDate = updateDate;	
	    }
	    
		public Long getUpdateUserId() {
	        return updateUserId;
	    }
	    
	    public void setUpdateUserId(Long updateUserId) {
	        this.updateUserId = updateUserId;	
	    }
	    
		public Long getOrganizationId() {
	        return organizationId;
	    }
	    
	    public void setOrganizationId(Long organizationId) {
	        this.organizationId = organizationId;	
	    }
	    
		public SysParameter getCheckExtendRef() {
	        return checkExtendRef;
	    }
	    
	    public void setCheckExtendRef(SysParameter checkExtendRef) {
	        this.checkExtendRef = checkExtendRef;	
	    }
		public SysParameter getAuditStatusRef() {
	        return auditStatusRef;
	    }
	    
	    public void setAuditStatusRef(SysParameter auditStatusRef) {
	        this.auditStatusRef = auditStatusRef;	
	    }
		public SysParameter getCheckStatusRef() {
	        return checkStatusRef;
	    }
	    
	    public void setCheckStatusRef(SysParameter checkStatusRef) {
	        this.checkStatusRef = checkStatusRef;	
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
		public Organization getOrganizationIdRef() {
	        return organizationIdRef;
	    }
	    
	    public void setOrganizationIdRef(Organization organizationIdRef) {
	        this.organizationIdRef = organizationIdRef;	
	    }

}