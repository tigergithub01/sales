package com.sales.service.business.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import com.sales.dao.business.DrpSupplierMapper;
import com.sales.model.business.DrpSupplier;
import com.sales.service.business.DrpSupplierService;
import com.sales.util.pager.helper.PageInfo;
import com.sales.util.pager.helper.PaginatedListHelper;

@Service("drpSupplierService")
public class DrpSupplierServiceImpl implements DrpSupplierService {
	
	@Resource
	private DrpSupplierMapper drpSupplierMapper;
	
	@Override
	public int deleteByPrimaryKey(Long id) {
		return drpSupplierMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(DrpSupplier record) {
		return drpSupplierMapper.insert(record);
	}

	@Override
	public int insertSelective(DrpSupplier record) {
		return drpSupplierMapper.insertSelective(record);
	}

	@Override
	public DrpSupplier selectByPrimaryKey(Long id) {
		return drpSupplierMapper.selectByPrimaryKey(id);
	}
	
	@Override
	public DrpSupplier selectBySelective(DrpSupplier record) {
		List<DrpSupplier> selectList = this.selectList(record);
		if(selectList!=null && !(selectList.isEmpty())){
			return selectList.get(0);
		}else{
			return null;
		}
	}

	@Override
	public int updateByPrimaryKeySelective(DrpSupplier record) {
		return drpSupplierMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(DrpSupplier record) {
		return drpSupplierMapper.updateByPrimaryKey(record);
	}
	 
	@Override
	public List<DrpSupplier> selectList(
			DrpSupplier record) {
		PageInfo pageInfo = new PageInfo();
		pageInfo.setPageNumber(1);
		pageInfo.setPageSize(Integer.MAX_VALUE);
		return this.selectList(record, pageInfo).getList(); 
	}
	
	@Override
	public PaginatedListHelper selectList(
			DrpSupplier record,PageInfo pageInfo) {
		if(record==null){
			record = new DrpSupplier();
		}
		List<DrpSupplier> list = drpSupplierMapper.selectList(record,pageInfo); 
		PaginatedListHelper helper = new PaginatedListHelper();		
//		helper.setPageNumber(pageInfo.getPageNumber());
//		helper.setPageSize(pageInfo.getPageSize());		
		helper.setList(list);
		helper.setFullListSize(pageInfo.getTotalCount());
		
		return helper; 
	}
	
}
