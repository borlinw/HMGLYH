package com.hdsx.hmglyh.gis.jichusj.gouzaowu.dao.model;
/**
 * 涵洞 基础库 handong
 * @author zhanglm
 *
 */
public class Handong {
	
	
    @Override
	public String toString() {
		return "Handong [roadcode=" + roadcode + ", code=" + code + ", xzqh="
				+ xzqh + ", roadname=" + roadname + ", name=" + name + ", pos="
				+ pos + ", ptx=" + ptx + ", pty=" + pty + "]";
	}

	private String roadcode;

    private String code;

    private String xzqh;

    private String roadname;

    private String name;

    private String pos;

    private String hdlx;

    private String ldlx;

    private String zdbm;

    private double hdkj;

    private double hdjg;

    private double hdcd;

    private String tbdwbm;

    private String gydwbm;

    private String gydwmc;

    private String bz;

    private String dsmc;

    private String qxmc;

    private double ptx;

    private double pty;

    private Long cId;

    private double mPtx;

    private double mPty;

    private Long zId;


    private String id;

    private String oId;

    private Long sfkbj;

    private double roadpos;
    
    private int page;
    private int rows;
    private double startzh;
    private double endzh;
    
    private String jszk;
    private String ks;
    private String kj;
    private String jk;
    private String hdqc;
    private String jkxs;
    private String ckxs;
    
    
    public String getJszk() {
		return jszk;
	}

	public void setJszk(String jszk) {
		this.jszk = jszk;
	}

	public String getKs() {
		return ks;
	}

	public void setKs(String ks) {
		this.ks = ks;
	}

	public String getKj() {
		return kj;
	}

	public void setKj(String kj) {
		this.kj = kj;
	}

	public String getJk() {
		return jk;
	}

	public void setJk(String jk) {
		this.jk = jk;
	}

	public String getHdqc() {
		return hdqc;
	}

	public void setHdqc(String hdqc) {
		this.hdqc = hdqc;
	}

	public String getJkxs() {
		return jkxs;
	}

	public void setJkxs(String jkxs) {
		this.jkxs = jkxs;
	}

	public String getCkxs() {
		return ckxs;
	}

	public void setCkxs(String ckxs) {
		this.ckxs = ckxs;
	}

	private String [] roadcodes;
    
    private String bmcode;
    
	public String getBmcode() {
		return bmcode;
	}

	public void setBmcode(String bmcode) {
		this.bmcode = bmcode;
	}

	public String[] getRoadcodes() {
		return roadcodes;
	}

	public void setRoadcodes(String[] roadcodes) {
		this.roadcodes = roadcodes;
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

	public String getHdlx() {
		return hdlx;
	}

	public void setHdlx(String hdlx) {
		this.hdlx = hdlx;
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

	public double getHdkj() {
		return hdkj;
	}

	public void setHdkj(double hdkj) {
		this.hdkj = hdkj;
	}

	public double getHdjg() {
		return hdjg;
	}

	public void setHdjg(double hdjg) {
		this.hdjg = hdjg;
	}

	public double getHdcd() {
		return hdcd;
	}

	public void setHdcd(double hdcd) {
		this.hdcd = hdcd;
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

	public Long getcId() {
		return cId;
	}

	public void setcId(Long cId) {
		this.cId = cId;
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

	public Long getzId() {
		return zId;
	}

	public void setzId(Long zId) {
		this.zId = zId;
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

	public Long getSfkbj() {
		return sfkbj;
	}

	public void setSfkbj(Long sfkbj) {
		this.sfkbj = sfkbj;
	}

	public double getRoadpos() {
		return roadpos;
	}

	public void setRoadpos(double roadpos) {
		this.roadpos = roadpos;
	}   
}