package com.sales.model.business;

import java.util.Date;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sales.model.basic.BasicModel;
import com.sales.model.business.DrpMatType;
import com.sales.model.business.ActRule;
import com.sales.model.business.DrpBrand;
import com.sales.model.business.Activity;
import com.sales.model.business.DrpMaterial;



//t_act_range
//参与促销产品范围（品牌，分类，产品）
public class ActRange extends BasicModel{

		//主键
		private Long id;
		
		//活动编号
		@NotNull(message="活动编号不能为空！") 
		private Long actId;
		
		//关联产品编号(优惠套装-关联商品编号)
		private Long materialId;
		
		//关联品牌
		private Long brandId;
		
		//关联产品分类
		private Long matTypeId;
		
		//数量
		@NotNull(message="数量不能为空！") 
		private Long quantity;
		
		//关联活动规则
		private Long ruleId;
		

		private Activity actIdRef;

		private DrpMaterial materialIdRef;

		private DrpBrand brandIdRef;

		private DrpMatType matTypeIdRef;


		private ActRule ruleIdRef;

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
	    
		public Long getMaterialId() {
	        return materialId;
	    }
	    
	    public void setMaterialId(Long materialId) {
	        this.materialId = materialId;	
	    }
	    
		public Long getBrandId() {
	        return brandId;
	    }
	    
	    public void setBrandId(Long brandId) {
	        this.brandId = brandId;	
	    }
	    
		public Long getMatTypeId() {
	        return matTypeId;
	    }
	    
	    public void setMatTypeId(Long matTypeId) {
	        this.matTypeId = matTypeId;	
	    }
	    
		public Long getQuantity() {
	        return quantity;
	    }
	    
	    public void setQuantity(Long quantity) {
	        this.quantity = quantity;	
	    }
	    
		public Long getRuleId() {
	        return ruleId;
	    }
	    
	    public void setRuleId(Long ruleId) {
	        this.ruleId = ruleId;	
	    }
	    
		public Activity getActIdRef() {
	        return actIdRef;
	    }
	    
	    public void setActIdRef(Activity actIdRef) {
	        this.actIdRef = actIdRef;	
	    }
		public DrpMaterial getMaterialIdRef() {
	        return materialIdRef;
	    }
	    
	    public void setMaterialIdRef(DrpMaterial materialIdRef) {
	        this.materialIdRef = materialIdRef;	
	    }
		public DrpBrand getBrandIdRef() {
	        return brandIdRef;
	    }
	    
	    public void setBrandIdRef(DrpBrand brandIdRef) {
	        this.brandIdRef = brandIdRef;	
	    }
		public DrpMatType getMatTypeIdRef() {
	        return matTypeIdRef;
	    }
	    
	    public void setMatTypeIdRef(DrpMatType matTypeIdRef) {
	        this.matTypeIdRef = matTypeIdRef;	
	    }
		public ActRule getRuleIdRef() {
	        return ruleIdRef;
	    }
	    
	    public void setRuleIdRef(ActRule ruleIdRef) {
	        this.ruleIdRef = ruleIdRef;	
	    }

}