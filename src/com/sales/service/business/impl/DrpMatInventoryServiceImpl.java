package com.sales.service.business.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import com.sales.dao.business.DrpMatInventoryMapper;
import com.sales.model.business.DrpMatInventory;
import com.sales.service.business.DrpMatInventoryService;
import com.sales.util.pager.helper.PageInfo;
import com.sales.util.pager.helper.PaginatedListHelper;

@Service("drpMatInventoryService")
public class DrpMatInventoryServiceImpl implements DrpMatInventoryService {
	
	@Resource
	private DrpMatInventoryMapper drpMatInventoryMapper;
	
	@Override
	public int deleteByPrimaryKey(Long id) {
		return drpMatInventoryMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(DrpMatInventory record) {
		return drpMatInventoryMapper.insert(record);
	}

	@Override
	public int insertSelective(DrpMatInventory record) {
		return drpMatInventoryMapper.insertSelective(record);
	}

	@Override
	public DrpMatInventory selectByPrimaryKey(Long id) {
		return drpMatInventoryMapper.selectByPrimaryKey(id);
	}
	
	@Override
	public DrpMatInventory selectBySelective(DrpMatInventory record) {
		List<DrpMatInventory> selectList = this.selectList(record);
		if(selectList!=null && !(selectList.isEmpty())){
			return selectList.get(0);
		}else{
			return null;
		}
	}

	@Override
	public int updateByPrimaryKeySelective(DrpMatInventory record) {
		return drpMatInventoryMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(DrpMatInventory record) {
		return drpMatInventoryMapper.updateByPrimaryKey(record);
	}
	 
	@Override
	public List<DrpMatInventory> selectList(
			DrpMatInventory record) {
		PageInfo pageInfo = new PageInfo();
		pageInfo.setPageNumber(1);
		pageInfo.setPageSize(Integer.MAX_VALUE);
		return this.selectList(record, pageInfo).getList(); 
	}
	
	@Override
	public PaginatedListHelper selectList(
			DrpMatInventory record,PageInfo pageInfo) {
		if(record==null){
			record = new DrpMatInventory();
		}
		List<DrpMatInventory> list = drpMatInventoryMapper.selectList(record,pageInfo); 
		PaginatedListHelper helper = new PaginatedListHelper();		
//		helper.setPageNumber(pageInfo.getPageNumber());
//		helper.setPageSize(pageInfo.getPageSize());		
		helper.setList(list);
		helper.setFullListSize(pageInfo.getTotalCount());
		
		return helper; 
	}
	
}
