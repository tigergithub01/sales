package com.sales.model.business;

import java.util.Date;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sales.model.basic.BasicModel;
import com.sales.model.business.VipDeposit;



//t_vip_deposit_log
//会员寄存领取记录
public class VipDepositLog extends BasicModel{

		//主键
		private Long id;
		
		//关联寄存编号
		@NotNull(message="关联寄存编号不能为空！") 
		private Long depositId;
		
		//领取日期
		@DateTimeFormat(pattern = "yyyy-MM-dd")
		@JsonFormat(pattern = "yyyy-MM-dd")
		@NotNull(message="领取日期不能为空！") 
		private Date fetchDate;
		
		//领取数量
		@NotNull(message="领取数量不能为空！") 
		private Long quantity;
		

		private VipDeposit depositIdRef;



		public Long getId() {
	        return id;
	    }
	    
	    public void setId(Long id) {
	        this.id = id;	
	    }
	    
		public Long getDepositId() {
	        return depositId;
	    }
	    
	    public void setDepositId(Long depositId) {
	        this.depositId = depositId;	
	    }
	    
		public Date getFetchDate() {
	        return fetchDate;
	    }
	    
	    public void setFetchDate(Date fetchDate) {
	        this.fetchDate = fetchDate;	
	    }
	    
		public Long getQuantity() {
	        return quantity;
	    }
	    
	    public void setQuantity(Long quantity) {
	        this.quantity = quantity;	
	    }
	    
		public VipDeposit getDepositIdRef() {
	        return depositIdRef;
	    }
	    
	    public void setDepositIdRef(VipDeposit depositIdRef) {
	        this.depositIdRef = depositIdRef;	
	    }

}