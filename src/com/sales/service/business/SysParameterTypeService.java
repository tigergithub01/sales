package com.sales.service.business;

import java.util.List;

import com.sales.model.business.SysParameterType;
import com.sales.util.pager.helper.PageInfo;
import com.sales.util.pager.helper.PaginatedListHelper;

public interface SysParameterTypeService {
	
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
    int insert(SysParameterType record);

    /**
     * insertSelective
     * @param record
     * @return int
     */
    int insertSelective(SysParameterType record);

    /**
     * selectByPrimaryKey
     * @param id
     * @return
     */
    SysParameterType selectByPrimaryKey(Long id);
    
    /**
     * selectBySelective
     * @param record
     * @return
     */
    SysParameterType selectBySelective(SysParameterType record);

    /**
     * updateByPrimaryKeySelective
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(SysParameterType record);

    /**
     * updateByPrimaryKey
     * @param record
     * @return
     */
    int updateByPrimaryKey(SysParameterType record);
    
    
    /**
     * @param record
     * @return
     */
    public List<SysParameterType> selectList(
			SysParameterType record);
    /**
     * selectList
     * @param record
     * @return
     */
    public PaginatedListHelper selectList(
			SysParameterType record,PageInfo pageInfo);
}
