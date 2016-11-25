package com.sales.service.business.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import com.sales.dao.business.VipIntegralLogMapper;
import com.sales.model.business.VipIntegralLog;
import com.sales.service.business.VipIntegralLogService;
import com.sales.util.pager.helper.PageInfo;
import com.sales.util.pager.helper.PaginatedListHelper;

@Service("vipIntegralLogService")
public class VipIntegralLogServiceImpl implements VipIntegralLogService {
	
	@Resource
	private VipIntegralLogMapper vipIntegralLogMapper;
	
	@Override
	public int deleteByPrimaryKey(Long id) {
		return vipIntegralLogMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(VipIntegralLog record) {
		return vipIntegralLogMapper.insert(record);
	}

	@Override
	public int insertSelective(VipIntegralLog record) {
		return vipIntegralLogMapper.insertSelective(record);
	}

	@Override
	public VipIntegralLog selectByPrimaryKey(Long id) {
		return vipIntegralLogMapper.selectByPrimaryKey(id);
	}
	
	@Override
	public VipIntegralLog selectBySelective(VipIntegralLog record) {
		List<VipIntegralLog> selectList = this.selectList(record);
		if(selectList!=null && !(selectList.isEmpty())){
			return selectList.get(0);
		}else{
			return null;
		}
	}

	@Override
	public int updateByPrimaryKeySelective(VipIntegralLog record) {
		return vipIntegralLogMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(VipIntegralLog record) {
		return vipIntegralLogMapper.updateByPrimaryKey(record);
	}
	 
	@Override
	public List<VipIntegralLog> selectList(
			VipIntegralLog record) {
		PageInfo pageInfo = new PageInfo();
		pageInfo.setPageNumber(1);
		pageInfo.setPageSize(Integer.MAX_VALUE);
		return this.selectList(record, pageInfo).getList(); 
	}
	
	@Override
	public PaginatedListHelper selectList(
			VipIntegralLog record,PageInfo pageInfo) {
		if(record==null){
			record = new VipIntegralLog();
		}
		List<VipIntegralLog> list = vipIntegralLogMapper.selectList(record,pageInfo); 
		PaginatedListHelper helper = new PaginatedListHelper();		
//		helper.setPageNumber(pageInfo.getPageNumber());
//		helper.setPageSize(pageInfo.getPageSize());		
		helper.setList(list);
		helper.setFullListSize(pageInfo.getTotalCount());
		
		return helper; 
	}
	
}
