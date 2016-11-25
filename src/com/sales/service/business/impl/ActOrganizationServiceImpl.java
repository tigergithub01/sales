package com.sales.service.business.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import com.sales.dao.business.ActOrganizationMapper;
import com.sales.model.business.ActOrganization;
import com.sales.service.business.ActOrganizationService;
import com.sales.util.pager.helper.PageInfo;
import com.sales.util.pager.helper.PaginatedListHelper;

@Service("actOrganizationService")
public class ActOrganizationServiceImpl implements ActOrganizationService {
	
	@Resource
	private ActOrganizationMapper actOrganizationMapper;
	
	@Override
	public int deleteByPrimaryKey(Long id) {
		return actOrganizationMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(ActOrganization record) {
		return actOrganizationMapper.insert(record);
	}

	@Override
	public int insertSelective(ActOrganization record) {
		return actOrganizationMapper.insertSelective(record);
	}

	@Override
	public ActOrganization selectByPrimaryKey(Long id) {
		return actOrganizationMapper.selectByPrimaryKey(id);
	}
	
	@Override
	public ActOrganization selectBySelective(ActOrganization record) {
		List<ActOrganization> selectList = this.selectList(record);
		if(selectList!=null && !(selectList.isEmpty())){
			return selectList.get(0);
		}else{
			return null;
		}
	}

	@Override
	public int updateByPrimaryKeySelective(ActOrganization record) {
		return actOrganizationMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(ActOrganization record) {
		return actOrganizationMapper.updateByPrimaryKey(record);
	}
	 
	@Override
	public List<ActOrganization> selectList(
			ActOrganization record) {
		PageInfo pageInfo = new PageInfo();
		pageInfo.setPageNumber(1);
		pageInfo.setPageSize(Integer.MAX_VALUE);
		return this.selectList(record, pageInfo).getList(); 
	}
	
	@Override
	public PaginatedListHelper selectList(
			ActOrganization record,PageInfo pageInfo) {
		if(record==null){
			record = new ActOrganization();
		}
		List<ActOrganization> list = actOrganizationMapper.selectList(record,pageInfo); 
		PaginatedListHelper helper = new PaginatedListHelper();		
//		helper.setPageNumber(pageInfo.getPageNumber());
//		helper.setPageSize(pageInfo.getPageSize());		
		helper.setList(list);
		helper.setFullListSize(pageInfo.getTotalCount());
		
		return helper; 
	}
	
}
