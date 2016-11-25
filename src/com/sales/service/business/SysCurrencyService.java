package com.sales.service.business;

import java.util.List;

import com.sales.model.business.SysCurrency;
import com.sales.util.pager.helper.PageInfo;
import com.sales.util.pager.helper.PaginatedListHelper;

public interface SysCurrencyService {
	
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
    int insert(SysCurrency record);

    /**
     * insertSelective
     * @param record
     * @return int
     */
    int insertSelective(SysCurrency record);

    /**
     * selectByPrimaryKey
     * @param id
     * @return
     */
    SysCurrency selectByPrimaryKey(Long id);
    
    /**
     * selectBySelective
     * @param record
     * @return
     */
    SysCurrency selectBySelective(SysCurrency record);

    /**
     * updateByPrimaryKeySelective
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(SysCurrency record);

    /**
     * updateByPrimaryKey
     * @param record
     * @return
     */
    int updateByPrimaryKey(SysCurrency record);
    
    
    /**
     * @param record
     * @return
     */
    public List<SysCurrency> selectList(
			SysCurrency record);
    /**
     * selectList
     * @param record
     * @return
     */
    public PaginatedListHelper selectList(
			SysCurrency record,PageInfo pageInfo);
}
