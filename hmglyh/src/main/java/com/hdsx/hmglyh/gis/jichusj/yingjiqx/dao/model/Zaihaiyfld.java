package com.hdsx.hmglyh.gis.jichusj.yingjiqx.dao.model;

/**
 * 灾害易发路段
 * @author zhanglm
 *
 */
public class Zaihaiyfld {
    private String id;

    private String roadcode;

    private String xzqh;

    private String roadname;

    private String spos;

    private String epos;

    private String wz;

    private String yfzhlx;

    private String zhsm;

    private String bz;
    
    private String fx;
    
    private double ptx;
    
    private double pty;
    
    private double mPtx;
    
    private double mPty;
    
    private String ldlx;
    
    private double ldcd;
    
    private String zdbm;
    
    private String yhdwmc;
    
    private String gydwmc;
    
    private String gydwbm;
    
    private String dsmc;
    
    private String qxmc;
    
    private String name;
    
    private String code;
    
    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getLdlx() {
		return ldlx;
	}

	public void setLdlx(String ldlx) {
		this.ldlx = ldlx;
	}

	public double getLdcd() {
		return ldcd;
	}

	public void setLdcd(double ldcd) {
		this.ldcd = ldcd;
	}

	public String getZdbm() {
		return zdbm;
	}

	public void setZdbm(String zdbm) {
		this.zdbm = zdbm;
	}

	public String getYhdwmc() {
		return yhdwmc;
	}

	public void setYhdwmc(String yhdwmc) {
		this.yhdwmc = yhdwmc;
	}

	public String getGydwmc() {
		return gydwmc;
	}

	public void setGydwmc(String gydwmc) {
		this.gydwmc = gydwmc;
	}

	public String getGydwbm() {
		return gydwbm;
	}

	public void setGydwbm(String gydwbm) {
		this.gydwbm = gydwbm;
	}

	public String getDsmc() {
		return dsmc;
	}

	public void setDsmc(String dsmc) {
		this.dsmc = dsmc;
	}

	public String getQxmc() {
		return qxmc;
	}

	public void setQxmc(String qxmc) {
		this.qxmc = qxmc;
	}

	public String getFx() {
		return fx;
	}

	public void setFx(String fx) {
		this.fx = fx;
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

	// 非持久化 字段
	
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


	@Override
	public String toString() {
		return "Zaihaiyfld [id=" + id + ", roadcode=" + roadcode + ", xzqh="
				+ xzqh + ", roadname=" + roadname + ", spos=" + spos
				+ ", epos=" + epos + ", wz=" + wz + ", yfzhlx=" + yfzhlx
				+ ", zhsm=" + zhsm + ", bz=" + bz + ", fx=" + fx + ", ptx="
				+ ptx + ", pty=" + pty + ", mPtx=" + mPtx + ", mPty=" + mPty
				+ ", page=" + page + ", rows=" + rows + "]";
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

	public String getWz() {
		return wz;
	}

	public void setWz(String wz) {
		this.wz = wz;
	}

	public String getYfzhlx() {
		return yfzhlx;
	}

	public void setYfzhlx(String yfzhlx) {
		this.yfzhlx = yfzhlx;
	}

	public String getZhsm() {
		return zhsm;
	}

	public void setZhsm(String zhsm) {
		this.zhsm = zhsm;
	}

	public String getBz() {
		return bz;
	}

	public void setBz(String bz) {
		this.bz = bz;
	}
    
    

}