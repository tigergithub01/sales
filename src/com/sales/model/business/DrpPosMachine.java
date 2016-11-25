package com.sales.model.business;

import java.util.Date;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sales.model.basic.BasicModel;
import com.sales.model.business.SysParameter;
import com.sales.model.business.Organization;



//t_drp_pos_machine
//POS机
public class DrpPosMachine extends BasicModel{

		//主键
		private Long id;
		
		//pos机编号（逻辑编号）
		@NotBlank(message="pos机编号（逻辑编号）不能为空！") 
		@Length(max=30)
		private String code;
		
		//电脑名称（用户的电脑名）
		@NotBlank(message="电脑名称（用户的电脑名）不能为空！") 
		@Length(max=30)
		private String name;
		
		//MAC地址
		@NotBlank(message="MAC地址不能为空！") 
		@Length(max=30)
		private String macAddr;
		
		//硬盘序列号
		@NotBlank(message="硬盘序列号不能为空！") 
		@Length(max=50)
		private String diskSeq;
		
		//描述
		@Length(max=100)
		private String description;
		
		//组织机构编号
		@NotNull(message="组织机构编号不能为空！") 
		private Long organizationId;
		
		//状态：正常，停用
		@NotNull(message="状态：正常，停用不能为空！") 
		private Long status;
		






		private Organization organizationIdRef;

		private SysParameter statusRef;

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
	    
		public String getMacAddr() {
	        return macAddr;
	    }
	    
	    public void setMacAddr(String macAddr) {
	        this.macAddr = macAddr == null ? null : macAddr.trim();
	    }
	    
		public String getDiskSeq() {
	        return diskSeq;
	    }
	    
	    public void setDiskSeq(String diskSeq) {
	        this.diskSeq = diskSeq == null ? null : diskSeq.trim();
	    }
	    
		public String getDescription() {
	        return description;
	    }
	    
	    public void setDescription(String description) {
	        this.description = description == null ? null : description.trim();
	    }
	    
		public Long getOrganizationId() {
	        return organizationId;
	    }
	    
	    public void setOrganizationId(Long organizationId) {
	        this.organizationId = organizationId;	
	    }
	    
		public Long getStatus() {
	        return status;
	    }
	    
	    public void setStatus(Long status) {
	        this.status = status;	
	    }
	    
		public Organization getOrganizationIdRef() {
	        return organizationIdRef;
	    }
	    
	    public void setOrganizationIdRef(Organization organizationIdRef) {
	        this.organizationIdRef = organizationIdRef;	
	    }
		public SysParameter getStatusRef() {
	        return statusRef;
	    }
	    
	    public void setStatusRef(SysParameter statusRef) {
	        this.statusRef = statusRef;	
	    }

}