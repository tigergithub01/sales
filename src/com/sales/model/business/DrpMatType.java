package com.sales.model.business;

import java.util.Date;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sales.model.basic.BasicModel;
import com.sales.model.business.SysParameter;



//t_drp_mat_type
//商品分类
public class DrpMatType extends BasicModel{

		//主键
		private Long id;
		
		//类型编码
		@NotBlank(message="类型编码不能为空！") 
		@Length(max=30)
		private String code;
		
		//分类名称
		@NotBlank(message="分类名称不能为空！") 
		@Length(max=30)
		private String name;
		
		//父类编号
		private Long parentId;
		
		//是否有效?1:有效:0,无效
		@NotNull(message="是否有效?1:有效:0,无效不能为空！") 
		private Long status;
		
		//消费多少元赠送消费积分数1分（待定）
		@NotNull(message="消费多少元赠送消费积分数1分（待定）不能为空！") 
		private Long giveIntegralRate;
		
		//赠送等级积分数（待定）
		@NotNull(message="赠送等级积分数（待定）不能为空！") 
		private Long rankIntegral;
		
		//赠送消费积分数（待定）
		@NotNull(message="赠送消费积分数（待定）不能为空！") 
		private Long resumeIntegral;
		
		//可使用积分购买金额（待定）
		@NotNull(message="可使用积分购买金额（待定）不能为空！") 
		private Double integralAmount;
		



		private DrpMatType parentIdRef;

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
	    
		public Long getParentId() {
	        return parentId;
	    }
	    
	    public void setParentId(Long parentId) {
	        this.parentId = parentId;	
	    }
	    
		public Long getStatus() {
	        return status;
	    }
	    
	    public void setStatus(Long status) {
	        this.status = status;	
	    }
	    
		public Long getGiveIntegralRate() {
	        return giveIntegralRate;
	    }
	    
	    public void setGiveIntegralRate(Long giveIntegralRate) {
	        this.giveIntegralRate = giveIntegralRate;	
	    }
	    
		public Long getRankIntegral() {
	        return rankIntegral;
	    }
	    
	    public void setRankIntegral(Long rankIntegral) {
	        this.rankIntegral = rankIntegral;	
	    }
	    
		public Long getResumeIntegral() {
	        return resumeIntegral;
	    }
	    
	    public void setResumeIntegral(Long resumeIntegral) {
	        this.resumeIntegral = resumeIntegral;	
	    }
	    
		public Double getIntegralAmount() {
	        return integralAmount;
	    }
	    
	    public void setIntegralAmount(Double integralAmount) {
	        this.integralAmount = integralAmount;	
	    }
	    
		public DrpMatType getParentIdRef() {
	        return parentIdRef;
	    }
	    
	    public void setParentIdRef(DrpMatType parentIdRef) {
	        this.parentIdRef = parentIdRef;	
	    }
		public SysParameter getStatusRef() {
	        return statusRef;
	    }
	    
	    public void setStatusRef(SysParameter statusRef) {
	        this.statusRef = statusRef;	
	    }

}