package com.hdsx.hmglyh.gis.jichusj.luxian.dao.model;
/**
 * 业务库 路段 表 htgl_ldb 
 * @author zhanglm 
 * 已弃用
 * 
 */
import java.math.BigDecimal;

public class HtglLdb {
    private String ldcode;

    private String ldname;

    private String lxcode;

    private double szhh;

    private double ezhh;
    
    private BigDecimal mileage;

    private String bmcode;

    private String bz;
    

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
	
	

	@Override
	public String toString() {
		return "HtglLdb [ldcode=" + ldcode + ", ldname=" + ldname + ", lxcode="
				+ lxcode + ", szhh=" + szhh + ", ezhh=" + ezhh + ", mileage="
				+ mileage + ", bmcode=" + bmcode + ", bz=" + bz + ", page="
				+ page + ", rows=" + rows + "]";
	}

    
    private int page;
    private int rows;
    
     

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

  

    public BigDecimal getMileage() {
        return mileage;
    }

    public void setMileage(BigDecimal mileage) {
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