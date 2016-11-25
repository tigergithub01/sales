package com.sales.model.business;

import java.util.Date;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sales.model.basic.BasicModel;
import com.sales.model.business.DrpSheet;
import com.sales.model.business.Activity;
import com.sales.model.business.SysUnit;
import com.sales.model.business.SysParameter;
import com.sales.model.business.DrpMaterial;
import com.sales.model.business.DrpMatBatch;



//t_drp_sheet_detail
//单据明细(如果存在多属性，如颜色，尺码等信息时，如何进行入库，出库操作）
public class DrpSheetDetail extends BasicModel{

		//主键
		private Long id;
		
		//关联单据编号
		@NotNull(message="关联单据编号不能为空！") 
		private Long sheetId;
		
		//商品编号
		@NotNull(message="商品编号不能为空！") 
		private Long materialId;
		
		//数量
		private Double quantity;
		
		//单价
		private Double price;
		
		//金额
		private Double amount;
		
		//计量单位
		@NotNull(message="计量单位不能为空！") 
		private Long unitId;
		
		//如入库单关联采购单号；入库退货单关联入库单
		private Long refSheetId;
		
		//调价单[调后单价]，调拨单[调入单价]
		private Double newPrice;
		
		//序列号
		@NotNull(message="序列号不能为空！") 
		private Long sequenceId;
		
		//备注
		@Length(max=200)
		private String description;
		
		//采购（销售）订单订购数量，在采购（销售）单中使用，盘点差异单单中的库存数量
		private Double orderQuantity;
		
		//盘盈单"盘盈数量"，盘亏单"盘亏数量"
		private Double diffQuantity;
		
		//调价单“调价金额”，盘盈单"盘盈金额"，盘亏单"盘亏金额"
		private Double diffAmount;
		
		//有效期（天）
		private Long guaranteeDays;
		
		//有效开始日期
		@DateTimeFormat(pattern = "yyyy-MM-dd")
		@JsonFormat(pattern = "yyyy-MM-dd")
		private Date effectiveStartDate;
		
		//有效截止日期
		@DateTimeFormat(pattern = "yyyy-MM-dd")
		@JsonFormat(pattern = "yyyy-MM-dd")
		private Date effectiveEndDate;
		
		//批号
		@Length(max=20)
		private String batchNo;
		
		//批号
		private Long batchId;
		
		//批发价
		private Double salePrice;
		
		//新批发价
		private Double newSalePrice;
		
		//零售价
		private Double retailPrice;
		
		//新零售价
		private Double newRetailPrice;
		
		//会员价
		private Double vipPrice;
		
		//新会员价
		private Double newVipPrice;
		
		//会员价2
		private Double vipPrice2;
		
		//新会员价2
		private Double newVipPrice2;
		
		//会员价3
		private Double vipPrice3;
		
		//新会员价3
		private Double newVipPrice3;
		
		//会员价4
		private Double vipPrice4;
		
		//新会员价4
		private Double newVipPrice4;
		
		//会员价5
		private Double vipPrice5;
		
		//新会员价5
		private Double newVipPrice5;
		
		//关联促销活动编号（要货申请单可以关联总部促销活动编号，总部向门店发货时，可以根据要货单关联的促销活动自动计算出给门店的配送价）
		private Long actId;
		
		//授权天数（单位：天）（调价授权申请时用到）
		private Long authDay;
		
		//是否积分兑换商品（门店发货时用到，积分兑换商品门店不需要入库，直接存放再商城中）
		private Long isExchange;
		


		private DrpMaterial materialIdRef;




		private SysUnit unitIdRef;

		private DrpSheet refSheetIdRef;











		private DrpMatBatch batchIdRef;















		private Activity actIdRef;


		private SysParameter isExchangeRef;

		public Long getId() {
	        return id;
	    }
	    
	    public void setId(Long id) {
	        this.id = id;	
	    }
	    
		public Long getSheetId() {
	        return sheetId;
	    }
	    
	    public void setSheetId(Long sheetId) {
	        this.sheetId = sheetId;	
	    }
	    
