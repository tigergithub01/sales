package com.sales.service.business.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import com.sales.dao.business.SysPayTypeMapper;
import com.sales.model.business.SysPayType;
import com.sales.service.business.SysPayTypeService;
import com.sales.util.pager.helper.PageInfo;
import com.sales.util.pager.helper.PaginatedListHelper;

@Service("sysPayTypeService")
public class SysPayTypeServiceImpl implements SysPayTypeService {
	
	@Resource
	private SysPayTypeMapper sysPayTypeMapper;
	
	@Override
	public int deleteByPrimaryKey(Long id) {
		return sysPayTypeMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(SysPayType record) {
		return sysPayTypeMapper.insert(record);
	}

	@Override
	public int insertSelective(SysPayType record) {
		return sysPayTypeMapper.insertSelective(record);
	}

	@Override
	public SysPayType selectByPrimaryKey(Long id) {
		return sysPayTypeMapper.selectByPrimaryKey(id);
	}
	
	@Override
	public SysPayType selectBySelective(SysPayType record) {
		List<SysPayType> selectList = this.selectList(record);
		if(selectList!=null && !(selectList.isEmpty())){
			return selectList.get(0);
		}else{
			return null;
		}
	}

	@Override
	public int updateByPrimaryKeySelective(SysPayType record) {
		return sysPayTypeMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(SysPayType record) {
		return sysPayTypeMapper.updateByPrimaryKey(record);
	}
	 
	@Override
	public List<SysPayType> selectList(
			SysPayType record) {
		PageInfo pageInfo = new PageInfo();
		pageInfo.setPageNumber(1);
		pageInfo.setPageSize(Integer.MAX_VALUE);
		return this.selectList(record, pageInfo).getList(); 
	}
	
	@Override
	public PaginatedListHelper selectList(
			SysPayType record,PageInfo pageInfo) {
		if(record==null){
			record = new SysPayType();
		}
		List<SysPayType> list = sysPayTypeMapper.selectList(record,pageInfo); 
		PaginatedListHelper helper = new PaginatedListHelper();		
//		helper.setPageNumber(pageInfo.getPageNumber());
//		helper.setPageSize(pageInfo.getPageSize());		
		helper.setList(list);
		helper.setFullListSize(pageInfo.getTotalCount());
		
		return helper; 
	}
	
}
