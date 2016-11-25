package com.sales.model.business;

import java.util.Date;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sales.model.basic.BasicModel;
import com.sales.model.business.DrpMaterial;



//t_drp_mat_intergral_exchange
//商品积分兑换规则（积分兑换商品是在商城里面兑换的，此表在收银系统中备用）
public class DrpMatIntergralExchange extends BasicModel{

		//主键
		private Long id;
		
		//关联产品编号
		@NotNull(message="关联产品编号不能为空！") 
		private Long materialId;
		
		//可使用积分数
		@NotNull(message="可使用积分数不能为空！") 
		private Long exchangeIntegral;
		

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
	    
		public Long getExchangeIntegral() {
	        return exchangeIntegral;
	    }
	    
	    public void setExchangeIntegral(Long exchangeIntegral) {
	        this.exchangeIntegral = exchangeIntegral;	
	    }
	    
		public DrpMaterial getMaterialIdRef() {
	        return materialIdRef;
	    }
	    
	    public void setMaterialIdRef(DrpMaterial materialIdRef) {
	        this.materialIdRef = materialIdRef;	
	    }

}