package com.sales.service.business;

import java.util.List;

import com.sales.model.business.SysConfig;
import com.sales.util.pager.helper.PageInfo;
import com.sales.util.pager.helper.PaginatedListHelper;

public interface SysConfigService {
	
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
    int insert(SysConfig record);

    /**
     * insertSelective
     * @param record
     * @return int
     */
    int insertSelective(SysConfig record);

    /**
     * selectByPrimaryKey
     * @param id
     * @return
     */
    SysConfig selectByPrimaryKey(Long id);
    
    /**
     * selectBySelective
     * @param record
     * @return
     */
    SysConfig selectBySelective(SysConfig record);

    /**
     * updateByPrimaryKeySelective
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(SysConfig record);

    /**
     * updateByPrimaryKey
     * @param record
     * @return
     */
    int updateByPrimaryKey(SysConfig record);
    
    
    /**
     * @param record
     * @return
     */
    public List<SysConfig> selectList(
			SysConfig record);
    /**
     * selectList
     * @param record
     * @return
     */
    public PaginatedListHelper selectList(
			SysConfig record,PageInfo pageInfo);
}
