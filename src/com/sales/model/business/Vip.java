package com.sales.model.business;

import java.util.Date;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sales.model.basic.BasicModel;
import com.sales.model.business.SysParameter;
import com.sales.model.business.VipType;



//t_vip
//会员信息
public class Vip extends BasicModel{

		//主键
		private Long id;
		
		//会员类别
		private Long vipTypeId;
		
		//会员名(登陆名）
		@NotBlank(message="会员名(登陆名）不能为空！") 
		@Length(max=20)
		private String vipName;
		
		//会员密码
		@NotBlank(message="会员密码不能为空！") 
		@Length(max=30)
		private String vipPwd;
		
		//会员昵称
		@Length(max=20)
		private String vipNickName;
		
		//性别
		private Long sex;
		
		//会员生日
		@DateTimeFormat(pattern = "yyyy-MM-dd")
		@JsonFormat(pattern = "yyyy-MM-dd")
		private Date birthday;
		
		//手机号码
		@Length(max=30)
		private String mobile;
		
		//手机号码是否已经验证？1：是；0：否
		@NotNull(message="手机号码是否已经验证？1：是；0：否不能为空！") 
		private Long mobileVerifyFlag;
		
		//邮箱
		@Length(max=40)
		private String email;
		
		//邮箱是否已经验证？1：是；0：否
		@NotNull(message="邮箱是否已经验证？1：是；0：否不能为空！") 
		private Long emailVerifyFlag;
		
		//等级积分（收银系统中，此字段备用）
		@NotNull(message="等级积分（收银系统中，此字段备用）不能为空！") 
		private Double rankIntegral;
		
		//消费积分
		@NotNull(message="消费积分不能为空！") 
		private Double resumeIntegral;
		
		//最后一次登录日期
		@DateTimeFormat(pattern = "yyyy-MM-dd")
		@JsonFormat(pattern = "yyyy-MM-dd")
		private Date lastLoginDate;
		
		//注册时间
		@DateTimeFormat(pattern = "yyyy-MM-dd")
		@JsonFormat(pattern = "yyyy-MM-dd")
		@NotNull(message="注册时间不能为空！") 
		private Date regiserDate;
		
		//上级会员
		private Long parentId;
		
		//宝宝昵称
		@Length(max=30)
		private String babyName;
		
		//宝宝性别
		private Long babySex;
		
		//宝宝生日
		@DateTimeFormat(pattern = "yyyy-MM-dd")
		@JsonFormat(pattern = "yyyy-MM-dd")
		private Date babyBirthday;
		

		private VipType vipTypeIdRef;




		private SysParameter sexRef;



		private SysParameter mobileVerifyFlagRef;


		private SysParameter emailVerifyFlagRef;





		private Vip parentIdRef;


		private SysParameter babySexRef;


		public Long getId() {
	        return id;
	    }
	    
	    public void setId(Long id) {
	        this.id = id;	
	    }
	    
		public Long getVipTypeId() {
	        return vipTypeId;
	    }
	    
	    public void setVipTypeId(Long vipTypeId) {
	        this.vipTypeId = vipTypeId;	
	    }
	    
		public String getVipName() {
	        return vipName;
	    }
	    
	    public void setVipName(String vipName) {
	        this.vipName = vipName == null ? null : vipName.trim();
	    }
	    
		public String getVipPwd() {
	        return vipPwd;
	    }
	    
	    public void setVipPwd(String vipPwd) {
	        this.vipPwd = vipPwd == null ? null : vipPwd.trim();
	    }
	    
		public String getVipNickName() {
	        return vipNickName;
	    }
	    
	    public void setVipNickName(String vipNickName) {
	        this.vipNickName = vipNickName == null ? null : vipNickName.trim();
	    }
	    
		public Long getSex() {
	        return sex;
	    }
	    
	    public void setSex(Long sex) {
	        this.sex = sex;	
	    }
	    
		public Date getBirthday() {
	        return birthday;
	    }
	    
