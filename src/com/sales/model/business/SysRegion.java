package com.sales.model.business;

import java.util.Date;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sales.model.basic.BasicModel;
import com.sales.model.business.SysParameter;



//t_sys_region
//区域信息（国家，省，市，区）
public class SysRegion extends BasicModel{

		//主键编号
		private Long id;
		
		//区域名称
		@NotBlank(message="区域名称不能为空！") 
		@Length(max=60)
		private String name;
		
		//上级区域
		private Long parentId;
		
		//国家省市区类别
		@NotNull(message="国家省市区类别不能为空！") 
		private Long regionType;
		


		private SysRegion parentIdRef;

		private SysParameter regionTypeRef;

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
	    
		public Long getParentId() {
	        return parentId;
	    }
	    
	    public void setParentId(Long parentId) {
	        this.parentId = parentId;	
	    }
	    
		public Long getRegionType() {
	        return regionType;
	    }
	    
	    public void setRegionType(Long regionType) {
	        this.regionType = regionType;	
	    }
	    
		public SysRegion getParentIdRef() {
	        return parentIdRef;
	    }
	    
	    public void setParentIdRef(SysRegion parentIdRef) {
	        this.parentIdRef = parentIdRef;	
	    }
		public SysParameter getRegionTypeRef() {
	        return regionTypeRef;
	    }
	    
	    public void setRegionTypeRef(SysParameter regionTypeRef) {
	        this.regionTypeRef = regionTypeRef;	
	    }

}