package com.hdsx.hmglyh.gis.jichusj.qitays.dao.model;

/**
 * 学校
 * @author zhanglm
 *
 */

public class Xuexiao {
    private String code;

    private String xzqh;

    private String name;

    private String ssjzcbm;

    private String xxlx;

    private String tbdwbm;

    private String gydwbm;

    private String gydwmc;

    private String bz;

    private String dsmc;

    private String qxmc;

    private Double ptx;

    private Double pty;

    private Long cId;

    private Double mPtx;

    private Double mPty;

    private Long zId;

    private String id;

    private Long sfkbj;
    
    private int page;
    private int rows;
    
    

	@Override
	public String toString() {
		return "Xuexiao [code=" + code + ", xzqh=" + xzqh + ", name=" + name
				+ ", ptx=" + ptx + ", pty=" + pty + ", id=" + id + "]";
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

	public String getSsjzcbm() {
		return ssjzcbm;
	}

	public void setSsjzcbm(String ssjzcbm) {
		this.ssjzcbm = ssjzcbm;
	}

	public String getXxlx() {
		return xxlx;
	}

	public void setXxlx(String xxlx) {
		this.xxlx = xxlx;
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

	public Long getcId() {
		return cId;
	}

	public void setcId(Long cId) {
		this.cId = cId;
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

	public Long getSfkbj() {
		return sfkbj;
	}

	public void setSfkbj(Long sfkbj) {
		this.sfkbj = sfkbj;
	}
    
    
}