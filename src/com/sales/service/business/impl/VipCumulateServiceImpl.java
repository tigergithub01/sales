package com.sales.service.business.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import com.sales.dao.business.VipCumulateMapper;
import com.sales.model.business.VipCumulate;
import com.sales.service.business.VipCumulateService;
import com.sales.util.pager.helper.PageInfo;
import com.sales.util.pager.helper.PaginatedListHelper;

@Service("vipCumulateService")
public class VipCumulateServiceImpl implements VipCumulateService {
	
	@Resource
	private VipCumulateMapper vipCumulateMapper;
	
	@Override
	public int deleteByPrimaryKey(Long id) {
		return vipCumulateMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(VipCumulate record) {
		return vipCumulateMapper.insert(record);
	}

	@Override
	public int insertSelective(VipCumulate record) {
		return vipCumulateMapper.insertSelective(record);
	}

	@Override
	public VipCumulate selectByPrimaryKey(Long id) {
		return vipCumulateMapper.selectByPrimaryKey(id);
	}
	
	@Override
	public VipCumulate selectBySelective(VipCumulate record) {
		List<VipCumulate> selectList = this.selectList(record);
		if(selectList!=null && !(selectList.isEmpty())){
			return selectList.get(0);
		}else{
			return null;
		}
	}

	@Override
	public int updateByPrimaryKeySelective(VipCumulate record) {
		return vipCumulateMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(VipCumulate record) {
		return vipCumulateMapper.updateByPrimaryKey(record);
	}
	 
	@Override
	public List<VipCumulate> selectList(
			VipCumulate record) {
		PageInfo pageInfo = new PageInfo();
		pageInfo.setPageNumber(1);
		pageInfo.setPageSize(Integer.MAX_VALUE);
		return this.selectList(record, pageInfo).getList(); 
	}
	
	@Override
	public PaginatedListHelper selectList(
			VipCumulate record,PageInfo pageInfo) {
		if(record==null){
			record = new VipCumulate();
		}
		List<VipCumulate> list = vipCumulateMapper.selectList(record,pageInfo); 
		PaginatedListHelper helper = new PaginatedListHelper();		
//		helper.setPageNumber(pageInfo.getPageNumber());
//		helper.setPageSize(pageInfo.getPageSize());		
		helper.setList(list);
		helper.setFullListSize(pageInfo.getTotalCount());
		
		return helper; 
	}
	
}
