package com.sales.service.business.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import com.sales.dao.business.VipDepositLogMapper;
import com.sales.model.business.VipDepositLog;
import com.sales.service.business.VipDepositLogService;
import com.sales.util.pager.helper.PageInfo;
import com.sales.util.pager.helper.PaginatedListHelper;

@Service("vipDepositLogService")
public class VipDepositLogServiceImpl implements VipDepositLogService {
	
	@Resource
	private VipDepositLogMapper vipDepositLogMapper;
	
	@Override
	public int deleteByPrimaryKey(Long id) {
		return vipDepositLogMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(VipDepositLog record) {
		return vipDepositLogMapper.insert(record);
	}

	@Override
	public int insertSelective(VipDepositLog record) {
		return vipDepositLogMapper.insertSelective(record);
	}

	@Override
	public VipDepositLog selectByPrimaryKey(Long id) {
		return vipDepositLogMapper.selectByPrimaryKey(id);
	}
	
	@Override
	public VipDepositLog selectBySelective(VipDepositLog record) {
		List<VipDepositLog> selectList = this.selectList(record);
		if(selectList!=null && !(selectList.isEmpty())){
			return selectList.get(0);
		}else{
			return null;
		}
	}

	@Override
	public int updateByPrimaryKeySelective(VipDepositLog record) {
		return vipDepositLogMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(VipDepositLog record) {
		return vipDepositLogMapper.updateByPrimaryKey(record);
	}
	 
	@Override
	public List<VipDepositLog> selectList(
			VipDepositLog record) {
		PageInfo pageInfo = new PageInfo();
		pageInfo.setPageNumber(1);
		pageInfo.setPageSize(Integer.MAX_VALUE);
		return this.selectList(record, pageInfo).getList(); 
	}
	
	@Override
	public PaginatedListHelper selectList(
			VipDepositLog record,PageInfo pageInfo) {
		if(record==null){
			record = new VipDepositLog();
		}
		List<VipDepositLog> list = vipDepositLogMapper.selectList(record,pageInfo); 
		PaginatedListHelper helper = new PaginatedListHelper();		
//		helper.setPageNumber(pageInfo.getPageNumber());
//		helper.setPageSize(pageInfo.getPageSize());		
		helper.setList(list);
		helper.setFullListSize(pageInfo.getTotalCount());
		
		return helper; 
	}
	
}
