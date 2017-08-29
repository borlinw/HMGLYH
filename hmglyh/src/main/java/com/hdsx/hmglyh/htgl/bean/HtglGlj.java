/**
 * 北京恒达时讯科技有限公司版权所有
 * Copyright (C) Hdsx Corporation. All Rights Reserved
 */
package com.hdsx.hmglyh.htgl.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**  
 *  工料机（工料机类型表+工料机价格表）
 * @author LiRui
 * @created 2015年6月4日 下午1:19:03 
 */

public class HtglGlj implements Serializable {

	private static final long serialVersionUID = -8155215312831384387L;

	//两表通用
	private String lxid;			//类型id（010101，人工 01，材料02，机械03）
	//工料机类型表
	private String lxname;	//类型名称
	private String gg;			//规格
	private String dw;			//单位
	private String bz;			//备注
	private int px;					//排序
	private int qyzt;				//启用状态
	private String bm;			//编码/号（新加）
	//工料机价格表
	private double dj;			//单价
	private String bmcode;	//部门编码
	//Grid查询显示
	private String page;		//分页页数（分页）
	private String rows;		//每页显示行数（分页）
	private int childNum;		//某节点下的子节点的数量（用于判断能不能“删除”）
	private List<HtglGlj> children = new ArrayList<HtglGlj>();//用于创建“工料机”Tree

	//构造函数
	public HtglGlj() {
		super();
	}
	//构造函数
	public HtglGlj(String lxid, String lxname) {
		super();
		this.lxid = lxid;
		this.lxname = lxname;
	}
	//构造函数
	public HtglGlj(String lxid, String lxname, int qyzt) {
		super();
		this.lxid = lxid;
		this.lxname = lxname;
		this.qyzt = qyzt;
	}
	public HtglGlj(String lxid, String bmcode, String bz) {
		super();
		this.lxid = lxid;
		this.bmcode = bmcode;
		this.bz = bz;
	}
	public String getLxid() {
		return lxid;
	}
	public void setLxid(String lxid) {
		this.lxid = lxid;
	}
	public String getLxname() {
		return lxname;
	}
	public void setLxname(String lxname) {
		this.lxname = lxname;
	}
	public String getGg() {
		return gg;
	}
	public void setGg(String gg) {
		this.gg = gg;
	}
	public String getDw() {
		return dw;
	}
	public void setDw(String dw) {
		this.dw = dw;
	}
	public String getBz() {
		return bz;
	}
	public void setBz(String bz) {
		this.bz = bz;
	}
	public int getPx() {
		return px;
	}
	public void setPx(int px) {
		this.px = px;
	}
	public int getQyzt() {
		return qyzt;
	}
	public void setQyzt(int qyzt) {
		this.qyzt = qyzt;
	}
	public double getDj() {
		return dj;
	}
	public void setDj(double dj) {
		this.dj = dj;
	}
	public String getBmcode() {
		return bmcode;
	}
	public void setBmcode(String bmcode) {
		this.bmcode = bmcode;
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
	public List<HtglGlj> getChildren() {
		return children;
	}
	public void setChildren(List<HtglGlj> children) {
		this.children = children;
	}
	public int getChildNum() {
		return childNum;
	}
	public void setChildNum(int childNum) {
		this.childNum = childNum;
	}
	public String getBm() {
		return bm;
	}
	public void setBm(String bm) {
		this.bm = bm;
	}

}
