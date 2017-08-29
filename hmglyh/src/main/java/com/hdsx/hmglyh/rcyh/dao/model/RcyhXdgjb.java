package com.hdsx.hmglyh.rcyh.dao.model;

import java.util.Date;

public class RcyhXdgjb {
    private String xcid;

    private String stime;

    private String etime;

    private byte[] shape;

    public String getXcid() {
        return xcid;
    }

    public void setXcid(String xcid) {
        this.xcid = xcid == null ? null : xcid.trim();
    }

    public String getStime() {
		return stime;
	}

	public void setStime(String stime) {
		this.stime = stime;
	}

	public String getEtime() {
		return etime;
	}

	public void setEtime(String etime) {
		this.etime = etime;
	}

	public byte[] getShape() {
        return shape;
    }

    public void setShape(byte[] shape) {
        this.shape = shape;
    }
}