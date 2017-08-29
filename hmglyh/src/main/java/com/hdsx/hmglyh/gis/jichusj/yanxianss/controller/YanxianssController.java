package com.hdsx.hmglyh.gis.jichusj.yanxianss.controller;

import java.net.URLDecoder;
import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.hdsx.hmglyh.gis.jichusj.yanxianss.dao.model.Fanghugc;
import com.hdsx.hmglyh.gis.jichusj.yanxianss.dao.model.Fuwuqu;
import com.hdsx.hmglyh.gis.jichusj.yanxianss.dao.model.Guanlijg;
import com.hdsx.hmglyh.gis.jichusj.yanxianss.dao.model.Jianchazhan;
import com.hdsx.hmglyh.gis.jichusj.yanxianss.dao.model.Jiaoanss;
import com.hdsx.hmglyh.gis.jichusj.yanxianss.dao.model.Jiaotongbz;
import com.hdsx.hmglyh.gis.jichusj.yanxianss.dao.model.Jiaotonglianggcz;
import com.hdsx.hmglyh.gis.jichusj.yanxianss.dao.model.LuMianbx;
import com.hdsx.hmglyh.gis.jichusj.yanxianss.dao.model.Luxiandmtd;
import com.hdsx.hmglyh.gis.jichusj.yanxianss.dao.model.Shoufeizhan;
import com.hdsx.hmglyh.gis.jichusj.yanxianss.dao.model.Tianqiao;
import com.hdsx.hmglyh.gis.jichusj.yanxianss.dao.model.Yanghudaoban;
import com.hdsx.hmglyh.gis.jichusj.yanxianss.dao.model.Yanxianfwss;
import com.hdsx.hmglyh.gis.jichusj.yanxianss.service.YanxianssService;
import com.hdsx.hmglyh.util.EasyUIPage;
import com.hdsx.hmglyh.util.JsonUtils;

@Controller
@Scope(value="request")
public class YanxianssController {
	
	private Jiaoanss jass = new Jiaoanss();
	private Jiaotongbz jtbz = new Jiaotongbz();
	private Tianqiao tq = new Tianqiao();
	private Jianchazhan jcz = new Jianchazhan();
	private Jiaotonglianggcz gcz = new Jiaotonglianggcz();
	private Luxiandmtd dmtd = new Luxiandmtd();
	private Fuwuqu fwq = new Fuwuqu();
	private Yanxianfwss fwss = new Yanxianfwss();
	private Shoufeizhan sfz = new Shoufeizhan();
	private Guanlijg gljg = new Guanlijg();
	private Yanghudaoban yanghudaoban =new Yanghudaoban();
	private LuMianbx lumianbx =new LuMianbx();
	private Fanghugc fanghugc = new Fanghugc();
	
	private boolean fromLx;
	private boolean fromBm;
	
	
	
	public Fanghugc getFanghugc() {
		return fanghugc;
	}

	public void setFanghugc(Fanghugc fanghugc) {
		this.fanghugc = fanghugc;
	}

	public boolean isFromBm() {
		return fromBm;
	}

	public void setFromBm(boolean fromBm) {
		this.fromBm = fromBm;
	}

	public boolean isFromLx() {
		return fromLx;
	}

	public void setFromLx(boolean fromLx) {
		this.fromLx = fromLx;
	}

	public Yanghudaoban getYanghudaoban() {
		return yanghudaoban;
	}

	public void setYanghudaoban(Yanghudaoban yanghudaoban) {
		this.yanghudaoban = yanghudaoban;
	}

	private int page;
	private int rows;
	
	@Autowired
	private YanxianssService yanxianssService;
	
	

	public Jiaoanss getJass() {
		return jass;
	}

	public void setJass(Jiaoanss jass) {
		this.jass = jass;
	}

	public Jiaotongbz getJtbz() {
		return jtbz;
	}

	public void setJtbz(Jiaotongbz jtbz) {
		this.jtbz = jtbz;
	}

	public Tianqiao getTq() {
		return tq;
	}

	public void setTq(Tianqiao tq) {
		this.tq = tq;
	}

	public Jianchazhan getJcz() {
		return jcz;
	}

	public void setJcz(Jianchazhan jcz) {
		this.jcz = jcz;
	}

	public Jiaotonglianggcz getGcz() {
		return gcz;
	}

	public void setGcz(Jiaotonglianggcz gcz) {
		this.gcz = gcz;
	}

	public Luxiandmtd getDmtd() {
		return dmtd;
	}

	public void setDmtd(Luxiandmtd dmtd) {
		this.dmtd = dmtd;
	}

	public Fuwuqu getFwq() {
		return fwq;
	}

	public void setFwq(Fuwuqu fwq) {
		this.fwq = fwq;
	}

	public Yanxianfwss getFwss() {
		return fwss;
	}

	public void setFwss(Yanxianfwss fwss) {
		this.fwss = fwss;
	}

	public Shoufeizhan getSfz() {
		return sfz;
	}

	public void setSfz(Shoufeizhan sfz) {
		this.sfz = sfz;
	}

