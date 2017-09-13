
 /**
 * 北京恒达时讯科技有限公司版权所有
 * Copyright (C) HDSX Corporation. All Rights Reserved
 */
package com.hdsx.hmglyh.gis.card.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.hdsx.hmglyh.base.BaseActionSupport;
import com.hdsx.hmglyh.gis.card.bean.Card;
import com.hdsx.hmglyh.gis.card.service.CardService;
import com.hdsx.hmglyh.gis.card.util.ExcelToHtml;
import com.hdsx.hmglyh.gis.card.util.Word2Html;
import com.hdsx.hmglyh.gis.jichusj.luxian.dao.model.Attachment;
import com.hdsx.hmglyh.util.JsonUtils;

/**  
 *  
 * @author Baiyy
 * @created 2015年8月6日 下午4:04:27 
 */
@Controller
@Scope(value="request")
public class CardController extends BaseActionSupport<Card> {
	private static final long serialVersionUID = -8195919499363874049L;
	
	@Resource(name="cardServiceImpl")
	private CardService cardService;
	
	private Card card = new Card();
	//上传用
	private File upload;
	private String uploadFileName;
	private String uploadContentType;
	
	public File getUpload() {
		return upload;
	}
	public void setUpload(File upload) {
		this.upload = upload;
	}
	public String getUploadFileName() {
		return uploadFileName;
	}
	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}
	public String getUploadContentType() {
		return uploadContentType;
	}
	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}
	public Card getCard() {
		return card;
	}
	public void setCard(Card card) {
		this.card = card;
	}
	
	public void select() throws Exception{
		card.setDyid(new String(card.getDyid().getBytes("ISO-8859-1"),"UTF-8"));
		System.out.println(card.getDyid()+"===========================");
		Card c = cardService.getCard(card);
		if(c != null){
			InputStream is = null;
			try {
				File sourcefile = new File(c.getWjdz());
				is = new FileInputStream(sourcefile);
				//判断卡片是word还是excel格式
				String[] url = c.getWjdz().split("\\\\");
				String fileName = url[url.length-1];			//文件名
				String ex = fileName.split("\\.")[fileName.split("\\.").length-1];			//扩展名
				switch(ex){
				case "doc":
					String s = UUID.randomUUID().toString();
					c.setHtml(Word2Html.convert2Html(is, s + ".html"));
					break;
				case "xls":
					c.setHtml(ExcelToHtml.getHtml(is));
					break;
				}
				c.setUserName(getUser().getUsername());
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
				try {
					is.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}else{
			c = new Card();
			c.setUserName(getUser().getUsername());
		}
		JsonUtils.write(c, this.getResponse().getWriter());
	}
	
	public void upload() throws Exception{
		//我也不知道为什么要转2次，要不然就是乱码。。。。。
		System.out.println(card.getDyid()+"===========before=================");
		card.setDyid(new String(card.getDyid().getBytes("ISO-8859-1"),"UTF-8"));
		System.out.println(card.getDyid()+"===========middle=================");
//		card.setDyid(new String(card.getDyid().getBytes("ISO-8859-1"),"UTF-8"));
//		System.out.println(card.getDyid()+"===========after=================");
		//上传文件到服务器
		FileInputStream in = new FileInputStream(upload);
		SimpleDateFormat sdf = new SimpleDateFormat("yyMMddHHmmssSSS");
		String date = sdf.format(new Date());
		String uploadName = date+uploadFileName;
		String uri = ServletActionContext.getRequest().getRealPath("/upload")+"\\"+uploadName;
		card.setWjdz(uri);
		System.out.println(uri+"============================================");
		
		System.out.println(uri.split("\\\\").length);
		
		
		FileOutputStream out = new FileOutputStream(uri);
//		System.out.println("000000000000000");
		byte[] buf = new byte[1024];
		for(int readNum;(readNum = in.read(buf))!=-1;)
			out.write(buf, 0, readNum);
		out.close();
		in.close();
		Card c = new Card();
		//若kpid为空则添加
		if(card.getKpid() == -1){
			//添加卡片信息
			cardService.addCard(card);
			//获取卡片信息
			c = cardService.getCard(card);
		}else{
			cardService.updateCard(card);
			c = card;
		}
		//excel转换成html
		InputStream is = null;
		try {
			File sourcefile = new File(c.getWjdz());
			is = new FileInputStream(sourcefile);
			
			//判断卡片是word还是excel格式
			String[] url = c.getWjdz().split("\\\\");
			String fileName = url[url.length-1];			//文件名
			String ex = fileName.split("\\.")[fileName.split("\\.").length-1];			//扩展名
			switch(ex){
			case "doc":
				String s = UUID.randomUUID().toString();
				c.setHtml(Word2Html.convert2Html(is, s + ".html"));
				break;
			case "xls":
				c.setHtml(ExcelToHtml.getHtml(is));
				break;
			}
			
//			c.setHtml(ExcelToHtml.getHtml(is));
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		JsonUtils.write(c, this.getResponse().getWriter());
	}
	
	public void uploadFile() throws Exception{
		FileInputStream in = new FileInputStream(upload);
		SimpleDateFormat sdf = new SimpleDateFormat("yyMMddHHmmssSSS");
		String date = sdf.format(new Date());
		String uploadName = date+uploadFileName;
		String uri = ServletActionContext.getRequest().getRealPath("/wxjl")+"\\"+uploadName;
		FileOutputStream out = new FileOutputStream(uri);
		byte[] buf = new byte[1024];
		for(int readNum;(readNum = in.read(buf))!=-1;)
			out.write(buf, 0, readNum);
		out.close();
		in.close();
		
		Attachment a = new Attachment();
		a.setName(uploadFileName);
		a.setWz(uri);
		
		JsonUtils.write(a, this.getResponse().getWriter());
	}
	
	
	public void uploadTp() throws Exception{
		FileInputStream in = new FileInputStream(upload);
		SimpleDateFormat sdf = new SimpleDateFormat("yyMMddHHmmssSSS");
		String date = sdf.format(new Date());
		String uploadName = date+uploadFileName;
		String uri = ServletActionContext.getRequest().getRealPath("/qhjc")+"\\"+uploadName;
		FileOutputStream out = new FileOutputStream(uri);
		byte[] buf = new byte[1024];
		for(int readNum;(readNum = in.read(buf))!=-1;)
			out.write(buf, 0, readNum);
		out.close();
		in.close();
		
		Attachment a = new Attachment();
		a.setName(uploadFileName);
		a.setWz(uri);
		
		JsonUtils.write(a, this.getResponse().getWriter());
	}
	
	
	
	
	
	@Override
	public Card getModel() {
		return card;
	}
	@Override
	protected void prepareModel() throws Exception {
		// TODO Auto-generated method stub
		
	}

}
