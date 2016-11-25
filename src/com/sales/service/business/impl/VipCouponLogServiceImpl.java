package com.sales.service.business.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import com.sales.dao.business.VipCouponLogMapper;
import com.sales.model.business.VipCouponLog;
import com.sales.service.business.VipCouponLogService;
import com.sales.util.pager.helper.PageInfo;
import com.sales.util.pager.helper.PaginatedListHelper;

@Service("vipCouponLogService")
public class VipCouponLogServiceImpl implements VipCouponLogService {
	
	@Resource
	private VipCouponLogMapper vipCouponLogMapper;
	
	@Override
	public int deleteByPrimaryKey(Long id) {
		return vipCouponLogMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(VipCouponLog record) {
		return vipCouponLogMapper.insert(record);
	}

	@Override
	public int insertSelective(VipCouponLog record) {
		return vipCouponLogMapper.insertSelective(record);
	}

	@Override
	public VipCouponLog selectByPrimaryKey(Long id) {
		return vipCouponLogMapper.selectByPrimaryKey(id);
	}
	
	@Override
	public VipCouponLog selectBySelective(VipCouponLog record) {
		List<VipCouponLog> selectList = this.selectList(record);
		if(selectList!=null && !(selectList.isEmpty())){
			return selectList.get(0);
		}else{
			return null;
		}
	}

	@Override
	public int updateByPrimaryKeySelective(VipCouponLog record) {
		return vipCouponLogMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(VipCouponLog record) {
		return vipCouponLogMapper.updateByPrimaryKey(record);
	}
	 
	@Override
	public List<VipCouponLog> selectList(
			VipCouponLog record) {
		PageInfo pageInfo = new PageInfo();
		pageInfo.setPageNumber(1);
		pageInfo.setPageSize(Integer.MAX_VALUE);
		return this.selectList(record, pageInfo).getList(); 
	}
	
	@Override
	public PaginatedListHelper selectList(
			VipCouponLog record,PageInfo pageInfo) {
		if(record==null){
			record = new VipCouponLog();
		}
		List<VipCouponLog> list = vipCouponLogMapper.selectList(record,pageInfo); 
		PaginatedListHelper helper = new PaginatedListHelper();		
//		helper.setPageNumber(pageInfo.getPageNumber());
//		helper.setPageSize(pageInfo.getPageSize());		
		helper.setList(list);
		helper.setFullListSize(pageInfo.getTotalCount());
		
		return helper; 
	}
	
}
