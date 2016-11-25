package com.sales.service.business;

import java.util.List;

import com.sales.model.business.OrgDepositAuth;
import com.sales.util.pager.helper.PageInfo;
import com.sales.util.pager.helper.PaginatedListHelper;

public interface OrgDepositAuthService {
	
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
    int insert(OrgDepositAuth record);

    /**
     * insertSelective
     * @param record
     * @return int
     */
    int insertSelective(OrgDepositAuth record);

    /**
     * selectByPrimaryKey
     * @param id
     * @return
     */
    OrgDepositAuth selectByPrimaryKey(Long id);
    
    /**
     * selectBySelective
     * @param record
     * @return
     */
    OrgDepositAuth selectBySelective(OrgDepositAuth record);

    /**
     * updateByPrimaryKeySelective
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(OrgDepositAuth record);

    /**
     * updateByPrimaryKey
     * @param record
     * @return
     */
    int updateByPrimaryKey(OrgDepositAuth record);
    
    
    /**
     * @param record
     * @return
     */
    public List<OrgDepositAuth> selectList(
			OrgDepositAuth record);
    /**
     * selectList
     * @param record
     * @return
     */
    public PaginatedListHelper selectList(
			OrgDepositAuth record,PageInfo pageInfo);
}
