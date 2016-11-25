package com.sales.service.business.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import com.sales.dao.business.SysAreaMapper;
import com.sales.model.business.SysArea;
import com.sales.service.business.SysAreaService;
import com.sales.util.pager.helper.PageInfo;
import com.sales.util.pager.helper.PaginatedListHelper;

@Service("sysAreaService")
public class SysAreaServiceImpl implements SysAreaService {
	
	@Resource
	private SysAreaMapper sysAreaMapper;
	
	@Override
	public int deleteByPrimaryKey(Long id) {
		return sysAreaMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(SysArea record) {
		return sysAreaMapper.insert(record);
	}

	@Override
	public int insertSelective(SysArea record) {
		return sysAreaMapper.insertSelective(record);
	}

	@Override
	public SysArea selectByPrimaryKey(Long id) {
		return sysAreaMapper.selectByPrimaryKey(id);
	}
	
	@Override
	public SysArea selectBySelective(SysArea record) {
		List<SysArea> selectList = this.selectList(record);
		if(selectList!=null && !(selectList.isEmpty())){
			return selectList.get(0);
		}else{
			return null;
		}
	}

	@Override
	public int updateByPrimaryKeySelective(SysArea record) {
		return sysAreaMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(SysArea record) {
		return sysAreaMapper.updateByPrimaryKey(record);
	}
	 
	@Override
	public List<SysArea> selectList(
			SysArea record) {
		PageInfo pageInfo = new PageInfo();
		pageInfo.setPageNumber(1);
		pageInfo.setPageSize(Integer.MAX_VALUE);
		return this.selectList(record, pageInfo).getList(); 
	}
	
	@Override
	public PaginatedListHelper selectList(
			SysArea record,PageInfo pageInfo) {
		if(record==null){
			record = new SysArea();
		}
		List<SysArea> list = sysAreaMapper.selectList(record,pageInfo); 
		PaginatedListHelper helper = new PaginatedListHelper();		
//		helper.setPageNumber(pageInfo.getPageNumber());
//		helper.setPageSize(pageInfo.getPageSize());		
		helper.setList(list);
		helper.setFullListSize(pageInfo.getTotalCount());
		
		return helper; 
	}
	
}
