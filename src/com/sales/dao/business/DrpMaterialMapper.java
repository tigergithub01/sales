package com.sales.dao.business;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sales.model.business.DrpMaterial;
import com.sales.util.pager.helper.PageInfo;

public interface DrpMaterialMapper {
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
    int insert(DrpMaterial record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_sys_user
     *
     * @mbg.generated
     */
    int insertSelective(DrpMaterial record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_sys_user
     *
     * @mbg.generated
     */
    DrpMaterial selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_sys_user
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(DrpMaterial record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_sys_user
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(DrpMaterial record);        
    
    /**
     * @param record
     * @param page
     * @return
     */
    List<DrpMaterial> selectList(@Param("model") DrpMaterial record,@Param("page") PageInfo page);
}