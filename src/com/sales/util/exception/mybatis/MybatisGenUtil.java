package com.sales.util.exception.mybatis;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

public class MybatisGenUtil {
	public static void main(String[] args){
		MybatisGenUtil util = new MybatisGenUtil();
		util.gen();
	}
	
	private void gen(){
		try{
			List<String> warnings = new ArrayList<String>();
			   boolean overwrite = true;
			   String file = getClass().getResource("/com/sales/config/mybatis/mybatis-generator-config.xml").getPath();
			   File configFile = new File(file);
			   System.out.println(configFile.getAbsolutePath());
			   
			   ConfigurationParser cp = new ConfigurationParser(warnings);
			   Configuration config = cp.parseConfiguration(configFile);
			   DefaultShellCallback callback = new DefaultShellCallback(overwrite);
			   MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
			   myBatisGenerator.generate(null);
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
}
