package com.hdsx.hmglyh.gis.jichusj.yanxianss.dao.model;
/**
 * 交通标志 jiaotongbiaozhi
 * @author zhanglm
 *
 */
public class Jiaotongbz {
    private String id;

    private String roadcode;

    private String xzqh;

    private String roadname;

    private String pos;

    private String sswz;

    private String bzlb;

    private String szrq;

    private String gydw;

    private String bz;

    private double ptx;

    private double pty;
    
    private String fx;
    
    private String bmcc;
    private String bznr;
    private String zcxs;
    
    private int page;
    private int rows;
    
    // 非持久化 字段
    private double startzh;
    private double endzh;
    private String bmcode;
     
	public String getBmcc() {
		return bmcc;
	}

	public void setBmcc(String bmcc) {
		this.bmcc = bmcc;
	}

	public String getBznr() {
		return bznr;
	}

	public void setBznr(String bznr) {
		this.bznr = bznr;
	}

	public String getZcxs() {
		return zcxs;
	}

	public void setZcxs(String zcxs) {
		this.zcxs = zcxs;
	}

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
		return "Jiaotongbz [id=" + id + ", roadcode=" + roadcode + ", xzqh="
				+ xzqh + ", roadname=" + roadname + ", ptx=" + ptx + ", pty="
				+ pty + "]";
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

	public String getPos() {
		return pos;
	}

	public void setPos(String pos) {
		this.pos = pos;
	}

	public String getSswz() {
		return sswz;
	}

	public void setSswz(String sswz) {
		this.sswz = sswz;
	}

	public String getBzlb() {
		return bzlb;
	}

	public void setBzlb(String bzlb) {
		this.bzlb = bzlb;
	}

	public String getSzrq() {
		return szrq;
	}

	public void setSzrq(String szrq) {
		this.szrq = szrq;
	}

	public String getGydw() {
		return gydw;
	}

	public void setGydw(String gydw) {
		this.gydw = gydw;
	}

	public String getBz() {
		return bz;
	}

	public void setBz(String bz) {
		this.bz = bz;
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
}