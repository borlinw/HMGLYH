package com.hdsx.hmglyh.gis.jichusj.yingjiqx.controller;

import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.hdsx.hmglyh.gis.jichusj.yingjiqx.dao.model.Dizhizhd;
import com.hdsx.hmglyh.gis.jichusj.yingjiqx.dao.model.Wuziku;
import com.hdsx.hmglyh.gis.jichusj.yingjiqx.dao.model.Yingjibzd;
import com.hdsx.hmglyh.gis.jichusj.yingjiqx.dao.model.Zaihaiyfld;
import com.hdsx.hmglyh.gis.jichusj.yingjiqx.service.YingjiqxService;
import com.hdsx.hmglyh.util.EasyUIPage;
import com.hdsx.hmglyh.util.JsonUtils;

@Controller
@Scope(value="prototype")
public class YingjiqxController {
	
	private Dizhizhd dzzhd = new Dizhizhd();
	private Zaihaiyfld zhyfld = new Zaihaiyfld();
	private Wuziku wzk = new Wuziku();
	private Yingjibzd yjbzd = new Yingjibzd();
	private int page;
	private int rows;
	private boolean fromLx = false;
	private boolean fromBm = false;
	
	
	
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

	@Autowired
	private YingjiqxService yingjiqxService;
	
	
	
	public Wuziku getWzk() {
		return wzk;
	}

	public void setWzk(Wuziku wzk) {
		this.wzk = wzk;
	}

	public Dizhizhd getDzzhd() {
		return dzzhd;
	}

	public void setDzzhd(Dizhizhd dzzhd) {
		this.dzzhd = dzzhd;
	}
	public Zaihaiyfld getZhyfld() {
		return zhyfld;
	}

	public void setZhyfld(Zaihaiyfld zhyfld) {
		this.zhyfld = zhyfld;
	}


	public Yingjibzd getYjbzd() {
		return yjbzd;
	}


	public void setYjbzd(Yingjibzd yjbzd) {
		this.yjbzd = yjbzd;
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


	public String index(){
		return "jc_index";
	}
	
	
	/**
	 * 其他要素之地质灾害点
	 * @return
	 */
	public String dizhizhd(){
		return "jc_dizhizhd";
	}
	
	/**
	 * 应急抢险之 灾害易发路段
	 * @return
	 */
	public String zaihaiyfld(){
		return "jc_zaihaiyfld";
	}
	
	/**
	 * 应急抢险之物资库
	 * @return
	 */
	public String wuziku(){
		return "jc_wuziku";
	}
	

	/**
	 * 应急抢险之应急保障点
	 * @return
	 */
	public String yingjibzd(){
		return "jc_yingjibzd";
	}
	
	// -------
	
	/**
	 * 地质灾害点列表
	 */
	public void dizhizhdRows(){
		try {
			
			dzzhd.setPage(page);
			dzzhd.setRows(rows);
			
			List<Dizhizhd> rows = yingjiqxService.dizhizhdRows(dzzhd);
			int total = yingjiqxService.dizhizhdCount(dzzhd);
			
			EasyUIPage<Dizhizhd> epage = new EasyUIPage<Dizhizhd>();
			epage.setRows(rows);
			epage.setTotal(total);
			
			JsonUtils.write(epage, ServletActionContext.getResponse().getWriter());
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 灾害易发路段列表
	 */
	public void zaihaiyfldRows(){
		try {
			
			zhyfld.setPage(page);
			zhyfld.setRows(rows);
			
			List<Zaihaiyfld> rows = yingjiqxService.zaihaiyfldRows(zhyfld);
			int total = yingjiqxService.zaihaiyfldCount(zhyfld);
			
			EasyUIPage<Zaihaiyfld> epage = new EasyUIPage<Zaihaiyfld>();
			epage.setRows(rows);
			epage.setTotal(total);
			
			JsonUtils.write(epage, ServletActionContext.getResponse().getWriter());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 物资库列表
	 */
	public void wuzikuRows(){
		try {
			
			wzk.setPage(page);
			wzk.setRows(rows);
			
			List<Wuziku> rows = yingjiqxService.wuzikuRows(wzk);
			int total = yingjiqxService.wuzikuCount(wzk);
			EasyUIPage<Wuziku> epage = new EasyUIPage<Wuziku>();
			epage.setRows(rows);
			epage.setTotal(total);
			JsonUtils.write(epage, ServletActionContext.getResponse().getWriter());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 应急保障点列表
	 */
	public void yingjibzdRows(){
		try {
			
			yjbzd.setPage(page);
			yjbzd.setRows(rows);	
		//	Yingjibzd yjbzd = new Yingjibzd();
			List<Yingjibzd> rows = yingjiqxService.yingjibzdRows(yjbzd);
			int total = yingjiqxService.yingjibzdCount(yjbzd);
			EasyUIPage<Yingjibzd> epage = new EasyUIPage<Yingjibzd>();
			epage.setRows(rows);
			epage.setTotal(total);
			JsonUtils.write(epage, ServletActionContext.getResponse().getWriter());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
