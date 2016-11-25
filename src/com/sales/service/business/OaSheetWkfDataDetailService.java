package com.sales.service.business;

import java.util.List;

import com.sales.model.business.OaSheetWkfDataDetail;
import com.sales.util.pager.helper.PageInfo;
import com.sales.util.pager.helper.PaginatedListHelper;

public interface OaSheetWkfDataDetailService {
	
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
    int insert(OaSheetWkfDataDetail record);

    /**
     * insertSelective
     * @param record
     * @return int
     */
    int insertSelective(OaSheetWkfDataDetail record);

    /**
     * selectByPrimaryKey
     * @param id
     * @return
     */
    OaSheetWkfDataDetail selectByPrimaryKey(Long id);
    
    /**
     * selectBySelective
     * @param record
     * @return
     */
    OaSheetWkfDataDetail selectBySelective(OaSheetWkfDataDetail record);

    /**
     * updateByPrimaryKeySelective
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(OaSheetWkfDataDetail record);

    /**
     * updateByPrimaryKey
     * @param record
     * @return
     */
    int updateByPrimaryKey(OaSheetWkfDataDetail record);
    
    
    /**
     * @param record
     * @return
     */
    public List<OaSheetWkfDataDetail> selectList(
			OaSheetWkfDataDetail record);
    /**
     * selectList
     * @param record
     * @return
     */
    public PaginatedListHelper selectList(
			OaSheetWkfDataDetail record,PageInfo pageInfo);
}
