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
import com.sales.model.business.DrpBrand;
import com.sales.model.business.DrpSupplier;
import com.sales.model.business.DrpMatType;
import com.sales.model.business.SysUnit;



//t_drp_material
//商品资料
public class DrpMaterial extends BasicModel{

		//主键
		private Long id;
		
		//商品编码
		@NotBlank(message="商品编码不能为空！") 
		@Length(max=50)
		private String code;
		
		//商品主条码
		@NotBlank(message="商品主条码不能为空！") 
		@Length(max=50)
		private String barcode;
		
		//商品名称
		@NotBlank(message="商品名称不能为空！") 
		@Length(max=100)
		private String name;
		
		//助记码
		@NotBlank(message="助记码不能为空！") 
		@Length(max=100)
		private String pinyin;
		
		//商品型号
		@Length(max=50)
		private String model;
		
		//商品规格
		@Length(max=50)
		private String spec;
		
		//计量单位
		@NotNull(message="计量单位不能为空！") 
		private Long unitId;
		
		//商品分类
		@NotNull(message="商品分类不能为空！") 
		private Long typeId;
		
		//品牌类型（备用）
		@NotNull(message="品牌类型（备用）不能为空！") 
		private Long brandId;
		
		//批发价（备用）
		private Double salePrice;
		
		//进货价(成本价)
		@NotNull(message="进货价(成本价)不能为空！") 
		private Double inPrice;
		
		//零售价
		@NotNull(message="零售价不能为空！") 
		private Double retailPrice;
		
		//会员价（备用）
		private Double vipPrice;
		
		//配送价
		private Double deliveryPrice;
		
		//进价税率（备用）
		private Double inTaxRate;
		
		//销价税率（备用）
		private Double saleTaxRate;
		
		//安全库存
		@NotNull(message="安全库存不能为空！") 
		private Long safetyQuantity;
		
		//描述
		@Length(max=400)
		private String description;
		
		//成本计算方式：加权平均法,   移动加权平均法,   先进先出法,   分批认定法
		private Long costType;
		
		//主供应商
		private Long supplierId;
		
		//是否可以销售？1：是；0：否
		@NotNull(message="是否可以销售？1：是；0：否不能为空！") 
		private Long isOnSale;
		
		//是否可以赠送（无偿赠送=可以赠送+不可以前台销售，无偿赠送需要配合is_on_sale字段一起使用）
		@NotNull(message="是否可以赠送（无偿赠送=可以赠送+不可以前台销售，无偿赠送需要配合is_on_sale字段一起使用）不能为空！") 
		private Long isGift;
		
		//是否批次管理?1,是:0,否
		private Long batchFlag;
		
		//保质期(天)
		private Long guaranteeDays;
		
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
		
		//创建门店（门店添加的商品需要在商品名称前加“* ”号）
		private Long organizationId;
		
		//购买此商品是否参与积分
		private Long isIntegral;
		
		//消费多少元赠送消费积分数1分（可以在系统配置设定预定义值）
		@NotNull(message="消费多少元赠送消费积分数1分（可以在系统配置设定预定义值）不能为空！") 
		private Long giveIntegralRate;
		
		//赠送等级积分数（收银系统中此字段待用）
		@NotNull(message="赠送等级积分数（收银系统中此字段待用）不能为空！") 
		private Long rankIntegral;
		
		//赠送消费积分数（收银系统中此字段待用）
		@NotNull(message="赠送消费积分数（收银系统中此字段待用）不能为空！") 
		private Long resumeIntegral;
		
		//可使用积分购买金额（收银系统中此字段待用）
		@NotNull(message="可使用积分购买金额（收银系统中此字段待用）不能为空！") 
		private Double integralAmount;
		
		//会员价二
		@NotNull(message="会员价二不能为空！") 
		private Double vipPrice2;
		
		//会员价三
		@NotNull(message="会员价三不能为空！") 
		private Double vipPrice3;
		
		//会员价四
		@NotNull(message="会员价四不能为空！") 
		private Double vipPrice4;
		
		//会员价五
		@NotNull(message="会员价五不能为空！") 
		private Double vipPrice5;
		
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
		







		private SysUnit unitIdRef;

		private DrpMatType typeIdRef;

		private DrpBrand brandIdRef;










		private SysParameter costTypeRef;

		private DrpSupplier supplierIdRef;

		private SysParameter isOnSaleRef;

