package com.sales.service.business;

import java.util.List;

import com.sales.model.business.ActType;
import com.sales.util.pager.helper.PageInfo;
import com.sales.util.pager.helper.PaginatedListHelper;

public interface ActTypeService {
	
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
    int insert(ActType record);

    /**
     * insertSelective
     * @param record
     * @return int
     */
    int insertSelective(ActType record);

    /**
     * selectByPrimaryKey
     * @param id
     * @return
     */
    ActType selectByPrimaryKey(Long id);
    
    /**
     * selectBySelective
     * @param record
     * @return
     */
    ActType selectBySelective(ActType record);

    /**
     * updateByPrimaryKeySelective
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(ActType record);

    /**
     * updateByPrimaryKey
     * @param record
     * @return
     */
    int updateByPrimaryKey(ActType record);
    
    
    /**
     * @param record
     * @return
     */
    public List<ActType> selectList(
			ActType record);
    /**
     * selectList
     * @param record
     * @return
     */
    public PaginatedListHelper selectList(
			ActType record,PageInfo pageInfo);
}
