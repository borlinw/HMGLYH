package com.hdsx.hmglyh.gis.jichusj.luxian.dao.model;
/**
 * 路段表  基础库  GPSROAD
 * @author zhanglm
 *
 */
public class Luduan {
    @Override
	public String toString() {
		return "Luduan [roadcode=" + roadcode + ", xzqh=" + xzqh
				+ ", roadname=" + roadname + ", startzh=" + startzh
				+ ", endzh=" + endzh + ", ldlx=" + ldlx + ", jsdj=" + jsdj
				+ ", cdtz=" + cdtz + "]";
	}

	private String roadcode;

    private String xzqh;

    private String roadname;

    private String gsfl;

    private String xzbm;

    private String xzmc;

    private String qddm;

    private String reRoadcode;

    private String startzh;

    private String qdfjdlb;

    private String reStartzh;

    private String zddm;

    private String reEndzh;

    private String endzh;

    private String zdfjdlb;

    private double zslc;

    private String ldlx;

    private String zdzxfl;

    private String zdbm;

    private String zdmc;

    private String ldxz;

    private String jcsj;

    private String gjsj;

    private String jsxz;

    private String gbm;

    private String dm;

    private String sfxz;

    private String sssfz;

    private String sfyfgs;

    private String sfqytc;

    private String sfcgld;

    private Long hdsl;

    private String jsdj;

    private String lmlx;

    private double lmkd;

    private double ljkd;

    private String cdtz;

    private double sjss;

    private String lzgldw;

    private String lyqk;

    private String dllx;

    private String lyzj;

    private String yhsj;

    private String tbdwbm;

    private String gydwbm;

    private String gydwmc;

    private String gydwfl;

    private String bgyy;

    private String bgsj;

    private String bz;

    private String dsmc;

    private String qxmc;

    private double txlc;

    private double startx;

    private double starty;

    private double endx;

    private double endy;

    private double maxx;

    private double klh;

    private Long zId;

    private String reId;

    private String xzdj;

    private Long cId;

    private double ylh;

    private double maxy;

    private double roadstart;

    private double roadends;

    private String sfnlczy;

    private String sfcfld;

    private Long sfkbj;

    private String id;

    private double minx;

    private byte[] shape;
    private int page;
    private int rows;
    

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

	public String getGsfl() {
		return gsfl;
	}

	public void setGsfl(String gsfl) {
		this.gsfl = gsfl;
	}

	public String getXzbm() {
		return xzbm;
	}

	public void setXzbm(String xzbm) {
		this.xzbm = xzbm;
	}

	public String getXzmc() {
		return xzmc;
	}

	public void setXzmc(String xzmc) {
		this.xzmc = xzmc;
	}

	public String getQddm() {
		return qddm;
	}

	public void setQddm(String qddm) {
		this.qddm = qddm;
	}

	public String getReRoadcode() {
		return reRoadcode;
	}

