package com.hdsx.hmglyh.ydjh.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class RcyhRwdjlb implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2510349367595046694L;

	private String pxcode;
	
	public String getPxcode() {
		return pxcode;
	}
	public void setPxcode(String pxcode) {
		this.pxcode = pxcode;
	}
	private String ryname;
	
	public String getRyname() {
		return ryname;
	}
	public void setRyname(String ryname) {
		this.ryname = ryname;
	}
	private String rwdid;
	
	private String rwbh;
	
	private String ssny;
	
	private Date cjtime;

    private String cjusername;

    private String bmcode;

    private String ldcode;

    private String tq;

    private String szhhkm;

    private String szhhm;

    private String ezhhkm;

    private String ezhhm;

    private String wzbc;

    private String qlcode;

    private String qlname;

    private String sdcode;

    private String sdname;

    private String hdcode;

    private String hdname;

    private String bhid;

    private String yhid;

    private String bz;

    private String grde;

    private String jhgr;

    private String rgf;

    private String clf;

    private String jxf;

    private String xfsx;

    private String rwdzt;

    private String rwdlx;
    //病害类型
	private String bhname;	//病害名称
	private String bhms;		//病害描述
	private double wxsx;		//维修时限
    //养护类型表
	private String yhname;	//养护类型名称
	private String dw;			//单位
	private String yhxmms;	//养护项目描述
	//部门表
	private String bmzscode;	//部门编码
	private String bmname;		//部门名称
	private String lxdh;			//联系电话
	private String bmlx;			//部门类型
	//工料机类型表
	private String lxid;			//类型id（010101，人工 01，材料02，机械03）
	private String lxname;	//类型名称
	private String gg;			//规格
	private int px;					//排序
	private int qyzt;	
	//工料机价格
	//材料机械消耗
	private String ssid;
	private BigDecimal sl;
	private BigDecimal dj;
	private BigDecimal je;
	 //路段表

    private String ldname;

	private String lxcode;

    private Long szhh;

    private Long ezhh;

    private Long mileage;
    //工程数量
    private String gchsl;
    //实施路段
    private String ssld;
	
	public String getGchsl() {
		return gchsl;
	}
	public void setGchsl(String gchsl) {
		this.gchsl = gchsl;
	}
	public String getSsld() {
		return ssld;
	}
	public void setSsld(String ssld) {
		this.ssld = ssld;
	}
	//分页
    private String page;
	private String rows;
	public String getRwdid() {
		return rwdid;
	}
	public void setRwdid(String rwdid) {
		this.rwdid = rwdid;
	}
	public String getRwbh() {
		return rwbh;
	}
	public void setRwbh(String rwbh) {
		this.rwbh = rwbh;
	}
	
	
	public Date getCjtime() {
		return cjtime;
	}
	public void setCjtime(Date cjtime) {
		this.cjtime = cjtime;
	}
	public String getCjusername() {
		return cjusername;
	}
	public void setCjusername(String cjusername) {
		this.cjusername = cjusername;
	}
	public String getBmcode() {
		return bmcode;
	}
	public void setBmcode(String bmcode) {
		this.bmcode = bmcode;
	}
	public String getLdcode() {
		return ldcode;
	}
	public void setLdcode(String ldcode) {
		this.ldcode = ldcode;
	}
	public String getTq() {
		return tq;
	}
	public void setTq(String tq) {
		this.tq = tq;
	}
	public String getSzhhkm() {
		return szhhkm;
	}
	public void setSzhhkm(String szhhkm) {
		this.szhhkm = szhhkm;
	}
	public String getSzhhm() {
		return szhhm;
	}
	public void setSzhhm(String szhhm) {
		this.szhhm = szhhm;
	}
	public String getEzhhkm() {
		return ezhhkm;
	}
	public void setEzhhkm(String ezhhkm) {
		this.ezhhkm = ezhhkm;
	}
	public String getEzhhm() {
		return ezhhm;
	}
	public void setEzhhm(String ezhhm) {
		this.ezhhm = ezhhm;
	}
	public String getWzbc() {
		return wzbc;
	}
	public void setWzbc(String wzbc) {
		this.wzbc = wzbc;
	}
	public String getQlcode() {
		return qlcode;
	}
	public void setQlcode(String qlcode) {
		this.qlcode = qlcode;
	}
	public String getQlname() {
		return qlname;
	}
	public void setQlname(String qlname) {
		this.qlname = qlname;
	}
	public String getSdcode() {
		return sdcode;
	}
	public void setSdcode(String sdcode) {
		this.sdcode = sdcode;
	}
	public String getSdname() {
		return sdname;
	}
	public void setSdname(String sdname) {
		this.sdname = sdname;
	}
	public String getHdcode() {
		return hdcode;
	}
	public void setHdcode(String hdcode) {
		this.hdcode = hdcode;
	}
	public String getHdname() {
		return hdname;
	}
	public void setHdname(String hdname) {
		this.hdname = hdname;
	}
	public String getBhid() {
		return bhid;
	}
	public void setBhid(String bhid) {
		this.bhid = bhid;
	}
	public String getYhid() {
		return yhid;
	}
	public void setYhid(String yhid) {
		this.yhid = yhid;
	}
	public String getBz() {
		return bz;
	}
	public void setBz(String bz) {
		this.bz = bz;
	}
	public String getGrde() {
		return grde;
	}
	public void setGrde(String grde) {
		this.grde = grde;
	}
	public String getJhgr() {
		return jhgr;
	}
	public void setJhgr(String jhgr) {
		this.jhgr = jhgr;
	}
	public String getRgf() {
		return rgf;
	}
	public void setRgf(String rgf) {
		this.rgf = rgf;
	}
	public String getClf() {
		return clf;
	}
	public void setClf(String clf) {
		this.clf = clf;
	}
	public String getJxf() {
		return jxf;
	}
	public void setJxf(String jxf) {
		this.jxf = jxf;
	}
	public String getXfsx() {
		return xfsx;
	}
	public void setXfsx(String xfsx) {
		this.xfsx = xfsx;
	}
	public String getRwdzt() {
		return rwdzt;
	}
	public void setRwdzt(String rwdzt) {
		this.rwdzt = rwdzt;
	}
	public String getRwdlx() {
		return rwdlx;
	}
	public void setRwdlx(String rwdlx) {
		this.rwdlx = rwdlx;
	}
	public String getBhname() {
		return bhname;
	}
	public void setBhname(String bhname) {
		this.bhname = bhname;
	}
	public String getBhms() {
		return bhms;
	}
	public void setBhms(String bhms) {
		this.bhms = bhms;
	}
	public double getWxsx() {
		return wxsx;
	}
	public void setWxsx(double wxsx) {
		this.wxsx = wxsx;
	}
	public String getYhname() {
		return yhname;
	}
	public void setYhname(String yhname) {
		this.yhname = yhname;
	}
	public String getDw() {
		return dw;
	}
	public void setDw(String dw) {
		this.dw = dw;
	}
	public String getYhxmms() {
		return yhxmms;
	}
	public void setYhxmms(String yhxmms) {
		this.yhxmms = yhxmms;
	}
	public String getBmzscode() {
		return bmzscode;
	}
	public void setBmzscode(String bmzscode) {
		this.bmzscode = bmzscode;
	}
	public String getBmname() {
		return bmname;
	}
	public void setBmname(String bmname) {
		this.bmname = bmname;
	}
	public String getLxdh() {
		return lxdh;
	}
	public void setLxdh(String lxdh) {
		this.lxdh = lxdh;
	}
	public String getBmlx() {
		return bmlx;
	}
	public void setBmlx(String bmlx) {
		this.bmlx = bmlx;
	}
	public String getLxid() {
		return lxid;
	}
	public void setLxid(String lxid) {
		this.lxid = lxid;
	}
	public String getLxname() {
		return lxname;
	}
	public void setLxname(String lxname) {
		this.lxname = lxname;
	}
	public String getGg() {
		return gg;
	}
	public void setGg(String gg) {
		this.gg = gg;
	}
	public int getPx() {
		return px;
	}
	public void setPx(int px) {
		this.px = px;
	}
	public int getQyzt() {
		return qyzt;
	}
	public void setQyzt(int qyzt) {
		this.qyzt = qyzt;
	}
	public String getSsid() {
		return ssid;
	}
	public void setSsid(String ssid) {
		this.ssid = ssid;
	}
	public BigDecimal getSl() {
		return sl;
	}
	public void setSl(BigDecimal sl) {
		this.sl = sl;
	}
	public BigDecimal getDj() {
		return dj;
	}
	public void setDj(BigDecimal dj) {
		this.dj = dj;
	}
	public BigDecimal getJe() {
		return je;
	}
	public void setJe(BigDecimal je) {
		this.je = je;
	}
	public String getPage() {
		return page;
	}
	public void setPage(String page) {
		this.page = page;
	}
	public String getRows() {
		return rows;
	}
	public void setRows(String rows) {
		this.rows = rows;
	}
    public String getLdname() {
		return ldname;
	}
	public void setLdname(String ldname) {
		this.ldname = ldname;
	}
	public String getLxcode() {
		return lxcode;
	}
	public void setLxcode(String lxcode) {
		this.lxcode = lxcode;
	}
	public Long getSzhh() {
		return szhh;
	}
	public void setSzhh(Long szhh) {
		this.szhh = szhh;
	}
	public Long getEzhh() {
		return ezhh;
	}
	public void setEzhh(Long ezhh) {
		this.ezhh = ezhh;
	}
	public Long getMileage() {
		return mileage;
	}
	public void setMileage(Long mileage) {
		this.mileage = mileage;
	}
	public String getSsny() {
		return ssny;
	}
	public void setSsny(String ssny) {
		this.ssny = ssny;
	}
	@Override
	public String toString() {
		return "RcyhRwdjlb [rwdid=" + rwdid + ", rwbh=" + rwbh + ", ssny="
				+ ssny + ", cjtime=" + cjtime + ", cjusername=" + cjusername
				+ ", bmcode=" + bmcode + ", ldcode=" + ldcode + ", tq=" + tq
				+ ", szhhkm=" + szhhkm + ", szhhm=" + szhhm + ", ezhhkm="
				+ ezhhkm + ", ezhhm=" + ezhhm + ", wzbc=" + wzbc + ", qlcode="
				+ qlcode + ", qlname=" + qlname + ", sdcode=" + sdcode
				+ ", sdname=" + sdname + ", hdcode=" + hdcode + ", hdname="
				+ hdname + ", bhid=" + bhid + ", yhid=" + yhid + ", bz=" + bz
				+ ", grde=" + grde + ", jhgr=" + jhgr + ", rgf=" + rgf
				+ ", clf=" + clf + ", jxf=" + jxf + ", xfsx=" + xfsx
				+ ", rwdzt=" + rwdzt + ", rwdlx=" + rwdlx + ", bhname="
				+ bhname + ", bhms=" + bhms + ", wxsx=" + wxsx + ", yhname="
				+ yhname + ", dw=" + dw + ", yhxmms=" + yhxmms + ", bmzscode="
				+ bmzscode + ", bmname=" + bmname + ", lxdh=" + lxdh
				+ ", bmlx=" + bmlx + ", lxid=" + lxid + ", lxname=" + lxname
				+ ", gg=" + gg + ", px=" + px + ", qyzt=" + qyzt + ", ssid="
				+ ssid + ", sl=" + sl + ", dj=" + dj + ", je=" + je
				+ ", ldname=" + ldname + ", lxcode=" + lxcode + ", szhh="
				+ szhh + ", ezhh=" + ezhh + ", mileage=" + mileage + ", gchsl="
				+ gchsl + ", ssld=" + ssld + ", page=" + page + ", rows="
				+ rows + "]";
	}
	
  
}