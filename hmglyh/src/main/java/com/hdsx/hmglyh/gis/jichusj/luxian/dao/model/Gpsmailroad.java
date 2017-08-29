package com.hdsx.hmglyh.gis.jichusj.luxian.dao.model;


/**
 * 路线 表  基础库 Gpsmailroad
 * @author zhanglm
 */
import java.util.Arrays;

public class Gpsmailroad {
    @Override
	public String toString() {
		return "Gpsmailroad [roadcode=" + roadcode + ", xzqh=" + xzqh
				+ ", xzdj=" + xzdj + ", roadname=" + roadname + ", gsfl="
				+ gsfl + ", qddm=" + qddm + ", startzh=" + startzh
				+ ", qdfjdlb=" + qdfjdlb + ", zddm=" + zddm + ", endzh="
				+ endzh + ", zdfjdlb=" + zdfjdlb + ", ldxz=" + ldxz + ", ldlx="
				+ ldlx + ", zdzxfl=" + zdzxfl + ", hdsl=" + hdsl + ", tbdwbm="
				+ tbdwbm + ", dsmc=" + dsmc + ", qxmc=" + qxmc + ", txlc="
				+ txlc + ", startx=" + startx + ", starty=" + starty
				+ ", gydwbm=" + gydwbm + ", endx=" + endx + ", endy=" + endy
				+ ", minx=" + minx + ", miny=" + miny + ", maxx=" + maxx
				+ ", maxy=" + maxy + ", sfkbj=" + sfkbj + ", cId=" + cId
				+ ", zId=" + zId + ", roadends=" + roadends + ", roadstart="
				+ roadstart + ", id=" + id + ", shape="
				+ Arrays.toString(shape) + "]";
	}

	private String roadcode;

    private String xzqh;

    private String xzdj;

    private String roadname;

    private String gsfl;

    private String qddm;

    private String startzh;

    private String qdfjdlb;

    private String zddm;

    private String endzh;

    private String zdfjdlb;

    private String ldxz;

    private String ldlx;

    private String zdzxfl;

    private Long hdsl;

    private String tbdwbm;

    private String dsmc;

    private String qxmc;

    private double txlc;

    private double startx;

    private double starty;

    private String gydwbm;

    private double endx;

    private double endy;

    private double minx;

    private double miny;

    private double maxx;

    private double maxy;

    private Long sfkbj;

    private Long cId;

    private Long zId;

    private double roadends;
    private double roadstart;
    private String id;
    
    private int rows;
    private int page;
    
	private byte[] shape;
	
	private String shapeStr;

	public String getShapeStr() {
		return shapeStr;
	}

	public void setShapeStr(String shapeStr) {
		this.shapeStr = shapeStr;
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

	public String getXzdj() {
		return xzdj;
	}

	public void setXzdj(String xzdj) {
		this.xzdj = xzdj;
	}

	public String getRoadname() {
		return roadname;
	}

	public void setRoadname(String roadname) {
		this.roadname = roadname;
	}

	public String getGsfl() {
		return gsfl;
	}

	public void setGsfl(String gsfl) {
		this.gsfl = gsfl;
	}

	public String getQddm() {
		return qddm;
	}

	public void setQddm(String qddm) {
		this.qddm = qddm;
	}

	public String getStartzh() {
		return startzh;
	}

	public void setStartzh(String startzh) {
		this.startzh = startzh;
	}

	public String getQdfjdlb() {
		return qdfjdlb;
	}

	public void setQdfjdlb(String qdfjdlb) {
		this.qdfjdlb = qdfjdlb;
	}

	public String getZddm() {
		return zddm;
	}

	public void setZddm(String zddm) {
		this.zddm = zddm;
	}

	public String getEndzh() {
		return endzh;
	}

	public void setEndzh(String endzh) {
		this.endzh = endzh;
	}

	public String getZdfjdlb() {
		return zdfjdlb;
	}

	public void setZdfjdlb(String zdfjdlb) {
		this.zdfjdlb = zdfjdlb;
	}

	public String getLdxz() {
		return ldxz;
	}

	public void setLdxz(String ldxz) {
		this.ldxz = ldxz;
	}

	public String getLdlx() {
		return ldlx;
	}

	public void setLdlx(String ldlx) {
		this.ldlx = ldlx;
	}

	public String getZdzxfl() {
		return zdzxfl;
	}

	public void setZdzxfl(String zdzxfl) {
		this.zdzxfl = zdzxfl;
	}

	public Long getHdsl() {
		return hdsl;
	}

	public void setHdsl(Long hdsl) {
		this.hdsl = hdsl;
	}

	public String getTbdwbm() {
		return tbdwbm;
	}

	public void setTbdwbm(String tbdwbm) {
		this.tbdwbm = tbdwbm;
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

	public double getTxlc() {
		return txlc;
	}

	public void setTxlc(double txlc) {
		this.txlc = txlc;
	}

	public double getStartx() {
		return startx;
	}

	public void setStartx(double startx) {
		this.startx = startx;
	}

	public double getStarty() {
		return starty;
	}

	public void setStarty(double starty) {
		this.starty = starty;
	}

	public String getGydwbm() {
		return gydwbm;
	}

	public void setGydwbm(String gydwbm) {
		this.gydwbm = gydwbm;
	}

	public double getEndx() {
		return endx;
	}

	public void setEndx(double endx) {
		this.endx = endx;
	}

	public double getEndy() {
		return endy;
	}

	public void setEndy(double endy) {
		this.endy = endy;
	}

	public double getMinx() {
		return minx;
	}

	public void setMinx(double minx) {
		this.minx = minx;
	}

	public double getMiny() {
		return miny;
	}

	public void setMiny(double miny) {
		this.miny = miny;
	}

	public double getMaxx() {
		return maxx;
	}

	public void setMaxx(double maxx) {
		this.maxx = maxx;
	}

	public double getMaxy() {
		return maxy;
	}

	public void setMaxy(double maxy) {
		this.maxy = maxy;
	}

	public Long getSfkbj() {
		return sfkbj;
	}

	public void setSfkbj(Long sfkbj) {
		this.sfkbj = sfkbj;
	}

	public Long getcId() {
		return cId;
	}

	public void setcId(Long cId) {
		this.cId = cId;
	}

	public Long getzId() {
		return zId;
	}

	public void setzId(Long zId) {
		this.zId = zId;
	}

	public double getRoadends() {
		return roadends;
	}

	public void setRoadends(double roadends) {
		this.roadends = roadends;
	}

	public double getRoadstart() {
		return roadstart;
	}

	public void setRoadstart(double roadstart) {
		this.roadstart = roadstart;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public byte[] getShape() {
		return shape;
	}

	public void setShape(byte[] shape) {
		this.shape = shape;
	}
	
	

  
}