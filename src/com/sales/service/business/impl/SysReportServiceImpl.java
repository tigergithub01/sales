package com.sales.service.business.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import com.sales.dao.business.SysReportMapper;
import com.sales.model.business.SysReport;
import com.sales.service.business.SysReportService;
import com.sales.util.pager.helper.PageInfo;
import com.sales.util.pager.helper.PaginatedListHelper;

@Service("sysReportService")
public class SysReportServiceImpl implements SysReportService {
	
	@Resource
	private SysReportMapper sysReportMapper;
	
	@Override
	public int deleteByPrimaryKey(Long id) {
		return sysReportMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(SysReport record) {
		return sysReportMapper.insert(record);
	}

	@Override
	public int insertSelective(SysReport record) {
		return sysReportMapper.insertSelective(record);
	}

	@Override
	public SysReport selectByPrimaryKey(Long id) {
		return sysReportMapper.selectByPrimaryKey(id);
	}
	
	@Override
	public SysReport selectBySelective(SysReport record) {
		List<SysReport> selectList = this.selectList(record);
		if(selectList!=null && !(selectList.isEmpty())){
			return selectList.get(0);
		}else{
			return null;
		}
	}

	@Override
	public int updateByPrimaryKeySelective(SysReport record) {
		return sysReportMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(SysReport record) {
		return sysReportMapper.updateByPrimaryKey(record);
	}
	 
	@Override
	public List<SysReport> selectList(
			SysReport record) {
		PageInfo pageInfo = new PageInfo();
		pageInfo.setPageNumber(1);
		pageInfo.setPageSize(Integer.MAX_VALUE);
		return this.selectList(record, pageInfo).getList(); 
	}
	
	@Override
	public PaginatedListHelper selectList(
			SysReport record,PageInfo pageInfo) {
		if(record==null){
			record = new SysReport();
		}
		List<SysReport> list = sysReportMapper.selectList(record,pageInfo); 
		PaginatedListHelper helper = new PaginatedListHelper();		
//		helper.setPageNumber(pageInfo.getPageNumber());
//		helper.setPageSize(pageInfo.getPageSize());		
		helper.setList(list);
		helper.setFullListSize(pageInfo.getTotalCount());
		
		return helper; 
	}
	
}
