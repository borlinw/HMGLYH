package com.hdsx.hmglyh.gis.jichusj.yanxianss.dao.model;

/**
 * 交安设施 基础库 JIAOANSHESHI
 * @author zhanglm
 *
 */
public class Jiaoanss {
	
	
	
    

	private String id;

    private String roadcode;

    private String xzqh;

    private String roadname;

    private String spos;

    private String epos;

    private String sslx;

    private String gydw;

    private String szrq;

    private String bz;
    
    private double ptx;
    
    private String szlxlx;
    
    private String sl;
    
    private String dw;
    
	public String getSl() {
		return sl;
	}

	public void setSl(String sl) {
		this.sl = sl;
	}

	public String getDw() {
		return dw;
	}

	public void setDw(String dw) {
		this.dw = dw;
	}

	public String getSzlxlx() {
		return szlxlx;
	}

	public void setSzlxlx(String szlxlx) {
		this.szlxlx = szlxlx;
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

	public double getmPtx() {
		return mPtx;
	}

	public void setmPtx(double mPtx) {
		this.mPtx = mPtx;
	}

	public double getmPty() {
		return mPty;
	}

	public void setmPty(double mPty) {
		this.mPty = mPty;
	}

	public String getFx() {
		return fx;
	}

	public void setFx(String fx) {
		this.fx = fx;
	}

	private double pty;
    
    private double mPtx;
    
    private double mPty;
    
    private String fx;
    
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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRoadcode() {
		return roadcode;
	}

	public void setRoadcode(String roadcode) {
		this.roadcode = roadcode;
	}

	public String getXzqh() {
		return xzqh;
	}

	public void setXzqh(String xzqh) {
		this.xzqh = xzqh;
	}

	public String getRoadname() {
		return roadname;
	}

	public void setRoadname(String roadname) {
		this.roadname = roadname;
	}

	public String getSpos() {
		return spos;
	}

	public void setSpos(String spos) {
		this.spos = spos;
	}

	public String getEpos() {
		return epos;
	}

	public void setEpos(String epos) {
		this.epos = epos;
	}

	public String getSslx() {
		return sslx;
	}

	public void setSslx(String sslx) {
		this.sslx = sslx;
	}

	public String getGydw() {
		return gydw;
	}

	public void setGydw(String gydw) {
		this.gydw = gydw;
	}

	public String getSzrq() {
		return szrq;
	}

	public void setSzrq(String szrq) {
		this.szrq = szrq;
	}

	public String getBz() {
		return bz;
	}

	public void setBz(String bz) {
		this.bz = bz;
	}

	@Override
	public String toString() {
		return "Jiaoanss [id=" + id + ", roadcode=" + roadcode + ", xzqh="
				+ xzqh + ", roadname=" + roadname + ", spos=" + spos
				+ ", epos=" + epos + ", sslx=" + sslx + ", gydw=" + gydw
				+ ", szrq=" + szrq + ", bz=" + bz + ", ptx=" + ptx + ", pty="
				+ pty + ", mPtx=" + mPtx + ", mPty=" + mPty + ", fx=" + fx
				+ ", page=" + page + ", rows=" + rows + "]";
	}

  
}