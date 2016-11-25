package com.sales.service.business;

import java.util.List;

import com.sales.model.business.DrpSheet;
import com.sales.util.pager.helper.PageInfo;
import com.sales.util.pager.helper.PaginatedListHelper;

public interface DrpSheetService {
	
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
    int insert(DrpSheet record);

    /**
     * insertSelective
     * @param record
     * @return int
     */
    int insertSelective(DrpSheet record);

    /**
     * selectByPrimaryKey
     * @param id
     * @return
     */
    DrpSheet selectByPrimaryKey(Long id);
    
    /**
     * selectBySelective
     * @param record
     * @return
     */
    DrpSheet selectBySelective(DrpSheet record);

    /**
     * updateByPrimaryKeySelective
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(DrpSheet record);

    /**
     * updateByPrimaryKey
     * @param record
     * @return
     */
    int updateByPrimaryKey(DrpSheet record);
    
    
    /**
     * @param record
     * @return
     */
    public List<DrpSheet> selectList(
			DrpSheet record);
    /**
     * selectList
     * @param record
     * @return
     */
    public PaginatedListHelper selectList(
			DrpSheet record,PageInfo pageInfo);
}
