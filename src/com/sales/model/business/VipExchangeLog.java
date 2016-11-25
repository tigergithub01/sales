package com.sales.model.business;

import java.util.Date;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sales.model.basic.BasicModel;
import com.sales.model.business.Vip;
import com.sales.model.business.DrpMaterial;
import com.sales.model.business.Organization;



//t_vip_exchange_log
//会员积分兑换日志（积分兑换是在商城中兑换，此表待用）
public class VipExchangeLog extends BasicModel{

		//主键
		private Long id;
		
		//兑换会员
		@NotNull(message="兑换会员不能为空！") 
		private Long vipId;
		
		//门店编号
		@NotNull(message="门店编号不能为空！") 
		private Long orgranizationId;
		
		//兑换商品
		@NotNull(message="兑换商品不能为空！") 
		private Long materialId;
		
		//兑换日期
		@DateTimeFormat(pattern = "yyyy-MM-dd")
		@JsonFormat(pattern = "yyyy-MM-dd")
		@NotNull(message="兑换日期不能为空！") 
		private Date exchangeDate;
		
		//消耗积分
		@NotNull(message="消耗积分不能为空！") 
		private Long usedIntegral;
		

		private Vip vipIdRef;

		private Organization orgranizationIdRef;

		private DrpMaterial materialIdRef;



		public Long getId() {
	        return id;
	    }
	    
	    public void setId(Long id) {
	        this.id = id;	
	    }
	    
		public Long getVipId() {
	        return vipId;
	    }
	    
	    public void setVipId(Long vipId) {
	        this.vipId = vipId;	
	    }
	    
		public Long getOrgranizationId() {
	        return orgranizationId;
	    }
	    
	    public void setOrgranizationId(Long orgranizationId) {
	        this.orgranizationId = orgranizationId;	
	    }
	    
		public Long getMaterialId() {
	        return materialId;
	    }
	    
	    public void setMaterialId(Long materialId) {
	        this.materialId = materialId;	
	    }
	    
		public Date getExchangeDate() {
	        return exchangeDate;
	    }
	    
	    public void setExchangeDate(Date exchangeDate) {
	        this.exchangeDate = exchangeDate;	
	    }
	    
		public Long getUsedIntegral() {
	        return usedIntegral;
	    }
	    
	    public void setUsedIntegral(Long usedIntegral) {
	        this.usedIntegral = usedIntegral;	
	    }
	    
		public Vip getVipIdRef() {
	        return vipIdRef;
	    }
	    
	    public void setVipIdRef(Vip vipIdRef) {
	        this.vipIdRef = vipIdRef;	
	    }
		public Organization getOrgranizationIdRef() {
	        return orgranizationIdRef;
	    }
	    
	    public void setOrgranizationIdRef(Organization orgranizationIdRef) {
	        this.orgranizationIdRef = orgranizationIdRef;	
	    }
		public DrpMaterial getMaterialIdRef() {
	        return materialIdRef;
	    }
	    
	    public void setMaterialIdRef(DrpMaterial materialIdRef) {
	        this.materialIdRef = materialIdRef;	
	    }

}