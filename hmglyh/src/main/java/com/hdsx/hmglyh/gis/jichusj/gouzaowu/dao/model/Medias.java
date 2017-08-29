package com.hdsx.hmglyh.gis.jichusj.gouzaowu.dao.model;

public class Medias {
    private Long sfkbj;

    private String id;

    private Long zId;

    private String bz;

    private String zpfx;

    private String dmtlx;

    private String txysdid;

    private String bm;

    private String zml;

    private Long cId;

    private String name;

    private String dx;

    private String zpdz;
    
    private String picUrl;
    
    

    public String getPicUrl() {
		return picUrl;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
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

    public Long getzId() {
        return zId;
    }

    public void setzId(Long zId) {
        this.zId = zId;
    }

    public String getBz() {
        return bz;
    }

    public void setBz(String bz) {
        this.bz = bz;
    }

    public String getZpfx() {
        return zpfx;
    }

    public void setZpfx(String zpfx) {
        this.zpfx = zpfx;
    }

    public String getDmtlx() {
        return dmtlx;
    }

    public void setDmtlx(String dmtlx) {
        this.dmtlx = dmtlx;
    }

    public String getTxysdid() {
        return txysdid;
    }

    public void setTxysdid(String txysdid) {
        this.txysdid = txysdid;
    }

    public String getBm() {
        return bm;
    }

    public void setBm(String bm) {
        this.bm = bm;
    }

    public String getZml() {
        return zml;
    }

    public void setZml(String zml) {
        this.zml = zml;
    }

    public Long getcId() {
        return cId;
    }

    public void setcId(Long cId) {
        this.cId = cId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDx() {
        return dx;
    }

    public void setDx(String dx) {
        this.dx = dx == null ? null : dx.trim();
    }

    public String getZpdz() {
        return zpdz;
    }

    public void setZpdz(String zpdz) {
        this.zpdz = zpdz == null ? null : zpdz.trim();
    }
}