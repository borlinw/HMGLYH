package com.hdsx.hmglyh.gis.jichusj.luxianjc.dao.model;



public class Gaosucrk {
    private String roadcode;

    private String xzqh;

    private String code;

    private String name;

    private String pos;

    private String crklx;

    private String crkwz;

    private String ldlx;

    private String zdbm;

    private String cktwmdddm;

    private String cktwjqmc;

    private String ljlxdm;

    private String ljlxmc;

    private String ljlxzh;

    private String qtzyxx;

    private String tbdwbm;

    private String gydwbm;

    private String gydwmc;

    private String bz;

    private String dsmc;

    private String qxmc;

    private double ptx;

    private double pty;

    private double roadpos;

    private String oId;

    private String roadname;

    private Long zId;

    private Long cId;

    private String id;

    private double mPty;

    private Long sfkbj;

    private double mPtx;
    
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
		return "Gaosucrk [roadcode=" + roadcode + ", xzqh=" + xzqh + ", code="
				+ code + ", name=" + name + ", pos=" + pos + ", ptx=" + ptx
				+ ", pty=" + pty + ", id=" + id + "]";
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

	public String getXzqh() {
		return xzqh;
	}

	public void setXzqh(String xzqh) {
		this.xzqh = xzqh;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
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

	public String getCrklx() {
		return crklx;
	}

	public void setCrklx(String crklx) {
		this.crklx = crklx;
	}

	public String getCrkwz() {
		return crkwz;
	}

	public void setCrkwz(String crkwz) {
		this.crkwz = crkwz;
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

	public String getCktwmdddm() {
		return cktwmdddm;
	}

	public void setCktwmdddm(String cktwmdddm) {
		this.cktwmdddm = cktwmdddm;
	}

	public String getCktwjqmc() {
		return cktwjqmc;
	}

	public void setCktwjqmc(String cktwjqmc) {
		this.cktwjqmc = cktwjqmc;
	}

	public String getLjlxdm() {
		return ljlxdm;
	}

	public void setLjlxdm(String ljlxdm) {
		this.ljlxdm = ljlxdm;
	}

	public String getLjlxmc() {
		return ljlxmc;
	}

	public void setLjlxmc(String ljlxmc) {
		this.ljlxmc = ljlxmc;
	}

	public String getLjlxzh() {
		return ljlxzh;
	}

	public void setLjlxzh(String ljlxzh) {
		this.ljlxzh = ljlxzh;
	}

	public String getQtzyxx() {
		return qtzyxx;
	}

	public void setQtzyxx(String qtzyxx) {
		this.qtzyxx = qtzyxx;
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

	public String getBz() {
		return bz;
	}

	public void setBz(String bz) {
		this.bz = bz;
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

	public double getRoadpos() {
		return roadpos;
	}

	public void setRoadpos(double roadpos) {
		this.roadpos = roadpos;
	}

	public String getoId() {
		return oId;
	}

	public void setoId(String oId) {
		this.oId = oId;
	}

	public String getRoadname() {
		return roadname;
	}

	public void setRoadname(String roadname) {
		this.roadname = roadname;
	}

	public Long getzId() {
		return zId;
	}

	public void setzId(Long zId) {
		this.zId = zId;
	}

	public Long getcId() {
		return cId;
	}

	public void setcId(Long cId) {
		this.cId = cId;
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