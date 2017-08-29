package com.hdsx.hmglyh.gis.jichusj.yingjiqx.dao.model;

/**
 * 地质灾害点
 * @author zhanglm
 *
 */

public class Dizhizhd {
    private String roadcode;

    private String code;

    private String xzqh;

    private String roadname;

    private String name;

    private String pos;

    private String yfdzzhdlx;

    private String ldlx;

    private double ldcd;

    private String zdbm;

    private String tbdwbm;

    private String gydwbm;

    private String gydwmc;

    private String dsmc;

    private String qxmc;

    private String bz;

    private double ptx;

    private double pty;

    private Long cId;

    private String oId;

    private Long zId;

    private double roadpos;

    private String id;

    private double mPty;

    private Long sfkbj;

    private double mPtx;
    private String fx;
    
    // 非持久化字段
    private int page;
    private int rows;
    
    private String bmcode;
    private double startzh;
    private double endzh;
    
	public String getFx() {
		return fx;
	}
	public void setFx(String fx) {
		this.fx = fx;
	}
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
		return "Dizhizhd [roadcode=" + roadcode + ", code=" + code + ", xzqh="
				+ xzqh + ", roadname=" + roadname + ", name=" + name + ", ptx="
				+ ptx + ", pty=" + pty + ", id=" + id + "]";
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

	public String getRoadcode() {
		return roadcode;
	}

	public void setRoadcode(String roadcode) {
		this.roadcode = roadcode;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPos() {
		return pos;
	}

	public void setPos(String pos) {
		this.pos = pos;
	}

	public String getYfdzzhdlx() {
		return yfdzzhdlx;
	}

	public void setYfdzzhdlx(String yfdzzhdlx) {
		this.yfdzzhdlx = yfdzzhdlx;
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

	public String getTbdwbm() {
		return tbdwbm;
	}

	public void setTbdwbm(String tbdwbm) {
		this.tbdwbm = tbdwbm;
	}

	public String getGydwbm() {
		return gydwbm;
	}

	public void setGydwbm(String gydwbm) {
		this.gydwbm = gydwbm;
	}

	public String getGydwmc() {
		return gydwmc;
	}

	public void setGydwmc(String gydwmc) {
		this.gydwmc = gydwmc;
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

	public String getBz() {
		return bz;
	}

	public void setBz(String bz) {
		this.bz = bz;
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

	public Long getcId() {
		return cId;
	}

	public void setcId(Long cId) {
		this.cId = cId;
	}

	public String getoId() {
		return oId;
	}

	public void setoId(String oId) {
		this.oId = oId;
	}

	public Long getzId() {
		return zId;
	}

	public void setzId(Long zId) {
		this.zId = zId;
	}

	public double getRoadpos() {
		return roadpos;
	}

	public void setRoadpos(double roadpos) {
		this.roadpos = roadpos;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public double getmPty() {
		return mPty;
	}

	public void setmPty(double mPty) {
		this.mPty = mPty;
	}

	public Long getSfkbj() {
		return sfkbj;
	}

	public void setSfkbj(Long sfkbj) {
		this.sfkbj = sfkbj;
	}

	public double getmPtx() {
		return mPtx;
	}

	public void setmPtx(double mPtx) {
		this.mPtx = mPtx;
	}
    
    
}