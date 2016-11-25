package com.sales.service.business;

import java.util.List;

import com.sales.model.business.SysAppInfo;
import com.sales.util.pager.helper.PageInfo;
import com.sales.util.pager.helper.PaginatedListHelper;

public interface SysAppInfoService {
	
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
    int insert(SysAppInfo record);

    /**
     * insertSelective
     * @param record
     * @return int
     */
    int insertSelective(SysAppInfo record);

    /**
     * selectByPrimaryKey
     * @param id
     * @return
     */
    SysAppInfo selectByPrimaryKey(Long id);
    
    /**
     * selectBySelective
     * @param record
     * @return
     */
    SysAppInfo selectBySelective(SysAppInfo record);

    /**
     * updateByPrimaryKeySelective
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(SysAppInfo record);

    /**
     * updateByPrimaryKey
     * @param record
     * @return
     */
    int updateByPrimaryKey(SysAppInfo record);
    
    
    /**
     * @param record
     * @return
     */
    public List<SysAppInfo> selectList(
			SysAppInfo record);
    /**
     * selectList
     * @param record
     * @return
     */
    public PaginatedListHelper selectList(
			SysAppInfo record,PageInfo pageInfo);
}
