package com.sales.service.business.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import com.sales.dao.business.VipCouponMapper;
import com.sales.model.business.VipCoupon;
import com.sales.service.business.VipCouponService;
import com.sales.util.pager.helper.PageInfo;
import com.sales.util.pager.helper.PaginatedListHelper;

@Service("vipCouponService")
public class VipCouponServiceImpl implements VipCouponService {
	
	@Resource
	private VipCouponMapper vipCouponMapper;
	
	@Override
	public int deleteByPrimaryKey(Long id) {
		return vipCouponMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(VipCoupon record) {
		return vipCouponMapper.insert(record);
	}

	@Override
	public int insertSelective(VipCoupon record) {
		return vipCouponMapper.insertSelective(record);
	}

	@Override
	public VipCoupon selectByPrimaryKey(Long id) {
		return vipCouponMapper.selectByPrimaryKey(id);
	}
	
	@Override
	public VipCoupon selectBySelective(VipCoupon record) {
		List<VipCoupon> selectList = this.selectList(record);
		if(selectList!=null && !(selectList.isEmpty())){
			return selectList.get(0);
		}else{
			return null;
		}
	}

	@Override
	public int updateByPrimaryKeySelective(VipCoupon record) {
		return vipCouponMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(VipCoupon record) {
		return vipCouponMapper.updateByPrimaryKey(record);
	}
	 
	@Override
	public List<VipCoupon> selectList(
			VipCoupon record) {
		PageInfo pageInfo = new PageInfo();
		pageInfo.setPageNumber(1);
		pageInfo.setPageSize(Integer.MAX_VALUE);
		return this.selectList(record, pageInfo).getList(); 
	}
	
	@Override
	public PaginatedListHelper selectList(
			VipCoupon record,PageInfo pageInfo) {
		if(record==null){
			record = new VipCoupon();
		}
		List<VipCoupon> list = vipCouponMapper.selectList(record,pageInfo); 
		PaginatedListHelper helper = new PaginatedListHelper();		
//		helper.setPageNumber(pageInfo.getPageNumber());
//		helper.setPageSize(pageInfo.getPageSize());		
		helper.setList(list);
		helper.setFullListSize(pageInfo.getTotalCount());
		
		return helper; 
	}
	
}
