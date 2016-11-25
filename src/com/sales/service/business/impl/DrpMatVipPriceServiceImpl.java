package com.sales.service.business.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import com.sales.dao.business.DrpMatVipPriceMapper;
import com.sales.model.business.DrpMatVipPrice;
import com.sales.service.business.DrpMatVipPriceService;
import com.sales.util.pager.helper.PageInfo;
import com.sales.util.pager.helper.PaginatedListHelper;

@Service("drpMatVipPriceService")
public class DrpMatVipPriceServiceImpl implements DrpMatVipPriceService {
	
	@Resource
	private DrpMatVipPriceMapper drpMatVipPriceMapper;
	
	@Override
	public int deleteByPrimaryKey(Long id) {
		return drpMatVipPriceMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(DrpMatVipPrice record) {
		return drpMatVipPriceMapper.insert(record);
	}

	@Override
	public int insertSelective(DrpMatVipPrice record) {
		return drpMatVipPriceMapper.insertSelective(record);
	}

	@Override
	public DrpMatVipPrice selectByPrimaryKey(Long id) {
		return drpMatVipPriceMapper.selectByPrimaryKey(id);
	}
	
	@Override
	public DrpMatVipPrice selectBySelective(DrpMatVipPrice record) {
		List<DrpMatVipPrice> selectList = this.selectList(record);
		if(selectList!=null && !(selectList.isEmpty())){
			return selectList.get(0);
		}else{
			return null;
		}
	}

	@Override
	public int updateByPrimaryKeySelective(DrpMatVipPrice record) {
		return drpMatVipPriceMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(DrpMatVipPrice record) {
		return drpMatVipPriceMapper.updateByPrimaryKey(record);
	}
	 
	@Override
	public List<DrpMatVipPrice> selectList(
			DrpMatVipPrice record) {
		PageInfo pageInfo = new PageInfo();
		pageInfo.setPageNumber(1);
		pageInfo.setPageSize(Integer.MAX_VALUE);
		return this.selectList(record, pageInfo).getList(); 
	}
	
	@Override
	public PaginatedListHelper selectList(
			DrpMatVipPrice record,PageInfo pageInfo) {
		if(record==null){
			record = new DrpMatVipPrice();
		}
		List<DrpMatVipPrice> list = drpMatVipPriceMapper.selectList(record,pageInfo); 
		PaginatedListHelper helper = new PaginatedListHelper();		
//		helper.setPageNumber(pageInfo.getPageNumber());
//		helper.setPageSize(pageInfo.getPageSize());		
		helper.setList(list);
		helper.setFullListSize(pageInfo.getTotalCount());
		
		return helper; 
	}
	
}
