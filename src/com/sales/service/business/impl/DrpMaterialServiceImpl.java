package com.sales.service.business.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import com.sales.dao.business.DrpMaterialMapper;
import com.sales.model.business.DrpMaterial;
import com.sales.service.business.DrpMaterialService;
import com.sales.util.pager.helper.PageInfo;
import com.sales.util.pager.helper.PaginatedListHelper;

@Service("drpMaterialService")
public class DrpMaterialServiceImpl implements DrpMaterialService {
	
	@Resource
	private DrpMaterialMapper drpMaterialMapper;
	
	@Override
	public int deleteByPrimaryKey(Long id) {
		return drpMaterialMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(DrpMaterial record) {
		return drpMaterialMapper.insert(record);
	}

	@Override
	public int insertSelective(DrpMaterial record) {
		return drpMaterialMapper.insertSelective(record);
	}

	@Override
	public DrpMaterial selectByPrimaryKey(Long id) {
		return drpMaterialMapper.selectByPrimaryKey(id);
	}
	
	@Override
	public DrpMaterial selectBySelective(DrpMaterial record) {
		List<DrpMaterial> selectList = this.selectList(record);
		if(selectList!=null && !(selectList.isEmpty())){
			return selectList.get(0);
		}else{
			return null;
		}
	}

	@Override
	public int updateByPrimaryKeySelective(DrpMaterial record) {
		return drpMaterialMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(DrpMaterial record) {
		return drpMaterialMapper.updateByPrimaryKey(record);
	}
	 
	@Override
	public List<DrpMaterial> selectList(
			DrpMaterial record) {
		PageInfo pageInfo = new PageInfo();
		pageInfo.setPageNumber(1);
		pageInfo.setPageSize(Integer.MAX_VALUE);
		return this.selectList(record, pageInfo).getList(); 
	}
	
	@Override
	public PaginatedListHelper selectList(
			DrpMaterial record,PageInfo pageInfo) {
		if(record==null){
			record = new DrpMaterial();
		}
		List<DrpMaterial> list = drpMaterialMapper.selectList(record,pageInfo); 
		PaginatedListHelper helper = new PaginatedListHelper();		
//		helper.setPageNumber(pageInfo.getPageNumber());
//		helper.setPageSize(pageInfo.getPageSize());		
		helper.setList(list);
		helper.setFullListSize(pageInfo.getTotalCount());
		
		return helper; 
	}
	
}