		public Long getMaterialId() {
	        return materialId;
	    }
	    
	    public void setMaterialId(Long materialId) {
	        this.materialId = materialId;	
	    }
	    
		public Double getQuantity() {
	        return quantity;
	    }
	    
	    public void setQuantity(Double quantity) {
	        this.quantity = quantity;	
	    }
	    
		public Double getPrice() {
	        return price;
	    }
	    
	    public void setPrice(Double price) {
	        this.price = price;	
	    }
	    
		public Double getAmount() {
	        return amount;
	    }
	    
	    public void setAmount(Double amount) {
	        this.amount = amount;	
	    }
	    
		public Long getUnitId() {
	        return unitId;
	    }
	    
	    public void setUnitId(Long unitId) {
	        this.unitId = unitId;	
	    }
	    
		public Long getRefSheetId() {
	        return refSheetId;
	    }
	    
	    public void setRefSheetId(Long refSheetId) {
	        this.refSheetId = refSheetId;	
	    }
	    
		public Double getNewPrice() {
	        return newPrice;
	    }
	    
	    public void setNewPrice(Double newPrice) {
	        this.newPrice = newPrice;	
	    }
	    
		public Long getSequenceId() {
	        return sequenceId;
	    }
	    
	    public void setSequenceId(Long sequenceId) {
	        this.sequenceId = sequenceId;	
	    }
	    
		public String getDescription() {
	        return description;
	    }
	    
	    public void setDescription(String description) {
	        this.description = description == null ? null : description.trim();
	    }
	    
		public Double getOrderQuantity() {
	        return orderQuantity;
	    }
	    
	    public void setOrderQuantity(Double orderQuantity) {
	        this.orderQuantity = orderQuantity;	
	    }
	    
		public Double getDiffQuantity() {
	        return diffQuantity;
	    }
	    
	    public void setDiffQuantity(Double diffQuantity) {
	        this.diffQuantity = diffQuantity;	
	    }
	    
		public Double getDiffAmount() {
	        return diffAmount;
	    }
	    
	    public void setDiffAmount(Double diffAmount) {
	        this.diffAmount = diffAmount;	
	    }
	    
		public Long getGuaranteeDays() {
	        return guaranteeDays;
	    }
	    
	    public void setGuaranteeDays(Long guaranteeDays) {
	        this.guaranteeDays = guaranteeDays;	
	    }
	    
		public Date getEffectiveStartDate() {
	        return effectiveStartDate;
	    }
	    
	    public void setEffectiveStartDate(Date effectiveStartDate) {
	        this.effectiveStartDate = effectiveStartDate;	
	    }
	    
		public Date getEffectiveEndDate() {
	        return effectiveEndDate;
	    }
	    
	    public void setEffectiveEndDate(Date effectiveEndDate) {
	        this.effectiveEndDate = effectiveEndDate;	
	    }
	    
		public String getBatchNo() {
	        return batchNo;
	    }
	    
	    public void setBatchNo(String batchNo) {
	        this.batchNo = batchNo == null ? null : batchNo.trim();
	    }
	    
		public Long getBatchId() {
	        return batchId;
	    }
	    
	    public void setBatchId(Long batchId) {
	        this.batchId = batchId;	
	    }
	    
		public Double getSalePrice() {
	        return salePrice;
	    }
	    
	    public void setSalePrice(Double salePrice) {
	        this.salePrice = salePrice;	
	    }
	    
		public Double getNewSalePrice() {
	        return newSalePrice;
	    }
	    
	    public void setNewSalePrice(Double newSalePrice) {
	        this.newSalePrice = newSalePrice;	
	    }
	    
		public Double getRetailPrice() {
	        return retailPrice;
	    }
	    
	    public void setRetailPrice(Double retailPrice) {
	        this.retailPrice = retailPrice;	
	    }
	    
		public Double getNewRetailPrice() {
	        return newRetailPrice;
	    }
	    
	    public void setNewRetailPrice(Double newRetailPrice) {
	        this.newRetailPrice = newRetailPrice;	
	    }
	    
