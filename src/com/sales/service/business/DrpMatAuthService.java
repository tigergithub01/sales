package com.sales.service.business;

import java.util.List;

import com.sales.model.business.DrpMatAuth;
import com.sales.util.pager.helper.PageInfo;
import com.sales.util.pager.helper.PaginatedListHelper;

public interface DrpMatAuthService {
	
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
    int insert(DrpMatAuth record);

    /**
     * insertSelective
     * @param record
     * @return int
     */
    int insertSelective(DrpMatAuth record);

    /**
     * selectByPrimaryKey
     * @param id
     * @return
     */
    DrpMatAuth selectByPrimaryKey(Long id);
    
    /**
     * selectBySelective
     * @param record
     * @return
     */
    DrpMatAuth selectBySelective(DrpMatAuth record);

    /**
     * updateByPrimaryKeySelective
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(DrpMatAuth record);

    /**
     * updateByPrimaryKey
     * @param record
     * @return
     */
    int updateByPrimaryKey(DrpMatAuth record);
    
    
    /**
     * @param record
     * @return
     */
    public List<DrpMatAuth> selectList(
			DrpMatAuth record);
    /**
     * selectList
     * @param record
     * @return
     */
    public PaginatedListHelper selectList(
			DrpMatAuth record,PageInfo pageInfo);
}
