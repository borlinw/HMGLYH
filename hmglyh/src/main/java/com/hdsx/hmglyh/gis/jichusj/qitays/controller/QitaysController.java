package com.hdsx.hmglyh.gis.jichusj.qitays.controller;

import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.hdsx.hmglyh.gis.jichusj.qitays.dao.model.Bixiancd;
import com.hdsx.hmglyh.gis.jichusj.qitays.dao.model.Chuanchengld;
import com.hdsx.hmglyh.gis.jichusj.qitays.dao.model.Guoshuilm;
import com.hdsx.hmglyh.gis.jichusj.qitays.dao.model.Jianzhicun;
import com.hdsx.hmglyh.gis.jichusj.qitays.dao.model.Jumindian;
import com.hdsx.hmglyh.gis.jichusj.qitays.dao.model.Lvhua;
import com.hdsx.hmglyh.gis.jichusj.qitays.dao.model.Lvyoujd;
import com.hdsx.hmglyh.gis.jichusj.qitays.dao.model.Qitalxd;
import com.hdsx.hmglyh.gis.jichusj.qitays.dao.model.Tingchedao;
import com.hdsx.hmglyh.gis.jichusj.qitays.dao.model.Xiangzhen;
import com.hdsx.hmglyh.gis.jichusj.qitays.dao.model.Xuexiao;
import com.hdsx.hmglyh.gis.jichusj.qitays.dao.model.Zirancun;
import com.hdsx.hmglyh.gis.jichusj.qitays.service.QitaysService;
import com.hdsx.hmglyh.rcyh.base.BaseAction;
import com.hdsx.hmglyh.util.EasyUIPage;
import com.hdsx.hmglyh.util.JsonUtils;

@Controller
@Scope(value="request")
public class QitaysController extends BaseAction{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Jianzhicun jzc = new Jianzhicun();
	private Jumindian jmd = new Jumindian();
	private Xiangzhen xz = new Xiangzhen();
	private Zirancun zrc = new Zirancun();
	private Lvyoujd lyjd = new Lvyoujd();
	private Xuexiao xx = new Xuexiao();
	private Qitalxd qtlxd = new Qitalxd();
	private Guoshuilm gslm = new Guoshuilm();
	private Bixiancd bxcd = new Bixiancd();
	private Tingchedao tcd = new Tingchedao();
	private Lvhua lh = new Lvhua();
	private Chuanchengld chuanchengld =new Chuanchengld();
	public Chuanchengld getChuanchengld() {
		return chuanchengld;
	}

	public void setChuanchengld(Chuanchengld chuanchengld) {
		this.chuanchengld = chuanchengld;
	}

	private int page;
	private int rows;

	@Autowired
	private QitaysService qitaysService;
	
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

	public Jianzhicun getJzc() {
		return jzc;
	}

	public void setJzc(Jianzhicun jzc) {
		this.jzc = jzc;
	}

	public Jumindian getJmd() {
		return jmd;
	}

	public void setJmd(Jumindian jmd) {
		this.jmd = jmd;
	}

	public Xiangzhen getXz() {
		return xz;
	}

	public void setXz(Xiangzhen xz) {
		this.xz = xz;
	}

	public Zirancun getZrc() {
		return zrc;
	}

	public void setZrc(Zirancun zrc) {
		this.zrc = zrc;
	}

	public Lvyoujd getLyjd() {
		return lyjd;
	}

	public void setLyjd(Lvyoujd lyjd) {
		this.lyjd = lyjd;
	}

	public Xuexiao getXx() {
		return xx;
	}

	public void setXx(Xuexiao xx) {
		this.xx = xx;
	}

	public Qitalxd getQtlxd() {
		return qtlxd;
	}

	public void setQtlxd(Qitalxd qtlxd) {
		this.qtlxd = qtlxd;
	}

	public Guoshuilm getGslm() {
		return gslm;
	}

	public void setGslm(Guoshuilm gslm) {
		this.gslm = gslm;
	}

	public Bixiancd getBxcd() {
		return bxcd;
	}

	public void setBxcd(Bixiancd bxcd) {
		this.bxcd = bxcd;
	}

	public Tingchedao getTcd() {
		return tcd;
	}

