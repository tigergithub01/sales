package com.sales.service.business.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import com.sales.dao.business.SysUnitMapper;
import com.sales.model.business.SysUnit;
import com.sales.service.business.SysUnitService;
import com.sales.util.pager.helper.PageInfo;
import com.sales.util.pager.helper.PaginatedListHelper;

@Service("sysUnitService")
public class SysUnitServiceImpl implements SysUnitService {
	
	@Resource
	private SysUnitMapper sysUnitMapper;
	
	@Override
	public int deleteByPrimaryKey(Long id) {
		return sysUnitMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(SysUnit record) {
		return sysUnitMapper.insert(record);
	}

	@Override
	public int insertSelective(SysUnit record) {
		return sysUnitMapper.insertSelective(record);
	}

	@Override
	public SysUnit selectByPrimaryKey(Long id) {
		return sysUnitMapper.selectByPrimaryKey(id);
	}
	
	@Override
	public SysUnit selectBySelective(SysUnit record) {
		List<SysUnit> selectList = this.selectList(record);
		if(selectList!=null && !(selectList.isEmpty())){
			return selectList.get(0);
		}else{
			return null;
		}
	}

	@Override
	public int updateByPrimaryKeySelective(SysUnit record) {
		return sysUnitMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(SysUnit record) {
		return sysUnitMapper.updateByPrimaryKey(record);
	}
	 
	@Override
	public List<SysUnit> selectList(
			SysUnit record) {
		PageInfo pageInfo = new PageInfo();
		pageInfo.setPageNumber(1);
		pageInfo.setPageSize(Integer.MAX_VALUE);
		return this.selectList(record, pageInfo).getList(); 
	}
	
	@Override
	public PaginatedListHelper selectList(
			SysUnit record,PageInfo pageInfo) {
		if(record==null){
			record = new SysUnit();
		}
		List<SysUnit> list = sysUnitMapper.selectList(record,pageInfo); 
		PaginatedListHelper helper = new PaginatedListHelper();		
//		helper.setPageNumber(pageInfo.getPageNumber());
//		helper.setPageSize(pageInfo.getPageSize());		
		helper.setList(list);
		helper.setFullListSize(pageInfo.getTotalCount());
		
		return helper; 
	}
	
}
