package com.sales.model.business;

import java.util.Date;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sales.model.basic.BasicModel;
import com.sales.model.business.SysParameter;



//t_sys_task_quartz
//定时任务
public class SysTaskQuartz extends BasicModel{

		//主键
		private Long id;
		
		//任务名称
		@NotBlank(message="任务名称不能为空！") 
		@Length(max=50)
		private String taskName;
		
		//任务对应java或spring对象
		@Length(max=50)
		private String targetObject;
		
		//对应的java方法名称
		@Length(max=50)
		private String targetMethod;
		
		//quartz配置
		@Length(max=20)
		private String targetExpr;
		
		//描述
		@Length(max=200)
		private String description;
		
		//是否有效
		@NotNull(message="是否有效不能为空！") 
		private Long status;
		
		//任务状态：执行中，停止，暂停
		@NotNull(message="任务状态：执行中，停止，暂停不能为空！") 
		private Long taskStatus;
		







		private SysParameter taskStatusRef;

		public Long getId() {
	        return id;
	    }
	    
	    public void setId(Long id) {
	        this.id = id;	
	    }
	    
		public String getTaskName() {
	        return taskName;
	    }
	    
	    public void setTaskName(String taskName) {
	        this.taskName = taskName == null ? null : taskName.trim();
	    }
	    
		public String getTargetObject() {
	        return targetObject;
	    }
	    
	    public void setTargetObject(String targetObject) {
	        this.targetObject = targetObject == null ? null : targetObject.trim();
	    }
	    
		public String getTargetMethod() {
	        return targetMethod;
	    }
	    
	    public void setTargetMethod(String targetMethod) {
	        this.targetMethod = targetMethod == null ? null : targetMethod.trim();
	    }
	    
		public String getTargetExpr() {
	        return targetExpr;
	    }
	    
	    public void setTargetExpr(String targetExpr) {
	        this.targetExpr = targetExpr == null ? null : targetExpr.trim();
	    }
	    
		public String getDescription() {
	        return description;
	    }
	    
	    public void setDescription(String description) {
	        this.description = description == null ? null : description.trim();
	    }
	    
		public Long getStatus() {
	        return status;
	    }
	    
	    public void setStatus(Long status) {
	        this.status = status;	
	    }
	    
		public Long getTaskStatus() {
	        return taskStatus;
	    }
	    
	    public void setTaskStatus(Long taskStatus) {
	        this.taskStatus = taskStatus;	
	    }
	    
		public SysParameter getTaskStatusRef() {
	        return taskStatusRef;
	    }
	    
	    public void setTaskStatusRef(SysParameter taskStatusRef) {
	        this.taskStatusRef = taskStatusRef;	
	    }

}