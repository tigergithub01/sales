package com.sales.service.business;

import java.util.List;

import com.sales.model.business.OrgActAuthDetail;
import com.sales.util.pager.helper.PageInfo;
import com.sales.util.pager.helper.PaginatedListHelper;

public interface OrgActAuthDetailService {
	
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
    int insert(OrgActAuthDetail record);

    /**
     * insertSelective
     * @param record
     * @return int
     */
    int insertSelective(OrgActAuthDetail record);

    /**
     * selectByPrimaryKey
     * @param id
     * @return
     */
    OrgActAuthDetail selectByPrimaryKey(Long id);
    
    /**
     * selectBySelective
     * @param record
     * @return
     */
    OrgActAuthDetail selectBySelective(OrgActAuthDetail record);

    /**
     * updateByPrimaryKeySelective
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(OrgActAuthDetail record);

    /**
     * updateByPrimaryKey
     * @param record
     * @return
     */
    int updateByPrimaryKey(OrgActAuthDetail record);
    
    
    /**
     * @param record
     * @return
     */
    public List<OrgActAuthDetail> selectList(
			OrgActAuthDetail record);
    /**
     * selectList
     * @param record
     * @return
     */
    public PaginatedListHelper selectList(
			OrgActAuthDetail record,PageInfo pageInfo);
}
