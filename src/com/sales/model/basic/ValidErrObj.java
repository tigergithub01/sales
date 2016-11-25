package com.sales.model.basic;

/**
 * 验证错误消息
 * @author Tiger-guo
 * 2016年11月15日 上午11:09:28
 */
public class ValidErrObj {
	private String filedName;
	private Object value;
	private String message;

	public String getFiledName() {
		return filedName;
	}

	public void setFiledName(String filedName) {
		this.filedName = filedName;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
