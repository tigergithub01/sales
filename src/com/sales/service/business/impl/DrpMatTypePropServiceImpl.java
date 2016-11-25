package com.sales.service.business.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import com.sales.dao.business.DrpMatTypePropMapper;
import com.sales.model.business.DrpMatTypeProp;
import com.sales.service.business.DrpMatTypePropService;
import com.sales.util.pager.helper.PageInfo;
import com.sales.util.pager.helper.PaginatedListHelper;

@Service("drpMatTypePropService")
public class DrpMatTypePropServiceImpl implements DrpMatTypePropService {
	
	@Resource
	private DrpMatTypePropMapper drpMatTypePropMapper;
	
	@Override
	public int deleteByPrimaryKey(Long id) {
		return drpMatTypePropMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(DrpMatTypeProp record) {
		return drpMatTypePropMapper.insert(record);
	}

	@Override
	public int insertSelective(DrpMatTypeProp record) {
		return drpMatTypePropMapper.insertSelective(record);
	}

	@Override
	public DrpMatTypeProp selectByPrimaryKey(Long id) {
		return drpMatTypePropMapper.selectByPrimaryKey(id);
	}
	
	@Override
	public DrpMatTypeProp selectBySelective(DrpMatTypeProp record) {
		List<DrpMatTypeProp> selectList = this.selectList(record);
		if(selectList!=null && !(selectList.isEmpty())){
			return selectList.get(0);
		}else{
			return null;
		}
	}

	@Override
	public int updateByPrimaryKeySelective(DrpMatTypeProp record) {
		return drpMatTypePropMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(DrpMatTypeProp record) {
		return drpMatTypePropMapper.updateByPrimaryKey(record);
	}
	 
	@Override
	public List<DrpMatTypeProp> selectList(
			DrpMatTypeProp record) {
		PageInfo pageInfo = new PageInfo();
		pageInfo.setPageNumber(1);
		pageInfo.setPageSize(Integer.MAX_VALUE);
		return this.selectList(record, pageInfo).getList(); 
	}
	
	@Override
	public PaginatedListHelper selectList(
			DrpMatTypeProp record,PageInfo pageInfo) {
		if(record==null){
			record = new DrpMatTypeProp();
		}
		List<DrpMatTypeProp> list = drpMatTypePropMapper.selectList(record,pageInfo); 
		PaginatedListHelper helper = new PaginatedListHelper();		
//		helper.setPageNumber(pageInfo.getPageNumber());
//		helper.setPageSize(pageInfo.getPageSize());		
		helper.setList(list);
		helper.setFullListSize(pageInfo.getTotalCount());
		
		return helper; 
	}
	
}
