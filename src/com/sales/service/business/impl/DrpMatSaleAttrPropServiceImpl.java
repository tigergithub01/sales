package com.sales.service.business.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import com.sales.dao.business.DrpMatSaleAttrPropMapper;
import com.sales.model.business.DrpMatSaleAttrProp;
import com.sales.service.business.DrpMatSaleAttrPropService;
import com.sales.util.pager.helper.PageInfo;
import com.sales.util.pager.helper.PaginatedListHelper;

@Service("drpMatSaleAttrPropService")
public class DrpMatSaleAttrPropServiceImpl implements DrpMatSaleAttrPropService {
	
	@Resource
	private DrpMatSaleAttrPropMapper drpMatSaleAttrPropMapper;
	
	@Override
	public int deleteByPrimaryKey(Long id) {
		return drpMatSaleAttrPropMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(DrpMatSaleAttrProp record) {
		return drpMatSaleAttrPropMapper.insert(record);
	}

	@Override
	public int insertSelective(DrpMatSaleAttrProp record) {
		return drpMatSaleAttrPropMapper.insertSelective(record);
	}

	@Override
	public DrpMatSaleAttrProp selectByPrimaryKey(Long id) {
		return drpMatSaleAttrPropMapper.selectByPrimaryKey(id);
	}
	
	@Override
	public DrpMatSaleAttrProp selectBySelective(DrpMatSaleAttrProp record) {
		List<DrpMatSaleAttrProp> selectList = this.selectList(record);
		if(selectList!=null && !(selectList.isEmpty())){
			return selectList.get(0);
		}else{
			return null;
		}
	}

	@Override
	public int updateByPrimaryKeySelective(DrpMatSaleAttrProp record) {
		return drpMatSaleAttrPropMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(DrpMatSaleAttrProp record) {
		return drpMatSaleAttrPropMapper.updateByPrimaryKey(record);
	}
	 
	@Override
	public List<DrpMatSaleAttrProp> selectList(
			DrpMatSaleAttrProp record) {
		PageInfo pageInfo = new PageInfo();
		pageInfo.setPageNumber(1);
		pageInfo.setPageSize(Integer.MAX_VALUE);
		return this.selectList(record, pageInfo).getList(); 
	}
	
	@Override
	public PaginatedListHelper selectList(
			DrpMatSaleAttrProp record,PageInfo pageInfo) {
		if(record==null){
			record = new DrpMatSaleAttrProp();
		}
		List<DrpMatSaleAttrProp> list = drpMatSaleAttrPropMapper.selectList(record,pageInfo); 
		PaginatedListHelper helper = new PaginatedListHelper();		
//		helper.setPageNumber(pageInfo.getPageNumber());
//		helper.setPageSize(pageInfo.getPageSize());		
		helper.setList(list);
		helper.setFullListSize(pageInfo.getTotalCount());
		
		return helper; 
	}
	
}
