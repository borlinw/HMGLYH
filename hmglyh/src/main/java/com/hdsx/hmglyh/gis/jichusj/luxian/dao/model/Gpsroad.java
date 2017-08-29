package com.hdsx.hmglyh.gis.jichusj.luxian.dao.model;

import java.math.BigDecimal;
import java.util.Arrays;

public class Gpsroad {
    @Override
	public String toString() {
		return "Gpsroad [id=" + id + ", roadcode=" + roadcode + ", xzqh="
				+ xzqh + ", roadname=" + roadname + ", gsfl=" + gsfl
				+ ", xzbm=" + xzbm + ", xzmc=" + xzmc + ", qddm=" + qddm
				+ ", startzh=" + startzh + ", qdfjdlb=" + qdfjdlb + ", zddm="
				+ zddm + ", endzh=" + endzh + ", zdfjdlb=" + zdfjdlb
				+ ", zslc=" + zslc + ", ldlx=" + ldlx + ", zdzxfl=" + zdzxfl
				+ ", zdbm=" + zdbm + ", zdmc=" + zdmc + ", ldxz=" + ldxz
				+ ", jcsj=" + jcsj + ", gjsj=" + gjsj + ", jsxz=" + jsxz
				+ ", gbm=" + gbm + ", dm=" + dm + ", sfxz=" + sfxz + ", sssfz="
				+ sssfz + ", sfyfgs=" + sfyfgs + ", sfqytc=" + sfqytc
				+ ", sfcgld=" + sfcgld + ", hdsl=" + hdsl + ", jsdj=" + jsdj
				+ ", lmlx=" + lmlx + ", lmkd=" + lmkd + ", ljkd=" + ljkd
				+ ", cdtz=" + cdtz + ", sjss=" + sjss + ", lzgldw=" + lzgldw
				+ ", lyqk=" + lyqk + ", lyzj=" + lyzj + ", yhsj=" + yhsj
				+ ", tbdwbm=" + tbdwbm + ", gydwbm=" + gydwbm + ", gydwmc="
				+ gydwmc + ", gydwfl=" + gydwfl + ", bgyy=" + bgyy + ", bgsj="
				+ bgsj + ", bz=" + bz + ", dsmc=" + dsmc + ", qxmc=" + qxmc
				+ ", txlc=" + txlc + ", startx=" + startx + ", starty="
				+ starty + ", endx=" + endx + ", endy=" + endy + ", sfcfld="
				+ sfcfld + ", sfnlczy=" + sfnlczy + ", roadends=" + roadends
				+ ", roadstart=" + roadstart + ", zId=" + zId + ", sfkbj="
				+ sfkbj + ", maxx=" + maxx + ", miny=" + miny + ", cId=" + cId
				+ ", minx=" + minx + ", xzdj=" + xzdj + ", reId=" + reId
				+ ", maxy=" + maxy + ", sfmedia=" + sfmedia + ", shape="
				+ Arrays.toString(shape) + "]";
	}

	private String id;

    private String roadcode;

    private String xzqh;

    private String roadname;

    private String gsfl;

    private String xzbm;

    private String xzmc;

    private String qddm;

    private String startzh;

    private String qdfjdlb;

    private String zddm;

    private String endzh;

    private String zdfjdlb;

    private BigDecimal zslc;

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

    private BigDecimal lmkd;

    private BigDecimal ljkd;

    private String cdtz;

    private BigDecimal sjss;

    private String lzgldw;

    private String lyqk;

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

    private BigDecimal txlc;

    private BigDecimal startx;

    private BigDecimal starty;

    private BigDecimal endx;

    private BigDecimal endy;

    private String sfcfld;

    private String sfnlczy;

    private BigDecimal roadends;

    private BigDecimal roadstart;

    private String zId;

    private Long sfkbj;

    private BigDecimal maxx;

    private BigDecimal miny;

    private Long cId;

    private BigDecimal minx;

    private String xzdj;

    private String reId;

    private BigDecimal maxy;

    private String sfmedia;

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

	public BigDecimal getZslc() {
		return zslc;
	}

	public void setZslc(BigDecimal zslc) {
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

	public BigDecimal getLmkd() {
		return lmkd;
	}

	public void setLmkd(BigDecimal lmkd) {
		this.lmkd = lmkd;
	}

	public BigDecimal getLjkd() {
		return ljkd;
	}

	public void setLjkd(BigDecimal ljkd) {
		this.ljkd = ljkd;
	}

	public String getCdtz() {
		return cdtz;
	}

	public void setCdtz(String cdtz) {
		this.cdtz = cdtz;
	}

	public BigDecimal getSjss() {
		return sjss;
	}

	public void setSjss(BigDecimal sjss) {
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

	public BigDecimal getTxlc() {
		return txlc;
	}

	public void setTxlc(BigDecimal txlc) {
		this.txlc = txlc;
	}

	public BigDecimal getStartx() {
		return startx;
	}

	public void setStartx(BigDecimal startx) {
		this.startx = startx;
	}

	public BigDecimal getStarty() {
		return starty;
	}

	public void setStarty(BigDecimal starty) {
		this.starty = starty;
	}

	public BigDecimal getEndx() {
		return endx;
	}

	public void setEndx(BigDecimal endx) {
		this.endx = endx;
	}

	public BigDecimal getEndy() {
		return endy;
	}

	public void setEndy(BigDecimal endy) {
		this.endy = endy;
	}

	public String getSfcfld() {
		return sfcfld;
	}

	public void setSfcfld(String sfcfld) {
		this.sfcfld = sfcfld;
	}

	public String getSfnlczy() {
		return sfnlczy;
	}

	public void setSfnlczy(String sfnlczy) {
		this.sfnlczy = sfnlczy;
	}

	public BigDecimal getRoadends() {
		return roadends;
	}

	public void setRoadends(BigDecimal roadends) {
		this.roadends = roadends;
	}

	public BigDecimal getRoadstart() {
		return roadstart;
	}

	public void setRoadstart(BigDecimal roadstart) {
		this.roadstart = roadstart;
	}

	public String getzId() {
		return zId;
	}

	public void setzId(String zId) {
		this.zId = zId;
	}

	public Long getSfkbj() {
		return sfkbj;
	}

	public void setSfkbj(Long sfkbj) {
		this.sfkbj = sfkbj;
	}

	public BigDecimal getMaxx() {
		return maxx;
	}

	public void setMaxx(BigDecimal maxx) {
		this.maxx = maxx;
	}

	public BigDecimal getMiny() {
		return miny;
	}

	public void setMiny(BigDecimal miny) {
		this.miny = miny;
	}

	public Long getcId() {
		return cId;
	}

	public void setcId(Long cId) {
		this.cId = cId;
	}

	public BigDecimal getMinx() {
		return minx;
	}

	public void setMinx(BigDecimal minx) {
		this.minx = minx;
	}

	public String getXzdj() {
		return xzdj;
	}

	public void setXzdj(String xzdj) {
		this.xzdj = xzdj;
	}

	public String getReId() {
		return reId;
	}

	public void setReId(String reId) {
		this.reId = reId;
	}

	public BigDecimal getMaxy() {
		return maxy;
	}

	public void setMaxy(BigDecimal maxy) {
		this.maxy = maxy;
	}

	public String getSfmedia() {
		return sfmedia;
	}

	public void setSfmedia(String sfmedia) {
		this.sfmedia = sfmedia;
	}

	public byte[] getShape() {
		return shape;
	}

	public void setShape(byte[] shape) {
		this.shape = shape;
	}

	private byte[] shape;
}