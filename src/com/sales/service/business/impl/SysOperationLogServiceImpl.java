package com.sales.service.business.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import com.sales.dao.business.SysOperationLogMapper;
import com.sales.model.business.SysOperationLog;
import com.sales.service.business.SysOperationLogService;
import com.sales.util.pager.helper.PageInfo;
import com.sales.util.pager.helper.PaginatedListHelper;

@Service("sysOperationLogService")
public class SysOperationLogServiceImpl implements SysOperationLogService {
	
	@Resource
	private SysOperationLogMapper sysOperationLogMapper;
	
	@Override
	public int deleteByPrimaryKey(Long id) {
		return sysOperationLogMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(SysOperationLog record) {
		return sysOperationLogMapper.insert(record);
	}

	@Override
	public int insertSelective(SysOperationLog record) {
		return sysOperationLogMapper.insertSelective(record);
	}

	@Override
	public SysOperationLog selectByPrimaryKey(Long id) {
		return sysOperationLogMapper.selectByPrimaryKey(id);
	}
	
	@Override
	public SysOperationLog selectBySelective(SysOperationLog record) {
		List<SysOperationLog> selectList = this.selectList(record);
		if(selectList!=null && !(selectList.isEmpty())){
			return selectList.get(0);
		}else{
			return null;
		}
	}

	@Override
	public int updateByPrimaryKeySelective(SysOperationLog record) {
		return sysOperationLogMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(SysOperationLog record) {
		return sysOperationLogMapper.updateByPrimaryKey(record);
	}
	 
	@Override
	public List<SysOperationLog> selectList(
			SysOperationLog record) {
		PageInfo pageInfo = new PageInfo();
		pageInfo.setPageNumber(1);
		pageInfo.setPageSize(Integer.MAX_VALUE);
		return this.selectList(record, pageInfo).getList(); 
	}
	
	@Override
	public PaginatedListHelper selectList(
			SysOperationLog record,PageInfo pageInfo) {
		if(record==null){
			record = new SysOperationLog();
		}
		List<SysOperationLog> list = sysOperationLogMapper.selectList(record,pageInfo); 
		PaginatedListHelper helper = new PaginatedListHelper();		
//		helper.setPageNumber(pageInfo.getPageNumber());
//		helper.setPageSize(pageInfo.getPageSize());		
		helper.setList(list);
		helper.setFullListSize(pageInfo.getTotalCount());
		
		return helper; 
	}
	
}
