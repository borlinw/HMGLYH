package com.hdsx.hmglyh.htgl.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**  
 *  后台管理 - （作业项目类别管理）养护类型表 - 实体类
 * @author LiRui
 * @created 2015年6月11日 下午7:30:51 
 */

public class HtglYhlxb implements Serializable {

	private static final long serialVersionUID = 565936589483959187L;

	private String yhid;		//养护类型编码
	private String yhname;	//养护类型名称
	private String dw;			//单位
	private double dj;			//单价
	private double grde;		//工日定额
	private String yhxmms;	//养护项目描述
	private int qyzt;				//启用状态
	private int dezt;				//定额状态（无定额 0，有定额 1）
	private int deqdzt;			//定额启动状态（未启动 0，已启动 1）
	private int islfxb;			//是否属于裂缝修补（否 0，是1）
	private int islqlmxb;		//是否属于沥青路面修补（否 0，是 1）
	private int px;					//排序（项目中用不到，预留）
	private double dejs;		//定额基数（2015-08-19新加HTGL_YHLXB）
	private String page;		//分页页数（分页）
	private String rows;		//每页显示行数（分页）
	private int denum;			//定额数量（用于限制删除）
	private int childNum;		//子节点数量（用于限制删除）
	private String deStrToAdd;	//添加定额信息的时候回传的String，拆分之后用于添加定额信息并将“养护类型”中的dezt改为1
	private List<HtglDeb> deList = new ArrayList<HtglDeb>();//养护项目对应的定额信息
	private List<HtglYhlxb> children = new ArrayList<HtglYhlxb>();//用于创建养护类型Tree

	public String getYhid() {
		return yhid;
	}
	public void setYhid(String yhid) {
		this.yhid = yhid;
	}
	public String getYhname() {
		return yhname;
	}
	public void setYhname(String yhname) {
		this.yhname = yhname;
	}
	public String getDw() {
		return dw;
	}
	public void setDw(String dw) {
		this.dw = dw;
	}
	public double getDj() {
		return dj;
	}
	public void setDj(double dj) {
		this.dj = dj;
	}
	public double getGrde() {
		return grde;
	}
	public void setGrde(double grde) {
		this.grde = grde;
	}
	public String getYhxmms() {
		return yhxmms;
	}
	public void setYhxmms(String yhxmms) {
		this.yhxmms = yhxmms;
	}
	public int getQyzt() {
		return qyzt;
	}
	public void setQyzt(int qyzt) {
		this.qyzt = qyzt;
	}
	public int getDezt() {
		return dezt;
	}
	public void setDezt(int dezt) {
		this.dezt = dezt;
	}
	public int getDeqdzt() {
		return deqdzt;
	}
	public void setDeqdzt(int deqdzt) {
		this.deqdzt = deqdzt;
	}
	public int getIslfxb() {
		return islfxb;
	}
	public void setIslfxb(int islfxb) {
		this.islfxb = islfxb;
	}
	public int getIslqlmxb() {
		return islqlmxb;
	}
	public void setIslqlmxb(int islqlmxb) {
		this.islqlmxb = islqlmxb;
	}
	public int getPx() {
		return px;
	}
	public void setPx(int px) {
		this.px = px;
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
	public List<HtglDeb> getDeList() {
		return deList;
	}
	public void setDeList(List<HtglDeb> deList) {
		this.deList = deList;
	}
	public List<HtglYhlxb> getChildren() {
		return children;
	}
	public void setChildren(List<HtglYhlxb> children) {
		this.children = children;
	}
	public int getDenum() {
		return denum;
	}
	public void setDenum(int denum) {
		this.denum = denum;
	}
	public int getChildNum() {
		return childNum;
	}
	public void setChildNum(int childNum) {
		this.childNum = childNum;
	}
	public String getDeStrToAdd() {
		return deStrToAdd;
	}
	public void setDeStrToAdd(String deStrToAdd) {
		this.deStrToAdd = deStrToAdd;
	}
	public double getDejs() {
		return dejs;
	}
	public void setDejs(double dejs) {
		this.dejs = dejs;
	}

}
