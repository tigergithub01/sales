package com.sales.service.business;

import java.util.List;

import com.sales.model.business.Organization;
import com.sales.util.pager.helper.PageInfo;
import com.sales.util.pager.helper.PaginatedListHelper;

public interface OrganizationService {
	
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
    int insert(Organization record);

    /**
     * insertSelective
     * @param record
     * @return int
     */
    int insertSelective(Organization record);

    /**
     * selectByPrimaryKey
     * @param id
     * @return
     */
    Organization selectByPrimaryKey(Long id);
    
    /**
     * selectBySelective
     * @param record
     * @return
     */
    Organization selectBySelective(Organization record);

    /**
     * updateByPrimaryKeySelective
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(Organization record);

    /**
     * updateByPrimaryKey
     * @param record
     * @return
     */
    int updateByPrimaryKey(Organization record);
    
    
    /**
     * @param record
     * @return
     */
    public List<Organization> selectList(
			Organization record);
    /**
     * selectList
     * @param record
     * @return
     */
    public PaginatedListHelper selectList(
			Organization record,PageInfo pageInfo);
}
