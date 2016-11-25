package com.sales.service.business.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import com.sales.dao.business.VipExchangeLogMapper;
import com.sales.model.business.VipExchangeLog;
import com.sales.service.business.VipExchangeLogService;
import com.sales.util.pager.helper.PageInfo;
import com.sales.util.pager.helper.PaginatedListHelper;

@Service("vipExchangeLogService")
public class VipExchangeLogServiceImpl implements VipExchangeLogService {
	
	@Resource
	private VipExchangeLogMapper vipExchangeLogMapper;
	
	@Override
	public int deleteByPrimaryKey(Long id) {
		return vipExchangeLogMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(VipExchangeLog record) {
		return vipExchangeLogMapper.insert(record);
	}

	@Override
	public int insertSelective(VipExchangeLog record) {
		return vipExchangeLogMapper.insertSelective(record);
	}

	@Override
	public VipExchangeLog selectByPrimaryKey(Long id) {
		return vipExchangeLogMapper.selectByPrimaryKey(id);
	}
	
	@Override
	public VipExchangeLog selectBySelective(VipExchangeLog record) {
		List<VipExchangeLog> selectList = this.selectList(record);
		if(selectList!=null && !(selectList.isEmpty())){
			return selectList.get(0);
		}else{
			return null;
		}
	}

	@Override
	public int updateByPrimaryKeySelective(VipExchangeLog record) {
		return vipExchangeLogMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(VipExchangeLog record) {
		return vipExchangeLogMapper.updateByPrimaryKey(record);
	}
	 
	@Override
	public List<VipExchangeLog> selectList(
			VipExchangeLog record) {
		PageInfo pageInfo = new PageInfo();
		pageInfo.setPageNumber(1);
		pageInfo.setPageSize(Integer.MAX_VALUE);
		return this.selectList(record, pageInfo).getList(); 
	}
	
	@Override
	public PaginatedListHelper selectList(
			VipExchangeLog record,PageInfo pageInfo) {
		if(record==null){
			record = new VipExchangeLog();
		}
		List<VipExchangeLog> list = vipExchangeLogMapper.selectList(record,pageInfo); 
		PaginatedListHelper helper = new PaginatedListHelper();		
//		helper.setPageNumber(pageInfo.getPageNumber());
//		helper.setPageSize(pageInfo.getPageSize());		
		helper.setList(list);
		helper.setFullListSize(pageInfo.getTotalCount());
		
		return helper; 
	}
	
}