		private SysParameter isGiftRef;

		private SysParameter batchFlagRef;


		private SysUser createUserIdRef;


		private SysUser updateUserIdRef;












		private SysParameter authTypeRef;


		private SysParameter auditStatusRef;


		private SysUser auditUserIdRef;


		public Long getId() {
	        return id;
	    }
	    
	    public void setId(Long id) {
	        this.id = id;	
	    }
	    
		public String getCode() {
	        return code;
	    }
	    
	    public void setCode(String code) {
	        this.code = code == null ? null : code.trim();
	    }
	    
		public String getBarcode() {
	        return barcode;
	    }
	    
	    public void setBarcode(String barcode) {
	        this.barcode = barcode == null ? null : barcode.trim();
	    }
	    
		public String getName() {
	        return name;
	    }
	    
	    public void setName(String name) {
	        this.name = name == null ? null : name.trim();
	    }
	    
		public String getPinyin() {
	        return pinyin;
	    }
	    
	    public void setPinyin(String pinyin) {
	        this.pinyin = pinyin == null ? null : pinyin.trim();
	    }
	    
		public String getModel() {
	        return model;
	    }
	    
	    public void setModel(String model) {
	        this.model = model == null ? null : model.trim();
	    }
	    
		public String getSpec() {
	        return spec;
	    }
	    
	    public void setSpec(String spec) {
	        this.spec = spec == null ? null : spec.trim();
	    }
	    
		public Long getUnitId() {
	        return unitId;
	    }
	    
	    public void setUnitId(Long unitId) {
	        this.unitId = unitId;	
	    }
	    
		public Long getTypeId() {
	        return typeId;
	    }
	    
	    public void setTypeId(Long typeId) {
	        this.typeId = typeId;	
	    }
	    
		public Long getBrandId() {
	        return brandId;
	    }
	    
	    public void setBrandId(Long brandId) {
	        this.brandId = brandId;	
	    }
	    
		public Double getSalePrice() {
	        return salePrice;
	    }
	    
	    public void setSalePrice(Double salePrice) {
	        this.salePrice = salePrice;	
	    }
	    
		public Double getInPrice() {
	        return inPrice;
	    }
	    
	    public void setInPrice(Double inPrice) {
	        this.inPrice = inPrice;	
	    }
	    
		public Double getRetailPrice() {
	        return retailPrice;
	    }
	    
	    public void setRetailPrice(Double retailPrice) {
	        this.retailPrice = retailPrice;	
	    }
	    
		public Double getVipPrice() {
	        return vipPrice;
	    }
	    
	    public void setVipPrice(Double vipPrice) {
	        this.vipPrice = vipPrice;	
	    }
	    
		public Double getDeliveryPrice() {
	        return deliveryPrice;
	    }
	    
	    public void setDeliveryPrice(Double deliveryPrice) {
	        this.deliveryPrice = deliveryPrice;	
	    }
	    
		public Double getInTaxRate() {
	        return inTaxRate;
	    }
	    
	    public void setInTaxRate(Double inTaxRate) {
	        this.inTaxRate = inTaxRate;	
	    }
	    
		public Double getSaleTaxRate() {
	        return saleTaxRate;
	    }
	    
	    public void setSaleTaxRate(Double saleTaxRate) {
	        this.saleTaxRate = saleTaxRate;	
	    }
	    
		public Long getSafetyQuantity() {
	        return safetyQuantity;
	    }
	    
	    public void setSafetyQuantity(Long safetyQuantity) {
	        this.safetyQuantity = safetyQuantity;	
	    }
	    
		public String getDescription() {
	        return description;
	    }
	    
	    public void setDescription(String description) {
	        this.description = description == null ? null : description.trim();
	    }
	    
		public Long getCostType() {
	        return costType;
	    }
	    
	    public void setCostType(Long costType) {
	        this.costType = costType;	
	    }
	    
		public Long getSupplierId() {
	        return supplierId;
	    }
	    
	    public void setSupplierId(Long supplierId) {
	        this.supplierId = supplierId;	
	    }
	    
		public Long getIsOnSale() {
	        return isOnSale;
	    }
	    
	    public void setIsOnSale(Long isOnSale) {
	        this.isOnSale = isOnSale;	
	    }
	    
		public Long getIsGift() {
	        return isGift;
	    }
	    
	    public void setIsGift(Long isGift) {
	        this.isGift = isGift;	
	    }
	    
