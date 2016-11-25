package com.sales.service.business.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import com.sales.dao.business.OaSheetWkfDataMapper;
import com.sales.model.business.OaSheetWkfData;
import com.sales.service.business.OaSheetWkfDataService;
import com.sales.util.pager.helper.PageInfo;
import com.sales.util.pager.helper.PaginatedListHelper;

@Service("oaSheetWkfDataService")
public class OaSheetWkfDataServiceImpl implements OaSheetWkfDataService {
	
	@Resource
	private OaSheetWkfDataMapper oaSheetWkfDataMapper;
	
	@Override
	public int deleteByPrimaryKey(Long id) {
		return oaSheetWkfDataMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(OaSheetWkfData record) {
		return oaSheetWkfDataMapper.insert(record);
	}

	@Override
	public int insertSelective(OaSheetWkfData record) {
		return oaSheetWkfDataMapper.insertSelective(record);
	}

	@Override
	public OaSheetWkfData selectByPrimaryKey(Long id) {
		return oaSheetWkfDataMapper.selectByPrimaryKey(id);
	}
	
	@Override
	public OaSheetWkfData selectBySelective(OaSheetWkfData record) {
		List<OaSheetWkfData> selectList = this.selectList(record);
		if(selectList!=null && !(selectList.isEmpty())){
			return selectList.get(0);
		}else{
			return null;
		}
	}

	@Override
	public int updateByPrimaryKeySelective(OaSheetWkfData record) {
		return oaSheetWkfDataMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(OaSheetWkfData record) {
		return oaSheetWkfDataMapper.updateByPrimaryKey(record);
	}
	 
	@Override
	public List<OaSheetWkfData> selectList(
			OaSheetWkfData record) {
		PageInfo pageInfo = new PageInfo();
		pageInfo.setPageNumber(1);
		pageInfo.setPageSize(Integer.MAX_VALUE);
		return this.selectList(record, pageInfo).getList(); 
	}
	
	@Override
	public PaginatedListHelper selectList(
			OaSheetWkfData record,PageInfo pageInfo) {
		if(record==null){
			record = new OaSheetWkfData();
		}
		List<OaSheetWkfData> list = oaSheetWkfDataMapper.selectList(record,pageInfo); 
		PaginatedListHelper helper = new PaginatedListHelper();		
//		helper.setPageNumber(pageInfo.getPageNumber());
//		helper.setPageSize(pageInfo.getPageSize());		
		helper.setList(list);
		helper.setFullListSize(pageInfo.getTotalCount());
		
		return helper; 
	}
	
}
