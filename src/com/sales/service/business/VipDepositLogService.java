package com.sales.service.business;

import java.util.List;

import com.sales.model.business.VipDepositLog;
import com.sales.util.pager.helper.PageInfo;
import com.sales.util.pager.helper.PaginatedListHelper;

public interface VipDepositLogService {
	
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
    int insert(VipDepositLog record);

    /**
     * insertSelective
     * @param record
     * @return int
     */
    int insertSelective(VipDepositLog record);

    /**
     * selectByPrimaryKey
     * @param id
     * @return
     */
    VipDepositLog selectByPrimaryKey(Long id);
    
    /**
     * selectBySelective
     * @param record
     * @return
     */
    VipDepositLog selectBySelective(VipDepositLog record);

    /**
     * updateByPrimaryKeySelective
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(VipDepositLog record);

    /**
     * updateByPrimaryKey
     * @param record
     * @return
     */
    int updateByPrimaryKey(VipDepositLog record);
    
    
    /**
     * @param record
     * @return
     */
    public List<VipDepositLog> selectList(
			VipDepositLog record);
    /**
     * selectList
     * @param record
     * @return
     */
    public PaginatedListHelper selectList(
			VipDepositLog record,PageInfo pageInfo);
}
