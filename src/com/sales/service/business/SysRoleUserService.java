package com.sales.service.business;

import java.util.List;

import com.sales.model.business.SysRoleUser;
import com.sales.util.pager.helper.PageInfo;
import com.sales.util.pager.helper.PaginatedListHelper;

public interface SysRoleUserService {
	
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
    int insert(SysRoleUser record);

    /**
     * insertSelective
     * @param record
     * @return int
     */
    int insertSelective(SysRoleUser record);

    /**
     * selectByPrimaryKey
     * @param id
     * @return
     */
    SysRoleUser selectByPrimaryKey(Long id);
    
    /**
     * selectBySelective
     * @param record
     * @return
     */
    SysRoleUser selectBySelective(SysRoleUser record);

    /**
     * updateByPrimaryKeySelective
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(SysRoleUser record);

    /**
     * updateByPrimaryKey
     * @param record
     * @return
     */
    int updateByPrimaryKey(SysRoleUser record);
    
    
    /**
     * @param record
     * @return
     */
    public List<SysRoleUser> selectList(
			SysRoleUser record);
    /**
     * selectList
     * @param record
     * @return
     */
    public PaginatedListHelper selectList(
			SysRoleUser record,PageInfo pageInfo);
}
