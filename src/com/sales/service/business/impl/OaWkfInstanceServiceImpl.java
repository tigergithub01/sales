package com.sales.service.business.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import com.sales.dao.business.OaWkfInstanceMapper;
import com.sales.model.business.OaWkfInstance;
import com.sales.service.business.OaWkfInstanceService;
import com.sales.util.pager.helper.PageInfo;
import com.sales.util.pager.helper.PaginatedListHelper;

@Service("oaWkfInstanceService")
public class OaWkfInstanceServiceImpl implements OaWkfInstanceService {
	
	@Resource
	private OaWkfInstanceMapper oaWkfInstanceMapper;
	
	@Override
	public int deleteByPrimaryKey(Long id) {
		return oaWkfInstanceMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(OaWkfInstance record) {
		return oaWkfInstanceMapper.insert(record);
	}

	@Override
	public int insertSelective(OaWkfInstance record) {
		return oaWkfInstanceMapper.insertSelective(record);
	}

	@Override
	public OaWkfInstance selectByPrimaryKey(Long id) {
		return oaWkfInstanceMapper.selectByPrimaryKey(id);
	}
	
	@Override
	public OaWkfInstance selectBySelective(OaWkfInstance record) {
		List<OaWkfInstance> selectList = this.selectList(record);
		if(selectList!=null && !(selectList.isEmpty())){
			return selectList.get(0);
		}else{
			return null;
		}
	}

	@Override
	public int updateByPrimaryKeySelective(OaWkfInstance record) {
		return oaWkfInstanceMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(OaWkfInstance record) {
		return oaWkfInstanceMapper.updateByPrimaryKey(record);
	}
	 
	@Override
	public List<OaWkfInstance> selectList(
			OaWkfInstance record) {
		PageInfo pageInfo = new PageInfo();
		pageInfo.setPageNumber(1);
		pageInfo.setPageSize(Integer.MAX_VALUE);
		return this.selectList(record, pageInfo).getList(); 
	}
	
	@Override
	public PaginatedListHelper selectList(
			OaWkfInstance record,PageInfo pageInfo) {
		if(record==null){
			record = new OaWkfInstance();
		}
		List<OaWkfInstance> list = oaWkfInstanceMapper.selectList(record,pageInfo); 
		PaginatedListHelper helper = new PaginatedListHelper();		
//		helper.setPageNumber(pageInfo.getPageNumber());
//		helper.setPageSize(pageInfo.getPageSize());		
		helper.setList(list);
		helper.setFullListSize(pageInfo.getTotalCount());
		
		return helper; 
	}
	
}
