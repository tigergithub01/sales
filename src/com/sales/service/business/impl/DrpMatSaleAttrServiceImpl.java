package com.sales.service.business.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import com.sales.dao.business.DrpMatSaleAttrMapper;
import com.sales.model.business.DrpMatSaleAttr;
import com.sales.service.business.DrpMatSaleAttrService;
import com.sales.util.pager.helper.PageInfo;
import com.sales.util.pager.helper.PaginatedListHelper;

@Service("drpMatSaleAttrService")
public class DrpMatSaleAttrServiceImpl implements DrpMatSaleAttrService {
	
	@Resource
	private DrpMatSaleAttrMapper drpMatSaleAttrMapper;
	
	@Override
	public int deleteByPrimaryKey(Long id) {
		return drpMatSaleAttrMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(DrpMatSaleAttr record) {
		return drpMatSaleAttrMapper.insert(record);
	}

	@Override
	public int insertSelective(DrpMatSaleAttr record) {
		return drpMatSaleAttrMapper.insertSelective(record);
	}

	@Override
	public DrpMatSaleAttr selectByPrimaryKey(Long id) {
		return drpMatSaleAttrMapper.selectByPrimaryKey(id);
	}
	
	@Override
	public DrpMatSaleAttr selectBySelective(DrpMatSaleAttr record) {
		List<DrpMatSaleAttr> selectList = this.selectList(record);
		if(selectList!=null && !(selectList.isEmpty())){
			return selectList.get(0);
		}else{
			return null;
		}
	}

	@Override
	public int updateByPrimaryKeySelective(DrpMatSaleAttr record) {
		return drpMatSaleAttrMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(DrpMatSaleAttr record) {
		return drpMatSaleAttrMapper.updateByPrimaryKey(record);
	}
	 
	@Override
	public List<DrpMatSaleAttr> selectList(
			DrpMatSaleAttr record) {
		PageInfo pageInfo = new PageInfo();
		pageInfo.setPageNumber(1);
		pageInfo.setPageSize(Integer.MAX_VALUE);
		return this.selectList(record, pageInfo).getList(); 
	}
	
	@Override
	public PaginatedListHelper selectList(
			DrpMatSaleAttr record,PageInfo pageInfo) {
		if(record==null){
			record = new DrpMatSaleAttr();
		}
		List<DrpMatSaleAttr> list = drpMatSaleAttrMapper.selectList(record,pageInfo); 
		PaginatedListHelper helper = new PaginatedListHelper();		
//		helper.setPageNumber(pageInfo.getPageNumber());
//		helper.setPageSize(pageInfo.getPageSize());		
		helper.setList(list);
		helper.setFullListSize(pageInfo.getTotalCount());
		
		return helper; 
	}
	
}
