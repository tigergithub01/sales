package com.sales.service.business.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import com.sales.dao.business.DrpPosTransPayFlowMapper;
import com.sales.model.business.DrpPosTransPayFlow;
import com.sales.service.business.DrpPosTransPayFlowService;
import com.sales.util.pager.helper.PageInfo;
import com.sales.util.pager.helper.PaginatedListHelper;

@Service("drpPosTransPayFlowService")
public class DrpPosTransPayFlowServiceImpl implements DrpPosTransPayFlowService {
	
	@Resource
	private DrpPosTransPayFlowMapper drpPosTransPayFlowMapper;
	
	@Override
	public int deleteByPrimaryKey(Long id) {
		return drpPosTransPayFlowMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(DrpPosTransPayFlow record) {
		return drpPosTransPayFlowMapper.insert(record);
	}

	@Override
	public int insertSelective(DrpPosTransPayFlow record) {
		return drpPosTransPayFlowMapper.insertSelective(record);
	}

	@Override
	public DrpPosTransPayFlow selectByPrimaryKey(Long id) {
		return drpPosTransPayFlowMapper.selectByPrimaryKey(id);
	}
	
	@Override
	public DrpPosTransPayFlow selectBySelective(DrpPosTransPayFlow record) {
		List<DrpPosTransPayFlow> selectList = this.selectList(record);
		if(selectList!=null && !(selectList.isEmpty())){
			return selectList.get(0);
		}else{
			return null;
		}
	}

	@Override
	public int updateByPrimaryKeySelective(DrpPosTransPayFlow record) {
		return drpPosTransPayFlowMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(DrpPosTransPayFlow record) {
		return drpPosTransPayFlowMapper.updateByPrimaryKey(record);
	}
	 
	@Override
	public List<DrpPosTransPayFlow> selectList(
			DrpPosTransPayFlow record) {
		PageInfo pageInfo = new PageInfo();
		pageInfo.setPageNumber(1);
		pageInfo.setPageSize(Integer.MAX_VALUE);
		return this.selectList(record, pageInfo).getList(); 
	}
	
	@Override
	public PaginatedListHelper selectList(
			DrpPosTransPayFlow record,PageInfo pageInfo) {
		if(record==null){
			record = new DrpPosTransPayFlow();
		}
		List<DrpPosTransPayFlow> list = drpPosTransPayFlowMapper.selectList(record,pageInfo); 
		PaginatedListHelper helper = new PaginatedListHelper();		
//		helper.setPageNumber(pageInfo.getPageNumber());
//		helper.setPageSize(pageInfo.getPageSize());		
		helper.setList(list);
		helper.setFullListSize(pageInfo.getTotalCount());
		
		return helper; 
	}
	
}
