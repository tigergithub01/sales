package com.sales.service.business.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import com.sales.dao.business.DrpMatTypePropValMapper;
import com.sales.model.business.DrpMatTypePropVal;
import com.sales.service.business.DrpMatTypePropValService;
import com.sales.util.pager.helper.PageInfo;
import com.sales.util.pager.helper.PaginatedListHelper;

@Service("drpMatTypePropValService")
public class DrpMatTypePropValServiceImpl implements DrpMatTypePropValService {
	
	@Resource
	private DrpMatTypePropValMapper drpMatTypePropValMapper;
	
	@Override
	public int deleteByPrimaryKey(Long id) {
		return drpMatTypePropValMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(DrpMatTypePropVal record) {
		return drpMatTypePropValMapper.insert(record);
	}

	@Override
	public int insertSelective(DrpMatTypePropVal record) {
		return drpMatTypePropValMapper.insertSelective(record);
	}

	@Override
	public DrpMatTypePropVal selectByPrimaryKey(Long id) {
		return drpMatTypePropValMapper.selectByPrimaryKey(id);
	}
	
	@Override
	public DrpMatTypePropVal selectBySelective(DrpMatTypePropVal record) {
		List<DrpMatTypePropVal> selectList = this.selectList(record);
		if(selectList!=null && !(selectList.isEmpty())){
			return selectList.get(0);
		}else{
			return null;
		}
	}

	@Override
	public int updateByPrimaryKeySelective(DrpMatTypePropVal record) {
		return drpMatTypePropValMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(DrpMatTypePropVal record) {
		return drpMatTypePropValMapper.updateByPrimaryKey(record);
	}
	 
	@Override
	public List<DrpMatTypePropVal> selectList(
			DrpMatTypePropVal record) {
		PageInfo pageInfo = new PageInfo();
		pageInfo.setPageNumber(1);
		pageInfo.setPageSize(Integer.MAX_VALUE);
		return this.selectList(record, pageInfo).getList(); 
	}
	
	@Override
	public PaginatedListHelper selectList(
			DrpMatTypePropVal record,PageInfo pageInfo) {
		if(record==null){
			record = new DrpMatTypePropVal();
		}
		List<DrpMatTypePropVal> list = drpMatTypePropValMapper.selectList(record,pageInfo); 
		PaginatedListHelper helper = new PaginatedListHelper();		
//		helper.setPageNumber(pageInfo.getPageNumber());
//		helper.setPageSize(pageInfo.getPageSize());		
		helper.setList(list);
		helper.setFullListSize(pageInfo.getTotalCount());
		
		return helper; 
	}
	
}
