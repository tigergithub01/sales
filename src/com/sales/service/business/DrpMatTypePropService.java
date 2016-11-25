package com.sales.service.business;

import java.util.List;

import com.sales.model.business.DrpMatTypeProp;
import com.sales.util.pager.helper.PageInfo;
import com.sales.util.pager.helper.PaginatedListHelper;

public interface DrpMatTypePropService {
	
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
    int insert(DrpMatTypeProp record);

    /**
     * insertSelective
     * @param record
     * @return int
     */
    int insertSelective(DrpMatTypeProp record);

    /**
     * selectByPrimaryKey
     * @param id
     * @return
     */
    DrpMatTypeProp selectByPrimaryKey(Long id);
    
    /**
     * selectBySelective
     * @param record
     * @return
     */
    DrpMatTypeProp selectBySelective(DrpMatTypeProp record);

    /**
     * updateByPrimaryKeySelective
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(DrpMatTypeProp record);

    /**
     * updateByPrimaryKey
     * @param record
     * @return
     */
    int updateByPrimaryKey(DrpMatTypeProp record);
    
    
    /**
     * @param record
     * @return
     */
    public List<DrpMatTypeProp> selectList(
			DrpMatTypeProp record);
    /**
     * selectList
     * @param record
     * @return
     */
    public PaginatedListHelper selectList(
			DrpMatTypeProp record,PageInfo pageInfo);
}
