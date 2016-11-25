package com.sales.test.codegen;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sales.dao.util.MybatisGenMapper;
import com.sales.model.util.meta.MetaTbl;
import com.sales.service.util.CodeGenService;
import com.sales.util.common.codegen.CodeModel;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"classpath:com/sales/config/spring-mybatis.xml" })
public class CodeGenServiceTest {
	private static Logger logger = Logger.getLogger(CodeGenServiceTest.class);

	@Resource
	private CodeGenService codeGenService;
	
	@Resource
	private MybatisGenMapper mybatisGenMapper;
	
	

	@Test
	public void test() {
		List<MetaTbl> tableList = mybatisGenMapper.getTableList("t_sys_user");
		logger.debug(tableList);
		
		// CodeGen
//		CodeGen gen = new CodeGen("src/com/sales/config/freemarker");

		// set code model
		CodeModel model = new CodeModel();		
		model.setTableName("t_sys_parameter_type");		
		model.setModuleName("用户信息");
		model.setModuleCode("SysParameterType");
		model.setWebContextPath("${pageContext.request.contextPath }");

		model.setServiceImplPackageName("com.sales.service.impl");
		model.setServiceImplClsName("SysParameterTypeImplService");

		model.setServicePackage("com.sales.service");
		model.setServiceClsName("SysParameterTypeService");
		model.setServiceName("sysParameterTypeService");

		model.setDaoPackage("com.sales.dao");
		model.setDaoClsName("SysParameterTypeMapper");
		model.setDaoName("sysParameterTypeMapper");

		model.setDaoMapperPackage("com.sales.config.mybatis.mapper");
		model.setDaoMapperName("SysParameterTypeMapper");

		model.setModelPackage("com.sales.model");
		model.setModelClsName("SysParameterType");
		model.setModelName("sysParameterType");

		model.setControllerPackage("com.sales.controller");
		model.setControllerClsName("SysParameterTypeController");
		model.setRequestMapping("/admin/system/sysParameterType");
		model.setViewPath("WebRoot/WEB-INF/view");
		
		Map<String,String> tblLabelMap = new HashMap<String,String>();
		tblLabelMap.put("t_drp_mat_batch", "batch_no");
		tblLabelMap.put("t_drp_sheet", "sheet_no");
		tblLabelMap.put("t_sys_parameter", "param_val");
		tblLabelMap.put("t_sys_config", "value");
		tblLabelMap.put("t_sys_user", "user_name");
		tblLabelMap.put("t_vip", "vip_name");
		tblLabelMap.put("t_vip_card", "vip_no");
		tblLabelMap.put("t_vip_coupon", "coupon_sn");
		model.setTblLabelMap(tblLabelMap);

		// set base dir
		String baseDir = "E:\\source/workplace-a8-new/sale_admin_gen";
//		baseDir = System.getProperty("user.dir");
		
		System.out.println(baseDir);
		codeGenService.genService(baseDir, "src/com/sales/config/freemarker", model);
		codeGenService.genController(baseDir, "src/com/sales/config/freemarker", model);
		codeGenService.genModel(baseDir, "src/com/sales/config/freemarker", model);
		codeGenService.genDao(baseDir, "src/com/sales/config/freemarker", model);
		 codeGenService.genDaoMapper(baseDir, "src/com/sales/config/freemarker", model);
		 codeGenService.genPages(baseDir, "src/com/sales/config/freemarker", model);

		 System.out.println("--ok--");

	}
	
	

}
