package com.hdsx.hmglyh.htgl.bean;

import java.io.Serializable;

/**  
 *  后台管理 - 用户表 - 实体类
 * @author LiRui
 * @created 2015年6月11日 上午9:48:03 
 */

public class HtglYhb implements Serializable {

	private static final long serialVersionUID = -5982451449413309497L;

	private String username;	//用户名
	private String pw;				//密码
	private int ryid;					//所属人员ID
	private String ryname;		//人员姓名
	private String bmcode;		//人员所属部门编码
	private String bmname;		//人员所属部门名称
	private int jsid;					//所属角色ID
	private String jsname;		//角色名称
	private int qyzt;					//启用状态
	private String page;		//分页页数（分页）
	private String rows;		//每页显示行数（分页）

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public int getRyid() {
		return ryid;
	}
	public void setRyid(int ryid) {
		this.ryid = ryid;
	}
	public String getRyname() {
		return ryname;
	}
	public void setRyname(String ryname) {
		this.ryname = ryname;
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
	public int getJsid() {
		return jsid;
	}
	public void setJsid(int jsid) {
		this.jsid = jsid;
	}
	public int getQyzt() {
		return qyzt;
	}
	public void setQyzt(int qyzt) {
		this.qyzt = qyzt;
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
	public String getJsname() {
		return jsname;
	}
	public void setJsname(String jsname) {
		this.jsname = jsname;
	}

}
