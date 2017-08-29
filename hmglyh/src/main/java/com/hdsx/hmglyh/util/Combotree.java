/**
 * 北京恒达时讯科技有限公司版权所有
 * Copyright (C) HDSX Corporation. All Rights Reserved
 */
package com.hdsx.hmglyh.util;

import java.util.ArrayList;
import java.util.List;

/**
 * 下拉树
 * @author LiRui
 * @version 2015年05月28日 上午10:44:09
 */
public class Combotree {

	/**
	 * ID
	 */
	private String id;

	/**
	 * 资源名称
	 */
	private String text;

	/**
	 * 是否展开，open或closed
	 */
	private String state = "open";

	/**
	 * 父节点ID
	 */
	private String pid;

	/**
	 * 子节点
	 */
	private List<Combotree> children = new ArrayList<Combotree>();
	/**
	 * 图标
	 */
	private String iconCls;

	/**
	 * 属性
	 */
	private Attributes attributes = new Attributes();
	//暂时只应用于添加人员时选择部门限制
	private int qyzt;					//启用状态
	//添加定额时的工料机的单位
	private String dw;				//单位
	private int childNum;		//某工料机节点下的子节点的数量（用于判断能不能被添加）

	public Combotree() {
		super();
	}

	public Combotree(String id, String text) {
		super();
		this.id = id;
		this.text = text;
	}

	public Combotree(String id, String text, Attributes attributes) {
		super();
		this.id = id;
		this.text = text;
		this.attributes = attributes;
	}

	public Combotree(String id, String text, String pid) {
		super();
		this.id = id;
		this.text = text;
		this.pid = pid;
	}

	public Combotree(String id, String text, String pid, Attributes attributes) {
		super();
		this.id = id;
		this.text = text;
		this.pid = pid;
		this.attributes = attributes;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public List<Combotree> getChildren() {
		return children;
	}
	public void setChildren(List<Combotree> children) {
		this.children = children;
	}
	public String getIconCls() {
		return iconCls;
	}
	public void setIconCls(String iconCls) {
		this.iconCls = iconCls;
	}
	public Attributes getAttributes() {
		return attributes;
	}
	public void setAttributes(Attributes attributes) {
		this.attributes = attributes;
	}
	public int getQyzt() {
		return qyzt;
	}
	public void setQyzt(int qyzt) {
		this.qyzt = qyzt;
	}
	public String getDw() {
		return dw;
	}
	public void setDw(String dw) {
		this.dw = dw;
	}
	public int getChildNum() {
		return childNum;
	}
	public void setChildNum(int childNum) {
		this.childNum = childNum;
	}

}