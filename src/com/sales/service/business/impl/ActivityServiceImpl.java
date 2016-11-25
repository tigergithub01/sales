package com.sales.service.business.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import com.sales.dao.business.ActivityMapper;
import com.sales.model.business.Activity;
import com.sales.service.business.ActivityService;
import com.sales.util.pager.helper.PageInfo;
import com.sales.util.pager.helper.PaginatedListHelper;

@Service("activityService")
public class ActivityServiceImpl implements ActivityService {
	
	@Resource
	private ActivityMapper activityMapper;
	
	@Override
	public int deleteByPrimaryKey(Long id) {
		return activityMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(Activity record) {
		return activityMapper.insert(record);
	}

	@Override
	public int insertSelective(Activity record) {
		return activityMapper.insertSelective(record);
	}

	@Override
	public Activity selectByPrimaryKey(Long id) {
		return activityMapper.selectByPrimaryKey(id);
	}
	
	@Override
	public Activity selectBySelective(Activity record) {
		List<Activity> selectList = this.selectList(record);
		if(selectList!=null && !(selectList.isEmpty())){
			return selectList.get(0);
		}else{
			return null;
		}
	}

	@Override
	public int updateByPrimaryKeySelective(Activity record) {
		return activityMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(Activity record) {
		return activityMapper.updateByPrimaryKey(record);
	}
	 
	@Override
	public List<Activity> selectList(
			Activity record) {
		PageInfo pageInfo = new PageInfo();
		pageInfo.setPageNumber(1);
		pageInfo.setPageSize(Integer.MAX_VALUE);
		return this.selectList(record, pageInfo).getList(); 
	}
	
	@Override
	public PaginatedListHelper selectList(
			Activity record,PageInfo pageInfo) {
		if(record==null){
			record = new Activity();
		}
		List<Activity> list = activityMapper.selectList(record,pageInfo); 
		PaginatedListHelper helper = new PaginatedListHelper();		
//		helper.setPageNumber(pageInfo.getPageNumber());
//		helper.setPageSize(pageInfo.getPageSize());		
		helper.setList(list);
		helper.setFullListSize(pageInfo.getTotalCount());
		
		return helper; 
	}
	
}
