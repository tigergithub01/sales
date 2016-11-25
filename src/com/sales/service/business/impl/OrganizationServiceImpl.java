package com.sales.service.business.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import com.sales.dao.business.OrganizationMapper;
import com.sales.model.business.Organization;
import com.sales.service.business.OrganizationService;
import com.sales.util.pager.helper.PageInfo;
import com.sales.util.pager.helper.PaginatedListHelper;

@Service("organizationService")
public class OrganizationServiceImpl implements OrganizationService {
	
	@Resource
	private OrganizationMapper organizationMapper;
	
	@Override
	public int deleteByPrimaryKey(Long id) {
		return organizationMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(Organization record) {
		return organizationMapper.insert(record);
	}

	@Override
	public int insertSelective(Organization record) {
		return organizationMapper.insertSelective(record);
	}

	@Override
	public Organization selectByPrimaryKey(Long id) {
		return organizationMapper.selectByPrimaryKey(id);
	}
	
	@Override
	public Organization selectBySelective(Organization record) {
		List<Organization> selectList = this.selectList(record);
		if(selectList!=null && !(selectList.isEmpty())){
			return selectList.get(0);
		}else{
			return null;
		}
	}

	@Override
	public int updateByPrimaryKeySelective(Organization record) {
		return organizationMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(Organization record) {
		return organizationMapper.updateByPrimaryKey(record);
	}
	 
	@Override
	public List<Organization> selectList(
			Organization record) {
		PageInfo pageInfo = new PageInfo();
		pageInfo.setPageNumber(1);
		pageInfo.setPageSize(Integer.MAX_VALUE);
		return this.selectList(record, pageInfo).getList(); 
	}
	
	@Override
	public PaginatedListHelper selectList(
			Organization record,PageInfo pageInfo) {
		if(record==null){
			record = new Organization();
		}
		List<Organization> list = organizationMapper.selectList(record,pageInfo); 
		PaginatedListHelper helper = new PaginatedListHelper();		
//		helper.setPageNumber(pageInfo.getPageNumber());
//		helper.setPageSize(pageInfo.getPageSize());		
		helper.setList(list);
		helper.setFullListSize(pageInfo.getTotalCount());
		
		return helper; 
	}
	
}
