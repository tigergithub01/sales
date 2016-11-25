package com.sales.service.business.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import com.sales.dao.business.DrpPosTransSaleFlowMapper;
import com.sales.model.business.DrpPosTransSaleFlow;
import com.sales.service.business.DrpPosTransSaleFlowService;
import com.sales.util.pager.helper.PageInfo;
import com.sales.util.pager.helper.PaginatedListHelper;

@Service("drpPosTransSaleFlowService")
public class DrpPosTransSaleFlowServiceImpl implements DrpPosTransSaleFlowService {
	
	@Resource
	private DrpPosTransSaleFlowMapper drpPosTransSaleFlowMapper;
	
	@Override
	public int deleteByPrimaryKey(Long id) {
		return drpPosTransSaleFlowMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(DrpPosTransSaleFlow record) {
		return drpPosTransSaleFlowMapper.insert(record);
	}

	@Override
	public int insertSelective(DrpPosTransSaleFlow record) {
		return drpPosTransSaleFlowMapper.insertSelective(record);
	}

	@Override
	public DrpPosTransSaleFlow selectByPrimaryKey(Long id) {
		return drpPosTransSaleFlowMapper.selectByPrimaryKey(id);
	}
	
	@Override
	public DrpPosTransSaleFlow selectBySelective(DrpPosTransSaleFlow record) {
		List<DrpPosTransSaleFlow> selectList = this.selectList(record);
		if(selectList!=null && !(selectList.isEmpty())){
			return selectList.get(0);
		}else{
			return null;
		}
	}

	@Override
	public int updateByPrimaryKeySelective(DrpPosTransSaleFlow record) {
		return drpPosTransSaleFlowMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(DrpPosTransSaleFlow record) {
		return drpPosTransSaleFlowMapper.updateByPrimaryKey(record);
	}
	 
	@Override
	public List<DrpPosTransSaleFlow> selectList(
			DrpPosTransSaleFlow record) {
		PageInfo pageInfo = new PageInfo();
		pageInfo.setPageNumber(1);
		pageInfo.setPageSize(Integer.MAX_VALUE);
		return this.selectList(record, pageInfo).getList(); 
	}
	
	@Override
	public PaginatedListHelper selectList(
			DrpPosTransSaleFlow record,PageInfo pageInfo) {
		if(record==null){
			record = new DrpPosTransSaleFlow();
		}
		List<DrpPosTransSaleFlow> list = drpPosTransSaleFlowMapper.selectList(record,pageInfo); 
		PaginatedListHelper helper = new PaginatedListHelper();		
//		helper.setPageNumber(pageInfo.getPageNumber());
//		helper.setPageSize(pageInfo.getPageSize());		
		helper.setList(list);
		helper.setFullListSize(pageInfo.getTotalCount());
		
		return helper; 
	}
	
}
