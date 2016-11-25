package com.sales.service.business;

import java.util.List;

import com.sales.model.business.DrpInvCheckSchemeDetail;
import com.sales.util.pager.helper.PageInfo;
import com.sales.util.pager.helper.PaginatedListHelper;

public interface DrpInvCheckSchemeDetailService {
	
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
    int insert(DrpInvCheckSchemeDetail record);

    /**
     * insertSelective
     * @param record
     * @return int
     */
    int insertSelective(DrpInvCheckSchemeDetail record);

    /**
     * selectByPrimaryKey
     * @param id
     * @return
     */
    DrpInvCheckSchemeDetail selectByPrimaryKey(Long id);
    
    /**
     * selectBySelective
     * @param record
     * @return
     */
    DrpInvCheckSchemeDetail selectBySelective(DrpInvCheckSchemeDetail record);

    /**
     * updateByPrimaryKeySelective
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(DrpInvCheckSchemeDetail record);

    /**
     * updateByPrimaryKey
     * @param record
     * @return
     */
    int updateByPrimaryKey(DrpInvCheckSchemeDetail record);
    
    
    /**
     * @param record
     * @return
     */
    public List<DrpInvCheckSchemeDetail> selectList(
			DrpInvCheckSchemeDetail record);
    /**
     * selectList
     * @param record
     * @return
     */
    public PaginatedListHelper selectList(
			DrpInvCheckSchemeDetail record,PageInfo pageInfo);
}
