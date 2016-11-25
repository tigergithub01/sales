package com.sales.service.business.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import com.sales.dao.business.DrpMatWarnRuleMapper;
import com.sales.model.business.DrpMatWarnRule;
import com.sales.service.business.DrpMatWarnRuleService;
import com.sales.util.pager.helper.PageInfo;
import com.sales.util.pager.helper.PaginatedListHelper;

@Service("drpMatWarnRuleService")
public class DrpMatWarnRuleServiceImpl implements DrpMatWarnRuleService {
	
	@Resource
	private DrpMatWarnRuleMapper drpMatWarnRuleMapper;
	
	@Override
	public int deleteByPrimaryKey(Long id) {
		return drpMatWarnRuleMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(DrpMatWarnRule record) {
		return drpMatWarnRuleMapper.insert(record);
	}

	@Override
	public int insertSelective(DrpMatWarnRule record) {
		return drpMatWarnRuleMapper.insertSelective(record);
	}

	@Override
	public DrpMatWarnRule selectByPrimaryKey(Long id) {
		return drpMatWarnRuleMapper.selectByPrimaryKey(id);
	}
	
	@Override
	public DrpMatWarnRule selectBySelective(DrpMatWarnRule record) {
		List<DrpMatWarnRule> selectList = this.selectList(record);
		if(selectList!=null && !(selectList.isEmpty())){
			return selectList.get(0);
		}else{
			return null;
		}
	}

	@Override
	public int updateByPrimaryKeySelective(DrpMatWarnRule record) {
		return drpMatWarnRuleMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(DrpMatWarnRule record) {
		return drpMatWarnRuleMapper.updateByPrimaryKey(record);
	}
	 
	@Override
	public List<DrpMatWarnRule> selectList(
			DrpMatWarnRule record) {
		PageInfo pageInfo = new PageInfo();
		pageInfo.setPageNumber(1);
		pageInfo.setPageSize(Integer.MAX_VALUE);
		return this.selectList(record, pageInfo).getList(); 
	}
	
	@Override
	public PaginatedListHelper selectList(
			DrpMatWarnRule record,PageInfo pageInfo) {
		if(record==null){
			record = new DrpMatWarnRule();
		}
		List<DrpMatWarnRule> list = drpMatWarnRuleMapper.selectList(record,pageInfo); 
		PaginatedListHelper helper = new PaginatedListHelper();		
//		helper.setPageNumber(pageInfo.getPageNumber());
//		helper.setPageSize(pageInfo.getPageSize());		
		helper.setList(list);
		helper.setFullListSize(pageInfo.getTotalCount());
		
		return helper; 
	}
	
}
