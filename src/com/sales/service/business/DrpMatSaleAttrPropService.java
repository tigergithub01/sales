package com.sales.service.business;

import java.util.List;

import com.sales.model.business.DrpMatSaleAttrProp;
import com.sales.util.pager.helper.PageInfo;
import com.sales.util.pager.helper.PaginatedListHelper;

public interface DrpMatSaleAttrPropService {
	
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
    int insert(DrpMatSaleAttrProp record);

    /**
     * insertSelective
     * @param record
     * @return int
     */
    int insertSelective(DrpMatSaleAttrProp record);

    /**
     * selectByPrimaryKey
     * @param id
     * @return
     */
    DrpMatSaleAttrProp selectByPrimaryKey(Long id);
    
    /**
     * selectBySelective
     * @param record
     * @return
     */
    DrpMatSaleAttrProp selectBySelective(DrpMatSaleAttrProp record);

    /**
     * updateByPrimaryKeySelective
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(DrpMatSaleAttrProp record);

    /**
     * updateByPrimaryKey
     * @param record
     * @return
     */
    int updateByPrimaryKey(DrpMatSaleAttrProp record);
    
    
    /**
     * @param record
     * @return
     */
    public List<DrpMatSaleAttrProp> selectList(
			DrpMatSaleAttrProp record);
    /**
     * selectList
     * @param record
     * @return
     */
    public PaginatedListHelper selectList(
			DrpMatSaleAttrProp record,PageInfo pageInfo);
}
