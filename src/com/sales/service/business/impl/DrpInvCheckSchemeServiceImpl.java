package com.sales.service.business.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import com.sales.dao.business.DrpInvCheckSchemeMapper;
import com.sales.model.business.DrpInvCheckScheme;
import com.sales.service.business.DrpInvCheckSchemeService;
import com.sales.util.pager.helper.PageInfo;
import com.sales.util.pager.helper.PaginatedListHelper;

@Service("drpInvCheckSchemeService")
public class DrpInvCheckSchemeServiceImpl implements DrpInvCheckSchemeService {
	
	@Resource
	private DrpInvCheckSchemeMapper drpInvCheckSchemeMapper;
	
	@Override
	public int deleteByPrimaryKey(Long id) {
		return drpInvCheckSchemeMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(DrpInvCheckScheme record) {
		return drpInvCheckSchemeMapper.insert(record);
	}

	@Override
	public int insertSelective(DrpInvCheckScheme record) {
		return drpInvCheckSchemeMapper.insertSelective(record);
	}

	@Override
	public DrpInvCheckScheme selectByPrimaryKey(Long id) {
		return drpInvCheckSchemeMapper.selectByPrimaryKey(id);
	}
	
	@Override
	public DrpInvCheckScheme selectBySelective(DrpInvCheckScheme record) {
		List<DrpInvCheckScheme> selectList = this.selectList(record);
		if(selectList!=null && !(selectList.isEmpty())){
			return selectList.get(0);
		}else{
			return null;
		}
	}

	@Override
	public int updateByPrimaryKeySelective(DrpInvCheckScheme record) {
		return drpInvCheckSchemeMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(DrpInvCheckScheme record) {
		return drpInvCheckSchemeMapper.updateByPrimaryKey(record);
	}
	 
	@Override
	public List<DrpInvCheckScheme> selectList(
			DrpInvCheckScheme record) {
		PageInfo pageInfo = new PageInfo();
		pageInfo.setPageNumber(1);
		pageInfo.setPageSize(Integer.MAX_VALUE);
		return this.selectList(record, pageInfo).getList(); 
	}
	
	@Override
	public PaginatedListHelper selectList(
			DrpInvCheckScheme record,PageInfo pageInfo) {
		if(record==null){
			record = new DrpInvCheckScheme();
		}
		List<DrpInvCheckScheme> list = drpInvCheckSchemeMapper.selectList(record,pageInfo); 
		PaginatedListHelper helper = new PaginatedListHelper();		
//		helper.setPageNumber(pageInfo.getPageNumber());
//		helper.setPageSize(pageInfo.getPageSize());		
		helper.setList(list);
		helper.setFullListSize(pageInfo.getTotalCount());
		
		return helper; 
	}
	
}
