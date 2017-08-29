/**
 * 北京恒达时讯科技有限公司版权所有
 * Copyright (C) HDSX Corporation. All Rights Reserved
 */
package com.hdsx.hmglyh.jcpd.bean;

import java.io.Serializable;
public class Lkldhfb implements Serializable {
	private static final long serialVersionUID = 7404373150944933878L;
	private int id;						//id
	private String roadcode;			//路线编码
	private double roadstart;			//起点桩号
	private double roadends;			//止点桩号
	private String jsdj;				//技术等级
	private double lmkd;				//路面宽度
	private String lmlx;				//路面类型（1沥青路面，2水泥路面，3砂石路面）
	private String lxname;				//路线名称
				
	
	public String getLxname() {
		return lxname;
	}
	public void setLxname(String lxname) {
		this.lxname = lxname;
	}
	private String rows;
	private String page;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRoadcode() {
		return roadcode;
	}
	public void setRoadcode(String roadcode) {
		this.roadcode = roadcode;
	}
	public double getRoadstart() {
		return roadstart;
	}
	public void setRoadstart(double roadstart) {
		this.roadstart = roadstart;
	}
	public double getRoadends() {
		return roadends;
	}
	public void setRoadends(double roadends) {
		this.roadends = roadends;
	}
	public String getJsdj() {
		return jsdj;
	}
	public void setJsdj(String jsdj) {
		this.jsdj = jsdj;
	}
	public double getLmkd() {
		return lmkd;
	}
	public void setLmkd(double lmkd) {
		this.lmkd = lmkd;
	}
	public String getLmlx() {
		return lmlx;
	}
	public void setLmlx(String lmlx) {
		this.lmlx = lmlx;
	}
	public String getRows() {
		return rows;
	}
	public void setRows(String rows) {
		this.rows = rows;
	}
	public String getPage() {
		return page;
	}
	public void setPage(String page) {
		this.page = page;
	}
	
}