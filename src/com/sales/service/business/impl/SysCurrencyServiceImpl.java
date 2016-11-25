package com.sales.service.business.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import com.sales.dao.business.SysCurrencyMapper;
import com.sales.model.business.SysCurrency;
import com.sales.service.business.SysCurrencyService;
import com.sales.util.pager.helper.PageInfo;
import com.sales.util.pager.helper.PaginatedListHelper;

@Service("sysCurrencyService")
public class SysCurrencyServiceImpl implements SysCurrencyService {
	
	@Resource
	private SysCurrencyMapper sysCurrencyMapper;
	
	@Override
	public int deleteByPrimaryKey(Long id) {
		return sysCurrencyMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(SysCurrency record) {
		return sysCurrencyMapper.insert(record);
	}

	@Override
	public int insertSelective(SysCurrency record) {
		return sysCurrencyMapper.insertSelective(record);
	}

	@Override
	public SysCurrency selectByPrimaryKey(Long id) {
		return sysCurrencyMapper.selectByPrimaryKey(id);
	}
	
	@Override
	public SysCurrency selectBySelective(SysCurrency record) {
		List<SysCurrency> selectList = this.selectList(record);
		if(selectList!=null && !(selectList.isEmpty())){
			return selectList.get(0);
		}else{
			return null;
		}
	}

	@Override
	public int updateByPrimaryKeySelective(SysCurrency record) {
		return sysCurrencyMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(SysCurrency record) {
		return sysCurrencyMapper.updateByPrimaryKey(record);
	}
	 
	@Override
	public List<SysCurrency> selectList(
			SysCurrency record) {
		PageInfo pageInfo = new PageInfo();
		pageInfo.setPageNumber(1);
		pageInfo.setPageSize(Integer.MAX_VALUE);
		return this.selectList(record, pageInfo).getList(); 
	}
	
	@Override
	public PaginatedListHelper selectList(
			SysCurrency record,PageInfo pageInfo) {
		if(record==null){
			record = new SysCurrency();
		}
		List<SysCurrency> list = sysCurrencyMapper.selectList(record,pageInfo); 
		PaginatedListHelper helper = new PaginatedListHelper();		
//		helper.setPageNumber(pageInfo.getPageNumber());
//		helper.setPageSize(pageInfo.getPageSize());		
		helper.setList(list);
		helper.setFullListSize(pageInfo.getTotalCount());
		
		return helper; 
	}
	
}
