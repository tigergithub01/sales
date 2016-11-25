package com.sales.service.business;

import java.util.List;

import com.sales.model.business.VipCard;
import com.sales.util.pager.helper.PageInfo;
import com.sales.util.pager.helper.PaginatedListHelper;

public interface VipCardService {
	
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
    int insert(VipCard record);

    /**
     * insertSelective
     * @param record
     * @return int
     */
    int insertSelective(VipCard record);

    /**
     * selectByPrimaryKey
     * @param id
     * @return
     */
    VipCard selectByPrimaryKey(Long id);
    
    /**
     * selectBySelective
     * @param record
     * @return
     */
    VipCard selectBySelective(VipCard record);

    /**
     * updateByPrimaryKeySelective
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(VipCard record);

    /**
     * updateByPrimaryKey
     * @param record
     * @return
     */
    int updateByPrimaryKey(VipCard record);
    
    
    /**
     * @param record
     * @return
     */
    public List<VipCard> selectList(
			VipCard record);
    /**
     * selectList
     * @param record
     * @return
     */
    public PaginatedListHelper selectList(
			VipCard record,PageInfo pageInfo);
}
