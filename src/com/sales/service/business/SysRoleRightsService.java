package com.sales.service.business;

import java.util.List;

import com.sales.model.business.SysRoleRights;
import com.sales.util.pager.helper.PageInfo;
import com.sales.util.pager.helper.PaginatedListHelper;

public interface SysRoleRightsService {
	
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
    int insert(SysRoleRights record);

    /**
     * insertSelective
     * @param record
     * @return int
     */
    int insertSelective(SysRoleRights record);

    /**
     * selectByPrimaryKey
     * @param id
     * @return
     */
    SysRoleRights selectByPrimaryKey(Long id);
    
    /**
     * selectBySelective
     * @param record
     * @return
     */
    SysRoleRights selectBySelective(SysRoleRights record);

    /**
     * updateByPrimaryKeySelective
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(SysRoleRights record);

    /**
     * updateByPrimaryKey
     * @param record
     * @return
     */
    int updateByPrimaryKey(SysRoleRights record);
    
    
    /**
     * @param record
     * @return
     */
    public List<SysRoleRights> selectList(
			SysRoleRights record);
    /**
     * selectList
     * @param record
     * @return
     */
    public PaginatedListHelper selectList(
			SysRoleRights record,PageInfo pageInfo);
}