	public void setReRoadcode(String reRoadcode) {
		this.reRoadcode = reRoadcode;
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

	public String getReStartzh() {
		return reStartzh;
	}

	public void setReStartzh(String reStartzh) {
		this.reStartzh = reStartzh;
	}

	public String getZddm() {
		return zddm;
	}

	public void setZddm(String zddm) {
		this.zddm = zddm;
	}

	public String getReEndzh() {
		return reEndzh;
	}

	public void setReEndzh(String reEndzh) {
		this.reEndzh = reEndzh;
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

	public double getZslc() {
		return zslc;
	}

	public void setZslc(double zslc) {
		this.zslc = zslc;
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

	public String getZdbm() {
		return zdbm;
	}

	public void setZdbm(String zdbm) {
		this.zdbm = zdbm;
	}

	public String getZdmc() {
		return zdmc;
	}

	public void setZdmc(String zdmc) {
		this.zdmc = zdmc;
	}

	public String getLdxz() {
		return ldxz;
	}

	public void setLdxz(String ldxz) {
		this.ldxz = ldxz;
	}

	public String getJcsj() {
		return jcsj;
	}

	public void setJcsj(String jcsj) {
		this.jcsj = jcsj;
	}

	public String getGjsj() {
		return gjsj;
	}

	public void setGjsj(String gjsj) {
		this.gjsj = gjsj;
	}

	public String getJsxz() {
		return jsxz;
	}

	public void setJsxz(String jsxz) {
		this.jsxz = jsxz;
	}

	public String getGbm() {
		return gbm;
	}

	public void setGbm(String gbm) {
		this.gbm = gbm;
	}

	public String getDm() {
		return dm;
	}

	public void setDm(String dm) {
		this.dm = dm;
	}

	public String getSfxz() {
		return sfxz;
	}

	public void setSfxz(String sfxz) {
		this.sfxz = sfxz;
	}

	public String getSssfz() {
		return sssfz;
	}

	public void setSssfz(String sssfz) {
		this.sssfz = sssfz;
	}

	public String getSfyfgs() {
		return sfyfgs;
	}

	public void setSfyfgs(String sfyfgs) {
		this.sfyfgs = sfyfgs;
	}

	public String getSfqytc() {
		return sfqytc;
	}

	public void setSfqytc(String sfqytc) {
		this.sfqytc = sfqytc;
	}

	public String getSfcgld() {
		return sfcgld;
	}

	public void setSfcgld(String sfcgld) {
		this.sfcgld = sfcgld;
	}

	public Long getHdsl() {
		return hdsl;
	}

	public void setHdsl(Long hdsl) {
		this.hdsl = hdsl;
	}

	public String getJsdj() {
		return jsdj;
	}

	public void setJsdj(String jsdj) {
		this.jsdj = jsdj;
	}

	public String getLmlx() {
		return lmlx;
	}

	public void setLmlx(String lmlx) {
		this.lmlx = lmlx;
	}

	public double getLmkd() {
		return lmkd;
	}

	public void setLmkd(double lmkd) {
		this.lmkd = lmkd;
	}

	public double getLjkd() {
		return ljkd;
	}

	public void setLjkd(double ljkd) {
		this.ljkd = ljkd;
	}

	public String getCdtz() {
		return cdtz;
	}

	public void setCdtz(String cdtz) {
		this.cdtz = cdtz;
	}

	public double getSjss() {
		return sjss;
	}

	public void setSjss(double sjss) {
		this.sjss = sjss;
	}

	public String getLzgldw() {
		return lzgldw;
	}

	public void setLzgldw(String lzgldw) {
		this.lzgldw = lzgldw;
	}

	public String getLyqk() {
		return lyqk;
	}

	public void setLyqk(String lyqk) {
		this.lyqk = lyqk;
	}

	public String getDllx() {
		return dllx;
	}

	public void setDllx(String dllx) {
		this.dllx = dllx;
	}

	public String getLyzj() {
		return lyzj;
	}

	public void setLyzj(String lyzj) {
		this.lyzj = lyzj;
	}

	public String getYhsj() {
		return yhsj;
	}

	public void setYhsj(String yhsj) {
		this.yhsj = yhsj;
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

	public String getGydwfl() {
		return gydwfl;
	}

	public void setGydwfl(String gydwfl) {
		this.gydwfl = gydwfl;
	}

	public String getBgyy() {
		return bgyy;
	}

	public void setBgyy(String bgyy) {
		this.bgyy = bgyy;
	}

	public String getBgsj() {
		return bgsj;
	}

	public void setBgsj(String bgsj) {
		this.bgsj = bgsj;
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

	public double getMaxx() {
		return maxx;
	}

	public void setMaxx(double maxx) {
		this.maxx = maxx;
	}

	public double getKlh() {
		return klh;
	}

	public void setKlh(double klh) {
		this.klh = klh;
	}

	public Long getzId() {
		return zId;
	}

	public void setzId(Long zId) {
		this.zId = zId;
	}

	public String getReId() {
		return reId;
	}

	public void setReId(String reId) {
		this.reId = reId;
	}

	public String getXzdj() {
		return xzdj;
	}

	public void setXzdj(String xzdj) {
		this.xzdj = xzdj;
	}

	public Long getcId() {
		return cId;
	}

	public void setcId(Long cId) {
		this.cId = cId;
	}

	public double getYlh() {
		return ylh;
	}

	public void setYlh(double ylh) {
		this.ylh = ylh;
	}

	public double getMaxy() {
		return maxy;
	}

	public void setMaxy(double maxy) {
		this.maxy = maxy;
	}

	public double getRoadstart() {
		return roadstart;
	}

	public void setRoadstart(double roadstart) {
		this.roadstart = roadstart;
	}

	public double getRoadends() {
		return roadends;
	}

	public void setRoadends(double roadends) {
		this.roadends = roadends;
	}

	public String getSfnlczy() {
		return sfnlczy;
	}

	public void setSfnlczy(String sfnlczy) {
		this.sfnlczy = sfnlczy;
	}

	public String getSfcfld() {
		return sfcfld;
	}

	public void setSfcfld(String sfcfld) {
		this.sfcfld = sfcfld;
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

	public double getMinx() {
		return minx;
	}

	public void setMinx(double minx) {
		this.minx = minx;
	}

	public byte[] getShape() {
		return shape;
	}

	public void setShape(byte[] shape) {
		this.shape = shape;
	}
}