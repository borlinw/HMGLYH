package com.hdsx.hmglyh.gis.jichusj.yanxianss.dao.model;
/**
 * 检查站
 * @author zhanglm
 *
 */

public class Jianchazhan {
 
	@Override
	public String toString() {
		return "Jianchazhan [roadcode=" + roadcode + ", code=" + code
				+ ", xzqh=" + xzqh + ", roadname=" + roadname + ", name="
				+ name + ", ptx=" + ptx + ", pty=" + pty + "]";
	}

	private String roadcode;

    private String code;

    private String xzqh;

    private String roadname;

    private String name;

    private String pos;

    private String jczlx;

    private String jczwz;

    private String jcnf;

    private String ldlx;

    private String zdbm;

    private String tbdwbm;

    private String gydwbm;

    private String gydwmc;

    private String fzr;

    private String lxdh;

    private String bz;

    private String dsmc;

    private String qxmc;

    private double ptx;

    private double pty;

    private Long zId;

    private String id;

    private Long cId;

    private double mPtx;

    private double mPty;

    private String oId;

    private Long sfkbj;

    private double roadpos;
    
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

  	public String getJczlx() {
  		return jczlx;
  	}

  	public void setJczlx(String jczlx) {
  		this.jczlx = jczlx;
  	}

  	public String getJczwz() {
  		return jczwz;
  	}

  	public void setJczwz(String jczwz) {
  		this.jczwz = jczwz;
  	}

  	public String getJcnf() {
  		return jcnf;
  	}

  	public void setJcnf(String jcnf) {
  		this.jcnf = jcnf;
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

  	public String getFzr() {
  		return fzr;
  	}

  	public void setFzr(String fzr) {
  		this.fzr = fzr;
  	}

  	public String getLxdh() {
  		return lxdh;
  	}

  	public void setLxdh(String lxdh) {
  		this.lxdh = lxdh;
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