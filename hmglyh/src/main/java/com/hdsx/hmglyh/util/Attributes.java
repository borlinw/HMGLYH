/**
 * 北京恒达时讯科技有限公司版权所有
 * Copyright (C) HDSX Corporation. All Rights Reserved
 */
package com.hdsx.hmglyh.util;

/**
 * Attributes
 * 描述：用于Combotree的扩展属性
 * @author LiRui
 * @version 2015年05月28日 上午10:45:29
 */
public class Attributes {

	//“工料机”（添加定额）
	private int childNum;		//某工料机节点下的子节点的数量（用于判断能不能被添加）
	private int isUsed;			//表示该条属性是否已被应用（0：未用，1：已用）
	private String dw;			//单位
	//路段下拉框（用于除雪快报）
	private double szhh;		//起点桩号（共用）
	private double ezhh;		//止点桩号（共用）

	public int getChildNum() {
		return childNum;
	}
	public void setChildNum(int childNum) {
		this.childNum = childNum;
	}
	public int getIsUsed() {
		return isUsed;
	}
	public void setIsUsed(int isUsed) {
		this.isUsed = isUsed;
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
	public String getDw() {
		return dw;
	}
	public void setDw(String dw) {
		this.dw = dw;
	}

}
