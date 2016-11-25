package com.sales.service.business.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import com.sales.dao.business.OrgActAuthDetailMapper;
import com.sales.model.business.OrgActAuthDetail;
import com.sales.service.business.OrgActAuthDetailService;
import com.sales.util.pager.helper.PageInfo;
import com.sales.util.pager.helper.PaginatedListHelper;

@Service("orgActAuthDetailService")
public class OrgActAuthDetailServiceImpl implements OrgActAuthDetailService {
	
	@Resource
	private OrgActAuthDetailMapper orgActAuthDetailMapper;
	
	@Override
	public int deleteByPrimaryKey(Long id) {
		return orgActAuthDetailMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(OrgActAuthDetail record) {
		return orgActAuthDetailMapper.insert(record);
	}

	@Override
	public int insertSelective(OrgActAuthDetail record) {
		return orgActAuthDetailMapper.insertSelective(record);
	}

	@Override
	public OrgActAuthDetail selectByPrimaryKey(Long id) {
		return orgActAuthDetailMapper.selectByPrimaryKey(id);
	}
	
	@Override
	public OrgActAuthDetail selectBySelective(OrgActAuthDetail record) {
		List<OrgActAuthDetail> selectList = this.selectList(record);
		if(selectList!=null && !(selectList.isEmpty())){
			return selectList.get(0);
		}else{
			return null;
		}
	}

	@Override
	public int updateByPrimaryKeySelective(OrgActAuthDetail record) {
		return orgActAuthDetailMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(OrgActAuthDetail record) {
		return orgActAuthDetailMapper.updateByPrimaryKey(record);
	}
	 
	@Override
	public List<OrgActAuthDetail> selectList(
			OrgActAuthDetail record) {
		PageInfo pageInfo = new PageInfo();
		pageInfo.setPageNumber(1);
		pageInfo.setPageSize(Integer.MAX_VALUE);
		return this.selectList(record, pageInfo).getList(); 
	}
	
	@Override
	public PaginatedListHelper selectList(
			OrgActAuthDetail record,PageInfo pageInfo) {
		if(record==null){
			record = new OrgActAuthDetail();
		}
		List<OrgActAuthDetail> list = orgActAuthDetailMapper.selectList(record,pageInfo); 
		PaginatedListHelper helper = new PaginatedListHelper();		
//		helper.setPageNumber(pageInfo.getPageNumber());
//		helper.setPageSize(pageInfo.getPageSize());		
		helper.setList(list);
		helper.setFullListSize(pageInfo.getTotalCount());
		
		return helper; 
	}
	
}
