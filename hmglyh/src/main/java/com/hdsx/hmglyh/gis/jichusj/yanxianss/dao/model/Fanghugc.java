
 /**
 * 北京恒达时讯科技有限公司版权所有
 * Copyright (C) HDSX Corporation. All Rights Reserved
 */
package com.hdsx.hmglyh.gis.jichusj.yanxianss.dao.model;

import java.io.Serializable;

/**  
 *  
 * @author Baiyy
 * @created 2016年5月17日 上午10:52:41 
 */

public class Fanghugc implements Serializable {
	private static final long serialVersionUID = 5523991433536228114L;
	
	private String roadcode;		//路线编码
	private double spos;			//起点桩号
	private double epos;			//止点桩号
	//上挡板
	private String sdbleft;
	private String sdblcl;
	private String sdbright;
	private String sdbrcl;
	//下挡板
	private String xdbleft;
	private String xdblcl;
	private String xdbright;
	private String xdbrcl;
	//浆砌块石
	private String jqksleft;
	private String jqkslcl;
	private String jqksright;
	private String jqksrcl;
	//水泥混凝土护坡
	private String snhnthpleft;
	private String snhnthplcl;
	private String snhnthpright;
	private String snhnthprcl;
	//浆砌边沟
	private String jqbgleft;
	private String jqbglcl;
	private String jqbgright;
	private String jqbgrcl;
	//水泥边沟
	private String snbgleft;
	private String snbglcl;
	private String snbgright;
	private String snbgrcl;
	//铁丝笼方格护坡
	private String tslfghpleft;
	private String tslfghplcl;
	private String tslfghpright;
	private String tslfghprcl;
	//砼方格网
	private String tfgwleft;
	private String tfgwlcl;
	private String tfgwright;
	private String tfgwrcl;
	//排水沟
	private String psgleft;
	private String psglcl;
	private String psgright;
	private String psgrcl;
	//截水墙
	private String jsqleft;
	private String jsqlcl;
	private String jsqright;
	private String jsqrcl;
	//防落网
	private String fsdleft;
	private String fsdright;
	//拦水带
	private String lsdleft;
	private String lsdlcl;
	private String lsdright;
	private String lsdrcl;
	//急流槽
	private String jlcleft;
	private String jlcright;
	//位置
	private String wz;
	
	private String page;
	private String rows;
	
	private String szhh;
	private String ezhh;

	public String getSzhh() {
		return szhh;
	}

	public void setSzhh(String szhh) {
		this.szhh = szhh;
	}

	public String getEzhh() {
		return ezhh;
	}

