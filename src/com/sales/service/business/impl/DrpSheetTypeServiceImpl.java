package com.sales.service.business.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import com.sales.dao.business.DrpSheetTypeMapper;
import com.sales.model.business.DrpSheetType;
import com.sales.service.business.DrpSheetTypeService;
import com.sales.util.pager.helper.PageInfo;
import com.sales.util.pager.helper.PaginatedListHelper;

@Service("drpSheetTypeService")
public class DrpSheetTypeServiceImpl implements DrpSheetTypeService {
	
	@Resource
	private DrpSheetTypeMapper drpSheetTypeMapper;
	
	@Override
	public int deleteByPrimaryKey(Long id) {
		return drpSheetTypeMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(DrpSheetType record) {
		return drpSheetTypeMapper.insert(record);
	}

	@Override
	public int insertSelective(DrpSheetType record) {
		return drpSheetTypeMapper.insertSelective(record);
	}

	@Override
	public DrpSheetType selectByPrimaryKey(Long id) {
		return drpSheetTypeMapper.selectByPrimaryKey(id);
	}
	
	@Override
	public DrpSheetType selectBySelective(DrpSheetType record) {
		List<DrpSheetType> selectList = this.selectList(record);
		if(selectList!=null && !(selectList.isEmpty())){
			return selectList.get(0);
		}else{
			return null;
		}
	}

	@Override
	public int updateByPrimaryKeySelective(DrpSheetType record) {
		return drpSheetTypeMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(DrpSheetType record) {
		return drpSheetTypeMapper.updateByPrimaryKey(record);
	}
	 
	@Override
	public List<DrpSheetType> selectList(
			DrpSheetType record) {
		PageInfo pageInfo = new PageInfo();
		pageInfo.setPageNumber(1);
		pageInfo.setPageSize(Integer.MAX_VALUE);
		return this.selectList(record, pageInfo).getList(); 
	}
	
	@Override
	public PaginatedListHelper selectList(
			DrpSheetType record,PageInfo pageInfo) {
		if(record==null){
			record = new DrpSheetType();
		}
		List<DrpSheetType> list = drpSheetTypeMapper.selectList(record,pageInfo); 
		PaginatedListHelper helper = new PaginatedListHelper();		
//		helper.setPageNumber(pageInfo.getPageNumber());
//		helper.setPageSize(pageInfo.getPageSize());		
		helper.setList(list);
		helper.setFullListSize(pageInfo.getTotalCount());
		
		return helper; 
	}
	
}