		public Long getBatchFlag() {
	        return batchFlag;
	    }
	    
	    public void setBatchFlag(Long batchFlag) {
	        this.batchFlag = batchFlag;	
	    }
	    
		public Long getGuaranteeDays() {
	        return guaranteeDays;
	    }
	    
	    public void setGuaranteeDays(Long guaranteeDays) {
	        this.guaranteeDays = guaranteeDays;	
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
	    
		public Long getIsIntegral() {
	        return isIntegral;
	    }
	    
	    public void setIsIntegral(Long isIntegral) {
	        this.isIntegral = isIntegral;	
	    }
	    
		public Long getGiveIntegralRate() {
	        return giveIntegralRate;
	    }
	    
	    public void setGiveIntegralRate(Long giveIntegralRate) {
	        this.giveIntegralRate = giveIntegralRate;	
	    }
	    
		public Long getRankIntegral() {
	        return rankIntegral;
	    }
	    
	    public void setRankIntegral(Long rankIntegral) {
	        this.rankIntegral = rankIntegral;	
	    }
	    
		public Long getResumeIntegral() {
	        return resumeIntegral;
	    }
	    
	    public void setResumeIntegral(Long resumeIntegral) {
	        this.resumeIntegral = resumeIntegral;	
	    }
	    
		public Double getIntegralAmount() {
	        return integralAmount;
	    }
	    
	    public void setIntegralAmount(Double integralAmount) {
	        this.integralAmount = integralAmount;	
	    }
	    
		public Double getVipPrice2() {
	        return vipPrice2;
	    }
	    
	    public void setVipPrice2(Double vipPrice2) {
	        this.vipPrice2 = vipPrice2;	
	    }
	    
		public Double getVipPrice3() {
	        return vipPrice3;
	    }
	    
	    public void setVipPrice3(Double vipPrice3) {
	        this.vipPrice3 = vipPrice3;	
	    }
	    
		public Double getVipPrice4() {
	        return vipPrice4;
	    }
	    
	    public void setVipPrice4(Double vipPrice4) {
	        this.vipPrice4 = vipPrice4;	
	    }
	    
		public Double getVipPrice5() {
	        return vipPrice5;
	    }
	    
	    public void setVipPrice5(Double vipPrice5) {
	        this.vipPrice5 = vipPrice5;	
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
	    
		public SysUnit getUnitIdRef() {
	        return unitIdRef;
	    }
	    
	    public void setUnitIdRef(SysUnit unitIdRef) {
	        this.unitIdRef = unitIdRef;	
	    }
		public DrpMatType getTypeIdRef() {
	        return typeIdRef;
	    }
	    
	    public void setTypeIdRef(DrpMatType typeIdRef) {
	        this.typeIdRef = typeIdRef;	
	    }
		public DrpBrand getBrandIdRef() {
	        return brandIdRef;
	    }
	    
	    public void setBrandIdRef(DrpBrand brandIdRef) {
	        this.brandIdRef = brandIdRef;	
	    }
		public SysParameter getCostTypeRef() {
	        return costTypeRef;
	    }
	    
	    public void setCostTypeRef(SysParameter costTypeRef) {
	        this.costTypeRef = costTypeRef;	
	    }
		public DrpSupplier getSupplierIdRef() {
	        return supplierIdRef;
	    }
	    
	    public void setSupplierIdRef(DrpSupplier supplierIdRef) {
	        this.supplierIdRef = supplierIdRef;	
	    }
		public SysParameter getIsOnSaleRef() {
	        return isOnSaleRef;
	    }
	    
	    public void setIsOnSaleRef(SysParameter isOnSaleRef) {
	        this.isOnSaleRef = isOnSaleRef;	
	    }
		public SysParameter getIsGiftRef() {
	        return isGiftRef;
	    }
	    
	    public void setIsGiftRef(SysParameter isGiftRef) {
	        this.isGiftRef = isGiftRef;	
	    }
		public SysParameter getBatchFlagRef() {
	        return batchFlagRef;
	    }
	    
	    public void setBatchFlagRef(SysParameter batchFlagRef) {
	        this.batchFlagRef = batchFlagRef;	
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
		public SysUser getAuditUserIdRef() {
	        return auditUserIdRef;
	    }
	    
	    public void setAuditUserIdRef(SysUser auditUserIdRef) {
	        this.auditUserIdRef = auditUserIdRef;	
	    }

}