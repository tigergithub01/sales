package com.sales.model.business;

import java.util.Date;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sales.model.basic.BasicModel;
import com.sales.model.business.SysUser;
import com.sales.model.business.SysShippingType;
import com.sales.model.business.SysParameter;
import com.sales.model.business.DrpInvCheckScheme;
import com.sales.model.business.DrpSheetType;
import com.sales.model.business.Organization;



//t_drp_sheet
//业务单据：总部发货单，总部入库单，门店要货（补货）申请单，门店发货单，门店退货单，盘点录入单（录入盘点单时，直接输入实盘
public class DrpSheet extends BasicModel{

		//主键
		private Long id;
		
		//单据类型
		@NotNull(message="单据类型不能为空！") 
		private Long sheetType;
		
		//单据编码
		@NotBlank(message="单据编码不能为空！") 
		@Length(max=50)
		private String sheetNo;
		
		//制单人
		private Long userId;
		
		//制单日期
		@DateTimeFormat(pattern = "yyyy-MM-dd")
		@JsonFormat(pattern = "yyyy-MM-dd")
		@NotNull(message="制单日期不能为空！") 
		private Date businessDate;
		
		//备注
		@Length(max=200)
		private String description;
		
		//金额合计
		private Double totalAmount;
		
		//数量合计
		private Double totalQuantity;
		
		//单据创建人
		private Long createUserId;
		
		//创建日期
		@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
		@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
		private Date createDate;
		
		//更新人
		private Long updateUserId;
		
		//更新日期
		@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
		@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
		private Date updateDate;
		
		//组织机构编号
		private Long organizationId;
		
		//审核状态：草稿，审核通过，不通过，已完成（补货单，门店退货单状态需要配合付款状态pay_status，配送状态shipping_status一起使用，门店确认后为“已完成”状态，业务逻辑生效）
		private Long auditStatus;
		
		//申请意见
		@Length(max=255)
		private String applyDesc;
		
		//审核时间
		@DateTimeFormat(pattern = "yyyy-MM-dd")
		@JsonFormat(pattern = "yyyy-MM-dd")
		private Date auditDate;
		
		//审核人
		private Long auditUserId;
		
		//审核意见
		@Length(max=255)
		private String auditDesc;
		
		//关联盘点方案编号
		private Long invSchemeId;
		
		//付款状态（未付款，已付款）-补货申请，门店退货申请时用到
		private Long payStatus;
		
		//配送状态（未发货，已发货）补货申请，门店退货申请时用到
		private Long shippingStatus;
		
		//积分抵消金额（补货申请，门店退货申请）
		private Double integralAmt;
		
		//配送费用（补货申请，门店退货申请）
		private Double shippingAmt;
		
		//实际收款金额（补货申请，门店退货申请）
		private Double settleAmt;
		
		//配送方式（补货申请，门店退货申请）
		private Long shippingId;
		

		private DrpSheetType sheetTypeRef;


		private SysUser userIdRef;





		private SysUser createUserIdRef;


		private SysUser updateUserIdRef;


		private Organization organizationIdRef;

		private SysParameter auditStatusRef;



		private SysUser auditUserIdRef;


		private DrpInvCheckScheme invSchemeIdRef;

		private SysParameter payStatusRef;

		private SysParameter shippingStatusRef;




		private SysShippingType shippingIdRef;

		public Long getId() {
	        return id;
	    }
	    
	    public void setId(Long id) {
	        this.id = id;	
	    }
	    
		public Long getSheetType() {
	        return sheetType;
	    }
	    
	    public void setSheetType(Long sheetType) {
	        this.sheetType = sheetType;	
	    }
	    
		public String getSheetNo() {
	        return sheetNo;
	    }
	    
	    public void setSheetNo(String sheetNo) {
	        this.sheetNo = sheetNo == null ? null : sheetNo.trim();
	    }
	    
		public Long getUserId() {
	        return userId;
	    }
	    
	    public void setUserId(Long userId) {
	        this.userId = userId;	
	    }
	    
		public Date getBusinessDate() {
	        return businessDate;
	    }
	    
	    public void setBusinessDate(Date businessDate) {
	        this.businessDate = businessDate;	
	    }
	    
		public String getDescription() {
	        return description;
	    }
	    
	    public void setDescription(String description) {
	        this.description = description == null ? null : description.trim();
	    }
	    
