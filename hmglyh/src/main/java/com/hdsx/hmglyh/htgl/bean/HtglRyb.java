package com.hdsx.hmglyh.htgl.bean;

import java.io.Serializable;
import java.util.Date;

/**  
 *  后台管理 - 人员 - 实体
 * @author LiRui
 * @created 2015年6月10日 下午4:57:04 
 */

public class HtglRyb implements Serializable {

	private static final long serialVersionUID = -6146169148633511962L;

	private String ryid;		//人员ID
	private String username;//所属用户名
	private String ryname;	//人员姓名
	private int ryxb;				//人员性别
	private String bmcode;	//所属部门编码
	private String bmname;	//所属部门名称
	private String zw;			//职位
	private String lxdh;		//联系电话
	private String email;		//E-mail
	private String qq;			//QQ
	private Date rzsj;			//入职日期：2016-04-08新加
	private String year;		//年份，用于DataGrid的数据筛选
	private String page;		//分页页数（分页）
	private String rows;		//每页显示行数（分页）
	private String qyzt;		//启用状态

	public String getQyzt() {
		return qyzt;
	}
	public void setQyzt(String qyzt) {
		this.qyzt = qyzt;
	}
	public String getRyid() {
		return ryid;
	}
	public void setRyid(String ryid) {
		this.ryid = ryid;
	}
	public String getRyname() {
		return ryname;
	}
	public void setRyname(String ryname) {
		this.ryname = ryname;
	}
	public int getRyxb() {
		return ryxb;
	}
	public void setRyxb(int ryxb) {
		this.ryxb = ryxb;
	}
	public String getBmcode() {
		return bmcode;
	}
	public void setBmcode(String bmcode) {
		this.bmcode = bmcode;
	}
	public String getBmname() {
		return bmname;
	}
	public void setBmname(String bmname) {
		this.bmname = bmname;
	}
	public String getZw() {
		return zw;
	}
	public void setZw(String zw) {
		this.zw = zw;
	}
	public String getLxdh() {
		return lxdh;
	}
	public void setLxdh(String lxdh) {
		this.lxdh = lxdh;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
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
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Date getRzsj() {
		return rzsj;
	}
	public void setRzsj(Date rzsj) {
		this.rzsj = rzsj;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}

}
