package com.sales.service.business.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import com.sales.dao.business.VipDepositMapper;
import com.sales.model.business.VipDeposit;
import com.sales.service.business.VipDepositService;
import com.sales.util.pager.helper.PageInfo;
import com.sales.util.pager.helper.PaginatedListHelper;

@Service("vipDepositService")
public class VipDepositServiceImpl implements VipDepositService {
	
	@Resource
	private VipDepositMapper vipDepositMapper;
	
	@Override
	public int deleteByPrimaryKey(Long id) {
		return vipDepositMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(VipDeposit record) {
		return vipDepositMapper.insert(record);
	}

	@Override
	public int insertSelective(VipDeposit record) {
		return vipDepositMapper.insertSelective(record);
	}

	@Override
	public VipDeposit selectByPrimaryKey(Long id) {
		return vipDepositMapper.selectByPrimaryKey(id);
	}
	
	@Override
	public VipDeposit selectBySelective(VipDeposit record) {
		List<VipDeposit> selectList = this.selectList(record);
		if(selectList!=null && !(selectList.isEmpty())){
			return selectList.get(0);
		}else{
			return null;
		}
	}

	@Override
	public int updateByPrimaryKeySelective(VipDeposit record) {
		return vipDepositMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(VipDeposit record) {
		return vipDepositMapper.updateByPrimaryKey(record);
	}
	 
	@Override
	public List<VipDeposit> selectList(
			VipDeposit record) {
		PageInfo pageInfo = new PageInfo();
		pageInfo.setPageNumber(1);
		pageInfo.setPageSize(Integer.MAX_VALUE);
		return this.selectList(record, pageInfo).getList(); 
	}
	
	@Override
	public PaginatedListHelper selectList(
			VipDeposit record,PageInfo pageInfo) {
		if(record==null){
			record = new VipDeposit();
		}
		List<VipDeposit> list = vipDepositMapper.selectList(record,pageInfo); 
		PaginatedListHelper helper = new PaginatedListHelper();		
//		helper.setPageNumber(pageInfo.getPageNumber());
//		helper.setPageSize(pageInfo.getPageSize());		
		helper.setList(list);
		helper.setFullListSize(pageInfo.getTotalCount());
		
		return helper; 
	}
	
}
