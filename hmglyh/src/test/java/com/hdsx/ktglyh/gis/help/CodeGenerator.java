package com.hdsx.hmglyh.gis.help;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.junit.Test;
/**
 * 
 * @author zhanglm
 *
 */
public class CodeGenerator {
	
	@Test
	public void mytest(){
		String s = "PingjiaodkResultMap";
		System.out.println(s.substring(0,s.indexOf("ResultMap")));
	}
	
	// 生成 sql 元素
	@Test
	public void createSqlColumns() throws Exception{
		
	
		
		//1获得dom4j Document
		SAXReader saxReader = new SAXReader();
		Document document = saxReader.read(new File("D:/codeGenerator/sql.xml"));  //java.io.FileNotFoundException 文件不存在异常
		
		//2必须获得根元素
		Element rootElement = document.getRootElement();
		
		//3获得所有元素
		List allElement = rootElement.elements("resultMap");
		
		Document targetD = DocumentHelper.createDocument();
		
		Element tarM = targetD.addElement("mapper");
		
		
		String sqlString = "";
		
		//4遍历
		for(int i = 0 ; i < allElement.size() ; i ++){
			
			Element sqlE = tarM.addElement("sql");
		
			Element resultMapE =  (Element) allElement.get(i);
			String resultMapId= (String)resultMapE.attributeValue("id");
			
			String sqlId = resultMapId.substring(0,resultMapId.indexOf("ResultMap")) +"_Column_List";
			
			List<Element> resultEs = resultMapE.elements();
			
			String strSql = "";
			for( int j = 0 ; j < resultEs.size(); j++ ) {
				strSql += "," + resultEs.get(j).attributeValue("column");
			}
			sqlE.setText(strSql.substring(1));
			sqlE.setAttributeValue("id", sqlId);
		}
		
		
		//3保存document
		FileOutputStream out = new FileOutputStream(new File("d:/codeGenerator/sqlTarget.xml"));
		
		XMLWriter xmlWriter = new XMLWriter(out,OutputFormat.createPrettyPrint());
		xmlWriter.write(targetD);
		xmlWriter.close();
		
		System.out.println("save");
		
	}
	
	@Test
	public void createSqlWhere() throws Exception{
		
		String []  equals = {"ROADCODE","XZQH","CODE","CRKLX","LDLX"};
		String []  likes = {"NAME"};
		
		String id = "Gaosucrk_Where";
		
		//1获得dom4j Document
		SAXReader saxReader = new SAXReader();
		Document sqlD =  saxReader.read(new File("D:/codeGenerator/whereSource.xml"));  //java.io.FileNotFoundException 文件不存在异常
		Element sqlE = sqlD.getRootElement();
		sqlE.setAttributeValue("id", id);
		Element whereE = sqlE.addElement("where");
	//	whereE.setAttributeValue("id", id);
		
		for(int i = 0 ; i < equals.length ; i++ ) {
			Element ifE = whereE.addElement("if");
			ifE.setAttributeValue("test",  equals[i].toLowerCase() + " != null and "+equals[i].toLowerCase()+" != '' ");
			ifE.setText(" and " + equals[i].toUpperCase() + " = #{" + equals[i].toLowerCase() + "}");
		}
		
		for(int i = 0 ; i < likes.length ; i++ ) {
			Element ifE = whereE.addElement("if");
			ifE.setAttributeValue("test",  likes[i].toLowerCase() + " != null and "+likes[i].toLowerCase() +" != '' ");
			ifE.setText(" and " + likes[i].toUpperCase() + " like '%' || #{" + likes[i].toLowerCase() + "} || '%'");
		}
		
		//3保存document
		FileOutputStream out = new FileOutputStream(new File("d:/codeGenerator/whereTarget.xml"));
		
		XMLWriter xmlWriter = new XMLWriter(out,OutputFormat.createPrettyPrint());
		xmlWriter.write(sqlD);
		xmlWriter.close();
		
		System.out.println("save");
	}
	
