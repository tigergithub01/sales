package com.sales.dao.business;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sales.model.business.VipType;
import com.sales.util.pager.helper.PageInfo;

public interface VipTypeMapper {
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
    int insert(VipType record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_sys_user
     *
     * @mbg.generated
     */
    int insertSelective(VipType record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_sys_user
     *
     * @mbg.generated
     */
    VipType selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_sys_user
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(VipType record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_sys_user
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(VipType record);        
    
    /**
     * @param record
     * @param page
     * @return
     */
    List<VipType> selectList(@Param("model") VipType record,@Param("page") PageInfo page);
}