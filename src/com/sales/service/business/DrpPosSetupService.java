package com.sales.service.business;

import java.util.List;

import com.sales.model.business.DrpPosSetup;
import com.sales.util.pager.helper.PageInfo;
import com.sales.util.pager.helper.PaginatedListHelper;

public interface DrpPosSetupService {
	
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
    int insert(DrpPosSetup record);

    /**
     * insertSelective
     * @param record
     * @return int
     */
    int insertSelective(DrpPosSetup record);

    /**
     * selectByPrimaryKey
     * @param id
     * @return
     */
    DrpPosSetup selectByPrimaryKey(Long id);
    
    /**
     * selectBySelective
     * @param record
     * @return
     */
    DrpPosSetup selectBySelective(DrpPosSetup record);

    /**
     * updateByPrimaryKeySelective
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(DrpPosSetup record);

    /**
     * updateByPrimaryKey
     * @param record
     * @return
     */
    int updateByPrimaryKey(DrpPosSetup record);
    
    
    /**
     * @param record
     * @return
     */
    public List<DrpPosSetup> selectList(
			DrpPosSetup record);
    /**
     * selectList
     * @param record
     * @return
     */
    public PaginatedListHelper selectList(
			DrpPosSetup record,PageInfo pageInfo);
}
