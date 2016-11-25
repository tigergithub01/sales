package com.sales.service.business;

import java.util.List;

import com.sales.model.business.DrpPosMachineLog;
import com.sales.util.pager.helper.PageInfo;
import com.sales.util.pager.helper.PaginatedListHelper;

public interface DrpPosMachineLogService {
	
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
    int insert(DrpPosMachineLog record);

    /**
     * insertSelective
     * @param record
     * @return int
     */
    int insertSelective(DrpPosMachineLog record);

    /**
     * selectByPrimaryKey
     * @param id
     * @return
     */
    DrpPosMachineLog selectByPrimaryKey(Long id);
    
    /**
     * selectBySelective
     * @param record
     * @return
     */
    DrpPosMachineLog selectBySelective(DrpPosMachineLog record);

    /**
     * updateByPrimaryKeySelective
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(DrpPosMachineLog record);

    /**
     * updateByPrimaryKey
     * @param record
     * @return
     */
    int updateByPrimaryKey(DrpPosMachineLog record);
    
    
    /**
     * @param record
     * @return
     */
    public List<DrpPosMachineLog> selectList(
			DrpPosMachineLog record);
    /**
     * selectList
     * @param record
     * @return
     */
    public PaginatedListHelper selectList(
			DrpPosMachineLog record,PageInfo pageInfo);
}
