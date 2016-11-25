package com.sales.model.business;

import java.util.Date;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sales.model.basic.BasicModel;
import com.sales.model.business.SysParameter;
import com.sales.model.business.SysAppInfo;



//t_sys_app_release
//应用发布信息表
public class SysAppRelease extends BasicModel{

		//主键编号
		private Long id;
		
		//版本名称(1.1.1，字符串型)、
		@NotBlank(message="版本名称(1.1.1，字符串型)、不能为空！") 
		@Length(max=60)
		private String name;
		
		//版本升级描述
		@Length(max=600)
		private String upgradeDesc;
		
		//版本编号(1.0，数字型用来与app进行版本比较)
		@NotNull(message="版本编号(1.0，数字型用来与app进行版本比较)不能为空！") 
		private Long verNo;
		
		//是否必须升级(1:是；0:否）
		@NotNull(message="是否必须升级(1:是；0:否）不能为空！") 
		private Long forceUpgrade;
		
		//发布日期
		@DateTimeFormat(pattern = "yyyy-MM-dd")
		@JsonFormat(pattern = "yyyy-MM-dd")
		@NotNull(message="发布日期不能为空！") 
		private Date issueDate;
		
		//应用下载地址
		@Length(max=200)
		private String appPath;
		
		//关联app名称（pos)
		@NotNull(message="关联app名称（pos)不能为空！") 
		private Long appInfoId;
		




		private SysParameter forceUpgradeRef;



		private SysAppInfo appInfoIdRef;

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
	    
		public String getUpgradeDesc() {
	        return upgradeDesc;
	    }
	    
	    public void setUpgradeDesc(String upgradeDesc) {
	        this.upgradeDesc = upgradeDesc == null ? null : upgradeDesc.trim();
	    }
	    
		public Long getVerNo() {
	        return verNo;
	    }
	    
	    public void setVerNo(Long verNo) {
	        this.verNo = verNo;	
	    }
	    
		public Long getForceUpgrade() {
	        return forceUpgrade;
	    }
	    
	    public void setForceUpgrade(Long forceUpgrade) {
	        this.forceUpgrade = forceUpgrade;	
	    }
	    
		public Date getIssueDate() {
	        return issueDate;
	    }
	    
	    public void setIssueDate(Date issueDate) {
	        this.issueDate = issueDate;	
	    }
	    
		public String getAppPath() {
	        return appPath;
	    }
	    
	    public void setAppPath(String appPath) {
	        this.appPath = appPath == null ? null : appPath.trim();
	    }
	    
		public Long getAppInfoId() {
	        return appInfoId;
	    }
	    
	    public void setAppInfoId(Long appInfoId) {
	        this.appInfoId = appInfoId;	
	    }
	    
		public SysParameter getForceUpgradeRef() {
	        return forceUpgradeRef;
	    }
	    
	    public void setForceUpgradeRef(SysParameter forceUpgradeRef) {
	        this.forceUpgradeRef = forceUpgradeRef;	
	    }
		public SysAppInfo getAppInfoIdRef() {
	        return appInfoIdRef;
	    }
	    
	    public void setAppInfoIdRef(SysAppInfo appInfoIdRef) {
	        this.appInfoIdRef = appInfoIdRef;	
	    }

}