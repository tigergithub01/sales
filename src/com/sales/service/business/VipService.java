package com.sales.service.business;

import java.util.List;

import com.sales.model.business.Vip;
import com.sales.util.pager.helper.PageInfo;
import com.sales.util.pager.helper.PaginatedListHelper;

public interface VipService {
	
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
    int insert(Vip record);

    /**
     * insertSelective
     * @param record
     * @return int
     */
    int insertSelective(Vip record);

    /**
     * selectByPrimaryKey
     * @param id
     * @return
     */
    Vip selectByPrimaryKey(Long id);
    
    /**
     * selectBySelective
     * @param record
     * @return
     */
    Vip selectBySelective(Vip record);

    /**
     * updateByPrimaryKeySelective
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(Vip record);

    /**
     * updateByPrimaryKey
     * @param record
     * @return
     */
    int updateByPrimaryKey(Vip record);
    
    
    /**
     * @param record
     * @return
     */
    public List<Vip> selectList(
			Vip record);
    /**
     * selectList
     * @param record
     * @return
     */
    public PaginatedListHelper selectList(
			Vip record,PageInfo pageInfo);
}
