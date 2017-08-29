package com.hdsx.hmglyh.gis.jichusj.qitays.dao.model;

import java.math.BigDecimal;

public class Chuanchengld {
    private Object id;

    private String roadcode;

    private Object xzqh;

    private Object roadname;

    private Object spos;

    private Object epos;

    private Object szdm;

    private Object bz;

    private BigDecimal ptx;

    private BigDecimal pty;

    private BigDecimal mPtx;

    private BigDecimal mPty;
    
    // 非持久化字段
    
    private int page;
    private int rows;
    
    private String bmcode;
    private double startzh;
    private double endzh;
	public String getBmcode() {
		return bmcode;
	}
	public void setBmcode(String bmcode) {
		this.bmcode = bmcode;
	}
	public double getStartzh() {
		return startzh;
	}
	public void setStartzh(double startzh) {
		this.startzh = startzh;
	}
	public double getEndzh() {
		return endzh;
	}
	public void setEndzh(double endzh) {
		this.endzh = endzh;
	}

    public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public Object getId() {
        return id;
    }

    public void setId(Object id) {
        this.id = id;
    }

    public String getRoadcode() {
		return roadcode;
	}
	public void setRoadcode(String roadcode) {
		this.roadcode = roadcode;
	}
	public Object getXzqh() {
        return xzqh;
    }

    public void setXzqh(Object xzqh) {
        this.xzqh = xzqh;
    }

    public Object getRoadname() {
        return roadname;
    }

    public void setRoadname(Object roadname) {
        this.roadname = roadname;
    }

    public Object getSpos() {
        return spos;
    }

    public void setSpos(Object spos) {
        this.spos = spos;
    }

    public Object getEpos() {
        return epos;
    }

    public void setEpos(Object epos) {
        this.epos = epos;
    }

    public Object getSzdm() {
        return szdm;
    }

    public void setSzdm(Object szdm) {
        this.szdm = szdm;
    }

    public Object getBz() {
        return bz;
    }

    public void setBz(Object bz) {
        this.bz = bz;
    }

    public BigDecimal getPtx() {
        return ptx;
    }

    public void setPtx(BigDecimal ptx) {
        this.ptx = ptx;
    }

    public BigDecimal getPty() {
        return pty;
    }

    public void setPty(BigDecimal pty) {
        this.pty = pty;
    }

    public BigDecimal getmPtx() {
        return mPtx;
    }

    public void setmPtx(BigDecimal mPtx) {
        this.mPtx = mPtx;
    }

    public BigDecimal getmPty() {
        return mPty;
    }

    public void setmPty(BigDecimal mPty) {
        this.mPty = mPty;
    }
}