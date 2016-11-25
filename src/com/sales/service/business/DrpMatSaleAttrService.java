package com.sales.service.business;

import java.util.List;

import com.sales.model.business.DrpMatSaleAttr;
import com.sales.util.pager.helper.PageInfo;
import com.sales.util.pager.helper.PaginatedListHelper;

public interface DrpMatSaleAttrService {
	
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
    int insert(DrpMatSaleAttr record);

    /**
     * insertSelective
     * @param record
     * @return int
     */
    int insertSelective(DrpMatSaleAttr record);

    /**
     * selectByPrimaryKey
     * @param id
     * @return
     */
    DrpMatSaleAttr selectByPrimaryKey(Long id);
    
    /**
     * selectBySelective
     * @param record
     * @return
     */
    DrpMatSaleAttr selectBySelective(DrpMatSaleAttr record);

    /**
     * updateByPrimaryKeySelective
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(DrpMatSaleAttr record);

    /**
     * updateByPrimaryKey
     * @param record
     * @return
     */
    int updateByPrimaryKey(DrpMatSaleAttr record);
    
    
    /**
     * @param record
     * @return
     */
    public List<DrpMatSaleAttr> selectList(
			DrpMatSaleAttr record);
    /**
     * selectList
     * @param record
     * @return
     */
    public PaginatedListHelper selectList(
			DrpMatSaleAttr record,PageInfo pageInfo);
}
