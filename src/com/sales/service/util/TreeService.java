package com.sales.service.util;

import java.util.List;

import com.sales.model.business.SysModule;

public interface TreeService {
	
	public List<SysModule> getSubSysModuleTreeList(Long moduleId,SysModule param);
	
	public List<SysModule> getRootModuleList(SysModule param);
}
