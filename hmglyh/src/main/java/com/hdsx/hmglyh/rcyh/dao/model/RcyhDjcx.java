package com.hdsx.hmglyh.rcyh.dao.model;

import java.io.Serializable;
import java.util.Date;

/**  
 *  日常养护 - 冬季除雪 - 实体类
 * @author LiRui
 * @created 2015年7月26日 上午8:45:35 
 */

public class RcyhDjcx implements Serializable {

	private static final long serialVersionUID = -1227421667032564299L;

	private String kbid;				//快报ID（UUID）
	private String bmcode;			//填报单位
	private String bmname;			//填报部门名称（预留、显示用）
	private Date tbdate;				//填报日期
	private String tbdateStr;		//填报日期Str
	private String tbusername;	//填报人用户名
	private String tbrxm;				//填报人姓名
	private String shrxm;				//审核人姓名
	private String lxcode;			//路线编码
	private String lxname;			//路线名称
	private String roadName;
	private double wd;					//温度
	private String qzzh;				//起止桩号
	private String qzzhStr;			//用于计算里程（高速公路、一级公路 ^ 格式：370.123-385.001###402.1554-415.501）
	private Date jxsj;					//降雪时间
	private String jxsjStr;			//降雪时间Str
	private Date txsj;					//停雪时间
	private String txsjStr;			//停雪时间Str
	private double cxsj;				//持续时间
	private double pjhd;				//平均厚度
	private String cxfl;				//降雪（除雪）分类：关联枚举表的数据
	private String cxflStr;			//降雪（除雪）分类：中文说明
	private double cxlc;				//除雪里程
	private Date stime;					//除雪开始时间
	private String stimeStr;		//除雪开始时间Str
	private Date etime;					//除雪结束时间
	private String etimeStr;		//除雪结束时间Str
	private double chuxsj;			//除雪时间（小时）
	private double cxmj;				//除雪面积
	private double cxl;					//除雪量（自动计算）
	private double rggr;				//人工工日
	private double jxtb;				//机械台班
	private double cxyysl;				//除雪用盐数量
	private double cxyydj;			//除雪用盐单价
	private double cxyyfy;			//除雪用盐费用
	private double rxjsl;				//融雪剂数量
	private double rxjdj;				//融雪剂单件
	private double rxjfy;				//融雪剂费用
	private double gssl;					//滚刷数量
	private double gsdj;				//滚刷单价
	private double gsfy;				//滚刷费用
	private double dpsl;				//刀片数量
	private double dpdj;				//刀片单价
	private double dpfy;				//刀片费用
	private double qysl;					//汽油数量
	private double qydj;				//汽油单价
	private double qyfy;				//汽油费用
	private double cysl;					//柴油数量
	private double cydj;				//柴油单价
	private double cyfy;				//柴油费用
	private double qtsl;					//其他数量
	private double qtdj;				//其他单价
	private double qtfy;				//其他费用
	private double fyhj;				//费用合计
	private String nz;					//备注栏
	private double zslc;					//折算里程（折算成二级公路的里程）
	private String nzCxrs;			//备注：除雪人数
	private String nzCxcl;			//备注：除雪车辆
	private String nzCxmj;			//备注：除雪面积
	private String nzCxl;				//备注：除雪量
	private String ldcode;			//路段编码：2016-03-07              
	private String bz1;              //备注栏中的备注
	public String getBz1() {
		return bz1;
	}

	private String state;				//编辑状态；2016-06-14
	//1：刚填写或者修改完成。
	//2：申请修改中（养护科人员同意了分局和养护站的修改请求）。
	//3：同意修改（“修改”按钮显示）。
	private String cxrs;				//除雪人数：2016-06-15（备注中的除雪人数）
	private String jxcl;					//机械车辆：2016-06-15（备注中的除雪车辆前部合计数量）
	private String page;				//分页页数（分页）
	private String rows;				//每页显示行数（分页）

