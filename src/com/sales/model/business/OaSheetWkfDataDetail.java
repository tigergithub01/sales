package com.sales.model.business;

import java.util.Date;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sales.model.basic.BasicModel;
import com.sales.model.business.OaSheetWkfData;



//t_oa_sheet_wkf_data_detail
//申请明细数据
public class OaSheetWkfDataDetail extends BasicModel{

		//主键
		private Long id;
		
		//关联流程数据编号
		@NotNull(message="关联流程数据编号不能为空！") 
		private Long wkfDataId;
		
		//关联商品，优惠活动，盘点，要货，退货
		@NotNull(message="关联商品，优惠活动，盘点，要货，退货不能为空！") 
		private Long refId;
		

		private OaSheetWkfData wkfDataIdRef;


		public Long getId() {
	        return id;
	    }
	    
	    public void setId(Long id) {
	        this.id = id;	
	    }
	    
		public Long getWkfDataId() {
	        return wkfDataId;
	    }
	    
	    public void setWkfDataId(Long wkfDataId) {
	        this.wkfDataId = wkfDataId;	
	    }
	    
		public Long getRefId() {
	        return refId;
	    }
	    
	    public void setRefId(Long refId) {
	        this.refId = refId;	
	    }
	    
		public OaSheetWkfData getWkfDataIdRef() {
	        return wkfDataIdRef;
	    }
	    
	    public void setWkfDataIdRef(OaSheetWkfData wkfDataIdRef) {
	        this.wkfDataIdRef = wkfDataIdRef;	
	    }

}