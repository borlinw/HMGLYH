package com.hdsx.hmglyh.gis.jichusj.gouzaowu.dao.model;

import java.io.Serializable;
import java.util.Date;

/**  
 * 涵洞定期检查htgl_hddqjcb
 * @author Baiyy
 * @created 2017年9月5日 下午8:46:44 
 */

public class Hddqjcb extends Qhjc implements Serializable {
	private static final long serialVersionUID = 1702306658769506744L;
	
	private String hddqjcid;			//涵洞定期检查id
	private String roadcode;			//路线编码
	private String roadname;			//路线名称
	private double roadpos;				//桩号
	private String gydw;				//管养单位
	private String hdlx;				//涵洞类型
	private String hdjszk;				//涵洞技术状况
	private String yhfa;				//养护方案
	private Date xcjcsj;				//下次检查时间
	private String yhfazs;				//养护方案综述
	private String zgfzr;				//主管负责人
	private String jcr;					//检查人
	
	public String getHddqjcid() {
		return hddqjcid;
	}
	public void setHddqjcid(String hddqjcid) {
		this.hddqjcid = hddqjcid;
	}
	public String getRoadcode() {
		return roadcode;
	}
	public void setRoadcode(String roadcode) {
		this.roadcode = roadcode;
	}
	public String getRoadname() {
		return roadname;
	}
	public void setRoadname(String roadname) {
		this.roadname = roadname;
	}
	public double getRoadpos() {
		return roadpos;
	}
	public void setRoadpos(double roadpos) {
		this.roadpos = roadpos;
	}
	public String getGydw() {
		return gydw;
	}
	public void setGydw(String gydw) {
		this.gydw = gydw;
	}
	public String getHdlx() {
		return hdlx;
	}
	public void setHdlx(String hdlx) {
		this.hdlx = hdlx;
	}
	public String getHdjszk() {
		return hdjszk;
	}
	public void setHdjszk(String hdjszk) {
		this.hdjszk = hdjszk;
	}
	public String getYhfa() {
		return yhfa;
	}
	public void setYhfa(String yhfa) {
		this.yhfa = yhfa;
	}
	public Date getXcjcsj() {
		return xcjcsj;
	}
	public void setXcjcsj(Date xcjcsj) {
		this.xcjcsj = xcjcsj;
	}
	public String getYhfazs() {
		return yhfazs;
	}
	public void setYhfazs(String yhfazs) {
		this.yhfazs = yhfazs;
	}
	public String getZgfzr() {
		return zgfzr;
	}
	public void setZgfzr(String zgfzr) {
		this.zgfzr = zgfzr;
	}
	public String getJcr() {
		return jcr;
	}
	public void setJcr(String jcr) {
		this.jcr = jcr;
	}
	
	
	
	
}
