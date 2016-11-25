package com.sales.util.pager.dialect;

import org.springframework.util.StringUtils;

public class MsSQL2005Dialect implements Dialect {

	
	/**
	 * 
	 * original SQL script: select * from t_oa_bbs_messages
	 * 
	 * formatted SQL script:
	 * select * from (
			select ROW_NUMBER() over (order by a.issue_date desc ) as [ROW_NUMBER],a.* 
			from (select * from t_oa_bbs_messages) a
		) b
		where [ROW_NUMBER] BETWEEN 11 AND 20
	 */
	
	
	@Override
	public String getPaginationString(String sql, int skipResults,
			int maxResults) {
		return this.getPaginationString(sql, skipResults, maxResults, null, null);
	}

	@Override
	public String getPaginationString(String sql, int skipResults,
			int maxResults, String sortColumn, String sortOrder) {
		// TODO Auto-generated method stub
		int startIndex  = skipResults+1;
		int endIndex = skipResults +maxResults;
		if(StringUtils.isEmpty(sortOrder)){
			sortOrder="asc";
		}
		if(StringUtils.isEmpty(sortColumn)){
			//TODO: may have not column named "id"
			sortColumn="id";
		}
		StringBuffer sb = new StringBuffer();
		sb.append("select * from (");
		sb.append("select ROW_NUMBER() over (order by a."+sortColumn+" "+sortOrder+" ) as [ROW_NUMBER],a.* ");
		sb.append("from ("+sql+") a");
		sb.append(") b ");
		sb.append("where [ROW_NUMBER] BETWEEN "+startIndex+" AND "+endIndex);
		return sb.toString();
	}
	
	
	
  
}  
