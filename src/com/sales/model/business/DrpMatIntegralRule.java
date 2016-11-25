package com.sales.model.business;

import java.util.Date;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sales.model.basic.BasicModel;
import com.sales.model.business.DrpMatType;
import com.sales.model.business.Organization;



//t_drp_mat_integral_rule
//商品积分规则
public class DrpMatIntegralRule extends BasicModel{

		//主键
		private Long id;
		
		//关联商品类别编号
		@NotNull(message="关联商品类别编号不能为空！") 
		private Long matTypeId;
		
		//关联门店编号
		@NotNull(message="关联门店编号不能为空！") 
		private Long organizationId;
		
		//消费多少元赠送消费积分数1分
		@NotNull(message="消费多少元赠送消费积分数1分不能为空！") 
		private Long giveIntegralRate;
		

		private DrpMatType matTypeIdRef;

		private Organization organizationIdRef;


		public Long getId() {
	        return id;
	    }
	    
	    public void setId(Long id) {
	        this.id = id;	
	    }
	    
		public Long getMatTypeId() {
	        return matTypeId;
	    }
	    
	    public void setMatTypeId(Long matTypeId) {
	        this.matTypeId = matTypeId;	
	    }
	    
		public Long getOrganizationId() {
	        return organizationId;
	    }
	    
	    public void setOrganizationId(Long organizationId) {
	        this.organizationId = organizationId;	
	    }
	    
		public Long getGiveIntegralRate() {
	        return giveIntegralRate;
	    }
	    
	    public void setGiveIntegralRate(Long giveIntegralRate) {
	        this.giveIntegralRate = giveIntegralRate;	
	    }
	    
		public DrpMatType getMatTypeIdRef() {
	        return matTypeIdRef;
	    }
	    
	    public void setMatTypeIdRef(DrpMatType matTypeIdRef) {
	        this.matTypeIdRef = matTypeIdRef;	
	    }
		public Organization getOrganizationIdRef() {
	        return organizationIdRef;
	    }
	    
	    public void setOrganizationIdRef(Organization organizationIdRef) {
	        this.organizationIdRef = organizationIdRef;	
	    }

}