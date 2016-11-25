package com.sales.service.util.impl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.sales.dao.util.MybatisGenMapper;
import com.sales.model.util.meta.MetaCol;
import com.sales.model.util.meta.MetaFk;
import com.sales.model.util.meta.MetaTbl;
import com.sales.service.util.CodeGenService;
import com.sales.util.common.codegen.CodeModel;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

@Service("codeGenService")
public class CodeGenServiceImpl implements CodeGenService {
	private static Logger logger = Logger.getLogger(CodeGenServiceImpl.class);
	private Map<String,Class> dataTypeMapping;
	private static final String split_token = "_";
	private static final String tbl_prefix = "t_";
	
	private CodeModel codeModel; //参数
	private String baseDir; // 文件产生目录
	private String templateDir; //ftl模板存放目录
	
	@Resource
	private MybatisGenMapper mybatisGenMapper;
	
	
	/**
	 * 数据初始化
	 * @param codeModel
	 */
	private void init(String baseDir,String templateDir,CodeModel codeModel){
		//模板存放位置
		this.templateDir = templateDir;
		
		//数据模型
		this.codeModel = codeModel;
		
		//文件产生路径
		this.baseDir = baseDir;
		
		//设置数据库类型与JAVA类型映射规则
		initDataTypeMapping();
		
		//根据表名设置表对象
		initMetaTbl();
	}
	
	/**
	 * 根据表名初始化表对象
	 */
	private void initMetaTbl(){
		MetaTbl metaTbl = mybatisGenMapper.getTableInfo(codeModel.getTableName());
		metaTbl = mybatisGenMapper.getTableInfo(codeModel.getTableName());
		metaTbl.setPrimaryKey(mybatisGenMapper.getTablePK(codeModel.getTableName()));
		metaTbl.setPrimaryKeyProperty(this.genProperty(metaTbl.getPrimaryKey()));
		logger.debug(metaTbl);
		
		List<MetaCol> colList = mybatisGenMapper.getColumnList(codeModel.getTableName());
		logger.debug(colList);
		for(MetaCol metaCol : colList){
			metaCol.setJavaType(this.dataTypeMapping.get(metaCol.getDataType().toUpperCase()));
			metaCol.setJavaTypeName(metaCol.getJavaType().getName());
			metaCol.setJavaTypeSimpleName(metaCol.getJavaType().getSimpleName());
			
			metaCol.setPropertyName(this.genProperty(metaCol.getColumnName()));
			metaCol.setCapitalizePropertyName(StringUtils.capitalize(metaCol.getPropertyName()));
			
			if(metaCol.getConstraintName()!=null){
				metaCol.setRefPropertyName(metaCol.getPropertyName()+"Ref");
				metaCol.setCapitalizeRefPropertyName(StringUtils.capitalize(metaCol.getRefPropertyName()));
				metaCol.setReferencedTableClsName(this.genTblClassName(metaCol.getReferencedTableName()));
				metaCol.setReferencedTablePropertyName(StringUtils.uncapitalize(metaCol.getReferencedTableClsName()));
			}
			
			String refLabelColumnName = codeModel.getTblLabelMap().get(metaCol.getReferencedTableName())==null?"name":codeModel.getTblLabelMap().get(metaCol.getReferencedTableName());
			metaCol.setRefLabelColumnName(refLabelColumnName);
			metaCol.setRefLabelPropertyName(this.genProperty(metaCol.getRefLabelColumnName()));
			//
//			public void setRefLabelColumnName(String refLabelColumnName) {
//				this.refLabelColumnName = refLabelColumnName;
//			}
//			public void setRefLabelPropertyName(String refLabelPropertyName) {
//				this.refLabelPropertyName = refLabelPropertyName;
//			}
		}
		metaTbl.setColList(colList);
		
		
		//fklist
		List<MetaFk> fkList = mybatisGenMapper.getColumnFKList(codeModel.getTableName());
		logger.debug(fkList);
		metaTbl.setFkList(fkList);
		codeModel.setMetaTbl(metaTbl);
		
		//refDistinctColList
		List<String> referencedTbls = mybatisGenMapper.getReferencedTbls(codeModel.getTableName());
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
		
		//create_user_id column object etc.
		if(codeModel.getCreateUpdateMap()!=null){
			for (Iterator<String> iterator = codeModel.getCreateUpdateMap().keySet().iterator(); iterator
					.hasNext();) {
				String key = (String) iterator.next();
				String columnName = codeModel.getCreateUpdateMap().get(key);
				
				for (MetaCol metaCol : metaTbl.getColList()) {
					if(key.equals("create_user") && metaCol.getColumnName().equals(columnName)) {
						metaTbl.setCreateUserIdCol(metaCol);
						break;
					}else if(key.equals("create_date") && metaCol.getColumnName().equals(columnName)) {
						metaTbl.setCreateDateCol(metaCol);
						break;
					}else if(key.equals("update_user") && metaCol.getColumnName().equals(columnName)) {
						metaTbl.setUpdateUserIdCol(metaCol);
						break;
					}else if(key.equals("update_date") && metaCol.getColumnName().equals(columnName)) {
						metaTbl.setUpdateDateCol(metaCol);
						break;
					}		
				}
			}
		}
	}
	
