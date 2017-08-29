/**
 * 北京恒达时讯科技有限公司版权所有
 * Copyright (C) HDSX Corporation. All Rights Reserved
 */
package com.hdsx.hmglyh.jcpd.bean;

import java.io.Serializable;

/**  
 *  
 * @author Baiyy
 * @created 2015年6月5日 上午10:42:00 
 */

public class Lkdcfb implements Serializable {

	private static final long serialVersionUID = 592104952218466972L;
	
	private String fbid;		//调查附表id
	private String dcid;		//调查主表id
	private String lxid;		//调查类型
	private double ljsj;		//累计数据
	
	public String getFbid() {
		return fbid;
	}
	public void setFbid(String fbid) {
		this.fbid = fbid;
	}
	public String getDcid() {
		return dcid;
	}
	public void setDcid(String dcid) {
		this.dcid = dcid;
	}
	public String getLxid() {
		return lxid;
	}
	public void setLxid(String lxid) {
		this.lxid = lxid;
	}
	public double getLjsj() {
		return ljsj;
	}
	public void setLjsj(double ljsj) {
		this.ljsj = ljsj;
	}
	
}
