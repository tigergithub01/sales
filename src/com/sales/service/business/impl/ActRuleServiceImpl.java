package com.sales.service.business.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import com.sales.dao.business.ActRuleMapper;
import com.sales.model.business.ActRule;
import com.sales.service.business.ActRuleService;
import com.sales.util.pager.helper.PageInfo;
import com.sales.util.pager.helper.PaginatedListHelper;

@Service("actRuleService")
public class ActRuleServiceImpl implements ActRuleService {
	
	@Resource
	private ActRuleMapper actRuleMapper;
	
	@Override
	public int deleteByPrimaryKey(Long id) {
		return actRuleMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(ActRule record) {
		return actRuleMapper.insert(record);
	}

	@Override
	public int insertSelective(ActRule record) {
		return actRuleMapper.insertSelective(record);
	}

	@Override
	public ActRule selectByPrimaryKey(Long id) {
		return actRuleMapper.selectByPrimaryKey(id);
	}
	
	@Override
	public ActRule selectBySelective(ActRule record) {
		List<ActRule> selectList = this.selectList(record);
		if(selectList!=null && !(selectList.isEmpty())){
			return selectList.get(0);
		}else{
			return null;
		}
	}

	@Override
	public int updateByPrimaryKeySelective(ActRule record) {
		return actRuleMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(ActRule record) {
		return actRuleMapper.updateByPrimaryKey(record);
	}
	 
	@Override
	public List<ActRule> selectList(
			ActRule record) {
		PageInfo pageInfo = new PageInfo();
		pageInfo.setPageNumber(1);
		pageInfo.setPageSize(Integer.MAX_VALUE);
		return this.selectList(record, pageInfo).getList(); 
	}
	
	@Override
	public PaginatedListHelper selectList(
			ActRule record,PageInfo pageInfo) {
		if(record==null){
			record = new ActRule();
		}
		List<ActRule> list = actRuleMapper.selectList(record,pageInfo); 
		PaginatedListHelper helper = new PaginatedListHelper();		
//		helper.setPageNumber(pageInfo.getPageNumber());
//		helper.setPageSize(pageInfo.getPageSize());		
		helper.setList(list);
		helper.setFullListSize(pageInfo.getTotalCount());
		
		return helper; 
	}
	
}
