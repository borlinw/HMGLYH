
 /**
 * 北京恒达时讯科技有限公司版权所有
 * Copyright (C) HDSX Corporation. All Rights Reserved
 */
package com.hdsx.hmglyh.gis.jichusj.yanxianss.dao.model;

import java.io.Serializable;

/**  
 *  
 * @author Baiyy
 * @created 2016年5月12日 下午2:43:24 
 */

public class LuMianbx implements Serializable {
	private static final long serialVersionUID = -7061944498380901850L;
	
	private String roadcode;
	private double spos;
	private double epos;
	private String szlx;
	private String xtlx;
	private String bxfslx;
	private String bxkd;
	private String bxmj;
	private String bxcl;
	private String gydw;
	private double ptx;
	private double pty;
	private double mptx;
	private double mpty;
	private String page;
	private String rows;
	private String wz;
	
	private String bmcode;
	private String szhh;
	private String ezhh;
	
	public String getWz() {
		return wz;
	}
	public void setWz(String wz) {
		this.wz = wz;
	}
	public String getSzhh() {
		return szhh;
	}
	public void setSzhh(String szhh) {
		this.szhh = szhh;
	}
	public String getEzhh() {
		return ezhh;
	}
	public void setEzhh(String ezhh) {
		this.ezhh = ezhh;
	}
	public String getBmcode() {
		return bmcode;
	}
	public void setBmcode(String bmcode) {
		this.bmcode = bmcode;
	}
	public String getRoadcode() {
		return roadcode;
	}
	public void setRoadcode(String roadcode) {
		this.roadcode = roadcode;
	}
	public double getSpos() {
		return spos;
	}
	public void setSpos(double spos) {
		this.spos = spos;
	}
	public double getEpos() {
		return epos;
	}
	public void setEpos(double epos) {
		this.epos = epos;
	}
	public String getSzlx() {
		return szlx;
	}
	public void setSzlx(String szlx) {
		this.szlx = szlx;
	}
	public String getXtlx() {
		return xtlx;
	}
	public void setXtlx(String xtlx) {
		this.xtlx = xtlx;
	}
	public String getBxfslx() {
		return bxfslx;
	}
	public void setBxfslx(String bxfslx) {
		this.bxfslx = bxfslx;
	}
	public String getBxkd() {
		return bxkd;
	}
	public void setBxkd(String bxkd) {
		this.bxkd = bxkd;
	}
	public String getBxmj() {
		return bxmj;
	}
	public void setBxmj(String bxmj) {
		this.bxmj = bxmj;
	}
	public String getBxcl() {
		return bxcl;
	}
	public void setBxcl(String bxcl) {
		this.bxcl = bxcl;
	}
	public String getGydw() {
		return gydw;
	}
	public void setGydw(String gydw) {
		this.gydw = gydw;
	}
	public double getPtx() {
		return ptx;
	}
	public void setPtx(double ptx) {
		this.ptx = ptx;
	}
	public double getPty() {
		return pty;
	}
	public void setPty(double pty) {
		this.pty = pty;
	}
	public double getMptx() {
		return mptx;
	}
	public void setMptx(double mptx) {
		this.mptx = mptx;
	}
	public double getMpty() {
		return mpty;
	}
	public void setMpty(double mpty) {
		this.mpty = mpty;
	}
	public String getPage() {
		return page;
	}
	public void setPage(String page) {
		this.page = page;
	}
	public String getRows() {
		return rows;
	}
	public void setRows(String rows) {
		this.rows = rows;
	}
	
	
}
