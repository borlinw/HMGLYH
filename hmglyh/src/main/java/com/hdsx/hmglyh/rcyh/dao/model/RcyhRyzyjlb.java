package com.hdsx.hmglyh.rcyh.dao.model;

import java.io.Serializable;

public class RcyhRyzyjlb implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String zyid;

    private String ryid;

    private Double wcgcl;

    private Double wcgr;
    
    private String ryname;
    
    

    public String getRyname() {
		return ryname;
	}

	public void setRyname(String ryname) {
		this.ryname = ryname;
	}

	public String getZyid() {
        return zyid;
    }

    public void setZyid(String zyid) {
        this.zyid = zyid == null ? null : zyid.trim();
    }


    public String getRyid() {
		return ryid;
	}

	public void setRyid(String ryid) {
		this.ryid = ryid;
	}

	public Double getWcgcl() {
		return wcgcl;
	}

	public void setWcgcl(Double wcgcl) {
		this.wcgcl = wcgcl;
	}

	public Double getWcgr() {
		return wcgr;
	}

	public void setWcgr(Double wcgr) {
		this.wcgr = wcgr;
	}

}