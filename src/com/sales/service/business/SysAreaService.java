package com.sales.service.business;

import java.util.List;

import com.sales.model.business.SysArea;
import com.sales.util.pager.helper.PageInfo;
import com.sales.util.pager.helper.PaginatedListHelper;

public interface SysAreaService {
	
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
    int insert(SysArea record);

    /**
     * insertSelective
     * @param record
     * @return int
     */
    int insertSelective(SysArea record);

    /**
     * selectByPrimaryKey
     * @param id
     * @return
     */
    SysArea selectByPrimaryKey(Long id);
    
    /**
     * selectBySelective
     * @param record
     * @return
     */
    SysArea selectBySelective(SysArea record);

    /**
     * updateByPrimaryKeySelective
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(SysArea record);

    /**
     * updateByPrimaryKey
     * @param record
     * @return
     */
    int updateByPrimaryKey(SysArea record);
    
    
    /**
     * @param record
     * @return
     */
    public List<SysArea> selectList(
			SysArea record);
    /**
     * selectList
     * @param record
     * @return
     */
    public PaginatedListHelper selectList(
			SysArea record,PageInfo pageInfo);
}
