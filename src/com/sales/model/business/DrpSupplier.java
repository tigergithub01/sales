package com.sales.model.business;

import java.util.Date;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sales.model.basic.BasicModel;
import com.sales.model.business.SysParameter;
import com.sales.model.business.SysUser;
import com.sales.model.business.Organization;



//t_drp_supplier
//供应商信息
public class DrpSupplier extends BasicModel{

		//主键
		private Long id;
		
		//供应商编号
		@NotBlank(message="供应商编号不能为空！") 
		@Length(max=10)
		private String code;
		
		//名称
		@NotBlank(message="名称不能为空！") 
		@Length(max=50)
		private String name;
		
		//联系人
		@Length(max=30)
		private String contact;
		
		//联系电话
		@Length(max=20)
		private String tel;
		
		//联系地址
		@Length(max=100)
		private String address;
		
		//是否有效？1：是；0：否
		@NotNull(message="是否有效？1：是；0：否不能为空！") 
		private Long status;
		
		//创建门店
		@NotNull(message="创建门店不能为空！") 
		private Long organizationId;
		
		//记录创建人
		private Long createUserId;
		
		//记录创建时间
		@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
		@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
		private Date createDate;
		
		//记录最后一次更新人
		private Long updateUserId;
		
		//记录最后一次更新时间
		@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
		@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
		private Date updateDate;
		






		private SysParameter statusRef;

		private Organization organizationIdRef;

		private SysUser createUserIdRef;


		private SysUser updateUserIdRef;


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
	    
		public String getContact() {
	        return contact;
	    }
	    
	    public void setContact(String contact) {
	        this.contact = contact == null ? null : contact.trim();
	    }
	    
		public String getTel() {
	        return tel;
	    }
	    
	    public void setTel(String tel) {
	        this.tel = tel == null ? null : tel.trim();
	    }
	    
		public String getAddress() {
	        return address;
	    }
	    
	    public void setAddress(String address) {
	        this.address = address == null ? null : address.trim();
	    }
	    
		public Long getStatus() {
	        return status;
	    }
	    
	    public void setStatus(Long status) {
	        this.status = status;	
	    }
	    
		public Long getOrganizationId() {
	        return organizationId;
	    }
	    
	    public void setOrganizationId(Long organizationId) {
	        this.organizationId = organizationId;	
	    }
	    
		public Long getCreateUserId() {
	        return createUserId;
	    }
	    
	    public void setCreateUserId(Long createUserId) {
	        this.createUserId = createUserId;	
	    }
	    
		public Date getCreateDate() {
	        return createDate;
	    }
	    
	    public void setCreateDate(Date createDate) {
	        this.createDate = createDate;	
	    }
	    
		public Long getUpdateUserId() {
	        return updateUserId;
	    }
	    
	    public void setUpdateUserId(Long updateUserId) {
	        this.updateUserId = updateUserId;	
	    }
	    
		public Date getUpdateDate() {
	        return updateDate;
	    }
	    
	    public void setUpdateDate(Date updateDate) {
	        this.updateDate = updateDate;	
	    }
	    
		public SysParameter getStatusRef() {
	        return statusRef;
	    }
	    
	    public void setStatusRef(SysParameter statusRef) {
	        this.statusRef = statusRef;	
	    }
		public Organization getOrganizationIdRef() {
	        return organizationIdRef;
	    }
	    
	    public void setOrganizationIdRef(Organization organizationIdRef) {
	        this.organizationIdRef = organizationIdRef;	
	    }
		public SysUser getCreateUserIdRef() {
	        return createUserIdRef;
	    }
	    
	    public void setCreateUserIdRef(SysUser createUserIdRef) {
	        this.createUserIdRef = createUserIdRef;	
	    }
		public SysUser getUpdateUserIdRef() {
	        return updateUserIdRef;
	    }
	    
	    public void setUpdateUserIdRef(SysUser updateUserIdRef) {
	        this.updateUserIdRef = updateUserIdRef;	
	    }

}