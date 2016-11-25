package com.sales.service.business;

import java.util.List;

import com.sales.model.business.DrpCommissionRuleUser;
import com.sales.util.pager.helper.PageInfo;
import com.sales.util.pager.helper.PaginatedListHelper;

public interface DrpCommissionRuleUserService {
	
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
    int insert(DrpCommissionRuleUser record);

    /**
     * insertSelective
     * @param record
     * @return int
     */
    int insertSelective(DrpCommissionRuleUser record);

    /**
     * selectByPrimaryKey
     * @param id
     * @return
     */
    DrpCommissionRuleUser selectByPrimaryKey(Long id);
    
    /**
     * selectBySelective
     * @param record
     * @return
     */
    DrpCommissionRuleUser selectBySelective(DrpCommissionRuleUser record);

    /**
     * updateByPrimaryKeySelective
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(DrpCommissionRuleUser record);

    /**
     * updateByPrimaryKey
     * @param record
     * @return
     */
    int updateByPrimaryKey(DrpCommissionRuleUser record);
    
    
    /**
     * @param record
     * @return
     */
    public List<DrpCommissionRuleUser> selectList(
			DrpCommissionRuleUser record);
    /**
     * selectList
     * @param record
     * @return
     */
    public PaginatedListHelper selectList(
			DrpCommissionRuleUser record,PageInfo pageInfo);
}
