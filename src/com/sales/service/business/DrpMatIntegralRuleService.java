package com.sales.service.business;

import java.util.List;

import com.sales.model.business.DrpMatIntegralRule;
import com.sales.util.pager.helper.PageInfo;
import com.sales.util.pager.helper.PaginatedListHelper;

public interface DrpMatIntegralRuleService {
	
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
    int insert(DrpMatIntegralRule record);

    /**
     * insertSelective
     * @param record
     * @return int
     */
    int insertSelective(DrpMatIntegralRule record);

    /**
     * selectByPrimaryKey
     * @param id
     * @return
     */
    DrpMatIntegralRule selectByPrimaryKey(Long id);
    
    /**
     * selectBySelective
     * @param record
     * @return
     */
    DrpMatIntegralRule selectBySelective(DrpMatIntegralRule record);

    /**
     * updateByPrimaryKeySelective
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(DrpMatIntegralRule record);

    /**
     * updateByPrimaryKey
     * @param record
     * @return
     */
    int updateByPrimaryKey(DrpMatIntegralRule record);
    
    
    /**
     * @param record
     * @return
     */
    public List<DrpMatIntegralRule> selectList(
			DrpMatIntegralRule record);
    /**
     * selectList
     * @param record
     * @return
     */
    public PaginatedListHelper selectList(
			DrpMatIntegralRule record,PageInfo pageInfo);
}
