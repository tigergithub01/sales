package com.sales.service.business;

import java.util.List;

import com.sales.model.business.DrpMatVipPriceRegular;
import com.sales.util.pager.helper.PageInfo;
import com.sales.util.pager.helper.PaginatedListHelper;

public interface DrpMatVipPriceRegularService {
	
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
    int insert(DrpMatVipPriceRegular record);

    /**
     * insertSelective
     * @param record
     * @return int
     */
    int insertSelective(DrpMatVipPriceRegular record);

    /**
     * selectByPrimaryKey
     * @param id
     * @return
     */
    DrpMatVipPriceRegular selectByPrimaryKey(Long id);
    
    /**
     * selectBySelective
     * @param record
     * @return
     */
    DrpMatVipPriceRegular selectBySelective(DrpMatVipPriceRegular record);

    /**
     * updateByPrimaryKeySelective
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(DrpMatVipPriceRegular record);

    /**
     * updateByPrimaryKey
     * @param record
     * @return
     */
    int updateByPrimaryKey(DrpMatVipPriceRegular record);
    
    
    /**
     * @param record
     * @return
     */
    public List<DrpMatVipPriceRegular> selectList(
			DrpMatVipPriceRegular record);
    /**
     * selectList
     * @param record
     * @return
     */
    public PaginatedListHelper selectList(
			DrpMatVipPriceRegular record,PageInfo pageInfo);
}
