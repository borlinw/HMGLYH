package com.hdsx.hmglyh.gis.jichusj.qitays.dao.model;

/**
 * 居民点
 * @author zhanglm
 *
 */

public class Jumindian {
    private String code;

    private String name;

    private String xzqh;

    private Long jmdrk;

    private String ssdx;

    private String sfgmlq;

    private String sfssmzjjq;

    private String sfpkdq;

    private String sfnlmc;

    private String sfsb;

    private String dysfjyldjtmt;

    private Double mtyldjl;

    private String dnsfjygl;

    private String tdxz;

    private String sfyjtgyl;

    private String sfsytgl;

    private String bsyyy;

    private String tbdwbm;

    private String gydwbm;

    private String gydwmc;

    private String bz;

    private String dsmc;

    private String qxmc;

    private Double ptx;

    private Double pty;

    private Long zId;

    private String id;

    private Long sfkbj;

    private Double mPtx;

    private Long cId;

    private Double mPty;
    
    private int page;
    private int rows;
    
    

	@Override
	public String toString() {
		return "Jumindian [code=" + code + ", name=" + name + ", xzqh=" + xzqh
				+ ", jmdrk=" + jmdrk + ", ptx=" + ptx + ", pty=" + pty
				+ ", id=" + id + "]";
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

	public Long getJmdrk() {
		return jmdrk;
	}

	public void setJmdrk(Long jmdrk) {
		this.jmdrk = jmdrk;
	}

	public String getSsdx() {
		return ssdx;
	}

	public void setSsdx(String ssdx) {
		this.ssdx = ssdx;
	}

	public String getSfgmlq() {
		return sfgmlq;
	}

	public void setSfgmlq(String sfgmlq) {
		this.sfgmlq = sfgmlq;
	}

	public String getSfssmzjjq() {
		return sfssmzjjq;
	}

	public void setSfssmzjjq(String sfssmzjjq) {
		this.sfssmzjjq = sfssmzjjq;
	}

	public String getSfpkdq() {
		return sfpkdq;
	}

	public void setSfpkdq(String sfpkdq) {
		this.sfpkdq = sfpkdq;
	}

	public String getSfnlmc() {
		return sfnlmc;
	}

	public void setSfnlmc(String sfnlmc) {
		this.sfnlmc = sfnlmc;
	}

	public String getSfsb() {
		return sfsb;
	}

	public void setSfsb(String sfsb) {
		this.sfsb = sfsb;
	}

	public String getDysfjyldjtmt() {
		return dysfjyldjtmt;
	}

	public void setDysfjyldjtmt(String dysfjyldjtmt) {
		this.dysfjyldjtmt = dysfjyldjtmt;
	}

	public Double getMtyldjl() {
		return mtyldjl;
	}

	public void setMtyldjl(Double mtyldjl) {
		this.mtyldjl = mtyldjl;
	}

	public String getDnsfjygl() {
		return dnsfjygl;
	}

	public void setDnsfjygl(String dnsfjygl) {
		this.dnsfjygl = dnsfjygl;
	}

	public String getTdxz() {
		return tdxz;
	}

	public void setTdxz(String tdxz) {
		this.tdxz = tdxz;
	}

	public String getSfyjtgyl() {
		return sfyjtgyl;
	}

	public void setSfyjtgyl(String sfyjtgyl) {
		this.sfyjtgyl = sfyjtgyl;
	}

	public String getSfsytgl() {
		return sfsytgl;
	}

	public void setSfsytgl(String sfsytgl) {
		this.sfsytgl = sfsytgl;
	}

	public String getBsyyy() {
		return bsyyy;
	}

	public void setBsyyy(String bsyyy) {
		this.bsyyy = bsyyy;
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

	public Double getmPtx() {
		return mPtx;
	}

	public void setmPtx(Double mPtx) {
		this.mPtx = mPtx;
	}

	public Long getcId() {
		return cId;
	}

	public void setcId(Long cId) {
		this.cId = cId;
	}

	public Double getmPty() {
		return mPty;
	}

	public void setmPty(Double mPty) {
		this.mPty = mPty;
	}
}