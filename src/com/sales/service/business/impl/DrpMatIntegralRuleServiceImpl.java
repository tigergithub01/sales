package com.sales.service.business.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import com.sales.dao.business.DrpMatIntegralRuleMapper;
import com.sales.model.business.DrpMatIntegralRule;
import com.sales.service.business.DrpMatIntegralRuleService;
import com.sales.util.pager.helper.PageInfo;
import com.sales.util.pager.helper.PaginatedListHelper;

@Service("drpMatIntegralRuleService")
public class DrpMatIntegralRuleServiceImpl implements DrpMatIntegralRuleService {
	
	@Resource
	private DrpMatIntegralRuleMapper drpMatIntegralRuleMapper;
	
	@Override
	public int deleteByPrimaryKey(Long id) {
		return drpMatIntegralRuleMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(DrpMatIntegralRule record) {
		return drpMatIntegralRuleMapper.insert(record);
	}

	@Override
	public int insertSelective(DrpMatIntegralRule record) {
		return drpMatIntegralRuleMapper.insertSelective(record);
	}

	@Override
	public DrpMatIntegralRule selectByPrimaryKey(Long id) {
		return drpMatIntegralRuleMapper.selectByPrimaryKey(id);
	}
	
	@Override
	public DrpMatIntegralRule selectBySelective(DrpMatIntegralRule record) {
		List<DrpMatIntegralRule> selectList = this.selectList(record);
		if(selectList!=null && !(selectList.isEmpty())){
			return selectList.get(0);
		}else{
			return null;
		}
	}

	@Override
	public int updateByPrimaryKeySelective(DrpMatIntegralRule record) {
		return drpMatIntegralRuleMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(DrpMatIntegralRule record) {
		return drpMatIntegralRuleMapper.updateByPrimaryKey(record);
	}
	 
	@Override
	public List<DrpMatIntegralRule> selectList(
			DrpMatIntegralRule record) {
		PageInfo pageInfo = new PageInfo();
		pageInfo.setPageNumber(1);
		pageInfo.setPageSize(Integer.MAX_VALUE);
		return this.selectList(record, pageInfo).getList(); 
	}
	
	@Override
	public PaginatedListHelper selectList(
			DrpMatIntegralRule record,PageInfo pageInfo) {
		if(record==null){
			record = new DrpMatIntegralRule();
		}
		List<DrpMatIntegralRule> list = drpMatIntegralRuleMapper.selectList(record,pageInfo); 
		PaginatedListHelper helper = new PaginatedListHelper();		
//		helper.setPageNumber(pageInfo.getPageNumber());
//		helper.setPageSize(pageInfo.getPageSize());		
		helper.setList(list);
		helper.setFullListSize(pageInfo.getTotalCount());
		
		return helper; 
	}
	
}
