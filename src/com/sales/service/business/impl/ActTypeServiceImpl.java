package com.sales.service.business.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import com.sales.dao.business.ActTypeMapper;
import com.sales.model.business.ActType;
import com.sales.service.business.ActTypeService;
import com.sales.util.pager.helper.PageInfo;
import com.sales.util.pager.helper.PaginatedListHelper;

@Service("actTypeService")
public class ActTypeServiceImpl implements ActTypeService {
	
	@Resource
	private ActTypeMapper actTypeMapper;
	
	@Override
	public int deleteByPrimaryKey(Long id) {
		return actTypeMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(ActType record) {
		return actTypeMapper.insert(record);
	}

	@Override
	public int insertSelective(ActType record) {
		return actTypeMapper.insertSelective(record);
	}

	@Override
	public ActType selectByPrimaryKey(Long id) {
		return actTypeMapper.selectByPrimaryKey(id);
	}
	
	@Override
	public ActType selectBySelective(ActType record) {
		List<ActType> selectList = this.selectList(record);
		if(selectList!=null && !(selectList.isEmpty())){
			return selectList.get(0);
		}else{
			return null;
		}
	}

	@Override
	public int updateByPrimaryKeySelective(ActType record) {
		return actTypeMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(ActType record) {
		return actTypeMapper.updateByPrimaryKey(record);
	}
	 
	@Override
	public List<ActType> selectList(
			ActType record) {
		PageInfo pageInfo = new PageInfo();
		pageInfo.setPageNumber(1);
		pageInfo.setPageSize(Integer.MAX_VALUE);
		return this.selectList(record, pageInfo).getList(); 
	}
	
	@Override
	public PaginatedListHelper selectList(
			ActType record,PageInfo pageInfo) {
		if(record==null){
			record = new ActType();
		}
		List<ActType> list = actTypeMapper.selectList(record,pageInfo); 
		PaginatedListHelper helper = new PaginatedListHelper();		
//		helper.setPageNumber(pageInfo.getPageNumber());
//		helper.setPageSize(pageInfo.getPageSize());		
		helper.setList(list);
		helper.setFullListSize(pageInfo.getTotalCount());
		
		return helper; 
	}
	
}
