package com.sales.service.business;

import java.util.List;

import com.sales.model.business.DrpMaterial;
import com.sales.util.pager.helper.PageInfo;
import com.sales.util.pager.helper.PaginatedListHelper;

public interface DrpMaterialService {
	
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
    int insert(DrpMaterial record);

    /**
     * insertSelective
     * @param record
     * @return int
     */
    int insertSelective(DrpMaterial record);

    /**
     * selectByPrimaryKey
     * @param id
     * @return
     */
    DrpMaterial selectByPrimaryKey(Long id);
    
    /**
     * selectBySelective
     * @param record
     * @return
     */
    DrpMaterial selectBySelective(DrpMaterial record);

    /**
     * updateByPrimaryKeySelective
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(DrpMaterial record);

    /**
     * updateByPrimaryKey
     * @param record
     * @return
     */
    int updateByPrimaryKey(DrpMaterial record);
    
    
    /**
     * @param record
     * @return
     */
    public List<DrpMaterial> selectList(
			DrpMaterial record);
    /**
     * selectList
     * @param record
     * @return
     */
    public PaginatedListHelper selectList(
			DrpMaterial record,PageInfo pageInfo);
}
