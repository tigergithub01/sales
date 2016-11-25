package com.sales.service.business;

import java.util.List;

import com.sales.model.business.SysUnit;
import com.sales.util.pager.helper.PageInfo;
import com.sales.util.pager.helper.PaginatedListHelper;

public interface SysUnitService {
	
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
    int insert(SysUnit record);

    /**
     * insertSelective
     * @param record
     * @return int
     */
    int insertSelective(SysUnit record);

    /**
     * selectByPrimaryKey
     * @param id
     * @return
     */
    SysUnit selectByPrimaryKey(Long id);
    
    /**
     * selectBySelective
     * @param record
     * @return
     */
    SysUnit selectBySelective(SysUnit record);

    /**
     * updateByPrimaryKeySelective
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(SysUnit record);

    /**
     * updateByPrimaryKey
     * @param record
     * @return
     */
    int updateByPrimaryKey(SysUnit record);
    
    
    /**
     * @param record
     * @return
     */
    public List<SysUnit> selectList(
			SysUnit record);
    /**
     * selectList
     * @param record
     * @return
     */
    public PaginatedListHelper selectList(
			SysUnit record,PageInfo pageInfo);
}
