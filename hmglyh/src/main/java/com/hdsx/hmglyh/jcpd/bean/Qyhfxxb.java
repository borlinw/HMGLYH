
 /**
 * 北京恒达时讯科技有限公司版权所有
 * Copyright (C) HDSX Corporation. All Rights Reserved
 */
package com.hdsx.hmglyh.jcpd.bean;

import java.io.Serializable;

/**  
 *  
 * @author Baiyy
 * @created 2015年7月3日 下午4:02:49 
 */

public class Qyhfxxb implements Serializable {
	private static final long serialVersionUID = -3609216833828801754L;
	
	private String id;				//区域id
	private String lxCode;			//路线编码
	private double szhh;			//起点桩号
	private double ezhh;			//止点桩号
	private String bmCode;			//部门编码
	private String bmName;
	private int bbid;				//版本id
	private String yxys;
	private String dj;
	
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getYxys() {
		return yxys;
	}
	public void setYxys(String yxys) {
		this.yxys = yxys;
	}
	public String getDj() {
		return dj;
	}
	public void setDj(String dj) {
		this.dj = dj;
	}
	public String getBmName() {
		return bmName;
	}
	public void setBmName(String bmName) {
		this.bmName = bmName;
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
}
