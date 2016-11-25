package com.sales.model.business;

import java.util.Date;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sales.model.basic.BasicModel;
import com.sales.model.business.SysUser;
import com.sales.model.business.SysRegion;
import com.sales.model.business.SysArea;
import com.sales.model.business.SysParameter;
import com.sales.model.business.OrgType;



//t_organization
//门店信息
public class Organization extends BasicModel{

		//主键
		private Long id;
		
		//门店编码
		@NotBlank(message="门店编码不能为空！") 
		@Length(max=30)
		private String code;
		
		//门店名称
		@NotBlank(message="门店名称不能为空！") 
		@Length(max=60)
		private String name;
		
		//上级门店
		private Long parentId;
		
		//门店类型（总部，仓库，配送中心，门店，网上商城）
		@NotNull(message="门店类型（总部，仓库，配送中心，门店，网上商城）不能为空！") 
		private Long typeId;
		
		//所属区域
		@NotNull(message="所属区域不能为空！") 
		private Long areaId;
		
		//地址
		@Length(max=255)
		private String address;
		
		//店主姓名
		@Length(max=30)
		private String contact;
		
		//联系电话
		@Length(max=30)
		private String mobile;
		
		//法人代表
		@Length(max=30)
		private String legal;
		
		//法人代表联系电话
		@Length(max=30)
		private String legalMobile;
		
		//门店联系电话
		@Length(max=30)
		private String tel;
		
		//创建日期
		@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
		@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
		private Date createDate;
		
		//更新日期
		@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
		@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
		private Date updateDate;
		
		//创建人
		private Long createUserId;
		
		//更新人
		private Long updateUserId;
		
		//状态?1:有效,0:失效
		@NotNull(message="状态?1:有效,0:失效不能为空！") 
		private Long status;
		
		//所属国家
		private Long countryId;
		
		//所属省份
		private Long provinceId;
		
		//所属城市
		private Long cityId;
		
		//所属地区
		private Long districtId;
		



		private Organization parentIdRef;

		private OrgType typeIdRef;

		private SysArea areaIdRef;









		private SysUser createUserIdRef;

		private SysUser updateUserIdRef;

		private SysParameter statusRef;

		private SysRegion countryIdRef;

		private SysRegion provinceIdRef;

		private SysRegion cityIdRef;

		private SysRegion districtIdRef;

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
	    
		public Long getParentId() {
	        return parentId;
	    }
	    
	    public void setParentId(Long parentId) {
	        this.parentId = parentId;	
	    }
	    
		public Long getTypeId() {
	        return typeId;
	    }
	    
	    public void setTypeId(Long typeId) {
	        this.typeId = typeId;	
	    }
	    
		public Long getAreaId() {
	        return areaId;
	    }
	    
	    public void setAreaId(Long areaId) {
	        this.areaId = areaId;	
	    }
	    
		public String getAddress() {
	        return address;
	    }
	    
	    public void setAddress(String address) {
	        this.address = address == null ? null : address.trim();
	    }
	    
		public String getContact() {
	        return contact;
	    }
	    
	    public void setContact(String contact) {
	        this.contact = contact == null ? null : contact.trim();
	    }
	    
		public String getMobile() {
	        return mobile;
	    }
	    
	    public void setMobile(String mobile) {
	        this.mobile = mobile == null ? null : mobile.trim();
	    }
	    
		public String getLegal() {
	        return legal;
	    }
	    
	    public void setLegal(String legal) {
	        this.legal = legal == null ? null : legal.trim();
	    }
	    
		public String getLegalMobile() {
	        return legalMobile;
	    }
	    
	    public void setLegalMobile(String legalMobile) {
	        this.legalMobile = legalMobile == null ? null : legalMobile.trim();
	    }
	    
		public String getTel() {
	        return tel;
	    }
	    
	    public void setTel(String tel) {
	        this.tel = tel == null ? null : tel.trim();
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
	    
		public Long getStatus() {
	        return status;
	    }
	    
	    public void setStatus(Long status) {
	        this.status = status;	
	    }
	    
		public Long getCountryId() {
	        return countryId;
	    }
	    
	    public void setCountryId(Long countryId) {
	        this.countryId = countryId;	
	    }
	    
		public Long getProvinceId() {
	        return provinceId;
	    }
	    
	    public void setProvinceId(Long provinceId) {
	        this.provinceId = provinceId;	
	    }
	    
		public Long getCityId() {
	        return cityId;
	    }
	    
	    public void setCityId(Long cityId) {
	        this.cityId = cityId;	
	    }
	    
		public Long getDistrictId() {
	        return districtId;
	    }
	    
	    public void setDistrictId(Long districtId) {
	        this.districtId = districtId;	
	    }
	    
		public Organization getParentIdRef() {
	        return parentIdRef;
	    }
	    
	    public void setParentIdRef(Organization parentIdRef) {
	        this.parentIdRef = parentIdRef;	
	    }
		public OrgType getTypeIdRef() {
	        return typeIdRef;
	    }
	    
	    public void setTypeIdRef(OrgType typeIdRef) {
	        this.typeIdRef = typeIdRef;	
	    }
		public SysArea getAreaIdRef() {
	        return areaIdRef;
	    }
	    
	    public void setAreaIdRef(SysArea areaIdRef) {
	        this.areaIdRef = areaIdRef;	
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
		public SysParameter getStatusRef() {
	        return statusRef;
	    }
	    
	    public void setStatusRef(SysParameter statusRef) {
	        this.statusRef = statusRef;	
	    }
		public SysRegion getCountryIdRef() {
	        return countryIdRef;
	    }
	    
	    public void setCountryIdRef(SysRegion countryIdRef) {
	        this.countryIdRef = countryIdRef;	
	    }
		public SysRegion getProvinceIdRef() {
	        return provinceIdRef;
	    }
	    
	    public void setProvinceIdRef(SysRegion provinceIdRef) {
	        this.provinceIdRef = provinceIdRef;	
	    }
		public SysRegion getCityIdRef() {
	        return cityIdRef;
	    }
	    
	    public void setCityIdRef(SysRegion cityIdRef) {
	        this.cityIdRef = cityIdRef;	
	    }
		public SysRegion getDistrictIdRef() {
	        return districtIdRef;
	    }
	    
	    public void setDistrictIdRef(SysRegion districtIdRef) {
	        this.districtIdRef = districtIdRef;	
	    }

}