	    public void setBirthday(Date birthday) {
	        this.birthday = birthday;	
	    }
	    
		public String getMobile() {
	        return mobile;
	    }
	    
	    public void setMobile(String mobile) {
	        this.mobile = mobile == null ? null : mobile.trim();
	    }
	    
		public Long getMobileVerifyFlag() {
	        return mobileVerifyFlag;
	    }
	    
	    public void setMobileVerifyFlag(Long mobileVerifyFlag) {
	        this.mobileVerifyFlag = mobileVerifyFlag;	
	    }
	    
		public String getEmail() {
	        return email;
	    }
	    
	    public void setEmail(String email) {
	        this.email = email == null ? null : email.trim();
	    }
	    
		public Long getEmailVerifyFlag() {
	        return emailVerifyFlag;
	    }
	    
	    public void setEmailVerifyFlag(Long emailVerifyFlag) {
	        this.emailVerifyFlag = emailVerifyFlag;	
	    }
	    
		public Double getRankIntegral() {
	        return rankIntegral;
	    }
	    
	    public void setRankIntegral(Double rankIntegral) {
	        this.rankIntegral = rankIntegral;	
	    }
	    
		public Double getResumeIntegral() {
	        return resumeIntegral;
	    }
	    
	    public void setResumeIntegral(Double resumeIntegral) {
	        this.resumeIntegral = resumeIntegral;	
	    }
	    
		public Date getLastLoginDate() {
	        return lastLoginDate;
	    }
	    
	    public void setLastLoginDate(Date lastLoginDate) {
	        this.lastLoginDate = lastLoginDate;	
	    }
	    
		public Date getRegiserDate() {
	        return regiserDate;
	    }
	    
	    public void setRegiserDate(Date regiserDate) {
	        this.regiserDate = regiserDate;	
	    }
	    
		public Long getParentId() {
	        return parentId;
	    }
	    
	    public void setParentId(Long parentId) {
	        this.parentId = parentId;	
	    }
	    
		public String getBabyName() {
	        return babyName;
	    }
	    
	    public void setBabyName(String babyName) {
	        this.babyName = babyName == null ? null : babyName.trim();
	    }
	    
		public Long getBabySex() {
	        return babySex;
	    }
	    
	    public void setBabySex(Long babySex) {
	        this.babySex = babySex;	
	    }
	    
		public Date getBabyBirthday() {
	        return babyBirthday;
	    }
	    
	    public void setBabyBirthday(Date babyBirthday) {
	        this.babyBirthday = babyBirthday;	
	    }
	    
		public VipType getVipTypeIdRef() {
	        return vipTypeIdRef;
	    }
	    
	    public void setVipTypeIdRef(VipType vipTypeIdRef) {
	        this.vipTypeIdRef = vipTypeIdRef;	
	    }
		public SysParameter getSexRef() {
	        return sexRef;
	    }
	    
	    public void setSexRef(SysParameter sexRef) {
	        this.sexRef = sexRef;	
	    }
		public SysParameter getMobileVerifyFlagRef() {
	        return mobileVerifyFlagRef;
	    }
	    
	    public void setMobileVerifyFlagRef(SysParameter mobileVerifyFlagRef) {
	        this.mobileVerifyFlagRef = mobileVerifyFlagRef;	
	    }
		public SysParameter getEmailVerifyFlagRef() {
	        return emailVerifyFlagRef;
	    }
	    
	    public void setEmailVerifyFlagRef(SysParameter emailVerifyFlagRef) {
	        this.emailVerifyFlagRef = emailVerifyFlagRef;	
	    }
		public Vip getParentIdRef() {
	        return parentIdRef;
	    }
	    
	    public void setParentIdRef(Vip parentIdRef) {
	        this.parentIdRef = parentIdRef;	
	    }
		public SysParameter getBabySexRef() {
	        return babySexRef;
	    }
	    
	    public void setBabySexRef(SysParameter babySexRef) {
	        this.babySexRef = babySexRef;	
	    }

}