package com.sales.service.business;

import java.util.List;

import com.sales.model.business.DrpMatPrice;
import com.sales.util.pager.helper.PageInfo;
import com.sales.util.pager.helper.PaginatedListHelper;

public interface DrpMatPriceService {
	
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
    int insert(DrpMatPrice record);

    /**
     * insertSelective
     * @param record
     * @return int
     */
    int insertSelective(DrpMatPrice record);

    /**
     * selectByPrimaryKey
     * @param id
     * @return
     */
    DrpMatPrice selectByPrimaryKey(Long id);
    
    /**
     * selectBySelective
     * @param record
     * @return
     */
    DrpMatPrice selectBySelective(DrpMatPrice record);

    /**
     * updateByPrimaryKeySelective
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(DrpMatPrice record);

    /**
     * updateByPrimaryKey
     * @param record
     * @return
     */
    int updateByPrimaryKey(DrpMatPrice record);
    
    
    /**
     * @param record
     * @return
     */
    public List<DrpMatPrice> selectList(
			DrpMatPrice record);
    /**
     * selectList
     * @param record
     * @return
     */
    public PaginatedListHelper selectList(
			DrpMatPrice record,PageInfo pageInfo);
}
