package com.sales.model.business;

import java.util.Date;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sales.model.basic.BasicModel;
import com.sales.model.business.SysParameter;



//t_sys_currency
//币种
public class SysCurrency extends BasicModel{

		//主键
		private Long id;
		
		//编码
		@NotBlank(message="编码不能为空！") 
		@Length(max=10)
		private String code;
		
		//名称
		@NotBlank(message="名称不能为空！") 
		@Length(max=50)
		private String name;
		
		//是否本位币？1，是；0，否
		private Long isStandardMoney;
		
		//汇率
		@NotNull(message="汇率不能为空！") 
		private Double rate;
		
		//是否有效？1，是；0，否
		@NotNull(message="是否有效？1，是；0，否不能为空！") 
		private Long status;
		
		//描述
		@Length(max=200)
		private String description;
		



		private SysParameter isStandardMoneyRef;


		private SysParameter statusRef;


		public Long getId() {
	        return id;
	    }
	    
	    public void setId(Long id) {
	        this.id = id;	
	    }
	    
		public String getCode() {
	        return code;
	    }
	    
	    public void setCode(String code) {
	        this.code = code == null ? null : code.trim();
	    }
	    
		public String getName() {
	        return name;
	    }
	    
	    public void setName(String name) {
	        this.name = name == null ? null : name.trim();
	    }
	    
		public Long getIsStandardMoney() {
	        return isStandardMoney;
	    }
	    
	    public void setIsStandardMoney(Long isStandardMoney) {
	        this.isStandardMoney = isStandardMoney;	
	    }
	    
		public Double getRate() {
	        return rate;
	    }
	    
	    public void setRate(Double rate) {
	        this.rate = rate;	
	    }
	    
		public Long getStatus() {
	        return status;
	    }
	    
	    public void setStatus(Long status) {
	        this.status = status;	
	    }
	    
		public String getDescription() {
	        return description;
	    }
	    
	    public void setDescription(String description) {
	        this.description = description == null ? null : description.trim();
	    }
	    
		public SysParameter getIsStandardMoneyRef() {
	        return isStandardMoneyRef;
	    }
	    
	    public void setIsStandardMoneyRef(SysParameter isStandardMoneyRef) {
	        this.isStandardMoneyRef = isStandardMoneyRef;	
	    }
		public SysParameter getStatusRef() {
	        return statusRef;
	    }
	    
	    public void setStatusRef(SysParameter statusRef) {
	        this.statusRef = statusRef;	
	    }

}