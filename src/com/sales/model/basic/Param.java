package com.sales.model.basic;

import java.util.List;

public class Param {
	
	/**
	 * 主键列表：批量处理列表的时候用到
	 */
	private List<Long> ids;
	
	/**
	 * 主键
	 */
	private Long id;

	public List<Long> getIds() {
		return ids;
	}

	public void setIds(List<Long> ids) {
		this.ids = ids;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
	
	
	

}
