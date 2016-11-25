package com.sales.service.business;

import java.util.List;

import com.sales.model.business.ActRule;
import com.sales.util.pager.helper.PageInfo;
import com.sales.util.pager.helper.PaginatedListHelper;

public interface ActRuleService {
	
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
    int insert(ActRule record);

    /**
     * insertSelective
     * @param record
     * @return int
     */
    int insertSelective(ActRule record);

    /**
     * selectByPrimaryKey
     * @param id
     * @return
     */
    ActRule selectByPrimaryKey(Long id);
    
    /**
     * selectBySelective
     * @param record
     * @return
     */
    ActRule selectBySelective(ActRule record);

    /**
     * updateByPrimaryKeySelective
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(ActRule record);

    /**
     * updateByPrimaryKey
     * @param record
     * @return
     */
    int updateByPrimaryKey(ActRule record);
    
    
    /**
     * @param record
     * @return
     */
    public List<ActRule> selectList(
			ActRule record);
    /**
     * selectList
     * @param record
     * @return
     */
    public PaginatedListHelper selectList(
			ActRule record,PageInfo pageInfo);
}
