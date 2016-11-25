package com.sales.util.exception;


/**
 * @author Tiger-guo
 * 2016年11月16日 上午10:54:46
 */
public class CommonException extends RuntimeException

{
	private static final long serialVersionUID = 0xc1a865c45ffdc5f9L;

	public CommonException(String frdMessage) {
		super(frdMessage);
	}

	public CommonException(Throwable throwable){
		super(throwable);
	}

	public CommonException(String frdMessage,Throwable throwable){
		super(frdMessage,throwable);
	}
	
	
}
