package com.sales.service.business;

import java.util.List;

import com.sales.model.business.DrpSheetDetail;
import com.sales.util.pager.helper.PageInfo;
import com.sales.util.pager.helper.PaginatedListHelper;

public interface DrpSheetDetailService {
	
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
    int insert(DrpSheetDetail record);

    /**
     * insertSelective
     * @param record
     * @return int
     */
    int insertSelective(DrpSheetDetail record);

    /**
     * selectByPrimaryKey
     * @param id
     * @return
     */
    DrpSheetDetail selectByPrimaryKey(Long id);
    
    /**
     * selectBySelective
     * @param record
     * @return
     */
    DrpSheetDetail selectBySelective(DrpSheetDetail record);

    /**
     * updateByPrimaryKeySelective
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(DrpSheetDetail record);

    /**
     * updateByPrimaryKey
     * @param record
     * @return
     */
    int updateByPrimaryKey(DrpSheetDetail record);
    
    
    /**
     * @param record
     * @return
     */
    public List<DrpSheetDetail> selectList(
			DrpSheetDetail record);
    /**
     * selectList
     * @param record
     * @return
     */
    public PaginatedListHelper selectList(
			DrpSheetDetail record,PageInfo pageInfo);
}
