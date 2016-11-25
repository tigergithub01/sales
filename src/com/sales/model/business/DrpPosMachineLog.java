package com.sales.model.business;

import java.util.Date;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sales.model.basic.BasicModel;
import com.sales.model.business.SysUser;
import com.sales.model.business.DrpPosMachine;



//t_drp_pos_machine_log
//收银机日志(断网后如何同步收银机日志）
public class DrpPosMachineLog extends BasicModel{

		//主键
		private Long id;
		
		//收银机编号
		@NotNull(message="收银机编号不能为空！") 
		private Long machineId;
		
		//收银员编号
		@NotNull(message="收银员编号不能为空！") 
		private Long userId;
		
		//登陆时间
		@DateTimeFormat(pattern = "yyyy-MM-dd")
		@JsonFormat(pattern = "yyyy-MM-dd")
		@NotNull(message="登陆时间不能为空！") 
		private Date logTime;
		
		//操作描述
		@NotBlank(message="操作描述不能为空！") 
		@Length(max=400)
		private String logDesc;
		

		private DrpPosMachine machineIdRef;

		private SysUser userIdRef;



		public Long getId() {
	        return id;
	    }
	    
	    public void setId(Long id) {
	        this.id = id;	
	    }
	    
		public Long getMachineId() {
	        return machineId;
	    }
	    
	    public void setMachineId(Long machineId) {
	        this.machineId = machineId;	
	    }
	    
		public Long getUserId() {
	        return userId;
	    }
	    
	    public void setUserId(Long userId) {
	        this.userId = userId;	
	    }
	    
		public Date getLogTime() {
	        return logTime;
	    }
	    
	    public void setLogTime(Date logTime) {
	        this.logTime = logTime;	
	    }
	    
		public String getLogDesc() {
	        return logDesc;
	    }
	    
	    public void setLogDesc(String logDesc) {
	        this.logDesc = logDesc == null ? null : logDesc.trim();
	    }
	    
		public DrpPosMachine getMachineIdRef() {
	        return machineIdRef;
	    }
	    
	    public void setMachineIdRef(DrpPosMachine machineIdRef) {
	        this.machineIdRef = machineIdRef;	
	    }
		public SysUser getUserIdRef() {
	        return userIdRef;
	    }
	    
	    public void setUserIdRef(SysUser userIdRef) {
	        this.userIdRef = userIdRef;	
	    }

}