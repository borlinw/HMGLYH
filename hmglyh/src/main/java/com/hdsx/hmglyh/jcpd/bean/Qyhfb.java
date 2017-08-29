
 /**
 * 北京恒达时讯科技有限公司版权所有
 * Copyright (C) HDSX Corporation. All Rights Reserved
 */
package com.hdsx.hmglyh.jcpd.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**  
 *  
 * @author Baiyy
 * @created 2015年7月3日 下午4:02:49 
 */

public class Qyhfb implements Serializable {
	private static final long serialVersionUID = -3609216833828801754L;
	
	private int qyid;				//区域id
	private String qyName;			//区域名
	private String lxCode;			//路线编码
	private double szhh;			//起点桩号
	private double ezhh;			//止点桩号
	private int cd;					//长度
	private String bmCode;			//部门编码
	private String bmName;
	private int bbid;				//版本id
	private String jsdj;			//技术等级
	private String description;		//描述区域划分的路段技术等级情况
	private int rn;					//序号
	private String page;
	private String rows;
	private String qybbid;			//沿用之前数据时，用于存储需要copy的数据的版本id
	
	private List<Qdhfb> qdhfList = new ArrayList<Qdhfb>();
	private int colspan;
	
	private List<Qyhfxxb> zrqh = new ArrayList<Qyhfxxb>();
	private List<Qyhfxxb> glgn = new ArrayList<Qyhfxxb>();
	private List<Qyhfxxb> jtl = new ArrayList<Qyhfxxb>();
	private List<Qyhfxxb> jtzc = new ArrayList<Qyhfxxb>();
	private List<Qyhfxxb> cyqk = new ArrayList<Qyhfxxb>();;
	private List<Qyhfxxb> qt = new ArrayList<Qyhfxxb>();
	
	private List<Qyhfxxb> details = new ArrayList<Qyhfxxb>();
	
	
	
	public List<Qyhfxxb> getDetails() {
		return details;
	}
	public void setDetails(List<Qyhfxxb> details) {
		this.details = details;
	}
	public List<Qyhfxxb> getZrqh() {
		return zrqh;
	}
	public void setZrqh(List<Qyhfxxb> zrqh) {
		this.zrqh = zrqh;
	}
	public List<Qyhfxxb> getGlgn() {
		return glgn;
	}
	public void setGlgn(List<Qyhfxxb> glgn) {
		this.glgn = glgn;
	}
	public List<Qyhfxxb> getJtl() {
		return jtl;
	}
	public void setJtl(List<Qyhfxxb> jtl) {
		this.jtl = jtl;
	}
	public List<Qyhfxxb> getJtzc() {
		return jtzc;
	}
	public void setJtzc(List<Qyhfxxb> jtzc) {
		this.jtzc = jtzc;
	}
	public List<Qyhfxxb> getCyqk() {
		return cyqk;
	}
	public void setCyqk(List<Qyhfxxb> cyqk) {
		this.cyqk = cyqk;
	}
	public List<Qyhfxxb> getQt() {
		return qt;
	}
	public void setQt(List<Qyhfxxb> qt) {
		this.qt = qt;
	}
	private boolean isgs;
	
	public boolean isIsgs() {
		return isgs;
	}
	public void setIsgs(boolean isgs) {
		this.isgs = isgs;
	}
	public String getQybbid() {
		return qybbid;
	}
	public void setQybbid(String qybbid) {
		this.qybbid = qybbid;
	}
	public int getColspan() {
		return colspan;
	}
	public void setColspan(int colspan) {
		this.colspan = colspan;
	}
	public List<Qdhfb> getQdhfList() {
		return qdhfList;
	}
	public void setQdhfList(List<Qdhfb> qdhfList) {
		this.qdhfList = qdhfList;
	}
	public String getBmName() {
		return bmName;
	}
	public void setBmName(String bmName) {
		this.bmName = bmName;
	}
	public int getRn() {
		return rn;
	}
	public void setRn(int rn) {
		this.rn = rn;
	}
	public String getJsdj() {
		return jsdj;
	}
	public void setJsdj(String jsdj) {
		this.jsdj = jsdj;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getQyName() {
		return qyName;
	}
	public void setQyName(String qyName) {
		this.qyName = qyName;
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
	public int getQyid() {
		return qyid;
	}
	public void setQyid(int qyid) {
		this.qyid = qyid;
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
	public int getCd() {
		return cd;
	}
	public void setCd(int cd) {
		this.cd = cd;
	}
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
	@Override
	public String toString() {
		return "Qyhfb [qyid=" + qyid + ", qyName=" + qyName + ", lxCode="
				+ lxCode + ", szhh=" + szhh + ", ezhh=" + ezhh + ", cd=" + cd
				+ ", bmCode=" + bmCode + ", bbid=" + bbid + ", jsdj=" + jsdj
				+ ", description=" + description + ", rn=" + rn + "]";
	}
	
}
