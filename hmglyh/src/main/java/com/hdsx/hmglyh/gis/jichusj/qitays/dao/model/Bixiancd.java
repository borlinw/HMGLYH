package com.hdsx.hmglyh.gis.jichusj.qitays.dao.model;

/**
 * 避险车道
 * @author zhanglm
 *
 */

public class Bixiancd {
    private String id;

    private String roadcode;

    private String xzqh;

    private String roadname;

    private String pos;

    private String gydw;

    private String szrq;

    private String bz;

    private Double ptx;

    private Double pty;
    
    private int page;
    private int rows;
    
    
    

	@Override
	public String toString() {
		return "Bixiancd [id=" + id + ", roadcode=" + roadcode + ", xzqh="
				+ xzqh + ", roadname=" + roadname + ", ptx=" + ptx + ", pty="
				+ pty + "]";
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

	public String getPos() {
		return pos;
	}

	public void setPos(String pos) {
		this.pos = pos;
	}

	public String getGydw() {
		return gydw;
	}

	public void setGydw(String gydw) {
		this.gydw = gydw;
	}

	public String getSzrq() {
		return szrq;
	}

	public void setSzrq(String szrq) {
		this.szrq = szrq;
	}

	public String getBz() {
		return bz;
	}

	public void setBz(String bz) {
		this.bz = bz;
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
}