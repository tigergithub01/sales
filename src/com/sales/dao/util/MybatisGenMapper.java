package com.sales.dao.util;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sales.model.util.meta.MetaCol;
import com.sales.model.util.meta.MetaFk;
import com.sales.model.util.meta.MetaTbl;

public interface MybatisGenMapper {
    
	List<MetaTbl> getTableList(@Param("tableName") String tableName);
	
	MetaTbl getTableInfo(@Param("tableName") String tableName);
	
    /**
     * @param record
     * @param page
     * @return
     */
    List<MetaCol> getColumnList(@Param("tableName") String tableName);
    
    
    List<MetaFk> getColumnFKList(@Param("tableName") String tableName);
    
    String getTablePK(@Param("tableName") String tableName);
    
    List<String> getReferencedTbls(@Param("tableName") String tableName);
    
    Integer getColCountInTable(@Param("tableName") String tableName, @Param("columnName") String columnName);
    
    
    
    
    
}