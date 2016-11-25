package com.sales.model.business;

import java.util.Date;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sales.model.basic.BasicModel;
import com.sales.model.business.OaWkfInstance;



//t_oa_wkf_log
//审批日志
public class OaWkfLog extends BasicModel{

		//主键
		private Long id;
		
		//流程实例编号
		private Long wkfInsId;
		
		//用户编号
		private Long userId;
		
		//操作日期
		@DateTimeFormat(pattern = "yyyy-MM-dd")
		@JsonFormat(pattern = "yyyy-MM-dd")
		private Date operateDate;
		
		//操作类型（同意，不同意）
		@NotNull(message="操作类型（同意，不同意）不能为空！") 
		private Long operateType;
		
		//操作意见
		@Length(max=200)
		private String description;
		

		private OaWkfInstance wkfInsIdRef;





		public Long getId() {
	        return id;
	    }
	    
	    public void setId(Long id) {
	        this.id = id;	
	    }
	    
		public Long getWkfInsId() {
	        return wkfInsId;
	    }
	    
	    public void setWkfInsId(Long wkfInsId) {
	        this.wkfInsId = wkfInsId;	
	    }
	    
		public Long getUserId() {
	        return userId;
	    }
	    
	    public void setUserId(Long userId) {
	        this.userId = userId;	
	    }
	    
		public Date getOperateDate() {
	        return operateDate;
	    }
	    
	    public void setOperateDate(Date operateDate) {
	        this.operateDate = operateDate;	
	    }
	    
		public Long getOperateType() {
	        return operateType;
	    }
	    
	    public void setOperateType(Long operateType) {
	        this.operateType = operateType;	
	    }
	    
		public String getDescription() {
	        return description;
	    }
	    
	    public void setDescription(String description) {
	        this.description = description == null ? null : description.trim();
	    }
	    
		public OaWkfInstance getWkfInsIdRef() {
	        return wkfInsIdRef;
	    }
	    
	    public void setWkfInsIdRef(OaWkfInstance wkfInsIdRef) {
	        this.wkfInsIdRef = wkfInsIdRef;	
	    }

}