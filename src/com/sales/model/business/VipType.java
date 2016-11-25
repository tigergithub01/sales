package com.sales.model.business;

import java.util.Date;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sales.model.basic.BasicModel;



//t_vip_type
//会员分类
public class VipType extends BasicModel{

		//主键
		private Long id;
		
		//会员等级名称
		@NotBlank(message="会员等级名称不能为空！") 
		@Length(max=30)
		private String name;
		
		//最少等级积分
		@NotNull(message="最少等级积分不能为空！") 
		private Long minPoints;
		
		//最大等级积分
		@NotNull(message="最大等级积分不能为空！") 
		private Long maxPoints;
		
		//折扣（此字段待用）
		private Double discount;
		





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
	    
		public Long getMinPoints() {
	        return minPoints;
	    }
	    
	    public void setMinPoints(Long minPoints) {
	        this.minPoints = minPoints;	
	    }
	    
		public Long getMaxPoints() {
	        return maxPoints;
	    }
	    
	    public void setMaxPoints(Long maxPoints) {
	        this.maxPoints = maxPoints;	
	    }
	    
		public Double getDiscount() {
	        return discount;
	    }
	    
	    public void setDiscount(Double discount) {
	        this.discount = discount;	
	    }
	    

}