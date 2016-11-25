package com.sales.model.business;

import java.util.Date;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sales.model.basic.BasicModel;
import com.sales.model.business.OaWkf;



//t_oa_wkf_instance
//流程实例
public class OaWkfInstance extends BasicModel{

		//主键
		private Long id;
		
		//关联流程编号
		@NotNull(message="关联流程编号不能为空！") 
		private Long wkfId;
		
		//开始时间
		@DateTimeFormat(pattern = "yyyy-MM-dd")
		@JsonFormat(pattern = "yyyy-MM-dd")
		private Date startDate;
		
		//结束时间
		@DateTimeFormat(pattern = "yyyy-MM-dd")
		@JsonFormat(pattern = "yyyy-MM-dd")
		private Date endDate;
		
		//待审核，审核通过，审核不通过
		private Long status;
		

		private OaWkf wkfIdRef;




		public Long getId() {
	        return id;
	    }
	    
	    public void setId(Long id) {
	        this.id = id;	
	    }
	    
		public Long getWkfId() {
	        return wkfId;
	    }
	    
	    public void setWkfId(Long wkfId) {
	        this.wkfId = wkfId;	
	    }
	    
		public Date getStartDate() {
	        return startDate;
	    }
	    
	    public void setStartDate(Date startDate) {
	        this.startDate = startDate;	
	    }
	    
		public Date getEndDate() {
	        return endDate;
	    }
	    
	    public void setEndDate(Date endDate) {
	        this.endDate = endDate;	
	    }
	    
		public Long getStatus() {
	        return status;
	    }
	    
	    public void setStatus(Long status) {
	        this.status = status;	
	    }
	    
		public OaWkf getWkfIdRef() {
	        return wkfIdRef;
	    }
	    
	    public void setWkfIdRef(OaWkf wkfIdRef) {
	        this.wkfIdRef = wkfIdRef;	
	    }

}