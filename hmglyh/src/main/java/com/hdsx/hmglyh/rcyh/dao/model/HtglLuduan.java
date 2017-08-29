package com.hdsx.hmglyh.rcyh.dao.model;

import java.io.Serializable;

public class HtglLuduan implements Serializable{
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String ldcode;

    private String ldname;

    private String lxcode;

    private Long szhh;

    private Long ezhh;

    private Long mileage;

    private String bmcode;

    private String bz;
    
    // 非持久化 字段
    private boolean selected;
    
    public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}

	@Override
	public String toString() {
		return "HtglLuduan [ldcode=" + ldcode + ", ldname=" + ldname
				+ ", lxcode=" + lxcode + ", szhh=" + szhh + ", ezhh=" + ezhh
				+ ", mileage=" + mileage + ", bmcode=" + bmcode + ", bz=" + bz
				+ "]";
	}

	public String getLdcode() {
        return ldcode;
    }

    public void setLdcode(String ldcode) {
        this.ldcode = ldcode == null ? null : ldcode.trim();
    }

    public String getLdname() {
        return ldname;
    }

    public void setLdname(String ldname) {
        this.ldname = ldname == null ? null : ldname.trim();
    }

    public String getLxcode() {
        return lxcode;
    }

    public void setLxcode(String lxcode) {
        this.lxcode = lxcode == null ? null : lxcode.trim();
    }

    public Long getSzhh() {
        return szhh;
    }

    public void setSzhh(Long szhh) {
        this.szhh = szhh;
    }

    public Long getEzhh() {
        return ezhh;
    }

    public void setEzhh(Long ezhh) {
        this.ezhh = ezhh;
    }

    public Long getMileage() {
        return mileage;
    }

    public void setMileage(Long mileage) {
        this.mileage = mileage;
    }

    public String getBmcode() {
        return bmcode;
    }

    public void setBmcode(String bmcode) {
        this.bmcode = bmcode == null ? null : bmcode.trim();
    }

    public String getBz() {
        return bz;
    }

    public void setBz(String bz) {
        this.bz = bz == null ? null : bz.trim();
    }
}