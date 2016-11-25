package com.sales.service.business.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import com.sales.dao.business.VipCardMapper;
import com.sales.model.business.VipCard;
import com.sales.service.business.VipCardService;
import com.sales.util.pager.helper.PageInfo;
import com.sales.util.pager.helper.PaginatedListHelper;

@Service("vipCardService")
public class VipCardServiceImpl implements VipCardService {
	
	@Resource
	private VipCardMapper vipCardMapper;
	
	@Override
	public int deleteByPrimaryKey(Long id) {
		return vipCardMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(VipCard record) {
		return vipCardMapper.insert(record);
	}

	@Override
	public int insertSelective(VipCard record) {
		return vipCardMapper.insertSelective(record);
	}

	@Override
	public VipCard selectByPrimaryKey(Long id) {
		return vipCardMapper.selectByPrimaryKey(id);
	}
	
	@Override
	public VipCard selectBySelective(VipCard record) {
		List<VipCard> selectList = this.selectList(record);
		if(selectList!=null && !(selectList.isEmpty())){
			return selectList.get(0);
		}else{
			return null;
		}
	}

	@Override
	public int updateByPrimaryKeySelective(VipCard record) {
		return vipCardMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(VipCard record) {
		return vipCardMapper.updateByPrimaryKey(record);
	}
	 
	@Override
	public List<VipCard> selectList(
			VipCard record) {
		PageInfo pageInfo = new PageInfo();
		pageInfo.setPageNumber(1);
		pageInfo.setPageSize(Integer.MAX_VALUE);
		return this.selectList(record, pageInfo).getList(); 
	}
	
	@Override
	public PaginatedListHelper selectList(
			VipCard record,PageInfo pageInfo) {
		if(record==null){
			record = new VipCard();
		}
		List<VipCard> list = vipCardMapper.selectList(record,pageInfo); 
		PaginatedListHelper helper = new PaginatedListHelper();		
//		helper.setPageNumber(pageInfo.getPageNumber());
//		helper.setPageSize(pageInfo.getPageSize());		
		helper.setList(list);
		helper.setFullListSize(pageInfo.getTotalCount());
		
		return helper; 
	}
	
}
