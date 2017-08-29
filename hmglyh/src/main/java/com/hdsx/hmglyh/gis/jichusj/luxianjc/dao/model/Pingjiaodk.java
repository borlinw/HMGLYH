package com.hdsx.hmglyh.gis.jichusj.luxianjc.dao.model;

/**
 * 平交道口
 * @author zhanglm
 *
 */

public class Pingjiaodk {
    private double pty;

    private double lxzh2;

    private String pos;

    private String zdbm;

    private String ldlx;
 
    private Long cId;
    
    // 非 持久化字段
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
		return "Pingjiaodk [pty=" + pty + ", ptx=" + ptx + ", id=" + id
				+ ", gydwmc=" + gydwmc + ", gydwbm=" + gydwbm + "]";
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

	public double getPty() {
		return pty;
	}

	public void setPty(double pty) {
		this.pty = pty;
	}

	public double getLxzh2() {
		return lxzh2;
	}

	public void setLxzh2(double lxzh2) {
		this.lxzh2 = lxzh2;
	}

	public String getPos() {
		return pos;
	}

	public void setPos(String pos) {
		this.pos = pos;
	}

	public String getZdbm() {
		return zdbm;
	}

	public void setZdbm(String zdbm) {
		this.zdbm = zdbm;
	}

	public String getLdlx() {
		return ldlx;
	}

	public void setLdlx(String ldlx) {
		this.ldlx = ldlx;
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

	public String getJclkzl() {
		return jclkzl;
	}

	public void setJclkzl(String jclkzl) {
		this.jclkzl = jclkzl;
	}

	public double getPtx() {
		return ptx;
	}

	public void setPtx(double ptx) {
		this.ptx = ptx;
	}

	public String getoId() {
		return oId;
	}

	public void setoId(String oId) {
		this.oId = oId;
	}

	public String getBz() {
		return bz;
	}

	public void setBz(String bz) {
		this.bz = bz;
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

	public double getmPty() {
		return mPty;
	}

	public void setmPty(double mPty) {
		this.mPty = mPty;
	}

	public String getRoadcode2() {
		return roadcode2;
	}

	public void setRoadcode2(String roadcode2) {
		this.roadcode2 = roadcode2;
	}

	public Long getSfkbj() {
		return sfkbj;
	}

	public void setSfkbj(Long sfkbj) {
		this.sfkbj = sfkbj;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public String getF002() {
		return f002;
	}

	public void setF002(String f002) {
		this.f002 = f002;
	}

	public String getRoadlevel() {
		return roadlevel;
	}

	public void setRoadlevel(String roadlevel) {
		this.roadlevel = roadlevel;
	}

	public String getF070() {
		return f070;
	}

	public void setF070(String f070) {
		this.f070 = f070;
	}

	public String getFbm() {
		return fbm;
	}

	public void setFbm(String fbm) {
		this.fbm = fbm;
	}

	public String getRoadcode3() {
		return roadcode3;
	}

	public void setRoadcode3(String roadcode3) {
		this.roadcode3 = roadcode3;
	}

	public String getRoadcode2D() {
		return roadcode2D;
	}

	public void setRoadcode2D(String roadcode2d) {
		roadcode2D = roadcode2d;
	}

	public double getLxzh3() {
		return lxzh3;
	}

	public void setLxzh3(double lxzh3) {
		this.lxzh3 = lxzh3;
	}

	public double getRoadpos() {
		return roadpos;
	}

	public void setRoadpos(double roadpos) {
		this.roadpos = roadpos;
	}

	public String getRoadcodeD() {
		return roadcodeD;
	}

	public void setRoadcodeD(String roadcodeD) {
		this.roadcodeD = roadcodeD;
	}

	public String getRoadcode() {
		return roadcode;
	}

	public void setRoadcode(String roadcode) {
		this.roadcode = roadcode;
	}

	public String getQxmc() {
		return qxmc;
	}

	public void setQxmc(String qxmc) {
		this.qxmc = qxmc;
	}

	public String getDsmc() {
		return dsmc;
	}

	public void setDsmc(String dsmc) {
		this.dsmc = dsmc;
	}

	public String getTbdwbm() {
		return tbdwbm;
	}

	public void setTbdwbm(String tbdwbm) {
		this.tbdwbm = tbdwbm;
	}

	public String getJcxs() {
		return jcxs;
	}

	public void setJcxs(String jcxs) {
		this.jcxs = jcxs;
	}

	public String getXzqh() {
		return xzqh;
	}

	public void setXzqh(String xzqh) {
		this.xzqh = xzqh;
	}

	public double getRoadpos2() {
		return roadpos2;
	}

	public void setRoadpos2(double roadpos2) {
		this.roadpos2 = roadpos2;
	}

	private double mPtx;

    private String jclkzl;

    private double ptx;

    private String oId;

    private String bz;

    private String roadname;

    private Long zId;

    private String name;

    private String code;

    private double mPty;

    private String roadcode2;

    private Long sfkbj;

    private String id;

    private String gydwmc;

    private String gydwbm;

    private String f002;

    private String roadlevel;

    private String f070;

    private String fbm;

    private String roadcode3;

    private String roadcode2D;

    private double lxzh3;

    private double roadpos;

    private String roadcodeD;

    private String roadcode;

    private String qxmc;

    private String dsmc;

    private String tbdwbm;

    private String jcxs;

    private String xzqh;

    private double roadpos2;
}