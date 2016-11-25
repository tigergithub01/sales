package com.sales.test;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sales.model.business.SysUser;
import com.sales.service.business.SysParameterService;
import com.sales.service.business.SysUserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"classpath:com/sales/config/spring-mybatis.xml" })
public class SysUserServiceTest {

	@Resource
	private SysUserService sysUserService;
	
	@Resource
	private SysParameterService sysParameterService;

	@Test
	public void test() {
		SysUser record = new SysUser();
		record.setId(1L);
		record.setUserName("5");
		List<SysUser> list = sysUserService.selectList(null);
		System.out.println(list);
	}
	
	

}
