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



//t_sys_user
//用户信息
public class SysUser extends BasicModel{

		//主键
		private Long id;
		
		//登录ID
		@NotBlank(message="登录ID不能为空！") 
		@Length(max=20)
		private String userId;
		
		//用户姓名
		@NotBlank(message="用户姓名不能为空！") 
		@Length(max=30)
		private String userName;
		
		//登录密码
		@Length(max=100)
		private String password;
		
		//是否有效?1,是;0,否
		private Long status;
		
		//创建人
		private Long createUserId;
		
		//更新人
		private Long updateUserId;
		
		//创建时间
		@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
		@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
		private Date createDate;
		
		//更新时间
		@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
		@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
		private Date updateDate;
		
		//最后登录时间
		@DateTimeFormat(pattern = "yyyy-MM-dd")
		@JsonFormat(pattern = "yyyy-MM-dd")
		private Date lastLoginDate;
		
		//描述
		@Length(max=400)
		private String description;
		
		//所属机构
		@NotNull(message="所属机构不能为空！") 
		private Long organizationId;
		
		//用户类型：操作员 ，营业员，收银员
		@NotNull(message="用户类型：操作员 ，营业员，收银员不能为空！") 
		private Long userType;
		
		//机构数据权限（查看本门店数据，查看本机构及其下属机构数据，查看指定机构数据）
		@NotNull(message="机构数据权限（查看本门店数据，查看本机构及其下属机构数据，查看指定机构数据）不能为空！") 
		private Long authType;
		
		//入职时间
		@DateTimeFormat(pattern = "yyyy-MM-dd")
		@JsonFormat(pattern = "yyyy-MM-dd")
		private Date empEntryTime;
		
		//离职时间
		@DateTimeFormat(pattern = "yyyy-MM-dd")
		@JsonFormat(pattern = "yyyy-MM-dd")
		private Date empLeaveTime;
		
		//人员状态（在职，离职）
		@NotNull(message="人员状态（在职，离职）不能为空！") 
		private Long empStatus;
		
		//联系电话
		@Length(max=30)
		private String tel;
		




		private SysParameter statusRef;







		private Organization organizationIdRef;

		private SysParameter userTypeRef;

		private SysParameter authTypeRef;



		private SysParameter empStatusRef;


		public Long getId() {
	        return id;
	    }
	    
	    public void setId(Long id) {
	        this.id = id;	
	    }
	    
		public String getUserId() {
	        return userId;
	    }
	    
	    public void setUserId(String userId) {
	        this.userId = userId == null ? null : userId.trim();
	    }
	    
		public String getUserName() {
	        return userName;
	    }
	    
	    public void setUserName(String userName) {
	        this.userName = userName == null ? null : userName.trim();
	    }
	    
		public String getPassword() {
	        return password;
	    }
	    
	    public void setPassword(String password) {
	        this.password = password == null ? null : password.trim();
	    }
	    
		public Long getStatus() {
	        return status;
	    }
	    
	    public void setStatus(Long status) {
	        this.status = status;	
	    }
	    
		public Long getCreateUserId() {
	        return createUserId;
	    }
	    
	    public void setCreateUserId(Long createUserId) {
	        this.createUserId = createUserId;	
	    }
	    
		public Long getUpdateUserId() {
	        return updateUserId;
	    }
	    
	    public void setUpdateUserId(Long updateUserId) {
	        this.updateUserId = updateUserId;	
	    }
	    
		public Date getCreateDate() {
	        return createDate;
	    }
	    
	    public void setCreateDate(Date createDate) {
	        this.createDate = createDate;	
	    }
	    
		public Date getUpdateDate() {
	        return updateDate;
	    }
	    
	    public void setUpdateDate(Date updateDate) {
	        this.updateDate = updateDate;	
	    }
	    
		public Date getLastLoginDate() {
	        return lastLoginDate;
	    }
	    
	    public void setLastLoginDate(Date lastLoginDate) {
	        this.lastLoginDate = lastLoginDate;	
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
	    
		public Long getUserType() {
	        return userType;
	    }
	    
	    public void setUserType(Long userType) {
	        this.userType = userType;	
	    }
	    
		public Long getAuthType() {
	        return authType;
	    }
	    
	    public void setAuthType(Long authType) {
	        this.authType = authType;	
	    }
	    
		public Date getEmpEntryTime() {
	        return empEntryTime;
	    }
	    
	    public void setEmpEntryTime(Date empEntryTime) {
	        this.empEntryTime = empEntryTime;	
	    }
	    
		public Date getEmpLeaveTime() {
	        return empLeaveTime;
	    }
	    
	    public void setEmpLeaveTime(Date empLeaveTime) {
	        this.empLeaveTime = empLeaveTime;	
	    }
	    
		public Long getEmpStatus() {
	        return empStatus;
	    }
	    
	    public void setEmpStatus(Long empStatus) {
	        this.empStatus = empStatus;	
	    }
	    
		public String getTel() {
	        return tel;
	    }
	    
	    public void setTel(String tel) {
	        this.tel = tel == null ? null : tel.trim();
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
		public SysParameter getUserTypeRef() {
	        return userTypeRef;
	    }
	    
	    public void setUserTypeRef(SysParameter userTypeRef) {
	        this.userTypeRef = userTypeRef;	
	    }
		public SysParameter getAuthTypeRef() {
	        return authTypeRef;
	    }
	    
	    public void setAuthTypeRef(SysParameter authTypeRef) {
	        this.authTypeRef = authTypeRef;	
	    }
		public SysParameter getEmpStatusRef() {
	        return empStatusRef;
	    }
	    
	    public void setEmpStatusRef(SysParameter empStatusRef) {
	        this.empStatusRef = empStatusRef;	
	    }
	    
	    //临时字段
	    private boolean rememberMe; //是否自动登陆


		public boolean isRememberMe() {
			return rememberMe;
		}

		public void setRememberMe(boolean rememberMe) {
			this.rememberMe = rememberMe;
		}
	    
	    
	    
	    

}