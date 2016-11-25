package com.sales.service.business.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import com.sales.dao.business.OaSheetWkfDataDetailMapper;
import com.sales.model.business.OaSheetWkfDataDetail;
import com.sales.service.business.OaSheetWkfDataDetailService;
import com.sales.util.pager.helper.PageInfo;
import com.sales.util.pager.helper.PaginatedListHelper;

@Service("oaSheetWkfDataDetailService")
public class OaSheetWkfDataDetailServiceImpl implements OaSheetWkfDataDetailService {
	
	@Resource
	private OaSheetWkfDataDetailMapper oaSheetWkfDataDetailMapper;
	
	@Override
	public int deleteByPrimaryKey(Long id) {
		return oaSheetWkfDataDetailMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(OaSheetWkfDataDetail record) {
		return oaSheetWkfDataDetailMapper.insert(record);
	}

	@Override
	public int insertSelective(OaSheetWkfDataDetail record) {
		return oaSheetWkfDataDetailMapper.insertSelective(record);
	}

	@Override
	public OaSheetWkfDataDetail selectByPrimaryKey(Long id) {
		return oaSheetWkfDataDetailMapper.selectByPrimaryKey(id);
	}
	
	@Override
	public OaSheetWkfDataDetail selectBySelective(OaSheetWkfDataDetail record) {
		List<OaSheetWkfDataDetail> selectList = this.selectList(record);
		if(selectList!=null && !(selectList.isEmpty())){
			return selectList.get(0);
		}else{
			return null;
		}
	}

	@Override
	public int updateByPrimaryKeySelective(OaSheetWkfDataDetail record) {
		return oaSheetWkfDataDetailMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(OaSheetWkfDataDetail record) {
		return oaSheetWkfDataDetailMapper.updateByPrimaryKey(record);
	}
	 
	@Override
	public List<OaSheetWkfDataDetail> selectList(
			OaSheetWkfDataDetail record) {
		PageInfo pageInfo = new PageInfo();
		pageInfo.setPageNumber(1);
		pageInfo.setPageSize(Integer.MAX_VALUE);
		return this.selectList(record, pageInfo).getList(); 
	}
	
	@Override
	public PaginatedListHelper selectList(
			OaSheetWkfDataDetail record,PageInfo pageInfo) {
		if(record==null){
			record = new OaSheetWkfDataDetail();
		}
		List<OaSheetWkfDataDetail> list = oaSheetWkfDataDetailMapper.selectList(record,pageInfo); 
		PaginatedListHelper helper = new PaginatedListHelper();		
//		helper.setPageNumber(pageInfo.getPageNumber());
//		helper.setPageSize(pageInfo.getPageSize());		
		helper.setList(list);
		helper.setFullListSize(pageInfo.getTotalCount());
		
		return helper; 
	}
	
}
