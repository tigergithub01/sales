package com.sales.test.codegen;

import java.util.ArrayList;
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
import com.sales.model.util.meta.MetaCol;
import com.sales.model.util.meta.MetaFk;
import com.sales.model.util.meta.MetaTbl;
import com.sales.util.common.codegen.CodeGen;
import com.sales.util.common.codegen.CodeModel;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"classpath:com/sales/config/spring-mybatis.xml" })
public class MybatisGenMapperTest {
	private static Logger logger = Logger.getLogger(MybatisGenMapperTest.class);

	@Resource
	private MybatisGenMapper mybatisGenMapper = null;

	@Test
	public void test() {
		List<MetaTbl> tableList = mybatisGenMapper.getTableList("t_sys_user");
		logger.debug(tableList);
		
		// CodeGen
		CodeGen gen = new CodeGen("src/com/sales/config/freemarker");

		// set base dir
		String userDir = System.getProperty("user.dir");
		gen.setBaseDir(userDir);

		// set code model
		CodeModel model = new CodeModel();
		gen.setCodeModel(model);

		model.setServiceImplPackageName("com.sales.service.system.impl");
		model.setServiceImplClsName("SysParameterTypeImplService");

		model.setServicePackage("com.sales.service.system");
		model.setServiceClsName("SysParameterTypeService");
		model.setServiceName("sysParameterTypeService");

		model.setDaoPackage("com.sales.dao.system");
		model.setDaoClsName("SysParameterTypeMapper");
		model.setDaoName("sysParameterTypeMapper");

		model.setDaoMapperPackage("com.sales.config.mybatis.mapper.system");
		model.setDaoMapperName("SysParameterTypeMapper");

		model.setModelPackage("com.sales.model.system");
		model.setModelClsName("SysParameterType");
		model.setModelName("sysParameterType");

		model.setControllerPackage("com.sales.controller.system");
		model.setControllerClsName("SysParameterTypeController");
		model.setRequestMapping("/admin/system/sysParameterType");
		model.setViewPath("WebRoot/WEB-INF/view");

		model.setModuleName("用户信息");
		model.setModuleCode("SysParameterType");

		model.setWebContextPath("${pageContext.request.contextPath }");
		
		model.setTableName("t_sys_parameter_type");
		
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
		
//		metaTbl
		MetaTbl metaTbl = mybatisGenMapper.getTableInfo("t_sys_user");
		metaTbl = mybatisGenMapper.getTableInfo("t_sys_user");
		metaTbl.setPrimaryKey(mybatisGenMapper.getTablePK("t_sys_user"));
		metaTbl.setPrimaryKeyProperty(gen.genProperty(metaTbl.getPrimaryKey()));
		logger.debug(metaTbl);
		
		List<MetaCol> colList = mybatisGenMapper.getColumnList("t_sys_user");
		logger.debug(colList);
		for(MetaCol metaCol : colList){
			metaCol.setJavaType(gen.getDataTypeMapping().get(metaCol.getDataType().toUpperCase()));
			metaCol.setJavaTypeName(metaCol.getJavaType().getName());
			metaCol.setJavaTypeSimpleName(metaCol.getJavaType().getSimpleName());
			
			metaCol.setPropertyName(gen.genProperty(metaCol.getColumnName()));
			metaCol.setCapitalizePropertyName(StringUtils.capitalize(metaCol.getPropertyName()));
			
			if(metaCol.getConstraintName()!=null){
				metaCol.setRefPropertyName(metaCol.getPropertyName()+"Ref");
				metaCol.setCapitalizeRefPropertyName(StringUtils.capitalize(metaCol.getRefPropertyName()));
				metaCol.setReferencedTableClsName(gen.genTblClassName(metaCol.getReferencedTableName()));
				metaCol.setReferencedTablePropertyName(StringUtils.uncapitalize(metaCol.getReferencedTableClsName()));
			}
			
			String refLabelColumnName = tblLabelMap.get(metaCol.getReferencedTableName())==null?"name":tblLabelMap.get(metaCol.getReferencedTableName());
			metaCol.setRefLabelColumnName(refLabelColumnName);
			metaCol.setRefLabelPropertyName(gen.genProperty(metaCol.getRefLabelColumnName()));
			//
//			public void setRefLabelColumnName(String refLabelColumnName) {
//				this.refLabelColumnName = refLabelColumnName;
//			}
//			public void setRefLabelPropertyName(String refLabelPropertyName) {
//				this.refLabelPropertyName = refLabelPropertyName;
//			}
		}
		metaTbl.setColList(colList);
		

		List<MetaFk> fkList = mybatisGenMapper.getColumnFKList("t_sys_user");
		logger.debug(fkList);
		metaTbl.setFkList(fkList);
		model.setMetaTbl(metaTbl);
		
		List<String> referencedTbls = mybatisGenMapper.getReferencedTbls("t_sys_user");
		List<MetaCol> refDistinctColList = new ArrayList<MetaCol>();
		for (String refTableName : referencedTbls) {
			MetaCol metaColRefTbl = null;
			for (MetaCol metaCol : metaTbl.getColList()) {
				if(metaCol.getReferencedTableName()!=null && metaCol.getReferencedTableName().equals(refTableName)){
					metaColRefTbl = metaCol;
					break;
				}				
			}
			refDistinctColList.add(metaColRefTbl);
		}
		metaTbl.setRefDistinctColList(refDistinctColList);
		

//		gen.genService();
//		gen.genController();
		
		
//		gen.genModel();

//		gen.genDao();
//		 gen.genDaoMapper();
		 gen.genPages();

		 System.out.println("--ok--");

	}
	
	

}
