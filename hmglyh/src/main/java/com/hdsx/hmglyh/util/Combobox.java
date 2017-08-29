package com.hdsx.hmglyh.util;

/**  
 *  EasyUI - Combobox
 * @author LiRui
 * @created 2015年6月5日 上午10:32:26 
 */

public class Combobox {
	private String id;		//combox id
	private String text;	//combox text
	private String value;
	//后台管理 - 路段用
	private double szhh;	//起点桩号
	private double ezhh;	//止点桩号
	private String lxcode;//路线编码
	//除雪汇总表用
	private String ssjStr;			//开始时间
	private String esjStr;		//结束时间

	public Combobox(){}
	
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Combobox(String id, String text) {
		super();
		this.id = id;
		this.text = text;
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
	public String getLxcode() {
		return lxcode;
	}
	public void setLxcode(String lxcode) {
		this.lxcode = lxcode;
	}
	public String getSsjStr() {
		return ssjStr;
	}
	public void setSsjStr(String ssjStr) {
		this.ssjStr = ssjStr;
	}
	public String getEsjStr() {
		return esjStr;
	}
	public void setEsjStr(String esjStr) {
		this.esjStr = esjStr;
	}

}
