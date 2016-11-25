package com.sales.service.business;

import java.util.List;

import com.sales.model.business.SysPayType;
import com.sales.util.pager.helper.PageInfo;
import com.sales.util.pager.helper.PaginatedListHelper;

public interface SysPayTypeService {
	
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
    int insert(SysPayType record);

    /**
     * insertSelective
     * @param record
     * @return int
     */
    int insertSelective(SysPayType record);

    /**
     * selectByPrimaryKey
     * @param id
     * @return
     */
    SysPayType selectByPrimaryKey(Long id);
    
    /**
     * selectBySelective
     * @param record
     * @return
     */
    SysPayType selectBySelective(SysPayType record);

    /**
     * updateByPrimaryKeySelective
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(SysPayType record);

    /**
     * updateByPrimaryKey
     * @param record
     * @return
     */
    int updateByPrimaryKey(SysPayType record);
    
    
    /**
     * @param record
     * @return
     */
    public List<SysPayType> selectList(
			SysPayType record);
    /**
     * selectList
     * @param record
     * @return
     */
    public PaginatedListHelper selectList(
			SysPayType record,PageInfo pageInfo);
}
