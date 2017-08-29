/**
 * 北京恒达时讯科技有限公司版权所有
 * Copyright (C) HDSX Corporation. All Rights Reserved
 */
package com.hdsx.hmglyh.basicData.bean;

import java.io.Serializable;

/**  
 *  
 * @author Baiyy
 * @created 2015年6月8日 上午10:11:36 
 */

public class Lxld implements Serializable {
	private static final long serialVersionUID = 6185484814885536413L;
	
	private String id;			//路线下拉树的id
	private String text;		//路线下拉树的text
	private double szhh;		//起点桩号
	private double ezhh;		//止点桩号
	private String lxCode;		//路线名称
	private String bmCode;		//管辖部门编码
	private String bmlx;		//部门类型
	
	public String getBmlx() {
		return bmlx;
	}
	public void setBmlx(String bmlx) {
		this.bmlx = bmlx;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public double getSzhh() {
		return szhh;
	}
	public void setSzhh(double szhh) {
		this.szhh = szhh;
	}
	public double getEzhh() {
		return ezhh;
	}
	public void setEzhh(double ezhh) {
		this.ezhh = ezhh;
	}
	public String getLxCode() {
		return lxCode;
	}
	public void setLxCode(String lxCode) {
		this.lxCode = lxCode;
	}
	public String getBmCode() {
		return bmCode;
	}
	public void setBmCode(String bmCode) {
		this.bmCode = bmCode;
	}
	
}
