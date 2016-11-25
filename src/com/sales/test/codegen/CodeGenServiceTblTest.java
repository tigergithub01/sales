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
import org.springframework.util.StringUtils;

import com.sales.dao.util.MybatisGenMapper;
import com.sales.model.util.meta.MetaTbl;
import com.sales.service.util.CodeGenService;
import com.sales.util.common.codegen.CodeGen;
import com.sales.util.common.codegen.CodeModel;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"classpath:com/sales/config/spring-mybatis.xml" })
public class CodeGenServiceTblTest {
	private static Logger logger = Logger.getLogger(CodeGenServiceTblTest.class);

	@Resource
	private CodeGenService codeGenService; 
	
	@Resource
	private MybatisGenMapper mybatisGenMapper;
	
	@Test
	public void test() {
		List<MetaTbl> tableList = mybatisGenMapper.getTableList("");
		CodeGen codeGen = new CodeGen();
		for (MetaTbl metaTbl : tableList) {
			metaTbl.setTableNameClsName(codeGen.genTblClassName(metaTbl.getTableName()));
			metaTbl.setTableNameProperty(StringUtils.uncapitalize(metaTbl.getTableNameClsName()));
			
			CodeModel model = new CodeModel();		
			model.setTableName(metaTbl.getTableName());		
			model.setModuleName(metaTbl.getTableComment());
			model.setModuleCode(metaTbl.getTableNameClsName());

			model.setServiceImplPackageName("com.sales.service.business.impl");
			model.setServiceImplClsName(metaTbl.getTableNameClsName()+ "ServiceImpl");

			model.setServicePackage("com.sales.service.business");
			model.setServiceClsName(metaTbl.getTableNameClsName()+ "Service");
			model.setServiceName(metaTbl.getTableNameProperty() + "Service");

			model.setDaoPackage("com.sales.dao.business");
			model.setDaoClsName(metaTbl.getTableNameClsName() + "Mapper");
			model.setDaoName(metaTbl.getTableNameProperty() + "Mapper");

			model.setDaoMapperPackage("com.sales.config.mybatis.mapper.business");
			model.setDaoMapperName(metaTbl.getTableNameClsName() + "Mapper");

			model.setModelPackage("com.sales.model.business");
			model.setModelClsName(metaTbl.getTableNameClsName());
			model.setModelName(metaTbl.getTableNameProperty());

			model.setControllerPackage("com.sales.controller.business");
			model.setControllerClsName(metaTbl.getTableNameClsName() + "Controller"); 
			model.setRequestMapping("/admin/"+metaTbl.getTableNameProperty());
			model.setViewPath("WebRoot/WEB-INF/view");
			model.setWebContextPath("${pageContext.request.contextPath}");
			model.setUuid("${uuid}");
			
			Map<String,String> tblLabelMap = new HashMap<String,String>();
			tblLabelMap.put("t_drp_mat_batch", "batch_no");
			tblLabelMap.put("t_drp_sheet", "sheet_no");
			tblLabelMap.put("t_sys_parameter", "param_val");
			tblLabelMap.put("t_sys_config", "value");
			tblLabelMap.put("t_sys_user", "user_name");
			tblLabelMap.put("t_vip", "vip_name");
			tblLabelMap.put("t_vip_card", "vip_no");
			tblLabelMap.put("t_vip_coupon", "coupon_sn");
			tblLabelMap.put("t_drp_pos_trans_info", "flow_no");
			model.setTblLabelMap(tblLabelMap);
			
			Map<String,String> createUpdateMap = new HashMap<String,String>();
			createUpdateMap.put("create_user", "create_user_id");
			createUpdateMap.put("create_date", "create_date");
			createUpdateMap.put("update_user", "update_user_id");
			createUpdateMap.put("update_date", "update_date");
			model.setCreateUpdateMap(createUpdateMap);

			// set base dir
			String baseDir = "E:\\source/workplace-a8-new/sale_admin_gen";
//			baseDir = System.getProperty("user.dir");
			
			System.out.println(baseDir);
			codeGenService.genService(baseDir, "src/com/sales/config/freemarker/coder", model);
			codeGenService.genController(baseDir, "src/com/sales/config/freemarker/coder", model);
			codeGenService.genModel(baseDir, "src/com/sales/config/freemarker/coder", model);
			codeGenService.genDao(baseDir, "src/com/sales/config/freemarker/coder", model);
			codeGenService.genDaoMapper(baseDir, "src/com/sales/config/freemarker/coder", model);
			codeGenService.genPages(baseDir, "src/com/sales/config/freemarker/coder", model);

			 System.out.println("--ok--");
			
		}
//		logger.debug(tableList);
		
		// CodeGen
//		CodeGen gen = new CodeGen("src/com/sales/config/freemarker");

		// set code model
		

	}
	

	
	

}
