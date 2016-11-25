package com.sales.service.business.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import com.sales.dao.business.DrpPosMachineLogMapper;
import com.sales.model.business.DrpPosMachineLog;
import com.sales.service.business.DrpPosMachineLogService;
import com.sales.util.pager.helper.PageInfo;
import com.sales.util.pager.helper.PaginatedListHelper;

@Service("drpPosMachineLogService")
public class DrpPosMachineLogServiceImpl implements DrpPosMachineLogService {
	
	@Resource
	private DrpPosMachineLogMapper drpPosMachineLogMapper;
	
	@Override
	public int deleteByPrimaryKey(Long id) {
		return drpPosMachineLogMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(DrpPosMachineLog record) {
		return drpPosMachineLogMapper.insert(record);
	}

	@Override
	public int insertSelective(DrpPosMachineLog record) {
		return drpPosMachineLogMapper.insertSelective(record);
	}

	@Override
	public DrpPosMachineLog selectByPrimaryKey(Long id) {
		return drpPosMachineLogMapper.selectByPrimaryKey(id);
	}
	
	@Override
	public DrpPosMachineLog selectBySelective(DrpPosMachineLog record) {
		List<DrpPosMachineLog> selectList = this.selectList(record);
		if(selectList!=null && !(selectList.isEmpty())){
			return selectList.get(0);
		}else{
			return null;
		}
	}

	@Override
	public int updateByPrimaryKeySelective(DrpPosMachineLog record) {
		return drpPosMachineLogMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(DrpPosMachineLog record) {
		return drpPosMachineLogMapper.updateByPrimaryKey(record);
	}
	 
	@Override
	public List<DrpPosMachineLog> selectList(
			DrpPosMachineLog record) {
		PageInfo pageInfo = new PageInfo();
		pageInfo.setPageNumber(1);
		pageInfo.setPageSize(Integer.MAX_VALUE);
		return this.selectList(record, pageInfo).getList(); 
	}
	
	@Override
	public PaginatedListHelper selectList(
			DrpPosMachineLog record,PageInfo pageInfo) {
		if(record==null){
			record = new DrpPosMachineLog();
		}
		List<DrpPosMachineLog> list = drpPosMachineLogMapper.selectList(record,pageInfo); 
		PaginatedListHelper helper = new PaginatedListHelper();		
//		helper.setPageNumber(pageInfo.getPageNumber());
//		helper.setPageSize(pageInfo.getPageSize());		
		helper.setList(list);
		helper.setFullListSize(pageInfo.getTotalCount());
		
		return helper; 
	}
	
}
