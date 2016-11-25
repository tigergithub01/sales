package com.sales.service.business.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import com.sales.dao.business.OaWkfLogMapper;
import com.sales.model.business.OaWkfLog;
import com.sales.service.business.OaWkfLogService;
import com.sales.util.pager.helper.PageInfo;
import com.sales.util.pager.helper.PaginatedListHelper;

@Service("oaWkfLogService")
public class OaWkfLogServiceImpl implements OaWkfLogService {
	
	@Resource
	private OaWkfLogMapper oaWkfLogMapper;
	
	@Override
	public int deleteByPrimaryKey(Long id) {
		return oaWkfLogMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(OaWkfLog record) {
		return oaWkfLogMapper.insert(record);
	}

	@Override
	public int insertSelective(OaWkfLog record) {
		return oaWkfLogMapper.insertSelective(record);
	}

	@Override
	public OaWkfLog selectByPrimaryKey(Long id) {
		return oaWkfLogMapper.selectByPrimaryKey(id);
	}
	
	@Override
	public OaWkfLog selectBySelective(OaWkfLog record) {
		List<OaWkfLog> selectList = this.selectList(record);
		if(selectList!=null && !(selectList.isEmpty())){
			return selectList.get(0);
		}else{
			return null;
		}
	}

	@Override
	public int updateByPrimaryKeySelective(OaWkfLog record) {
		return oaWkfLogMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(OaWkfLog record) {
		return oaWkfLogMapper.updateByPrimaryKey(record);
	}
	 
	@Override
	public List<OaWkfLog> selectList(
			OaWkfLog record) {
		PageInfo pageInfo = new PageInfo();
		pageInfo.setPageNumber(1);
		pageInfo.setPageSize(Integer.MAX_VALUE);
		return this.selectList(record, pageInfo).getList(); 
	}
	
	@Override
	public PaginatedListHelper selectList(
			OaWkfLog record,PageInfo pageInfo) {
		if(record==null){
			record = new OaWkfLog();
		}
		List<OaWkfLog> list = oaWkfLogMapper.selectList(record,pageInfo); 
		PaginatedListHelper helper = new PaginatedListHelper();		
//		helper.setPageNumber(pageInfo.getPageNumber());
//		helper.setPageSize(pageInfo.getPageSize());		
		helper.setList(list);
		helper.setFullListSize(pageInfo.getTotalCount());
		
		return helper; 
	}
	
}
