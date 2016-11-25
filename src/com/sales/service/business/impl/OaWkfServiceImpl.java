package com.sales.service.business.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import com.sales.dao.business.OaWkfMapper;
import com.sales.model.business.OaWkf;
import com.sales.service.business.OaWkfService;
import com.sales.util.pager.helper.PageInfo;
import com.sales.util.pager.helper.PaginatedListHelper;

@Service("oaWkfService")
public class OaWkfServiceImpl implements OaWkfService {
	
	@Resource
	private OaWkfMapper oaWkfMapper;
	
	@Override
	public int deleteByPrimaryKey(Long id) {
		return oaWkfMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(OaWkf record) {
		return oaWkfMapper.insert(record);
	}

	@Override
	public int insertSelective(OaWkf record) {
		return oaWkfMapper.insertSelective(record);
	}

	@Override
	public OaWkf selectByPrimaryKey(Long id) {
		return oaWkfMapper.selectByPrimaryKey(id);
	}
	
	@Override
	public OaWkf selectBySelective(OaWkf record) {
		List<OaWkf> selectList = this.selectList(record);
		if(selectList!=null && !(selectList.isEmpty())){
			return selectList.get(0);
		}else{
			return null;
		}
	}

	@Override
	public int updateByPrimaryKeySelective(OaWkf record) {
		return oaWkfMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(OaWkf record) {
		return oaWkfMapper.updateByPrimaryKey(record);
	}
	 
	@Override
	public List<OaWkf> selectList(
			OaWkf record) {
		PageInfo pageInfo = new PageInfo();
		pageInfo.setPageNumber(1);
		pageInfo.setPageSize(Integer.MAX_VALUE);
		return this.selectList(record, pageInfo).getList(); 
	}
	
	@Override
	public PaginatedListHelper selectList(
			OaWkf record,PageInfo pageInfo) {
		if(record==null){
			record = new OaWkf();
		}
		List<OaWkf> list = oaWkfMapper.selectList(record,pageInfo); 
		PaginatedListHelper helper = new PaginatedListHelper();		
//		helper.setPageNumber(pageInfo.getPageNumber());
//		helper.setPageSize(pageInfo.getPageSize());		
		helper.setList(list);
		helper.setFullListSize(pageInfo.getTotalCount());
		
		return helper; 
	}
	
}
