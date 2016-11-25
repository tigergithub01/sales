package com.sales.service.business.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import com.sales.dao.business.DrpBrandMapper;
import com.sales.model.business.DrpBrand;
import com.sales.service.business.DrpBrandService;
import com.sales.util.pager.helper.PageInfo;
import com.sales.util.pager.helper.PaginatedListHelper;

@Service("drpBrandService")
public class DrpBrandServiceImpl implements DrpBrandService {
	
	@Resource
	private DrpBrandMapper drpBrandMapper;
	
	@Override
	public int deleteByPrimaryKey(Long id) {
		return drpBrandMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(DrpBrand record) {
		return drpBrandMapper.insert(record);
	}

	@Override
	public int insertSelective(DrpBrand record) {
		return drpBrandMapper.insertSelective(record);
	}

	@Override
	public DrpBrand selectByPrimaryKey(Long id) {
		return drpBrandMapper.selectByPrimaryKey(id);
	}
	
	@Override
	public DrpBrand selectBySelective(DrpBrand record) {
		List<DrpBrand> selectList = this.selectList(record);
		if(selectList!=null && !(selectList.isEmpty())){
			return selectList.get(0);
		}else{
			return null;
		}
	}

	@Override
	public int updateByPrimaryKeySelective(DrpBrand record) {
		return drpBrandMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(DrpBrand record) {
		return drpBrandMapper.updateByPrimaryKey(record);
	}
	 
	@Override
	public List<DrpBrand> selectList(
			DrpBrand record) {
		PageInfo pageInfo = new PageInfo();
		pageInfo.setPageNumber(1);
		pageInfo.setPageSize(Integer.MAX_VALUE);
		return this.selectList(record, pageInfo).getList(); 
	}
	
	@Override
	public PaginatedListHelper selectList(
			DrpBrand record,PageInfo pageInfo) {
		if(record==null){
			record = new DrpBrand();
		}
		List<DrpBrand> list = drpBrandMapper.selectList(record,pageInfo); 
		PaginatedListHelper helper = new PaginatedListHelper();		
//		helper.setPageNumber(pageInfo.getPageNumber());
//		helper.setPageSize(pageInfo.getPageSize());		
		helper.setList(list);
		helper.setFullListSize(pageInfo.getTotalCount());
		
		return helper; 
	}
	
}
