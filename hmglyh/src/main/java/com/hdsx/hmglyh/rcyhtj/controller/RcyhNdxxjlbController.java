/**
 * 北京恒达时讯科技有限公司版权所有
 * Copyright (C) HDSX Corporation. All Rights Reserved
 */
package com.hdsx.hmglyh.rcyhtj.controller;

import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import jxl.Workbook;
import jxl.format.Border;
import jxl.format.BorderLineStyle;
import jxl.format.UnderlineStyle;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.hdsx.hmglyh.base.BaseActionSupport;
import com.hdsx.hmglyh.jcpd.dto.Result;
import com.hdsx.hmglyh.rcyhtj.bean.RcyhNdxxjlb;
import com.hdsx.hmglyh.rcyhtj.service.RcyhNdxxjlbService;
import com.hdsx.hmglyh.util.EasyUIPage;
import com.hdsx.hmglyh.util.JsonUtils;
import com.hdsx.hmglyh.util.ResponseUtils;

/**
 * 
 * @author jason
 *
 */
@Controller
@Scope(value="request")
public class RcyhNdxxjlbController extends BaseActionSupport<RcyhNdxxjlb> {

	
	private static final long serialVersionUID = -2865578191898987738L;

	@Resource(name="rcyhNdxxjlbServiceImpl")
	private RcyhNdxxjlbService rcyhNdxxjlbService;
	
	private RcyhNdxxjlb rcyhNdxxjlb = new RcyhNdxxjlb();
	
	
	public RcyhNdxxjlb getRcyhNdxxjlb() {
		return rcyhNdxxjlb;
	}
	public void setRcyhNdxxjlb(RcyhNdxxjlb rcyhNdxxjlb) {
		this.rcyhNdxxjlb = rcyhNdxxjlb;
	}
	/**
	 * 查询学习记录信息
	 */
	public void queryXxjl() throws Exception{
		List<RcyhNdxxjlb> list = rcyhNdxxjlbService.queryXxjl(rcyhNdxxjlb);
		int total = rcyhNdxxjlbService.getXxCount(rcyhNdxxjlb);
		EasyUIPage<RcyhNdxxjlb> ep = new EasyUIPage<RcyhNdxxjlb>();
		ep.setRows(list);
		ep.setTotal(total);
		JsonUtils.write(ep, this.getResponse().getWriter());
	}
	/**
	 * 查询年份
	 */
	public void getNf() throws Exception{
		List<RcyhNdxxjlb> list = rcyhNdxxjlbService.getNf(rcyhNdxxjlb);
		JsonUtils.write(list, this.getResponse().getWriter());
	}
	/**
	 * 添加
	 */
	public void add(){
		try {
			Date now =rcyhNdxxjlb.getXxdate();
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			String date = dateFormat.format(now); 
			rcyhNdxxjlb.setJldate(new Date());
			rcyhNdxxjlb.setNf(date.toString().substring(0, 4));
			rcyhNdxxjlbService.add(rcyhNdxxjlb);
			ResponseUtils.write(getResponse(), "true");
			}catch (Exception e) {
				e.printStackTrace();
				ResponseUtils.write(getResponse(), "false");
			}
		}
	
	/**
	 * 修改
	 * @throws Exception 
	 */
	public void change() throws Exception{
		Date now =rcyhNdxxjlb.getXxdate();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		String date = dateFormat.format(now); 
		rcyhNdxxjlb.setNf(date.toString().substring(0, 4));
		rcyhNdxxjlbService.change(rcyhNdxxjlb);
		int result = 0;
		try {
		boolean msg=rcyhNdxxjlbService.change(rcyhNdxxjlb);
		if(msg)
			result = 1;
		else
			result = -1;
	}catch (Exception e) {
		e.printStackTrace();
	}
		Result r = new Result();
		r.setResult(result);
		JsonUtils.write(r, this.getResponse().getWriter());
	}
	
