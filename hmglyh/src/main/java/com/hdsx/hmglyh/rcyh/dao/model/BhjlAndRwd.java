package com.hdsx.hmglyh.rcyh.dao.model;

import java.io.Serializable;

public class BhjlAndRwd implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String bhjlid;
	private String rwdid;
	
	public String getBhjlid() {
		return bhjlid;
	}
	public void setBhjlid(String bhjlid) {
		this.bhjlid = bhjlid;
	}
	public String getRwdid() {
		return rwdid;
	}
	public void setRwdid(String rwdid) {
		this.rwdid = rwdid;
	}
}
