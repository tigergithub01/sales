package com.sales.service.business;

import java.util.List;

import com.sales.model.business.VipCoupon;
import com.sales.util.pager.helper.PageInfo;
import com.sales.util.pager.helper.PaginatedListHelper;

public interface VipCouponService {
	
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
    int insert(VipCoupon record);

    /**
     * insertSelective
     * @param record
     * @return int
     */
    int insertSelective(VipCoupon record);

    /**
     * selectByPrimaryKey
     * @param id
     * @return
     */
    VipCoupon selectByPrimaryKey(Long id);
    
    /**
     * selectBySelective
     * @param record
     * @return
     */
    VipCoupon selectBySelective(VipCoupon record);

    /**
     * updateByPrimaryKeySelective
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(VipCoupon record);

    /**
     * updateByPrimaryKey
     * @param record
     * @return
     */
    int updateByPrimaryKey(VipCoupon record);
    
    
    /**
     * @param record
     * @return
     */
    public List<VipCoupon> selectList(
			VipCoupon record);
    /**
     * selectList
     * @param record
     * @return
     */
    public PaginatedListHelper selectList(
			VipCoupon record,PageInfo pageInfo);
}
