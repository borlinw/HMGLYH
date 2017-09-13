package com.hdsx.hmglyh.gis.jichusj.gouzaowu.dao.model;

import java.io.Serializable;
import java.util.Date;

/**  
 * 桥梁定期检查表  htgl_qldqjcb
 * @author Baiyy
 * @created 2017年9月4日 下午4:48:43 
 */

public class Qldqjcb extends Qhjc implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String qldqjcid;		//id
	private String roadcode;		//路线编码
	private String roadname;		//路线名称
	private double roadpos;			//桥位桩号
	private String qlname;			//桥梁名称
	private String xctdm;			//下穿通道名
	private double qc;				//桥长
	private String zkjg;			//主跨结构
	private double zdkj;			//最大跨径
	private String gydw;			//管养单位
	private String jcny;			//建成年月
	private Date scdzxrq;			//上次大中修日期
	private Date scjcrq;			//上次检查日期
	private Date bcjcrq;			//本次检查日期
	private String qh;				//气候
	private String ztzkpddj;		//总体状况评定等级
	private double qlqjzkpf;		//桥梁清洁状况评分
	private double byxxzkpf;		//保养、小修状况评分
	private String jcxyhjy;			//经常性养护建议
	private Date xcjcsj;			//下次检查时间
	private String qssm;			//缺损说明
	
	public String getQldqjcid() {
		return qldqjcid;
	}
	public void setQldqjcid(String qldqjcid) {
		this.qldqjcid = qldqjcid;
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
	public String getXctdm() {
		return xctdm;
	}
	public void setXctdm(String xctdm) {
		this.xctdm = xctdm;
	}
	public double getQc() {
		return qc;
	}
	public void setQc(double qc) {
		this.qc = qc;
	}
	public String getZkjg() {
		return zkjg;
	}
	public void setZkjg(String zkjg) {
		this.zkjg = zkjg;
	}
	public double getZdkj() {
		return zdkj;
	}
	public void setZdkj(double zdkj) {
		this.zdkj = zdkj;
	}
	public String getGydw() {
		return gydw;
	}
	public void setGydw(String gydw) {
		this.gydw = gydw;
	}
	public String getJcny() {
		return jcny;
	}
	public void setJcny(String jcny) {
		this.jcny = jcny;
	}
	public Date getScdzxrq() {
		return scdzxrq;
	}
	public void setScdzxrq(Date scdzxrq) {
		this.scdzxrq = scdzxrq;
	}
	public Date getScjcrq() {
		return scjcrq;
	}
	public void setScjcrq(Date scjcrq) {
		this.scjcrq = scjcrq;
	}
	public Date getBcjcrq() {
		return bcjcrq;
	}
	public void setBcjcrq(Date bcjcrq) {
		this.bcjcrq = bcjcrq;
	}
	public String getQh() {
		return qh;
	}
	public void setQh(String qh) {
		this.qh = qh;
	}
	public String getZtzkpddj() {
		return ztzkpddj;
	}
	public void setZtzkpddj(String ztzkpddj) {
		this.ztzkpddj = ztzkpddj;
	}
	public double getQlqjzkpf() {
		return qlqjzkpf;
	}
	public void setQlqjzkpf(double qlqjzkpf) {
		this.qlqjzkpf = qlqjzkpf;
	}
	public double getByxxzkpf() {
		return byxxzkpf;
	}
	public void setByxxzkpf(double byxxzkpf) {
		this.byxxzkpf = byxxzkpf;
	}
	public String getJcxyhjy() {
		return jcxyhjy;
	}
	public void setJcxyhjy(String jcxyhjy) {
		this.jcxyhjy = jcxyhjy;
	}
	public Date getXcjcsj() {
		return xcjcsj;
	}
	public void setXcjcsj(Date xcjcsj) {
		this.xcjcsj = xcjcsj;
	}
	public String getQssm() {
		return qssm;
	}
	public void setQssm(String qssm) {
		this.qssm = qssm;
	}
	
	
	
}

















