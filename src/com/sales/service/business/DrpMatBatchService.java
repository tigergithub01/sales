package com.sales.service.business;

import java.util.List;

import com.sales.model.business.DrpMatBatch;
import com.sales.util.pager.helper.PageInfo;
import com.sales.util.pager.helper.PaginatedListHelper;

public interface DrpMatBatchService {
	
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
    int insert(DrpMatBatch record);

    /**
     * insertSelective
     * @param record
     * @return int
     */
    int insertSelective(DrpMatBatch record);

    /**
     * selectByPrimaryKey
     * @param id
     * @return
     */
    DrpMatBatch selectByPrimaryKey(Long id);
    
    /**
     * selectBySelective
     * @param record
     * @return
     */
    DrpMatBatch selectBySelective(DrpMatBatch record);

    /**
     * updateByPrimaryKeySelective
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(DrpMatBatch record);

    /**
     * updateByPrimaryKey
     * @param record
     * @return
     */
    int updateByPrimaryKey(DrpMatBatch record);
    
    
    /**
     * @param record
     * @return
     */
    public List<DrpMatBatch> selectList(
			DrpMatBatch record);
    /**
     * selectList
     * @param record
     * @return
     */
    public PaginatedListHelper selectList(
			DrpMatBatch record,PageInfo pageInfo);
}
