package com.hdsx.hmglyh.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hdsx.hmglyh.rcyh.service.impl.BhflowServiceImpl;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class HDFreeMarker {
	
	private static Logger log = LoggerFactory.getLogger(HDFreeMarker.class);
	
	 /** 
     * freemark模板配置 
     */  
    private Configuration configuration;  
    /** 
     * freemark模板的名字 
     */  
    private String templateName;  
    /** 
     * 生成文件名 
     */  
    private String fileName;  
    /** 
     * 生成文件路径 
     */  
    private String filePath;  
	
	
	public void createJsonFile(HashMap<String,Object> map, String filePath,String fileName){  
         
	        Template t = null;  
	        try {  
	            //获取模板信息  
	            t = configuration.getTemplate(filePath);  
	        } catch (IOException e) {  
	            e.printStackTrace();  
	        }  
	          
	        File outFile = new File(fileName);  
	        Writer out = null;  
	        try {  
	            out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile), "UTF-8"));  
	        } catch (UnsupportedEncodingException e) {  
	            e.printStackTrace();  
	        } catch (FileNotFoundException e) {  
	            e.printStackTrace();  
	        }  
	          
	        try {  
	            //输出数据到模板中，生成文件。  
	            t.process(map, out);  
	            out.close();  
	            log.info(fileName + "生成成功!"+outFile.getAbsolutePath());
	        } catch (TemplateException e) {  
	            e.printStackTrace();  
	        } catch (IOException e) {  
	            e.printStackTrace();  
	        }  
	          
	    }  
	    /** 
	     * freemark初始化 
	     * @param templatePath 模板文件位置 
	     */  
	    public HDFreeMarker(String templatePath) {  
	        configuration = new Configuration();  
	        configuration.setDefaultEncoding("utf-8");  
	        configuration.setClassForTemplateLoading(this.getClass(),templatePath);       
	    }     
	   
	  
	    public String getFileName() {  
	        return fileName;  
	    }  
	  
	    public void setFileName(String fileName) {  
	        this.fileName = fileName;  
	    }  
	  
	    public String getFilePath() {  
	        return filePath;  
	    }  
	  
	    public void setFilePath(String filePath) {  
	        this.filePath = filePath;  
	    }  
	  
	    public String getTemplateName() {  
	        return templateName;  
	    }  
	  
	    public void setTemplateName(String templateName) {  
	        this.templateName = templateName;  
	    }  
}
