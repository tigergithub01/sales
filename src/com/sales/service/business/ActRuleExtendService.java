package com.sales.service.business;

import java.util.List;

import com.sales.model.business.ActRuleExtend;
import com.sales.util.pager.helper.PageInfo;
import com.sales.util.pager.helper.PaginatedListHelper;

public interface ActRuleExtendService {
	
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
    int insert(ActRuleExtend record);

    /**
     * insertSelective
     * @param record
     * @return int
     */
    int insertSelective(ActRuleExtend record);

    /**
     * selectByPrimaryKey
     * @param id
     * @return
     */
    ActRuleExtend selectByPrimaryKey(Long id);
    
    /**
     * selectBySelective
     * @param record
     * @return
     */
    ActRuleExtend selectBySelective(ActRuleExtend record);

    /**
     * updateByPrimaryKeySelective
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(ActRuleExtend record);

    /**
     * updateByPrimaryKey
     * @param record
     * @return
     */
    int updateByPrimaryKey(ActRuleExtend record);
    
    
    /**
     * @param record
     * @return
     */
    public List<ActRuleExtend> selectList(
			ActRuleExtend record);
    /**
     * selectList
     * @param record
     * @return
     */
    public PaginatedListHelper selectList(
			ActRuleExtend record,PageInfo pageInfo);
}
