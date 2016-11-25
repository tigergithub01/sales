package com.sales.model.business;

import java.util.Date;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sales.model.basic.BasicModel;
import com.sales.model.business.VipCoupon;



//t_vip_coupon_log
//现金券使用记录
public class VipCouponLog extends BasicModel{

		//主键
		private Long id;
		
		//关联现金券编号
		@NotNull(message="关联现金券编号不能为空！") 
		private Long couponId;
		
		//使用金额，退还金额
		@NotNull(message="使用金额，退还金额不能为空！") 
		private Double usedAmount;
		
		//发生时间
		@DateTimeFormat(pattern = "yyyy-MM-dd")
		@JsonFormat(pattern = "yyyy-MM-dd")
		@NotNull(message="发生时间不能为空！") 
		private Date useTime;
		
		//发生描述
		@NotBlank(message="发生描述不能为空！") 
		@Length(max=255)
		private String useDesc;
		

		private VipCoupon couponIdRef;




		public Long getId() {
	        return id;
	    }
	    
	    public void setId(Long id) {
	        this.id = id;	
	    }
	    
		public Long getCouponId() {
	        return couponId;
	    }
	    
	    public void setCouponId(Long couponId) {
	        this.couponId = couponId;	
	    }
	    
		public Double getUsedAmount() {
	        return usedAmount;
	    }
	    
	    public void setUsedAmount(Double usedAmount) {
	        this.usedAmount = usedAmount;	
	    }
	    
		public Date getUseTime() {
	        return useTime;
	    }
	    
	    public void setUseTime(Date useTime) {
	        this.useTime = useTime;	
	    }
	    
		public String getUseDesc() {
	        return useDesc;
	    }
	    
	    public void setUseDesc(String useDesc) {
	        this.useDesc = useDesc == null ? null : useDesc.trim();
	    }
	    
		public VipCoupon getCouponIdRef() {
	        return couponIdRef;
	    }
	    
	    public void setCouponIdRef(VipCoupon couponIdRef) {
	        this.couponIdRef = couponIdRef;	
	    }

}