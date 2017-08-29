
 /**
 * 北京恒达时讯科技有限公司版权所有
 * Copyright (C) HDSX Corporation. All Rights Reserved
 */
package com.hdsx.hmglyh.gis.card.bean;

import java.io.Serializable;
import java.util.Date;

/**  
 *  
 * @author Baiyy
 * @created 2015年8月6日 下午2:53:13 
 */

public class Card implements Serializable {
	private static final long serialVersionUID = 2065642529664090218L;
	private int kpid;
	private int kplx;
	private String dyid;
	private String wjdz;
	private String userName;
	private Date scTime;
	
	private String html;
	
	public String getHtml() {
		return html;
	}
	public void setHtml(String html) {
		this.html = html;
	}
	public int getKpid() {
		return kpid;
	}
	public void setKpid(int kpid) {
		this.kpid = kpid;
	}
	public int getKplx() {
		return kplx;
	}
	public void setKplx(int kplx) {
		this.kplx = kplx;
	}
	public String getDyid() {
		return dyid;
	}
	public void setDyid(String dyid) {
		this.dyid = dyid;
	}
	public String getWjdz() {
		return wjdz;
	}
	public void setWjdz(String wjdz) {
		this.wjdz = wjdz;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Date getScTime() {
		return scTime;
	}
	public void setScTime(Date scTime) {
		this.scTime = scTime;
	}
	
	
}
