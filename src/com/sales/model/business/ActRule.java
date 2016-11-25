package com.sales.model.business;

import java.util.Date;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sales.model.basic.BasicModel;
import com.sales.model.business.Activity;
import com.sales.model.business.SysParameter;



//t_act_rule
//促销活动规则
public class ActRule extends BasicModel{

		//主键
		private Long id;
		
		//关联活动编号
		@NotNull(message="关联活动编号不能为空！") 
		private Long actId;
		
		//天数（再买就抵消-天数，无偿赠送-天数，积满就送-天数）
		private Long periodDays;
		
		//购满金额（满减促销-消费金额，满就折-购买金额，满就送-购买金额，满额就送-购买金额，送现金券-购买金额）
		private Double buyAmount;
		
		//购买数量（满减促销-购买数量，满就折-购买数量，满就送-购买数量，积满就送-积满数量，送现金券-购买数量）
		private Long buyQuantity;
		
		//减少金额（满减促销-减少金额，再买就抵消-抵消金额）
		private Double reduceAmt;
		
		//赠送数量（无偿赠送-限送数量）
		private Long givingQuantity;
		
		//赠送金额（送现金券：赠送金额)
		private Double givingAmt;
		
		//折扣率（满就折-折扣，折扣促销-折扣，第二件特价-折扣）
		private Double discount;
		
		//是否按倍数赠送如买二赠一，买四赠二？1:是；0：否（满就减促销-倍增，满就折-倍增，满就送-倍增，满额就送-倍增）
		private Long isDoubleGive;
		
		//最大赠送数量(满就送促销-最大赠送数量）（字段待定）
		private Long maxGiveNumber;
		
		//套装价(组合套餐-套餐价）
		private Double packagePrice;
		
		//限购数量（每个会员最多可购买数量）（折扣促销，特价促销）
		private Long buyLimitNum;
		
		//限量数量（本次促销总共发放数量）（折扣，特价促销）
		private Long buyTotalLimits;
		
		//特价（特价促销-特价，第二件特价-特价）
		private Double specialPrice;
		
		//是否自动累积？1：是；0：否（积满就送-自动累积）
		private Long isAutoAdd;
		

		private Activity actIdRef;








		private SysParameter isDoubleGiveRef;






		private SysParameter isAutoAddRef;

		public Long getId() {
	        return id;
	    }
	    
	    public void setId(Long id) {
	        this.id = id;	
	    }
	    
		public Long getActId() {
	        return actId;
	    }
	    
	    public void setActId(Long actId) {
	        this.actId = actId;	
	    }
	    
		public Long getPeriodDays() {
	        return periodDays;
	    }
	    
	    public void setPeriodDays(Long periodDays) {
	        this.periodDays = periodDays;	
	    }
	    
		public Double getBuyAmount() {
	        return buyAmount;
	    }
	    
	    public void setBuyAmount(Double buyAmount) {
	        this.buyAmount = buyAmount;	
	    }
	    
		public Long getBuyQuantity() {
	        return buyQuantity;
	    }
	    
	    public void setBuyQuantity(Long buyQuantity) {
	        this.buyQuantity = buyQuantity;	
	    }
	    
		public Double getReduceAmt() {
	        return reduceAmt;
	    }
	    
	    public void setReduceAmt(Double reduceAmt) {
	        this.reduceAmt = reduceAmt;	
	    }
	    
		public Long getGivingQuantity() {
	        return givingQuantity;
	    }
	    
	    public void setGivingQuantity(Long givingQuantity) {
	        this.givingQuantity = givingQuantity;	
	    }
	    
		public Double getGivingAmt() {
	        return givingAmt;
	    }
	    
	    public void setGivingAmt(Double givingAmt) {
	        this.givingAmt = givingAmt;	
	    }
	    
		public Double getDiscount() {
	        return discount;
	    }
	    
	    public void setDiscount(Double discount) {
	        this.discount = discount;	
	    }
	    
		public Long getIsDoubleGive() {
	        return isDoubleGive;
	    }
	    
	    public void setIsDoubleGive(Long isDoubleGive) {
	        this.isDoubleGive = isDoubleGive;	
	    }
	    
		public Long getMaxGiveNumber() {
	        return maxGiveNumber;
	    }
	    
	    public void setMaxGiveNumber(Long maxGiveNumber) {
	        this.maxGiveNumber = maxGiveNumber;	
	    }
	    
		public Double getPackagePrice() {
	        return packagePrice;
	    }
	    
	    public void setPackagePrice(Double packagePrice) {
	        this.packagePrice = packagePrice;	
	    }
	    
		public Long getBuyLimitNum() {
	        return buyLimitNum;
	    }
	    
	    public void setBuyLimitNum(Long buyLimitNum) {
	        this.buyLimitNum = buyLimitNum;	
	    }
	    
		public Long getBuyTotalLimits() {
	        return buyTotalLimits;
	    }
	    
	    public void setBuyTotalLimits(Long buyTotalLimits) {
	        this.buyTotalLimits = buyTotalLimits;	
	    }
	    
		public Double getSpecialPrice() {
	        return specialPrice;
	    }
	    
	    public void setSpecialPrice(Double specialPrice) {
	        this.specialPrice = specialPrice;	
	    }
	    
		public Long getIsAutoAdd() {
	        return isAutoAdd;
	    }
	    
	    public void setIsAutoAdd(Long isAutoAdd) {
	        this.isAutoAdd = isAutoAdd;	
	    }
	    
		public Activity getActIdRef() {
	        return actIdRef;
	    }
	    
	    public void setActIdRef(Activity actIdRef) {
	        this.actIdRef = actIdRef;	
	    }
		public SysParameter getIsDoubleGiveRef() {
	        return isDoubleGiveRef;
	    }
	    
	    public void setIsDoubleGiveRef(SysParameter isDoubleGiveRef) {
	        this.isDoubleGiveRef = isDoubleGiveRef;	
	    }
		public SysParameter getIsAutoAddRef() {
	        return isAutoAddRef;
	    }
	    
	    public void setIsAutoAddRef(SysParameter isAutoAddRef) {
	        this.isAutoAddRef = isAutoAddRef;	
	    }

}