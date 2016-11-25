package com.sales.service.business.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import com.sales.dao.business.DrpMatPropertiesMapper;
import com.sales.model.business.DrpMatProperties;
import com.sales.service.business.DrpMatPropertiesService;
import com.sales.util.pager.helper.PageInfo;
import com.sales.util.pager.helper.PaginatedListHelper;

@Service("drpMatPropertiesService")
public class DrpMatPropertiesServiceImpl implements DrpMatPropertiesService {
	
	@Resource
	private DrpMatPropertiesMapper drpMatPropertiesMapper;
	
	@Override
	public int deleteByPrimaryKey(Long id) {
		return drpMatPropertiesMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(DrpMatProperties record) {
		return drpMatPropertiesMapper.insert(record);
	}

	@Override
	public int insertSelective(DrpMatProperties record) {
		return drpMatPropertiesMapper.insertSelective(record);
	}

	@Override
	public DrpMatProperties selectByPrimaryKey(Long id) {
		return drpMatPropertiesMapper.selectByPrimaryKey(id);
	}
	
	@Override
	public DrpMatProperties selectBySelective(DrpMatProperties record) {
		List<DrpMatProperties> selectList = this.selectList(record);
		if(selectList!=null && !(selectList.isEmpty())){
			return selectList.get(0);
		}else{
			return null;
		}
	}

	@Override
	public int updateByPrimaryKeySelective(DrpMatProperties record) {
		return drpMatPropertiesMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(DrpMatProperties record) {
		return drpMatPropertiesMapper.updateByPrimaryKey(record);
	}
	 
	@Override
	public List<DrpMatProperties> selectList(
			DrpMatProperties record) {
		PageInfo pageInfo = new PageInfo();
		pageInfo.setPageNumber(1);
		pageInfo.setPageSize(Integer.MAX_VALUE);
		return this.selectList(record, pageInfo).getList(); 
	}
	
	@Override
	public PaginatedListHelper selectList(
			DrpMatProperties record,PageInfo pageInfo) {
		if(record==null){
			record = new DrpMatProperties();
		}
		List<DrpMatProperties> list = drpMatPropertiesMapper.selectList(record,pageInfo); 
		PaginatedListHelper helper = new PaginatedListHelper();		
//		helper.setPageNumber(pageInfo.getPageNumber());
//		helper.setPageSize(pageInfo.getPageSize());		
		helper.setList(list);
		helper.setFullListSize(pageInfo.getTotalCount());
		
		return helper; 
	}
	
}
