package com.sales.service.business;

import java.util.List;

import com.sales.model.business.DrpMatVipPrice;
import com.sales.util.pager.helper.PageInfo;
import com.sales.util.pager.helper.PaginatedListHelper;

public interface DrpMatVipPriceService {
	
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
    int insert(DrpMatVipPrice record);

    /**
     * insertSelective
     * @param record
     * @return int
     */
    int insertSelective(DrpMatVipPrice record);

    /**
     * selectByPrimaryKey
     * @param id
     * @return
     */
    DrpMatVipPrice selectByPrimaryKey(Long id);
    
    /**
     * selectBySelective
     * @param record
     * @return
     */
    DrpMatVipPrice selectBySelective(DrpMatVipPrice record);

    /**
     * updateByPrimaryKeySelective
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(DrpMatVipPrice record);

    /**
     * updateByPrimaryKey
     * @param record
     * @return
     */
    int updateByPrimaryKey(DrpMatVipPrice record);
    
    
    /**
     * @param record
     * @return
     */
    public List<DrpMatVipPrice> selectList(
			DrpMatVipPrice record);
    /**
     * selectList
     * @param record
     * @return
     */
    public PaginatedListHelper selectList(
			DrpMatVipPrice record,PageInfo pageInfo);
}