		public Double getVipPrice() {
	        return vipPrice;
	    }
	    
	    public void setVipPrice(Double vipPrice) {
	        this.vipPrice = vipPrice;	
	    }
	    
		public Double getNewVipPrice() {
	        return newVipPrice;
	    }
	    
	    public void setNewVipPrice(Double newVipPrice) {
	        this.newVipPrice = newVipPrice;	
	    }
	    
		public Double getVipPrice2() {
	        return vipPrice2;
	    }
	    
	    public void setVipPrice2(Double vipPrice2) {
	        this.vipPrice2 = vipPrice2;	
	    }
	    
		public Double getNewVipPrice2() {
	        return newVipPrice2;
	    }
	    
	    public void setNewVipPrice2(Double newVipPrice2) {
	        this.newVipPrice2 = newVipPrice2;	
	    }
	    
		public Double getVipPrice3() {
	        return vipPrice3;
	    }
	    
	    public void setVipPrice3(Double vipPrice3) {
	        this.vipPrice3 = vipPrice3;	
	    }
	    
		public Double getNewVipPrice3() {
	        return newVipPrice3;
	    }
	    
	    public void setNewVipPrice3(Double newVipPrice3) {
	        this.newVipPrice3 = newVipPrice3;	
	    }
	    
		public Double getVipPrice4() {
	        return vipPrice4;
	    }
	    
	    public void setVipPrice4(Double vipPrice4) {
	        this.vipPrice4 = vipPrice4;	
	    }
	    
		public Double getNewVipPrice4() {
	        return newVipPrice4;
	    }
	    
	    public void setNewVipPrice4(Double newVipPrice4) {
	        this.newVipPrice4 = newVipPrice4;	
	    }
	    
		public Double getVipPrice5() {
	        return vipPrice5;
	    }
	    
	    public void setVipPrice5(Double vipPrice5) {
	        this.vipPrice5 = vipPrice5;	
	    }
	    
		public Double getNewVipPrice5() {
	        return newVipPrice5;
	    }
	    
	    public void setNewVipPrice5(Double newVipPrice5) {
	        this.newVipPrice5 = newVipPrice5;	
	    }
	    
		public Long getActId() {
	        return actId;
	    }
	    
	    public void setActId(Long actId) {
	        this.actId = actId;	
	    }
	    
		public Long getAuthDay() {
	        return authDay;
	    }
	    
	    public void setAuthDay(Long authDay) {
	        this.authDay = authDay;	
	    }
	    
		public Long getIsExchange() {
	        return isExchange;
	    }
	    
	    public void setIsExchange(Long isExchange) {
	        this.isExchange = isExchange;	
	    }
	    
		public DrpMaterial getMaterialIdRef() {
	        return materialIdRef;
	    }
	    
	    public void setMaterialIdRef(DrpMaterial materialIdRef) {
	        this.materialIdRef = materialIdRef;	
	    }
		public SysUnit getUnitIdRef() {
	        return unitIdRef;
	    }
	    
	    public void setUnitIdRef(SysUnit unitIdRef) {
	        this.unitIdRef = unitIdRef;	
	    }
		public DrpSheet getRefSheetIdRef() {
	        return refSheetIdRef;
	    }
	    
	    public void setRefSheetIdRef(DrpSheet refSheetIdRef) {
	        this.refSheetIdRef = refSheetIdRef;	
	    }
		public DrpMatBatch getBatchIdRef() {
	        return batchIdRef;
	    }
	    
	    public void setBatchIdRef(DrpMatBatch batchIdRef) {
	        this.batchIdRef = batchIdRef;	
	    }
		public Activity getActIdRef() {
	        return actIdRef;
	    }
	    
	    public void setActIdRef(Activity actIdRef) {
	        this.actIdRef = actIdRef;	
	    }
		public SysParameter getIsExchangeRef() {
	        return isExchangeRef;
	    }
	    
	    public void setIsExchangeRef(SysParameter isExchangeRef) {
	        this.isExchangeRef = isExchangeRef;	
	    }

}