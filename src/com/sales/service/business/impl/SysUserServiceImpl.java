package com.sales.service.business.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import com.sales.dao.business.SysUserMapper;
import com.sales.model.business.SysUser;
import com.sales.service.business.SysUserService;
import com.sales.util.pager.helper.PageInfo;
import com.sales.util.pager.helper.PaginatedListHelper;

@Service("sysUserService")
public class SysUserServiceImpl implements SysUserService {
	
	@Resource
	private SysUserMapper sysUserMapper;
	
	@Override
	public int deleteByPrimaryKey(Long id) {
		return sysUserMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(SysUser record) {
		return sysUserMapper.insert(record);
	}

	@Override
	public int insertSelective(SysUser record) {
		return sysUserMapper.insertSelective(record);
	}

	@Override
	public SysUser selectByPrimaryKey(Long id) {
		return sysUserMapper.selectByPrimaryKey(id);
	}
	
	@Override
	public SysUser selectBySelective(SysUser record) {
		List<SysUser> selectList = this.selectList(record);
		if(selectList!=null && !(selectList.isEmpty())){
			return selectList.get(0);
		}else{
			return null;
		}
	}

	@Override
	public int updateByPrimaryKeySelective(SysUser record) {
		return sysUserMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(SysUser record) {
		return sysUserMapper.updateByPrimaryKey(record);
	}
	 
	@Override
	public List<SysUser> selectList(
			SysUser record) {
		PageInfo pageInfo = new PageInfo();
		pageInfo.setPageNumber(1);
		pageInfo.setPageSize(Integer.MAX_VALUE);
		return this.selectList(record, pageInfo).getList(); 
	}
	
	@Override
	public PaginatedListHelper selectList(
			SysUser record,PageInfo pageInfo) {
		if(record==null){
			record = new SysUser();
		}
		List<SysUser> list = sysUserMapper.selectList(record,pageInfo); 
		PaginatedListHelper helper = new PaginatedListHelper();		
//		helper.setPageNumber(pageInfo.getPageNumber());
//		helper.setPageSize(pageInfo.getPageSize());		
		helper.setList(list);
		helper.setFullListSize(pageInfo.getTotalCount());
		
		return helper; 
	}
	
}
