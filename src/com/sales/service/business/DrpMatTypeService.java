package com.sales.service.business;

import java.util.List;

import com.sales.model.business.DrpMatType;
import com.sales.util.pager.helper.PageInfo;
import com.sales.util.pager.helper.PaginatedListHelper;

public interface DrpMatTypeService {
	
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
    int insert(DrpMatType record);

    /**
     * insertSelective
     * @param record
     * @return int
     */
    int insertSelective(DrpMatType record);

    /**
     * selectByPrimaryKey
     * @param id
     * @return
     */
    DrpMatType selectByPrimaryKey(Long id);
    
    /**
     * selectBySelective
     * @param record
     * @return
     */
    DrpMatType selectBySelective(DrpMatType record);

    /**
     * updateByPrimaryKeySelective
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(DrpMatType record);

    /**
     * updateByPrimaryKey
     * @param record
     * @return
     */
    int updateByPrimaryKey(DrpMatType record);
    
    
    /**
     * @param record
     * @return
     */
    public List<DrpMatType> selectList(
			DrpMatType record);
    /**
     * selectList
     * @param record
     * @return
     */
    public PaginatedListHelper selectList(
			DrpMatType record,PageInfo pageInfo);
}
