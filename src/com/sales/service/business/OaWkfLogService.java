package com.sales.service.business;

import java.util.List;

import com.sales.model.business.OaWkfLog;
import com.sales.util.pager.helper.PageInfo;
import com.sales.util.pager.helper.PaginatedListHelper;

public interface OaWkfLogService {
	
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
    int insert(OaWkfLog record);

    /**
     * insertSelective
     * @param record
     * @return int
     */
    int insertSelective(OaWkfLog record);

    /**
     * selectByPrimaryKey
     * @param id
     * @return
     */
    OaWkfLog selectByPrimaryKey(Long id);
    
    /**
     * selectBySelective
     * @param record
     * @return
     */
    OaWkfLog selectBySelective(OaWkfLog record);

    /**
     * updateByPrimaryKeySelective
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(OaWkfLog record);

    /**
     * updateByPrimaryKey
     * @param record
     * @return
     */
    int updateByPrimaryKey(OaWkfLog record);
    
    
    /**
     * @param record
     * @return
     */
    public List<OaWkfLog> selectList(
			OaWkfLog record);
    /**
     * selectList
     * @param record
     * @return
     */
    public PaginatedListHelper selectList(
			OaWkfLog record,PageInfo pageInfo);
}
