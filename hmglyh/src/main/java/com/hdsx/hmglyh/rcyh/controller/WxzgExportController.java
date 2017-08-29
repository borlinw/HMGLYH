package com.hdsx.hmglyh.rcyh.controller;

import java.io.OutputStream;

import javax.annotation.Resource;

import jxl.Workbook;
import jxl.format.Border;
import jxl.format.BorderLineStyle;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import org.springframework.stereotype.Controller;

import com.hdsx.hmglyh.rcyh.base.BaseAction;
import com.hdsx.hmglyh.rcyh.dao.model.RcyhWxzg;
import com.hdsx.hmglyh.rcyh.service.RcyhWxzgService;

/**  
 *  “维修整改”中通知单和回复单的导出类
 * @author LiRui
 * @created 2015年7月20日 下午1:41:15 
 */
@Controller
public class WxzgExportController extends BaseAction {

	private static final long serialVersionUID = -6173281696245300230L;

	@Resource(name="rcyhWxzgServiceImpl") 
	private RcyhWxzgService service; 

	private String tzdid;				//维修整改通知单ID
	private String hfdid;				//维修整改回复单ID
	private String fileName;		//文件名（除去后缀名）
	//private InputStream fileStream;	//下载使用的文件流
	private OutputStream fileStream;	//下载使用的文件流
	private String type = "xls";	//文件类型（文件后缀名）

	//测试地址（回复单）：http://lrlucky:8080/hmglyh/rcyh/wxzgExport_exportHfd.do?tzdid=dc299425-7e77-43dd-b273-bb0cbd5b7e65&hfdid=6e517f15-3c10-4825-8053-6e80d6ae54e5

