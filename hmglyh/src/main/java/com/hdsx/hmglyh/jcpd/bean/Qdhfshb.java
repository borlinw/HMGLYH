
 /**
 * 北京恒达时讯科技有限公司版权所有
 * Copyright (C) HDSX Corporation. All Rights Reserved
 */
package com.hdsx.hmglyh.jcpd.bean;

import java.io.Serializable;
import java.util.Date;

/**  
 *  
 * @author Baiyy
 * @created 2015年8月7日 下午1:54:23 
 */

public class Qdhfshb implements Serializable {
	private static final long serialVersionUID = 2253658178282320478L;
	
	private String bmCode1;		//区段划分表获取的部门编码
	private int bbid1;			//区段划分表获取的版本id
	private String bbname;
	private String bmCode;		//部门编码
	private String bmName;
	private int bbid;			//版本id
	private boolean sqzt;		//申请状态
	private String sqr;			//申请人
	private Date sqsj;			//申请时间
	private int shzt;			//申请状态
	private String shr;			//审核人
	private String shry;			//审核人
	private Date shsj;			//审核时间
	private int qmbbid;
	private String page;		
	private String rows;
	
	public int getQmbbid() {
		return qmbbid;
	}
	public void setQmbbid(int qmbbid) {
		this.qmbbid = qmbbid;
	}
	public String getBbname() {
		return bbname;
	}
	public void setBbname(String bbname) {
		this.bbname = bbname;
	}
	public String getBmName() {
		return bmName;
	}
	public void setBmName(String bmName) {
		this.bmName = bmName;
	}
	public String getShry() {
		return shry;
	}
	public void setShry(String shry) {
		this.shry = shry;
	}
	public String getBmCode1() {
		return bmCode1;
	}
	public void setBmCode1(String bmCode1) {
		this.bmCode1 = bmCode1;
	}
	public int getBbid1() {
		return bbid1;
	}
	public void setBbid1(int bbid1) {
		this.bbid1 = bbid1;
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
	public boolean isSqzt() {
		return sqzt;
	}
	public void setSqzt(boolean sqzt) {
		this.sqzt = sqzt;
	}
	public String getSqr() {
		return sqr;
	}
	public void setSqr(String sqr) {
		this.sqr = sqr;
	}
	public Date getSqsj() {
		return sqsj;
	}
	public void setSqsj(Date sqsj) {
		this.sqsj = sqsj;
	}
	public int getShzt() {
		return shzt;
	}
	public void setShzt(int shzt) {
		this.shzt = shzt;
	}
	public String getShr() {
		return shr;
	}
	public void setShr(String shr) {
		this.shr = shr;
	}
	public Date getShsj() {
		return shsj;
	}
	public void setShsj(Date shsj) {
		this.shsj = shsj;
	}
	
	

}
