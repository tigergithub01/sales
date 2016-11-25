package com.sales.service.business.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import com.sales.dao.business.SysParameterMapper;
import com.sales.model.business.SysParameter;
import com.sales.service.business.SysParameterService;
import com.sales.util.pager.helper.PageInfo;
import com.sales.util.pager.helper.PaginatedListHelper;

@Service("sysParameterService")
public class SysParameterServiceImpl implements SysParameterService {
	
	@Resource
	private SysParameterMapper sysParameterMapper;
	
	@Override
	public int deleteByPrimaryKey(Long id) {
		return sysParameterMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(SysParameter record) {
		return sysParameterMapper.insert(record);
	}

	@Override
	public int insertSelective(SysParameter record) {
		return sysParameterMapper.insertSelective(record);
	}

	@Override
	public SysParameter selectByPrimaryKey(Long id) {
		return sysParameterMapper.selectByPrimaryKey(id);
	}
	
	@Override
	public SysParameter selectBySelective(SysParameter record) {
		List<SysParameter> selectList = this.selectList(record);
		if(selectList!=null && !(selectList.isEmpty())){
			return selectList.get(0);
		}else{
			return null;
		}
	}

	@Override
	public int updateByPrimaryKeySelective(SysParameter record) {
		return sysParameterMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(SysParameter record) {
		return sysParameterMapper.updateByPrimaryKey(record);
	}
	 
	@Override
	public List<SysParameter> selectList(
			SysParameter record) {
		PageInfo pageInfo = new PageInfo();
		pageInfo.setPageNumber(1);
		pageInfo.setPageSize(Integer.MAX_VALUE);
		return this.selectList(record, pageInfo).getList(); 
	}
	
	@Override
	public PaginatedListHelper selectList(
			SysParameter record,PageInfo pageInfo) {
		if(record==null){
			record = new SysParameter();
		}
		List<SysParameter> list = sysParameterMapper.selectList(record,pageInfo); 
		PaginatedListHelper helper = new PaginatedListHelper();		
//		helper.setPageNumber(pageInfo.getPageNumber());
//		helper.setPageSize(pageInfo.getPageSize());		
		helper.setList(list);
		helper.setFullListSize(pageInfo.getTotalCount());
		
		return helper; 
	}
	
}
