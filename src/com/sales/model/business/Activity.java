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
import com.sales.model.business.ActType;



//t_activity
//促销活动（门店促销与总部促销）(类别与品牌先按照只能选择一个进行设计）
public class Activity extends BasicModel{

		//主键
		private Long id;
		
		//促销活动名称
		@NotBlank(message="促销活动名称不能为空！") 
		@Length(max=30)
		private String name;
		
		//促销活动编号（自动生成）
		@NotBlank(message="促销活动编号（自动生成）不能为空！") 
		@Length(max=20)
		private String code;
		
		//活动类型（门店促销：打折，特价，满就减，满就折，满就送，积满就送，满额就送，第二件特价，再买就抵消，组合套餐，送现金券，无偿赠送  总部促销：打折，特价，满就减，满就折，满就送，积满就送）
		@NotNull(message="活动类型（门店促销：打折，特价，满就减，满就折，满就送，积满就送，满额就送，第二件特价，再买就抵消，组合套餐，送现金券，无偿赠送  总部促销：打折，特价，满就减，满就折，满就送，积满就送）不能为空！") 
		private Long activityType;
		
		//活动门店范围：所有门店，指定门店
		private Long activityOrgScope;
		
		//优惠范围（按类别，按品牌，按商品，全场[满就减，满就折，满就送，送现金券可用]）
		@NotNull(message="优惠范围（按类别，按品牌，按商品，全场[满就减，满就折，满就送，送现金券可用]）不能为空！") 
		private Long activityRange;
		
		//开始时间
		@DateTimeFormat(pattern = "yyyy-MM-dd")
		@JsonFormat(pattern = "yyyy-MM-dd")
		@NotNull(message="开始时间不能为空！") 
		private Date startDate;
		
		//结束时间
		@DateTimeFormat(pattern = "yyyy-MM-dd")
		@JsonFormat(pattern = "yyyy-MM-dd")
		@NotNull(message="结束时间不能为空！") 
		private Date endDate;
		
		//活动描述
		@Length(max=255)
		private String description;
		
		//门店寄存金额(待定）
		private Double amount;
		
		//门店销售授权类型：全部门店，仅授权门店
		@NotNull(message="门店销售授权类型：全部门店，仅授权门店不能为空！") 
		private Long authType;
		
		//申请意见
		@Length(max=255)
		private String applyDesc;
		
		//审核状态：草稿，待审核，已审核
		@NotNull(message="审核状态：草稿，待审核，已审核不能为空！") 
		private Long auditStatus;
		
		//审核时间
		@DateTimeFormat(pattern = "yyyy-MM-dd")
		@JsonFormat(pattern = "yyyy-MM-dd")
		private Date auditDate;
		
		//审核人
		private Long auditUserId;
		
		//审核意见
		@Length(max=255)
		private String auditDesc;
		
		//活动状态（不是必填项）（未开始，进行中，已结束）(可以根据起止日期来自动计算）
		private Long status;
		
		//创建人
		private Long createUserId;
		
		//创建时间
		@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
		@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
		private Date createDate;
		
		//更新人
		private Long updateUserId;
		
		//更新时间
		@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
		@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
		private Date updateDate;
		



		private ActType activityTypeRef;

		private SysParameter activityOrgScopeRef;

		private SysParameter activityRangeRef;





		private SysParameter authTypeRef;


		private SysParameter auditStatusRef;




		private SysParameter statusRef;

		private SysUser createUserIdRef;


		private SysUser updateUserIdRef;


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
	    
		public String getCode() {
	        return code;
	    }
	    
	    public void setCode(String code) {
	        this.code = code == null ? null : code.trim();
	    }
	    
		public Long getActivityType() {
	        return activityType;
	    }
	    
	    public void setActivityType(Long activityType) {
	        this.activityType = activityType;	
	    }
	    
		public Long getActivityOrgScope() {
	        return activityOrgScope;
	    }
	    
	    public void setActivityOrgScope(Long activityOrgScope) {
	        this.activityOrgScope = activityOrgScope;	
	    }
	    
		public Long getActivityRange() {
	        return activityRange;
	    }
	    
	    public void setActivityRange(Long activityRange) {
	        this.activityRange = activityRange;	
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
	    
		public String getDescription() {
	        return description;
	    }
	    
	    public void setDescription(String description) {
	        this.description = description == null ? null : description.trim();
	    }
	    
		public Double getAmount() {
	        return amount;
	    }
	    
	    public void setAmount(Double amount) {
	        this.amount = amount;	
	    }
	    
		public Long getAuthType() {
	        return authType;
	    }
	    
	    public void setAuthType(Long authType) {
	        this.authType = authType;	
	    }
	    
		public String getApplyDesc() {
	        return applyDesc;
	    }
	    
	    public void setApplyDesc(String applyDesc) {
	        this.applyDesc = applyDesc == null ? null : applyDesc.trim();
	    }
	    
		public Long getAuditStatus() {
	        return auditStatus;
	    }
	    
	    public void setAuditStatus(Long auditStatus) {
	        this.auditStatus = auditStatus;	
	    }
	    
		public Date getAuditDate() {
	        return auditDate;
	    }
	    
	    public void setAuditDate(Date auditDate) {
	        this.auditDate = auditDate;	
	    }
	    
		public Long getAuditUserId() {
	        return auditUserId;
	    }
	    
	    public void setAuditUserId(Long auditUserId) {
	        this.auditUserId = auditUserId;	
	    }
	    
		public String getAuditDesc() {
	        return auditDesc;
	    }
	    
	    public void setAuditDesc(String auditDesc) {
	        this.auditDesc = auditDesc == null ? null : auditDesc.trim();
	    }
	    
		public Long getStatus() {
	        return status;
	    }
	    
	    public void setStatus(Long status) {
	        this.status = status;	
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
	    
		public ActType getActivityTypeRef() {
	        return activityTypeRef;
	    }
	    
	    public void setActivityTypeRef(ActType activityTypeRef) {
	        this.activityTypeRef = activityTypeRef;	
	    }
		public SysParameter getActivityOrgScopeRef() {
	        return activityOrgScopeRef;
	    }
	    
	    public void setActivityOrgScopeRef(SysParameter activityOrgScopeRef) {
	        this.activityOrgScopeRef = activityOrgScopeRef;	
	    }
		public SysParameter getActivityRangeRef() {
	        return activityRangeRef;
	    }
	    
	    public void setActivityRangeRef(SysParameter activityRangeRef) {
	        this.activityRangeRef = activityRangeRef;	
	    }
		public SysParameter getAuthTypeRef() {
	        return authTypeRef;
	    }
	    
	    public void setAuthTypeRef(SysParameter authTypeRef) {
	        this.authTypeRef = authTypeRef;	
	    }
		public SysParameter getAuditStatusRef() {
	        return auditStatusRef;
	    }
	    
	    public void setAuditStatusRef(SysParameter auditStatusRef) {
	        this.auditStatusRef = auditStatusRef;	
	    }
		public SysParameter getStatusRef() {
	        return statusRef;
	    }
	    
	    public void setStatusRef(SysParameter statusRef) {
	        this.statusRef = statusRef;	
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