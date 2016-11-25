package com.sales.service.business.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import com.sales.dao.business.DrpMatBatchMapper;
import com.sales.model.business.DrpMatBatch;
import com.sales.service.business.DrpMatBatchService;
import com.sales.util.pager.helper.PageInfo;
import com.sales.util.pager.helper.PaginatedListHelper;

@Service("drpMatBatchService")
public class DrpMatBatchServiceImpl implements DrpMatBatchService {
	
	@Resource
	private DrpMatBatchMapper drpMatBatchMapper;
	
	@Override
	public int deleteByPrimaryKey(Long id) {
		return drpMatBatchMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(DrpMatBatch record) {
		return drpMatBatchMapper.insert(record);
	}

	@Override
	public int insertSelective(DrpMatBatch record) {
		return drpMatBatchMapper.insertSelective(record);
	}

	@Override
	public DrpMatBatch selectByPrimaryKey(Long id) {
		return drpMatBatchMapper.selectByPrimaryKey(id);
	}
	
	@Override
	public DrpMatBatch selectBySelective(DrpMatBatch record) {
		List<DrpMatBatch> selectList = this.selectList(record);
		if(selectList!=null && !(selectList.isEmpty())){
			return selectList.get(0);
		}else{
			return null;
		}
	}

	@Override
	public int updateByPrimaryKeySelective(DrpMatBatch record) {
		return drpMatBatchMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(DrpMatBatch record) {
		return drpMatBatchMapper.updateByPrimaryKey(record);
	}
	 
	@Override
	public List<DrpMatBatch> selectList(
			DrpMatBatch record) {
		PageInfo pageInfo = new PageInfo();
		pageInfo.setPageNumber(1);
		pageInfo.setPageSize(Integer.MAX_VALUE);
		return this.selectList(record, pageInfo).getList(); 
	}
	
	@Override
	public PaginatedListHelper selectList(
			DrpMatBatch record,PageInfo pageInfo) {
		if(record==null){
			record = new DrpMatBatch();
		}
		List<DrpMatBatch> list = drpMatBatchMapper.selectList(record,pageInfo); 
		PaginatedListHelper helper = new PaginatedListHelper();		
//		helper.setPageNumber(pageInfo.getPageNumber());
//		helper.setPageSize(pageInfo.getPageSize());		
		helper.setList(list);
		helper.setFullListSize(pageInfo.getTotalCount());
		
		return helper; 
	}
	
}
