package com.sales.service.util.impl;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sales.dao.business.SysModuleMapper;
import com.sales.model.business.SysModule;
import com.sales.service.business.SysModuleService;
import com.sales.service.util.TreeService;
import com.sales.util.pager.helper.PageInfo;

@Service("treeService")
public class TreeServiceImpl implements TreeService { 
	
	@Resource
	private SysModuleMapper sysModuleMapper;
	
	@Resource
	private SysModuleService sysModuleService;
	
		
	public List<SysModule> getSubSysModuleTreeList(Long moduleId,SysModule param){
		PageInfo pageInfo = new PageInfo();
		pageInfo.setPageNumber(1);
		pageInfo.setPageSize(Integer.MAX_VALUE);
		
		SysModule root = new SysModule();
		root.setId(moduleId);
		
		List<SysModule> allList = sysModuleMapper.selectList(param, pageInfo); 
		formatTreeList(allList, root);
		return root.getChildren();
	}
	
	public List<SysModule> getRootModuleList(SysModule param){
		PageInfo pageInfo = new PageInfo();
		pageInfo.setPageNumber(1);
		pageInfo.setPageSize(Integer.MAX_VALUE);
		pageInfo.setSortColumn("sequence_id");
		param.setRoot(true);
		
		List<SysModule> list = sysModuleMapper.selectList(param, pageInfo); 
		
		return list;
	}
	
	private void formatTreeList(List<SysModule> allList,SysModule parentSysModule){		
		List<SysModule> subList = getSubSysModuleList(allList, parentSysModule.getId());
		System.out.println(subList.size());
		for (SysModule sysModule : subList) {
			List<SysModule> children =  getSubSysModuleList(allList, parentSysModule.getId());
			parentSysModule.setChildren(children);
			formatTreeList(allList, sysModule);
		}
	}
	
	private List<SysModule> getSubSysModuleList(List<SysModule> allList, Long moduleId){
		List<SysModule> subList = new ArrayList<SysModule>();
		for (SysModule sysModule : allList) {
			if(moduleId==null || sysModule.getParentId()==null){
				if(moduleId==sysModule.getParentId()){
					subList.add(sysModule);
				}
			}else{
				if(sysModule.getParentId().longValue()==moduleId.longValue()){
					subList.add(sysModule);
				}
			}
		}
		
		//sort array
		java.util.Collections.sort(subList, new Comparator<SysModule>() {
			@Override
			public int compare(SysModule o1, SysModule o2) {
				// TODO Auto-generated method stub
				Long sequenceId1 = (o1.getSequenceId()==null?Long.MAX_VALUE:o1.getSequenceId());
				Long sequenceId2 = (o2.getSequenceId()==null?Long.MAX_VALUE:o2.getSequenceId());
				return sequenceId1.compareTo(sequenceId2);  
			}
			
		});
		return subList;
	}
	
	
	
	
	
	
	
	
	
}
