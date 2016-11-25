package com.sales.model.business;

import java.util.Date;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sales.model.basic.BasicModel;
import com.sales.model.business.Organization;
import com.sales.model.business.Activity;



//t_act_organization
//参与促销活动门店
public class ActOrganization extends BasicModel{

		//主键
		private Long id;
		
		//关联活动编号
		@NotNull(message="关联活动编号不能为空！") 
		private Long actId;
		
		//关联门店编号
		@NotNull(message="关联门店编号不能为空！") 
		private Long organizationId;
		

		private Activity actIdRef;

		private Organization organizationIdRef;

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
	    
		public Long getOrganizationId() {
	        return organizationId;
	    }
	    
	    public void setOrganizationId(Long organizationId) {
	        this.organizationId = organizationId;	
	    }
	    
		public Activity getActIdRef() {
	        return actIdRef;
	    }
	    
	    public void setActIdRef(Activity actIdRef) {
	        this.actIdRef = actIdRef;	
	    }
		public Organization getOrganizationIdRef() {
	        return organizationIdRef;
	    }
	    
	    public void setOrganizationIdRef(Organization organizationIdRef) {
	        this.organizationIdRef = organizationIdRef;	
	    }

}