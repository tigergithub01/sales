package com.sales.util.pager.helper;

import java.util.List;

public class PaginatedListHelper {

	private List list;
	private int fullListSize;
	private int pageSize;
	private int pageNumber;
	private String sortColumn;
	private String sortOrder;

	public List getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}

	public int getFullListSize() {
		return fullListSize;
	}

	public void setFullListSize(int fullListSize) {
		this.fullListSize = fullListSize;
	}

	public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	public String getSortColumn() {
		return sortColumn;
	}

	public void setSortColumn(String sortColumn) {
		this.sortColumn = sortColumn;
	}

	public String getSortOrder() {
		return sortOrder;
	}

	public void setSortOrder(String sortOrder) {
		this.sortOrder = sortOrder;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

}
