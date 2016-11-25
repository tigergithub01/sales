package com.sales.service.business.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import com.sales.dao.business.DrpPosMachineMapper;
import com.sales.model.business.DrpPosMachine;
import com.sales.service.business.DrpPosMachineService;
import com.sales.util.pager.helper.PageInfo;
import com.sales.util.pager.helper.PaginatedListHelper;

@Service("drpPosMachineService")
public class DrpPosMachineServiceImpl implements DrpPosMachineService {
	
	@Resource
	private DrpPosMachineMapper drpPosMachineMapper;
	
	@Override
	public int deleteByPrimaryKey(Long id) {
		return drpPosMachineMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(DrpPosMachine record) {
		return drpPosMachineMapper.insert(record);
	}

	@Override
	public int insertSelective(DrpPosMachine record) {
		return drpPosMachineMapper.insertSelective(record);
	}

	@Override
	public DrpPosMachine selectByPrimaryKey(Long id) {
		return drpPosMachineMapper.selectByPrimaryKey(id);
	}
	
	@Override
	public DrpPosMachine selectBySelective(DrpPosMachine record) {
		List<DrpPosMachine> selectList = this.selectList(record);
		if(selectList!=null && !(selectList.isEmpty())){
			return selectList.get(0);
		}else{
			return null;
		}
	}

	@Override
	public int updateByPrimaryKeySelective(DrpPosMachine record) {
		return drpPosMachineMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(DrpPosMachine record) {
		return drpPosMachineMapper.updateByPrimaryKey(record);
	}
	 
	@Override
	public List<DrpPosMachine> selectList(
			DrpPosMachine record) {
		PageInfo pageInfo = new PageInfo();
		pageInfo.setPageNumber(1);
		pageInfo.setPageSize(Integer.MAX_VALUE);
		return this.selectList(record, pageInfo).getList(); 
	}
	
	@Override
	public PaginatedListHelper selectList(
			DrpPosMachine record,PageInfo pageInfo) {
		if(record==null){
			record = new DrpPosMachine();
		}
		List<DrpPosMachine> list = drpPosMachineMapper.selectList(record,pageInfo); 
		PaginatedListHelper helper = new PaginatedListHelper();		
//		helper.setPageNumber(pageInfo.getPageNumber());
//		helper.setPageSize(pageInfo.getPageSize());		
		helper.setList(list);
		helper.setFullListSize(pageInfo.getTotalCount());
		
		return helper; 
	}
	
}
