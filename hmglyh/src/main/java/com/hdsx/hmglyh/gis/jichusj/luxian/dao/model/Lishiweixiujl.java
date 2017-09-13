
 /**
 * 北京恒达时讯科技有限公司版权所有
 * Copyright (C) HDSX Corporation. All Rights Reserved
 */
package com.hdsx.hmglyh.gis.jichusj.luxian.dao.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**  
 *  
 * @author Baiyy
 * @created 2016年6月15日 下午4:00:32 
 * 历史维修记录
 */

public class Lishiweixiujl {
	
	private String id;
	private String lx;
	private String roadcode;
	private String zh;
	private String qlcode;
	private String qlname;
	private String hdcode;
	private String wxlx;
	private String wxbw;
	private Date kgsj;
	private Date wgsj;
	private String sycl;
	private String wxgcl;
	private double wxje;
	
	private List<Attachment> yxzl = new ArrayList<Attachment>();
	private List<Attachment> hpgqk = new ArrayList<Attachment>();
	private List<Attachment> attachment = new ArrayList<Attachment>();
	
	private int page;
	private int rows;
	
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}
	public String getQlname() {
		return qlname;
	}
	public void setQlname(String qlname) {
		this.qlname = qlname;
	}
	public String getZh() {
		return zh;
	}
	public void setZh(String zh) {
		this.zh = zh;
	}
	public String getLx() {
		return lx;
	}
	public void setLx(String lx) {
		this.lx = lx;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getRoadcode() {
		return roadcode;
	}
	public void setRoadcode(String roadcode) {
		this.roadcode = roadcode;
	}
	public String getQlcode() {
		return qlcode;
	}
	public void setQlcode(String qlcode) {
		this.qlcode = qlcode;
	}
	public String getHdcode() {
		return hdcode;
	}
	public void setHdcode(String hdcode) {
		this.hdcode = hdcode;
	}
	public String getWxlx() {
		return wxlx;
	}
	public void setWxlx(String wxlx) {
		this.wxlx = wxlx;
	}
	public String getWxbw() {
		return wxbw;
	}
	public void setWxbw(String wxbw) {
		this.wxbw = wxbw;
	}
	public Date getKgsj() {
		return kgsj;
	}
	public void setKgsj(Date kgsj) {
		this.kgsj = kgsj;
	}
	public Date getWgsj() {
		return wgsj;
	}
	public void setWgsj(Date wgsj) {
		this.wgsj = wgsj;
	}
	public String getSycl() {
		return sycl;
	}
	public void setSycl(String sycl) {
		this.sycl = sycl;
	}
	public String getWxgcl() {
		return wxgcl;
	}
	public void setWxgcl(String wxgcl) {
		this.wxgcl = wxgcl;
	}
	public double getWxje() {
		return wxje;
	}
	public void setWxje(double wxje) {
		this.wxje = wxje;
	}
	public List<Attachment> getYxzl() {
		return yxzl;
	}
	public void setYxzl(List<Attachment> yxzl) {
		this.yxzl = yxzl;
	}
	public List<Attachment> getHpgqk() {
		return hpgqk;
	}
	public void setHpgqk(List<Attachment> hpgqk) {
		this.hpgqk = hpgqk;
	}
	public List<Attachment> getAttachment() {
		return attachment;
	}
	public void setAttachment(List<Attachment> attachment) {
		this.attachment = attachment;
	}
	@Override
	public String toString() {
		return "Lishiweixiujl [id=" + id + ", lx=" + lx + ", roadcode="
				+ roadcode + ", zh=" + zh + ", qlcode=" + qlcode + ", qlname="
				+ qlname + ", hdcode=" + hdcode + ", wxlx=" + wxlx + ", wxbw="
				+ wxbw + ", kgsj=" + kgsj + ", wgsj=" + wgsj + ", sycl=" + sycl
				+ ", wxgcl=" + wxgcl + ", wxje=" + wxje + "]";
	}
	
	
}











