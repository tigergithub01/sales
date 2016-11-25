package com.sales.util.pager.dialect;

import org.springframework.util.StringUtils;

public class OracleDialect implements Dialect {

	
	/**
	 * 
	 * original SQL script: select * from t_oa_bbs_messages
	 * 
	 * formatted SQL script:
	 * select * from ( select row_.*, rownum rownum_ from ( 
			select * from t_oa_bbs_messages order by issue_date 
	   ) row_ ) where rownum_ > 10  and rownum_ <= 20
	 */
	
	
	@Override
	public String getPaginationString(String sql, int skipResults,
			int maxResults) {
		// TODO Auto-generated method stub
		sql = sql.trim();  
        StringBuffer sb = new StringBuffer(sql.length() + 100);  
        sb.append("select * from ( select row_.*, rownum rownum_ from ( ");  
        sb.append(sql);  
        sb.append(" ) row_ ) where rownum_ > ").append(skipResults).append(" and rownum_ <= ").append(skipResults + maxResults);  
        return sb.toString();  
	}

	@Override
	public String getPaginationString(String sql, int skipResults,
			int maxResults, String sortColumn, String sortOrder) {
		sql = sql.trim();  
        StringBuffer sb = new StringBuffer(sql.length() + 100);  
        sb.append("select * from ( select row_.*, rownum rownum_ from ( ");  
        sb.append(sql);  
        if(!StringUtils.isEmpty(sortColumn)){
        	if(StringUtils.isEmpty(sortOrder)){
            	sortOrder="asc";
    		}
        	sb.append(" order by "+sortColumn+" "+sortOrder);
		}
        sb.append(" ) row_ ) where rownum_ > ").append(skipResults).append(" and rownum_ <= ").append(skipResults + maxResults);  
        return sb.toString();  
	}
	
    
  
}  
