package com.sales.model.business;

import java.util.Date;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sales.model.basic.BasicModel;



//t_drp_sheet_type
//单据类型(发货单，入库单，要货（补货）申请单，退货单)
public class DrpSheetType extends BasicModel{

		//主键
		private Long id;
		
		//单据名称
		@NotBlank(message="单据名称不能为空！") 
		@Length(max=30)
		private String name;
		
		//前缀
		@NotBlank(message="前缀不能为空！") 
		@Length(max=10)
		private String prefix;
		
		//日期格式
		@NotBlank(message="日期格式不能为空！") 
		@Length(max=200)
		private String dateFormat;
		
		//分隔符(Null、’-’)
		@Length(max=5)
		private String formatDelimiter;
		
		//流水号长度
		@NotNull(message="流水号长度不能为空！") 
		private Long seqLength;
		
		//流水号当前值
		@NotNull(message="流水号当前值不能为空！") 
		private Long seqCurVal;
		







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
	    
		public String getPrefix() {
	        return prefix;
	    }
	    
	    public void setPrefix(String prefix) {
	        this.prefix = prefix == null ? null : prefix.trim();
	    }
	    
		public String getDateFormat() {
	        return dateFormat;
	    }
	    
	    public void setDateFormat(String dateFormat) {
	        this.dateFormat = dateFormat == null ? null : dateFormat.trim();
	    }
	    
		public String getFormatDelimiter() {
	        return formatDelimiter;
	    }
	    
	    public void setFormatDelimiter(String formatDelimiter) {
	        this.formatDelimiter = formatDelimiter == null ? null : formatDelimiter.trim();
	    }
	    
		public Long getSeqLength() {
	        return seqLength;
	    }
	    
	    public void setSeqLength(Long seqLength) {
	        this.seqLength = seqLength;	
	    }
	    
		public Long getSeqCurVal() {
	        return seqCurVal;
	    }
	    
	    public void setSeqCurVal(Long seqCurVal) {
	        this.seqCurVal = seqCurVal;	
	    }
	    

}