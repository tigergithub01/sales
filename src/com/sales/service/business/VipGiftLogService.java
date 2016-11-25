package com.sales.service.business;

import java.util.List;

import com.sales.model.business.VipGiftLog;
import com.sales.util.pager.helper.PageInfo;
import com.sales.util.pager.helper.PaginatedListHelper;

public interface VipGiftLogService {
	
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
    int insert(VipGiftLog record);

    /**
     * insertSelective
     * @param record
     * @return int
     */
    int insertSelective(VipGiftLog record);

    /**
     * selectByPrimaryKey
     * @param id
     * @return
     */
    VipGiftLog selectByPrimaryKey(Long id);
    
    /**
     * selectBySelective
     * @param record
     * @return
     */
    VipGiftLog selectBySelective(VipGiftLog record);

    /**
     * updateByPrimaryKeySelective
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(VipGiftLog record);

    /**
     * updateByPrimaryKey
     * @param record
     * @return
     */
    int updateByPrimaryKey(VipGiftLog record);
    
    
    /**
     * @param record
     * @return
     */
    public List<VipGiftLog> selectList(
			VipGiftLog record);
    /**
     * selectList
     * @param record
     * @return
     */
    public PaginatedListHelper selectList(
			VipGiftLog record,PageInfo pageInfo);
}
