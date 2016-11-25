package com.sales.service.business;

import java.util.List;

import com.sales.model.business.DrpMatProperties;
import com.sales.util.pager.helper.PageInfo;
import com.sales.util.pager.helper.PaginatedListHelper;

public interface DrpMatPropertiesService {
	
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
    int insert(DrpMatProperties record);

    /**
     * insertSelective
     * @param record
     * @return int
     */
    int insertSelective(DrpMatProperties record);

    /**
     * selectByPrimaryKey
     * @param id
     * @return
     */
    DrpMatProperties selectByPrimaryKey(Long id);
    
    /**
     * selectBySelective
     * @param record
     * @return
     */
    DrpMatProperties selectBySelective(DrpMatProperties record);

    /**
     * updateByPrimaryKeySelective
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(DrpMatProperties record);

    /**
     * updateByPrimaryKey
     * @param record
     * @return
     */
    int updateByPrimaryKey(DrpMatProperties record);
    
    
    /**
     * @param record
     * @return
     */
    public List<DrpMatProperties> selectList(
			DrpMatProperties record);
    /**
     * selectList
     * @param record
     * @return
     */
    public PaginatedListHelper selectList(
			DrpMatProperties record,PageInfo pageInfo);
}
