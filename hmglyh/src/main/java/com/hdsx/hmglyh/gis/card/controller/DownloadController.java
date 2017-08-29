/**
 * 北京恒达时讯科技有限公司版权所有
 * Copyright (C) HDSX Corporation. All Rights Reserved
 */
package com.hdsx.hmglyh.gis.card.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.hdsx.hmglyh.base.BaseActionSupport;
import com.hdsx.hmglyh.jcpd.bean.Qdhfshb;

/**
 * 
 * @author Baiyy
 * @version 2013年12月20日 下午1:36:12
 */
@Controller
@Scope(value="request")
public class DownloadController extends BaseActionSupport<Qdhfshb>{
	private static final long serialVersionUID = 1993315044194475374L;
	private String fileName;
	private String filePath;
	public String getFileName(){
		try {
			return new String(fileName.getBytes(),"ISO-8859-1");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return null;
		}
	}
	public void setFileName(String fileName) {
		try {
			fileName = new String(fileName.getBytes("ISO-8859-1"),"UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} 
		this.fileName = fileName;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		try {
			filePath = new String(filePath.getBytes("ISO-8859-1"),"UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} 
		this.filePath = filePath;
	}
	
	public InputStream getDownload(){
		System.out.println(filePath+"=======================================================================");
		try {
			return new FileInputStream(filePath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public String down(){
		return SUCCESS;
	}
	public String open(){
		return SUCCESS;
	}
	
	@Override
	protected void prepareModel() throws Exception {
		// TODO Auto-generated method stub
		
	}
}


















