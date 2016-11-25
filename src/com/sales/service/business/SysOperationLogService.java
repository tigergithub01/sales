package com.sales.service.business;

import java.util.List;

import com.sales.model.business.SysOperationLog;
import com.sales.util.pager.helper.PageInfo;
import com.sales.util.pager.helper.PaginatedListHelper;

public interface SysOperationLogService {
	
	/**
	 * deleteByPrimaryKey
	 * @param id
	 * @return int
	 */
	int deleteByPrimaryKey(Long id);

   /**
    * insert
    * @param record
    * @return int
    */
    int insert(SysOperationLog record);

    /**
     * insertSelective
     * @param record
     * @return int
     */
    int insertSelective(SysOperationLog record);

    /**
     * selectByPrimaryKey
     * @param id
     * @return
     */
    SysOperationLog selectByPrimaryKey(Long id);
    
    /**
     * selectBySelective
     * @param record
     * @return
     */
    SysOperationLog selectBySelective(SysOperationLog record);

    /**
     * updateByPrimaryKeySelective
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(SysOperationLog record);

    /**
     * updateByPrimaryKey
     * @param record
     * @return
     */
    int updateByPrimaryKey(SysOperationLog record);
    
    
    /**
     * @param record
     * @return
     */
    public List<SysOperationLog> selectList(
			SysOperationLog record);
    /**
     * selectList
     * @param record
     * @return
     */
    public PaginatedListHelper selectList(
			SysOperationLog record,PageInfo pageInfo);
}
