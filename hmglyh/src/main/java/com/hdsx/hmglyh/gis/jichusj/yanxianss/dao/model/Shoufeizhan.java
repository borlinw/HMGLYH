package com.hdsx.hmglyh.gis.jichusj.yanxianss.dao.model;

/**
 * 收费站
 * @author zhanglm
 *
 */
public class Shoufeizhan {
	
	
    @Override
	public String toString() {
		return "Shoufeizhan [roadcode=" + roadcode + ", code=" + code
				+ ", xzqh=" + xzqh + ", roadname=" + roadname + ", name="
				+ name + ", ptx=" + ptx + ", pty=" + pty + ", id=" + id + "]";
	}

	private String roadcode;

    private String code;

    private String xzqh;

    private String roadname;

    private String name;

    private String pos;

    private String jcnf;

    private String sfzlx;

    private String ldlx;

    private String zdbm;

    private String pzsfwjbh;

    private String pzsfrq;

    private double pzsfnx;

    private String jssfsj;

    private Long sfcds;

    private String sfxz;

    private String sffx;

    private double yxygsfzjl;

    private double gyzcszbl;

    private Long sfjglrys;

    private double tzze;

    private double hdye;

    private double dkje;

    private double lstdjm;

    private double qtjm;

    private double nsfe;

    private double nhde;

    private double yhjfzc;

    private double qtfyzc;

    private String tbdwbm;

    private String gydwbm;

    private String gydwmc;

    private String gydwxz;

    private String fzr;

    private String lxdh;

    private String bz;

    private String dsmc;

    private String qxmc;

    private double ptx;

    private double pty;

    private String oId;

    private String id;

    private double roadpos;
    
    private Long cId;

    private Long zId;

    private double mPty;

    private double mPtx;
   
    private Long sfkbj;
    
    private double zdmj;
    
    private double jzmj;
    
    // 非 持久化字段
    private int page;
    private int rows;
    
    private String bmcode;
    private double startzh;
    private double endzh;
    
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

	public String getRoadname() {
		return roadname;
	}

	public void setRoadname(String roadname) {
		this.roadname = roadname;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPos() {
		return pos;
	}

	public void setPos(String pos) {
		this.pos = pos;
	}

	public String getJcnf() {
		return jcnf;
	}

	public void setJcnf(String jcnf) {
		this.jcnf = jcnf;
	}

	public String getSfzlx() {
		return sfzlx;
	}

	public void setSfzlx(String sfzlx) {
		this.sfzlx = sfzlx;
	}

	public String getLdlx() {
		return ldlx;
	}

	public void setLdlx(String ldlx) {
		this.ldlx = ldlx;
	}

	public String getZdbm() {
		return zdbm;
	}

	public void setZdbm(String zdbm) {
		this.zdbm = zdbm;
	}

	public String getPzsfwjbh() {
		return pzsfwjbh;
	}

	public void setPzsfwjbh(String pzsfwjbh) {
		this.pzsfwjbh = pzsfwjbh;
	}

	public String getPzsfrq() {
		return pzsfrq;
	}

	public void setPzsfrq(String pzsfrq) {
		this.pzsfrq = pzsfrq;
	}

	public double getPzsfnx() {
		return pzsfnx;
	}

	public void setPzsfnx(double pzsfnx) {
		this.pzsfnx = pzsfnx;
	}

	public String getJssfsj() {
		return jssfsj;
	}

	public void setJssfsj(String jssfsj) {
		this.jssfsj = jssfsj;
	}

	public Long getSfcds() {
		return sfcds;
	}

	public void setSfcds(Long sfcds) {
		this.sfcds = sfcds;
	}

	public String getSfxz() {
		return sfxz;
	}

	public void setSfxz(String sfxz) {
		this.sfxz = sfxz;
	}

	public String getSffx() {
		return sffx;
	}

	public void setSffx(String sffx) {
		this.sffx = sffx;
	}

	public double getYxygsfzjl() {
		return yxygsfzjl;
	}

	public void setYxygsfzjl(double yxygsfzjl) {
		this.yxygsfzjl = yxygsfzjl;
	}

	public double getGyzcszbl() {
		return gyzcszbl;
	}

	public void setGyzcszbl(double gyzcszbl) {
		this.gyzcszbl = gyzcszbl;
	}

	public Long getSfjglrys() {
		return sfjglrys;
	}

	public void setSfjglrys(Long sfjglrys) {
		this.sfjglrys = sfjglrys;
	}

	public double getTzze() {
		return tzze;
	}

	public void setTzze(double tzze) {
		this.tzze = tzze;
	}

	public double getHdye() {
		return hdye;
	}

	public void setHdye(double hdye) {
		this.hdye = hdye;
	}

	public double getDkje() {
		return dkje;
	}

	public void setDkje(double dkje) {
		this.dkje = dkje;
	}

	public double getLstdjm() {
		return lstdjm;
	}

	public void setLstdjm(double lstdjm) {
		this.lstdjm = lstdjm;
	}

	public double getQtjm() {
		return qtjm;
	}

	public void setQtjm(double qtjm) {
		this.qtjm = qtjm;
	}

	public double getNsfe() {
		return nsfe;
	}

	public void setNsfe(double nsfe) {
		this.nsfe = nsfe;
	}

	public double getNhde() {
		return nhde;
	}

	public void setNhde(double nhde) {
		this.nhde = nhde;
	}

	public double getYhjfzc() {
		return yhjfzc;
	}

	public void setYhjfzc(double yhjfzc) {
		this.yhjfzc = yhjfzc;
	}

	public double getQtfyzc() {
		return qtfyzc;
	}

	public void setQtfyzc(double qtfyzc) {
		this.qtfyzc = qtfyzc;
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

	public String getGydwxz() {
		return gydwxz;
	}

	public void setGydwxz(String gydwxz) {
		this.gydwxz = gydwxz;
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

	public String getoId() {
		return oId;
	}

	public void setoId(String oId) {
		this.oId = oId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public double getRoadpos() {
		return roadpos;
	}

	public void setRoadpos(double roadpos) {
		this.roadpos = roadpos;
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

	public double getmPty() {
		return mPty;
	}

	public void setmPty(double mPty) {
		this.mPty = mPty;
	}

	public double getmPtx() {
		return mPtx;
	}

	public void setmPtx(double mPtx) {
		this.mPtx = mPtx;
	}

	public Long getSfkbj() {
		return sfkbj;
	}

	public void setSfkbj(Long sfkbj) {
		this.sfkbj = sfkbj;
	}

   
}