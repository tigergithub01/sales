package com.sales.service.business.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import com.sales.dao.business.SysConfigDetailMapper;
import com.sales.model.business.SysConfigDetail;
import com.sales.service.business.SysConfigDetailService;
import com.sales.util.pager.helper.PageInfo;
import com.sales.util.pager.helper.PaginatedListHelper;

@Service("sysConfigDetailService")
public class SysConfigDetailServiceImpl implements SysConfigDetailService {
	
	@Resource
	private SysConfigDetailMapper sysConfigDetailMapper;
	
	@Override
	public int deleteByPrimaryKey(Long id) {
		return sysConfigDetailMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(SysConfigDetail record) {
		return sysConfigDetailMapper.insert(record);
	}

	@Override
	public int insertSelective(SysConfigDetail record) {
		return sysConfigDetailMapper.insertSelective(record);
	}

	@Override
	public SysConfigDetail selectByPrimaryKey(Long id) {
		return sysConfigDetailMapper.selectByPrimaryKey(id);
	}
	
	@Override
	public SysConfigDetail selectBySelective(SysConfigDetail record) {
		List<SysConfigDetail> selectList = this.selectList(record);
		if(selectList!=null && !(selectList.isEmpty())){
			return selectList.get(0);
		}else{
			return null;
		}
	}

	@Override
	public int updateByPrimaryKeySelective(SysConfigDetail record) {
		return sysConfigDetailMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(SysConfigDetail record) {
		return sysConfigDetailMapper.updateByPrimaryKey(record);
	}
	 
	@Override
	public List<SysConfigDetail> selectList(
			SysConfigDetail record) {
		PageInfo pageInfo = new PageInfo();
		pageInfo.setPageNumber(1);
		pageInfo.setPageSize(Integer.MAX_VALUE);
		return this.selectList(record, pageInfo).getList(); 
	}
	
	@Override
	public PaginatedListHelper selectList(
			SysConfigDetail record,PageInfo pageInfo) {
		if(record==null){
			record = new SysConfigDetail();
		}
		List<SysConfigDetail> list = sysConfigDetailMapper.selectList(record,pageInfo); 
		PaginatedListHelper helper = new PaginatedListHelper();		
//		helper.setPageNumber(pageInfo.getPageNumber());
//		helper.setPageSize(pageInfo.getPageSize());		
		helper.setList(list);
		helper.setFullListSize(pageInfo.getTotalCount());
		
		return helper; 
	}
	
}
