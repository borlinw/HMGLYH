package com.hdsx.hmglyh.rcyh.dao.model;

import java.io.Serializable;

public class ZP implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String zpid;

    private String ssid;

    private String ryid;

    private String zpmc;

    private String zpdz;
    
    private String zpdx;
    
    private String zpms;
    
    public String getZpdx() {
		return zpdx;
	}

	public void setZpdx(String zpdx) {
		this.zpdx = zpdx;
	}

	public String getZpms() {
		return zpms;
	}

	public void setZpms(String zpms) {
		this.zpms = zpms;
	}

	// 非持久化 字段
    private String picUrl;
    

    public String getPicUrl() {
		return picUrl;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}

	public String getZpid() {
        return zpid;
    }

    public void setZpid(String zpid) {
        this.zpid = zpid == null ? null : zpid.trim();
    }

    public String getSsid() {
        return ssid;
    }

    public void setSsid(String ssid) {
        this.ssid = ssid == null ? null : ssid.trim();
    }

    public String getRyid() {
        return ryid;
    }

    public void setRyid(String ryid) {
        this.ryid = ryid == null ? null : ryid.trim();
    }

    public String getZpmc() {
        return zpmc;
    }

    public void setZpmc(String zpmc) {
        this.zpmc = zpmc == null ? null : zpmc.trim();
    }

    public String getZpdz() {
        return zpdz;
    }

    public void setZpdz(String zpdz) {
        this.zpdz = zpdz == null ? null : zpdz.trim();
    }
}