		public Double getTotalAmount() {
	        return totalAmount;
	    }
	    
	    public void setTotalAmount(Double totalAmount) {
	        this.totalAmount = totalAmount;	
	    }
	    
		public Double getTotalQuantity() {
	        return totalQuantity;
	    }
	    
	    public void setTotalQuantity(Double totalQuantity) {
	        this.totalQuantity = totalQuantity;	
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
	    
		public Long getOrganizationId() {
	        return organizationId;
	    }
	    
	    public void setOrganizationId(Long organizationId) {
	        this.organizationId = organizationId;	
	    }
	    
		public Long getAuditStatus() {
	        return auditStatus;
	    }
	    
	    public void setAuditStatus(Long auditStatus) {
	        this.auditStatus = auditStatus;	
	    }
	    
		public String getApplyDesc() {
	        return applyDesc;
	    }
	    
	    public void setApplyDesc(String applyDesc) {
	        this.applyDesc = applyDesc == null ? null : applyDesc.trim();
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
	    
		public Long getInvSchemeId() {
	        return invSchemeId;
	    }
	    
	    public void setInvSchemeId(Long invSchemeId) {
	        this.invSchemeId = invSchemeId;	
	    }
	    
		public Long getPayStatus() {
	        return payStatus;
	    }
	    
	    public void setPayStatus(Long payStatus) {
	        this.payStatus = payStatus;	
	    }
	    
		public Long getShippingStatus() {
	        return shippingStatus;
	    }
	    
	    public void setShippingStatus(Long shippingStatus) {
	        this.shippingStatus = shippingStatus;	
	    }
	    
		public Double getIntegralAmt() {
	        return integralAmt;
	    }
	    
	    public void setIntegralAmt(Double integralAmt) {
	        this.integralAmt = integralAmt;	
	    }
	    
		public Double getShippingAmt() {
	        return shippingAmt;
	    }
	    
	    public void setShippingAmt(Double shippingAmt) {
	        this.shippingAmt = shippingAmt;	
	    }
	    
		public Double getSettleAmt() {
	        return settleAmt;
	    }
	    
	    public void setSettleAmt(Double settleAmt) {
	        this.settleAmt = settleAmt;	
	    }
	    
		public Long getShippingId() {
	        return shippingId;
	    }
	    
	    public void setShippingId(Long shippingId) {
	        this.shippingId = shippingId;	
	    }
	    
		public DrpSheetType getSheetTypeRef() {
	        return sheetTypeRef;
	    }
	    
	    public void setSheetTypeRef(DrpSheetType sheetTypeRef) {
	        this.sheetTypeRef = sheetTypeRef;	
	    }
		public SysUser getUserIdRef() {
	        return userIdRef;
	    }
	    
	    public void setUserIdRef(SysUser userIdRef) {
	        this.userIdRef = userIdRef;	
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
		public SysParameter getAuditStatusRef() {
	        return auditStatusRef;
	    }
	    
	    public void setAuditStatusRef(SysParameter auditStatusRef) {
	        this.auditStatusRef = auditStatusRef;	
	    }
		public SysUser getAuditUserIdRef() {
	        return auditUserIdRef;
	    }
	    
	    public void setAuditUserIdRef(SysUser auditUserIdRef) {
	        this.auditUserIdRef = auditUserIdRef;	
	    }
		public DrpInvCheckScheme getInvSchemeIdRef() {
	        return invSchemeIdRef;
	    }
	    
	    public void setInvSchemeIdRef(DrpInvCheckScheme invSchemeIdRef) {
	        this.invSchemeIdRef = invSchemeIdRef;	
	    }
		public SysParameter getPayStatusRef() {
	        return payStatusRef;
	    }
	    
	    public void setPayStatusRef(SysParameter payStatusRef) {
	        this.payStatusRef = payStatusRef;	
	    }
		public SysParameter getShippingStatusRef() {
	        return shippingStatusRef;
	    }
	    
	    public void setShippingStatusRef(SysParameter shippingStatusRef) {
	        this.shippingStatusRef = shippingStatusRef;	
	    }
		public SysShippingType getShippingIdRef() {
	        return shippingIdRef;
	    }
	    
	    public void setShippingIdRef(SysShippingType shippingIdRef) {
	        this.shippingIdRef = shippingIdRef;	
	    }

}