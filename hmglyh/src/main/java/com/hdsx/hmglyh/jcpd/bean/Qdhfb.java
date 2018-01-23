
 /**
 * 北京恒达时讯科技有限公司版权所有
 * Copyright (C) HDSX Corporation. All Rights Reserved
 */
package com.hdsx.hmglyh.jcpd.bean;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**  
 *  
 * @author Baiyy
 * @created 2015年7月5日 下午2:03:15 
 */

public class Qdhfb implements Serializable {
	private static final long serialVersionUID = -6060498263908180291L;
	private int qdid;				//区段id
	private String lxCode;			//路线编码	
	private Double szhh;			//起点桩号
	private Double ezhh;			//止点桩号
	private int cd;					//长度
	private String fx;
	private String gydw;
	private String gydwmc;
	private String bmCode;			//部门编码
	private String bmName;
	private int bbid;				//版本id
	private String sqr;				//申请人
	private String sqsj;			//申请时间
	
	private int pdbbid;				//区段划分用路况评定版本id
	private String page;		
	private String rows;
	private int dcbbid;
	
	//区段划分用
	private double pci;
	private double iri;
	private String points;
	private double length;
	
	private double jl=0;
	private double kl=0;
	private double dtlf=0;
	private double cx=0;
	private double blyb=0;
	private double cz=0;
	private double kc=0;
	private double ss=0;
	private double fy=0;
	private double xb=0;
	
	private Map<String,String> list = new HashMap<String,String>();
	
	private String jd;
	
	public String getGydwmc() {
		return gydwmc;
	}
	public void setGydwmc(String gydwmc) {
		this.gydwmc = gydwmc;
	}
	public String getGydw() {
		return gydw;
	}
	public void setGydw(String gydw) {
		this.gydw = gydw;
	}
	public int getDcbbid() {
		return dcbbid;
	}
	public void setDcbbid(int dcbbid) {
		this.dcbbid = dcbbid;
	}
	public String getJd() {
		return jd;
	}
	public void setJd(String jd) {
		this.jd = jd;
	}
	public Map<String, String> getList() {
		return list;
	}
	public void setList(Map<String, String> list) {
		this.list = list;
	}
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
	public String getFx() {
		return fx;
	}
	public void setFx(String fx) {
		this.fx = fx;
	}
	public String getBmName() {
		return bmName;
	}
	public void setBmName(String bmName) {
		this.bmName = bmName;
	}
	public double getLength() {
		return length;
	}
	public void setLength(double length) {
		this.length = length;
	}
	public int getPdbbid() {
		return pdbbid;
	}
	public void setPdbbid(int pdbbid) {
		this.pdbbid = pdbbid;
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
	public double getPci() {
		return pci;
	}
	public void setPci(double pci) {
		this.pci = pci;
	}
	public double getIri() {
		return iri;
	}
	public void setIri(double iri) {
		this.iri = iri;
	}
	public String getPoints() {
		return points;
	}
	public void setPoints(String points) {
		this.points = points;
	}
	public String getSqr() {
		return sqr;
	}
	public void setSqr(String sqr) {
		this.sqr = sqr;
	}
	public String getSqsj() {
		return sqsj;
	}
	public void setSqsj(String sqsj) {
		this.sqsj = sqsj;
	}
	public int getQdid() {
		return qdid;
	}
	public void setQdid(int qdid) {
		this.qdid = qdid;
	}
	public String getLxCode() {
		return lxCode;
	}
	public void setLxCode(String lxCode) {
		this.lxCode = lxCode;
	}
	public Double getSzhh() {
		return szhh;
	}
	public void setSzhh(Double szhh) {
		this.szhh = szhh;
	}
	public Double getEzhh() {
		return ezhh;
	}
	public void setEzhh(Double ezhh) {
		this.ezhh = ezhh;
	}
	public int getCd() {
		return cd;
	}
	public void setCd(int cd) {
		this.cd = cd;
	}
	public String getBmCode() {
		return bmCode;
	}
	public void setBmCode(String bmCode) {
		this.bmCode = bmCode;
	}
	public int getBbid() {
		return bbid;
	}
	public void setBbid(int bbid) {
		this.bbid = bbid;
	}
	@Override
	public String toString() {
		return "Qdhfb [qdid=" + qdid + ", lxCode=" + lxCode + ", szhh=" + szhh
				+ ", ezhh=" + ezhh + ", cd=" + cd + ", bmCode=" + bmCode
				+ ", bbid=" + bbid + ", sqr=" + sqr + ", sqsj=" + sqsj+"]";
	}
	
}
