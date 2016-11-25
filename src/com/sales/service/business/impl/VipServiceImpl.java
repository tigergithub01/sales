package com.sales.service.business.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import com.sales.dao.business.VipMapper;
import com.sales.model.business.Vip;
import com.sales.service.business.VipService;
import com.sales.util.pager.helper.PageInfo;
import com.sales.util.pager.helper.PaginatedListHelper;

@Service("vipService")
public class VipServiceImpl implements VipService {
	
	@Resource
	private VipMapper vipMapper;
	
	@Override
	public int deleteByPrimaryKey(Long id) {
		return vipMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(Vip record) {
		return vipMapper.insert(record);
	}

	@Override
	public int insertSelective(Vip record) {
		return vipMapper.insertSelective(record);
	}

	@Override
	public Vip selectByPrimaryKey(Long id) {
		return vipMapper.selectByPrimaryKey(id);
	}
	
	@Override
	public Vip selectBySelective(Vip record) {
		List<Vip> selectList = this.selectList(record);
		if(selectList!=null && !(selectList.isEmpty())){
			return selectList.get(0);
		}else{
			return null;
		}
	}

	@Override
	public int updateByPrimaryKeySelective(Vip record) {
		return vipMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(Vip record) {
		return vipMapper.updateByPrimaryKey(record);
	}
	 
	@Override
	public List<Vip> selectList(
			Vip record) {
		PageInfo pageInfo = new PageInfo();
		pageInfo.setPageNumber(1);
		pageInfo.setPageSize(Integer.MAX_VALUE);
		return this.selectList(record, pageInfo).getList(); 
	}
	
	@Override
	public PaginatedListHelper selectList(
			Vip record,PageInfo pageInfo) {
		if(record==null){
			record = new Vip();
		}
		List<Vip> list = vipMapper.selectList(record,pageInfo); 
		PaginatedListHelper helper = new PaginatedListHelper();		
//		helper.setPageNumber(pageInfo.getPageNumber());
//		helper.setPageSize(pageInfo.getPageSize());		
		helper.setList(list);
		helper.setFullListSize(pageInfo.getTotalCount());
		
		return helper; 
	}
	
}
