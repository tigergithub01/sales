package com.sales.service.business.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import com.sales.dao.business.SysAuditLogMapper;
import com.sales.model.business.SysAuditLog;
import com.sales.service.business.SysAuditLogService;
import com.sales.util.pager.helper.PageInfo;
import com.sales.util.pager.helper.PaginatedListHelper;

@Service("sysAuditLogService")
public class SysAuditLogServiceImpl implements SysAuditLogService {
	
	@Resource
	private SysAuditLogMapper sysAuditLogMapper;
	
	@Override
	public int deleteByPrimaryKey(Long id) {
		return sysAuditLogMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(SysAuditLog record) {
		return sysAuditLogMapper.insert(record);
	}

	@Override
	public int insertSelective(SysAuditLog record) {
		return sysAuditLogMapper.insertSelective(record);
	}

	@Override
	public SysAuditLog selectByPrimaryKey(Long id) {
		return sysAuditLogMapper.selectByPrimaryKey(id);
	}
	
	@Override
	public SysAuditLog selectBySelective(SysAuditLog record) {
		List<SysAuditLog> selectList = this.selectList(record);
		if(selectList!=null && !(selectList.isEmpty())){
			return selectList.get(0);
		}else{
			return null;
		}
	}

	@Override
	public int updateByPrimaryKeySelective(SysAuditLog record) {
		return sysAuditLogMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(SysAuditLog record) {
		return sysAuditLogMapper.updateByPrimaryKey(record);
	}
	 
	@Override
	public List<SysAuditLog> selectList(
			SysAuditLog record) {
		PageInfo pageInfo = new PageInfo();
		pageInfo.setPageNumber(1);
		pageInfo.setPageSize(Integer.MAX_VALUE);
		return this.selectList(record, pageInfo).getList(); 
	}
	
	@Override
	public PaginatedListHelper selectList(
			SysAuditLog record,PageInfo pageInfo) {
		if(record==null){
			record = new SysAuditLog();
		}
		List<SysAuditLog> list = sysAuditLogMapper.selectList(record,pageInfo); 
		PaginatedListHelper helper = new PaginatedListHelper();		
//		helper.setPageNumber(pageInfo.getPageNumber());
//		helper.setPageSize(pageInfo.getPageSize());		
		helper.setList(list);
		helper.setFullListSize(pageInfo.getTotalCount());
		
		return helper; 
	}
	
}
