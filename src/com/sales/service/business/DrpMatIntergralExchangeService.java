package com.sales.service.business;

import java.util.List;

import com.sales.model.business.DrpMatIntergralExchange;
import com.sales.util.pager.helper.PageInfo;
import com.sales.util.pager.helper.PaginatedListHelper;

public interface DrpMatIntergralExchangeService {
	
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
    int insert(DrpMatIntergralExchange record);

    /**
     * insertSelective
     * @param record
     * @return int
     */
    int insertSelective(DrpMatIntergralExchange record);

    /**
     * selectByPrimaryKey
     * @param id
     * @return
     */
    DrpMatIntergralExchange selectByPrimaryKey(Long id);
    
    /**
     * selectBySelective
     * @param record
     * @return
     */
    DrpMatIntergralExchange selectBySelective(DrpMatIntergralExchange record);

    /**
     * updateByPrimaryKeySelective
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(DrpMatIntergralExchange record);

    /**
     * updateByPrimaryKey
     * @param record
     * @return
     */
    int updateByPrimaryKey(DrpMatIntergralExchange record);
    
    
    /**
     * @param record
     * @return
     */
    public List<DrpMatIntergralExchange> selectList(
			DrpMatIntergralExchange record);
    /**
     * selectList
     * @param record
     * @return
     */
    public PaginatedListHelper selectList(
			DrpMatIntergralExchange record,PageInfo pageInfo);
}
