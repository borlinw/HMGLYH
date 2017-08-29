package com.hdsx.hmglyh.basicData.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

public class Bhlx implements Serializable{

	private static final long serialVersionUID = 8839452853893184970L;

	private String bhid;

    private String bhname;

    private String dw;

    private String bhms; 

    private BigDecimal wxsx;

    private Short qyzt;

    private BigDecimal px;

 
	private List<Bhlx> children;
	private int childNum;
   


    
    public List<Bhlx> getChildren() {
		return children;
	}

	public void setChildren(List<Bhlx> children) {
		this.children = children;
	}

	public String getBhid() {
        return bhid;
    }

    public void setBhid(String bhid) {
        this.bhid = bhid == null ? null : bhid.trim();
    }

    public String getBhname() {
        return bhname;
    }

    public void setBhname(String bhname) {
        this.bhname = bhname == null ? null : bhname.trim();
    }

    public String getDw() {
        return dw;
    }

    public void setDw(String dw) {
        this.dw = dw == null ? null : dw.trim();
    }

    public String getBhms() {
        return bhms;
    }

    public void setBhms(String bhms) {
        this.bhms = bhms == null ? null : bhms.trim();
    }

    public BigDecimal getWxsx() {
        return wxsx;
    }

    public void setWxsx(BigDecimal wxsx) {
        this.wxsx = wxsx;
    }

    public Short getQyzt() {
        return qyzt;
    }

    public void setQyzt(Short qyzt) {
        this.qyzt = qyzt;
    }

    public BigDecimal getPx() {
        return px;
    }

    public void setPx(BigDecimal px) {
        this.px = px;
    }

	public int getChildNum() {
		return childNum;
	}

	public void setChildNum(int childNum) {
		this.childNum = childNum;
	}
}