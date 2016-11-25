package com.sales.service.business.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import com.sales.dao.business.OrgDepositAuthMapper;
import com.sales.model.business.OrgDepositAuth;
import com.sales.service.business.OrgDepositAuthService;
import com.sales.util.pager.helper.PageInfo;
import com.sales.util.pager.helper.PaginatedListHelper;

@Service("orgDepositAuthService")
public class OrgDepositAuthServiceImpl implements OrgDepositAuthService {
	
	@Resource
	private OrgDepositAuthMapper orgDepositAuthMapper;
	
	@Override
	public int deleteByPrimaryKey(Long id) {
		return orgDepositAuthMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(OrgDepositAuth record) {
		return orgDepositAuthMapper.insert(record);
	}

	@Override
	public int insertSelective(OrgDepositAuth record) {
		return orgDepositAuthMapper.insertSelective(record);
	}

	@Override
	public OrgDepositAuth selectByPrimaryKey(Long id) {
		return orgDepositAuthMapper.selectByPrimaryKey(id);
	}
	
	@Override
	public OrgDepositAuth selectBySelective(OrgDepositAuth record) {
		List<OrgDepositAuth> selectList = this.selectList(record);
		if(selectList!=null && !(selectList.isEmpty())){
			return selectList.get(0);
		}else{
			return null;
		}
	}

	@Override
	public int updateByPrimaryKeySelective(OrgDepositAuth record) {
		return orgDepositAuthMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(OrgDepositAuth record) {
		return orgDepositAuthMapper.updateByPrimaryKey(record);
	}
	 
	@Override
	public List<OrgDepositAuth> selectList(
			OrgDepositAuth record) {
		PageInfo pageInfo = new PageInfo();
		pageInfo.setPageNumber(1);
		pageInfo.setPageSize(Integer.MAX_VALUE);
		return this.selectList(record, pageInfo).getList(); 
	}
	
	@Override
	public PaginatedListHelper selectList(
			OrgDepositAuth record,PageInfo pageInfo) {
		if(record==null){
			record = new OrgDepositAuth();
		}
		List<OrgDepositAuth> list = orgDepositAuthMapper.selectList(record,pageInfo); 
		PaginatedListHelper helper = new PaginatedListHelper();		
//		helper.setPageNumber(pageInfo.getPageNumber());
//		helper.setPageSize(pageInfo.getPageSize());		
		helper.setList(list);
		helper.setFullListSize(pageInfo.getTotalCount());
		
		return helper; 
	}
	
}
