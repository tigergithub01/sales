package com.sales.service.business;

import java.util.List;

import com.sales.model.business.SysShippingType;
import com.sales.util.pager.helper.PageInfo;
import com.sales.util.pager.helper.PaginatedListHelper;

public interface SysShippingTypeService {
	
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
    int insert(SysShippingType record);

    /**
     * insertSelective
     * @param record
     * @return int
     */
    int insertSelective(SysShippingType record);

    /**
     * selectByPrimaryKey
     * @param id
     * @return
     */
    SysShippingType selectByPrimaryKey(Long id);
    
    /**
     * selectBySelective
     * @param record
     * @return
     */
    SysShippingType selectBySelective(SysShippingType record);

    /**
     * updateByPrimaryKeySelective
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(SysShippingType record);

    /**
     * updateByPrimaryKey
     * @param record
     * @return
     */
    int updateByPrimaryKey(SysShippingType record);
    
    
    /**
     * @param record
     * @return
     */
    public List<SysShippingType> selectList(
			SysShippingType record);
    /**
     * selectList
     * @param record
     * @return
     */
    public PaginatedListHelper selectList(
			SysShippingType record,PageInfo pageInfo);
}