	public Guanlijg getGljg() {
		return gljg;
	}

	public void setGljg(Guanlijg gljg) {
		this.gljg = gljg;
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
	
	
	
	
	public LuMianbx getLumianbx() {
		return lumianbx;
	}

	public void setLumianbx(LuMianbx lumianbx) {
		this.lumianbx = lumianbx;
	}

	public String index(){
		return "jc_index";
	}
	
	/**
	 * 沿线设施之交安设施
	 * 交通安全？
	 * @return
	 */
	public String jiaoanss(){
		return "jc_jiaoanss";
	}
	
	
	
	/**
	 * 沿线设施之交通标志  tab 
	 * @return
	 */
	public String jiaotongbz(){
		return "jc_jiaotongbz";
	}
	
	/**
	 * 沿线设施 之 天桥
	 * @return
	 */
	public String tianqiao(){
		return "jc_tianqiao";
	}
	
	/**
	 * 沿线设施 之 路面标线
	 * @return
	 */
	public String lumianbx(){
		return "jc_lumianbx";
	}
	
	/**
	 * 沿线设施 之 防护工程
	 * @return
	 */
	public String fanghugc(){
		return "jc_fanghugc";
	}
	
	
	/**
	 * 沿线设施之检查站 tab
	 * @return
	 */
	public String jianchazhan(){
		return "jc_jianchazhan";
	}
	
	/**
	 * 沿线设施之交通量 观测站 tab
	 * @return
	 */
	public String jiaotonglianggcz(){
		return "jc_jiaotonglianggcz";
	}
	
	/**
	 * 沿线设施之路线多媒体点
	 * @return
	 */
	public String luxiandmtd(){
		return "jc_luxiandmtd";
	}
	
	/**
	 * 沿线设施之服务区
	 * @return
	 */
	public String fuwuqu(){
		return "jc_fuwuqu";
	}
	
	/**
	 * 沿线设施之沿线服务设施 tab
	 * @return
	 */
	public String fuwuss(){
		return "jc_fuwuss";
	}
	

	/**
	 * 沿线设施之收费站
	 * @return
	 */
	public String shoufeizhan(){
		return "jc_shoufeizhan";
	}
	
	/**
	 * 沿线设施之管理机构
	 * @return
	 */
	public String guanlijg(){
		return "jc_guanlijg";
	}
	
	
	/**
	 * 沿线设施 之 养护站（养护工区）
	 * @return
	 */
	public String yanghuzhan(){
		return "jc_yanghuzhan";
	}
	
	//--------------------------------------
	
	/**
	 * 交安设施 列表
	 */
	public void jiaoanssRows() {
		try {
			jass.setPage(page);
			jass.setRows(rows);
			List<Jiaoanss> rows = yanxianssService.jiaoanssRows(jass);
			int total = yanxianssService.jiaoanssCount(jass);
			
			EasyUIPage<Jiaoanss> epage = new EasyUIPage<Jiaoanss>();
			epage.setRows(rows);
			epage.setTotal(total);
			
			JsonUtils.write(epage, ServletActionContext.getResponse().getWriter());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 交通标志列表
	 */
	public void jiaotongbzRows(){
		try {
			
			jtbz.setPage(page);
			jtbz.setRows(rows);
			
			List<Jiaotongbz> rows = yanxianssService.jiaotongbzRows(jtbz);
			int total = yanxianssService.jiaotongbzCount(jtbz);
			
			EasyUIPage<Jiaotongbz> epage = new EasyUIPage<Jiaotongbz>();
			epage.setRows(rows);
			epage.setTotal(total);
			JsonUtils.write(epage, ServletActionContext.getResponse().getWriter());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 天桥列表
	 */
	public void tianqiaoRows(){
		try {
			
			tq.setPage(page);
			tq.setRows(rows);
			
			List<Tianqiao> rows = yanxianssService.tianqiaoRows(tq);
			int total = yanxianssService.tianqiaoCount(tq);
			
			EasyUIPage<Tianqiao> epage =new EasyUIPage<Tianqiao>();
			epage.setRows(rows);
			epage.setTotal(total);
			
			JsonUtils.write(epage, ServletActionContext.getResponse().getWriter());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 检查站列表
	 */
	public void jianchazhanRows(){
		try {
			
		
			jcz.setPage(page);
			jcz.setRows(rows);
			
			List<Jianchazhan> rows = yanxianssService.jianchazhanRows(jcz);
			int total = yanxianssService.jianchazhanCount(jcz);
			
			EasyUIPage<Jianchazhan> epage = new EasyUIPage<Jianchazhan>();
			epage.setRows(rows);
			epage.setTotal(total);
			
			JsonUtils.write(epage, ServletActionContext.getResponse().getWriter());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 交通量观测站
	 */
	public void jiaotonglianggczRows(){
		try {
			
			gcz.setPage(page);
			gcz.setRows(rows);
			
			List<Jiaotonglianggcz> rows = yanxianssService.jiaotonglianggczRows(gcz);
			int total = yanxianssService.jiaotonglainggczCount(gcz);
			
			EasyUIPage<Jiaotonglianggcz> epage = new EasyUIPage<Jiaotonglianggcz>();
			epage.setRows(rows);
			epage.setTotal(total);
			
			JsonUtils.write(epage, ServletActionContext.getResponse().getWriter());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 路线多媒体点
	 */
	public void luxiandmtdRows(){
		try {
			
			dmtd.setPage(page);
			dmtd.setRows(rows);
			
			List<Luxiandmtd> rows = yanxianssService.luxiandmtdRows(dmtd);
			int total = yanxianssService.luxiandmtCount(dmtd);
			
			EasyUIPage<Luxiandmtd> epage = new EasyUIPage<Luxiandmtd>();
			epage.setRows(rows);
			epage.setTotal(total);
			
			JsonUtils.write(epage, ServletActionContext.getResponse().getWriter());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 服务区列表
	 */
	public void fuwuquRows(){
		try {
			
			fwq.setPage(page);
			fwq.setRows(rows);
			
			List<Fuwuqu> rows = yanxianssService.fuwuquRows(fwq);
			int total = yanxianssService.fuwuquCount(fwq);
			
			EasyUIPage<Fuwuqu> epage = new EasyUIPage<Fuwuqu>();
			epage.setRows(rows);
			epage.setTotal(total);
			
			JsonUtils.write(epage, ServletActionContext.getResponse().getWriter());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 沿线服务设施
	 */
	public void yanxianfwssRows(){
		try {
			
			fwss.setPage(page);
			fwss.setRows(rows);
			
			if(fwss.getName() != null ) {
				fwss.setName(URLDecoder.decode(fwss.getName(),"UTF-8"));
			}
			
			List<Yanxianfwss> rows = yanxianssService.yanxianfwssRows(fwss);
			int total = yanxianssService.yanxianfwssCount(fwss);
			
			EasyUIPage<Yanxianfwss> epage = new EasyUIPage<Yanxianfwss>();
			epage.setRows(rows);
			epage.setTotal(total);
			
			JsonUtils.write(epage, ServletActionContext.getResponse().getWriter());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 收费站列表
	 */
	public void shoufeizhanRows(){
		try {
			
			sfz.setPage(page);
			sfz.setRows(rows);
			
			if( sfz.getName() != null ) {
				sfz.setName(URLDecoder.decode(sfz.getName(),"UTF-8"));
			}
			
			List<Shoufeizhan> rows = yanxianssService.shoufeizhanRows(sfz);
			int total = yanxianssService.shoufeizhanCount(sfz);
			
			EasyUIPage<Shoufeizhan> epage = new EasyUIPage<Shoufeizhan>();
			epage.setRows(rows);
			epage.setTotal(total);
			
			JsonUtils.write(epage, ServletActionContext.getResponse().getWriter());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 管理机构 列表
	 */
	public void guanlijgRows(){
		try {
		
			gljg.setPage(page);
			gljg.setRows(rows);
			
			List<Guanlijg> rows = yanxianssService.guanlijgRows(gljg);
			int total = yanxianssService.guanlijgCount(gljg);
			
			EasyUIPage<Guanlijg> epage = new EasyUIPage<Guanlijg>();
			epage.setRows(rows);
			epage.setTotal(total);

			JsonUtils.write(epage, ServletActionContext.getResponse().getWriter());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 养护工区列表
	 */
	public void yanghuzhanRows(){
		try {
			yanghudaoban.setPage(page);
			yanghudaoban.setRows(rows);
			
			List<Yanghudaoban> rows = yanxianssService.yanghudaobanList(yanghudaoban);
			int total = yanxianssService.yanghudaobanCount(yanghudaoban);
			
			EasyUIPage<Yanghudaoban> epage = new EasyUIPage<Yanghudaoban>();
			epage.setRows(rows);
			epage.setTotal(total);

			JsonUtils.write(epage, ServletActionContext.getResponse().getWriter());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 路面标线
	 */
	public void lumianbxRows(){
		try {
			lumianbx.setPage(page+"");
			lumianbx.setRows(rows+"");
			
			List<LuMianbx> rows = yanxianssService.lumianbxList(lumianbx);
			int total = yanxianssService.lumianbxCount(lumianbx);
			
			EasyUIPage<LuMianbx> epage = new EasyUIPage<LuMianbx>();
			epage.setRows(rows);
			epage.setTotal(total);

			JsonUtils.write(epage, ServletActionContext.getResponse().getWriter());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 防护工程
	 */
	public void fanghugcRows(){
		try {
			fanghugc.setPage(page+"");
			fanghugc.setRows(rows+"");
			
			List<Fanghugc> rows = yanxianssService.fanghugcList(fanghugc);
			int total = yanxianssService.fanghugcCount(fanghugc);
			
			EasyUIPage<Fanghugc> epage = new EasyUIPage<Fanghugc>();
			epage.setRows(rows);
			epage.setTotal(total);

			JsonUtils.write(epage, ServletActionContext.getResponse().getWriter());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
