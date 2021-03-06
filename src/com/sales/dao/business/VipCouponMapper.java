package com.sales.dao.business;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sales.model.business.VipCoupon;
import com.sales.util.pager.helper.PageInfo;

public interface VipCouponMapper {
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
    int insert(VipCoupon record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_sys_user
     *
     * @mbg.generated
     */
    int insertSelective(VipCoupon record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_sys_user
     *
     * @mbg.generated
     */
    VipCoupon selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_sys_user
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(VipCoupon record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_sys_user
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(VipCoupon record);        
    
    /**
     * @param record
     * @param page
     * @return
     */
    List<VipCoupon> selectList(@Param("model") VipCoupon record,@Param("page") PageInfo page);
}