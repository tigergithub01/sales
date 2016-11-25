package com.sales.service.business.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import com.sales.dao.business.SysConfigMapper;
import com.sales.model.business.SysConfig;
import com.sales.service.business.SysConfigService;
import com.sales.util.pager.helper.PageInfo;
import com.sales.util.pager.helper.PaginatedListHelper;

@Service("sysConfigService")
public class SysConfigServiceImpl implements SysConfigService {
	
	@Resource
	private SysConfigMapper sysConfigMapper;
	
	@Override
	public int deleteByPrimaryKey(Long id) {
		return sysConfigMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(SysConfig record) {
		return sysConfigMapper.insert(record);
	}

	@Override
	public int insertSelective(SysConfig record) {
		return sysConfigMapper.insertSelective(record);
	}

	@Override
	public SysConfig selectByPrimaryKey(Long id) {
		return sysConfigMapper.selectByPrimaryKey(id);
	}
	
	@Override
	public SysConfig selectBySelective(SysConfig record) {
		List<SysConfig> selectList = this.selectList(record);
		if(selectList!=null && !(selectList.isEmpty())){
			return selectList.get(0);
		}else{
			return null;
		}
	}

	@Override
	public int updateByPrimaryKeySelective(SysConfig record) {
		return sysConfigMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(SysConfig record) {
		return sysConfigMapper.updateByPrimaryKey(record);
	}
	 
	@Override
	public List<SysConfig> selectList(
			SysConfig record) {
		PageInfo pageInfo = new PageInfo();
		pageInfo.setPageNumber(1);
		pageInfo.setPageSize(Integer.MAX_VALUE);
		return this.selectList(record, pageInfo).getList(); 
	}
	
	@Override
	public PaginatedListHelper selectList(
			SysConfig record,PageInfo pageInfo) {
		if(record==null){
			record = new SysConfig();
		}
		List<SysConfig> list = sysConfigMapper.selectList(record,pageInfo); 
		PaginatedListHelper helper = new PaginatedListHelper();		
//		helper.setPageNumber(pageInfo.getPageNumber());
//		helper.setPageSize(pageInfo.getPageSize());		
		helper.setList(list);
		helper.setFullListSize(pageInfo.getTotalCount());
		
		return helper; 
	}
	
}
