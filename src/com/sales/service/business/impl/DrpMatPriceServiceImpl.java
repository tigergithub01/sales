package com.sales.service.business.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import com.sales.dao.business.DrpMatPriceMapper;
import com.sales.model.business.DrpMatPrice;
import com.sales.service.business.DrpMatPriceService;
import com.sales.util.pager.helper.PageInfo;
import com.sales.util.pager.helper.PaginatedListHelper;

@Service("drpMatPriceService")
public class DrpMatPriceServiceImpl implements DrpMatPriceService {
	
	@Resource
	private DrpMatPriceMapper drpMatPriceMapper;
	
	@Override
	public int deleteByPrimaryKey(Long id) {
		return drpMatPriceMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(DrpMatPrice record) {
		return drpMatPriceMapper.insert(record);
	}

	@Override
	public int insertSelective(DrpMatPrice record) {
		return drpMatPriceMapper.insertSelective(record);
	}

	@Override
	public DrpMatPrice selectByPrimaryKey(Long id) {
		return drpMatPriceMapper.selectByPrimaryKey(id);
	}
	
	@Override
	public DrpMatPrice selectBySelective(DrpMatPrice record) {
		List<DrpMatPrice> selectList = this.selectList(record);
		if(selectList!=null && !(selectList.isEmpty())){
			return selectList.get(0);
		}else{
			return null;
		}
	}

	@Override
	public int updateByPrimaryKeySelective(DrpMatPrice record) {
		return drpMatPriceMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(DrpMatPrice record) {
		return drpMatPriceMapper.updateByPrimaryKey(record);
	}
	 
	@Override
	public List<DrpMatPrice> selectList(
			DrpMatPrice record) {
		PageInfo pageInfo = new PageInfo();
		pageInfo.setPageNumber(1);
		pageInfo.setPageSize(Integer.MAX_VALUE);
		return this.selectList(record, pageInfo).getList(); 
	}
	
	@Override
	public PaginatedListHelper selectList(
			DrpMatPrice record,PageInfo pageInfo) {
		if(record==null){
			record = new DrpMatPrice();
		}
		List<DrpMatPrice> list = drpMatPriceMapper.selectList(record,pageInfo); 
		PaginatedListHelper helper = new PaginatedListHelper();		
//		helper.setPageNumber(pageInfo.getPageNumber());
//		helper.setPageSize(pageInfo.getPageSize());		
		helper.setList(list);
		helper.setFullListSize(pageInfo.getTotalCount());
		
		return helper; 
	}
	
}
