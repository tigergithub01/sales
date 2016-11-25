package com.sales.service.business.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import com.sales.dao.business.SysModuleMapper;
import com.sales.model.business.SysModule;
import com.sales.service.business.SysModuleService;
import com.sales.util.pager.helper.PageInfo;
import com.sales.util.pager.helper.PaginatedListHelper;

@Service("sysModuleService")
public class SysModuleServiceImpl implements SysModuleService {
	
	@Resource
	private SysModuleMapper sysModuleMapper;
	
	@Override
	public int deleteByPrimaryKey(Long id) {
		return sysModuleMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(SysModule record) {
		return sysModuleMapper.insert(record);
	}

	@Override
	public int insertSelective(SysModule record) {
		return sysModuleMapper.insertSelective(record);
	}

	@Override
	public SysModule selectByPrimaryKey(Long id) {
		return sysModuleMapper.selectByPrimaryKey(id);
	}
	
	@Override
	public SysModule selectBySelective(SysModule record) {
		List<SysModule> selectList = this.selectList(record);
		if(selectList!=null && !(selectList.isEmpty())){
			return selectList.get(0);
		}else{
			return null;
		}
	}

	@Override
	public int updateByPrimaryKeySelective(SysModule record) {
		return sysModuleMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(SysModule record) {
		return sysModuleMapper.updateByPrimaryKey(record);
	}
	 
	@Override
	public List<SysModule> selectList(
			SysModule record) {
		PageInfo pageInfo = new PageInfo();
		pageInfo.setPageNumber(1);
		pageInfo.setPageSize(Integer.MAX_VALUE);
		return this.selectList(record, pageInfo).getList(); 
	}
	
	@Override
	public PaginatedListHelper selectList(
			SysModule record,PageInfo pageInfo) {
		if(record==null){
			record = new SysModule();
		}
		List<SysModule> list = sysModuleMapper.selectList(record,pageInfo); 
		PaginatedListHelper helper = new PaginatedListHelper();		
//		helper.setPageNumber(pageInfo.getPageNumber());
//		helper.setPageSize(pageInfo.getPageSize());		
		helper.setList(list);
		helper.setFullListSize(pageInfo.getTotalCount());
		
		return helper; 
	}
	
}
