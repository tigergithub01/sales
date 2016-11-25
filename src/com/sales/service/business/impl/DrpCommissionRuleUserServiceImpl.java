package com.sales.service.business.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import com.sales.dao.business.DrpCommissionRuleUserMapper;
import com.sales.model.business.DrpCommissionRuleUser;
import com.sales.service.business.DrpCommissionRuleUserService;
import com.sales.util.pager.helper.PageInfo;
import com.sales.util.pager.helper.PaginatedListHelper;

@Service("drpCommissionRuleUserService")
public class DrpCommissionRuleUserServiceImpl implements DrpCommissionRuleUserService {
	
	@Resource
	private DrpCommissionRuleUserMapper drpCommissionRuleUserMapper;
	
	@Override
	public int deleteByPrimaryKey(Long id) {
		return drpCommissionRuleUserMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(DrpCommissionRuleUser record) {
		return drpCommissionRuleUserMapper.insert(record);
	}

	@Override
	public int insertSelective(DrpCommissionRuleUser record) {
		return drpCommissionRuleUserMapper.insertSelective(record);
	}

	@Override
	public DrpCommissionRuleUser selectByPrimaryKey(Long id) {
		return drpCommissionRuleUserMapper.selectByPrimaryKey(id);
	}
	
	@Override
	public DrpCommissionRuleUser selectBySelective(DrpCommissionRuleUser record) {
		List<DrpCommissionRuleUser> selectList = this.selectList(record);
		if(selectList!=null && !(selectList.isEmpty())){
			return selectList.get(0);
		}else{
			return null;
		}
	}

	@Override
	public int updateByPrimaryKeySelective(DrpCommissionRuleUser record) {
		return drpCommissionRuleUserMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(DrpCommissionRuleUser record) {
		return drpCommissionRuleUserMapper.updateByPrimaryKey(record);
	}
	 
	@Override
	public List<DrpCommissionRuleUser> selectList(
			DrpCommissionRuleUser record) {
		PageInfo pageInfo = new PageInfo();
		pageInfo.setPageNumber(1);
		pageInfo.setPageSize(Integer.MAX_VALUE);
		return this.selectList(record, pageInfo).getList(); 
	}
	
	@Override
	public PaginatedListHelper selectList(
			DrpCommissionRuleUser record,PageInfo pageInfo) {
		if(record==null){
			record = new DrpCommissionRuleUser();
		}
		List<DrpCommissionRuleUser> list = drpCommissionRuleUserMapper.selectList(record,pageInfo); 
		PaginatedListHelper helper = new PaginatedListHelper();		
//		helper.setPageNumber(pageInfo.getPageNumber());
//		helper.setPageSize(pageInfo.getPageSize());		
		helper.setList(list);
		helper.setFullListSize(pageInfo.getTotalCount());
		
		return helper; 
	}
	
}
