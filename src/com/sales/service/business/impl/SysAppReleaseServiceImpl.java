package com.sales.service.business.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import com.sales.dao.business.SysAppReleaseMapper;
import com.sales.model.business.SysAppRelease;
import com.sales.service.business.SysAppReleaseService;
import com.sales.util.pager.helper.PageInfo;
import com.sales.util.pager.helper.PaginatedListHelper;

@Service("sysAppReleaseService")
public class SysAppReleaseServiceImpl implements SysAppReleaseService {
	
	@Resource
	private SysAppReleaseMapper sysAppReleaseMapper;
	
	@Override
	public int deleteByPrimaryKey(Long id) {
		return sysAppReleaseMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(SysAppRelease record) {
		return sysAppReleaseMapper.insert(record);
	}

	@Override
	public int insertSelective(SysAppRelease record) {
		return sysAppReleaseMapper.insertSelective(record);
	}

	@Override
	public SysAppRelease selectByPrimaryKey(Long id) {
		return sysAppReleaseMapper.selectByPrimaryKey(id);
	}
	
	@Override
	public SysAppRelease selectBySelective(SysAppRelease record) {
		List<SysAppRelease> selectList = this.selectList(record);
		if(selectList!=null && !(selectList.isEmpty())){
			return selectList.get(0);
		}else{
			return null;
		}
	}

	@Override
	public int updateByPrimaryKeySelective(SysAppRelease record) {
		return sysAppReleaseMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(SysAppRelease record) {
		return sysAppReleaseMapper.updateByPrimaryKey(record);
	}
	 
	@Override
	public List<SysAppRelease> selectList(
			SysAppRelease record) {
		PageInfo pageInfo = new PageInfo();
		pageInfo.setPageNumber(1);
		pageInfo.setPageSize(Integer.MAX_VALUE);
		return this.selectList(record, pageInfo).getList(); 
	}
	
	@Override
	public PaginatedListHelper selectList(
			SysAppRelease record,PageInfo pageInfo) {
		if(record==null){
			record = new SysAppRelease();
		}
		List<SysAppRelease> list = sysAppReleaseMapper.selectList(record,pageInfo); 
		PaginatedListHelper helper = new PaginatedListHelper();		
//		helper.setPageNumber(pageInfo.getPageNumber());
//		helper.setPageSize(pageInfo.getPageSize());		
		helper.setList(list);
		helper.setFullListSize(pageInfo.getTotalCount());
		
		return helper; 
	}
	
}
