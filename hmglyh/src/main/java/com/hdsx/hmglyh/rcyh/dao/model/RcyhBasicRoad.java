package com.hdsx.hmglyh.rcyh.dao.model;

import java.io.Serializable;

/**  
 *  基础库的路线表 - 实体（GPSROAD）
 * @author LiRui
 * @created 2015年7月28日 下午2:39:21 
 */

public class RcyhBasicRoad implements Serializable {

	private static final long serialVersionUID = -734717933006520695L;

	private String roadcode;	//路线编码
	private String roadname;	//路线名称
	private String startzh;		//起点桩号（String）
	private String endzh;			//止点桩号（String）
	private String jsdj;				//标识所属几级公路
	private double roadstart;	//起点桩号（NUMBER(18,3)）
	private double roadends;	//止点桩号（NUMBER(18,3)）
	private double lc;				//计算出的某段路中高速公路+一级公路的总里程
	private double mj;				//计算某段路的面积，用作与除雪面积

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
	public String getStartzh() {
		return startzh;
	}
	public void setStartzh(String startzh) {
		this.startzh = startzh;
	}
	public String getEndzh() {
		return endzh;
	}
	public void setEndzh(String endzh) {
		this.endzh = endzh;
	}
	public String getJsdj() {
		return jsdj;
	}
	public void setJsdj(String jsdj) {
		this.jsdj = jsdj;
	}
	public double getRoadstart() {
		return roadstart;
	}
	public void setRoadstart(double roadstart) {
		this.roadstart = roadstart;
	}
	public double getRoadends() {
		return roadends;
	}
	public void setRoadends(double roadends) {
		this.roadends = roadends;
	}
	public double getLc() {
		return lc;
	}
	public void setLc(double lc) {
		this.lc = lc;
	}
	public double getMj() {
		return mj;
	}
	public void setMj(double mj) {
		this.mj = mj;
	}

}