	public void setEzhh(String ezhh) {
		this.ezhh = ezhh;
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

	public String getRoadcode() {
		return roadcode;
	}

	public void setRoadcode(String roadcode) {
		this.roadcode = roadcode;
	}

	public double getSpos() {
		return spos;
	}

	public void setSpos(double spos) {
		this.spos = spos;
	}

	public double getEpos() {
		return epos;
	}

	public void setEpos(double epos) {
		this.epos = epos;
	}

	public String getSdbleft() {
		return sdbleft;
	}

	public void setSdbleft(String sdbleft) {
		this.sdbleft = sdbleft;
	}

	public String getSdblcl() {
		return sdblcl;
	}

	public void setSdblcl(String sdblcl) {
		this.sdblcl = sdblcl;
	}

	public String getSdbright() {
		return sdbright;
	}

	public void setSdbright(String sdbright) {
		this.sdbright = sdbright;
	}

	public String getSdbrcl() {
		return sdbrcl;
	}

	public void setSdbrcl(String sdbrcl) {
		this.sdbrcl = sdbrcl;
	}

	public String getXdbleft() {
		return xdbleft;
	}

	public void setXdbleft(String xdbleft) {
		this.xdbleft = xdbleft;
	}

	public String getXdblcl() {
		return xdblcl;
	}

	public void setXdblcl(String xdblcl) {
		this.xdblcl = xdblcl;
	}

	public String getXdbright() {
		return xdbright;
	}

	public void setXdbright(String xdbright) {
		this.xdbright = xdbright;
	}

	public String getXdbrcl() {
		return xdbrcl;
	}

	public void setXdbrcl(String xdbrcl) {
		this.xdbrcl = xdbrcl;
	}

	public String getJqksleft() {
		return jqksleft;
	}

	public void setJqksleft(String jqksleft) {
		this.jqksleft = jqksleft;
	}

	public String getJqkslcl() {
		return jqkslcl;
	}

	public void setJqkslcl(String jqkslcl) {
		this.jqkslcl = jqkslcl;
	}

	public String getJqksright() {
		return jqksright;
	}

	public void setJqksright(String jqksright) {
		this.jqksright = jqksright;
	}

	public String getJqksrcl() {
		return jqksrcl;
	}

	public void setJqksrcl(String jqksrcl) {
		this.jqksrcl = jqksrcl;
	}

	public String getSnhnthpleft() {
		return snhnthpleft;
	}

	public void setSnhnthpleft(String snhnthpleft) {
		this.snhnthpleft = snhnthpleft;
	}

	public String getSnhnthplcl() {
		return snhnthplcl;
	}

	public void setSnhnthplcl(String snhnthplcl) {
		this.snhnthplcl = snhnthplcl;
	}

	public String getSnhnthpright() {
		return snhnthpright;
	}

	public void setSnhnthpright(String snhnthpright) {
		this.snhnthpright = snhnthpright;
	}

	public String getSnhnthprcl() {
		return snhnthprcl;
	}

	public void setSnhnthprcl(String snhnthprcl) {
		this.snhnthprcl = snhnthprcl;
	}

	public String getJqbgleft() {
		return jqbgleft;
	}

	public void setJqbgleft(String jqbgleft) {
		this.jqbgleft = jqbgleft;
	}

	public String getJqbglcl() {
		return jqbglcl;
	}

	public void setJqbglcl(String jqbglcl) {
		this.jqbglcl = jqbglcl;
	}

	public String getJqbgright() {
		return jqbgright;
	}

	public void setJqbgright(String jqbgright) {
		this.jqbgright = jqbgright;
	}

	public String getJqbgrcl() {
		return jqbgrcl;
	}

	public void setJqbgrcl(String jqbgrcl) {
		this.jqbgrcl = jqbgrcl;
	}

	public String getSnbgleft() {
		return snbgleft;
	}

	public void setSnbgleft(String snbgleft) {
		this.snbgleft = snbgleft;
	}

	public String getSnbglcl() {
		return snbglcl;
	}

	public void setSnbglcl(String snbglcl) {
		this.snbglcl = snbglcl;
	}

	public String getSnbgright() {
		return snbgright;
	}

	public void setSnbgright(String snbgright) {
		this.snbgright = snbgright;
	}

	public String getSnbgrcl() {
		return snbgrcl;
	}

	public void setSnbgrcl(String snbgrcl) {
		this.snbgrcl = snbgrcl;
	}

	public String getTslfghpleft() {
		return tslfghpleft;
	}

	public void setTslfghpleft(String tslfghpleft) {
		this.tslfghpleft = tslfghpleft;
	}

	public String getTslfghplcl() {
		return tslfghplcl;
	}

	public void setTslfghplcl(String tslfghplcl) {
		this.tslfghplcl = tslfghplcl;
	}

	public String getTslfghpright() {
		return tslfghpright;
	}

	public void setTslfghpright(String tslfghpright) {
		this.tslfghpright = tslfghpright;
	}

	public String getTslfghprcl() {
		return tslfghprcl;
	}

	public void setTslfghprcl(String tslfghprcl) {
		this.tslfghprcl = tslfghprcl;
	}

	public String getTfgwleft() {
		return tfgwleft;
	}

	public void setTfgwleft(String tfgwleft) {
		this.tfgwleft = tfgwleft;
	}

	public String getTfgwlcl() {
		return tfgwlcl;
	}

	public void setTfgwlcl(String tfgwlcl) {
		this.tfgwlcl = tfgwlcl;
	}

	public String getTfgwright() {
		return tfgwright;
	}

	public void setTfgwright(String tfgwright) {
		this.tfgwright = tfgwright;
	}

	public String getTfgwrcl() {
		return tfgwrcl;
	}

	public void setTfgwrcl(String tfgwrcl) {
		this.tfgwrcl = tfgwrcl;
	}

	public String getPsgleft() {
		return psgleft;
	}

	public void setPsgleft(String psgleft) {
		this.psgleft = psgleft;
	}

	public String getPsglcl() {
		return psglcl;
	}

	public void setPsglcl(String psglcl) {
		this.psglcl = psglcl;
	}

	public String getPsgright() {
		return psgright;
	}

	public void setPsgright(String psgright) {
		this.psgright = psgright;
	}

	public String getPsgrcl() {
		return psgrcl;
	}

	public void setPsgrcl(String psgrcl) {
		this.psgrcl = psgrcl;
	}

	public String getJsqleft() {
		return jsqleft;
	}

	public void setJsqleft(String jsqleft) {
		this.jsqleft = jsqleft;
	}

	public String getJsqlcl() {
		return jsqlcl;
	}

	public void setJsqlcl(String jsqlcl) {
		this.jsqlcl = jsqlcl;
	}

	public String getJsqright() {
		return jsqright;
	}

	public void setJsqright(String jsqright) {
		this.jsqright = jsqright;
	}

	public String getJsqrcl() {
		return jsqrcl;
	}

	public void setJsqrcl(String jsqrcl) {
		this.jsqrcl = jsqrcl;
	}

	public String getFsdleft() {
		return fsdleft;
	}

	public void setFsdleft(String fsdleft) {
		this.fsdleft = fsdleft;
	}

	public String getFsdright() {
		return fsdright;
	}

	public void setFsdright(String fsdright) {
		this.fsdright = fsdright;
	}

	public String getLsdleft() {
		return lsdleft;
	}

	public void setLsdleft(String lsdleft) {
		this.lsdleft = lsdleft;
	}

	public String getLsdlcl() {
		return lsdlcl;
	}

	public void setLsdlcl(String lsdlcl) {
		this.lsdlcl = lsdlcl;
	}

	public String getLsdright() {
		return lsdright;
	}

	public void setLsdright(String lsdright) {
		this.lsdright = lsdright;
	}

	public String getLsdrcl() {
		return lsdrcl;
	}

	public void setLsdrcl(String lsdrcl) {
		this.lsdrcl = lsdrcl;
	}

	public String getJlcleft() {
		return jlcleft;
	}

	public void setJlcleft(String jlcleft) {
		this.jlcleft = jlcleft;
	}

	public String getJlcright() {
		return jlcright;
	}

	public void setJlcright(String jlcright) {
		this.jlcright = jlcright;
	}

	public String getWz() {
		return wz;
	}

	public void setWz(String wz) {
		this.wz = wz;
	}

	
	

}





























