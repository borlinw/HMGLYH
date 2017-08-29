package com.hdsx.hmglyh.rcyh.dao.model;

import java.io.Serializable;
import java.util.Date;

/**  
 *  日常养护 - 除雪版本表 - 实体类
 *  描述：用于控制”除雪汇总表“的查询时间范围
 * @author LiRui
 * @created 2015年8月21日 下午12:49:35 
 */

public class RcyhCxbbb implements Serializable {

	private static final long serialVersionUID = 2360607023878884411L;

	private int bbid;				//版本id
	private String bbmc;		//版本名称
	private Date ssj;				//开始时间
	private String ssjStr;		//开始时间（Str：用于展示）
	private Date esj;				//结束时间
	private String esjStr;	//结束时间（Str：用于展示）
	private String zjczr;		//创建人（用户名）
	private String cjrmc;		//创建人（人员名：显示用）
	private String bmcode;	//创建用户部门（用于“查看/添加”除雪年报主/副表）
	private String page;		//分页页数（分页）
	private String rows;		//每页显示行数（分页）
	private String nbid;
	

	public String getNbid() {
		return nbid;
	}
	public void setNbid(String nbid) {
		this.nbid = nbid;
	}
	public int getBbid() {
		return bbid;
	}
	public void setBbid(int bbid) {
		this.bbid = bbid;
	}
	public String getBbmc() {
		return bbmc;
	}
	public void setBbmc(String bbmc) {
		this.bbmc = bbmc;
	}
	public Date getSsj() {
		return ssj;
	}
	public void setSsj(Date ssj) {
		this.ssj = ssj;
	}
	public Date getEsj() {
		return esj;
	}
	public void setEsj(Date esj) {
		this.esj = esj;
	}
	public String getZjczr() {
		return zjczr;
	}
	public void setZjczr(String zjczr) {
		this.zjczr = zjczr;
	}
	public String getCjrmc() {
		return cjrmc;
	}
	public void setCjrmc(String cjrmc) {
		this.cjrmc = cjrmc;
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
	public String getSsjStr() {
		return ssjStr;
	}
	public void setSsjStr(String ssjStr) {
		this.ssjStr = ssjStr;
	}
	public String getEsjStr() {
		return esjStr;
	}
	public void setEsjStr(String esjStr) {
		this.esjStr = esjStr;
	}
	public String getBmcode() {
		return bmcode;
	}
	public void setBmcode(String bmcode) {
		this.bmcode = bmcode;
	}

}
