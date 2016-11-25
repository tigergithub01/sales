package com.sales.service.business.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import com.sales.dao.business.SysRegionMapper;
import com.sales.model.business.SysRegion;
import com.sales.service.business.SysRegionService;
import com.sales.util.pager.helper.PageInfo;
import com.sales.util.pager.helper.PaginatedListHelper;

@Service("sysRegionService")
public class SysRegionServiceImpl implements SysRegionService {
	
	@Resource
	private SysRegionMapper sysRegionMapper;
	
	@Override
	public int deleteByPrimaryKey(Long id) {
		return sysRegionMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(SysRegion record) {
		return sysRegionMapper.insert(record);
	}

	@Override
	public int insertSelective(SysRegion record) {
		return sysRegionMapper.insertSelective(record);
	}

	@Override
	public SysRegion selectByPrimaryKey(Long id) {
		return sysRegionMapper.selectByPrimaryKey(id);
	}
	
	@Override
	public SysRegion selectBySelective(SysRegion record) {
		List<SysRegion> selectList = this.selectList(record);
		if(selectList!=null && !(selectList.isEmpty())){
			return selectList.get(0);
		}else{
			return null;
		}
	}

	@Override
	public int updateByPrimaryKeySelective(SysRegion record) {
		return sysRegionMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(SysRegion record) {
		return sysRegionMapper.updateByPrimaryKey(record);
	}
	 
	@Override
	public List<SysRegion> selectList(
			SysRegion record) {
		PageInfo pageInfo = new PageInfo();
		pageInfo.setPageNumber(1);
		pageInfo.setPageSize(Integer.MAX_VALUE);
		return this.selectList(record, pageInfo).getList(); 
	}
	
	@Override
	public PaginatedListHelper selectList(
			SysRegion record,PageInfo pageInfo) {
		if(record==null){
			record = new SysRegion();
		}
		List<SysRegion> list = sysRegionMapper.selectList(record,pageInfo); 
		PaginatedListHelper helper = new PaginatedListHelper();		
//		helper.setPageNumber(pageInfo.getPageNumber());
//		helper.setPageSize(pageInfo.getPageSize());		
		helper.setList(list);
		helper.setFullListSize(pageInfo.getTotalCount());
		
		return helper; 
	}
	
}
