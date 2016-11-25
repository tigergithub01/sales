package com.sales.util.pager.dialect;

/**
 * 
* @ClassName: Dialect
* @Description: TODO: SQLSERVER 2000 is not supported now because of the pagination SQL script.
* @author Tiger.guo
* @date 2013-4-12 下午05:42:15
*
 */
public interface Dialect {

	public static enum Type {

		MYSQL,

		ORACLE

	}

	public String getPaginationString(String sql, final int skipResults,
			final int maxResults);

	public String getPaginationString(String sql, final int skipResults,
			final int maxResults, final String sortColumn,
			final String sortOrder);

}
