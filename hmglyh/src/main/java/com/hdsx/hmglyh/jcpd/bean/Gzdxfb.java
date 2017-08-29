
 /**
 * 北京恒达时讯科技有限公司版权所有
 * Copyright (C) HDSX Corporation. All Rights Reserved
 */
package com.hdsx.hmglyh.jcpd.bean;

import java.io.Serializable;

/**  
 *  
 * @author Baiyy
 * @created 2015年7月16日 下午3:38:31 
 */

public class Gzdxfb implements Serializable {
	private static final long serialVersionUID = 4948475806106740720L;
	
	private String gzid;		//工资id
	private int ryid;			//人员id
	private double cqgr;		//出勤工日
	private double bjts;		//病假天数
	private double sjts;		//事假天数
	private double kgts;		//旷工天数
	
	public String getGzid() {
		return gzid;
	}
	public void setGzid(String gzid) {
		this.gzid = gzid;
	}
	public int getRyid() {
		return ryid;
	}
	public void setRyid(int ryid) {
		this.ryid = ryid;
	}
	public double getCqgr() {
		return cqgr;
	}
	public void setCqgr(double cqgr) {
		this.cqgr = cqgr;
	}
	public double getBjts() {
		return bjts;
	}
	public void setBjts(double bjts) {
		this.bjts = bjts;
	}
	public double getSjts() {
		return sjts;
	}
	public void setSjts(double sjts) {
		this.sjts = sjts;
	}
	public double getKgts() {
		return kgts;
	}
	public void setKgts(double kgts) {
		this.kgts = kgts;
	}
	
	

}
