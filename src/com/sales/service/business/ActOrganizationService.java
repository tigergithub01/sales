package com.sales.service.business;

import java.util.List;

import com.sales.model.business.ActOrganization;
import com.sales.util.pager.helper.PageInfo;
import com.sales.util.pager.helper.PaginatedListHelper;

public interface ActOrganizationService {
	
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
    int insert(ActOrganization record);

    /**
     * insertSelective
     * @param record
     * @return int
     */
    int insertSelective(ActOrganization record);

    /**
     * selectByPrimaryKey
     * @param id
     * @return
     */
    ActOrganization selectByPrimaryKey(Long id);
    
    /**
     * selectBySelective
     * @param record
     * @return
     */
    ActOrganization selectBySelective(ActOrganization record);

    /**
     * updateByPrimaryKeySelective
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(ActOrganization record);

    /**
     * updateByPrimaryKey
     * @param record
     * @return
     */
    int updateByPrimaryKey(ActOrganization record);
    
    
    /**
     * @param record
     * @return
     */
    public List<ActOrganization> selectList(
			ActOrganization record);
    /**
     * selectList
     * @param record
     * @return
     */
    public PaginatedListHelper selectList(
			ActOrganization record,PageInfo pageInfo);
}
