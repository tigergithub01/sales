package com.sales.service.util;

import com.sales.util.common.codegen.CodeModel;

public interface CodeGenService {
	public void genService(String baseDir,String templateDir,CodeModel codeModel);
	
	public void genController(String baseDir,String templateDir,CodeModel codeModel);
	
	public void genModel(String baseDir,String templateDir,CodeModel codeModel);
	
	public void genDao(String baseDir,String templateDir,CodeModel codeModel) ;
	
	public void genDaoMapper(String baseDir,String templateDir,CodeModel codeModel);
	
	public void genPages(String baseDir,String templateDir,CodeModel codeModel);
}
