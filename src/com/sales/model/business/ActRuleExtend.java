package com.sales.model.business;

import java.util.Date;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sales.model.basic.BasicModel;
import com.sales.model.business.DrpMaterial;
import com.sales.model.business.ActRule;



//t_act_rule_extend
//赠送商品（满就送-赠品，积满就送-赠品，送现金券-可使用商品，再买就抵消-再次购买商品）
public class ActRuleExtend extends BasicModel{

		//主键
		private Long id;
		
		//关联促销规则
		@NotNull(message="关联促销规则不能为空！") 
		private Long ruleId;
		
		//数量
		@NotNull(message="数量不能为空！") 
		private Long quantity;
		
		//关联商品编号
		@NotNull(message="关联商品编号不能为空！") 
		private Long materialId;
		

		private ActRule ruleIdRef;


		private DrpMaterial materialIdRef;

		public Long getId() {
	        return id;
	    }
	    
	    public void setId(Long id) {
	        this.id = id;	
	    }
	    
		public Long getRuleId() {
	        return ruleId;
	    }
	    
	    public void setRuleId(Long ruleId) {
	        this.ruleId = ruleId;	
	    }
	    
		public Long getQuantity() {
	        return quantity;
	    }
	    
	    public void setQuantity(Long quantity) {
	        this.quantity = quantity;	
	    }
	    
		public Long getMaterialId() {
	        return materialId;
	    }
	    
	    public void setMaterialId(Long materialId) {
	        this.materialId = materialId;	
	    }
	    
		public ActRule getRuleIdRef() {
	        return ruleIdRef;
	    }
	    
	    public void setRuleIdRef(ActRule ruleIdRef) {
	        this.ruleIdRef = ruleIdRef;	
	    }
		public DrpMaterial getMaterialIdRef() {
	        return materialIdRef;
	    }
	    
	    public void setMaterialIdRef(DrpMaterial materialIdRef) {
	        this.materialIdRef = materialIdRef;	
	    }

}