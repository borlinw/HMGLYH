package com.hdsx.hmglyh.gis.jichusj.gouzaowu.dao.model;

import java.io.Serializable;

/**  
 * 桥梁定期检查部件缺损图片表 htgl_qldqjc_bjqstpb
 * @author Baiyy
 * @created 2017年9月6日 上午12:33:27 
 */

public class Qlbjqstpb implements Serializable {
	private static final long serialVersionUID = -1546280446668919136L;
	
	private String id;				//id
	private String qldqjcid;		//桥梁定期检查id
	private String tpbm;			//图片编码
	private String tpms;			//图片描述
	private String cfdz;			//存放地址
	private String fjmc;			//附件名称
	
	public String getFjmc() {
		return fjmc;
	}
	public void setFjmc(String fjmc) {
		this.fjmc = fjmc;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getQldqjcid() {
		return qldqjcid;
	}
	public void setQldqjcid(String qldqjcid) {
		this.qldqjcid = qldqjcid;
	}
	public String getTpbm() {
		return tpbm;
	}
	public void setTpbm(String tpbm) {
		this.tpbm = tpbm;
	}
	public String getTpms() {
		return tpms;
	}
	public void setTpms(String tpms) {
		this.tpms = tpms;
	}
	public String getCfdz() {
		return cfdz;
	}
	public void setCfdz(String cfdz) {
		this.cfdz = cfdz;
	}
	
	
}
