package com.sales.service.business;

import java.util.List;

import com.sales.model.business.DrpPosMachine;
import com.sales.util.pager.helper.PageInfo;
import com.sales.util.pager.helper.PaginatedListHelper;

public interface DrpPosMachineService {
	
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
    int insert(DrpPosMachine record);

    /**
     * insertSelective
     * @param record
     * @return int
     */
    int insertSelective(DrpPosMachine record);

    /**
     * selectByPrimaryKey
     * @param id
     * @return
     */
    DrpPosMachine selectByPrimaryKey(Long id);
    
    /**
     * selectBySelective
     * @param record
     * @return
     */
    DrpPosMachine selectBySelective(DrpPosMachine record);

    /**
     * updateByPrimaryKeySelective
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(DrpPosMachine record);

    /**
     * updateByPrimaryKey
     * @param record
     * @return
     */
    int updateByPrimaryKey(DrpPosMachine record);
    
    
    /**
     * @param record
     * @return
     */
    public List<DrpPosMachine> selectList(
			DrpPosMachine record);
    /**
     * selectList
     * @param record
     * @return
     */
    public PaginatedListHelper selectList(
			DrpPosMachine record,PageInfo pageInfo);
}
