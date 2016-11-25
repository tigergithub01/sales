package com.sales.service.business;

import java.util.List;

import com.sales.model.business.SysAppRelease;
import com.sales.util.pager.helper.PageInfo;
import com.sales.util.pager.helper.PaginatedListHelper;

public interface SysAppReleaseService {
	
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
    int insert(SysAppRelease record);

    /**
     * insertSelective
     * @param record
     * @return int
     */
    int insertSelective(SysAppRelease record);

    /**
     * selectByPrimaryKey
     * @param id
     * @return
     */
    SysAppRelease selectByPrimaryKey(Long id);
    
    /**
     * selectBySelective
     * @param record
     * @return
     */
    SysAppRelease selectBySelective(SysAppRelease record);

    /**
     * updateByPrimaryKeySelective
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(SysAppRelease record);

    /**
     * updateByPrimaryKey
     * @param record
     * @return
     */
    int updateByPrimaryKey(SysAppRelease record);
    
    
    /**
     * @param record
     * @return
     */
    public List<SysAppRelease> selectList(
			SysAppRelease record);
    /**
     * selectList
     * @param record
     * @return
     */
    public PaginatedListHelper selectList(
			SysAppRelease record,PageInfo pageInfo);
}
