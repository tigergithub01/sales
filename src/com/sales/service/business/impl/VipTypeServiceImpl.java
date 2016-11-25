package com.sales.service.business.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import com.sales.dao.business.VipTypeMapper;
import com.sales.model.business.VipType;
import com.sales.service.business.VipTypeService;
import com.sales.util.pager.helper.PageInfo;
import com.sales.util.pager.helper.PaginatedListHelper;

@Service("vipTypeService")
public class VipTypeServiceImpl implements VipTypeService {
	
	@Resource
	private VipTypeMapper vipTypeMapper;
	
	@Override
	public int deleteByPrimaryKey(Long id) {
		return vipTypeMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(VipType record) {
		return vipTypeMapper.insert(record);
	}

	@Override
	public int insertSelective(VipType record) {
		return vipTypeMapper.insertSelective(record);
	}

	@Override
	public VipType selectByPrimaryKey(Long id) {
		return vipTypeMapper.selectByPrimaryKey(id);
	}
	
	@Override
	public VipType selectBySelective(VipType record) {
		List<VipType> selectList = this.selectList(record);
		if(selectList!=null && !(selectList.isEmpty())){
			return selectList.get(0);
		}else{
			return null;
		}
	}

	@Override
	public int updateByPrimaryKeySelective(VipType record) {
		return vipTypeMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(VipType record) {
		return vipTypeMapper.updateByPrimaryKey(record);
	}
	 
	@Override
	public List<VipType> selectList(
			VipType record) {
		PageInfo pageInfo = new PageInfo();
		pageInfo.setPageNumber(1);
		pageInfo.setPageSize(Integer.MAX_VALUE);
		return this.selectList(record, pageInfo).getList(); 
	}
	
	@Override
	public PaginatedListHelper selectList(
			VipType record,PageInfo pageInfo) {
		if(record==null){
			record = new VipType();
		}
		List<VipType> list = vipTypeMapper.selectList(record,pageInfo); 
		PaginatedListHelper helper = new PaginatedListHelper();		
//		helper.setPageNumber(pageInfo.getPageNumber());
//		helper.setPageSize(pageInfo.getPageSize());		
		helper.setList(list);
		helper.setFullListSize(pageInfo.getTotalCount());
		
		return helper; 
	}
	
}
