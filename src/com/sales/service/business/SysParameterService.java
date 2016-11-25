package com.sales.service.business;

import java.util.List;

import com.sales.model.business.SysParameter;
import com.sales.util.pager.helper.PageInfo;
import com.sales.util.pager.helper.PaginatedListHelper;

public interface SysParameterService {
	
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
    int insert(SysParameter record);

    /**
     * insertSelective
     * @param record
     * @return int
     */
    int insertSelective(SysParameter record);

    /**
     * selectByPrimaryKey
     * @param id
     * @return
     */
    SysParameter selectByPrimaryKey(Long id);
    
    /**
     * selectBySelective
     * @param record
     * @return
     */
    SysParameter selectBySelective(SysParameter record);

    /**
     * updateByPrimaryKeySelective
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(SysParameter record);

    /**
     * updateByPrimaryKey
     * @param record
     * @return
     */
    int updateByPrimaryKey(SysParameter record);
    
    
    /**
     * @param record
     * @return
     */
    public List<SysParameter> selectList(
			SysParameter record);
    /**
     * selectList
     * @param record
     * @return
     */
    public PaginatedListHelper selectList(
			SysParameter record,PageInfo pageInfo);
}
