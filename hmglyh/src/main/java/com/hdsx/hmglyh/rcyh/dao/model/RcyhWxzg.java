package com.hdsx.hmglyh.rcyh.dao.model;

import java.io.Serializable;
import java.util.Date;

/**  
 *  日常养护 - 维修整改（通知单/回复单）
 * @author LiRui
 * @created 2015年6月24日 下午2:15:25 
 */

public class RcyhWxzg implements Serializable {

	private static final long serialVersionUID = -3907130031142434867L;

	//维修整改通知单
	private String tzdid;				//维修整改通知单ID
	private String tbbmcode;		//填表单位
	private String tbbmname;		//填表单位名称（显示用）
	private String tbusername;	//填表人用户名
	private String tzdxlj;				//通知单序列号
	private String sbbmcode;		//送表单位
	private String sbbmname;		//送表单位名称（显示用）
	private String wz;					//位置
	private Integer bhsl;               //病害数量
	public Integer getBhsl() {
		return bhsl;
	}
	public void setBhsl(Integer bhsl) {
		this.bhsl = bhsl;
	}
	private String yq;					//要求（立即/尽快）
	private Date sxtime;				//时限（要求完成时间）
	private String sxtimeStr;		//时限（中文格式）
	private String tbrxm;				//检查人姓名（根据填表人获取，可修改）（可充当填报人）
	private Date sdtime;				//送单时间
	private String sdtimeStr;		//送单时间（中文格式）
	private String czwt;				//存在问题
	private String zgyq;				//整改要求
	private String jdusername;	//接单人用户名（根据接单人生成，不可修改）
	private String jdrxm;				//接单人姓名（显示用）
	private Date jdtime;				//接单时间（根据首次查看时间生成，不可修改）
	private String jdtimeStr;		//时限（中文格式）
	private int tzdzt;					//通知单状态（已送出 0，已送达 1，已回复 2，整改不合格 3，返工已回复 4，整改合格 5）
	//维修整改回复单
	private String hfdid;				//维修整改回复单ID
	private String zybmcode;		//作业单位（自动获取，不可修改）
	private String zybmname;		//作业部门名称（显示用）
	private Date hfdate;				//日期（填单日期）
	private String hfdateStr;		//日期（填单日期）（中文格式）
	private Date sjwctime;			//实际完成时间
	private String sjwctimeStr;	//实际完成时间（中文格式）
	private String zgcs;				//整改措施
	private String zgjg;				//整改结果
	private String jcryj;				//检查人审核一件
	private String jcusername;		//检查人用户名
	private String jcrxm;				//检查人姓名（根据检查人获取，可修改）
	//分页
	private String page;				//分页页数（分页）
	private String rows;				//每页显示行数（分页）

	//构造方法
	public RcyhWxzg() {
		super();
	}
	//构造方法
	public RcyhWxzg(String tzdid, int tzdzt) {
		super();
		this.tzdid = tzdid;
		this.tzdzt = tzdzt;
	}

