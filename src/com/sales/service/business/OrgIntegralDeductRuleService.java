package com.sales.service.business;

import java.util.List;

import com.sales.model.business.OrgIntegralDeductRule;
import com.sales.util.pager.helper.PageInfo;
import com.sales.util.pager.helper.PaginatedListHelper;

public interface OrgIntegralDeductRuleService {
	
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
    int insert(OrgIntegralDeductRule record);

    /**
     * insertSelective
     * @param record
     * @return int
     */
    int insertSelective(OrgIntegralDeductRule record);

    /**
     * selectByPrimaryKey
     * @param id
     * @return
     */
    OrgIntegralDeductRule selectByPrimaryKey(Long id);
    
    /**
     * selectBySelective
     * @param record
     * @return
     */
    OrgIntegralDeductRule selectBySelective(OrgIntegralDeductRule record);

    /**
     * updateByPrimaryKeySelective
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(OrgIntegralDeductRule record);

    /**
     * updateByPrimaryKey
     * @param record
     * @return
     */
    int updateByPrimaryKey(OrgIntegralDeductRule record);
    
    
    /**
     * @param record
     * @return
     */
    public List<OrgIntegralDeductRule> selectList(
			OrgIntegralDeductRule record);
    /**
     * selectList
     * @param record
     * @return
     */
    public PaginatedListHelper selectList(
			OrgIntegralDeductRule record,PageInfo pageInfo);
}
