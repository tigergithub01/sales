package com.sales.service.business.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import com.sales.dao.business.DrpPosTransInfoMapper;
import com.sales.model.business.DrpPosTransInfo;
import com.sales.service.business.DrpPosTransInfoService;
import com.sales.util.pager.helper.PageInfo;
import com.sales.util.pager.helper.PaginatedListHelper;

@Service("drpPosTransInfoService")
public class DrpPosTransInfoServiceImpl implements DrpPosTransInfoService {
	
	@Resource
	private DrpPosTransInfoMapper drpPosTransInfoMapper;
	
	@Override
	public int deleteByPrimaryKey(Long id) {
		return drpPosTransInfoMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(DrpPosTransInfo record) {
		return drpPosTransInfoMapper.insert(record);
	}

	@Override
	public int insertSelective(DrpPosTransInfo record) {
		return drpPosTransInfoMapper.insertSelective(record);
	}

	@Override
	public DrpPosTransInfo selectByPrimaryKey(Long id) {
		return drpPosTransInfoMapper.selectByPrimaryKey(id);
	}
	
	@Override
	public DrpPosTransInfo selectBySelective(DrpPosTransInfo record) {
		List<DrpPosTransInfo> selectList = this.selectList(record);
		if(selectList!=null && !(selectList.isEmpty())){
			return selectList.get(0);
		}else{
			return null;
		}
	}

	@Override
	public int updateByPrimaryKeySelective(DrpPosTransInfo record) {
		return drpPosTransInfoMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(DrpPosTransInfo record) {
		return drpPosTransInfoMapper.updateByPrimaryKey(record);
	}
	 
	@Override
	public List<DrpPosTransInfo> selectList(
			DrpPosTransInfo record) {
		PageInfo pageInfo = new PageInfo();
		pageInfo.setPageNumber(1);
		pageInfo.setPageSize(Integer.MAX_VALUE);
		return this.selectList(record, pageInfo).getList(); 
	}
	
	@Override
	public PaginatedListHelper selectList(
			DrpPosTransInfo record,PageInfo pageInfo) {
		if(record==null){
			record = new DrpPosTransInfo();
		}
		List<DrpPosTransInfo> list = drpPosTransInfoMapper.selectList(record,pageInfo); 
		PaginatedListHelper helper = new PaginatedListHelper();		
//		helper.setPageNumber(pageInfo.getPageNumber());
//		helper.setPageSize(pageInfo.getPageSize());		
		helper.setList(list);
		helper.setFullListSize(pageInfo.getTotalCount());
		
		return helper; 
	}
	
}
