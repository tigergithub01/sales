package com.sales.service.business;

import java.util.List;

import com.sales.model.business.SysTaskQuartz;
import com.sales.util.pager.helper.PageInfo;
import com.sales.util.pager.helper.PaginatedListHelper;

public interface SysTaskQuartzService {
	
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
    int insert(SysTaskQuartz record);

    /**
     * insertSelective
     * @param record
     * @return int
     */
    int insertSelective(SysTaskQuartz record);

    /**
     * selectByPrimaryKey
     * @param id
     * @return
     */
    SysTaskQuartz selectByPrimaryKey(Long id);
    
    /**
     * selectBySelective
     * @param record
     * @return
     */
    SysTaskQuartz selectBySelective(SysTaskQuartz record);

    /**
     * updateByPrimaryKeySelective
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(SysTaskQuartz record);

    /**
     * updateByPrimaryKey
     * @param record
     * @return
     */
    int updateByPrimaryKey(SysTaskQuartz record);
    
    
    /**
     * @param record
     * @return
     */
    public List<SysTaskQuartz> selectList(
			SysTaskQuartz record);
    /**
     * selectList
     * @param record
     * @return
     */
    public PaginatedListHelper selectList(
			SysTaskQuartz record,PageInfo pageInfo);
}
