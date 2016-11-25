package com.sales.service.business.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import com.sales.dao.business.DrpMatAuthMapper;
import com.sales.model.business.DrpMatAuth;
import com.sales.service.business.DrpMatAuthService;
import com.sales.util.pager.helper.PageInfo;
import com.sales.util.pager.helper.PaginatedListHelper;

@Service("drpMatAuthService")
public class DrpMatAuthServiceImpl implements DrpMatAuthService {
	
	@Resource
	private DrpMatAuthMapper drpMatAuthMapper;
	
	@Override
	public int deleteByPrimaryKey(Long id) {
		return drpMatAuthMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(DrpMatAuth record) {
		return drpMatAuthMapper.insert(record);
	}

	@Override
	public int insertSelective(DrpMatAuth record) {
		return drpMatAuthMapper.insertSelective(record);
	}

	@Override
	public DrpMatAuth selectByPrimaryKey(Long id) {
		return drpMatAuthMapper.selectByPrimaryKey(id);
	}
	
	@Override
	public DrpMatAuth selectBySelective(DrpMatAuth record) {
		List<DrpMatAuth> selectList = this.selectList(record);
		if(selectList!=null && !(selectList.isEmpty())){
			return selectList.get(0);
		}else{
			return null;
		}
	}

	@Override
	public int updateByPrimaryKeySelective(DrpMatAuth record) {
		return drpMatAuthMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(DrpMatAuth record) {
		return drpMatAuthMapper.updateByPrimaryKey(record);
	}
	 
	@Override
	public List<DrpMatAuth> selectList(
			DrpMatAuth record) {
		PageInfo pageInfo = new PageInfo();
		pageInfo.setPageNumber(1);
		pageInfo.setPageSize(Integer.MAX_VALUE);
		return this.selectList(record, pageInfo).getList(); 
	}
	
	@Override
	public PaginatedListHelper selectList(
			DrpMatAuth record,PageInfo pageInfo) {
		if(record==null){
			record = new DrpMatAuth();
		}
		List<DrpMatAuth> list = drpMatAuthMapper.selectList(record,pageInfo); 
		PaginatedListHelper helper = new PaginatedListHelper();		
//		helper.setPageNumber(pageInfo.getPageNumber());
//		helper.setPageSize(pageInfo.getPageSize());		
		helper.setList(list);
		helper.setFullListSize(pageInfo.getTotalCount());
		
		return helper; 
	}
	
}
