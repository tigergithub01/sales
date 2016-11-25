package com.sales.service.business;

import java.util.List;

import com.sales.model.business.DrpPosTransInfo;
import com.sales.util.pager.helper.PageInfo;
import com.sales.util.pager.helper.PaginatedListHelper;

public interface DrpPosTransInfoService {
	
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
    int insert(DrpPosTransInfo record);

    /**
     * insertSelective
     * @param record
     * @return int
     */
    int insertSelective(DrpPosTransInfo record);

    /**
     * selectByPrimaryKey
     * @param id
     * @return
     */
    DrpPosTransInfo selectByPrimaryKey(Long id);
    
    /**
     * selectBySelective
     * @param record
     * @return
     */
    DrpPosTransInfo selectBySelective(DrpPosTransInfo record);

    /**
     * updateByPrimaryKeySelective
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(DrpPosTransInfo record);

    /**
     * updateByPrimaryKey
     * @param record
     * @return
     */
    int updateByPrimaryKey(DrpPosTransInfo record);
    
    
    /**
     * @param record
     * @return
     */
    public List<DrpPosTransInfo> selectList(
			DrpPosTransInfo record);
    /**
     * selectList
     * @param record
     * @return
     */
    public PaginatedListHelper selectList(
			DrpPosTransInfo record,PageInfo pageInfo);
}
