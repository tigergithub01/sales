package com.sales.service.business;

import java.util.List;

import com.sales.model.business.VipIntegralLog;
import com.sales.util.pager.helper.PageInfo;
import com.sales.util.pager.helper.PaginatedListHelper;

public interface VipIntegralLogService {
	
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
    int insert(VipIntegralLog record);

    /**
     * insertSelective
     * @param record
     * @return int
     */
    int insertSelective(VipIntegralLog record);

    /**
     * selectByPrimaryKey
     * @param id
     * @return
     */
    VipIntegralLog selectByPrimaryKey(Long id);
    
    /**
     * selectBySelective
     * @param record
     * @return
     */
    VipIntegralLog selectBySelective(VipIntegralLog record);

    /**
     * updateByPrimaryKeySelective
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(VipIntegralLog record);

    /**
     * updateByPrimaryKey
     * @param record
     * @return
     */
    int updateByPrimaryKey(VipIntegralLog record);
    
    
    /**
     * @param record
     * @return
     */
    public List<VipIntegralLog> selectList(
			VipIntegralLog record);
    /**
     * selectList
     * @param record
     * @return
     */
    public PaginatedListHelper selectList(
			VipIntegralLog record,PageInfo pageInfo);
}