	// 创建 select 元素
	@Test
	public void createSelect() throws Exception{
		
		// 其他要素
	/*	String basePackage = "com.hdsx.hmglyh.gis.jichusj.qitays.dao.model.";
		String funcs [] = {"Jianzhicun","Jumindian","Xiangzhen","Zirancun","Lvyoujd","Xuexiao","Qitalxd","Guoshuilm","Bixiancd","Tingchedao","Lvhua"};	
		String tables [] = {"JIANZHICUN","JUMINDIAN","xiangzhen","zirancun","jinqu","School","OTHERPOINT","GUOSHUILUMIAN","PUTONGGONGLUBIXIANCHEDAO","PUTONGGONGLUTINGCHEDAO","lxlh"};
		*/
		// 路线交叉
		String basePackage = "com.hdsx.hmglyh.gis.jichusj.luxianjc.dao.model.";
		String funcs[] = {"Gaosucrk","Pingjiaodk"};
		String tables [] = {"GSCHURU","PINGJIAODAOKOU"};
		
		// 应急抢险
		/*String basePackage = "com.hdsx.hmglyh.gis.jichusj.yingjiqx.dao.model.";
		String funcs[] = {"Dizhizhd","Zaihaiyfld","Yingjibzd","Wuziku"};
		String tables [] = {"DIZHI","ZAIHAIYIFALD","YINGJIBAOZHANGDIAN","WUZI"};*/
		
		// 沿线设施
		/*String basePackage = "com.hdsx.hmglyh.gis.jichusj.yanxianss.dao.model.";
		String funcs [] = {"Jiaoanss","Jiaotongbz","Tianqiao",
				"Jianchanzhan","Jiaotonglianggcz","Luxiandmtd","Fuwuqu"
				,"Yanxianfwss","Shoufeizhan","Guanlijg"
				};
		String tables [] = {"JIAOANSHESHI","JIAOTONGBIAOZHI","TIANQIAO","Jianchazhan",
				"JIAOTONG","roadmedia","fuwuqu","FUWUSHESHI","shoufeizhan","GUANLIJIGOU"
		};*/
		
		Document document = DocumentHelper.createDocument();
		Element mE = document.addElement("Mapper");
		
		for ( int i = 0; i < funcs.length; i++ ) {
			
			Element selE = mE.addElement("select");
			selE.setAttributeValue("id", funcs[i].toLowerCase() + "List");
			selE.setAttributeValue("resultMap", funcs[i]+"ResultMap");
			selE.setAttributeValue("parameterType", basePackage+funcs[i]);
			String selText = "	SELECT * FROM("+
								"SELECT ROWNUM RN,TEMP.* FROM( select";		
			
			selE.addText(selText);
			
			Element incE1 = selE.addElement("include");
			incE1.setAttributeValue("refid", funcs[i] + "_Column_List" );
			selE.addText( "from " + tables[i] );
			Element incE2 = selE.addElement("include");
			incE2.setAttributeValue("refid", funcs[i]+"_Where" );
			
			selE.addText(") TEMP"); 
			Element ifE = selE.addElement("if");
			ifE.setAttributeValue("test", "page != null and page != '' ");
			ifE.setText("where <![CDATA[ROWNUM <= (#{page} * #{rows}))]]>");
			Element whereE = selE.addElement("where");
			Element wIfE = whereE.addElement("if");
			wIfE.setAttributeValue("test", "page != null and page != ''");
			wIfE.setText( "<![CDATA[RN>((#{page} - 1) * #{rows})]]>");
			 	  
			Element countE = mE.addElement("select");
			countE.setAttributeValue("id", funcs[i].toLowerCase() + "Count");
			countE.setAttributeValue("resultType", "int");
			countE.setAttributeValue("parameterType", basePackage+funcs[i]);
		
			countE.addText("select count(*) from " + tables[i]);
			Element countInclude = countE.addElement("include");
			countInclude.setAttributeValue("refid",funcs[i]+"_Where");
		}
		
		//3保存document
		FileOutputStream out = new FileOutputStream(new File("d:/codeGenerator/selectTarget.xml"));
		
		XMLWriter xmlWriter = new XMLWriter(out,OutputFormat.createPrettyPrint());
		xmlWriter.write(document);
		xmlWriter.close();
		
		System.out.println("保存生成的 select 的语句，d:/codeGenerator/selectTarget.xml ");
		
	}
	
}

