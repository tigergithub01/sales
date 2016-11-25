package com.sales.service.business;

import java.util.List;

import com.sales.model.business.DrpSheetType;
import com.sales.util.pager.helper.PageInfo;
import com.sales.util.pager.helper.PaginatedListHelper;

public interface DrpSheetTypeService {
	
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
    int insert(DrpSheetType record);

    /**
     * insertSelective
     * @param record
     * @return int
     */
    int insertSelective(DrpSheetType record);

    /**
     * selectByPrimaryKey
     * @param id
     * @return
     */
    DrpSheetType selectByPrimaryKey(Long id);
    
    /**
     * selectBySelective
     * @param record
     * @return
     */
    DrpSheetType selectBySelective(DrpSheetType record);

    /**
     * updateByPrimaryKeySelective
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(DrpSheetType record);

    /**
     * updateByPrimaryKey
     * @param record
     * @return
     */
    int updateByPrimaryKey(DrpSheetType record);
    
    
    /**
     * @param record
     * @return
     */
    public List<DrpSheetType> selectList(
			DrpSheetType record);
    /**
     * selectList
     * @param record
     * @return
     */
    public PaginatedListHelper selectList(
			DrpSheetType record,PageInfo pageInfo);
}
