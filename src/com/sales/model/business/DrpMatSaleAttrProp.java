package com.sales.model.business;

import java.util.Date;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sales.model.basic.BasicModel;
import com.sales.model.business.DrpMatProperties;
import com.sales.model.business.DrpMatSaleAttr;



//t_drp_mat_sale_attr_prop
//销售属性定义（如果存在促销的时候，多属性产品很难管理，这个要考虑）
public class DrpMatSaleAttrProp extends BasicModel{

		//主键
		private Long id;
		
		//销售属性产品编号
		@NotNull(message="销售属性产品编号不能为空！") 
		private Long matAttrId;
		
		//商品属性编号
		@NotNull(message="商品属性编号不能为空！") 
		private Long matPropId;
		

		private DrpMatSaleAttr matAttrIdRef;

		private DrpMatProperties matPropIdRef;

		public Long getId() {
	        return id;
	    }
	    
	    public void setId(Long id) {
	        this.id = id;	
	    }
	    
		public Long getMatAttrId() {
	        return matAttrId;
	    }
	    
	    public void setMatAttrId(Long matAttrId) {
	        this.matAttrId = matAttrId;	
	    }
	    
		public Long getMatPropId() {
	        return matPropId;
	    }
	    
	    public void setMatPropId(Long matPropId) {
	        this.matPropId = matPropId;	
	    }
	    
		public DrpMatSaleAttr getMatAttrIdRef() {
	        return matAttrIdRef;
	    }
	    
	    public void setMatAttrIdRef(DrpMatSaleAttr matAttrIdRef) {
	        this.matAttrIdRef = matAttrIdRef;	
	    }
		public DrpMatProperties getMatPropIdRef() {
	        return matPropIdRef;
	    }
	    
	    public void setMatPropIdRef(DrpMatProperties matPropIdRef) {
	        this.matPropIdRef = matPropIdRef;	
	    }

}