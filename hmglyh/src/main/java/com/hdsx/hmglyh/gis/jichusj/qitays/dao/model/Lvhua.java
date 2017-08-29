package com.hdsx.hmglyh.gis.jichusj.qitays.dao.model;

/**
 * 路线绿化
 * @author zhanglm
 *
 */

public class Lvhua {
    private String id;

    private String roadcode;

    private String xzqh;

    private String roadname;

    private String startzh;

    private String endzh;

    private String ldlx;

    private String lhzl;

    private String zzrq;

    private String tbdwbm;

    private String gydwbm;

    private String gydwmc;

    private String bz;

    private String dsmc;

    private String qxmc;

    private Double cId;

    private Double zId;

    private Double roadstart;

    private Double roadends;
    
    private Double ptx;

    private Double pty;
    
    private Double mPtx;
    
    private Double mPty;
    
    private String fx;
    
    private int page;
    private int rows;
    
     


	@Override
	public String toString() {
		return "Lvhua [id=" + id + ", roadcode=" + roadcode + ", xzqh=" + xzqh
				+ ", roadname=" + roadname + ", startzh=" + startzh
				+ ", endzh=" + endzh + ", ldlx=" + ldlx + ", lhzl=" + lhzl
				+ ", zzrq=" + zzrq + ", tbdwbm=" + tbdwbm + ", gydwbm="
				+ gydwbm + ", gydwmc=" + gydwmc + ", bz=" + bz + ", dsmc="
				+ dsmc + ", qxmc=" + qxmc + ", cId=" + cId + ", zId=" + zId
				+ ", roadstart=" + roadstart + ", roadends=" + roadends
				+ ", ptx=" + ptx + ", pty=" + pty + ", mPtx=" + mPtx
				+ ", mPty=" + mPty + ", fx=" + fx + ", page=" + page
				+ ", rows=" + rows + "]";
	}
	

	public Double getPtx() {
		return ptx;
	}


	public void setPtx(Double ptx) {
		this.ptx = ptx;
	}


	public Double getPty() {
		return pty;
	}


	public void setPty(Double pty) {
		this.pty = pty;
	}


	public Double getmPtx() {
		return mPtx;
	}


	public void setmPtx(Double mPtx) {
		this.mPtx = mPtx;
	}


	public Double getmPty() {
		return mPty;
	}


	public void setmPty(Double mPty) {
		this.mPty = mPty;
	}


	public String getFx() {
		return fx;
	}


	public void setFx(String fx) {
		this.fx = fx;
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

	public String getStartzh() {
		return startzh;
	}

	public void setStartzh(String startzh) {
		this.startzh = startzh;
	}

	public String getEndzh() {
		return endzh;
	}

	public void setEndzh(String endzh) {
		this.endzh = endzh;
	}

	public String getLdlx() {
		return ldlx;
	}

	public void setLdlx(String ldlx) {
		this.ldlx = ldlx;
	}

	public String getLhzl() {
		return lhzl;
	}

	public void setLhzl(String lhzl) {
		this.lhzl = lhzl;
	}

	public String getZzrq() {
		return zzrq;
	}

	public void setZzrq(String zzrq) {
		this.zzrq = zzrq;
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

	public Double getcId() {
		return cId;
	}

	public void setcId(Double cId) {
		this.cId = cId;
	}

	public Double getzId() {
		return zId;
	}

	public void setzId(Double zId) {
		this.zId = zId;
	}

	public Double getRoadstart() {
		return roadstart;
	}

	public void setRoadstart(Double roadstart) {
		this.roadstart = roadstart;
	}

	public Double getRoadends() {
		return roadends;
	}

	public void setRoadends(Double roadends) {
		this.roadends = roadends;
	}
    
    
}