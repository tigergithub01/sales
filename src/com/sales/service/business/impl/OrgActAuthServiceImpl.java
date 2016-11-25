package com.sales.service.business.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import com.sales.dao.business.OrgActAuthMapper;
import com.sales.model.business.OrgActAuth;
import com.sales.service.business.OrgActAuthService;
import com.sales.util.pager.helper.PageInfo;
import com.sales.util.pager.helper.PaginatedListHelper;

@Service("orgActAuthService")
public class OrgActAuthServiceImpl implements OrgActAuthService {
	
	@Resource
	private OrgActAuthMapper orgActAuthMapper;
	
	@Override
	public int deleteByPrimaryKey(Long id) {
		return orgActAuthMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(OrgActAuth record) {
		return orgActAuthMapper.insert(record);
	}

	@Override
	public int insertSelective(OrgActAuth record) {
		return orgActAuthMapper.insertSelective(record);
	}

	@Override
	public OrgActAuth selectByPrimaryKey(Long id) {
		return orgActAuthMapper.selectByPrimaryKey(id);
	}
	
	@Override
	public OrgActAuth selectBySelective(OrgActAuth record) {
		List<OrgActAuth> selectList = this.selectList(record);
		if(selectList!=null && !(selectList.isEmpty())){
			return selectList.get(0);
		}else{
			return null;
		}
	}

	@Override
	public int updateByPrimaryKeySelective(OrgActAuth record) {
		return orgActAuthMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(OrgActAuth record) {
		return orgActAuthMapper.updateByPrimaryKey(record);
	}
	 
	@Override
	public List<OrgActAuth> selectList(
			OrgActAuth record) {
		PageInfo pageInfo = new PageInfo();
		pageInfo.setPageNumber(1);
		pageInfo.setPageSize(Integer.MAX_VALUE);
		return this.selectList(record, pageInfo).getList(); 
	}
	
	@Override
	public PaginatedListHelper selectList(
			OrgActAuth record,PageInfo pageInfo) {
		if(record==null){
			record = new OrgActAuth();
		}
		List<OrgActAuth> list = orgActAuthMapper.selectList(record,pageInfo); 
		PaginatedListHelper helper = new PaginatedListHelper();		
//		helper.setPageNumber(pageInfo.getPageNumber());
//		helper.setPageSize(pageInfo.getPageSize());		
		helper.setList(list);
		helper.setFullListSize(pageInfo.getTotalCount());
		
		return helper; 
	}
	
}
