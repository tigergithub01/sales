package com.sales.service.business;

import java.util.List;

import com.sales.model.business.SysRole;
import com.sales.util.pager.helper.PageInfo;
import com.sales.util.pager.helper.PaginatedListHelper;

public interface SysRoleService {
	
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
    int insert(SysRole record);

    /**
     * insertSelective
     * @param record
     * @return int
     */
    int insertSelective(SysRole record);

    /**
     * selectByPrimaryKey
     * @param id
     * @return
     */
    SysRole selectByPrimaryKey(Long id);
    
    /**
     * selectBySelective
     * @param record
     * @return
     */
    SysRole selectBySelective(SysRole record);

    /**
     * updateByPrimaryKeySelective
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(SysRole record);

    /**
     * updateByPrimaryKey
     * @param record
     * @return
     */
    int updateByPrimaryKey(SysRole record);
    
    
    /**
     * @param record
     * @return
     */
    public List<SysRole> selectList(
			SysRole record);
    /**
     * selectList
     * @param record
     * @return
     */
    public PaginatedListHelper selectList(
			SysRole record,PageInfo pageInfo);
}
