package com.sales.service.business;

import java.util.List;

import com.sales.model.business.VipDeposit;
import com.sales.util.pager.helper.PageInfo;
import com.sales.util.pager.helper.PaginatedListHelper;

public interface VipDepositService {
	
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
    int insert(VipDeposit record);

    /**
     * insertSelective
     * @param record
     * @return int
     */
    int insertSelective(VipDeposit record);

    /**
     * selectByPrimaryKey
     * @param id
     * @return
     */
    VipDeposit selectByPrimaryKey(Long id);
    
    /**
     * selectBySelective
     * @param record
     * @return
     */
    VipDeposit selectBySelective(VipDeposit record);

    /**
     * updateByPrimaryKeySelective
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(VipDeposit record);

    /**
     * updateByPrimaryKey
     * @param record
     * @return
     */
    int updateByPrimaryKey(VipDeposit record);
    
    
    /**
     * @param record
     * @return
     */
    public List<VipDeposit> selectList(
			VipDeposit record);
    /**
     * selectList
     * @param record
     * @return
     */
    public PaginatedListHelper selectList(
			VipDeposit record,PageInfo pageInfo);
}
