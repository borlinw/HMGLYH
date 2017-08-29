/**
 * 北京恒达时讯科技有限公司版权所有
 * Copyright (C) HDSX Corporation. All Rights Reserved
 */
package com.hdsx.hmglyh.jcpd.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
public class Qmldb implements Serializable {

	private static final long serialVersionUID = -1038585893737541092L;
	
	private String bmCode;
	private int ldid;			//路段id
	private String ldCode;
	private String lxCode;		//路线编码
	private String lxName;		//路线名
	private double szhh;		//起点桩号
	private double ezhh;		//止点桩号
	private int cd;				//长度
	private double lmkd;		//路面宽度
	private int bbid;			//版本编号
	private int lmlx;			//路面类型（1沥青路面，2水泥路面，3砂石路面）
	private int isgs;		//是否是高速或一级公路
	private String fx;			//方向（0301上行，0302下行，0303全幅）
	private String fxName;		
	private String ldName;		//前面路段名，类似K340-K350
	
	private String rows;
	private String page;
	
	//路况调查
	private String dcid;		//调查主表id
	private String lxid;		//调查类型id
	private int dcbbid;			//调查版本id
	private String dcsj;		//调查时间
	private String dcry;		//调查人员
	private List<Lkdcfb> lkdcfb = new ArrayList<Lkdcfb>();//路况评定附表
	private double a0;			//沥青15.00，水泥10.66，砂石10.10
	private double a1;			//沥青0.412，水泥0.461，砂石0.487
	private double pci;
	private double tci;
	private double sci;
	private double bci;
	
	//路面检测
	private String jcbbid;		//路面检测版本id
	//路面行驶质量rqi
	private double iri;
	private double rqi;
	//路面车辙rdi
	private double rd;
	private double rdi;
	//路面抗滑性能sri
	private double sfc;
	private double sri;
	//路面结构强度pssi
	private double ssi;
	private double pssi;
	private double pqi;
	private double mqi;
	
	//路况评定
	private int pdbbid;
	
	//区段划分用
	private double jl;			//龟裂
	private double kl;			//块状裂缝
	private double dtlf;		//纵、横向裂缝
	private double cx;			//沉陷
	private double blyb;		//波浪拥包
	private double cz;			//车辙
	private double kc;			//坑槽
	private double ss;			//松散
	private double fy;			//泛油
	private double xb;			//修补
	
	
	private List<Qmldb> mxbList = new ArrayList<Qmldb>();
	
