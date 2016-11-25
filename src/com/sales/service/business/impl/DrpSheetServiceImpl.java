package com.sales.service.business.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import com.sales.dao.business.DrpSheetMapper;
import com.sales.model.business.DrpSheet;
import com.sales.service.business.DrpSheetService;
import com.sales.util.pager.helper.PageInfo;
import com.sales.util.pager.helper.PaginatedListHelper;

@Service("drpSheetService")
public class DrpSheetServiceImpl implements DrpSheetService {
	
	@Resource
	private DrpSheetMapper drpSheetMapper;
	
	@Override
	public int deleteByPrimaryKey(Long id) {
		return drpSheetMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(DrpSheet record) {
		return drpSheetMapper.insert(record);
	}

	@Override
	public int insertSelective(DrpSheet record) {
		return drpSheetMapper.insertSelective(record);
	}

	@Override
	public DrpSheet selectByPrimaryKey(Long id) {
		return drpSheetMapper.selectByPrimaryKey(id);
	}
	
	@Override
	public DrpSheet selectBySelective(DrpSheet record) {
		List<DrpSheet> selectList = this.selectList(record);
		if(selectList!=null && !(selectList.isEmpty())){
			return selectList.get(0);
		}else{
			return null;
		}
	}

	@Override
	public int updateByPrimaryKeySelective(DrpSheet record) {
		return drpSheetMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(DrpSheet record) {
		return drpSheetMapper.updateByPrimaryKey(record);
	}
	 
	@Override
	public List<DrpSheet> selectList(
			DrpSheet record) {
		PageInfo pageInfo = new PageInfo();
		pageInfo.setPageNumber(1);
		pageInfo.setPageSize(Integer.MAX_VALUE);
		return this.selectList(record, pageInfo).getList(); 
	}
	
	@Override
	public PaginatedListHelper selectList(
			DrpSheet record,PageInfo pageInfo) {
		if(record==null){
			record = new DrpSheet();
		}
		List<DrpSheet> list = drpSheetMapper.selectList(record,pageInfo); 
		PaginatedListHelper helper = new PaginatedListHelper();		
//		helper.setPageNumber(pageInfo.getPageNumber());
//		helper.setPageSize(pageInfo.getPageSize());		
		helper.setList(list);
		helper.setFullListSize(pageInfo.getTotalCount());
		
		return helper; 
	}
	
}
