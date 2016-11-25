package com.sales.service.business;

import java.util.List;

import com.sales.model.business.DrpBrand;
import com.sales.util.pager.helper.PageInfo;
import com.sales.util.pager.helper.PaginatedListHelper;

public interface DrpBrandService {
	
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
    int insert(DrpBrand record);

    /**
     * insertSelective
     * @param record
     * @return int
     */
    int insertSelective(DrpBrand record);

    /**
     * selectByPrimaryKey
     * @param id
     * @return
     */
    DrpBrand selectByPrimaryKey(Long id);
    
    /**
     * selectBySelective
     * @param record
     * @return
     */
    DrpBrand selectBySelective(DrpBrand record);

    /**
     * updateByPrimaryKeySelective
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(DrpBrand record);

    /**
     * updateByPrimaryKey
     * @param record
     * @return
     */
    int updateByPrimaryKey(DrpBrand record);
    
    
    /**
     * @param record
     * @return
     */
    public List<DrpBrand> selectList(
			DrpBrand record);
    /**
     * selectList
     * @param record
     * @return
     */
    public PaginatedListHelper selectList(
			DrpBrand record,PageInfo pageInfo);
}
