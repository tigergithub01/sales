package com.sales.service.business.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import com.sales.dao.business.OrgTypeMapper;
import com.sales.model.business.OrgType;
import com.sales.service.business.OrgTypeService;
import com.sales.util.pager.helper.PageInfo;
import com.sales.util.pager.helper.PaginatedListHelper;

@Service("orgTypeService")
public class OrgTypeServiceImpl implements OrgTypeService {
	
	@Resource
	private OrgTypeMapper orgTypeMapper;
	
	@Override
	public int deleteByPrimaryKey(Long id) {
		return orgTypeMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(OrgType record) {
		return orgTypeMapper.insert(record);
	}

	@Override
	public int insertSelective(OrgType record) {
		return orgTypeMapper.insertSelective(record);
	}

	@Override
	public OrgType selectByPrimaryKey(Long id) {
		return orgTypeMapper.selectByPrimaryKey(id);
	}
	
	@Override
	public OrgType selectBySelective(OrgType record) {
		List<OrgType> selectList = this.selectList(record);
		if(selectList!=null && !(selectList.isEmpty())){
			return selectList.get(0);
		}else{
			return null;
		}
	}

	@Override
	public int updateByPrimaryKeySelective(OrgType record) {
		return orgTypeMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(OrgType record) {
		return orgTypeMapper.updateByPrimaryKey(record);
	}
	 
	@Override
	public List<OrgType> selectList(
			OrgType record) {
		PageInfo pageInfo = new PageInfo();
		pageInfo.setPageNumber(1);
		pageInfo.setPageSize(Integer.MAX_VALUE);
		return this.selectList(record, pageInfo).getList(); 
	}
	
	@Override
	public PaginatedListHelper selectList(
			OrgType record,PageInfo pageInfo) {
		if(record==null){
			record = new OrgType();
		}
		List<OrgType> list = orgTypeMapper.selectList(record,pageInfo); 
		PaginatedListHelper helper = new PaginatedListHelper();		
//		helper.setPageNumber(pageInfo.getPageNumber());
//		helper.setPageSize(pageInfo.getPageSize());		
		helper.setList(list);
		helper.setFullListSize(pageInfo.getTotalCount());
		
		return helper; 
	}
	
}
