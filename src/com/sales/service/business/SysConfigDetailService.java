package com.sales.service.business;

import java.util.List;

import com.sales.model.business.SysConfigDetail;
import com.sales.util.pager.helper.PageInfo;
import com.sales.util.pager.helper.PaginatedListHelper;

public interface SysConfigDetailService {
	
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
    int insert(SysConfigDetail record);

    /**
     * insertSelective
     * @param record
     * @return int
     */
    int insertSelective(SysConfigDetail record);

    /**
     * selectByPrimaryKey
     * @param id
     * @return
     */
    SysConfigDetail selectByPrimaryKey(Long id);
    
    /**
     * selectBySelective
     * @param record
     * @return
     */
    SysConfigDetail selectBySelective(SysConfigDetail record);

    /**
     * updateByPrimaryKeySelective
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(SysConfigDetail record);

    /**
     * updateByPrimaryKey
     * @param record
     * @return
     */
    int updateByPrimaryKey(SysConfigDetail record);
    
    
    /**
     * @param record
     * @return
     */
    public List<SysConfigDetail> selectList(
			SysConfigDetail record);
    /**
     * selectList
     * @param record
     * @return
     */
    public PaginatedListHelper selectList(
			SysConfigDetail record,PageInfo pageInfo);
}
