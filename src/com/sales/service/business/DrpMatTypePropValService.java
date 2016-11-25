package com.sales.service.business;

import java.util.List;

import com.sales.model.business.DrpMatTypePropVal;
import com.sales.util.pager.helper.PageInfo;
import com.sales.util.pager.helper.PaginatedListHelper;

public interface DrpMatTypePropValService {
	
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
    int insert(DrpMatTypePropVal record);

    /**
     * insertSelective
     * @param record
     * @return int
     */
    int insertSelective(DrpMatTypePropVal record);

    /**
     * selectByPrimaryKey
     * @param id
     * @return
     */
    DrpMatTypePropVal selectByPrimaryKey(Long id);
    
    /**
     * selectBySelective
     * @param record
     * @return
     */
    DrpMatTypePropVal selectBySelective(DrpMatTypePropVal record);

    /**
     * updateByPrimaryKeySelective
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(DrpMatTypePropVal record);

    /**
     * updateByPrimaryKey
     * @param record
     * @return
     */
    int updateByPrimaryKey(DrpMatTypePropVal record);
    
    
    /**
     * @param record
     * @return
     */
    public List<DrpMatTypePropVal> selectList(
			DrpMatTypePropVal record);
    /**
     * selectList
     * @param record
     * @return
     */
    public PaginatedListHelper selectList(
			DrpMatTypePropVal record,PageInfo pageInfo);
}
