package com.sales.service.business;

import java.util.List;

import com.sales.model.business.OaSheetWkfData;
import com.sales.util.pager.helper.PageInfo;
import com.sales.util.pager.helper.PaginatedListHelper;

public interface OaSheetWkfDataService {
	
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
    int insert(OaSheetWkfData record);

    /**
     * insertSelective
     * @param record
     * @return int
     */
    int insertSelective(OaSheetWkfData record);

    /**
     * selectByPrimaryKey
     * @param id
     * @return
     */
    OaSheetWkfData selectByPrimaryKey(Long id);
    
    /**
     * selectBySelective
     * @param record
     * @return
     */
    OaSheetWkfData selectBySelective(OaSheetWkfData record);

    /**
     * updateByPrimaryKeySelective
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(OaSheetWkfData record);

    /**
     * updateByPrimaryKey
     * @param record
     * @return
     */
    int updateByPrimaryKey(OaSheetWkfData record);
    
    
    /**
     * @param record
     * @return
     */
    public List<OaSheetWkfData> selectList(
			OaSheetWkfData record);
    /**
     * selectList
     * @param record
     * @return
     */
    public PaginatedListHelper selectList(
			OaSheetWkfData record,PageInfo pageInfo);
}
