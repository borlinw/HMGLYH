package com.hdsx.hmglyh.htgl.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**  
 *  后台管理 - 角色 - 实体
 * @author LiRui
 * @created 2015年6月11日 上午9:53:26 
 */

public class HtglJs implements Serializable {

	private static final long serialVersionUID = 5085190369358874211L;

	//角色表
	private int jsid;				//角色ID
	private String jsname;	//角色名称
	private String jsms;		//角色描述
	//角色页面对应表
	private String mkid;				//角色模块对应表ID
	//页面（模块）表
	private String mkname;	//模块名称
	private String mkms;		//模块描述
	private String url;			//木料地址
	//其他
	private int jsmkNum;		//角色下管辖模块的数量
	private String jsmkStr;	//某角色对应的模块ID（mkid,mkid,mkid）
	private String queryTypeOfYh;	//“用户”模块请求的类型（有无“全部”）
	private int childNum;		//角色下的用户数量（用于限制删除）
	//页面查询
	private String page;		//分页页数（分页）
	private String rows;		//每页显示行数（分页）
	//Tree
	private List<HtglJs> children = new ArrayList<HtglJs>();//用户创建页面树

	//构造函数
	public HtglJs() {
		super();
	}
	//构造函数
	public HtglJs(int jsid, String mkid) {
		super();
		this.jsid = jsid;
		this.mkid = mkid;
	}

	public int getJsid() {
		return jsid;
	}
	public void setJsid(int jsid) {
		this.jsid = jsid;
	}
	public String getJsname() {
		return jsname;
	}
	public void setJsname(String jsname) {
		this.jsname = jsname;
	}
	public String getJsms() {
		return jsms;
	}
	public void setJsms(String jsms) {
		this.jsms = jsms;
	}
	public String getMkid() {
		return mkid;
	}
	public void setMkid(String mkid) {
		this.mkid = mkid;
	}
	public String getMkname() {
		return mkname;
	}
	public void setMkname(String mkname) {
		this.mkname = mkname;
	}
	public String getMkms() {
		return mkms;
	}
	public void setMkms(String mkms) {
		this.mkms = mkms;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
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
	public String getJsmkStr() {
		return jsmkStr;
	}
	public void setJsmkStr(String jsmkStr) {
		this.jsmkStr = jsmkStr;
	}
	public int getJsmkNum() {
		return jsmkNum;
	}
	public void setJsmkNum(int jsmkNum) {
		this.jsmkNum = jsmkNum;
	}
	public String getQueryTypeOfYh() {
		return queryTypeOfYh;
	}
	public void setQueryTypeOfYh(String queryTypeOfYh) {
		this.queryTypeOfYh = queryTypeOfYh;
	}
	public List<HtglJs> getChildren() {
		return children;
	}
	public void setChildren(List<HtglJs> children) {
		this.children = children;
	}
	public int getChildNum() {
		return childNum;
	}
	public void setChildNum(int childNum) {
		this.childNum = childNum;
	}

}
