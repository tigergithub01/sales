package com.sales.service.business.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import com.sales.dao.business.DrpPosSetupMapper;
import com.sales.model.business.DrpPosSetup;
import com.sales.service.business.DrpPosSetupService;
import com.sales.util.pager.helper.PageInfo;
import com.sales.util.pager.helper.PaginatedListHelper;

@Service("drpPosSetupService")
public class DrpPosSetupServiceImpl implements DrpPosSetupService {
	
	@Resource
	private DrpPosSetupMapper drpPosSetupMapper;
	
	@Override
	public int deleteByPrimaryKey(Long id) {
		return drpPosSetupMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(DrpPosSetup record) {
		return drpPosSetupMapper.insert(record);
	}

	@Override
	public int insertSelective(DrpPosSetup record) {
		return drpPosSetupMapper.insertSelective(record);
	}

	@Override
	public DrpPosSetup selectByPrimaryKey(Long id) {
		return drpPosSetupMapper.selectByPrimaryKey(id);
	}
	
	@Override
	public DrpPosSetup selectBySelective(DrpPosSetup record) {
		List<DrpPosSetup> selectList = this.selectList(record);
		if(selectList!=null && !(selectList.isEmpty())){
			return selectList.get(0);
		}else{
			return null;
		}
	}

	@Override
	public int updateByPrimaryKeySelective(DrpPosSetup record) {
		return drpPosSetupMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(DrpPosSetup record) {
		return drpPosSetupMapper.updateByPrimaryKey(record);
	}
	 
	@Override
	public List<DrpPosSetup> selectList(
			DrpPosSetup record) {
		PageInfo pageInfo = new PageInfo();
		pageInfo.setPageNumber(1);
		pageInfo.setPageSize(Integer.MAX_VALUE);
		return this.selectList(record, pageInfo).getList(); 
	}
	
	@Override
	public PaginatedListHelper selectList(
			DrpPosSetup record,PageInfo pageInfo) {
		if(record==null){
			record = new DrpPosSetup();
		}
		List<DrpPosSetup> list = drpPosSetupMapper.selectList(record,pageInfo); 
		PaginatedListHelper helper = new PaginatedListHelper();		
//		helper.setPageNumber(pageInfo.getPageNumber());
//		helper.setPageSize(pageInfo.getPageSize());		
		helper.setList(list);
		helper.setFullListSize(pageInfo.getTotalCount());
		
		return helper; 
	}
	
}
