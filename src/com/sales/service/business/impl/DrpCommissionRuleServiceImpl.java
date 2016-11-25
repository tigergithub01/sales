package com.sales.service.business.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import com.sales.dao.business.DrpCommissionRuleMapper;
import com.sales.model.business.DrpCommissionRule;
import com.sales.service.business.DrpCommissionRuleService;
import com.sales.util.pager.helper.PageInfo;
import com.sales.util.pager.helper.PaginatedListHelper;

@Service("drpCommissionRuleService")
public class DrpCommissionRuleServiceImpl implements DrpCommissionRuleService {
	
	@Resource
	private DrpCommissionRuleMapper drpCommissionRuleMapper;
	
	@Override
	public int deleteByPrimaryKey(Long id) {
		return drpCommissionRuleMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(DrpCommissionRule record) {
		return drpCommissionRuleMapper.insert(record);
	}

	@Override
	public int insertSelective(DrpCommissionRule record) {
		return drpCommissionRuleMapper.insertSelective(record);
	}

	@Override
	public DrpCommissionRule selectByPrimaryKey(Long id) {
		return drpCommissionRuleMapper.selectByPrimaryKey(id);
	}
	
	@Override
	public DrpCommissionRule selectBySelective(DrpCommissionRule record) {
		List<DrpCommissionRule> selectList = this.selectList(record);
		if(selectList!=null && !(selectList.isEmpty())){
			return selectList.get(0);
		}else{
			return null;
		}
	}

	@Override
	public int updateByPrimaryKeySelective(DrpCommissionRule record) {
		return drpCommissionRuleMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(DrpCommissionRule record) {
		return drpCommissionRuleMapper.updateByPrimaryKey(record);
	}
	 
	@Override
	public List<DrpCommissionRule> selectList(
			DrpCommissionRule record) {
		PageInfo pageInfo = new PageInfo();
		pageInfo.setPageNumber(1);
		pageInfo.setPageSize(Integer.MAX_VALUE);
		return this.selectList(record, pageInfo).getList(); 
	}
	
	@Override
	public PaginatedListHelper selectList(
			DrpCommissionRule record,PageInfo pageInfo) {
		if(record==null){
			record = new DrpCommissionRule();
		}
		List<DrpCommissionRule> list = drpCommissionRuleMapper.selectList(record,pageInfo); 
		PaginatedListHelper helper = new PaginatedListHelper();		
//		helper.setPageNumber(pageInfo.getPageNumber());
//		helper.setPageSize(pageInfo.getPageSize());		
		helper.setList(list);
		helper.setFullListSize(pageInfo.getTotalCount());
		
		return helper; 
	}
	
}
