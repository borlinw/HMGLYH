/**
 * 北京恒达时讯科技有限公司版权所有
 * Copyright (C) Hdsx Corporation. All Rights Reserved
 */
package com.hdsx.hmglyh.htgl.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**  
 *  后台管理 - 路段表（路线表+路段表）
 * @author LiRui
 * @created 2015年6月9日 下午6:25:24 
 */

public class HtglLdb implements Serializable {

	private static final long serialVersionUID = -302209821018813961L;

	//Htgl_ldb（路段表：业务路段表）Htgl_lxb（路线表：基础路线表）
	private String ldcode;	//路段编码（0101...）
	private String ldname;	//路段名称
	private String lxcode;	//路线编码（共用）
	private String lxname;	//路线名称
	private double szhh;		//起点桩号（共用）
	private double ezhh;		//止点桩号（共用）
	private double mileage;	//公里数（共用）
	private String bmcode;	//所属部门编码
	private String bmname;	//所属部门名称
	private String bz;			//备注
	private int childNum;		//其下子节点的数量（不确定是否有上下级关系）
	private int bmlx;				//部门类型（或许会用上）
	private String page;		//分页页数（分页）
	private String rows;		//每页显示行数（分页）
	private String lxQueryType;	//查询类型（影响路线下拉框是否有“全部”）
	private List<HtglLdb> children = new ArrayList<HtglLdb>();//孩子节点，用于创建路线Tree

	public String getLdcode() {
		return ldcode;
	}
	public void setLdcode(String ldcode) {
		this.ldcode = ldcode;
	}
	public String getLdname() {
		return ldname;
	}
	public void setLdname(String ldname) {
		this.ldname = ldname;
	}
	public String getLxcode() {
		return lxcode;
	}
	public void setLxcode(String lxcode) {
		this.lxcode = lxcode;
	}
	public String getLxname() {
		return lxname;
	}
	public void setLxname(String lxname) {
		this.lxname = lxname;
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
	public double getMileage() {
		return mileage;
	}
	public void setMileage(double mileage) {
		this.mileage = mileage;
	}
	public String getBmcode() {
		return bmcode;
	}
	public void setBmcode(String bmcode) {
		this.bmcode = bmcode;
	}
	public String getBz() {
		return bz;
	}
	public void setBz(String bz) {
		this.bz = bz;
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
	public List<HtglLdb> getChildren() {
		return children;
	}
	public void setChildren(List<HtglLdb> children) {
		this.children = children;
	}
	public String getBmname() {
		return bmname;
	}
	public void setBmname(String bmname) {
		this.bmname = bmname;
	}
	public int getChildNum() {
		return childNum;
	}
	public void setChildNum(int childNum) {
		this.childNum = childNum;
	}
	public String getLxQueryType() {
		return lxQueryType;
	}
	public void setLxQueryType(String lxQueryType) {
		this.lxQueryType = lxQueryType;
	}
	public int getBmlx() {
		return bmlx;
	}
	public void setBmlx(int bmlx) {
		this.bmlx = bmlx;
	}

}
