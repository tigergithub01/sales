package com.sales.service.business.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import com.sales.dao.business.SysTaskQuartzMapper;
import com.sales.model.business.SysTaskQuartz;
import com.sales.service.business.SysTaskQuartzService;
import com.sales.util.pager.helper.PageInfo;
import com.sales.util.pager.helper.PaginatedListHelper;

@Service("sysTaskQuartzService")
public class SysTaskQuartzServiceImpl implements SysTaskQuartzService {
	
	@Resource
	private SysTaskQuartzMapper sysTaskQuartzMapper;
	
	@Override
	public int deleteByPrimaryKey(Long id) {
		return sysTaskQuartzMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(SysTaskQuartz record) {
		return sysTaskQuartzMapper.insert(record);
	}

	@Override
	public int insertSelective(SysTaskQuartz record) {
		return sysTaskQuartzMapper.insertSelective(record);
	}

	@Override
	public SysTaskQuartz selectByPrimaryKey(Long id) {
		return sysTaskQuartzMapper.selectByPrimaryKey(id);
	}
	
	@Override
	public SysTaskQuartz selectBySelective(SysTaskQuartz record) {
		List<SysTaskQuartz> selectList = this.selectList(record);
		if(selectList!=null && !(selectList.isEmpty())){
			return selectList.get(0);
		}else{
			return null;
		}
	}

	@Override
	public int updateByPrimaryKeySelective(SysTaskQuartz record) {
		return sysTaskQuartzMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(SysTaskQuartz record) {
		return sysTaskQuartzMapper.updateByPrimaryKey(record);
	}
	 
	@Override
	public List<SysTaskQuartz> selectList(
			SysTaskQuartz record) {
		PageInfo pageInfo = new PageInfo();
		pageInfo.setPageNumber(1);
		pageInfo.setPageSize(Integer.MAX_VALUE);
		return this.selectList(record, pageInfo).getList(); 
	}
	
	@Override
	public PaginatedListHelper selectList(
			SysTaskQuartz record,PageInfo pageInfo) {
		if(record==null){
			record = new SysTaskQuartz();
		}
		List<SysTaskQuartz> list = sysTaskQuartzMapper.selectList(record,pageInfo); 
		PaginatedListHelper helper = new PaginatedListHelper();		
//		helper.setPageNumber(pageInfo.getPageNumber());
//		helper.setPageSize(pageInfo.getPageSize());		
		helper.setList(list);
		helper.setFullListSize(pageInfo.getTotalCount());
		
		return helper; 
	}
	
}
