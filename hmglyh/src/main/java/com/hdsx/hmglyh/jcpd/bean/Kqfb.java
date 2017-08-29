
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
 * @created 2015年7月15日 下午3:31:23 
 */

public class Kqfb implements Serializable{
	private static final long serialVersionUID = 2293595768575635563L;
	
	private String kqid;			//考勤id
	private int ryid;				//人员id
	private String sql;				//生成考勤附表的sql
	
	private Date zytime;			//作业时间
	private String kq;				//考勤状态（休息，出工，出勤等）
	
	public Date getZytime() {
		return zytime;
	}
	public void setZytime(Date zytime) {
		this.zytime = zytime;
	}
	public String getKq() {
		return kq;
	}
	public void setKq(String kq) {
		this.kq = kq;
	}
	public String getKqid() {
		return kqid;
	}
	public void setKqid(String kqid) {
		this.kqid = kqid;
	}
	public int getRyid() {
		return ryid;
	}
	public void setRyid(int ryid) {
		this.ryid = ryid;
	}
	public String getSql() {
		return sql;
	}
	public void setSql(String sql) {
		this.sql = sql;
	}
	
	
}
































