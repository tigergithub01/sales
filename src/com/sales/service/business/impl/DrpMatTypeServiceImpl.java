package com.sales.service.business.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import com.sales.dao.business.DrpMatTypeMapper;
import com.sales.model.business.DrpMatType;
import com.sales.service.business.DrpMatTypeService;
import com.sales.util.pager.helper.PageInfo;
import com.sales.util.pager.helper.PaginatedListHelper;

@Service("drpMatTypeService")
public class DrpMatTypeServiceImpl implements DrpMatTypeService {
	
	@Resource
	private DrpMatTypeMapper drpMatTypeMapper;
	
	@Override
	public int deleteByPrimaryKey(Long id) {
		return drpMatTypeMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(DrpMatType record) {
		return drpMatTypeMapper.insert(record);
	}

	@Override
	public int insertSelective(DrpMatType record) {
		return drpMatTypeMapper.insertSelective(record);
	}

	@Override
	public DrpMatType selectByPrimaryKey(Long id) {
		return drpMatTypeMapper.selectByPrimaryKey(id);
	}
	
	@Override
	public DrpMatType selectBySelective(DrpMatType record) {
		List<DrpMatType> selectList = this.selectList(record);
		if(selectList!=null && !(selectList.isEmpty())){
			return selectList.get(0);
		}else{
			return null;
		}
	}

	@Override
	public int updateByPrimaryKeySelective(DrpMatType record) {
		return drpMatTypeMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(DrpMatType record) {
		return drpMatTypeMapper.updateByPrimaryKey(record);
	}
	 
	@Override
	public List<DrpMatType> selectList(
			DrpMatType record) {
		PageInfo pageInfo = new PageInfo();
		pageInfo.setPageNumber(1);
		pageInfo.setPageSize(Integer.MAX_VALUE);
		return this.selectList(record, pageInfo).getList(); 
	}
	
	@Override
	public PaginatedListHelper selectList(
			DrpMatType record,PageInfo pageInfo) {
		if(record==null){
			record = new DrpMatType();
		}
		List<DrpMatType> list = drpMatTypeMapper.selectList(record,pageInfo); 
		PaginatedListHelper helper = new PaginatedListHelper();		
//		helper.setPageNumber(pageInfo.getPageNumber());
//		helper.setPageSize(pageInfo.getPageSize());		
		helper.setList(list);
		helper.setFullListSize(pageInfo.getTotalCount());
		
		return helper; 
	}
	
}