	public String getKbid() {
		return kbid;
	}
	public void setKbid(String kbid) {
		this.kbid = kbid;
	}
	public String getRoadName() {
		return roadName;
	}
	public void setRoadName(String roadName) {
		this.roadName = roadName;
	}
	public String getBmcode() {
		return bmcode;
	}
	public void setBmcode(String bmcode) {
		this.bmcode = bmcode;
	}
	public String getBmname() {
		return bmname;
	}
	public void setBmname(String bmname) {
		this.bmname = bmname;
	}
	public Date getTbdate() {
		return tbdate;
	}
	public void setTbdate(Date tbdate) {
		this.tbdate = tbdate;
	}
	public String getTbusername() {
		return tbusername;
	}
	public void setTbusername(String tbusername) {
		this.tbusername = tbusername;
	}
	public String getTbrxm() {
		return tbrxm;
	}
	public void setTbrxm(String tbrxm) {
		this.tbrxm = tbrxm;
	}
	public String getShrxm() {
		return shrxm;
	}
	public void setShrxm(String shrxm) {
		this.shrxm = shrxm;
	}
	public String getLxcode() {
		return lxcode;
	}
	public void setLxcode(String lxcode) {
		this.lxcode = lxcode;
	}
	public String getLxname() {
		return lxname;
	}
	public void setLxname(String lxname) {
		this.lxname = lxname;
	}
	public double getWd() {
		return wd;
	}
	public void setWd(double wd) {
		this.wd = wd;
	}
	public String getQzzh() {
		return qzzh;
	}
	public void setQzzh(String qzzh) {
		this.qzzh = qzzh;
	}
	public Date getJxsj() {
		return jxsj;
	}
	public void setJxsj(Date jxsj) {
		this.jxsj = jxsj;
	}
	public Date getTxsj() {
		return txsj;
	}
	public void setTxsj(Date txsj) {
		this.txsj = txsj;
	}
	public double getCxsj() {
		return cxsj;
	}
	public void setCxsj(double cxsj) {
		this.cxsj = cxsj;
	}
	public double getPjhd() {
		return pjhd;
	}
	public void setPjhd(double pjhd) {
		this.pjhd = pjhd;
	}
	public String getCxfl() {
		return cxfl;
	}
	public void setCxfl(String cxfl) {
		this.cxfl = cxfl;
	}
	public double getCxlc() {
		return cxlc;
	}
	public void setCxlc(double cxlc) {
		this.cxlc = cxlc;
	}
	public Date getStime() {
		return stime;
	}
	public void setStime(Date stime) {
		this.stime = stime;
	}
	public Date getEtime() {
		return etime;
	}
	public void setEtime(Date etime) {
		this.etime = etime;
	}
	public double getChuxsj() {
		return chuxsj;
	}
	public void setChuxsj(double chuxsj) {
		this.chuxsj = chuxsj;
	}
	public double getCxmj() {
		return cxmj;
	}
	public void setCxmj(double cxmj) {
		this.cxmj = cxmj;
	}
	public double getCxl() {
		return cxl;
	}
	public void setCxl(double cxl) {
		this.cxl = cxl;
	}
	public double getRggr() {
		return rggr;
	}
	public void setRggr(double rggr) {
		this.rggr = rggr;
	}
	public double getJxtb() {
		return jxtb;
	}
	public void setJxtb(double jxtb) {
		this.jxtb = jxtb;
	}
	public double getCxyysl() {
		return cxyysl;
	}
	public void setCxyysl(double cxyysl) {
		this.cxyysl = cxyysl;
	}
	public double getCxyydj() {
		return cxyydj;
	}
	public void setCxyydj(double cxyydj) {
		this.cxyydj = cxyydj;
	}
	public double getCxyyfy() {
		return cxyyfy;
	}
	public void setCxyyfy(double cxyyfy) {
		this.cxyyfy = cxyyfy;
	}
	public double getRxjsl() {
		return rxjsl;
	}
	public void setRxjsl(double rxjsl) {
		this.rxjsl = rxjsl;
	}
	public double getRxjdj() {
		return rxjdj;
	}
	public void setRxjdj(double rxjdj) {
		this.rxjdj = rxjdj;
	}
	public double getRxjfy() {
		return rxjfy;
	}
	public void setRxjfy(double rxjfy) {
		this.rxjfy = rxjfy;
	}
	public double getGssl() {
		return gssl;
	}
	public void setGssl(double gssl) {
		this.gssl = gssl;
	}
	public double getGsdj() {
		return gsdj;
	}
	public void setGsdj(double gsdj) {
		this.gsdj = gsdj;
	}
	public double getGsfy() {
		return gsfy;
	}
	public void setGsfy(double gsfy) {
		this.gsfy = gsfy;
	}
	public double getDpsl() {
		return dpsl;
	}
	public void setDpsl(double dpsl) {
		this.dpsl = dpsl;
	}
	public double getDpdj() {
		return dpdj;
	}
	public void setDpdj(double dpdj) {
		this.dpdj = dpdj;
	}
	public double getDpfy() {
		return dpfy;
	}
	public void setDpfy(double dpfy) {
		this.dpfy = dpfy;
	}
	public double getQysl() {
		return qysl;
	}
	public void setQysl(double qysl) {
		this.qysl = qysl;
	}
	public double getQydj() {
		return qydj;
	}
	public void setQydj(double qydj) {
		this.qydj = qydj;
	}
	public double getQyfy() {
		return qyfy;
	}
	public void setQyfy(double qyfy) {
		this.qyfy = qyfy;
	}
	public double getCysl() {
		return cysl;
	}
	public void setCysl(double cysl) {
		this.cysl = cysl;
	}
	public double getCydj() {
		return cydj;
	}
	public void setCydj(double cydj) {
		this.cydj = cydj;
	}
	public double getCyfy() {
		return cyfy;
	}
	public void setCyfy(double cyfy) {
		this.cyfy = cyfy;
	}
	public double getQtsl() {
		return qtsl;
	}
	public void setQtsl(double qtsl) {
		this.qtsl = qtsl;
	}
	public double getQtdj() {
		return qtdj;
	}
	public void setQtdj(double qtdj) {
		this.qtdj = qtdj;
	}
	public double getQtfy() {
		return qtfy;
	}
	public void setQtfy(double qtfy) {
		this.qtfy = qtfy;
	}
	public double getFyhj() {
		return fyhj;
	}
	public void setFyhj(double fyhj) {
		this.fyhj = fyhj;
	}
	public String getNz() {
		return nz;
	}
	public void setNz(String nz) {
		this.nz = nz;
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
	public String getTbdateStr() {
		return tbdateStr;
	}
	public void setTbdateStr(String tbdateStr) {
		this.tbdateStr = tbdateStr;
	}
	public String getJxsjStr() {
		return jxsjStr;
	}
	public void setJxsjStr(String jxsjStr) {
		this.jxsjStr = jxsjStr;
	}
	public String getTxsjStr() {
		return txsjStr;
	}
	public void setTxsjStr(String txsjStr) {
		this.txsjStr = txsjStr;
	}
	public String getStimeStr() {
		return stimeStr;
	}
	public void setStimeStr(String stimeStr) {
		this.stimeStr = stimeStr;
	}
	public String getEtimeStr() {
		return etimeStr;
	}
	public void setEtimeStr(String etimeStr) {
		this.etimeStr = etimeStr;
	}
	public String getCxflStr() {
		return cxflStr;
	}
	public void setCxflStr(String cxflStr) {
		this.cxflStr = cxflStr;
	}
	public String getQzzhStr() {
		return qzzhStr;
	}
	public void setQzzhStr(String qzzhStr) {
		this.qzzhStr = qzzhStr;
	}
	public double getZslc() {
		return zslc;
	}
	public void setZslc(double zslc) {
		this.zslc = zslc;
	}
	public String getNzCxrs() {
		return nzCxrs;
	}
	public void setNzCxrs(String nzCxrs) {
		this.nzCxrs = nzCxrs;
	}
	public String getNzCxcl() {
		return nzCxcl;
	}
	public void setNzCxcl(String nzCxcl) {
		this.nzCxcl = nzCxcl;
	}
	public String getNzCxmj() {
		return nzCxmj;
	}
	public void setNzCxmj(String nzCxmj) {
		this.nzCxmj = nzCxmj;
	}
	public String getNzCxl() {
		return nzCxl;
	}
	public void setNzCxl(String nzCxl) {
		this.nzCxl = nzCxl;
	}
	public String getLdcode() {
		return ldcode;
	}
	public void setLdcode(String ldcode) {
		this.ldcode = ldcode;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCxrs() {
		return cxrs;
	}
	public void setCxrs(String cxrs) {
		this.cxrs = cxrs;
	}
	public String getJxcl() {
		return jxcl;
	}
	public void setJxcl(String jxcl) {
		this.jxcl = jxcl;
	}

	public void setBz1(String bz1) {
		this.bz1 = bz1;
	}
}
