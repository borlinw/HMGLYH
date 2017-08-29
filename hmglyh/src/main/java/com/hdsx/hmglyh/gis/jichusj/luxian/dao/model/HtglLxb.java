package com.hdsx.hmglyh.gis.jichusj.luxian.dao.model;

/**
 * 与 htgl_ldb 合并 到了一起 
 * 路线表 业务库 对应表 htgl_lxb
 * @author zhanglm
 */

public class HtglLxb {
    private String lxcode;

    private String lxname;

    private double szhh;

    private double ezhh;

    private double mileage;
    
    private double zdlc;
    
  
    
    private int page;
    
	private int rows;
   
	
	
    public double getZdlc() {
		return zdlc;
	}

	public void setZdlc(double zdlc) {
		this.zdlc = zdlc;
	}

	@Override
	public String toString() {
		return "HtglLxb [lxcode=" + lxcode + ", lxname=" + lxname + ", szhh="
				+ szhh + ", ezhh=" + ezhh + ", mileage=" + mileage + ", page="
				+ page + ", rows=" + rows + "]";
	}

	public double getSzhh() {
		return szhh;
	}

	public void setSzhh(double szhh) {
		this.szhh = szhh;
	}

	public double getEzhh() {
		return ezhh;
	}

	public void setEzhh(double ezhh) {
		this.ezhh = ezhh;
	}

	public double getMileage() {
		return mileage;
	}

	public void setMileage(double mileage) {
		this.mileage = mileage;
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

	public String getLxcode() {
        return lxcode;
    }

    public void setLxcode(String lxcode) {
        this.lxcode = lxcode == null ? null : lxcode.trim();
    }

    public String getLxname() {
        return lxname;
    }

    public void setLxname(String lxname) {
        this.lxname = lxname == null ? null : lxname.trim();
    }
}