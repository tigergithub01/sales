package com.sales.service.business;

import java.util.List;

import com.sales.model.business.VipExchangeLog;
import com.sales.util.pager.helper.PageInfo;
import com.sales.util.pager.helper.PaginatedListHelper;

public interface VipExchangeLogService {
	
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
    int insert(VipExchangeLog record);

    /**
     * insertSelective
     * @param record
     * @return int
     */
    int insertSelective(VipExchangeLog record);

    /**
     * selectByPrimaryKey
     * @param id
     * @return
     */
    VipExchangeLog selectByPrimaryKey(Long id);
    
    /**
     * selectBySelective
     * @param record
     * @return
     */
    VipExchangeLog selectBySelective(VipExchangeLog record);

    /**
     * updateByPrimaryKeySelective
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(VipExchangeLog record);

    /**
     * updateByPrimaryKey
     * @param record
     * @return
     */
    int updateByPrimaryKey(VipExchangeLog record);
    
    
    /**
     * @param record
     * @return
     */
    public List<VipExchangeLog> selectList(
			VipExchangeLog record);
    /**
     * selectList
     * @param record
     * @return
     */
    public PaginatedListHelper selectList(
			VipExchangeLog record,PageInfo pageInfo);
}
