package com.hdsx.hmglyh.gis.jichusj.yanxianss.dao.model;
/**
 * 服务区
 * @author zhanglm
 *
 */

public class Fuwuqu {
    private String roadcode;

    private String code;

    private String xzqh;

    private String name;

    private String fwqlx;

    private String pos;

    private String jcnf;

    private String fwqwz;

    private String ldlx;

    private String zdbm;

    private String tbdwbm;

    private String gydwbm;

    private String gydwmc;

    private String tgzsfw;

    private String tgqcjyfw;

    private String tgqcxlfw;

    private String tgcyfw;

    private String tgtcfw;

    private String tgcsfw;

    private String fzr;

    private String lxdh;

    private String bz;

    private String dsmc;

    private String qxmc;

    private String ptx;

    private String pty;

    private String roadpos;

    private Long cId;

    private String mPtx;

    private String mPty;

    private String roadname;

    private Long zId;

    private String id;

    private String oId;

    private Long sfkbj;
    
    private double zdmj;
    
    private double jzmj;
    
    // 非持久化字段
    
    private int page;
    private int rows;
    
    private double startzh;
    private double endzh;
    private String bmcode;
    
	public double getZdmj() {
		return zdmj;
	}

	public void setZdmj(double zdmj) {
		this.zdmj = zdmj;
	}

	public double getJzmj() {
		return jzmj;
	}

	public void setJzmj(double jzmj) {
		this.jzmj = jzmj;
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



	public String getBmcode() {
		return bmcode;
	}



	public void setBmcode(String bmcode) {
		this.bmcode = bmcode;
	}



	@Override
	public String toString() {
		return "Fuwuqu [roadcode=" + roadcode + ", code=" + code + ", xzqh="
				+ xzqh + ", name=" + name + ", ptx=" + ptx + ", pty=" + pty
				+ ", id=" + id + "]";
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



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getFwqlx() {
		return fwqlx;
	}



	public void setFwqlx(String fwqlx) {
		this.fwqlx = fwqlx;
	}



	public String getPos() {
		return pos;
	}



	public void setPos(String pos) {
		this.pos = pos;
	}



	public String getJcnf() {
		return jcnf;
	}



	public void setJcnf(String jcnf) {
		this.jcnf = jcnf;
	}



	public String getFwqwz() {
		return fwqwz;
	}



	public void setFwqwz(String fwqwz) {
		this.fwqwz = fwqwz;
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



	public String getTgzsfw() {
		return tgzsfw;
	}



	public void setTgzsfw(String tgzsfw) {
		this.tgzsfw = tgzsfw;
	}



	public String getTgqcjyfw() {
		return tgqcjyfw;
	}



	public void setTgqcjyfw(String tgqcjyfw) {
		this.tgqcjyfw = tgqcjyfw;
	}



	public String getTgqcxlfw() {
		return tgqcxlfw;
	}



	public void setTgqcxlfw(String tgqcxlfw) {
		this.tgqcxlfw = tgqcxlfw;
	}



	public String getTgcyfw() {
		return tgcyfw;
	}



	public void setTgcyfw(String tgcyfw) {
		this.tgcyfw = tgcyfw;
	}



	public String getTgtcfw() {
		return tgtcfw;
	}



	public void setTgtcfw(String tgtcfw) {
		this.tgtcfw = tgtcfw;
	}



	public String getTgcsfw() {
		return tgcsfw;
	}



	public void setTgcsfw(String tgcsfw) {
		this.tgcsfw = tgcsfw;
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



	public String getPtx() {
		return ptx;
	}



	public void setPtx(String ptx) {
		this.ptx = ptx;
	}



	public String getPty() {
		return pty;
	}



	public void setPty(String pty) {
		this.pty = pty;
	}



	public String getRoadpos() {
		return roadpos;
	}



	public void setRoadpos(String roadpos) {
		this.roadpos = roadpos;
	}



	public Long getcId() {
		return cId;
	}



	public void setcId(Long cId) {
		this.cId = cId;
	}



	public String getmPtx() {
		return mPtx;
	}



	public void setmPtx(String mPtx) {
		this.mPtx = mPtx;
	}



	public String getmPty() {
		return mPty;
	}



	public void setmPty(String mPty) {
		this.mPty = mPty;
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

	
	

}