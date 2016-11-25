package com.sales.model.business;

import java.util.Date;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sales.model.basic.BasicModel;
import com.sales.model.business.Organization;



//t_org_integral_deduct_rule
//积分抵消规则(门店补货的时候，根据可抵消积分换算成本次补货积分可以抵消的金额）
public class OrgIntegralDeductRule extends BasicModel{

		//主键
		private Long id;
		
		//关联门店编号
		@NotNull(message="关联门店编号不能为空！") 
		private Long organizationId;
		
		//积分数（1元可以抵消的积分数）
		@NotNull(message="积分数（1元可以抵消的积分数）不能为空！") 
		private Long integralRate;
		
		//可抵消积分
		@NotNull(message="可抵消积分不能为空！") 
		private Long integral;
		

		private Organization organizationIdRef;



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
	    
		public Long getIntegralRate() {
	        return integralRate;
	    }
	    
	    public void setIntegralRate(Long integralRate) {
	        this.integralRate = integralRate;	
	    }
	    
		public Long getIntegral() {
	        return integral;
	    }
	    
	    public void setIntegral(Long integral) {
	        this.integral = integral;	
	    }
	    
		public Organization getOrganizationIdRef() {
	        return organizationIdRef;
	    }
	    
	    public void setOrganizationIdRef(Organization organizationIdRef) {
	        this.organizationIdRef = organizationIdRef;	
	    }

}