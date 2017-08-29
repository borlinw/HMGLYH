/**
 * 北京恒达时讯科技有限公司版权所有
 * Copyright (C) HDSX Corporation. All Rights Reserved
 */
package com.hdsx.hmglyh.basicData.bean;

import java.io.Serializable;

/**  
 *  
 * @author Baiyy
 * @created 2015年5月27日 下午3:01:34 
 */

public class GpsRoad implements Serializable {
	private static final long serialVersionUID = 6060577982129675288L;
	
	private String roadCode;
	private double roadStart;
	private double roadEnds;

	private int lmlx;
	private int isgs;
	private double lmkd;
	public String getRoadCode() {
		return roadCode;
	}
	public void setRoadCode(String roadCode) {
		this.roadCode = roadCode;
	}
	public double getRoadStart() {
		return roadStart;
	}
	public void setRoadStart(double roadStart) {
		this.roadStart = roadStart;
	}
	public double getRoadEnds() {
		return roadEnds;
	}
	public void setRoadEnds(double roadEnds) {
		this.roadEnds = roadEnds;
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
	public double getLmkd() {
		return lmkd;
	}
	public void setLmkd(double lmkd) {
		this.lmkd = lmkd;
	}
	
}
