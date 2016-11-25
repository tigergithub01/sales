package com.sales.service.business.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import com.sales.dao.business.SysOperationMapper;
import com.sales.model.business.SysOperation;
import com.sales.service.business.SysOperationService;
import com.sales.util.pager.helper.PageInfo;
import com.sales.util.pager.helper.PaginatedListHelper;

@Service("sysOperationService")
public class SysOperationServiceImpl implements SysOperationService {
	
	@Resource
	private SysOperationMapper sysOperationMapper;
	
	@Override
	public int deleteByPrimaryKey(Long id) {
		return sysOperationMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(SysOperation record) {
		return sysOperationMapper.insert(record);
	}

	@Override
	public int insertSelective(SysOperation record) {
		return sysOperationMapper.insertSelective(record);
	}

	@Override
	public SysOperation selectByPrimaryKey(Long id) {
		return sysOperationMapper.selectByPrimaryKey(id);
	}
	
	@Override
	public SysOperation selectBySelective(SysOperation record) {
		List<SysOperation> selectList = this.selectList(record);
		if(selectList!=null && !(selectList.isEmpty())){
			return selectList.get(0);
		}else{
			return null;
		}
	}

	@Override
	public int updateByPrimaryKeySelective(SysOperation record) {
		return sysOperationMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(SysOperation record) {
		return sysOperationMapper.updateByPrimaryKey(record);
	}
	 
	@Override
	public List<SysOperation> selectList(
			SysOperation record) {
		PageInfo pageInfo = new PageInfo();
		pageInfo.setPageNumber(1);
		pageInfo.setPageSize(Integer.MAX_VALUE);
		return this.selectList(record, pageInfo).getList(); 
	}
	
	@Override
	public PaginatedListHelper selectList(
			SysOperation record,PageInfo pageInfo) {
		if(record==null){
			record = new SysOperation();
		}
		List<SysOperation> list = sysOperationMapper.selectList(record,pageInfo); 
		PaginatedListHelper helper = new PaginatedListHelper();		
//		helper.setPageNumber(pageInfo.getPageNumber());
//		helper.setPageSize(pageInfo.getPageSize());		
		helper.setList(list);
		helper.setFullListSize(pageInfo.getTotalCount());
		
		return helper; 
	}
	
}
