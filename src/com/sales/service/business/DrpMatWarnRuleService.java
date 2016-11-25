package com.sales.service.business;

import java.util.List;

import com.sales.model.business.DrpMatWarnRule;
import com.sales.util.pager.helper.PageInfo;
import com.sales.util.pager.helper.PaginatedListHelper;

public interface DrpMatWarnRuleService {
	
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
    int insert(DrpMatWarnRule record);

    /**
     * insertSelective
     * @param record
     * @return int
     */
    int insertSelective(DrpMatWarnRule record);

    /**
     * selectByPrimaryKey
     * @param id
     * @return
     */
    DrpMatWarnRule selectByPrimaryKey(Long id);
    
    /**
     * selectBySelective
     * @param record
     * @return
     */
    DrpMatWarnRule selectBySelective(DrpMatWarnRule record);

    /**
     * updateByPrimaryKeySelective
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(DrpMatWarnRule record);

    /**
     * updateByPrimaryKey
     * @param record
     * @return
     */
    int updateByPrimaryKey(DrpMatWarnRule record);
    
    
    /**
     * @param record
     * @return
     */
    public List<DrpMatWarnRule> selectList(
			DrpMatWarnRule record);
    /**
     * selectList
     * @param record
     * @return
     */
    public PaginatedListHelper selectList(
			DrpMatWarnRule record,PageInfo pageInfo);
}
