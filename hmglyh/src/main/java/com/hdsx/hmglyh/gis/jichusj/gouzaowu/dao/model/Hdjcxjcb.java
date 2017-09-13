package com.hdsx.hmglyh.gis.jichusj.gouzaowu.dao.model;

import java.io.Serializable;

/**  
 * 涵洞经常性检查 htgl_hdjcxjcb
 * @author Baiyy
 * @created 2017年9月5日 下午2:24:45 
 */

public class Hdjcxjcb extends Qhjc implements Serializable{
	private static final long serialVersionUID = -8611276820473549030L;
	
	private String hdjcxjcid;		//涵洞经常性检查id
	private String roadcode;		//路线编码
	private String roadname;		//路线名称
	private double roadpos;			//桩号
	private String lx;				//类型
	
	public String getHdjcxjcid() {
		return hdjcxjcid;
	}
	public void setHdjcxjcid(String hdjcxjcid) {
		this.hdjcxjcid = hdjcxjcid;
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
	public String getLx() {
		return lx;
	}
	public void setLx(String lx) {
		this.lx = lx;
	}
	

}