	/**
	 * 导出通知单
	 * 描述：根据tzdid导出通知单（Jxl）
	 * @return 
	 */
	public void exportTzd(){
		//输出流
		//OutputStream os = System.out;
		try{
			OutputStream os = getResponse().getOutputStream();
			RcyhWxzg model = new RcyhWxzg();
			model.setTzdid(tzdid);
			RcyhWxzg tzd = service.queryTzdToExport(model);
			if(tzd == null || tzd.getTzdid() == null){
				throw new Exception("请求“通知单数据出错。”");
			}
			//创建工作薄（某Excel）
			//WritableWorkbook workbook = Workbook.createWorkbook(new File("C:/Users/Administrator/Desktop/测试.xls"));
			WritableWorkbook workbook = Workbook.createWorkbook(os);
			//创建一个新的Sheet（Excel中的页签）
			WritableSheet sheet = workbook.createSheet("整改通知单", 0);
			sheet.mergeCells(0, 0, 4, 0);//添加合并单元格，第一个参数是起始列，第二个参数是起始行，第三个参数是终止列，第四个参数是终止行
			//给所有列设置默认宽度，给行设置高度
			sheet.getSettings().setDefaultColumnWidth(20);
			
			//单元格水平、垂直居中
			//设置字体种类和黑体显示,字体为Arial,字号大小为10,采用黑体显示
			WritableFont bold = new WritableFont(WritableFont.ARIAL,14,WritableFont.BOLD);
			WritableCellFormat titleFormate = new WritableCellFormat(bold);//生成一个单元格样式控制对象
			titleFormate.setAlignment(jxl.format.Alignment.CENTRE);//单元格中的内容水平方向居中
			titleFormate.setVerticalAlignment(jxl.format.VerticalAlignment.CENTRE);//单元格的内容垂直方向居中
			Label title = new Label(0,0,"日常养护作业检查整改通知单",titleFormate);
			sheet.setRowView(0, 800, false);//设置第一行的高度（表头）
			sheet.addCell(title);
			
			//填表单位 .... 表6-11
			sheet.setRowView(1, 400, false);//设置行的高度
			sheet.mergeCells(0, 1, 1, 1);//合并单元格
			Label title2 = new Label(0,1," 填表单位："+tzd.getTbbmname());
			sheet.addCell(title2);
			//title3WCF水平靠右
			WritableCellFormat title3WCF = new WritableCellFormat();//生成一个单元格样式控制对象
			title3WCF.setAlignment(jxl.format.Alignment.RIGHT);//单元格中的靠右对齐
			Label title3 = new Label(4,1,"表 6-11 ",title3WCF);
			sheet.addCell(title3);

			//正文内容
			WritableCellFormat tzdxlhWCF = new WritableCellFormat();//生成一个单元格样式控制对象
			tzdxlhWCF.setAlignment(jxl.format.Alignment.RIGHT);//单元格中的内容水平方向居中
			tzdxlhWCF.setBorder(Border.ALL, BorderLineStyle.THIN);//设置全边框
			sheet.setRowView(2, 400, false);//设置行的高度
			sheet.mergeCells(3, 2, 4, 2);//合并单元格
			Label tzdxlh = new Label(3,2,"通知单序列号："+tzd.getTzdxlj(),tzdxlhWCF);//通知单序列号
			sheet.addCell(tzdxlh);
			//以下至下个注释之间纯属为了设置边框
			WritableCellFormat borderWCF = new WritableCellFormat();//生成一个单元格样式控制对象
			borderWCF.setBorder(Border.TOP, BorderLineStyle.THIN);
			borderWCF.setBorder(Border.LEFT, BorderLineStyle.THIN);
			sheet.mergeCells(0, 2, 2, 2);//合并单元格
			Label kongbaiToBorder = new Label(0,2,"",borderWCF);//通知单序列号之前的空白的边框设置
			sheet.addCell(kongbaiToBorder);
			//正文内容1
			sheet.setRowView(4, 1000, false);//设置行的高度
			sheet.mergeCells(0, 4, 4, 4);//合并单元格
			WritableCellFormat textWCF = new WritableCellFormat();//生成一个单元格样式控制对象
			textWCF.setWrap(true);//通过调整宽度和高度自动换行
			textWCF.setVerticalAlignment(jxl.format.VerticalAlignment.CENTRE);//单元格的内容垂直方向居中
			textWCF.setBorder(Border.LEFT, BorderLineStyle.THIN);//设置左边框
			textWCF.setBorder(Border.RIGHT, BorderLineStyle.THIN);//设置右边框
			sheet.setRowView(3, 400, false);//设置行的高度
			sheet.mergeCells(0, 3, 4, 3);//合并单元格
			Label text1 = new Label(0,3,"致：",textWCF);//通知单序列号
			sheet.addCell(text1);
			Label text2 = new Label(0,4,"    经巡查、检查发现你单位 "+tzd.getSbbmname()+" 在 "+tzd.getWz()+" 等处，从事的养护作业存在以下问题，请务必"+tzd.getYq()+"按本单要求进行整改，并于 "+tzd.getSxtimeStr()+" 前报送整改结果，特此通知。",textWCF);
			sheet.addCell(text2);
			//检查人、送单时间
			WritableCellFormat jcrsdtimeWCF = new WritableCellFormat();//生成一个单元格样式控制对象（检查人、送单时间的标签）
			jcrsdtimeWCF.setAlignment(jxl.format.Alignment.RIGHT);//单元格中的靠右对齐
			jcrsdtimeWCF.setBorder(Border.LEFT, BorderLineStyle.THIN);//设置左边框
			WritableCellFormat jcrsdtimeDataWCF = new WritableCellFormat();//生成一个单元格样式控制对象（检查人、送单时间的数据）
			jcrsdtimeDataWCF.setAlignment(jxl.format.Alignment.LEFT);//单元格中的靠右对齐
			jcrsdtimeDataWCF.setBorder(Border.RIGHT, BorderLineStyle.THIN);//设置右边框
			sheet.mergeCells(0, 5, 3, 5);//合并单元格
			Label textJcr = new Label(0,5,"检查人：",jcrsdtimeWCF);
			sheet.addCell(textJcr);
			Label textJcrName = new Label(4,5,tzd.getTbrxm(),jcrsdtimeDataWCF);
			sheet.addCell(textJcrName);
			sheet.mergeCells(0, 6, 3, 6);//合并单元格
			Label textSdtime = new Label(0,6,"送单时间：",jcrsdtimeWCF);
			sheet.addCell(textSdtime);
			Label textSdtimeStr = new Label(4,6,tzd.getSdtimeStr(),jcrsdtimeDataWCF);
			sheet.addCell(textSdtimeStr);
			//存在问题和整改要求
			//生成一个单元格样式控制对象（垂直、水平居中）
			WritableCellFormat WCF1 = new WritableCellFormat();
			WCF1.setVerticalAlignment(jxl.format.VerticalAlignment.CENTRE);//单元格的内容垂直方向居中
			WCF1.setAlignment(jxl.format.Alignment.CENTRE);//单元格中的内容水平方向居中
			WCF1.setBorder(Border.ALL, BorderLineStyle.THIN);//设置全边框
			WritableCellFormat WCF2 = new WritableCellFormat();//生成一个单元格样式控制对象（顶端对齐）
			WCF2.setVerticalAlignment(jxl.format.VerticalAlignment.TOP);//数据靠上
			WCF2.setBorder(Border.ALL, BorderLineStyle.THIN);//设置全边框
			WCF2.setWrap(true);//自动换行
			sheet.setRowView(7, 4000, false);//设置行的高度
			Label czwt = new Label(0,7,"存在问题：",WCF1);
			sheet.addCell(czwt);
			sheet.mergeCells(1, 7, 4, 7);//合并单元格
			Label czwtStr = new Label(1,7,tzd.getCzwt(),WCF2);//存在问题内容
			sheet.addCell(czwtStr);
			sheet.setRowView(8, 4000, false);//设置行的高度
			Label zgyq = new Label(0,8,"整改要求：",WCF1);
			sheet.addCell(zgyq);
			sheet.mergeCells(1, 8, 4, 8);//合并单元格
			Label zgyqStr = new Label(1,8,tzd.getZgyq(),WCF2);//整改要求内容
			sheet.addCell(zgyqStr);
			
			//接单人、接单时间
			WritableCellFormat jdrWCF = new WritableCellFormat();
			jdrWCF.setBorder(Border.LEFT, BorderLineStyle.THIN);//左
			jdrWCF.setBorder(Border.BOTTOM, BorderLineStyle.THIN);//下
			sheet.setRowView(9, 500, false);//设置行的高度
			sheet.mergeCells(0, 9, 2, 9);//合并单元格
			Label jdr = new Label(0,9,"接单人："+tzd.getJdrxm(),jdrWCF);
			sheet.addCell(jdr);
			sheet.mergeCells(3, 9, 4, 9);//合并单元格
			WritableCellFormat jdtimeWCF = new WritableCellFormat();//生成一个单元格样式控制对象
			jdtimeWCF.setAlignment(jxl.format.Alignment.RIGHT);//单元格数据靠右对齐
			jdtimeWCF.setBorder(Border.RIGHT, BorderLineStyle.THIN);//左
			jdtimeWCF.setBorder(Border.BOTTOM, BorderLineStyle.THIN);//下
			Label jdTime = new Label(3,9,"接单时间："+tzd.getJdtimeStr(),jdtimeWCF);
			sheet.addCell(jdTime);

			fileName = new String("整改通知单.xls".getBytes("UTF-8"), "ISO-8859-1");
			getResponse().setHeader("Content-disposition", "attachment;filename=" + fileName);

			//将内容输出并关闭输出流
			workbook.write();
			workbook.close();
			//os.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	/**
	 * 导出回复单
	 * 描述：根据thfdid导出回复单（Jxl）
	 */
	public void exportHfd(){
		try{
			//输出流
			//OutputStream os = ServletActionContext.getResponse().getOutputStream();
			OutputStream os = getResponse().getOutputStream();
			/*ServletActionContext.getResponse().setContentType("application/msexcel");  
			ServletActionContext.getResponse().setHeader("Content-Disposition", "attachment;filename="+"整改回复单.xls");*/
			RcyhWxzg model = new RcyhWxzg();
			//model.setHfdid(hfdid);
			model.setTzdid(tzdid);
			//model.setTzdid("aecf7e60-734f-48aa-aea1-fd4348a4ec46");
			RcyhWxzg hfd = service.queryHfdToExport(model);
			if(hfd == null || hfd.getHfdid() == null){
				throw new Exception("请求“回复单数据出错。”");
			}
			//创建工作薄（某Excel）
			//WritableWorkbook workbook = Workbook.createWorkbook(new File("C:/Users/Administrator/Desktop/测试.xls"));
			WritableWorkbook workbook = Workbook.createWorkbook(os);
			//创建一个新的Sheet（Excel中的页签）
			WritableSheet sheet = workbook.createSheet("整改回复单", 0);
			sheet.mergeCells(0, 0, 3, 0);//添加合并单元格，第一个参数是起始列，第二个参数是起始行，第三个参数是终止列，第四个参数是终止行
			//给所有列设置默认宽度
			sheet.getSettings().setDefaultColumnWidth(20);
			//单元格水平、垂直居中（标题）
			//设置字体种类和黑体显示,字体为Arial,字号大小为10,采用黑体显示
			WritableFont bold = new WritableFont(WritableFont.ARIAL,14,WritableFont.BOLD);
			WritableCellFormat titleFormate = new WritableCellFormat(bold);//生成一个单元格样式控制对象
			titleFormate.setAlignment(jxl.format.Alignment.CENTRE);//单元格中的内容水平方向居中
			titleFormate.setVerticalAlignment(jxl.format.VerticalAlignment.CENTRE);//单元格的内容垂直方向居中
			Label title = new Label(0,0,"日常养护作业检查整改回复单",titleFormate);
			sheet.setRowView(0, 800, false);//设置第一行的高度（表头）
			sheet.addCell(title);
			//表6-12
			WritableCellFormat title3WCF = new WritableCellFormat();//生成一个单元格样式控制对象
			title3WCF.setAlignment(jxl.format.Alignment.RIGHT);//单元格中的靠右对齐
			Label title3 = new Label(3,1,"表 6-12 ",title3WCF);
			sheet.addCell(title3);
			//养护作业单位 .... 日期
			sheet.setRowView(1, 400, false);//设置行的高度
			sheet.mergeCells(0, 2, 1, 2);//合并单元格
			Label title2 = new Label(0,2," 养护作业单位："+hfd.getZybmname());
			sheet.addCell(title2);
			sheet.mergeCells(2, 2, 3, 2);//合并单元格
			Label titleRq = new Label(2,2,"日期："+hfd.getHfdateStr(),title3WCF);
			sheet.addCell(titleRq);

			//正文内容
				//textWCF：水平、垂直居中，全边框
			WritableCellFormat textWCF = new WritableCellFormat();//生成一个单元格样式控制对象
			textWCF.setAlignment(jxl.format.Alignment.CENTRE);//单元格中的内容水平方向居中
			textWCF.setVerticalAlignment(jxl.format.VerticalAlignment.CENTRE);//单元格的内容垂直方向居中
			textWCF.setBorder(Border.ALL, BorderLineStyle.THIN);//设置全边框
			//正文第一行
			sheet.setRowView(3, 400, false);//设置行的高度
			Label tzdbhLabel = new Label(0,3,"通知单编号：",textWCF);//通知单编号标题
			sheet.addCell(tzdbhLabel);
			Label tzdbh = new Label(1,3,hfd.getTzdxlj(),textWCF);//通知单编号内容（通知单中的序列号）
			sheet.addCell(tzdbh);
			Label tztimeLabel = new Label(2,3,"通知时间：",textWCF);//通知时间标题
			sheet.addCell(tztimeLabel);
			Label tztime = new Label(3,3,hfd.getSdtimeStr(),textWCF);//通知时间内容
			sheet.addCell(tztime);
			//正文第二行
			sheet.setRowView(4, 400, false);//设置行的高度
			Label yqtimeLabel = new Label(0,4,"要求完成时间：",textWCF);//要求完成时间标题
			sheet.addCell(yqtimeLabel);
			Label yqtime = new Label(1,4,hfd.getSxtimeStr(),textWCF);//要求完成时间内容
			sheet.addCell(yqtime);
			Label sjtimeLabel = new Label(2,4,"实际完成时间：",textWCF);//实际完成时间标题
			sheet.addCell(sjtimeLabel);
			Label sjtime = new Label(3,4,hfd.getSjwctimeStr(),textWCF);//实际完成时间内容
			sheet.addCell(sjtime);
			//正文表格内容
			sheet.setRowView(5, 4000, false);//设置行的高度
			Label zgcsLabel = new Label(0,5,"整改措施",textWCF);
			sheet.addCell(zgcsLabel);
			sheet.setRowView(6, 4000, false);//设置行的高度
			Label zgjgLabel = new Label(0,6,"整改结果",textWCF);
			sheet.addCell(zgjgLabel);
			sheet.mergeCells(0, 7, 0, 8);//合并单元格
			sheet.setRowView(7, 4000, false);//设置行的高度
			Label shyjLabel = new Label(0,7,"检查人审核意见",textWCF);
			sheet.addCell(shyjLabel);
			//设置单元格格式（单元格内容左、上对齐，自动换行，全边框）
			WritableCellFormat text2WCF = new WritableCellFormat();
			text2WCF.setAlignment(jxl.format.Alignment.LEFT);
			text2WCF.setVerticalAlignment(jxl.format.VerticalAlignment.TOP);
			text2WCF.setBorder(Border.ALL, BorderLineStyle.THIN);//设置全边框
			text2WCF.setWrap(true);//自动换行
			sheet.mergeCells(1, 5, 3, 5);//合并单元格（整改措施内容）
			Label zgcs = new Label(1,5,hfd.getZgcs(),text2WCF);
			sheet.addCell(zgcs);
			sheet.mergeCells(1, 6, 3, 6);//合并单元格（整改结果内容）
			Label zgjg = new Label(1,6,hfd.getZgjg(),text2WCF);
			sheet.addCell(zgjg);
			sheet.mergeCells(1, 7, 3, 7);//合并单元格（检查人审核意见内容）
			//设置单元格格式（单元格内容左、上对齐，自动换行，右边框）
			WritableCellFormat text3WCF = new WritableCellFormat();
			text3WCF.setAlignment(jxl.format.Alignment.LEFT);
			text3WCF.setVerticalAlignment(jxl.format.VerticalAlignment.TOP);
			text3WCF.setBorder(Border.RIGHT, BorderLineStyle.THIN);
			Label jcrshyj = new Label(1,7,hfd.getJcryj(),text3WCF);
			sheet.addCell(jcrshyj);
			//设置单元格格式（水平右对齐，垂直居中，右、下边框）
			WritableCellFormat text4WCF = new WritableCellFormat();
			text4WCF.setAlignment(jxl.format.Alignment.RIGHT);
			text4WCF.setVerticalAlignment(jxl.format.VerticalAlignment.CENTRE);
			text4WCF.setBorder(Border.RIGHT, BorderLineStyle.THIN);
			text4WCF.setBorder(Border.BOTTOM, BorderLineStyle.THIN);
			sheet.mergeCells(1, 8, 3, 8);//合并单元格（检查人审核意见内容）
			Label qm = new Label(1,8,"签名："+hfd.getJcrxm()+"          ",text4WCF);
			sheet.addCell(qm);

			fileName = new String("整改回复单.xls".getBytes("UTF-8"), "ISO-8859-1");
			getResponse().setHeader("Content-disposition", "attachment;filename=" + fileName);

			//将内容输出并关闭输出流
			workbook.write();
			//os.close();
			//fileName = new String("整改回复单.xls".getBytes("UTF-8"), "ISO-8859-1");
			//fileStream = new FileInputStream(workbook.toString());
			//fileStream = new FileInputStream(os.toString());
			//fileStream = os;
			//fileStream = new FileOutputStream(new File(os.toString()));
			workbook.close();
			//return SUCCESS;
		}catch(Exception e){
			e.printStackTrace();
			//return ERROR;
		}
	}

	//tzdid和hfdid的Get、Set方法
	public String getTzdid() {
		return tzdid;
	}
	public void setTzdid(String tzdid) {
		this.tzdid = tzdid;
	}
	public String getHfdid() {
		return hfdid;
	}
	public void setHfdid(String hfdid) {
		this.hfdid = hfdid;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public OutputStream getFileStream() {
		return fileStream;
	}
	public void setFileStream(OutputStream fileStream) {
		this.fileStream = fileStream;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

}