	public void setTcd(Tingchedao tcd) {
		this.tcd = tcd;
	}

	public Lvhua getLh() {
		return lh;
	}

	public void setLh(Lvhua lh) {
		this.lh = lh;
	}	
	
	public String index(){
		return "jc_index";
	}
	
	/**
	 * 其他要素之建制村
	 * @return
	 */
	public String jianzhicun(){
		return "jc_jianzhicun";
	}
	
	/**
	 * 其他要素之居民点
	 * @return
	 */
	public String jumindian(){
		return "jc_jumindian";
	}
	
	/**
	 * 其他要素之乡镇
	 * @return
	 */
	public String xiangzhen(){
		return "jc_xiangzhen";
	}
	
	/**
	 * 其他要素之自然村
	 * @return
	 */
	public String zirancun(){
		return "jc_zirancun";
	}
	
	/**
	 * 其他要素之旅游景点
	 * @return
	 */
	public String lvyoujd(){
		return "jc_lvyoujd";
	}
	/**
	 * 其他要素之学校
	 * @return
	 */
	public String xuexiao(){
		return "jc_xuexiao";
	}

	/**
	 * 其他要素之其他类型点
	 * @return
	 */
	public String qitalxd(){
		return "jc_qitalxd";
	}
	
	
	/**
	 * 其他要素之过水路面
	 * @return
	 */
	public String guoshuilm(){
		return "jc_guoshuilm";
	}
	
	/**
	 * 其他要素之 普通公路避险车道
	 * @return
	 */
	public String bixiancd(){
		return "jc_bixiancd";
	}
	
	
	/**
	 * 应急抢险之普通公路停车带
	 * @return
	 */
	public String tingchedai(){
		return "jc_tingchedai";
	}
	
	/**
	 * 其他要素之 绿化
	 * @return
	 */
	public String lvhua(){
		return "jc_lvhua";
	}
	
	/**
	 * 重点路段之穿城路段
	 * @return
	 */
	public String chuanchengld(){
		return "jc_chuanchengld";
	}
	
	
	// ------------------
	
