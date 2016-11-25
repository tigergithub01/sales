package com.sales.util.common.codegen;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.util.StringUtils;

import com.sales.model.util.meta.MetaCol;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class CodeGen {
	private Map<String,Class> dataTypeMapping;
	private static final String split_token = "_";
	private static final String tbl_prefix = "t_";
	
	public CodeGen() {
		
	}

	public CodeGen(String templateDir) {
		this.templateDir = templateDir;
		initDataTypeMapping();
	}
	
	
	private void initDataTypeMapping(){
		dataTypeMapping = new HashMap<String,Class>();
		dataTypeMapping.put("BIGINT", java.lang.Long.class);
		dataTypeMapping.put("VARCHAR", java.lang.String.class);
		dataTypeMapping.put("TEXT", java.lang.String.class);
		dataTypeMapping.put("INT", java.lang.Long.class);
		dataTypeMapping.put("DATETIME", java.util.Date.class);
		dataTypeMapping.put("DECIMAL", java.lang.Double.class);
	}
	
	public String genProperty(String columnName) {
		columnName = columnName.toLowerCase();
		String[] columns = columnName.split(split_token);
		String rtnColumnName = "";
		for (String s : columns) {
			rtnColumnName += StringUtils.capitalize(s);
		}
		return StringUtils.uncapitalize(rtnColumnName);
	}
	
	public String genTblClassName(String tableName) {
		tableName = tableName.toLowerCase();
		String[] columns = tableName.substring(tbl_prefix.length()).split(split_token); //table start with prefix of "t_"
		String rtnColumnName = "";
		for (String s : columns) {
			rtnColumnName += StringUtils.capitalize(s);
		}
		return rtnColumnName;
	}
	

	public Map<String, Class> getDataTypeMapping() {
		return dataTypeMapping;
	}

	public void setDataTypeMapping(Map<String, Class> dataTypeMapping) {
		this.dataTypeMapping = dataTypeMapping;
	}

	private CodeModel codeModel;
	private String baseDir; // 目录
	private String templateDir;

	public String getBaseDir() {
		return baseDir;
	}

	public void setBaseDir(String baseDir) {
		this.baseDir = baseDir;
	}

	public String getTemplateDir() {
		return templateDir;
	}

	public void setTemplateDir(String templateDir) {
		this.templateDir = templateDir;
	}

	public CodeModel getCodeModel() {
		return codeModel;
	}

	public void setCodeModel(CodeModel codeModel) {
		this.codeModel = codeModel;
	}

	/**
	 * @param outputFile
	 * @param templateDir
	 * @param template
	 * @throws IOException
	 * @throws TemplateException
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
//			Writer out = new OutputStreamWriter(fos);
			 Writer out = new OutputStreamWriter(System.out);
			temp.process(this.codeModel, out);
			// temp.process(this.parameters, out);
			// 关闭
			out.flush();
			out.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public void genService() {
		// service.ftl
		String sourceDir = baseDir + "/" + "src";
		String serviceOutputFile = sourceDir + "/"
				+ codeModel.getServicePackage().replace(".", "/") + "/"
				+ codeModel.getServiceClsName() + ".java";
		System.out.println(serviceOutputFile);
		this.output(new java.io.File(serviceOutputFile), "service.ftl");
		
		//serviceImpl.ftl
		String serviceImplOutputFile = sourceDir + "/"
				+ codeModel.getServiceImplPackageName().replace(".", "/") + "/"
				+ codeModel.getServiceImplClsName() + ".java";
		System.out.println(serviceImplOutputFile);
		this.output(new java.io.File(serviceImplOutputFile), "serviceImpl.ftl");
	}
	
	public void genController() {
		String sourceDir = baseDir + "/" + "src";
		
		// service.ftl
		String outputFile = sourceDir + "/"
				+ codeModel.getControllerPackage().replace(".", "/") + "/"
				+ codeModel.getControllerClsName() + ".java";
		System.out.println(outputFile);
		this.output(new java.io.File(outputFile), "controller.ftl");
	}
	
	
	public void genModel() {
		String sourceDir = baseDir + "/" + "src";
		
		// service.ftl
		String outputFile = sourceDir + "/"
				+ codeModel.getModelPackage().replace(".", "/") + "/"
				+ codeModel.getModelClsName() + ".java";
		System.out.println(outputFile);
		this.output(new java.io.File(outputFile), "model.ftl");
	}
	
	public void genDao() {
		String sourceDir = baseDir + "/" + "src";
		
		// service.ftl
		String outputFile = sourceDir + "/"
				+ codeModel.getDaoPackage().replace(".", "/") + "/"
				+ codeModel.getDaoClsName() + ".java";
		System.out.println(outputFile);
		this.output(new java.io.File(outputFile), "dao.ftl");
	}
	
	
	public void genDaoMapper(){
		String sourceDir = baseDir + "/" + "src";
		
		
		// service.ftl
		String outputFile = sourceDir + "/"
				+ codeModel.getDaoMapperPackage().replace(".", "/") + "/"
				+ codeModel.getDaoMapperName() + ".xml";
		System.out.println(outputFile);
		this.output(new java.io.File(outputFile), "dao_mapper.ftl");
	}
	
	
	public void genPages() {
		String pageDir = baseDir + "/" + codeModel.getViewPath() + codeModel.getRequestMapping();
		File path = new File(pageDir);
		if(!(path.exists())){
			path.mkdirs();
		}
		
//		//add_page.ftl
//		String addPageFile = pageDir + "/" + "add.jsp";
//		System.out.println(addPageFile);
//		this.output(new java.io.File(addPageFile), "add_page.ftl");
//		
//		//edit_page.ftl
//		String editPageFile = pageDir + "/" + "edit.jsp";
//		System.out.println(editPageFile);
//		this.output(new java.io.File(editPageFile), "edit_page.ftl");
//		
//		//view_page.ftl
//		String viewPageFile = pageDir + "/" + "view.jsp";
//		System.out.println(viewPageFile);
//		this.output(new java.io.File(viewPageFile), "view_page.ftl");
		
		//form_page.ftl
		String formPageFile = pageDir + "/" + "_form.jsp";
		System.out.println(formPageFile);
		this.output(new java.io.File(formPageFile), "form_page.ftl");
		
//		//index_page.ftl
//		String indexPageFile = pageDir + "/" + "index.jsp";
//		System.out.println(indexPageFile);
//		this.output(new java.io.File(indexPageFile), "index_page.ftl");
	}
	
	private MetaCol findMetaColByTbl(String tableName, List<MetaCol> list){
		for (MetaCol metaCol : list) {
			if(metaCol.getReferencedTableName().equals(tableName)){
				return metaCol;
			}
		}
		return null;
	}
	
	
	

	public static void main(String[] args)
			throws IOException, TemplateException {
	}

}
