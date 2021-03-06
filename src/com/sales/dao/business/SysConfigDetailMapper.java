package com.sales.dao.business;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sales.model.business.SysConfigDetail;
import com.sales.util.pager.helper.PageInfo;

public interface SysConfigDetailMapper {
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
    int insert(SysConfigDetail record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_sys_user
     *
     * @mbg.generated
     */
    int insertSelective(SysConfigDetail record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_sys_user
     *
     * @mbg.generated
     */
    SysConfigDetail selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_sys_user
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(SysConfigDetail record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_sys_user
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(SysConfigDetail record);        
    
    /**
     * @param record
     * @param page
     * @return
     */
    List<SysConfigDetail> selectList(@Param("model") SysConfigDetail record,@Param("page") PageInfo page);
}