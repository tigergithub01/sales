package com.sales.service.business;

import java.util.List;

import com.sales.model.business.SysModule;
import com.sales.util.pager.helper.PageInfo;
import com.sales.util.pager.helper.PaginatedListHelper;

public interface SysModuleService {
	
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
    int insert(SysModule record);

    /**
     * insertSelective
     * @param record
     * @return int
     */
    int insertSelective(SysModule record);

    /**
     * selectByPrimaryKey
     * @param id
     * @return
     */
    SysModule selectByPrimaryKey(Long id);
    
    /**
     * selectBySelective
     * @param record
     * @return
     */
    SysModule selectBySelective(SysModule record);

    /**
     * updateByPrimaryKeySelective
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(SysModule record);

    /**
     * updateByPrimaryKey
     * @param record
     * @return
     */
    int updateByPrimaryKey(SysModule record);
    
    
    /**
     * @param record
     * @return
     */
    public List<SysModule> selectList(
			SysModule record);
    /**
     * selectList
     * @param record
     * @return
     */
    public PaginatedListHelper selectList(
			SysModule record,PageInfo pageInfo);
}
