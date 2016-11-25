package com.sales.service.business;

import java.util.List;

import com.sales.model.business.DrpSupplier;
import com.sales.util.pager.helper.PageInfo;
import com.sales.util.pager.helper.PaginatedListHelper;

public interface DrpSupplierService {
	
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
    int insert(DrpSupplier record);

    /**
     * insertSelective
     * @param record
     * @return int
     */
    int insertSelective(DrpSupplier record);

    /**
     * selectByPrimaryKey
     * @param id
     * @return
     */
    DrpSupplier selectByPrimaryKey(Long id);
    
    /**
     * selectBySelective
     * @param record
     * @return
     */
    DrpSupplier selectBySelective(DrpSupplier record);

    /**
     * updateByPrimaryKeySelective
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(DrpSupplier record);

    /**
     * updateByPrimaryKey
     * @param record
     * @return
     */
    int updateByPrimaryKey(DrpSupplier record);
    
    
    /**
     * @param record
     * @return
     */
    public List<DrpSupplier> selectList(
			DrpSupplier record);
    /**
     * selectList
     * @param record
     * @return
     */
    public PaginatedListHelper selectList(
			DrpSupplier record,PageInfo pageInfo);
}
