package com.sales.service.business.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import com.sales.dao.business.ActRangeMapper;
import com.sales.model.business.ActRange;
import com.sales.service.business.ActRangeService;
import com.sales.util.pager.helper.PageInfo;
import com.sales.util.pager.helper.PaginatedListHelper;

@Service("actRangeService")
public class ActRangeServiceImpl implements ActRangeService {
	
	@Resource
	private ActRangeMapper actRangeMapper;
	
	@Override
	public int deleteByPrimaryKey(Long id) {
		return actRangeMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(ActRange record) {
		return actRangeMapper.insert(record);
	}

	@Override
	public int insertSelective(ActRange record) {
		return actRangeMapper.insertSelective(record);
	}

	@Override
	public ActRange selectByPrimaryKey(Long id) {
		return actRangeMapper.selectByPrimaryKey(id);
	}
	
	@Override
	public ActRange selectBySelective(ActRange record) {
		List<ActRange> selectList = this.selectList(record);
		if(selectList!=null && !(selectList.isEmpty())){
			return selectList.get(0);
		}else{
			return null;
		}
	}

	@Override
	public int updateByPrimaryKeySelective(ActRange record) {
		return actRangeMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(ActRange record) {
		return actRangeMapper.updateByPrimaryKey(record);
	}
	 
	@Override
	public List<ActRange> selectList(
			ActRange record) {
		PageInfo pageInfo = new PageInfo();
		pageInfo.setPageNumber(1);
		pageInfo.setPageSize(Integer.MAX_VALUE);
		return this.selectList(record, pageInfo).getList(); 
	}
	
	@Override
	public PaginatedListHelper selectList(
			ActRange record,PageInfo pageInfo) {
		if(record==null){
			record = new ActRange();
		}
		List<ActRange> list = actRangeMapper.selectList(record,pageInfo); 
		PaginatedListHelper helper = new PaginatedListHelper();		
//		helper.setPageNumber(pageInfo.getPageNumber());
//		helper.setPageSize(pageInfo.getPageSize());		
		helper.setList(list);
		helper.setFullListSize(pageInfo.getTotalCount());
		
		return helper; 
	}
	
}
