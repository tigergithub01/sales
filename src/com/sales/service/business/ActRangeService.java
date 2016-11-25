package com.sales.service.business;

import java.util.List;

import com.sales.model.business.ActRange;
import com.sales.util.pager.helper.PageInfo;
import com.sales.util.pager.helper.PaginatedListHelper;

public interface ActRangeService {
	
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
    int insert(ActRange record);

    /**
     * insertSelective
     * @param record
     * @return int
     */
    int insertSelective(ActRange record);

    /**
     * selectByPrimaryKey
     * @param id
     * @return
     */
    ActRange selectByPrimaryKey(Long id);
    
    /**
     * selectBySelective
     * @param record
     * @return
     */
    ActRange selectBySelective(ActRange record);

    /**
     * updateByPrimaryKeySelective
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(ActRange record);

    /**
     * updateByPrimaryKey
     * @param record
     * @return
     */
    int updateByPrimaryKey(ActRange record);
    
    
    /**
     * @param record
     * @return
     */
    public List<ActRange> selectList(
			ActRange record);
    /**
     * selectList
     * @param record
     * @return
     */
    public PaginatedListHelper selectList(
			ActRange record,PageInfo pageInfo);
}
