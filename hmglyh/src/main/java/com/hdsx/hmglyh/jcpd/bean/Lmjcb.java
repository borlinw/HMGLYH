
 /**
 * 北京恒达时讯科技有限公司版权所有
 * Copyright (C) HDSX Corporation. All Rights Reserved
 */
package com.hdsx.hmglyh.jcpd.bean;

import java.io.Serializable;

/**  
 *  
 * @author Baiyy
 * @created 2015年6月25日 下午3:12:11 
 */

public class Lmjcb implements Serializable {

	private static final long serialVersionUID = -4371175244456941470L;
	
	private int ldid;			//路段id
	private String lxCode;		//路线编码
	private String qmName;		//千米路段
	private double szhh;		//起点桩号
	private double ezhh;		//止点桩号
	private String fx;			//方向枚举id
	private String fxName;		//方向
	private String page;		
	private String rows;		
	
	private String jcid;		//检测
	private int bbid;			//版本
	private String jclx;		//检测类型
	private int jcbbid;			//沿用之前路面检测数据用版本id
	//检查点1-10
	private double jcd1;
	private double jcd2;
	private double jcd3;
	private double jcd4;
	private double jcd5;
	private double jcd6;
	private double jcd7;
	private double jcd8;
	private double jcd9;
	private double jcd10;
	private double zhi;			//值
	private double pjz;			//平均值
	
	public int getJcbbid() {
		return jcbbid;
	}
	public void setJcbbid(int jcbbid) {
		this.jcbbid = jcbbid;
	}
	public String getFxName() {
		return fxName;
	}
	public void setFxName(String fxName) {
		this.fxName = fxName;
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
	public String getFx() {
		return fx;
	}
	public void setFx(String fx) {
		this.fx = fx;
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
	public String getQmName() {
		return qmName;
	}
	public void setQmName(String qmName) {
		this.qmName = qmName;
	}
	public int getLdid() {
		return ldid;
	}
	public void setLdid(int ldid) {
		this.ldid = ldid;
	}
	public String getJcid() {
		return jcid;
	}
	public void setJcid(String jcid) {
		this.jcid = jcid;
	}
	public int getBbid() {
		return bbid;
	}
	public void setBbid(int bbid) {
		this.bbid = bbid;
	}
	public String getJclx() {
		return jclx;
	}
	public void setJclx(String jclx) {
		this.jclx = jclx;
	}
	public double getJcd1() {
		return jcd1;
	}
	public void setJcd1(double jcd1) {
		this.jcd1 = jcd1;
	}
	public double getJcd2() {
		return jcd2;
	}
	public void setJcd2(double jcd2) {
		this.jcd2 = jcd2;
	}
	public double getJcd3() {
		return jcd3;
	}
	public void setJcd3(double jcd3) {
		this.jcd3 = jcd3;
	}
	public double getJcd4() {
		return jcd4;
	}
	public void setJcd4(double jcd4) {
		this.jcd4 = jcd4;
	}
	public double getJcd5() {
		return jcd5;
	}
	public void setJcd5(double jcd5) {
		this.jcd5 = jcd5;
	}
	public double getJcd6() {
		return jcd6;
	}
	public void setJcd6(double jcd6) {
		this.jcd6 = jcd6;
	}
	public double getJcd7() {
		return jcd7;
	}
	public void setJcd7(double jcd7) {
		this.jcd7 = jcd7;
	}
	public double getJcd8() {
		return jcd8;
	}
	public void setJcd8(double jcd8) {
		this.jcd8 = jcd8;
	}
	public double getJcd9() {
		return jcd9;
	}
	public void setJcd9(double jcd9) {
		this.jcd9 = jcd9;
	}
	public double getJcd10() {
		return jcd10;
	}
	public void setJcd10(double jcd10) {
		this.jcd10 = jcd10;
	}
	public double getZhi() {
		return zhi;
	}
	public void setZhi(double zhi) {
		this.zhi = zhi;
	}
	public double getPjz() {
		return pjz;
	}
	public void setPjz(double pjz) {
		this.pjz = pjz;
	}
	
}
