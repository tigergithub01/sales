package com.sales.service.business.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import com.sales.dao.business.SysRoleMapper;
import com.sales.model.business.SysRole;
import com.sales.service.business.SysRoleService;
import com.sales.util.pager.helper.PageInfo;
import com.sales.util.pager.helper.PaginatedListHelper;

@Service("sysRoleService")
public class SysRoleServiceImpl implements SysRoleService {
	
	@Resource
	private SysRoleMapper sysRoleMapper;
	
	@Override
	public int deleteByPrimaryKey(Long id) {
		return sysRoleMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(SysRole record) {
		return sysRoleMapper.insert(record);
	}

	@Override
	public int insertSelective(SysRole record) {
		return sysRoleMapper.insertSelective(record);
	}

	@Override
	public SysRole selectByPrimaryKey(Long id) {
		return sysRoleMapper.selectByPrimaryKey(id);
	}
	
	@Override
	public SysRole selectBySelective(SysRole record) {
		List<SysRole> selectList = this.selectList(record);
		if(selectList!=null && !(selectList.isEmpty())){
			return selectList.get(0);
		}else{
			return null;
		}
	}

	@Override
	public int updateByPrimaryKeySelective(SysRole record) {
		return sysRoleMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(SysRole record) {
		return sysRoleMapper.updateByPrimaryKey(record);
	}
	 
	@Override
	public List<SysRole> selectList(
			SysRole record) {
		PageInfo pageInfo = new PageInfo();
		pageInfo.setPageNumber(1);
		pageInfo.setPageSize(Integer.MAX_VALUE);
		return this.selectList(record, pageInfo).getList(); 
	}
	
	@Override
	public PaginatedListHelper selectList(
			SysRole record,PageInfo pageInfo) {
		if(record==null){
			record = new SysRole();
		}
		List<SysRole> list = sysRoleMapper.selectList(record,pageInfo); 
		PaginatedListHelper helper = new PaginatedListHelper();		
//		helper.setPageNumber(pageInfo.getPageNumber());
//		helper.setPageSize(pageInfo.getPageSize());		
		helper.setList(list);
		helper.setFullListSize(pageInfo.getTotalCount());
		
		return helper; 
	}
	
}
