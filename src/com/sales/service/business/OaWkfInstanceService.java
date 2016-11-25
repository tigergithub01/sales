package com.sales.service.business;

import java.util.List;

import com.sales.model.business.OaWkfInstance;
import com.sales.util.pager.helper.PageInfo;
import com.sales.util.pager.helper.PaginatedListHelper;

public interface OaWkfInstanceService {
	
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
    int insert(OaWkfInstance record);

    /**
     * insertSelective
     * @param record
     * @return int
     */
    int insertSelective(OaWkfInstance record);

    /**
     * selectByPrimaryKey
     * @param id
     * @return
     */
    OaWkfInstance selectByPrimaryKey(Long id);
    
    /**
     * selectBySelective
     * @param record
     * @return
     */
    OaWkfInstance selectBySelective(OaWkfInstance record);

    /**
     * updateByPrimaryKeySelective
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(OaWkfInstance record);

    /**
     * updateByPrimaryKey
     * @param record
     * @return
     */
    int updateByPrimaryKey(OaWkfInstance record);
    
    
    /**
     * @param record
     * @return
     */
    public List<OaWkfInstance> selectList(
			OaWkfInstance record);
    /**
     * selectList
     * @param record
     * @return
     */
    public PaginatedListHelper selectList(
			OaWkfInstance record,PageInfo pageInfo);
}
