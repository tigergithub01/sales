package com.sales.service.business.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import com.sales.dao.business.SysRoleUserMapper;
import com.sales.model.business.SysRoleUser;
import com.sales.service.business.SysRoleUserService;
import com.sales.util.pager.helper.PageInfo;
import com.sales.util.pager.helper.PaginatedListHelper;

@Service("sysRoleUserService")
public class SysRoleUserServiceImpl implements SysRoleUserService {
	
	@Resource
	private SysRoleUserMapper sysRoleUserMapper;
	
	@Override
	public int deleteByPrimaryKey(Long id) {
		return sysRoleUserMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(SysRoleUser record) {
		return sysRoleUserMapper.insert(record);
	}

	@Override
	public int insertSelective(SysRoleUser record) {
		return sysRoleUserMapper.insertSelective(record);
	}

	@Override
	public SysRoleUser selectByPrimaryKey(Long id) {
		return sysRoleUserMapper.selectByPrimaryKey(id);
	}
	
	@Override
	public SysRoleUser selectBySelective(SysRoleUser record) {
		List<SysRoleUser> selectList = this.selectList(record);
		if(selectList!=null && !(selectList.isEmpty())){
			return selectList.get(0);
		}else{
			return null;
		}
	}

	@Override
	public int updateByPrimaryKeySelective(SysRoleUser record) {
		return sysRoleUserMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(SysRoleUser record) {
		return sysRoleUserMapper.updateByPrimaryKey(record);
	}
	 
	@Override
	public List<SysRoleUser> selectList(
			SysRoleUser record) {
		PageInfo pageInfo = new PageInfo();
		pageInfo.setPageNumber(1);
		pageInfo.setPageSize(Integer.MAX_VALUE);
		return this.selectList(record, pageInfo).getList(); 
	}
	
	@Override
	public PaginatedListHelper selectList(
			SysRoleUser record,PageInfo pageInfo) {
		if(record==null){
			record = new SysRoleUser();
		}
		List<SysRoleUser> list = sysRoleUserMapper.selectList(record,pageInfo); 
		PaginatedListHelper helper = new PaginatedListHelper();		
//		helper.setPageNumber(pageInfo.getPageNumber());
//		helper.setPageSize(pageInfo.getPageSize());		
		helper.setList(list);
		helper.setFullListSize(pageInfo.getTotalCount());
		
		return helper; 
	}
	
}
