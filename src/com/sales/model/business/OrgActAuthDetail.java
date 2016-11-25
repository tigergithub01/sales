package com.sales.model.business;

import java.util.Date;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sales.model.basic.BasicModel;
import com.sales.model.business.ActType;
import com.sales.model.business.OrgActAuth;



//t_org_act_auth_detail
//门店促销授权明细
public class OrgActAuthDetail extends BasicModel{

		//主键
		private Long id;
		
		//关联授权编号
		@NotNull(message="关联授权编号不能为空！") 
		private Long actAuthId;
		
		//关联活动类别
		@NotNull(message="关联活动类别不能为空！") 
		private Long actTypeId;
		

		private OrgActAuth actAuthIdRef;

		private ActType actTypeIdRef;

		public Long getId() {
	        return id;
	    }
	    
	    public void setId(Long id) {
	        this.id = id;	
	    }
	    
		public Long getActAuthId() {
	        return actAuthId;
	    }
	    
	    public void setActAuthId(Long actAuthId) {
	        this.actAuthId = actAuthId;	
	    }
	    
		public Long getActTypeId() {
	        return actTypeId;
	    }
	    
	    public void setActTypeId(Long actTypeId) {
	        this.actTypeId = actTypeId;	
	    }
	    
		public OrgActAuth getActAuthIdRef() {
	        return actAuthIdRef;
	    }
	    
	    public void setActAuthIdRef(OrgActAuth actAuthIdRef) {
	        this.actAuthIdRef = actAuthIdRef;	
	    }
		public ActType getActTypeIdRef() {
	        return actTypeIdRef;
	    }
	    
	    public void setActTypeIdRef(ActType actTypeIdRef) {
	        this.actTypeIdRef = actTypeIdRef;	
	    }

}