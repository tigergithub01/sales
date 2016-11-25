package com.sales.util.exception;

public class NoDataFoundException extends CommonException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5584190108839449833L;

	public NoDataFoundException() {
		super("数据不存在");
	}

}
