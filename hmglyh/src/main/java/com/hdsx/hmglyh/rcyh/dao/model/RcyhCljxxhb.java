package com.hdsx.hmglyh.rcyh.dao.model;

import java.io.Serializable;


public class RcyhCljxxhb implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String ssid;

    private String lxid;

    private Double sl;

    private Double dj;

    private Double je;
    
    private String gg;
    private String lxname;
    private String dw;
    
    private String bm;
    
	public String getBm() {
		return bm;
	}

	public void setBm(String bm) {
		this.bm = bm;
	}

	public String getDw() {
		return dw;
	}

	public void setDw(String dw) {
		this.dw = dw;
	}

	public String getGg() {
		return gg;
	}

	public void setGg(String gg) {
		this.gg = gg;
	}

	public String getLxname() {
		return lxname;
	}

	public void setLxname(String lxname) {
		this.lxname = lxname;
	}

	public String getSsid() {
		return ssid;
	}

	public void setSsid(String ssid) {
		this.ssid = ssid;
	}

	public String getLxid() {
		return lxid;
	}

	public void setLxid(String lxid) {
		this.lxid = lxid;
	}


	public Double getSl() {
		return sl;
	}

	public void setSl(Double sl) {
		this.sl = sl;
	}

	public Double getDj() {
		return dj;
	}

	public void setDj(Double dj) {
		this.dj = dj;
	}

	public Double getJe() {
		return this.dj * this.sl;
	}

	public void setJe(Double je) {
		this.je = je;
	}

   
}