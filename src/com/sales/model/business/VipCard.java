package com.sales.model.business;

import java.util.Date;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sales.model.basic.BasicModel;
import com.sales.model.business.SysParameter;
import com.sales.model.business.Vip;



//t_vip_card
//会员卡（待确定，需要确定会员卡使用情况）
public class VipCard extends BasicModel{

		//主键
		private Long id;
		
		//关联会员编号
		@NotNull(message="关联会员编号不能为空！") 
		private Long vipId;
		
		//会员卡号(卡面编号）
		@NotBlank(message="会员卡号(卡面编号）不能为空！") 
		@Length(max=20)
		private String vipNo;
		
		//物理卡号 
		@NotBlank(message="物理卡号 不能为空！") 
		@Length(max=50)
		private String vipPhysicalNo;
		
		//有效开始日期
		@DateTimeFormat(pattern = "yyyy-MM-dd")
		@JsonFormat(pattern = "yyyy-MM-dd")
		private Date effectiveStartDate;
		
		//有效截至日期
		@DateTimeFormat(pattern = "yyyy-MM-dd")
		@JsonFormat(pattern = "yyyy-MM-dd")
		private Date effectiveEndDate;
		
		//描述
		@Length(max=200)
		private String description;
		
		//发卡日期
		@DateTimeFormat(pattern = "yyyy-MM-dd")
		@JsonFormat(pattern = "yyyy-MM-dd")
		private Date issueDate;
		
		//状态：正常，挂失，作废
		@NotNull(message="状态：正常，挂失，作废不能为空！") 
		private Long status;
		

		private Vip vipIdRef;







		private SysParameter statusRef;

		public Long getId() {
	        return id;
	    }
	    
	    public void setId(Long id) {
	        this.id = id;	
	    }
	    
		public Long getVipId() {
	        return vipId;
	    }
	    
	    public void setVipId(Long vipId) {
	        this.vipId = vipId;	
	    }
	    
		public String getVipNo() {
	        return vipNo;
	    }
	    
	    public void setVipNo(String vipNo) {
	        this.vipNo = vipNo == null ? null : vipNo.trim();
	    }
	    
		public String getVipPhysicalNo() {
	        return vipPhysicalNo;
	    }
	    
	    public void setVipPhysicalNo(String vipPhysicalNo) {
	        this.vipPhysicalNo = vipPhysicalNo == null ? null : vipPhysicalNo.trim();
	    }
	    
		public Date getEffectiveStartDate() {
	        return effectiveStartDate;
	    }
	    
	    public void setEffectiveStartDate(Date effectiveStartDate) {
	        this.effectiveStartDate = effectiveStartDate;	
	    }
	    
		public Date getEffectiveEndDate() {
	        return effectiveEndDate;
	    }
	    
	    public void setEffectiveEndDate(Date effectiveEndDate) {
	        this.effectiveEndDate = effectiveEndDate;	
	    }
	    
		public String getDescription() {
	        return description;
	    }
	    
	    public void setDescription(String description) {
	        this.description = description == null ? null : description.trim();
	    }
	    
		public Date getIssueDate() {
	        return issueDate;
	    }
	    
	    public void setIssueDate(Date issueDate) {
	        this.issueDate = issueDate;	
	    }
	    
		public Long getStatus() {
	        return status;
	    }
	    
	    public void setStatus(Long status) {
	        this.status = status;	
	    }
	    
		public Vip getVipIdRef() {
	        return vipIdRef;
	    }
	    
	    public void setVipIdRef(Vip vipIdRef) {
	        this.vipIdRef = vipIdRef;	
	    }
		public SysParameter getStatusRef() {
	        return statusRef;
	    }
	    
	    public void setStatusRef(SysParameter statusRef) {
	        this.statusRef = statusRef;	
	    }

}