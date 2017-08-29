/**
 * 北京恒达时讯科技有限公司版权所有
 * Copyright (C) Hdsx Corporation. All Rights Reserved
 */
package com.hdsx.hmglyh.login.bean;

import java.io.Serializable;
import java.util.List;

/**  
 *  用户登录
 * @author LiRui
 * @created 2015年6月8日 上午9:37:57 
 */

public class LoginUser implements Serializable {

	private static final long serialVersionUID = -6163778662014134768L;

	//用户表（HTGL_YHB）
	private String username;	//用户名
	private String pw;				//密码
	private String newpw;			//新密码（修改密码使用）
	private int ryid;					//人员id：10000起，自增
	private int jsid;					//角色id
	private int qyzt;					//启用状态
	//人员表（HTGL_RYB）
	private String ryname;		//人员姓名
	private String bmcode;		//所属部门编码
	private String zw;				//职位
	//部门表（HTGL_BMB）
	private String bmzscode;	//部门编码（显示用，真实编码）
	private String bmname;		//部门名称
	private String fzr;				//部门负责人
	private String bmlx;			//部门类型
	//权限code（前台权限控制）
	private List<String> indexrole;
	
	private Role role;  // 角色
	private String roleStr;
	private String htglRoleStr;

	@Override
	public String toString() {
		return "LoginUser [username=" + username + ", pw=" + pw + ", ryid="
				+ ryid + ", jsid=" + jsid + ", qyzt=" + qyzt + ", ryname="
				+ ryname + ", bmcode=" + bmcode + ", zw=" + zw + ", bmzscode="
				+ bmzscode + ", bmname=" + bmname + ", fzr=" + fzr + ", bmlx="
				+ bmlx + ", indexrole=" + indexrole + "]";
	}

	public Role getRole() {
		return role;
	}
	public String getRoleStr() {
		return roleStr;
	}
	public void setRoleStr(String roleStr) {
		this.roleStr = roleStr;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public String getHtglRoleStr() {
		return htglRoleStr;
	}
	public void setHtglRoleStr(String htglRoleStr) {
		this.htglRoleStr = htglRoleStr;
	}
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
	public String getZw() {
		return zw;
	}
	public void setZw(String zw) {
		this.zw = zw;
	}
	public String getBmzscode() {
		return bmzscode;
	}
	public void setBmzscode(String bmzscode) {
		this.bmzscode = bmzscode;
	}
	public String getBmname() {
		return bmname;
	}
	public void setBmname(String bmname) {
		this.bmname = bmname;
	}
	public String getFzr() {
		return fzr;
	}
	public void setFzr(String fzr) {
		this.fzr = fzr;
	}
	public List<String> getIndexrole() {
		return indexrole;
	}
	public void setIndexrole(List<String> indexrole) {
		this.indexrole = indexrole;
	}
	public String getBmlx() {
		return bmlx;
	}
	public void setBmlx(String bmlx) {
		this.bmlx = bmlx;
	}
	public String getNewpw() {
		return newpw;
	}
	public void setNewpw(String newpw) {
		this.newpw = newpw;
	}

}
