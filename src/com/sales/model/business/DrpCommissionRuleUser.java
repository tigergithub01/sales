package com.sales.model.business;

import java.util.Date;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sales.model.basic.BasicModel;
import com.sales.model.business.SysUser;
import com.sales.model.business.DrpCommissionRule;



//t_drp_commission_rule_user
//用户提成规则
public class DrpCommissionRuleUser extends BasicModel{

		//主键
		private Long id;
		
		//提成规则编号
		@NotNull(message="提成规则编号不能为空！") 
		private Long ruleId;
		
		//用户编号
		@NotNull(message="用户编号不能为空！") 
		private Long userId;
		

		private DrpCommissionRule ruleIdRef;

		private SysUser userIdRef;

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
	    
		public Long getUserId() {
	        return userId;
	    }
	    
	    public void setUserId(Long userId) {
	        this.userId = userId;	
	    }
	    
		public DrpCommissionRule getRuleIdRef() {
	        return ruleIdRef;
	    }
	    
	    public void setRuleIdRef(DrpCommissionRule ruleIdRef) {
	        this.ruleIdRef = ruleIdRef;	
	    }
		public SysUser getUserIdRef() {
	        return userIdRef;
	    }
	    
	    public void setUserIdRef(SysUser userIdRef) {
	        this.userIdRef = userIdRef;	
	    }

}