package com.sales.service.business;

import java.util.List;

import com.sales.model.business.VipType;
import com.sales.util.pager.helper.PageInfo;
import com.sales.util.pager.helper.PaginatedListHelper;

public interface VipTypeService {
	
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
    int insert(VipType record);

    /**
     * insertSelective
     * @param record
     * @return int
     */
    int insertSelective(VipType record);

    /**
     * selectByPrimaryKey
     * @param id
     * @return
     */
    VipType selectByPrimaryKey(Long id);
    
    /**
     * selectBySelective
     * @param record
     * @return
     */
    VipType selectBySelective(VipType record);

    /**
     * updateByPrimaryKeySelective
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(VipType record);

    /**
     * updateByPrimaryKey
     * @param record
     * @return
     */
    int updateByPrimaryKey(VipType record);
    
    
    /**
     * @param record
     * @return
     */
    public List<VipType> selectList(
			VipType record);
    /**
     * selectList
     * @param record
     * @return
     */
    public PaginatedListHelper selectList(
			VipType record,PageInfo pageInfo);
}
