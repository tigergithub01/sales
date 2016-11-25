package com.sales.service.business.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import com.sales.dao.business.SysAppInfoMapper;
import com.sales.model.business.SysAppInfo;
import com.sales.service.business.SysAppInfoService;
import com.sales.util.pager.helper.PageInfo;
import com.sales.util.pager.helper.PaginatedListHelper;

@Service("sysAppInfoService")
public class SysAppInfoServiceImpl implements SysAppInfoService {
	
	@Resource
	private SysAppInfoMapper sysAppInfoMapper;
	
	@Override
	public int deleteByPrimaryKey(Long id) {
		return sysAppInfoMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(SysAppInfo record) {
		return sysAppInfoMapper.insert(record);
	}

	@Override
	public int insertSelective(SysAppInfo record) {
		return sysAppInfoMapper.insertSelective(record);
	}

	@Override
	public SysAppInfo selectByPrimaryKey(Long id) {
		return sysAppInfoMapper.selectByPrimaryKey(id);
	}
	
	@Override
	public SysAppInfo selectBySelective(SysAppInfo record) {
		List<SysAppInfo> selectList = this.selectList(record);
		if(selectList!=null && !(selectList.isEmpty())){
			return selectList.get(0);
		}else{
			return null;
		}
	}

	@Override
	public int updateByPrimaryKeySelective(SysAppInfo record) {
		return sysAppInfoMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(SysAppInfo record) {
		return sysAppInfoMapper.updateByPrimaryKey(record);
	}
	 
	@Override
	public List<SysAppInfo> selectList(
			SysAppInfo record) {
		PageInfo pageInfo = new PageInfo();
		pageInfo.setPageNumber(1);
		pageInfo.setPageSize(Integer.MAX_VALUE);
		return this.selectList(record, pageInfo).getList(); 
	}
	
	@Override
	public PaginatedListHelper selectList(
			SysAppInfo record,PageInfo pageInfo) {
		if(record==null){
			record = new SysAppInfo();
		}
		List<SysAppInfo> list = sysAppInfoMapper.selectList(record,pageInfo); 
		PaginatedListHelper helper = new PaginatedListHelper();		
//		helper.setPageNumber(pageInfo.getPageNumber());
//		helper.setPageSize(pageInfo.getPageSize());		
		helper.setList(list);
		helper.setFullListSize(pageInfo.getTotalCount());
		
		return helper; 
	}
	
}
