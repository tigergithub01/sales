package com.sales.service.business;

import java.util.List;

import com.sales.model.business.VipCumulate;
import com.sales.util.pager.helper.PageInfo;
import com.sales.util.pager.helper.PaginatedListHelper;

public interface VipCumulateService {
	
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
    int insert(VipCumulate record);

    /**
     * insertSelective
     * @param record
     * @return int
     */
    int insertSelective(VipCumulate record);

    /**
     * selectByPrimaryKey
     * @param id
     * @return
     */
    VipCumulate selectByPrimaryKey(Long id);
    
    /**
     * selectBySelective
     * @param record
     * @return
     */
    VipCumulate selectBySelective(VipCumulate record);

    /**
     * updateByPrimaryKeySelective
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(VipCumulate record);

    /**
     * updateByPrimaryKey
     * @param record
     * @return
     */
    int updateByPrimaryKey(VipCumulate record);
    
    
    /**
     * @param record
     * @return
     */
    public List<VipCumulate> selectList(
			VipCumulate record);
    /**
     * selectList
     * @param record
     * @return
     */
    public PaginatedListHelper selectList(
			VipCumulate record,PageInfo pageInfo);
}
