package com.hdsx.hmglyh.gis.jichusj.guanyangdw.dao.model;

import java.math.BigDecimal;
import java.util.List;


public class HtglBmb {
    private String bmcode;

    private String bmzscode = "";

    private String bmname = "";

    private String fzr = "";

    private String lxdh = "";

    private String bmms = "";

    private BigDecimal bmlx;

    private Short qyzt;

    private double ptx;

    private double pty;
    
    private String state;
    
    private int sftsbm; // 是否特殊部门
    
    private String jsnf;
    
    private double zdmj;
    
    private double jzmj;
    
    private String dz;
    
    private String lxCode;
    
    private String fx;
    
    private double pos;
    
    private String zh;
    
    

	public String getJsnf() {
		return jsnf;
	}

	public void setJsnf(String jsnf) {
		this.jsnf = jsnf;
	}

	public double getZdmj() {
		return zdmj;
	}

	public void setZdmj(double zdmj) {
		this.zdmj = zdmj;
	}

	public double getJzmj() {
		return jzmj;
	}

	public void setJzmj(double jzmj) {
		this.jzmj = jzmj;
	}

	public String getDz() {
		return dz;
	}

	public void setDz(String dz) {
		this.dz = dz;
	}

	public String getLxCode() {
		return lxCode;
	}

	public void setLxCode(String lxCode) {
		this.lxCode = lxCode;
	}

	public String getFx() {
		return fx;
	}

	public void setFx(String fx) {
		this.fx = fx;
	}

	public double getPos() {
		return pos;
	}

	public void setPos(double pos) {
		this.pos = pos;
	}

	public String getZh() {
		return zh;
	}

	public void setZh(String zh) {
		this.zh = zh;
	}

	// 非持久化 字段
    private boolean selected;
    
    
    public int getSftsbm() {
		return sftsbm;
	}

	public void setSftsbm(int sftsbm) {
		this.sftsbm = sftsbm;
	}

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "HtglBmb [bmcode=" + bmcode + ", bmzscode=" + bmzscode
				+ ", bmname=" + bmname + ", fzr=" + fzr + ", lxdh=" + lxdh
				+ ", bmms=" + bmms + ", bmlx=" + bmlx + ", qyzt=" + qyzt
				+ ", ptx=" + ptx + ", pty=" + pty + ", children=" + children
				+ "]";
	}

	private List<HtglBmb> children;
   
   

	

	public List<HtglBmb> getChildren() {
		return children;
	}

	public void setChildren(List<HtglBmb> children) {
		this.children = children;
	}

	public String getBmcode() {
        return bmcode;
    }

    public void setBmcode(String bmcode) {
        this.bmcode = bmcode == null ? null : bmcode.trim();
    }

    public String getBmzscode() {
        return bmzscode;
    }

    public void setBmzscode(String bmzscode) {
        this.bmzscode = bmzscode == null ? null : bmzscode.trim();
    }

    public String getBmname() {
        return bmname;
    }

    public void setBmname(String bmname) {
        this.bmname = bmname == null ? null : bmname.trim();
    }

    public String getFzr() {
        return fzr;
    }

    public void setFzr(String fzr) {
        this.fzr = fzr == null ? null : fzr.trim();
    }

    public String getLxdh() {
        return lxdh;
    }

    public void setLxdh(String lxdh) {
        this.lxdh = lxdh == null ? null : lxdh.trim();
    }

    public String getBmms() {
        return bmms;
    }

    public void setBmms(String bmms) {
        this.bmms = bmms == null ? null : bmms.trim();
    }

    public BigDecimal getBmlx() {
        return bmlx;
    }

    public void setBmlx(BigDecimal bmlx) {
        this.bmlx = bmlx;
    }

    public Short getQyzt() {
        return qyzt;
    }

    public void setQyzt(Short qyzt) {
        this.qyzt = qyzt;
    }

	public double getPtx() {
		return ptx;
	}

	public void setPtx(double ptx) {
		this.ptx = ptx;
	}

	public double getPty() {
		return pty;
	}

	public void setPty(double pty) {
		this.pty = pty;
	}

  
}