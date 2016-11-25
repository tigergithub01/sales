package com.sales.model.business;

import java.util.Date;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sales.model.basic.BasicModel;
import com.sales.model.business.DrpSheet;
import com.sales.model.business.Organization;
import com.sales.model.business.DrpMaterial;



//t_drp_mat_batch
//商品批次信息
public class DrpMatBatch extends BasicModel{

		//主键
		private Long id;
		
		//商品编号
		@NotNull(message="商品编号不能为空！") 
		private Long materialId;
		
		//关联机构（门店）编号
		@NotNull(message="关联机构（门店）编号不能为空！") 
		private Long organizationId;
		
		//商品批次
		@NotBlank(message="商品批次不能为空！") 
		@Length(max=30)
		private String batchNo;
		
		//入库数量
		private Double quantity;
		
		//入库日期
		@DateTimeFormat(pattern = "yyyy-MM-dd")
		@JsonFormat(pattern = "yyyy-MM-dd")
		@NotNull(message="入库日期不能为空！") 
		private Date inDate;
		
		//关联进货单号，用于对数据进行追溯
		@NotNull(message="关联进货单号，用于对数据进行追溯不能为空！") 
		private Long sheetId;
		
		//入库单价
		private Double price;
		
		//生产日期
		@DateTimeFormat(pattern = "yyyy-MM-dd")
		@JsonFormat(pattern = "yyyy-MM-dd")
		@NotNull(message="生产日期不能为空！") 
		private Date manufactureDate;
		
		//有效期限（天）
		@NotNull(message="有效期限（天）不能为空！") 
		private Long guaranteeDays;
		
		//数量余额
		@NotNull(message="数量余额不能为空！") 
		private Long balanceQuantity;
		

		private DrpMaterial materialIdRef;

		private Organization organizationIdRef;




		private DrpSheet sheetIdRef;





		public Long getId() {
	        return id;
	    }
	    
	    public void setId(Long id) {
	        this.id = id;	
	    }
	    
		public Long getMaterialId() {
	        return materialId;
	    }
	    
	    public void setMaterialId(Long materialId) {
	        this.materialId = materialId;	
	    }
	    
		public Long getOrganizationId() {
	        return organizationId;
	    }
	    
	    public void setOrganizationId(Long organizationId) {
	        this.organizationId = organizationId;	
	    }
	    
		public String getBatchNo() {
	        return batchNo;
	    }
	    
	    public void setBatchNo(String batchNo) {
	        this.batchNo = batchNo == null ? null : batchNo.trim();
	    }
	    
		public Double getQuantity() {
	        return quantity;
	    }
	    
	    public void setQuantity(Double quantity) {
	        this.quantity = quantity;	
	    }
	    
		public Date getInDate() {
	        return inDate;
	    }
	    
	    public void setInDate(Date inDate) {
	        this.inDate = inDate;	
	    }
	    
		public Long getSheetId() {
	        return sheetId;
	    }
	    
	    public void setSheetId(Long sheetId) {
	        this.sheetId = sheetId;	
	    }
	    
		public Double getPrice() {
	        return price;
	    }
	    
	    public void setPrice(Double price) {
	        this.price = price;	
	    }
	    
		public Date getManufactureDate() {
	        return manufactureDate;
	    }
	    
	    public void setManufactureDate(Date manufactureDate) {
	        this.manufactureDate = manufactureDate;	
	    }
	    
		public Long getGuaranteeDays() {
	        return guaranteeDays;
	    }
	    
	    public void setGuaranteeDays(Long guaranteeDays) {
	        this.guaranteeDays = guaranteeDays;	
	    }
	    
		public Long getBalanceQuantity() {
	        return balanceQuantity;
	    }
	    
	    public void setBalanceQuantity(Long balanceQuantity) {
	        this.balanceQuantity = balanceQuantity;	
	    }
	    
		public DrpMaterial getMaterialIdRef() {
	        return materialIdRef;
	    }
	    
	    public void setMaterialIdRef(DrpMaterial materialIdRef) {
	        this.materialIdRef = materialIdRef;	
	    }
		public Organization getOrganizationIdRef() {
	        return organizationIdRef;
	    }
	    
	    public void setOrganizationIdRef(Organization organizationIdRef) {
	        this.organizationIdRef = organizationIdRef;	
	    }
		public DrpSheet getSheetIdRef() {
	        return sheetIdRef;
	    }
	    
	    public void setSheetIdRef(DrpSheet sheetIdRef) {
	        this.sheetIdRef = sheetIdRef;	
	    }

}