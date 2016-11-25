package com.sales.service.business;

import java.util.List;

import com.sales.model.business.OaWkf;
import com.sales.util.pager.helper.PageInfo;
import com.sales.util.pager.helper.PaginatedListHelper;

public interface OaWkfService {
	
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
    int insert(OaWkf record);

    /**
     * insertSelective
     * @param record
     * @return int
     */
    int insertSelective(OaWkf record);

    /**
     * selectByPrimaryKey
     * @param id
     * @return
     */
    OaWkf selectByPrimaryKey(Long id);
    
    /**
     * selectBySelective
     * @param record
     * @return
     */
    OaWkf selectBySelective(OaWkf record);

    /**
     * updateByPrimaryKeySelective
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(OaWkf record);

    /**
     * updateByPrimaryKey
     * @param record
     * @return
     */
    int updateByPrimaryKey(OaWkf record);
    
    
    /**
     * @param record
     * @return
     */
    public List<OaWkf> selectList(
			OaWkf record);
    /**
     * selectList
     * @param record
     * @return
     */
    public PaginatedListHelper selectList(
			OaWkf record,PageInfo pageInfo);
}
