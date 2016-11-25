package com.sales.service.business.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import com.sales.dao.business.VipGiftLogMapper;
import com.sales.model.business.VipGiftLog;
import com.sales.service.business.VipGiftLogService;
import com.sales.util.pager.helper.PageInfo;
import com.sales.util.pager.helper.PaginatedListHelper;

@Service("vipGiftLogService")
public class VipGiftLogServiceImpl implements VipGiftLogService {
	
	@Resource
	private VipGiftLogMapper vipGiftLogMapper;
	
	@Override
	public int deleteByPrimaryKey(Long id) {
		return vipGiftLogMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(VipGiftLog record) {
		return vipGiftLogMapper.insert(record);
	}

	@Override
	public int insertSelective(VipGiftLog record) {
		return vipGiftLogMapper.insertSelective(record);
	}

	@Override
	public VipGiftLog selectByPrimaryKey(Long id) {
		return vipGiftLogMapper.selectByPrimaryKey(id);
	}
	
	@Override
	public VipGiftLog selectBySelective(VipGiftLog record) {
		List<VipGiftLog> selectList = this.selectList(record);
		if(selectList!=null && !(selectList.isEmpty())){
			return selectList.get(0);
		}else{
			return null;
		}
	}

	@Override
	public int updateByPrimaryKeySelective(VipGiftLog record) {
		return vipGiftLogMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(VipGiftLog record) {
		return vipGiftLogMapper.updateByPrimaryKey(record);
	}
	 
	@Override
	public List<VipGiftLog> selectList(
			VipGiftLog record) {
		PageInfo pageInfo = new PageInfo();
		pageInfo.setPageNumber(1);
		pageInfo.setPageSize(Integer.MAX_VALUE);
		return this.selectList(record, pageInfo).getList(); 
	}
	
	@Override
	public PaginatedListHelper selectList(
			VipGiftLog record,PageInfo pageInfo) {
		if(record==null){
			record = new VipGiftLog();
		}
		List<VipGiftLog> list = vipGiftLogMapper.selectList(record,pageInfo); 
		PaginatedListHelper helper = new PaginatedListHelper();		
//		helper.setPageNumber(pageInfo.getPageNumber());
//		helper.setPageSize(pageInfo.getPageSize());		
		helper.setList(list);
		helper.setFullListSize(pageInfo.getTotalCount());
		
		return helper; 
	}
	
}
