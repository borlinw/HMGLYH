/**
 * 北京恒达时讯科技有限公司版权所有
 * Copyright (C) HDSX Corporation. All Rights Reserved
 */
package com.hdsx.hmglyh.jcpd.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**  
 *  
 * @author Baiyy
 * @created 2015年5月27日 下午11:43:02 
 */

public class Bbkzb implements Serializable {

	private static final long serialVersionUID = -5761392951201122103L;
	
	private int bbid;		//版本编号
	private String bbmc;	//版本名称
	private Date bbsj;		//版本时间
	private String bblx;	//版本类型（路况调查 0201，路面检测 0202，路况评定 0203，千米路段划分 0204，区域区段划分 0205）
	private String zjczr;	//最近操作人
	private int qmbbid;		//对应的千米路段划分版本编码
	
	private List<Qdhfb> qdhfList = new ArrayList<Qdhfb>();		//区段划分用，查询已经划分好的区段
	
	private String page;
	private String rows;
	private int isUse;
	
	private String bmCode;
	private int issb;
	
	public String getBmCode() {
		return bmCode;
	}
	public void setBmCode(String bmCode) {
		this.bmCode = bmCode;
	}
	public int getIssb() {
		return issb;
	}
	public void setIssb(int issb) {
		this.issb = issb;
	}
	public List<Qdhfb> getQdhfList() {
		return qdhfList;
	}
	public void setQdhfList(List<Qdhfb> qdhfList) {
		this.qdhfList = qdhfList;
	}
	public int getIsUse() {
		return isUse;
	}
	public void setIsUse(int isUse) {
		this.isUse = isUse;
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
	public int getBbid() {
		return bbid;
	}
	public void setBbid(int bbid) {
		this.bbid = bbid;
	}
	public String getBbmc() {
		return bbmc;
	}
	public void setBbmc(String bbmc) {
		this.bbmc = bbmc;
	}
	public Date getBbsj() {
		return bbsj;
	}
	public void setBbsj(Date bbsj) {
		this.bbsj = bbsj;
	}
	public String getBblx() {
		return bblx;
	}
	public void setBblx(String bblx) {
		this.bblx = bblx;
	}
	public String getZjczr() {
		return zjczr;
	}
	public void setZjczr(String zjczr) {
		this.zjczr = zjczr;
	}
	public int getQmbbid() {
		return qmbbid;
	}
	public void setQmbbid(int qmbbid) {
		this.qmbbid = qmbbid;
	}
	
}
