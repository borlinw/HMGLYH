
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
 * @created 2015年7月15日 下午3:30:57 
 */

public class Kqzb implements Serializable {
	private static final long serialVersionUID = -6159078050017512399L;
			
	private String kqid;		//考勤id
	private Date scdate;		//生成时间
	private String ssny;		//所属年月
	private String bmCode;		//部门
	private String tbUserName;	//填报用户
	private String tbrxm;		//填报人姓名
	private String fzrxm;		//负责人
	private String bmlx;		//部门类型
	private boolean saved;		//是否已插入
	
	public boolean isSaved() {
		return saved;
	}
	public void setSaved(boolean saved) {
		this.saved = saved;
	}
	public String getBmlx() {
		return bmlx;
	}
	public void setBmlx(String bmlx) {
		this.bmlx = bmlx;
	}
	public String getKqid() {
		return kqid;
	}
	public void setKqid(String kqid) {
		this.kqid = kqid;
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
	@Override
	public String toString() {
		return "Kqzb [kqid=" + kqid + ", scdate=" + scdate 
				+ ", bmCode=" + bmCode + ", tbUserName=" + tbUserName
				+ ", tbrxm=" + tbrxm + ", fzrxm=" + fzrxm + "]";
	}
	
	
}














