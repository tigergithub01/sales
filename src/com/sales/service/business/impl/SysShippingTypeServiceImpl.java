package com.sales.service.business.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import com.sales.dao.business.SysShippingTypeMapper;
import com.sales.model.business.SysShippingType;
import com.sales.service.business.SysShippingTypeService;
import com.sales.util.pager.helper.PageInfo;
import com.sales.util.pager.helper.PaginatedListHelper;

@Service("sysShippingTypeService")
public class SysShippingTypeServiceImpl implements SysShippingTypeService {
	
	@Resource
	private SysShippingTypeMapper sysShippingTypeMapper;
	
	@Override
	public int deleteByPrimaryKey(Long id) {
		return sysShippingTypeMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(SysShippingType record) {
		return sysShippingTypeMapper.insert(record);
	}

	@Override
	public int insertSelective(SysShippingType record) {
		return sysShippingTypeMapper.insertSelective(record);
	}

	@Override
	public SysShippingType selectByPrimaryKey(Long id) {
		return sysShippingTypeMapper.selectByPrimaryKey(id);
	}
	
	@Override
	public SysShippingType selectBySelective(SysShippingType record) {
		List<SysShippingType> selectList = this.selectList(record);
		if(selectList!=null && !(selectList.isEmpty())){
			return selectList.get(0);
		}else{
			return null;
		}
	}

	@Override
	public int updateByPrimaryKeySelective(SysShippingType record) {
		return sysShippingTypeMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(SysShippingType record) {
		return sysShippingTypeMapper.updateByPrimaryKey(record);
	}
	 
	@Override
	public List<SysShippingType> selectList(
			SysShippingType record) {
		PageInfo pageInfo = new PageInfo();
		pageInfo.setPageNumber(1);
		pageInfo.setPageSize(Integer.MAX_VALUE);
		return this.selectList(record, pageInfo).getList(); 
	}
	
	@Override
	public PaginatedListHelper selectList(
			SysShippingType record,PageInfo pageInfo) {
		if(record==null){
			record = new SysShippingType();
		}
		List<SysShippingType> list = sysShippingTypeMapper.selectList(record,pageInfo); 
		PaginatedListHelper helper = new PaginatedListHelper();		
//		helper.setPageNumber(pageInfo.getPageNumber());
//		helper.setPageSize(pageInfo.getPageSize());		
		helper.setList(list);
		helper.setFullListSize(pageInfo.getTotalCount());
		
		return helper; 
	}
	
}
