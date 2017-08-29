
 /**
 * 北京恒达时讯科技有限公司版权所有
 * Copyright (C) HDSX Corporation. All Rights Reserved
 */
package com.hdsx.hmglyh.jcpd.bean;

import java.io.Serializable;
import java.util.Date;

/**  
 *  
 * @author Baiyy
 * @created 2015年7月16日 下午3:37:46 
 */

public class Gzdxzb implements Serializable {
	private static final long serialVersionUID = 2863654571421862646L;
	
	private String gzid;		//工资id
	private Date scdate;		//生成时间
	private String ssny;		//所属年月
	private String bmCode;		//部门编码
	private String tbUserName;	//填报用户
	private String tbrxm;		//填报人姓名
	private String fzrxm;		//负责人
	
	public String getGzid() {
		return gzid;
	}
	public void setGzid(String gzid) {
		this.gzid = gzid;
	}
	public Date getScdate() {
		return scdate;
	}
	public void setScdate(Date scdate) {
		this.scdate = scdate;
	}
	public String getSsny() {
		return ssny;
	}
	public void setSsny(String ssny) {
		this.ssny = ssny;
	}
	public String getBmCode() {
		return bmCode;
	}
	public void setBmCode(String bmCode) {
		this.bmCode = bmCode;
	}
	public String getTbUserName() {
		return tbUserName;
	}
	public void setTbUserName(String tbUserName) {
		this.tbUserName = tbUserName;
	}
	public String getTbrxm() {
		return tbrxm;
	}
	public void setTbrxm(String tbrxm) {
		this.tbrxm = tbrxm;
	}
	public String getFzrxm() {
		return fzrxm;
	}
	public void setFzrxm(String fzrxm) {
		this.fzrxm = fzrxm;
	}
	
	
	
	
}
