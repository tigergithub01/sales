package com.sales.util.pager.dialect;

import org.springframework.util.StringUtils;

public class MySQLDialect implements Dialect {  
	  
    protected static final String SQL_END_DELIMITER = ";";  
  
  
    /**
	 * 
	 * original SQL script: select * from t_oa_bbs_messages
	 * 
	 * formatted SQL script:
	 * select * from t_oa_bbs_messages order by issue_date limit 11,10
	 */
    @Override
    public String getPaginationString(String sql, final int skipResults, final int maxResults) {  
       return this.getPaginationString(sql, skipResults, maxResults, null, null);
    }


	@Override
	public String getPaginationString(String sql, int skipResults,
			int maxResults, String sortColumn, String sortOrder) {
		sql = sql.trim();
        StringBuffer sb = new StringBuffer(sql.length() + 20);  
        sb.append(sql);  
        if(!StringUtils.isEmpty(sortColumn)){
        	if(StringUtils.isEmpty(sortOrder)){
            	sortOrder="asc";
    		}
        	
        	sb.append(" order by "+sortColumn+" "+sortOrder);
		}
        if (skipResults > 0) {  
            sb.append(" limit ").append(skipResults).append(',').append(maxResults)  
                    .append(SQL_END_DELIMITER);  
        } else {  
            sb.append(" limit ").append(maxResults).append(SQL_END_DELIMITER);  
        }  
        return sb.toString(); 
	}  
  

	
  
}  
