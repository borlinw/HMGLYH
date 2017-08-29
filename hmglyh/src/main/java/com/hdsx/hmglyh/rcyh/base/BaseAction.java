package com.hdsx.hmglyh.rcyh.base;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.hdsx.hmglyh.login.bean.LoginUser;
import com.hdsx.hmglyh.rcyh.dao.model.RcyhBhjlb;
import com.hdsx.hmglyh.rcyh.dao.model.RcyhGlxcsjb;
import com.hdsx.hmglyh.rcyh.dao.model.RcyhRwdjlb;
import com.hdsx.hmglyh.rcyh.dao.model.RcyhWxzyjlb;
import com.hdsx.hmglyh.rcyh.dao.model.RcyhZyysjlb;
import com.hdsx.hmglyh.rcyh.dao.model.ZP;
import com.opensymphony.xwork2.ActionSupport;

public class BaseAction extends ActionSupport{

	private static final long serialVersionUID = 5075498217185621683L;
	public static String succ = "succ";//统一返回到成功页面
	public static String exception = "excepPage";//统一返回到异常页面
	public static String res = "result";//返回到 自定义页面
	public String resultname; // result名称
	public String resultpage; // 跳转的页面
	public boolean isUpdate; // 页面是用来更新
	public boolean isAdd; // 页面是用来做添加
	public boolean isShow; // 页面只是用来做显示
	public boolean fromXd = false; // 与巡道相关的 查询 病害列表
	public boolean fromSb = false; // 与病害上报页面来查询病害列表
	public boolean fromPg = false; // 从派工页面过来的
	public boolean fromWx = false; // 是否维修作业详情的页面过来的要查询 相关的病害列表 
	public boolean isPg2th = false; // 是否是第二次派工
	public boolean ddWxzy = false;
	public boolean fromYdjh = false;
	public HashMap<String, Object> gmap = new HashMap<String, Object>(); // 全局Map
	private LoginUser user; // 当前登录用户
	public ZP zp; // 照片
	public List<ZP> zps; // 照片数组
	public RcyhGlxcsjb xcsj = new RcyhGlxcsjb(); // 巡查记录
	public RcyhBhjlb bhjl = new RcyhBhjlb(); // 病害记录
	public List<RcyhBhjlb> bhjls; // 病害记录数组
	public RcyhRwdjlb rwd = new RcyhRwdjlb(); // 任务单
	public RcyhZyysjlb zyys = new RcyhZyysjlb(); // 作业验收
	public RcyhWxzyjlb wxzy = new RcyhWxzyjlb(); // 维修作业
	public List<RcyhWxzyjlb> wxzys; // 维修作业s
	public boolean bufenYs = false;
	public int page;
	public int rows;
	public boolean selectFirst = true;
	
	
	public boolean isSelectFirst() {
		return selectFirst;
	}

	public void setSelectFirst(boolean selectFirst) {
		this.selectFirst = selectFirst;
	}

	public boolean isFromYdjh() {
		return fromYdjh;
	}

	public void setFromYdjh(boolean fromYdjh) {
		this.fromYdjh = fromYdjh;
	}

	public boolean isDdWxzy() {
		return ddWxzy;
	}

	public void setDdWxzy(boolean ddWxzy) {
		this.ddWxzy = ddWxzy;
	}

	public boolean isBufenYs() {
		return bufenYs;
	}

	public void setBufenYs(boolean bufenYs) {
		this.bufenYs = bufenYs;
	}

	public boolean isPg2th() {
		return isPg2th;
	}

	public void setPg2th(boolean isPg2th) {
		this.isPg2th = isPg2th;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public boolean isFromWx() {
		return fromWx;
	}

	public void setFromWx(boolean fromWx) {
		this.fromWx = fromWx;
	}

	public boolean isFromPg() {
		return fromPg;
	}

	public void setFromPg(boolean fromPg) {
		this.fromPg = fromPg;
	}

	public boolean isFromXd() {
		return fromXd;
	}

	public void setFromXd(boolean fromXd) {
		this.fromXd = fromXd;
	}

	public boolean isFromSb() {
		return fromSb;
	}

	public void setFromSb(boolean fromSb) {
		this.fromSb = fromSb;
	}

	public List<RcyhWxzyjlb> getWxzys() {
		return wxzys;
	}

	public void setWxzys(List<RcyhWxzyjlb> wxzys) {
		this.wxzys = wxzys;
	}

	public RcyhZyysjlb getZyys() {
		return zyys;
	}

	public void setZyys(RcyhZyysjlb zyys) {
		this.zyys = zyys;
	}

	public RcyhWxzyjlb getWxzy() {
		return wxzy;
	}

	public void setWxzy(RcyhWxzyjlb wxzy) {
		this.wxzy = wxzy;
	}

	public RcyhGlxcsjb getXcsj() {
		return xcsj;
	}

	public void setXcsj(RcyhGlxcsjb xcsj) {
		this.xcsj = xcsj;
	}

	public RcyhBhjlb getBhjl() {
		return bhjl;
	}

	public void setBhjl(RcyhBhjlb bhjl) {
		this.bhjl = bhjl;
	}

	public List<RcyhBhjlb> getBhjls() {
		return bhjls;
	}

	public void setBhjls(List<RcyhBhjlb> bhjls) {
		this.bhjls = bhjls;
	}

	public RcyhRwdjlb getRwd() {
		return rwd;
	}

	public void setRwd(RcyhRwdjlb rwd) {
		this.rwd = rwd;
	}

	public HashMap<String, Object> getGmap() {
		return gmap;
	}

	public void setGmap(HashMap<String, Object> gmap) {
		this.gmap = gmap;
	}

	public ZP getZp() {
		return zp;
	}

	public void setZp(ZP zp) {
		this.zp = zp;
	}

	public List<ZP> getZps() {
		return zps;
	}

	public void setZps(List<ZP> zps) {
		this.zps = zps;
	}

	public boolean isUpdate() {
		return isUpdate;
	}

	public void setUpdate(boolean isUpdate) {
		this.isUpdate = isUpdate;
	}

	public boolean isAdd() {
		return isAdd;
	}

	public void setAdd(boolean isAdd) {
		this.isAdd = isAdd;
	}

	public boolean isShow() {
		return isShow;
	}

	public void setShow(boolean isShow) {
		this.isShow = isShow;
	}

	public LoginUser getUser() {
		user = (LoginUser) ServletActionContext.getContext().getSession()
				.get("loginuser");
		return user;
	}

	public void setUser(LoginUser user) {
		this.user = user;
	}
	@Deprecated
	public String getResultname() {
		return resultname;
	}

	public void setResultname(String resultname) {
		this.resultname = resultname;
	}

	public String getResultpage() {
		return resultpage;
	}

	public void setResultpage(String resultpage) {
		this.resultpage = resultpage;
	}

	/**
	 * 获取 输出流
	 * 
	 * @return
	 */
	public HttpServletResponse getResponse() {
		return ServletActionContext.getResponse();
	}
}
