package com.sales.model.business;

import java.util.Date;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sales.model.basic.BasicModel;
import com.sales.model.business.VipType;
import com.sales.model.business.DrpMatType;
import com.sales.model.business.Organization;



//t_drp_mat_vip_price_regular
//商品会员价规则
public class DrpMatVipPriceRegular extends BasicModel{

		//主键
		private Long id;
		
		//关联门店编号
		@NotNull(message="关联门店编号不能为空！") 
		private Long organizationId;
		
		//关联商品类别编号
		@NotNull(message="关联商品类别编号不能为空！") 
		private Long matTypeId;
		
		//关联会员类别（待定）
		private Long vipTypeId;
		
		//折扣（待定）
		private Double discount;
		
		//V2会员折扣
		private Double vip2Discount;
		
		//V3会员折扣
		private Double vip3Discount;
		
		//V4会员折扣
		private Double vip4Discount;
		
		//V5会员折扣
		private Double vip5Discount;
		

		private Organization organizationIdRef;

		private DrpMatType matTypeIdRef;

		private VipType vipTypeIdRef;






		public Long getId() {
	        return id;
	    }
	    
	    public void setId(Long id) {
	        this.id = id;	
	    }
	    
		public Long getOrganizationId() {
	        return organizationId;
	    }
	    
	    public void setOrganizationId(Long organizationId) {
	        this.organizationId = organizationId;	
	    }
	    
		public Long getMatTypeId() {
	        return matTypeId;
	    }
	    
	    public void setMatTypeId(Long matTypeId) {
	        this.matTypeId = matTypeId;	
	    }
	    
		public Long getVipTypeId() {
	        return vipTypeId;
	    }
	    
	    public void setVipTypeId(Long vipTypeId) {
	        this.vipTypeId = vipTypeId;	
	    }
	    
		public Double getDiscount() {
	        return discount;
	    }
	    
	    public void setDiscount(Double discount) {
	        this.discount = discount;	
	    }
	    
		public Double getVip2Discount() {
	        return vip2Discount;
	    }
	    
	    public void setVip2Discount(Double vip2Discount) {
	        this.vip2Discount = vip2Discount;	
	    }
	    
		public Double getVip3Discount() {
	        return vip3Discount;
	    }
	    
	    public void setVip3Discount(Double vip3Discount) {
	        this.vip3Discount = vip3Discount;	
	    }
	    
		public Double getVip4Discount() {
	        return vip4Discount;
	    }
	    
	    public void setVip4Discount(Double vip4Discount) {
	        this.vip4Discount = vip4Discount;	
	    }
	    
		public Double getVip5Discount() {
	        return vip5Discount;
	    }
	    
	    public void setVip5Discount(Double vip5Discount) {
	        this.vip5Discount = vip5Discount;	
	    }
	    
		public Organization getOrganizationIdRef() {
	        return organizationIdRef;
	    }
	    
	    public void setOrganizationIdRef(Organization organizationIdRef) {
	        this.organizationIdRef = organizationIdRef;	
	    }
		public DrpMatType getMatTypeIdRef() {
	        return matTypeIdRef;
	    }
	    
	    public void setMatTypeIdRef(DrpMatType matTypeIdRef) {
	        this.matTypeIdRef = matTypeIdRef;	
	    }
		public VipType getVipTypeIdRef() {
	        return vipTypeIdRef;
	    }
	    
	    public void setVipTypeIdRef(VipType vipTypeIdRef) {
	        this.vipTypeIdRef = vipTypeIdRef;	
	    }

}