package com.hdsx.hmglyh.gis.help;

import java.io.File;
import java.io.FileWriter;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;

public class ColumnsGenerator {
	
	// 生成 columns
	public static void generateColumns(String mapperFile) throws Exception {
		//1获得dom4j Document
		SAXReader saxReader = new SAXReader();
		saxReader.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false);
		Document document = saxReader.read(new File(mapperFile));  //java.io.FileNotFoundException 文件不存在异常
		
		//2必须获得根元素
		Element mapperE = document.getRootElement();
		
		//3获得所有元素
		List<Element> resultMapEs = mapperE.elements("resultMap");
		String tempStr = mapperFile.substring(0,mapperFile.lastIndexOf("."));
		String fname = tempStr.substring(tempStr.lastIndexOf("/"),tempStr.length()-6)+"Columns.js";
		
		File f = new File("D://codeGenerator/columnsTarget/"+fname);
		FileWriter fw = new FileWriter(f);
		
		if(f.exists()) {
			f.delete();
			f.createNewFile();
		}
		
		for( Element ele : resultMapEs ) {
			
			List<Element> resultEs = ele.elements("result");
			String id = ele.attributeValue("id");
			String colname = id.substring(0,id.indexOf("ResultMap"));
			StringBuilder sb = new StringBuilder();
			sb.append("\n var "+colname+"Columns = [[");
			for( Element rE : resultEs ) {
				sb.append("\n    {field:'"+rE.attributeValue("property")+"',title:'"+rE.attributeValue("property")+"',width:100},");
			}
			String s = sb.toString();
			String json = s.substring(0,s.length()-1);
			json += "\n]];";
			
			
			fw.write(json);
			System.out.println("写入"+colname + "成功");
		}
		
		fw.close();
	}
	
	@Test
	public void createColumnsByResultMap() throws Exception{
		ColumnsGenerator.generateColumns("D:/codeGenerator/RcyhWxzyjlbMapper.xml");
	}
	
}
