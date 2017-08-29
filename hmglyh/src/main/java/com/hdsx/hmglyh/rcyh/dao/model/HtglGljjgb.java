package com.hdsx.hmglyh.rcyh.dao.model;

import java.io.Serializable;

public class HtglGljjgb implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Double dj;

	private String bmcode;

	private String lxid;

	public String getBmcode() {

		return bmcode;

	}

	public void setBmcode(String bmcode) {

		this.bmcode = bmcode;

	}

	public String getLxid() {

		return lxid;

	}

	public void setLxid(String lxid) {

		this.lxid = lxid;

	}

	public Double getDj() {

		return dj;

	}

	public void setDj(Double dj) {

		this.dj = dj;

	}

}
