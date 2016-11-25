package com.sales.service.business;

import java.util.List;

import com.sales.model.business.DrpInvCheckScheme;
import com.sales.util.pager.helper.PageInfo;
import com.sales.util.pager.helper.PaginatedListHelper;

public interface DrpInvCheckSchemeService {
	
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
    int insert(DrpInvCheckScheme record);

    /**
     * insertSelective
     * @param record
     * @return int
     */
    int insertSelective(DrpInvCheckScheme record);

    /**
     * selectByPrimaryKey
     * @param id
     * @return
     */
    DrpInvCheckScheme selectByPrimaryKey(Long id);
    
    /**
     * selectBySelective
     * @param record
     * @return
     */
    DrpInvCheckScheme selectBySelective(DrpInvCheckScheme record);

    /**
     * updateByPrimaryKeySelective
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(DrpInvCheckScheme record);

    /**
     * updateByPrimaryKey
     * @param record
     * @return
     */
    int updateByPrimaryKey(DrpInvCheckScheme record);
    
    
    /**
     * @param record
     * @return
     */
    public List<DrpInvCheckScheme> selectList(
			DrpInvCheckScheme record);
    /**
     * selectList
     * @param record
     * @return
     */
    public PaginatedListHelper selectList(
			DrpInvCheckScheme record,PageInfo pageInfo);
}
