package com.hdsx.hmglyh.gis.jichusj.yingjiqx.dao.model;

/**
 * 应急保障点
 * @author zhanglm
 *
 */

public class Yingjibzd {
    private String id;

    private String roadcode;

    private String xzqh;

    private String roadname;

    private String pos;

    private String yjwzlx;

    private String gydw;

    private String szrq;

    private String bz;

    private Double ptx;

    private Double pty;
    
    private String fx;
    
    private String yhdw;
    
    private String code;
    
    private String name;
    
    private String dz;
    
    private double zdmj;
    
    private double jzmj;
    
    private String yjcljx;
    
    private String fzr;
    
    private String lxdh;
    
    // 非持久化字段
    private int page;
    private int rows;
    
    private String bmcode;
    private double startzh;
    private double endzh;
    
	public String getFx() {
		return fx;
	}
	public void setFx(String fx) {
		this.fx = fx;
	}
	public String getYhdw() {
		return yhdw;
	}
	public void setYhdw(String yhdw) {
		this.yhdw = yhdw;
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
	public String getDz() {
		return dz;
	}
	public void setDz(String dz) {
		this.dz = dz;
	}
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
	public String getYjcljx() {
		return yjcljx;
	}
	public void setYjcljx(String yjcljx) {
		this.yjcljx = yjcljx;
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
		return "Yingjibzd [id=" + id + ", roadcode=" + roadcode + ", xzqh="
				+ xzqh + ", roadname=" + roadname + ", pos=" + pos
				+ ", yjwzlx=" + yjwzlx + ", gydw=" + gydw + ", szrq=" + szrq
				+ ", bz=" + bz + ", ptx=" + ptx + ", pty=" + pty + ", fx=" + fx
				+ ", yhdw=" + yhdw + ", page=" + page + ", rows=" + rows + "]";
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

	public String getYjwzlx() {
		return yjwzlx;
	}

	public void setYjwzlx(String yjwzlx) {
		this.yjwzlx = yjwzlx;
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