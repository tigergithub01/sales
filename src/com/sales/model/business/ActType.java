package com.sales.model.business;

import java.util.Date;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sales.model.basic.BasicModel;
import com.sales.model.business.SysParameter;



//t_act_type
//活动类型(门店：打折，特价，满就减，满就折，满就送，积满就送，满额就送，第二件特价，再买就抵消，组合套餐，送现金券，无偿
public class ActType extends BasicModel{

		//主键
		private Long id;
		
		//活动名称
		@NotBlank(message="活动名称不能为空！") 
		@Length(max=30)
		private String name;
		
		//门店促销与总部促销标识位?1:门店促销；0：总部促销
		@NotNull(message="门店促销与总部促销标识位?1:门店促销；0：总部促销不能为空！") 
		private Long actFlag;
		


		private SysParameter actFlagRef;

		public Long getId() {
	        return id;
	    }
	    
	    public void setId(Long id) {
	        this.id = id;	
	    }
	    
		public String getName() {
	        return name;
	    }
	    
	    public void setName(String name) {
	        this.name = name == null ? null : name.trim();
	    }
	    
		public Long getActFlag() {
	        return actFlag;
	    }
	    
	    public void setActFlag(Long actFlag) {
	        this.actFlag = actFlag;	
	    }
	    
		public SysParameter getActFlagRef() {
	        return actFlagRef;
	    }
	    
	    public void setActFlagRef(SysParameter actFlagRef) {
	        this.actFlagRef = actFlagRef;	
	    }

}