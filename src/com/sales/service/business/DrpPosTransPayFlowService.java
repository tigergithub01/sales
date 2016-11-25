package com.sales.service.business;

import java.util.List;

import com.sales.model.business.DrpPosTransPayFlow;
import com.sales.util.pager.helper.PageInfo;
import com.sales.util.pager.helper.PaginatedListHelper;

public interface DrpPosTransPayFlowService {
	
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
    int insert(DrpPosTransPayFlow record);

    /**
     * insertSelective
     * @param record
     * @return int
     */
    int insertSelective(DrpPosTransPayFlow record);

    /**
     * selectByPrimaryKey
     * @param id
     * @return
     */
    DrpPosTransPayFlow selectByPrimaryKey(Long id);
    
    /**
     * selectBySelective
     * @param record
     * @return
     */
    DrpPosTransPayFlow selectBySelective(DrpPosTransPayFlow record);

    /**
     * updateByPrimaryKeySelective
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(DrpPosTransPayFlow record);

    /**
     * updateByPrimaryKey
     * @param record
     * @return
     */
    int updateByPrimaryKey(DrpPosTransPayFlow record);
    
    
    /**
     * @param record
     * @return
     */
    public List<DrpPosTransPayFlow> selectList(
			DrpPosTransPayFlow record);
    /**
     * selectList
     * @param record
     * @return
     */
    public PaginatedListHelper selectList(
			DrpPosTransPayFlow record,PageInfo pageInfo);
}
