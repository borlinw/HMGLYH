package com.hdsx.hmglyh.gis.jichusj.luxian.dao.model;

import java.math.BigDecimal;

public class Luxian {
  
	private String lxcode;
	
    private String lxname;

    private BigDecimal szhh;

    private BigDecimal ezhh;

    private String mileage;

	@Override
	public String toString() {
		return "Luxian [lxcode=" + lxcode + ", lxname=" + lxname + ", szhh="
				+ szhh + ", ezhh=" + ezhh + ", mileage=" + mileage + "]";
	}

	public String getLxcode() {
		return lxcode;
	}

	public void setLxcode(String lxcode) {
		this.lxcode = lxcode;
	}

	public String getLxname() {
		return lxname;
	}

	public void setLxname(String lxname) {
		this.lxname = lxname;
	}

	public BigDecimal getSzhh() {
		return szhh;
	}

	public void setSzhh(BigDecimal szhh) {
		this.szhh = szhh;
	}

	public BigDecimal getEzhh() {
		return ezhh;
	}

	public void setEzhh(BigDecimal ezhh) {
		this.ezhh = ezhh;
	}

	public String getMileage() {
		return mileage;
	}

	public void setMileage(String mileage) {
		this.mileage = mileage;
	}

   
}