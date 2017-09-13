package com.hdsx.hmglyh.gis.jichusj.gouzaowu.dao.model;

import java.io.Serializable;
import java.util.Date;

/**  
 * 桥梁经常性检查表  htgl_qljcxjcb
 * @author Baiyy
 * @created 2017年9月4日 下午6:44:19 
 */

public class Qljcxjcb extends Qhjc implements Serializable {
	private static final long serialVersionUID = 196859360472036348L;
	
	private String qljcxjcid;			//桥梁经常性检查id
	private String roadcode;			//路线编码
	private String roadname;			//路线名称
	private double roadpos;				//桥梁桩号
	private String qlname;				//桥梁名称
	private String gydw;				//管养单位
	private Date jcrq;
	
	public Date getJcrq() {
		return jcrq;
	}
	public void setJcrq(Date jcrq) {
		this.jcrq = jcrq;
	}
	public String getQljcxjcid() {
		return qljcxjcid;
	}
	public void setQljcxjcid(String qljcxjcid) {
		this.qljcxjcid = qljcxjcid;
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
	public String getQlname() {
		return qlname;
	}
	public void setQlname(String qlname) {
		this.qlname = qlname;
	}
	public String getGydw() {
		return gydw;
	}
	public void setGydw(String gydw) {
		this.gydw = gydw;
	}
	
	
	
}
