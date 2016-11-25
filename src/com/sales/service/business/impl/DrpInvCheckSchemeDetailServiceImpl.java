package com.sales.service.business.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import com.sales.dao.business.DrpInvCheckSchemeDetailMapper;
import com.sales.model.business.DrpInvCheckSchemeDetail;
import com.sales.service.business.DrpInvCheckSchemeDetailService;
import com.sales.util.pager.helper.PageInfo;
import com.sales.util.pager.helper.PaginatedListHelper;

@Service("drpInvCheckSchemeDetailService")
public class DrpInvCheckSchemeDetailServiceImpl implements DrpInvCheckSchemeDetailService {
	
	@Resource
	private DrpInvCheckSchemeDetailMapper drpInvCheckSchemeDetailMapper;
	
	@Override
	public int deleteByPrimaryKey(Long id) {
		return drpInvCheckSchemeDetailMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(DrpInvCheckSchemeDetail record) {
		return drpInvCheckSchemeDetailMapper.insert(record);
	}

	@Override
	public int insertSelective(DrpInvCheckSchemeDetail record) {
		return drpInvCheckSchemeDetailMapper.insertSelective(record);
	}

	@Override
	public DrpInvCheckSchemeDetail selectByPrimaryKey(Long id) {
		return drpInvCheckSchemeDetailMapper.selectByPrimaryKey(id);
	}
	
	@Override
	public DrpInvCheckSchemeDetail selectBySelective(DrpInvCheckSchemeDetail record) {
		List<DrpInvCheckSchemeDetail> selectList = this.selectList(record);
		if(selectList!=null && !(selectList.isEmpty())){
			return selectList.get(0);
		}else{
			return null;
		}
	}

	@Override
	public int updateByPrimaryKeySelective(DrpInvCheckSchemeDetail record) {
		return drpInvCheckSchemeDetailMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(DrpInvCheckSchemeDetail record) {
		return drpInvCheckSchemeDetailMapper.updateByPrimaryKey(record);
	}
	 
	@Override
	public List<DrpInvCheckSchemeDetail> selectList(
			DrpInvCheckSchemeDetail record) {
		PageInfo pageInfo = new PageInfo();
		pageInfo.setPageNumber(1);
		pageInfo.setPageSize(Integer.MAX_VALUE);
		return this.selectList(record, pageInfo).getList(); 
	}
	
	@Override
	public PaginatedListHelper selectList(
			DrpInvCheckSchemeDetail record,PageInfo pageInfo) {
		if(record==null){
			record = new DrpInvCheckSchemeDetail();
		}
		List<DrpInvCheckSchemeDetail> list = drpInvCheckSchemeDetailMapper.selectList(record,pageInfo); 
		PaginatedListHelper helper = new PaginatedListHelper();		
//		helper.setPageNumber(pageInfo.getPageNumber());
//		helper.setPageSize(pageInfo.getPageSize());		
		helper.setList(list);
		helper.setFullListSize(pageInfo.getTotalCount());
		
		return helper; 
	}
	
}
