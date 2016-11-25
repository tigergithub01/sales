package com.sales.service.business.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import com.sales.dao.business.ActRuleExtendMapper;
import com.sales.model.business.ActRuleExtend;
import com.sales.service.business.ActRuleExtendService;
import com.sales.util.pager.helper.PageInfo;
import com.sales.util.pager.helper.PaginatedListHelper;

@Service("actRuleExtendService")
public class ActRuleExtendServiceImpl implements ActRuleExtendService {
	
	@Resource
	private ActRuleExtendMapper actRuleExtendMapper;
	
	@Override
	public int deleteByPrimaryKey(Long id) {
		return actRuleExtendMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(ActRuleExtend record) {
		return actRuleExtendMapper.insert(record);
	}

	@Override
	public int insertSelective(ActRuleExtend record) {
		return actRuleExtendMapper.insertSelective(record);
	}

	@Override
	public ActRuleExtend selectByPrimaryKey(Long id) {
		return actRuleExtendMapper.selectByPrimaryKey(id);
	}
	
	@Override
	public ActRuleExtend selectBySelective(ActRuleExtend record) {
		List<ActRuleExtend> selectList = this.selectList(record);
		if(selectList!=null && !(selectList.isEmpty())){
			return selectList.get(0);
		}else{
			return null;
		}
	}

	@Override
	public int updateByPrimaryKeySelective(ActRuleExtend record) {
		return actRuleExtendMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(ActRuleExtend record) {
		return actRuleExtendMapper.updateByPrimaryKey(record);
	}
	 
	@Override
	public List<ActRuleExtend> selectList(
			ActRuleExtend record) {
		PageInfo pageInfo = new PageInfo();
		pageInfo.setPageNumber(1);
		pageInfo.setPageSize(Integer.MAX_VALUE);
		return this.selectList(record, pageInfo).getList(); 
	}
	
	@Override
	public PaginatedListHelper selectList(
			ActRuleExtend record,PageInfo pageInfo) {
		if(record==null){
			record = new ActRuleExtend();
		}
		List<ActRuleExtend> list = actRuleExtendMapper.selectList(record,pageInfo); 
		PaginatedListHelper helper = new PaginatedListHelper();		
//		helper.setPageNumber(pageInfo.getPageNumber());
//		helper.setPageSize(pageInfo.getPageSize());		
		helper.setList(list);
		helper.setFullListSize(pageInfo.getTotalCount());
		
		return helper; 
	}
	
}
