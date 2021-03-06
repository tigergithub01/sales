package com.sales.dao.business;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sales.model.business.SysOperation;
import com.sales.util.pager.helper.PageInfo;

public interface SysOperationMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_sys_user
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_sys_user
     *
     * @mbg.generated
     */
    int insert(SysOperation record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_sys_user
     *
     * @mbg.generated
     */
    int insertSelective(SysOperation record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_sys_user
     *
     * @mbg.generated
     */
    SysOperation selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_sys_user
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(SysOperation record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_sys_user
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(SysOperation record);        
    
    /**
     * @param record
     * @param page
     * @return
     */
    List<SysOperation> selectList(@Param("model") SysOperation record,@Param("page") PageInfo page);
}