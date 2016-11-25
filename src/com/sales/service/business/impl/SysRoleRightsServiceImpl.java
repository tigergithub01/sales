package com.sales.service.business.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import com.sales.dao.business.SysRoleRightsMapper;
import com.sales.model.business.SysRoleRights;
import com.sales.service.business.SysRoleRightsService;
import com.sales.util.pager.helper.PageInfo;
import com.sales.util.pager.helper.PaginatedListHelper;

@Service("sysRoleRightsService")
public class SysRoleRightsServiceImpl implements SysRoleRightsService {
	
	@Resource
	private SysRoleRightsMapper sysRoleRightsMapper;
	
	@Override
	public int deleteByPrimaryKey(Long id) {
		return sysRoleRightsMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(SysRoleRights record) {
		return sysRoleRightsMapper.insert(record);
	}

	@Override
	public int insertSelective(SysRoleRights record) {
		return sysRoleRightsMapper.insertSelective(record);
	}

	@Override
	public SysRoleRights selectByPrimaryKey(Long id) {
		return sysRoleRightsMapper.selectByPrimaryKey(id);
	}
	
	@Override
	public SysRoleRights selectBySelective(SysRoleRights record) {
		List<SysRoleRights> selectList = this.selectList(record);
		if(selectList!=null && !(selectList.isEmpty())){
			return selectList.get(0);
		}else{
			return null;
		}
	}

	@Override
	public int updateByPrimaryKeySelective(SysRoleRights record) {
		return sysRoleRightsMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(SysRoleRights record) {
		return sysRoleRightsMapper.updateByPrimaryKey(record);
	}
	 
	@Override
	public List<SysRoleRights> selectList(
			SysRoleRights record) {
		PageInfo pageInfo = new PageInfo();
		pageInfo.setPageNumber(1);
		pageInfo.setPageSize(Integer.MAX_VALUE);
		return this.selectList(record, pageInfo).getList(); 
	}
	
	@Override
	public PaginatedListHelper selectList(
			SysRoleRights record,PageInfo pageInfo) {
		if(record==null){
			record = new SysRoleRights();
		}
		List<SysRoleRights> list = sysRoleRightsMapper.selectList(record,pageInfo); 
		PaginatedListHelper helper = new PaginatedListHelper();		
//		helper.setPageNumber(pageInfo.getPageNumber());
//		helper.setPageSize(pageInfo.getPageSize());		
		helper.setList(list);
		helper.setFullListSize(pageInfo.getTotalCount());
		
		return helper; 
	}
	
}
