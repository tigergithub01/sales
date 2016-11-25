package com.sales.service.business;

import java.util.List;

import com.sales.model.business.SysOperation;
import com.sales.util.pager.helper.PageInfo;
import com.sales.util.pager.helper.PaginatedListHelper;

public interface SysOperationService {
	
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
    int insert(SysOperation record);

    /**
     * insertSelective
     * @param record
     * @return int
     */
    int insertSelective(SysOperation record);

    /**
     * selectByPrimaryKey
     * @param id
     * @return
     */
    SysOperation selectByPrimaryKey(Long id);
    
    /**
     * selectBySelective
     * @param record
     * @return
     */
    SysOperation selectBySelective(SysOperation record);

    /**
     * updateByPrimaryKeySelective
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(SysOperation record);

    /**
     * updateByPrimaryKey
     * @param record
     * @return
     */
    int updateByPrimaryKey(SysOperation record);
    
    
    /**
     * @param record
     * @return
     */
    public List<SysOperation> selectList(
			SysOperation record);
    /**
     * selectList
     * @param record
     * @return
     */
    public PaginatedListHelper selectList(
			SysOperation record,PageInfo pageInfo);
}
