
 /**
 * 北京恒达时讯科技有限公司版权所有
 * Copyright (C) HDSX Corporation. All Rights Reserved
 */
package com.hdsx.hmglyh.gis.jichusj.pub.dao.model;

import java.io.Serializable;

/**  
 *  
 * @author Baiyy
 * @created 2016年5月24日 下午3:28:22 
 */

public class PublicBean implements Serializable {
	private static final long serialVersionUID = 8746564827853260535L;
	
	private String title;
	private String data;
	private String condition;
	private String tableName;
	private String html;
	
	public String getHtml() {
		return html;
	}
	public void setHtml(String html) {
		this.html = html;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getCondition() {
		return condition;
	}
	public void setCondition(String condition) {
		this.condition = condition;
	}
	
	
	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	@Override
	public String toString() {
		return "PublicBean [title=" + title + ", data=" + data + ", condition="
				+ condition + ", tbaleName=" + tableName + "]";
	}
	
	

}
