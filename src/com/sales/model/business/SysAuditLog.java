package com.sales.model.business;

import java.util.Date;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sales.model.basic.BasicModel;
import com.sales.model.business.SysParameter;



//t_sys_audit_log
//审批日志
public class SysAuditLog extends BasicModel{

		//主键
		private Long id;
		
		//关联编号
		@NotNull(message="关联编号不能为空！") 
		private Long refId;
		
		//审批类型：促销信息审核，商品信息审核等
		@NotNull(message="审批类型：促销信息审核，商品信息审核等不能为空！") 
		private Long auditType;
		
		//审核动作：审核通过，审核不通过
		@NotNull(message="审核动作：审核通过，审核不通过不能为空！") 
		private Long auditOperate;
		
		//审核人
		@NotNull(message="审核人不能为空！") 
		private Long auditUserId;
		
		//审核日期
		@DateTimeFormat(pattern = "yyyy-MM-dd")
		@JsonFormat(pattern = "yyyy-MM-dd")
		@NotNull(message="审核日期不能为空！") 
		private Date auditDate;
		
		//审核意见（不通过时必须填写）
		@Length(max=200)
		private String auditMemo;
		


		private SysParameter auditTypeRef;

		private SysParameter auditOperateRef;




		public Long getId() {
	        return id;
	    }
	    
	    public void setId(Long id) {
	        this.id = id;	
	    }
	    
		public Long getRefId() {
	        return refId;
	    }
	    
	    public void setRefId(Long refId) {
	        this.refId = refId;	
	    }
	    
		public Long getAuditType() {
	        return auditType;
	    }
	    
	    public void setAuditType(Long auditType) {
	        this.auditType = auditType;	
	    }
	    
		public Long getAuditOperate() {
	        return auditOperate;
	    }
	    
	    public void setAuditOperate(Long auditOperate) {
	        this.auditOperate = auditOperate;	
	    }
	    
		public Long getAuditUserId() {
	        return auditUserId;
	    }
	    
	    public void setAuditUserId(Long auditUserId) {
	        this.auditUserId = auditUserId;	
	    }
	    
		public Date getAuditDate() {
	        return auditDate;
	    }
	    
	    public void setAuditDate(Date auditDate) {
	        this.auditDate = auditDate;	
	    }
	    
		public String getAuditMemo() {
	        return auditMemo;
	    }
	    
	    public void setAuditMemo(String auditMemo) {
	        this.auditMemo = auditMemo == null ? null : auditMemo.trim();
	    }
	    
		public SysParameter getAuditTypeRef() {
	        return auditTypeRef;
	    }
	    
	    public void setAuditTypeRef(SysParameter auditTypeRef) {
	        this.auditTypeRef = auditTypeRef;	
	    }
		public SysParameter getAuditOperateRef() {
	        return auditOperateRef;
	    }
	    
	    public void setAuditOperateRef(SysParameter auditOperateRef) {
	        this.auditOperateRef = auditOperateRef;	
	    }

}