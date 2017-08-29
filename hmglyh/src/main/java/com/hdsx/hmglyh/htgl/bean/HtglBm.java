package com.hdsx.hmglyh.htgl.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**  
 *  后台管理 - 部门管理
 * @author LiRui
 * @created 2015年6月4日 下午4:59:30 
 */

public class HtglBm implements Serializable {

	private static final long serialVersionUID = -797948995277789987L;

	private String bmcode;		//部门编码（主键）
	private String bmzscode;	//部门编码
	private String bmname;		//部门名称
	private String fzr;				//负责人
	private String lxdh;			//联系电话
	private String bmms;			//部门描述
	private String bmlx;			//部门类型
	private String bmlxStr;		//部门类型名称（关联枚举表）
	private int qyzt;					//启用状态
	private String page;		//分页页数（分页）
	private String rows;		//每页显示行数（分页）
	private List<HtglBm> children = new ArrayList<HtglBm>();//子节点，用于创建部门树
	private int childNum;		//其下子节点的数量（设置Grid中是否能被删除）

	//构造函数
	public HtglBm() {
		super();
	}
	//构造函数
	public HtglBm(String bmcode, String bmname, int qyzt) {
		super();
		this.bmcode = bmcode;
		this.bmname = bmname;
		this.qyzt = qyzt;
	}

	public String getBmcode() {
		return bmcode;
	}
	public void setBmcode(String bmcode) {
		this.bmcode = bmcode;
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
	public String getLxdh() {
		return lxdh;
	}
	public void setLxdh(String lxdh) {
		this.lxdh = lxdh;
	}
	public String getBmms() {
		return bmms;
	}
	public void setBmms(String bmms) {
		this.bmms = bmms;
	}
	public String getBmlx() {
		return bmlx;
	}
	public void setBmlx(String bmlx) {
		this.bmlx = bmlx;
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
	public List<HtglBm> getChildren() {
		return children;
	}
	public void setChildren(List<HtglBm> children) {
		this.children = children;
	}
	public int getChildNum() {
		return childNum;
	}
	public void setChildNum(int childNum) {
		this.childNum = childNum;
	}
	public String getBmlxStr() {
		return bmlxStr;
	}
	public void setBmlxStr(String bmlxStr) {
		this.bmlxStr = bmlxStr;
	}

}