	/**
	 * 删除学习记录
	 */
	public void drop() throws Exception{
		int result = 0;
		try {
			boolean msg = rcyhNdxxjlbService.drop(rcyhNdxxjlb);
			if(msg){
				result = 1;
			}else{
				result = -1;
			}
			}catch (Exception e) {
			e.printStackTrace();
		}
		Result r = new Result();
		r.setResult(result);
		JsonUtils.write(r, this.getResponse().getWriter());
	}
	
	//导出学习记录表
	public void exportXxjl(){
		try{
			//请求学习记录数据
			List<RcyhNdxxjlb> list = rcyhNdxxjlbService.queryXxjl(rcyhNdxxjlb);
			if(rcyhNdxxjlb == null){
				throw new Exception("请求“通知单数据出错。”");
			}
			//正文样式
			WritableFont wf = new WritableFont(WritableFont.createFont("宋体") ,10,WritableFont.BOLD,false,UnderlineStyle.NO_UNDERLINE,jxl.format.Colour.BLACK); 
			WritableCellFormat textTitleWCF = new WritableCellFormat(wf);//生成一个单元格样式控制对象
			textTitleWCF.setAlignment(jxl.format.Alignment.CENTRE);//水平居中
			textTitleWCF.setVerticalAlignment(jxl.format.VerticalAlignment.CENTRE);//垂直居中
			textTitleWCF.setBorder(Border.ALL, BorderLineStyle.THIN);//设置全边框
			//设置第二行,最后一行样式
			WritableFont bold1 = new WritableFont(WritableFont.createFont("宋体") ,11,WritableFont.BOLD,false,UnderlineStyle.NO_UNDERLINE,jxl.format.Colour.BLACK); 
			WritableCellFormat titleFormate1 = new WritableCellFormat(bold1);//生成一个单元格样式控制对象
			titleFormate1.setAlignment(jxl.format.Alignment.LEFT);//水平居中
			titleFormate1.setVerticalAlignment(jxl.format.VerticalAlignment.CENTRE);//垂直居中
			
			
			//获取输出流
			OutputStream os = getResponse().getOutputStream();
			//创建工作薄（Excel）
			WritableWorkbook workbook = Workbook.createWorkbook(os);
			//WritableWorkbook workbook = Workbook.createWorkbook(new File("C:/Users/Administrator/Desktop/测试.xls"));
			WritableSheet sheet = workbook.createSheet("日常养护年度学习记录表", 0);//根据Excel创建一个Excel的sheet
			sheet.mergeCells(0, 0, 5, 0);//添加合并单元格，第一个参数是起始列，第二个参数是起始行，第三个参数是终止列，第四个参数是终止行
			//给所有列设置默认宽度
			//sheet.getSettings().setDefaultColumnWidth(20);
			sheet.setColumnView(0, 8);
			sheet.setColumnView(1, 40);
			sheet.setColumnView(2, 40);
			sheet.setColumnView(3, 15);
			sheet.setColumnView(4, 20);
			sheet.setColumnView(5, 40);
			//设置表头（水平、垂直居中）
			WritableFont bold = new WritableFont(WritableFont.ARIAL,14,WritableFont.BOLD);
			WritableCellFormat titleFormate = new WritableCellFormat(bold);//生成一个单元格样式控制对象
			titleFormate.setAlignment(jxl.format.Alignment.CENTRE);//水平居中
			titleFormate.setVerticalAlignment(jxl.format.VerticalAlignment.CENTRE);//垂直居中
		//	titleFormate.setBorder(Border.ALL, BorderLineStyle.THIN);//设置全边框
			Label title = new Label(0,0,"日常养护年度学习记录表",titleFormate);
			sheet.setRowView(0, 800, false);//设置第一行的高度（表头）
			sheet.addCell(title);
			
			
			sheet.setRowView(0, 700, false);//设置行的高度
			
			Label xh = new Label(0,2,"序号",textTitleWCF);
			sheet.addCell(xh);
			Label xxnr = new Label(1,2,"学习内容 ",textTitleWCF);
			sheet.addCell(xxnr);
			Label ry = new Label(2,2,"人员 ",textTitleWCF);
			sheet.addCell(ry);
			Label xxdd = new Label(3,2,"学习地点 ",textTitleWCF);
			sheet.addCell(xxdd);
			Label xxsj = new Label(4,2,"学习时间 ",textTitleWCF);
			sheet.addCell(xxsj);
			Label bz = new Label(5,2,"备注 ",textTitleWCF);
			sheet.addCell(bz);
			int i=1;
			for(RcyhNdxxjlb rcyhNdxxjlb:list){
				//养护作业单位
				sheet.mergeCells(0, 1, 3, 1);
				Label title2 = new Label(0,1," 养护作业单位："+rcyhNdxxjlb.getBmname(),titleFormate1);
				sheet.setRowView(1, 400, false);//设置行的高度
				sheet.addCell(title2);
				
				
				//添加“填报日期”的单元格格式：水平居中
				Label title3 = new Label(4,1,"第    页共     页",titleFormate1);
				sheet.addCell(title3);
				Label xh_xh = new Label(0,i+2,i+"",textTitleWCF);
				sheet.addCell(xh_xh);
				Label xxnr_xh = new Label(1,i+2,rcyhNdxxjlb.getXxnr(),textTitleWCF);
				sheet.addCell(xxnr_xh);
				Label ry_xh = new Label(2,i+2,rcyhNdxxjlb.getXxry(),textTitleWCF);
				sheet.addCell(ry_xh);
				Label xxdd_xh = new Label(3,i+2,rcyhNdxxjlb.getXxdd(),textTitleWCF);
				sheet.addCell(xxdd_xh);
				Date now =rcyhNdxxjlb.getXxdate();
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				String date = dateFormat.format(now); 
				Label xxsj_xh = new Label(4,i+2,date,textTitleWCF);
				sheet.addCell(xxsj_xh);
				Label bz_xh = new Label(5,i+2,rcyhNdxxjlb.getBz(),textTitleWCF);
				sheet.addCell(bz_xh);
				i++;
			}
			sheet.setRowView(1, 400, false);//设置行的高度
			sheet.mergeCells(0, i+2, 1, i+2);//合并单元格：表中固有内容（路线名称）
			Label title4 = new Label(0,i+2," 养护作业单位负责人：",titleFormate1);
			sheet.addCell(title4);
		//	sheet.mergeCells(5, 1, 5, 1);//合并单元格：填报日期
			
			//添加“填报日期”的单元格格式：水平居中
			Label title5 = new Label(2,i+2,"填表：",titleFormate1);
			sheet.addCell(title5);
			Label title6 = new Label(4,i+2,"日期：",titleFormate1);
			sheet.addCell(title6);
			
			
			//处理文件名以及设置Response方式
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
			String fileNameStr = "日常养护年度学习记录表"+sdf.format(new Date())+".xls";
		//	System.out.println("处理好的带日期参数的文件名为："+fileNameStr);
			fileName = new String(fileNameStr.getBytes("UTF-8"), "ISO-8859-1");
			getResponse().setHeader("Content-disposition", "attachment;filename=" + fileName);
			//将内容输出并关闭输出流
			workbook.write();
			workbook.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	//导出用
		private String fileName;		//文件名（除去后缀名）
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
		private OutputStream fileStream;	//下载使用的文件流
		private String type = "xls";	//文件类型（文件后缀名）

	
	
	
	
	
	
	
	@Override
	protected void prepareModel() throws Exception {
		// TODO Auto-generated method stub
		
	}
	@Override
	public RcyhNdxxjlb getModel() {
		return rcyhNdxxjlb;
	}
	
}
