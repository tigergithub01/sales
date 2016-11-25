package com.sales.service.business;

import java.util.List;

import com.sales.model.business.DrpCommissionRule;
import com.sales.util.pager.helper.PageInfo;
import com.sales.util.pager.helper.PaginatedListHelper;

public interface DrpCommissionRuleService {
	
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
    int insert(DrpCommissionRule record);

    /**
     * insertSelective
     * @param record
     * @return int
     */
    int insertSelective(DrpCommissionRule record);

    /**
     * selectByPrimaryKey
     * @param id
     * @return
     */
    DrpCommissionRule selectByPrimaryKey(Long id);
    
    /**
     * selectBySelective
     * @param record
     * @return
     */
    DrpCommissionRule selectBySelective(DrpCommissionRule record);

    /**
     * updateByPrimaryKeySelective
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(DrpCommissionRule record);

    /**
     * updateByPrimaryKey
     * @param record
     * @return
     */
    int updateByPrimaryKey(DrpCommissionRule record);
    
    
    /**
     * @param record
     * @return
     */
    public List<DrpCommissionRule> selectList(
			DrpCommissionRule record);
    /**
     * selectList
     * @param record
     * @return
     */
    public PaginatedListHelper selectList(
			DrpCommissionRule record,PageInfo pageInfo);
}