	public String getTzdid() {
		return tzdid;
	}
	public void setTzdid(String tzdid) {
		this.tzdid = tzdid;
	}
	public String getTbbmcode() {
		return tbbmcode;
	}
	public void setTbbmcode(String tbbmcode) {
		this.tbbmcode = tbbmcode;
	}
	public String getTbbmname() {
		return tbbmname;
	}
	public void setTbbmname(String tbbmname) {
		this.tbbmname = tbbmname;
	}
	public String getTbusername() {
		return tbusername;
	}
	public void setTbusername(String tbusername) {
		this.tbusername = tbusername;
	}
	public String getTzdxlj() {
		return tzdxlj;
	}
	public void setTzdxlj(String tzdxlj) {
		this.tzdxlj = tzdxlj;
	}
	public String getSbbmcode() {
		return sbbmcode;
	}
	public void setSbbmcode(String sbbmcode) {
		this.sbbmcode = sbbmcode;
	}
	public String getSbbmname() {
		return sbbmname;
	}
	public void setSbbmname(String sbbmname) {
		this.sbbmname = sbbmname;
	}
	public String getWz() {
		return wz;
	}
	public void setWz(String wz) {
		this.wz = wz;
	}
	public String getYq() {
		return yq;
	}
	public void setYq(String yq) {
		this.yq = yq;
	}
	public Date getSxtime() {
		return sxtime;
	}
	public void setSxtime(Date sxtime) {
		this.sxtime = sxtime;
	}
	public String getSxtimeStr() {
		return sxtimeStr;
	}
	public void setSxtimeStr(String sxtimeStr) {
		this.sxtimeStr = sxtimeStr;
	}
	public String getTbrxm() {
		return tbrxm;
	}
	public void setTbrxm(String tbrxm) {
		this.tbrxm = tbrxm;
	}
	public Date getSdtime() {
		return sdtime;
	}
	public void setSdtime(Date sdtime) {
		this.sdtime = sdtime;
	}
	public String getSdtimeStr() {
		return sdtimeStr;
	}
	public void setSdtimeStr(String sdtimeStr) {
		this.sdtimeStr = sdtimeStr;
	}
	public String getCzwt() {
		return czwt;
	}
	public void setCzwt(String czwt) {
		this.czwt = czwt;
	}
	public String getZgyq() {
		return zgyq;
	}
	public void setZgyq(String zgyq) {
		this.zgyq = zgyq;
	}
	public String getJdusername() {
		return jdusername;
	}
	public void setJdusername(String jdusername) {
		this.jdusername = jdusername;
	}
	public String getJdrxm() {
		return jdrxm;
	}
	public void setJdrxm(String jdrxm) {
		this.jdrxm = jdrxm;
	}
	public Date getJdtime() {
		return jdtime;
	}
	public void setJdtime(Date jdtime) {
		this.jdtime = jdtime;
	}
	public String getJdtimeStr() {
		return jdtimeStr;
	}
	public void setJdtimeStr(String jdtimeStr) {
		this.jdtimeStr = jdtimeStr;
	}
	public int getTzdzt() {
		return tzdzt;
	}
	public void setTzdzt(int tzdzt) {
		this.tzdzt = tzdzt;
	}
	public String getHfdid() {
		return hfdid;
	}
	public void setHfdid(String hfdid) {
		this.hfdid = hfdid;
	}
	public String getZybmcode() {
		return zybmcode;
	}
	public void setZybmcode(String zybmcode) {
		this.zybmcode = zybmcode;
	}
	public String getZybmname() {
		return zybmname;
	}
	public void setZybmname(String zybmname) {
		this.zybmname = zybmname;
	}
	public Date getHfdate() {
		return hfdate;
	}
	public void setHfdate(Date hfdate) {
		this.hfdate = hfdate;
	}
	public String getHfdateStr() {
		return hfdateStr;
	}
	public void setHfdateStr(String hfdateStr) {
		this.hfdateStr = hfdateStr;
	}
	public Date getSjwctime() {
		return sjwctime;
	}
	public void setSjwctime(Date sjwctime) {
		this.sjwctime = sjwctime;
	}
	public String getSjwctimeStr() {
		return sjwctimeStr;
	}
	public void setSjwctimeStr(String sjwctimeStr) {
		this.sjwctimeStr = sjwctimeStr;
	}
	public String getZgcs() {
		return zgcs;
	}
	public void setZgcs(String zgcs) {
		this.zgcs = zgcs;
	}
	public String getZgjg() {
		return zgjg;
	}
	public void setZgjg(String zgjg) {
		this.zgjg = zgjg;
	}
	public String getJcryj() {
		return jcryj;
	}
	public void setJcryj(String jcryj) {
		this.jcryj = jcryj;
	}
	public String getJcusername() {
		return jcusername;
	}
	public void setJcusername(String jcusername) {
		this.jcusername = jcusername;
	}
	public String getJcrxm() {
		return jcrxm;
	}
	public void setJcrxm(String jcrxm) {
		this.jcrxm = jcrxm;
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

}
