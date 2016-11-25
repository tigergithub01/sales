package com.sales.model.business;

import java.util.Date;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sales.model.basic.BasicModel;
import com.sales.model.business.VipType;
import com.sales.model.business.DrpMaterial;



//t_drp_mat_vip_price
//商品会员价(是否需要此表待定，现在确定是5级会员，商品各等级的会员价直接放在商品基本档案中，如果需要扩展更多等级的会员价
public class DrpMatVipPrice extends BasicModel{

		//主键
		private Long id;
		
		//产品编号
		@NotNull(message="产品编号不能为空！") 
		private Long materialId;
		
		//会员等级
		@NotNull(message="会员等级不能为空！") 
		private Long vipTypeId;
		
		//价格
		@NotNull(message="价格不能为空！") 
		private Double price;
		

		private DrpMaterial materialIdRef;

		private VipType vipTypeIdRef;


		public Long getId() {
	        return id;
	    }
	    
	    public void setId(Long id) {
	        this.id = id;	
	    }
	    
		public Long getMaterialId() {
	        return materialId;
	    }
	    
	    public void setMaterialId(Long materialId) {
	        this.materialId = materialId;	
	    }
	    
		public Long getVipTypeId() {
	        return vipTypeId;
	    }
	    
	    public void setVipTypeId(Long vipTypeId) {
	        this.vipTypeId = vipTypeId;	
	    }
	    
		public Double getPrice() {
	        return price;
	    }
	    
	    public void setPrice(Double price) {
	        this.price = price;	
	    }
	    
		public DrpMaterial getMaterialIdRef() {
	        return materialIdRef;
	    }
	    
	    public void setMaterialIdRef(DrpMaterial materialIdRef) {
	        this.materialIdRef = materialIdRef;	
	    }
		public VipType getVipTypeIdRef() {
	        return vipTypeIdRef;
	    }
	    
	    public void setVipTypeIdRef(VipType vipTypeIdRef) {
	        this.vipTypeIdRef = vipTypeIdRef;	
	    }

}