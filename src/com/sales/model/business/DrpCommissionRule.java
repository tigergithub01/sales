package com.sales.model.business;

import java.util.Date;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sales.model.basic.BasicModel;
import com.sales.model.business.DrpMatType;
import com.sales.model.business.DrpMaterial;
import com.sales.model.business.DrpBrand;



//t_drp_commission_rule
//营业员提成规则
public class DrpCommissionRule extends BasicModel{

		//编号
		private Long id;
		
		//关联品牌编号
		private Long brandId;
		
		//关联商品类别
		private Long matTypeId;
		
		//关联商品编号
		private Long materialId;
		
		//达到金额
		@NotNull(message="达到金额不能为空！") 
		private Double achieveAmt;
		
		//提成百分比
		@NotNull(message="提成百分比不能为空！") 
		private Double commissionPercent;
		
		//提成金额（加）
		@NotNull(message="提成金额（加）不能为空！") 
		private Double commissionAmt;
		

		private DrpBrand brandIdRef;

		private DrpMatType matTypeIdRef;

		private DrpMaterial materialIdRef;




		public Long getId() {
	        return id;
	    }
	    
	    public void setId(Long id) {
	        this.id = id;	
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
	    
		public Long getMaterialId() {
	        return materialId;
	    }
	    
	    public void setMaterialId(Long materialId) {
	        this.materialId = materialId;	
	    }
	    
		public Double getAchieveAmt() {
	        return achieveAmt;
	    }
	    
	    public void setAchieveAmt(Double achieveAmt) {
	        this.achieveAmt = achieveAmt;	
	    }
	    
		public Double getCommissionPercent() {
	        return commissionPercent;
	    }
	    
	    public void setCommissionPercent(Double commissionPercent) {
	        this.commissionPercent = commissionPercent;	
	    }
	    
		public Double getCommissionAmt() {
	        return commissionAmt;
	    }
	    
	    public void setCommissionAmt(Double commissionAmt) {
	        this.commissionAmt = commissionAmt;	
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
		public DrpMaterial getMaterialIdRef() {
	        return materialIdRef;
	    }
	    
	    public void setMaterialIdRef(DrpMaterial materialIdRef) {
	        this.materialIdRef = materialIdRef;	
	    }

}