	/**
	 * 设置java类型与数据库类型映射规则
	 */
	private void initDataTypeMapping(){
		dataTypeMapping = new HashMap<String,Class>();
		dataTypeMapping.put("BIGINT", java.lang.Long.class);
		dataTypeMapping.put("VARCHAR", java.lang.String.class);
		dataTypeMapping.put("TEXT", java.lang.String.class);
		dataTypeMapping.put("INT", java.lang.Long.class);
		dataTypeMapping.put("DATETIME", java.util.Date.class);
		dataTypeMapping.put("DECIMAL", java.lang.Double.class);
	}
	
	/**
	 * java属性字段
	 * @param columnName
	 * @return
	 */
	private String genProperty(String columnName) {
		columnName = columnName.toLowerCase();
		String[] columns = columnName.split(split_token);
		String rtnColumnName = "";
		for (String s : columns) {
			rtnColumnName += StringUtils.capitalize(s);
		}
		return StringUtils.uncapitalize(rtnColumnName);
	}
	
	/**
	 * java class类名
	 * @param tableName
	 * @return
	 */
	private String genTblClassName(String tableName) {
		tableName = tableName.toLowerCase();
		String[] columns = tableName.substring(tbl_prefix.length()).split(split_token); //table start with prefix of "t_"
		String rtnColumnName = "";
		for (String s : columns) {
			rtnColumnName += StringUtils.capitalize(s);
		}
		return rtnColumnName;
	}

	
	/**
	 * 文件输出
	 * @param outputFile
	 * @param template
	 */
	private void output(File outputFile, String template) {
		try {
			Configuration cfg = new Configuration(Configuration.VERSION_2_3_23);
			// 设置模板目录
			cfg.setDirectoryForTemplateLoading(
					new java.io.File(this.templateDir));
			// 设置默认编码格式
			cfg.setDefaultEncoding("UTF-8");
			// 从设置的目录中获得模板
			Template temp = cfg.getTemplate(template);
			// 合并模板和数据模型
			FileOutputStream fos = new FileOutputStream(outputFile);
			Writer out = new OutputStreamWriter(fos);
//			 Writer out = new OutputStreamWriter(System.out);
			temp.process(this.codeModel, out);
			// 关闭
			out.flush();
			out.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * service
	 */
	public void genService(String baseDir,String templateDir,CodeModel codeModel) {
		//初始化
		this.init(baseDir,templateDir,codeModel);
		
		// service.ftl
		String sourceDir = this.baseDir + "/" + "src";
		String path = sourceDir + "/"
				+ codeModel.getServicePackage().replace(".", "/") ;
		if(!(new java.io.File(path)).exists()){
			(new java.io.File(path)).mkdirs();
		}
		
		String serviceOutputFile = path+ "/"
				+ codeModel.getServiceClsName() + ".java";
		System.out.println(serviceOutputFile);
		this.output(new java.io.File(serviceOutputFile), "service.ftl");
		
		//serviceImpl.ftl
		String implPath = sourceDir + "/"
				+ codeModel.getServiceImplPackageName().replace(".", "/") ;
		if(!(new java.io.File(implPath)).exists()){
			(new java.io.File(implPath)).mkdirs();
		}
		String serviceImplOutputFile = implPath + "/"
				+ codeModel.getServiceImplClsName() + ".java";
		System.out.println(serviceImplOutputFile);
		this.output(new java.io.File(serviceImplOutputFile), "serviceImpl.ftl");
	}
	
	public void genController(String baseDir,String templateDir,CodeModel codeModel) {
		//初始化
		this.init(baseDir,templateDir,codeModel);
				
		String sourceDir = this.baseDir + "/" + "src";
		String path = sourceDir + "/"
				+ codeModel.getControllerPackage().replace(".", "/") ;
		if(!(new java.io.File(path)).exists()){
			(new java.io.File(path)).mkdirs();
		}
		
		// service.ftl
		String outputFile = path + "/"
				+ codeModel.getControllerClsName() + ".java";
		System.out.println(outputFile);
		this.output(new java.io.File(outputFile), "controller.ftl");
	}
	
	
	public void genModel(String baseDir,String templateDir,CodeModel codeModel) {
		//初始化
		this.init(baseDir,templateDir,codeModel);
		
		String sourceDir = this.baseDir + "/" + "src";
		String path = sourceDir + "/"
				+ codeModel.getModelPackage().replace(".", "/") ;
		if(!(new java.io.File(path)).exists()){
			(new java.io.File(path)).mkdirs();
		}
		
		// service.ftl
		String outputFile = path + "/"
				+ codeModel.getModelClsName() + ".java";
		System.out.println(outputFile);
		this.output(new java.io.File(outputFile), "model.ftl");
	}
	
	public void genDao(String baseDir,String templateDir,CodeModel codeModel) {
		//初始化
		this.init(baseDir,templateDir,codeModel);
		
		String sourceDir = this.baseDir + "/" + "src";
		String path = sourceDir + "/"
				+ codeModel.getDaoPackage().replace(".", "/") ;
		if(!(new java.io.File(path)).exists()){
			(new java.io.File(path)).mkdirs();
		}
		
		// service.ftl
		String outputFile = path + "/"
				+ codeModel.getDaoClsName() + ".java";
		System.out.println(outputFile);
		this.output(new java.io.File(outputFile), "dao.ftl");
	}
	
	
	public void genDaoMapper(String baseDir,String templateDir,CodeModel codeModel){
		//初始化
		this.init(baseDir,templateDir,codeModel);
		
		String sourceDir = this.baseDir + "/" + "src";
		String path = sourceDir + "/"
				+ codeModel.getDaoMapperPackage().replace(".", "/") ;
		if(!(new java.io.File(path)).exists()){
			(new java.io.File(path)).mkdirs();
		}
		
		// service.ftl
		String outputFile = path + "/"
				+ codeModel.getDaoMapperName() + ".xml";
		System.out.println(outputFile);
		this.output(new java.io.File(outputFile), "dao_mapper.ftl");
	}
	
	
	public void genPages(String baseDir,String templateDir,CodeModel codeModel) {
		//初始化
		this.init(baseDir,templateDir,codeModel);
		
		String pageDir = baseDir + "/" + codeModel.getViewPath() + codeModel.getRequestMapping();
		File path = new File(pageDir);
		if(!(path.exists())){
			path.mkdirs();
		}
		
		//add_page.ftl
		String addPageFile = pageDir + "/" + "add.jsp";
		System.out.println(addPageFile);
		this.output(new java.io.File(addPageFile), "add_page.ftl");
		
		//edit_page.ftl
		String editPageFile = pageDir + "/" + "edit.jsp";
		System.out.println(editPageFile);
		this.output(new java.io.File(editPageFile), "edit_page.ftl");
		
		//view_page.ftl
		String viewPageFile = pageDir + "/" + "view.jsp";
		System.out.println(viewPageFile);
		this.output(new java.io.File(viewPageFile), "view_page.ftl");
		
		//form_page.ftl
		String formPageFile = pageDir + "/" + "_form.jsp";
		System.out.println(formPageFile);
		this.output(new java.io.File(formPageFile), "form_page.ftl");
		
		//index_page.ftl
		String indexPageFile = pageDir + "/" + "index.jsp";
		System.out.println(indexPageFile);
		this.output(new java.io.File(indexPageFile), "index_page.ftl");
	}
	
	private MetaCol findMetaColByTbl(String tableName, List<MetaCol> list){
		for (MetaCol metaCol : list) {
			if(metaCol.getReferencedTableName().equals(tableName)){
				return metaCol;
			}
		}
		return null;
	}
	

}
