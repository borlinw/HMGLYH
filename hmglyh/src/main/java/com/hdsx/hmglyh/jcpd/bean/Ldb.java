
 /**
 * 北京恒达时讯科技有限公司版权所有
 * Copyright (C) HDSX Corporation. All Rights Reserved
 */
package com.hdsx.hmglyh.jcpd.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**  
 *  区段划分导出用管辖路段
 * @author Baiyy
 * @created 2015年9月7日 下午2:59:38 
 */

public class Ldb implements Serializable {
	private static final long serialVersionUID = -2942690804750627859L;
	
	private String bmCode;				//管辖部门
	private int bbid;					//区域区段划分版本
	private String lxCode;				//路线编码
	private double szhh;				//起点桩号
	private double ezhh;				//止点桩号
	private List<Qyhfb> qyhf = new ArrayList<Qyhfb>();
	private int colspan;				
	
	public String getBmCode() {
		return bmCode;
	}
	public void setBmCode(String bmCode) {
		this.bmCode = bmCode;
	}
	public int getBbid() {
		return bbid;
	}
	public void setBbid(int bbid) {
		this.bbid = bbid;
	}
	public String getLxCode() {
		return lxCode;
	}
	public void setLxCode(String lxCode) {
		this.lxCode = lxCode;
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
	public List<Qyhfb> getQyhf() {
		return qyhf;
	}
	public void setQyhf(List<Qyhfb> qyhf) {
		this.qyhf = qyhf;
	}
	public int getColspan() {
		return colspan;
	}
	public void setColspan(int colspan) {
		this.colspan = colspan;
	}
	
}
