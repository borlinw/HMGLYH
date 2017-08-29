package com.hdsx.hmglyh.gis.jichusj.qitays.dao.model;

/**
 * 旅游景点
 * @author zhanglm
 *
 */

public class Lvyoujd {
    private String id;

    private String code;

    private String name;

    private String xzqh;

    private String sfhsjq;

    private String tdgldm;

    private String tbdwbm;

    private String gydwbm;

    private String gydwmc;

    private String bz;

    private String dsmc;

    private String qxmc;

    private Double ptx;

    private Double pty;

    private Double mPtx;

    private Double mPty;

    private Double cId;

    private Double zId;

    private Double sfkbj;
    
    private int page;
    private int rows;
    
    

	@Override
	public String toString() {
		return "Lvyoujd [id=" + id + ", code=" + code + ", name=" + name
				+ ", xzqh=" + xzqh + ", ptx=" + ptx + ", pty=" + pty + "]";
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

	public String getXzqh() {
		return xzqh;
	}

	public void setXzqh(String xzqh) {
		this.xzqh = xzqh;
	}

	public String getSfhsjq() {
		return sfhsjq;
	}

	public void setSfhsjq(String sfhsjq) {
		this.sfhsjq = sfhsjq;
	}

	public String getTdgldm() {
		return tdgldm;
	}

	public void setTdgldm(String tdgldm) {
		this.tdgldm = tdgldm;
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

	public Double getSfkbj() {
		return sfkbj;
	}

	public void setSfkbj(Double sfkbj) {
		this.sfkbj = sfkbj;
	}
    
    
}