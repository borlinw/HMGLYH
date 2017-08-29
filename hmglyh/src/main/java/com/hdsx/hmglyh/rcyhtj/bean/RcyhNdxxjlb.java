package com.hdsx.hmglyh.rcyhtj.bean;

import java.io.OutputStream;
import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @author jason
 * 年度学习记录表
 *
 */

public class RcyhNdxxjlb implements Serializable {

	
	private static final long serialVersionUID = 4300352786987755619L;
	private String jlid; //记录ID
	private Date jldate;	//记录时间
	private String nf;		//记录年份
	private String bmcode;	//部门code
	private String jlusername;	//记录人
	private String xxnr;	//学习内容
	private String xxdd;	//学习地点
	private Date xxdate;	//学习时间	
	private String bz;	//备注
	private String bmname; //部门名称
	private String xxry; //人员
	
	public String getXxry() {
		return xxry;
	}
	public void setXxry(String xxry) {
		this.xxry = xxry;
	}
	public String getBmname() {
		return bmname;
	}
	public void setBmname(String bmname) {
		this.bmname = bmname;
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
	//分页
    private String page;
	private String rows;
	public String getJlid() {
		return jlid;
	}
	public void setJlid(String jlid) {
		this.jlid = jlid;
	}
	public Date getJldate() {
		return jldate;
	}
	public void setJldate(Date jldate) {
		this.jldate = jldate;
	}
	public String getNf() {
		return nf;
	}
	public void setNf(String nf) {
		this.nf = nf;
	}
	public String getBmcode() {
		return bmcode;
	}
	public void setBmcode(String bmcode) {
		this.bmcode = bmcode;
	}
	public String getJlusername() {
		return jlusername;
	}
	public void setJlusername(String jlusername) {
		this.jlusername = jlusername;
	}
	public String getXxnr() {
		return xxnr;
	}
	public void setXxnr(String xxnr) {
		this.xxnr = xxnr;
	}
	public String getXxdd() {
		return xxdd;
	}
	public void setXxdd(String xxdd) {
		this.xxdd = xxdd;
	}
	public Date getXxdate() {
		return xxdate;
	}
	public void setXxdate(Date xxdate) {
		this.xxdate = xxdate;
	}
	public String getBz() {
		return bz;
	}
	public void setBz(String bz) {
		this.bz = bz;
	}
}
