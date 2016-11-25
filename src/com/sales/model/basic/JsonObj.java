package com.sales.model.basic;

import java.util.List;

public class JsonObj {
	private boolean status; // 状态
	private String message; // 消息
	private Object value; // 返回值
	private int errCode; // 错误编码
	private List<ValidErrObj> validErrList;

	private int total; // for EASYUI datagrid;
	private Object rows;// for EASYUI datagrid;

	public JsonObj() {
		super();
	}
	
	

	public JsonObj(boolean status) {
		super();
		this.status = status;		
	}



	public JsonObj(boolean status, String message) {
		super();
		this.status = status;
		this.message = message;
	}

	public JsonObj(boolean status, String message, Object value) {
		super();
		this.status = status;
		this.message = message;
		this.value = value;
	}

	public JsonObj(boolean status, int total, Object rows) {
		super();
		this.status = status;
		this.total = total;
		this.rows = rows;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}

	public int getErrCode() {
		return errCode;
	}

	public void setErrCode(int errCode) {
		this.errCode = errCode;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public Object getRows() {
		return rows;
	}

	public void setRows(Object rows) {
		this.rows = rows;
	}

	public List<ValidErrObj> getValidErrList() {
		return validErrList;
	}

	public void setValidErrList(List<ValidErrObj> validErrList) {
		this.validErrList = validErrList;
	}

}
