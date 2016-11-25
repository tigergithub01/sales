package com.sales.service.business.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import com.sales.dao.business.DrpMatIntergralExchangeMapper;
import com.sales.model.business.DrpMatIntergralExchange;
import com.sales.service.business.DrpMatIntergralExchangeService;
import com.sales.util.pager.helper.PageInfo;
import com.sales.util.pager.helper.PaginatedListHelper;

@Service("drpMatIntergralExchangeService")
public class DrpMatIntergralExchangeServiceImpl implements DrpMatIntergralExchangeService {
	
	@Resource
	private DrpMatIntergralExchangeMapper drpMatIntergralExchangeMapper;
	
	@Override
	public int deleteByPrimaryKey(Long id) {
		return drpMatIntergralExchangeMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(DrpMatIntergralExchange record) {
		return drpMatIntergralExchangeMapper.insert(record);
	}

	@Override
	public int insertSelective(DrpMatIntergralExchange record) {
		return drpMatIntergralExchangeMapper.insertSelective(record);
	}

	@Override
	public DrpMatIntergralExchange selectByPrimaryKey(Long id) {
		return drpMatIntergralExchangeMapper.selectByPrimaryKey(id);
	}
	
	@Override
	public DrpMatIntergralExchange selectBySelective(DrpMatIntergralExchange record) {
		List<DrpMatIntergralExchange> selectList = this.selectList(record);
		if(selectList!=null && !(selectList.isEmpty())){
			return selectList.get(0);
		}else{
			return null;
		}
	}

	@Override
	public int updateByPrimaryKeySelective(DrpMatIntergralExchange record) {
		return drpMatIntergralExchangeMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(DrpMatIntergralExchange record) {
		return drpMatIntergralExchangeMapper.updateByPrimaryKey(record);
	}
	 
	@Override
	public List<DrpMatIntergralExchange> selectList(
			DrpMatIntergralExchange record) {
		PageInfo pageInfo = new PageInfo();
		pageInfo.setPageNumber(1);
		pageInfo.setPageSize(Integer.MAX_VALUE);
		return this.selectList(record, pageInfo).getList(); 
	}
	
	@Override
	public PaginatedListHelper selectList(
			DrpMatIntergralExchange record,PageInfo pageInfo) {
		if(record==null){
			record = new DrpMatIntergralExchange();
		}
		List<DrpMatIntergralExchange> list = drpMatIntergralExchangeMapper.selectList(record,pageInfo); 
		PaginatedListHelper helper = new PaginatedListHelper();		
//		helper.setPageNumber(pageInfo.getPageNumber());
//		helper.setPageSize(pageInfo.getPageSize());		
		helper.setList(list);
		helper.setFullListSize(pageInfo.getTotalCount());
		
		return helper; 
	}
	
}