	public double getJl() {
		return jl;
	}
	public void setJl(double jl) {
		this.jl = jl;
	}
	public double getKl() {
		return kl;
	}
	public void setKl(double kl) {
		this.kl = kl;
	}
	public double getDtlf() {
		return dtlf;
	}
	public void setDtlf(double dtlf) {
		this.dtlf = dtlf;
	}
	public double getCx() {
		return cx;
	}
	public void setCx(double cx) {
		this.cx = cx;
	}
	public double getBlyb() {
		return blyb;
	}
	public void setBlyb(double blyb) {
		this.blyb = blyb;
	}
	public double getCz() {
		return cz;
	}
	public void setCz(double cz) {
		this.cz = cz;
	}
	public double getKc() {
		return kc;
	}
	public void setKc(double kc) {
		this.kc = kc;
	}
	public double getSs() {
		return ss;
	}
	public void setSs(double ss) {
		this.ss = ss;
	}
	public double getFy() {
		return fy;
	}
	public void setFy(double fy) {
		this.fy = fy;
	}
	public double getXb() {
		return xb;
	}
	public void setXb(double xb) {
		this.xb = xb;
	}
	public String getLdCode() {
		return ldCode;
	}
	public void setLdCode(String ldCode) {
		this.ldCode = ldCode;
	}
	public String getBmCode() {
		return bmCode;
	}
	public void setBmCode(String bmCode) {
		this.bmCode = bmCode;
	}
	public String getLdName() {
		return ldName;
	}
	public void setLdName(String ldName) {
		this.ldName = ldName;
	}
	public List<Qmldb> getMxbList() {
		return mxbList;
	}
	public void setMxbList(List<Qmldb> mxbList) {
		this.mxbList = mxbList;
	}
	public String getFxName() {
		return fxName;
	}
	public void setFxName(String fxName) {
		this.fxName = fxName;
	}
	public double getPqi() {
		return pqi;
	}
	public void setPqi(double pqi) {
		this.pqi = pqi;
	}
	public double getMqi() {
		return mqi;
	}
	public void setMqi(double mqi) {
		this.mqi = mqi;
	}
	public int getPdbbid() {
		return pdbbid;
	}
	public void setPdbbid(int pdbbid) {
		this.pdbbid = pdbbid;
	}
	public double getPci() {
		return pci;
	}
	public void setPci(double pci) {
		this.pci = pci;
	}
	public double getTci() {
		return tci;
	}
	public void setTci(double tci) {
		this.tci = tci;
	}
	public double getSci() {
		return sci;
	}
	public void setSci(double sci) {
		this.sci = sci;
	}
	public double getBci() {
		return bci;
	}
	public void setBci(double bci) {
		this.bci = bci;
	}
	public double getA0() {
		return a0;
	}
	public void setA0(double a0) {
		this.a0 = a0;
	}
	public double getA1() {
		return a1;
	}
	public void setA1(double a1) {
		this.a1 = a1;
	}
	public double getIri() {
		return iri;
	}
	public void setIri(double iri) {
		this.iri = iri;
	}
	public double getRqi() {
		return rqi;
	}
	public void setRqi(double rqi) {
		this.rqi = rqi;
	}
	public double getRd() {
		return rd;
	}
	public void setRd(double rd) {
		this.rd = rd;
	}
	public double getRdi() {
		return rdi;
	}
	public void setRdi(double rdi) {
		this.rdi = rdi;
	}
	public double getSfc() {
		return sfc;
	}
	public void setSfc(double sfc) {
		this.sfc = sfc;
	}
	public double getSri() {
		return sri;
	}
	public void setSri(double sri) {
		this.sri = sri;
	}
	public double getSsi() {
		return ssi;
	}
	public void setSsi(double ssi) {
		this.ssi = ssi;
	}
	public double getPssi() {
		return pssi;
	}
	public void setPssi(double pssi) {
		this.pssi = pssi;
	}
	public String getJcbbid() {
		return jcbbid;
	}
	public void setJcbbid(String jcbbid) {
		this.jcbbid = jcbbid;
	}
	public String getLxName() {
		return lxName;
	}
	public void setLxName(String lxName) {
		this.lxName = lxName;
	}
	public String getDcid() {
		return dcid;
	}
	public void setDcid(String dcid) {
		this.dcid = dcid;
	}
	public String getLxid() {
		return lxid;
	}
	public void setLxid(String lxid) {
		this.lxid = lxid;
	}
	public int getDcbbid() {
		return dcbbid;
	}
	public void setDcbbid(int dcbbid) {
		this.dcbbid = dcbbid;
	}
	public String getDcsj() {
		return dcsj;
	}
	public void setDcsj(String dcsj) {
		this.dcsj = dcsj;
	}
	public String getDcry() {
		return dcry;
	}
	public void setDcry(String dcry) {
		this.dcry = dcry;
	}
	public List<Lkdcfb> getLkdcfb() {
		return lkdcfb;
	}
	public void setLkdcfb(List<Lkdcfb> lkdcfb) {
		this.lkdcfb = lkdcfb;
	}
	public String getRows() {
		return rows;
	}
	public void setRows(String rows) {
		this.rows = rows;
	}
	public String getPage() {
		return page;
	}
	public void setPage(String page) {
		this.page = page;
	}

	public int getLdid() {
		return ldid;
	}
	public void setLdid(int ldid) {
		this.ldid = ldid;
	}
	public String getLxCode() {
		return lxCode;
	}
	public void setLxCode(String lxCode) {
		this.lxCode = lxCode;
	}
	public double getSzhh() {
		return szhh;
	}
	public void setSzhh(double szhh) {
		this.szhh = szhh;
	}
	public double getEzhh() {
		return ezhh;
	}
	public void setEzhh(double ezhh) {
		this.ezhh = ezhh;
	}
	public int getCd() {
		return cd;
	}
	public void setCd(int cd) {
		this.cd = cd;
	}
	public double getLmkd() {
		return lmkd;
	}
	public void setLmkd(double lmkd) {
		this.lmkd = lmkd;
	}
	public int getBbid() {
		return bbid;
	}
	public void setBbid(int bbid) {
		this.bbid = bbid;
	}
	public int getLmlx() {
		return lmlx;
	}
	public void setLmlx(int lmlx) {
		this.lmlx = lmlx;
	}
	public int getIsgs() {
		return isgs;
	}
	public void setIsgs(int isgs) {
		this.isgs = isgs;
	}
	public String getFx() {
		return fx;
	}
	public void setFx(String fx) {
		this.fx = fx;
	}
	@Override
	public String toString() {
		return "Qmldb [ldid=" + ldid + ", lxCode=" + lxCode + ", lxName="
				+ lxName + ", szhh=" + szhh + ", ezhh=" + ezhh + ", cd=" + cd
				+ ", lmkd=" + lmkd + ", bbid=" + bbid + ", lmlx=" + lmlx
				+ ", isgs=" + isgs + ", fx=" + fx + ", rows=" + rows
				+ ", page=" + page + ", dcid=" + dcid + ", lxid=" + lxid
				+ ", dcbbid=" + dcbbid + ", dcsj=" + dcsj + ", dcry=" + dcry
				+ ", lkdcfb=" + lkdcfb + "]";
	}
}
