package com.sales.service.business.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import com.sales.dao.business.DrpSheetDetailMapper;
import com.sales.model.business.DrpSheetDetail;
import com.sales.service.business.DrpSheetDetailService;
import com.sales.util.pager.helper.PageInfo;
import com.sales.util.pager.helper.PaginatedListHelper;

@Service("drpSheetDetailService")
public class DrpSheetDetailServiceImpl implements DrpSheetDetailService {
	
	@Resource
	private DrpSheetDetailMapper drpSheetDetailMapper;
	
	@Override
	public int deleteByPrimaryKey(Long id) {
		return drpSheetDetailMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(DrpSheetDetail record) {
		return drpSheetDetailMapper.insert(record);
	}

	@Override
	public int insertSelective(DrpSheetDetail record) {
		return drpSheetDetailMapper.insertSelective(record);
	}

	@Override
	public DrpSheetDetail selectByPrimaryKey(Long id) {
		return drpSheetDetailMapper.selectByPrimaryKey(id);
	}
	
	@Override
	public DrpSheetDetail selectBySelective(DrpSheetDetail record) {
		List<DrpSheetDetail> selectList = this.selectList(record);
		if(selectList!=null && !(selectList.isEmpty())){
			return selectList.get(0);
		}else{
			return null;
		}
	}

	@Override
	public int updateByPrimaryKeySelective(DrpSheetDetail record) {
		return drpSheetDetailMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(DrpSheetDetail record) {
		return drpSheetDetailMapper.updateByPrimaryKey(record);
	}
	 
	@Override
	public List<DrpSheetDetail> selectList(
			DrpSheetDetail record) {
		PageInfo pageInfo = new PageInfo();
		pageInfo.setPageNumber(1);
		pageInfo.setPageSize(Integer.MAX_VALUE);
		return this.selectList(record, pageInfo).getList(); 
	}
	
	@Override
	public PaginatedListHelper selectList(
			DrpSheetDetail record,PageInfo pageInfo) {
		if(record==null){
			record = new DrpSheetDetail();
		}
		List<DrpSheetDetail> list = drpSheetDetailMapper.selectList(record,pageInfo); 
		PaginatedListHelper helper = new PaginatedListHelper();		
//		helper.setPageNumber(pageInfo.getPageNumber());
//		helper.setPageSize(pageInfo.getPageSize());		
		helper.setList(list);
		helper.setFullListSize(pageInfo.getTotalCount());
		
		return helper; 
	}
	
}
