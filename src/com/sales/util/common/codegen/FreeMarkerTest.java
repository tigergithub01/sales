package com.sales.util.common.codegen;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

/**
 * http://freemarker.org/docs/index.html
 * 
 * 
 * @author Tiger-guo
 * 2016年11月17日 下午3:02:00
 */
public class FreeMarkerTest {

	public static void main(String[] args) throws IOException, TemplateException {
		// TODO Auto-generated method stub
		//创建一个freemarker.template.Configuration实例，它是存储 FreeMarker 应用级设置的核心部分
        //指定版本号
        Configuration cfg=new Configuration(Configuration.VERSION_2_3_23);
        //设置模板目录
        cfg.setDirectoryForTemplateLoading(new File("src/com/sales/config/freemarker"));
        //设置默认编码格式
        cfg.setDefaultEncoding("UTF-8");
        
        //数据
        Map<String, Object> product = new HashMap<String, Object>();
        product.put("name", "Huwei P8");
        product.put("price", "3985.7");
        product.put("users", new String[]{"Tom","Jack","Rose"});
        
        //从设置的目录中获得模板
        Template temp = cfg.getTemplate("service.ftl");
        
        //合并模板和数据模型
        FileOutputStream fos = new FileOutputStream(new java.io.File("e:/1.txt"));
        Writer out = new OutputStreamWriter(fos);
//        Writer out = new OutputStreamWriter(System.out);
        
       
        temp.process(product, out);
        
        
        //TODO:可以输出到文件
        
        
        //关闭
        out.flush();
        out.close();	
	}

}
