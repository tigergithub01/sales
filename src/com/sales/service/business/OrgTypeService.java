package com.sales.service.business;

import java.util.List;

import com.sales.model.business.OrgType;
import com.sales.util.pager.helper.PageInfo;
import com.sales.util.pager.helper.PaginatedListHelper;

public interface OrgTypeService {
	
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
    int insert(OrgType record);

    /**
     * insertSelective
     * @param record
     * @return int
     */
    int insertSelective(OrgType record);

    /**
     * selectByPrimaryKey
     * @param id
     * @return
     */
    OrgType selectByPrimaryKey(Long id);
    
    /**
     * selectBySelective
     * @param record
     * @return
     */
    OrgType selectBySelective(OrgType record);

    /**
     * updateByPrimaryKeySelective
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(OrgType record);

    /**
     * updateByPrimaryKey
     * @param record
     * @return
     */
    int updateByPrimaryKey(OrgType record);
    
    
    /**
     * @param record
     * @return
     */
    public List<OrgType> selectList(
			OrgType record);
    /**
     * selectList
     * @param record
     * @return
     */
    public PaginatedListHelper selectList(
			OrgType record,PageInfo pageInfo);
}
