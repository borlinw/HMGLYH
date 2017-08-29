package com.hdsx.hmglyh.htgl.bean;

import java.io.Serializable;

/**  
 *  后台管理 - （作业项目类别管理）定额表 - 实体
 * @author LiRui
 * @created 2015年6月11日 下午7:38:33 
 */

public class HtglDeb implements Serializable {

	private static final long serialVersionUID = 4627703190165217441L;

	private String yhid;		//关联养护类型表主键
	private String lxid;			//关联“工料机”主键
	private String lxname;	//工料机名称
	private double sl;			//数量
	private String dw;			//单位

	//构造方法
	public HtglDeb() {
		super();
	}

	//构造方法
	public HtglDeb(String yhid, String lxid, double sl) {
		super();
		this.yhid = yhid;
		this.lxid = lxid;
		this.sl = sl;
	}

	public String getYhid() {
		return yhid;
	}
	public void setYhid(String yhid) {
		this.yhid = yhid;
	}
	public String getLxid() {
		return lxid;
	}
	public void setLxid(String lxid) {
		this.lxid = lxid;
	}
	public String getLxname() {
		return lxname;
	}
	public void setLxname(String lxname) {
		this.lxname = lxname;
	}
	public double getSl() {
		return sl;
	}
	public void setSl(double sl) {
		this.sl = sl;
	}
	public String getDw() {
		return dw;
	}
	public void setDw(String dw) {
		this.dw = dw;
	}

}
