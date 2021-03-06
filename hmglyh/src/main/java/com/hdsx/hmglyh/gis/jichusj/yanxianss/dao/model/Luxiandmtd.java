package com.hdsx.hmglyh.gis.jichusj.yanxianss.dao.model;

/**
 * 路线多媒体点 Roadmedia
 * @author zhanglm
 *
 */

public class Luxiandmtd {
    private String roadcode;

    private String code;

    private String xzqh;

    private String roadname;

    private String name;

    private String pos;

    private String dmtddlx;

    private String ldlx;

    private String zdbm;

    private String ms;

    private String dm;

    private String tbdwbm;

    private String gydwbm;

    private String gydwmc;

    private String dsmc;

    private String qxmc;

    private double ptx;

    private double pty;

    private String id;

    private String oId;

    private double mPtx;

    private double mPty;

    private double roadpos;
    
    private Long zId;

    private Long sfkbj;

    private Long cId;
    
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

	@Override
	public String toString() {
		return "Luxiandmtd [roadcode=" + roadcode + ", code=" + code
				+ ", xzqh=" + xzqh + ", roadname=" + roadname + ", name="
				+ name + ", ptx=" + ptx + ", pty=" + pty + ", id=" + id + "]";
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

	public String getDmtddlx() {
		return dmtddlx;
	}

	public void setDmtddlx(String dmtddlx) {
		this.dmtddlx = dmtddlx;
	}

	public String getLdlx() {
		return ldlx;
	}

	public void setLdlx(String ldlx) {
		this.ldlx = ldlx;
	}

	public String getZdbm() {
		return zdbm;
	}

	public void setZdbm(String zdbm) {
		this.zdbm = zdbm;
	}

	public String getMs() {
		return ms;
	}

	public void setMs(String ms) {
		this.ms = ms;
	}

	public String getDm() {
		return dm;
	}

	public void setDm(String dm) {
		this.dm = dm;
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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getoId() {
		return oId;
	}

	public void setoId(String oId) {
		this.oId = oId;
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

	public double getRoadpos() {
		return roadpos;
	}

	public void setRoadpos(double roadpos) {
		this.roadpos = roadpos;
	}

	public Long getzId() {
		return zId;
	}

	public void setzId(Long zId) {
		this.zId = zId;
	}

	public Long getSfkbj() {
		return sfkbj;
	}

	public void setSfkbj(Long sfkbj) {
		this.sfkbj = sfkbj;
	}

	public Long getcId() {
		return cId;
	}

	public void setcId(Long cId) {
		this.cId = cId;
	}

	
   
}