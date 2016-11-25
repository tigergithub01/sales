package com.sales.service.business;

import java.util.List;

import com.sales.model.business.SysUser;
import com.sales.util.pager.helper.PageInfo;
import com.sales.util.pager.helper.PaginatedListHelper;

public interface SysUserService {
	
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
    int insert(SysUser record);

    /**
     * insertSelective
     * @param record
     * @return int
     */
    int insertSelective(SysUser record);

    /**
     * selectByPrimaryKey
     * @param id
     * @return
     */
    SysUser selectByPrimaryKey(Long id);
    
    /**
     * selectBySelective
     * @param record
     * @return
     */
    SysUser selectBySelective(SysUser record);

    /**
     * updateByPrimaryKeySelective
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(SysUser record);

    /**
     * updateByPrimaryKey
     * @param record
     * @return
     */
    int updateByPrimaryKey(SysUser record);
    
    
    /**
     * @param record
     * @return
     */
    public List<SysUser> selectList(
			SysUser record);
    /**
     * selectList
     * @param record
     * @return
     */
    public PaginatedListHelper selectList(
			SysUser record,PageInfo pageInfo);
}
