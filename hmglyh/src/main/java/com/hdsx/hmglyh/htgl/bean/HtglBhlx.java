/**
 * 北京恒达时讯科技有限公司版权所有
 * Copyright (C) Hdsx Corporation. All Rights Reserved
 */
package com.hdsx.hmglyh.htgl.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**  
 *  后台管理 - 病害类型表
 * @author LiRui
 * @created 2015年5月28日 上午9:41:04 
 */

public class HtglBhlx implements Serializable {

	private static final long serialVersionUID = -3300008112309317709L;

	private String bhid;		//病害ID（主键）
	private String bhname;	//病害名称
	private String dw;			//单位
	private String bhms;		//病害描述
	private double wxsx;		//维修时限
	private int qyzt;				//启用状态
	private int px;					//排序
	private String page;		//分页页数（分页）
	private String rows;		//每页显示行数（分页）
	private List<HtglBhlx> children = new ArrayList<HtglBhlx>();//用于创建病害Tree
	private int length;			//记录病害ID（bhid）的长度，用于创建病害Tree
	private String qyztStr;	//启用状态（a=启用；b=禁用），作为查询条件使用
	private int childNum;		//其下子节点的数量（设置Grid中是否能被删除）

	//构造方法
	public HtglBhlx() {
		super();
	}
	//构造方法
	public HtglBhlx(String bhid, String bhname) {
		super();
		this.bhid = bhid;
		this.bhname = bhname;
	}
	//构造方法
	public HtglBhlx(String bhid, String bhname, int qyzt) {
		super();
		this.bhid = bhid;
		this.bhname = bhname;
		this.qyzt = qyzt;
	}
	public String getBhid() {
		return bhid;
	}
	public void setBhid(String bhid) {
		this.bhid = bhid;
	}
	public String getBhname() {
		return bhname;
	}
	public void setBhname(String bhname) {
		this.bhname = bhname;
	}
	public String getDw() {
		return dw;
	}
	public void setDw(String dw) {
		this.dw = dw;
	}
	public String getBhms() {
		return bhms;
	}
	public void setBhms(String bhms) {
		this.bhms = bhms;
	}
	public double getWxsx() {
		return wxsx;
	}
	public void setWxsx(double wxsx) {
		this.wxsx = wxsx;
	}
	public int getQyzt() {
		return qyzt;
	}
	public void setQyzt(int qyzt) {
		this.qyzt = qyzt;
	}
	public int getPx() {
		return px;
	}
	public void setPx(int px) {
		this.px = px;
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
	public List<HtglBhlx> getChildren() {
		return children;
	}
	public void setChildren(List<HtglBhlx> children) {
		this.children = children;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public String getQyztStr() {
		return qyztStr;
	}
	public void setQyztStr(String qyztStr) {
		this.qyztStr = qyztStr;
	}
	public int getChildNum() {
		return childNum;
	}
	public void setChildNum(int childNum) {
		this.childNum = childNum;
	}

}
