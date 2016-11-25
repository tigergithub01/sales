package com.sales.service.business.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import com.sales.dao.business.DrpMatVipPriceRegularMapper;
import com.sales.model.business.DrpMatVipPriceRegular;
import com.sales.service.business.DrpMatVipPriceRegularService;
import com.sales.util.pager.helper.PageInfo;
import com.sales.util.pager.helper.PaginatedListHelper;

@Service("drpMatVipPriceRegularService")
public class DrpMatVipPriceRegularServiceImpl implements DrpMatVipPriceRegularService {
	
	@Resource
	private DrpMatVipPriceRegularMapper drpMatVipPriceRegularMapper;
	
	@Override
	public int deleteByPrimaryKey(Long id) {
		return drpMatVipPriceRegularMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(DrpMatVipPriceRegular record) {
		return drpMatVipPriceRegularMapper.insert(record);
	}

	@Override
	public int insertSelective(DrpMatVipPriceRegular record) {
		return drpMatVipPriceRegularMapper.insertSelective(record);
	}

	@Override
	public DrpMatVipPriceRegular selectByPrimaryKey(Long id) {
		return drpMatVipPriceRegularMapper.selectByPrimaryKey(id);
	}
	
	@Override
	public DrpMatVipPriceRegular selectBySelective(DrpMatVipPriceRegular record) {
		List<DrpMatVipPriceRegular> selectList = this.selectList(record);
		if(selectList!=null && !(selectList.isEmpty())){
			return selectList.get(0);
		}else{
			return null;
		}
	}

	@Override
	public int updateByPrimaryKeySelective(DrpMatVipPriceRegular record) {
		return drpMatVipPriceRegularMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(DrpMatVipPriceRegular record) {
		return drpMatVipPriceRegularMapper.updateByPrimaryKey(record);
	}
	 
	@Override
	public List<DrpMatVipPriceRegular> selectList(
			DrpMatVipPriceRegular record) {
		PageInfo pageInfo = new PageInfo();
		pageInfo.setPageNumber(1);
		pageInfo.setPageSize(Integer.MAX_VALUE);
		return this.selectList(record, pageInfo).getList(); 
	}
	
	@Override
	public PaginatedListHelper selectList(
			DrpMatVipPriceRegular record,PageInfo pageInfo) {
		if(record==null){
			record = new DrpMatVipPriceRegular();
		}
		List<DrpMatVipPriceRegular> list = drpMatVipPriceRegularMapper.selectList(record,pageInfo); 
		PaginatedListHelper helper = new PaginatedListHelper();		
//		helper.setPageNumber(pageInfo.getPageNumber());
//		helper.setPageSize(pageInfo.getPageSize());		
		helper.setList(list);
		helper.setFullListSize(pageInfo.getTotalCount());
		
		return helper; 
	}
	
}
