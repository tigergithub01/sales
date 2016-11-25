package com.sales.service.business;

import java.util.List;

import com.sales.model.business.VipCouponLog;
import com.sales.util.pager.helper.PageInfo;
import com.sales.util.pager.helper.PaginatedListHelper;

public interface VipCouponLogService {
	
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
    int insert(VipCouponLog record);

    /**
     * insertSelective
     * @param record
     * @return int
     */
    int insertSelective(VipCouponLog record);

    /**
     * selectByPrimaryKey
     * @param id
     * @return
     */
    VipCouponLog selectByPrimaryKey(Long id);
    
    /**
     * selectBySelective
     * @param record
     * @return
     */
    VipCouponLog selectBySelective(VipCouponLog record);

    /**
     * updateByPrimaryKeySelective
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(VipCouponLog record);

    /**
     * updateByPrimaryKey
     * @param record
     * @return
     */
    int updateByPrimaryKey(VipCouponLog record);
    
    
    /**
     * @param record
     * @return
     */
    public List<VipCouponLog> selectList(
			VipCouponLog record);
    /**
     * selectList
     * @param record
     * @return
     */
    public PaginatedListHelper selectList(
			VipCouponLog record,PageInfo pageInfo);
}
