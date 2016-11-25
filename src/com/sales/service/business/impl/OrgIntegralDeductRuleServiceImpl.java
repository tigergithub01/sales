package com.sales.service.business.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import com.sales.dao.business.OrgIntegralDeductRuleMapper;
import com.sales.model.business.OrgIntegralDeductRule;
import com.sales.service.business.OrgIntegralDeductRuleService;
import com.sales.util.pager.helper.PageInfo;
import com.sales.util.pager.helper.PaginatedListHelper;

@Service("orgIntegralDeductRuleService")
public class OrgIntegralDeductRuleServiceImpl implements OrgIntegralDeductRuleService {
	
	@Resource
	private OrgIntegralDeductRuleMapper orgIntegralDeductRuleMapper;
	
	@Override
	public int deleteByPrimaryKey(Long id) {
		return orgIntegralDeductRuleMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(OrgIntegralDeductRule record) {
		return orgIntegralDeductRuleMapper.insert(record);
	}

	@Override
	public int insertSelective(OrgIntegralDeductRule record) {
		return orgIntegralDeductRuleMapper.insertSelective(record);
	}

	@Override
	public OrgIntegralDeductRule selectByPrimaryKey(Long id) {
		return orgIntegralDeductRuleMapper.selectByPrimaryKey(id);
	}
	
	@Override
	public OrgIntegralDeductRule selectBySelective(OrgIntegralDeductRule record) {
		List<OrgIntegralDeductRule> selectList = this.selectList(record);
		if(selectList!=null && !(selectList.isEmpty())){
			return selectList.get(0);
		}else{
			return null;
		}
	}

	@Override
	public int updateByPrimaryKeySelective(OrgIntegralDeductRule record) {
		return orgIntegralDeductRuleMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(OrgIntegralDeductRule record) {
		return orgIntegralDeductRuleMapper.updateByPrimaryKey(record);
	}
	 
	@Override
	public List<OrgIntegralDeductRule> selectList(
			OrgIntegralDeductRule record) {
		PageInfo pageInfo = new PageInfo();
		pageInfo.setPageNumber(1);
		pageInfo.setPageSize(Integer.MAX_VALUE);
		return this.selectList(record, pageInfo).getList(); 
	}
	
	@Override
	public PaginatedListHelper selectList(
			OrgIntegralDeductRule record,PageInfo pageInfo) {
		if(record==null){
			record = new OrgIntegralDeductRule();
		}
		List<OrgIntegralDeductRule> list = orgIntegralDeductRuleMapper.selectList(record,pageInfo); 
		PaginatedListHelper helper = new PaginatedListHelper();		
//		helper.setPageNumber(pageInfo.getPageNumber());
//		helper.setPageSize(pageInfo.getPageSize());		
		helper.setList(list);
		helper.setFullListSize(pageInfo.getTotalCount());
		
		return helper; 
	}
	
}
