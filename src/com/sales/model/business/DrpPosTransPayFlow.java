package com.sales.model.business;

import java.util.Date;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sales.model.basic.BasicModel;
import com.sales.model.business.SysPayType;
import com.sales.model.business.SysCurrency;
import com.sales.model.business.DrpPosTransInfo;
import com.sales.model.business.SysParameter;



//t_drp_pos_trans_pay_flow
//收银流水
public class DrpPosTransPayFlow extends BasicModel{

		//主键
		private Long id;
		
		//关联交易编号
		@NotNull(message="关联交易编号不能为空！") 
		private Long transactionId;
		
		//收银方式：销售、找零、退货
		@NotNull(message="收银方式：销售、找零、退货不能为空！") 
		private Long saleType;
		
		//付款方式
		@NotNull(message="付款方式不能为空！") 
		private Long payType;
		
		//金额
		@NotNull(message="金额不能为空！") 
		private Double amount;
		
		//币种
		@NotNull(message="币种不能为空！") 
		private Long currencyId;
		
		//汇率
		@NotNull(message="汇率不能为空！") 
		private Double rate;
		
		//序号
		@NotNull(message="序号不能为空！") 
		private Long sequenceId;
		

		private DrpPosTransInfo transactionIdRef;

		private SysParameter saleTypeRef;

		private SysPayType payTypeRef;


		private SysCurrency currencyIdRef;



		public Long getId() {
	        return id;
	    }
	    
	    public void setId(Long id) {
	        this.id = id;	
	    }
	    
		public Long getTransactionId() {
	        return transactionId;
	    }
	    
	    public void setTransactionId(Long transactionId) {
	        this.transactionId = transactionId;	
	    }
	    
		public Long getSaleType() {
	        return saleType;
	    }
	    
	    public void setSaleType(Long saleType) {
	        this.saleType = saleType;	
	    }
	    
		public Long getPayType() {
	        return payType;
	    }
	    
	    public void setPayType(Long payType) {
	        this.payType = payType;	
	    }
	    
		public Double getAmount() {
	        return amount;
	    }
	    
	    public void setAmount(Double amount) {
	        this.amount = amount;	
	    }
	    
		public Long getCurrencyId() {
	        return currencyId;
	    }
	    
	    public void setCurrencyId(Long currencyId) {
	        this.currencyId = currencyId;	
	    }
	    
		public Double getRate() {
	        return rate;
	    }
	    
	    public void setRate(Double rate) {
	        this.rate = rate;	
	    }
	    
		public Long getSequenceId() {
	        return sequenceId;
	    }
	    
	    public void setSequenceId(Long sequenceId) {
	        this.sequenceId = sequenceId;	
	    }
	    
		public DrpPosTransInfo getTransactionIdRef() {
	        return transactionIdRef;
	    }
	    
	    public void setTransactionIdRef(DrpPosTransInfo transactionIdRef) {
	        this.transactionIdRef = transactionIdRef;	
	    }
		public SysParameter getSaleTypeRef() {
	        return saleTypeRef;
	    }
	    
	    public void setSaleTypeRef(SysParameter saleTypeRef) {
	        this.saleTypeRef = saleTypeRef;	
	    }
		public SysPayType getPayTypeRef() {
	        return payTypeRef;
	    }
	    
	    public void setPayTypeRef(SysPayType payTypeRef) {
	        this.payTypeRef = payTypeRef;	
	    }
		public SysCurrency getCurrencyIdRef() {
	        return currencyIdRef;
	    }
	    
	    public void setCurrencyIdRef(SysCurrency currencyIdRef) {
	        this.currencyIdRef = currencyIdRef;	
	    }

}