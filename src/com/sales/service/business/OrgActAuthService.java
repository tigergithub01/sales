package com.sales.service.business;

import java.util.List;

import com.sales.model.business.OrgActAuth;
import com.sales.util.pager.helper.PageInfo;
import com.sales.util.pager.helper.PaginatedListHelper;

public interface OrgActAuthService {
	
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
    int insert(OrgActAuth record);

    /**
     * insertSelective
     * @param record
     * @return int
     */
    int insertSelective(OrgActAuth record);

    /**
     * selectByPrimaryKey
     * @param id
     * @return
     */
    OrgActAuth selectByPrimaryKey(Long id);
    
    /**
     * selectBySelective
     * @param record
     * @return
     */
    OrgActAuth selectBySelective(OrgActAuth record);

    /**
     * updateByPrimaryKeySelective
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(OrgActAuth record);

    /**
     * updateByPrimaryKey
     * @param record
     * @return
     */
    int updateByPrimaryKey(OrgActAuth record);
    
    
    /**
     * @param record
     * @return
     */
    public List<OrgActAuth> selectList(
			OrgActAuth record);
    /**
     * selectList
     * @param record
     * @return
     */
    public PaginatedListHelper selectList(
			OrgActAuth record,PageInfo pageInfo);
}
