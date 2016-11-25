package com.sales.service.business;

import java.util.List;

import com.sales.model.business.SysRegion;
import com.sales.util.pager.helper.PageInfo;
import com.sales.util.pager.helper.PaginatedListHelper;

public interface SysRegionService {
	
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
    int insert(SysRegion record);

    /**
     * insertSelective
     * @param record
     * @return int
     */
    int insertSelective(SysRegion record);

    /**
     * selectByPrimaryKey
     * @param id
     * @return
     */
    SysRegion selectByPrimaryKey(Long id);
    
    /**
     * selectBySelective
     * @param record
     * @return
     */
    SysRegion selectBySelective(SysRegion record);

    /**
     * updateByPrimaryKeySelective
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(SysRegion record);

    /**
     * updateByPrimaryKey
     * @param record
     * @return
     */
    int updateByPrimaryKey(SysRegion record);
    
    
    /**
     * @param record
     * @return
     */
    public List<SysRegion> selectList(
			SysRegion record);
    /**
     * selectList
     * @param record
     * @return
     */
    public PaginatedListHelper selectList(
			SysRegion record,PageInfo pageInfo);
}
