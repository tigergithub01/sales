package com.sales.service.business.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import com.sales.dao.business.SysParameterTypeMapper;
import com.sales.model.business.SysParameterType;
import com.sales.service.business.SysParameterTypeService;
import com.sales.util.pager.helper.PageInfo;
import com.sales.util.pager.helper.PaginatedListHelper;

@Service("sysParameterTypeService")
public class SysParameterTypeServiceImpl implements SysParameterTypeService {
	
	@Resource
	private SysParameterTypeMapper sysParameterTypeMapper;
	
	@Override
	public int deleteByPrimaryKey(Long id) {
		return sysParameterTypeMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(SysParameterType record) {
		return sysParameterTypeMapper.insert(record);
	}

	@Override
	public int insertSelective(SysParameterType record) {
		return sysParameterTypeMapper.insertSelective(record);
	}

	@Override
	public SysParameterType selectByPrimaryKey(Long id) {
		return sysParameterTypeMapper.selectByPrimaryKey(id);
	}
	
	@Override
	public SysParameterType selectBySelective(SysParameterType record) {
		List<SysParameterType> selectList = this.selectList(record);
		if(selectList!=null && !(selectList.isEmpty())){
			return selectList.get(0);
		}else{
			return null;
		}
	}

	@Override
	public int updateByPrimaryKeySelective(SysParameterType record) {
		return sysParameterTypeMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(SysParameterType record) {
		return sysParameterTypeMapper.updateByPrimaryKey(record);
	}
	 
	@Override
	public List<SysParameterType> selectList(
			SysParameterType record) {
		PageInfo pageInfo = new PageInfo();
		pageInfo.setPageNumber(1);
		pageInfo.setPageSize(Integer.MAX_VALUE);
		return this.selectList(record, pageInfo).getList(); 
	}
	
	@Override
	public PaginatedListHelper selectList(
			SysParameterType record,PageInfo pageInfo) {
		if(record==null){
			record = new SysParameterType();
		}
		List<SysParameterType> list = sysParameterTypeMapper.selectList(record,pageInfo); 
		PaginatedListHelper helper = new PaginatedListHelper();		
//		helper.setPageNumber(pageInfo.getPageNumber());
//		helper.setPageSize(pageInfo.getPageSize());		
		helper.setList(list);
		helper.setFullListSize(pageInfo.getTotalCount());
		
		return helper; 
	}
	
}
