package com.sales.service.business;

import java.util.List;

import com.sales.model.business.SysAuditLog;
import com.sales.util.pager.helper.PageInfo;
import com.sales.util.pager.helper.PaginatedListHelper;

public interface SysAuditLogService {
	
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
    int insert(SysAuditLog record);

    /**
     * insertSelective
     * @param record
     * @return int
     */
    int insertSelective(SysAuditLog record);

    /**
     * selectByPrimaryKey
     * @param id
     * @return
     */
    SysAuditLog selectByPrimaryKey(Long id);
    
    /**
     * selectBySelective
     * @param record
     * @return
     */
    SysAuditLog selectBySelective(SysAuditLog record);

    /**
     * updateByPrimaryKeySelective
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(SysAuditLog record);

    /**
     * updateByPrimaryKey
     * @param record
     * @return
     */
    int updateByPrimaryKey(SysAuditLog record);
    
    
    /**
     * @param record
     * @return
     */
    public List<SysAuditLog> selectList(
			SysAuditLog record);
    /**
     * selectList
     * @param record
     * @return
     */
    public PaginatedListHelper selectList(
			SysAuditLog record,PageInfo pageInfo);
}
