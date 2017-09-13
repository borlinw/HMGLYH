
 /**
 * 北京恒达时讯科技有限公司版权所有
 * Copyright (C) HDSX Corporation. All Rights Reserved
 */
package com.hdsx.hmglyh.gis.jichusj.luxian.dao.model;

/**  
 *  
 * @author Baiyy
 * @created 2016年6月19日 下午6:26:56 
 */

public class Attachment {
	private String id;
	private String name;
	private String wz;
	private String lswxjlid;
	private int type;
	
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getWz() {
		return wz;
	}
	public void setWz(String wz) {
		this.wz = wz;
	}
	public String getLswxjlid() {
		return lswxjlid;
	}
	public void setLswxjlid(String lswxjlid) {
		this.lswxjlid = lswxjlid;
	}
	
	
}
