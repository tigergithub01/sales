package com.sales.service.business;

import java.util.List;

import com.sales.model.business.Activity;
import com.sales.util.pager.helper.PageInfo;
import com.sales.util.pager.helper.PaginatedListHelper;

public interface ActivityService {
	
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
    int insert(Activity record);

    /**
     * insertSelective
     * @param record
     * @return int
     */
    int insertSelective(Activity record);

    /**
     * selectByPrimaryKey
     * @param id
     * @return
     */
    Activity selectByPrimaryKey(Long id);
    
    /**
     * selectBySelective
     * @param record
     * @return
     */
    Activity selectBySelective(Activity record);

    /**
     * updateByPrimaryKeySelective
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(Activity record);

    /**
     * updateByPrimaryKey
     * @param record
     * @return
     */
    int updateByPrimaryKey(Activity record);
    
    
    /**
     * @param record
     * @return
     */
    public List<Activity> selectList(
			Activity record);
    /**
     * selectList
     * @param record
     * @return
     */
    public PaginatedListHelper selectList(
			Activity record,PageInfo pageInfo);
}