	/**
	 * 建制村列表
	 */
	public void jianzhicunRows(){
		try {
			
			jzc.setPage(page);
			jzc.setRows(rows);
			
			List<Jianzhicun> rows = qitaysService.jianzhicunRows(jzc);
			int total = qitaysService.jianzhicunCount(jzc);
			
			EasyUIPage<Jianzhicun> epage = new EasyUIPage<Jianzhicun>();
			epage.setRows(rows);
			epage.setTotal(total);
			
			JsonUtils.write(epage, ServletActionContext.getResponse().getWriter());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 居民点列表
	 */
	public void jumindianRows(){
		try {
			
			jmd.setPage(page);
			jmd.setRows(rows);
			
			List<Jumindian> rows = qitaysService.jumindianRows(jmd);
			int total = qitaysService.jumindianCount(jmd);
			
			EasyUIPage<Jumindian> epage = new EasyUIPage<Jumindian>();
			epage.setRows(rows);
			epage.setTotal(total);
			
			JsonUtils.write(epage, ServletActionContext.getResponse().getWriter());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/***
	 * 乡镇列表
	 */
	public void xiangzhenRows(){
		try {
			
			xz.setPage(page);
			xz.setRows(rows);
			List<Xiangzhen> rows = qitaysService.xiangzhenRows(xz);
			int total = qitaysService.xiangzhenCount(xz);
			
			EasyUIPage<Xiangzhen> epage = new EasyUIPage<Xiangzhen>();
			epage.setRows(rows);
			epage.setTotal(total);
			
			JsonUtils.write(epage, ServletActionContext.getResponse().getWriter());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 自然村列表
	 */
	public void zirancunRows(){
		try {
			
			zrc.setPage(page);
			zrc.setRows(rows);
			List<Zirancun> rows = qitaysService.zirancunRows(zrc);
			int total = qitaysService.zirancunCount(zrc);
			
			EasyUIPage<Zirancun> epage = new EasyUIPage<Zirancun>();
			epage.setRows(rows);
			epage.setTotal(total);
			
			JsonUtils.write(epage, ServletActionContext.getResponse().getWriter());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 旅游景点列表
	 */
	public void lvyoujdRows(){
		try {
			
			lyjd.setPage(page);
			lyjd.setRows(rows);

			List<Lvyoujd> rows = qitaysService.lvyoujdRows(lyjd);
			int total = qitaysService.lvyoujdCount(lyjd);
			
			EasyUIPage<Lvyoujd> epage = new EasyUIPage<Lvyoujd>();
			epage.setRows(rows);
			epage.setTotal(total);
			
			JsonUtils.write(epage, ServletActionContext.getResponse().getWriter());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 学校列表
	 */
	public void xuexiaoRows(){
		try {
			
			xx.setPage(page);
			xx.setRows(rows);
			List<Xuexiao> rows = qitaysService.xuexiaoRows(xx);
			int total = qitaysService.xuexiaoCount(xx);
			
			EasyUIPage<Xuexiao> epage = new EasyUIPage<Xuexiao>();
			epage.setRows(rows);
			epage.setTotal(total);
		
			JsonUtils.write(epage, ServletActionContext.getResponse().getWriter());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 其他类型表列表
	 */
	public void qitalxdRows(){
		try {
			qtlxd.setRows(rows);
			qtlxd.setPage(page);
			List<Qitalxd> rows = qitaysService.qitalxdRows(qtlxd);
			int total = qitaysService.qitalxdCount(qtlxd);
			
			EasyUIPage<Qitalxd> epage = new EasyUIPage<Qitalxd>();
			epage.setRows(rows);
			epage.setTotal(total);
			
			JsonUtils.write(epage, ServletActionContext.getResponse().getWriter());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 过水路面列表
	 */
	public void guoshuilmRows(){
		try {
			
			gslm.setPage(page);
			gslm.setRows(rows);
			
			List<Guoshuilm> rows  = qitaysService.guoshuilmRows(gslm);
			int total = qitaysService.guoshuilmCount(gslm);
			
			EasyUIPage<Guoshuilm> epage = new EasyUIPage<Guoshuilm>();
			epage.setRows(rows);
			epage.setTotal(total);
			
			JsonUtils.write(epage, ServletActionContext.getResponse().getWriter());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 避险车道列表
	 */
	public void bixiancdRows(){
		try {
			
			bxcd.setPage(page);
			bxcd.setRows(rows);
			
			List<Bixiancd> rows  = qitaysService.bixiancdRows(bxcd);
			int total = qitaysService.bixiancdCount(bxcd);
			
			EasyUIPage<Bixiancd> epage = new EasyUIPage<Bixiancd>();
			epage.setRows(rows);
			epage.setTotal(total);
			
			JsonUtils.write(epage, ServletActionContext.getResponse().getWriter());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 停车道列表
	 */
	public void tingchedaoRows(){
		try {
			
			tcd.setPage(page);
			tcd.setRows(rows);
			
			List<Tingchedao> rows = qitaysService.tingchedaoRows(tcd);
			int total = qitaysService.tingchedaoCount(tcd);
			
			EasyUIPage<Tingchedao> epage = new EasyUIPage<Tingchedao>();
			epage.setRows(rows);
			epage.setTotal(total);
			
			JsonUtils.write(epage, ServletActionContext.getResponse().getWriter());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 绿化列表
	 */
	public void lvhuaRows(){
		try {
			
			lh.setPage(page);
			lh.setRows(rows);
			List<Lvhua> rows = qitaysService.lvhuaRows(lh);
			int total = qitaysService.lvhuaCount(lh);
			
			EasyUIPage<Lvhua> epage  = new EasyUIPage<Lvhua>();
			epage.setRows(rows);
			epage.setTotal(total);
			
			JsonUtils.write(epage, ServletActionContext.getResponse().getWriter());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 穿城路段列表
	 */
	public void chuanchengldRows(){
		try {
			chuanchengld.setPage(page);
			chuanchengld.setRows(rows);
			List<Chuanchengld> rows = qitaysService.ChuanchengldList(chuanchengld);
			int total = qitaysService.ChuanchengldCount(chuanchengld);
			
			EasyUIPage<Chuanchengld> epage  = new EasyUIPage<Chuanchengld>();
			epage.setRows(rows);
			epage.setTotal(total);
			
			JsonUtils.write(epage, ServletActionContext.getResponse().getWriter());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
