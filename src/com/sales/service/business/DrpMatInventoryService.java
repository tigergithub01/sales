package com.sales.service.business;

import java.util.List;

import com.sales.model.business.DrpMatInventory;
import com.sales.util.pager.helper.PageInfo;
import com.sales.util.pager.helper.PaginatedListHelper;

public interface DrpMatInventoryService {
	
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
    int insert(DrpMatInventory record);

    /**
     * insertSelective
     * @param record
     * @return int
     */
    int insertSelective(DrpMatInventory record);

    /**
     * selectByPrimaryKey
     * @param id
     * @return
     */
    DrpMatInventory selectByPrimaryKey(Long id);
    
    /**
     * selectBySelective
     * @param record
     * @return
     */
    DrpMatInventory selectBySelective(DrpMatInventory record);

    /**
     * updateByPrimaryKeySelective
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(DrpMatInventory record);

    /**
     * updateByPrimaryKey
     * @param record
     * @return
     */
    int updateByPrimaryKey(DrpMatInventory record);
    
    
    /**
     * @param record
     * @return
     */
    public List<DrpMatInventory> selectList(
			DrpMatInventory record);
    /**
     * selectList
     * @param record
     * @return
     */
    public PaginatedListHelper selectList(
			DrpMatInventory record,PageInfo pageInfo);
}
