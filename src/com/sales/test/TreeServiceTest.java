package com.sales.test;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sales.model.business.SysModule;
import com.sales.service.util.TreeService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"classpath:com/sales/config/spring-mybatis.xml" })
public class TreeServiceTest {
	@Resource
	private TreeService treeService;
	

	@Test
	public void test() {  
		SysModule param = new SysModule();
		param.setStatus(1L); 
		
		List<SysModule> list= treeService.getSubSysModuleTreeList(8L,param);
		System.out.println(list);
		for (SysModule sysModule : list) {
			System.out.println(sysModule.getName());
			System.out.println(sysModule.getChildren());
		}
		
		
	}
}
