package com.sales.service.business;

import java.util.List;

import com.sales.model.business.SysReport;
import com.sales.util.pager.helper.PageInfo;
import com.sales.util.pager.helper.PaginatedListHelper;

public interface SysReportService {
	
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
    int insert(SysReport record);

    /**
     * insertSelective
     * @param record
     * @return int
     */
    int insertSelective(SysReport record);

    /**
     * selectByPrimaryKey
     * @param id
     * @return
     */
    SysReport selectByPrimaryKey(Long id);
    
    /**
     * selectBySelective
     * @param record
     * @return
     */
    SysReport selectBySelective(SysReport record);

    /**
     * updateByPrimaryKeySelective
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(SysReport record);

    /**
     * updateByPrimaryKey
     * @param record
     * @return
     */
    int updateByPrimaryKey(SysReport record);
    
    
    /**
     * @param record
     * @return
     */
    public List<SysReport> selectList(
			SysReport record);
    /**
     * selectList
     * @param record
     * @return
     */
    public PaginatedListHelper selectList(
			SysReport record,PageInfo pageInfo);
}
