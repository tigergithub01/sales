package com.sales.service.business;

import java.util.List;

import com.sales.model.business.DrpPosTransSaleFlow;
import com.sales.util.pager.helper.PageInfo;
import com.sales.util.pager.helper.PaginatedListHelper;

public interface DrpPosTransSaleFlowService {
	
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
    int insert(DrpPosTransSaleFlow record);

    /**
     * insertSelective
     * @param record
     * @return int
     */
    int insertSelective(DrpPosTransSaleFlow record);

    /**
     * selectByPrimaryKey
     * @param id
     * @return
     */
    DrpPosTransSaleFlow selectByPrimaryKey(Long id);
    
    /**
     * selectBySelective
     * @param record
     * @return
     */
    DrpPosTransSaleFlow selectBySelective(DrpPosTransSaleFlow record);

    /**
     * updateByPrimaryKeySelective
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(DrpPosTransSaleFlow record);

    /**
     * updateByPrimaryKey
     * @param record
     * @return
     */
    int updateByPrimaryKey(DrpPosTransSaleFlow record);
    
    
    /**
     * @param record
     * @return
     */
    public List<DrpPosTransSaleFlow> selectList(
			DrpPosTransSaleFlow record);
    /**
     * selectList
     * @param record
     * @return
     */
    public PaginatedListHelper selectList(
			DrpPosTransSaleFlow record,PageInfo pageInfo);
}
