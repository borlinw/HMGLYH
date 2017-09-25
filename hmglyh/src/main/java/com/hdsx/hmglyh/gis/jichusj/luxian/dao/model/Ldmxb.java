
 /**
 * 北京恒达时讯科技有限公司版权所有
 * Copyright (C) HDSX Corporation. All Rights Reserved
 */
package com.hdsx.hmglyh.gis.jichusj.luxian.dao.model;

/**  
 *  
 * @author Baiyy
 * @created 2016年6月13日 下午6:19:29 
 */

public class Ldmxb {
	private String id;				//路段id
	private String roadcode;		//路线编号
	private String xzqh;			//行政区划
	private String xzqhname;		//行政区划名称
	private String roadname;		//路线名称
	private String startname;		//起点名称
	private String endname;			//止点名称
	private String spos;			//起点桩号
	private String epos;			//止点桩号
	private double mail;			//里程
	private String jsdj;			//路段技术等级代码
	private String jsdjname;		//路段技术等级
	private String sfyfgd;			//是否一幅高度
	private int cdsl;				//车道数量
	private String mclx;			//面层类型代码
	private String mclxmc;			//面层类型名称
	private String mchd;			//面层厚度
	private String ljkd;			//路基宽度
	private String lmkd;			//路面宽度
	private String sjss;			//设计时速
	private String xjnd;			//修建年度
	private String gjnd;			//改建年度
	private String dzxnd;			//最近一次大中修年度
	private String dllx;			//断链类型
	private String sfcgld;			//是否城管路段
	private String sddtld;			//是否断头路段
	private String ldsfxz;			//路段收费性质
	private String cfldbh;			//重复路段-路段编号
	private String cfspos;			//重复路段-起点桩号
	private String cfepos;			//重复路段-止点桩号
	private double yhlc;			//养护里程
	private double qytclc;			//晴雨通车里程
	private double klhlc;			//可绿化里程
	private double ylhlc;			//已绿化里程
	private String dmdm;			//地貌代码
	private String dmhz;			//地貌汉字
	private String hdsl;			//涵洞数量
	private String gydw;			//管养单位名称
	private String sjcrk;			//省际出入口
	private String bz;				//备注
	private String npjrjtl;			//年平均日交通量
	
	
	private String page;
	private String rows;
	private double roadends;
    private double roadstart;
    
	public String getMclx() {
		return mclx;
	}
	public void setMclx(String mclx) {
		this.mclx = mclx;
	}
	public String getMclxmc() {
		return mclxmc;
	}
	public void setMclxmc(String mclxmc) {
		this.mclxmc = mclxmc;
	}
	public String getMchd() {
		return mchd;
	}
	public void setMchd(String mchd) {
		this.mchd = mchd;
	}
	public String getNpjrjtl() {
		return npjrjtl;
	}
	public void setNpjrjtl(String npjrjtl) {
		this.npjrjtl = npjrjtl;
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
	public String getXzqhname() {
		return xzqhname;
	}
	public void setXzqhname(String xzqhname) {
		this.xzqhname = xzqhname;
	}
	public String getRoadname() {
		return roadname;
	}
	public void setRoadname(String roadname) {
		this.roadname = roadname;
	}
	public String getStartname() {
		return startname;
	}
	public void setStartname(String startname) {
		this.startname = startname;
	}
	public String getEndname() {
		return endname;
	}
	public void setEndname(String endname) {
		this.endname = endname;
	}
	public String getSpos() {
		return spos;
	}
	public void setSpos(String spos) {
		this.spos = spos;
	}
	public String getEpos() {
		return epos;
	}
	public void setEpos(String epos) {
		this.epos = epos;
	}
	public double getMail() {
		return mail;
	}
	public void setMail(double mail) {
		this.mail = mail;
	}
	public String getJsdj() {
		return jsdj;
	}
	public void setJsdj(String jsdj) {
		this.jsdj = jsdj;
	}
	public String getJsdjname() {
		return jsdjname;
	}
	public void setJsdjname(String jsdjname) {
		this.jsdjname = jsdjname;
	}
	public String getSfyfgd() {
		return sfyfgd;
	}
	public void setSfyfgd(String sfyfgd) {
		this.sfyfgd = sfyfgd;
	}
	public int getCdsl() {
		return cdsl;
	}
	public void setCdsl(int cdsl) {
		this.cdsl = cdsl;
	}
	public String getLjkd() {
		return ljkd;
	}
	public void setLjkd(String ljkd) {
		this.ljkd = ljkd;
	}
	public String getLmkd() {
		return lmkd;
	}
	public void setLmkd(String lmkd) {
		this.lmkd = lmkd;
	}
	public String getSjss() {
		return sjss;
	}
	public void setSjss(String sjss) {
		this.sjss = sjss;
	}
	public String getXjnd() {
		return xjnd;
	}
	public void setXjnd(String xjnd) {
		this.xjnd = xjnd;
	}
	public String getGjnd() {
		return gjnd;
	}
	public void setGjnd(String gjnd) {
		this.gjnd = gjnd;
	}
	public String getDzxnd() {
		return dzxnd;
	}
	public void setDzxnd(String dzxnd) {
		this.dzxnd = dzxnd;
	}
	public String getDllx() {
		return dllx;
	}
	public void setDllx(String dllx) {
		this.dllx = dllx;
	}
	public String getSfcgld() {
		return sfcgld;
	}
	public void setSfcgld(String sfcgld) {
		this.sfcgld = sfcgld;
	}
	public String getSddtld() {
		return sddtld;
	}
	public void setSddtld(String sddtld) {
		this.sddtld = sddtld;
	}
	public String getLdsfxz() {
		return ldsfxz;
	}
	public void setLdsfxz(String ldsfxz) {
		this.ldsfxz = ldsfxz;
	}
	public String getCfldbh() {
		return cfldbh;
	}
	public void setCfldbh(String cfldbh) {
		this.cfldbh = cfldbh;
	}
	public String getCfspos() {
		return cfspos;
	}
	public void setCfspos(String cfspos) {
		this.cfspos = cfspos;
	}
	public String getCfepos() {
		return cfepos;
	}
	public void setCfepos(String cfepos) {
		this.cfepos = cfepos;
	}
	public double getYhlc() {
		return yhlc;
	}
	public void setYhlc(double yhlc) {
		this.yhlc = yhlc;
	}
	public double getQytclc() {
		return qytclc;
	}
	public void setQytclc(double qytclc) {
		this.qytclc = qytclc;
	}
	public double getKlhlc() {
		return klhlc;
	}
	public void setKlhlc(double klhlc) {
		this.klhlc = klhlc;
	}
	public double getYlhlc() {
		return ylhlc;
	}
	public void setYlhlc(double ylhlc) {
		this.ylhlc = ylhlc;
	}
	public String getDmdm() {
		return dmdm;
	}
	public void setDmdm(String dmdm) {
		this.dmdm = dmdm;
	}
	public String getDmhz() {
		return dmhz;
	}
	public void setDmhz(String dmhz) {
		this.dmhz = dmhz;
	}
	public String getHdsl() {
		return hdsl;
	}
	public void setHdsl(String hdsl) {
		this.hdsl = hdsl;
	}
	public String getGydw() {
		return gydw;
	}
	public void setGydw(String gydw) {
		this.gydw = gydw;
	}
	public String getSjcrk() {
		return sjcrk;
	}
	public void setSjcrk(String sjcrk) {
		this.sjcrk = sjcrk;
	}
	public String getBz() {
		return bz;
	}
	public void setBz(String bz) {
		this.bz = bz;
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
    
    
	
}
