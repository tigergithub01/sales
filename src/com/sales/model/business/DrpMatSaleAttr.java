package com.sales.model.business;

import java.util.Date;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sales.model.basic.BasicModel;
import com.sales.model.business.DrpMaterial;



//t_drp_mat_sale_attr
//商品销售-产品
public class DrpMatSaleAttr extends BasicModel{

		//主键
		private Long id;
		
		//商品编号
		@NotNull(message="商品编号不能为空！") 
		private Long materialId;
		
		//批发价
		@NotNull(message="批发价不能为空！") 
		private Double salePrice;
		
		//零售价
		@NotNull(message="零售价不能为空！") 
		private Double retailPrice;
		
		//会员价
		@NotNull(message="会员价不能为空！") 
		private Double vipPrice;
		
		//库存
		@NotNull(message="库存不能为空！") 
		private Double stockQuantity;
		

		private DrpMaterial materialIdRef;





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
	    
		public Double getSalePrice() {
	        return salePrice;
	    }
	    
	    public void setSalePrice(Double salePrice) {
	        this.salePrice = salePrice;	
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
	    
		public Double getStockQuantity() {
	        return stockQuantity;
	    }
	    
	    public void setStockQuantity(Double stockQuantity) {
	        this.stockQuantity = stockQuantity;	
	    }
	    
		public DrpMaterial getMaterialIdRef() {
	        return materialIdRef;
	    }
	    
	    public void setMaterialIdRef(DrpMaterial materialIdRef) {
	        this.materialIdRef = materialIdRef;	
	    }

}