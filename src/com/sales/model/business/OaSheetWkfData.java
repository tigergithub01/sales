package com.sales.model.business;

import java.util.Date;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sales.model.basic.BasicModel;
import com.sales.model.business.OaWkfInstance;



//t_oa_sheet_wkf_data
//流程信息
public class OaSheetWkfData extends BasicModel{

		//主键
		private Long id;
		
		//流程实例编号
		@NotNull(message="流程实例编号不能为空！") 
		private Long wkfInstanceId;
		
		//申请唯一编号（暂时不显示在页面）
		@NotBlank(message="申请唯一编号（暂时不显示在页面）不能为空！") 
		@Length(max=30)
		private String wkfCode;
		
		//申请人
		@NotNull(message="申请人不能为空！") 
		private Long applyUserId;
		
		//申请时间
		@DateTimeFormat(pattern = "yyyy-MM-dd")
		@JsonFormat(pattern = "yyyy-MM-dd")
		@NotNull(message="申请时间不能为空！") 
		private Date applyDate;
		
		//申请机构
		@NotNull(message="申请机构不能为空！") 
		private Long organizationId;
		

		private OaWkfInstance wkfInstanceIdRef;





		public Long getId() {
	        return id;
	    }
	    
	    public void setId(Long id) {
	        this.id = id;	
	    }
	    
		public Long getWkfInstanceId() {
	        return wkfInstanceId;
	    }
	    
	    public void setWkfInstanceId(Long wkfInstanceId) {
	        this.wkfInstanceId = wkfInstanceId;	
	    }
	    
		public String getWkfCode() {
	        return wkfCode;
	    }
	    
	    public void setWkfCode(String wkfCode) {
	        this.wkfCode = wkfCode == null ? null : wkfCode.trim();
	    }
	    
		public Long getApplyUserId() {
	        return applyUserId;
	    }
	    
	    public void setApplyUserId(Long applyUserId) {
	        this.applyUserId = applyUserId;	
	    }
	    
		public Date getApplyDate() {
	        return applyDate;
	    }
	    
	    public void setApplyDate(Date applyDate) {
	        this.applyDate = applyDate;	
	    }
	    
		public Long getOrganizationId() {
	        return organizationId;
	    }
	    
	    public void setOrganizationId(Long organizationId) {
	        this.organizationId = organizationId;	
	    }
	    
		public OaWkfInstance getWkfInstanceIdRef() {
	        return wkfInstanceIdRef;
	    }
	    
	    public void setWkfInstanceIdRef(OaWkfInstance wkfInstanceIdRef) {
	        this.wkfInstanceIdRef = wkfInstanceIdRef;	
	    }

}