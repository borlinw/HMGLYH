package com.hdsx.hmglyh.gis.jichusj.luxianjc.controller;

import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.hdsx.hmglyh.gis.jichusj.luxianjc.dao.model.Gaosucrk;
import com.hdsx.hmglyh.gis.jichusj.luxianjc.dao.model.Pingjiaodk;
import com.hdsx.hmglyh.gis.jichusj.luxianjc.service.LuxianjcService;
import com.hdsx.hmglyh.util.EasyUIPage;
import com.hdsx.hmglyh.util.JsonUtils;

@Controller
@Scope(value="request")
public class LuxianjcController {
	
	private Gaosucrk crk = new Gaosucrk();
	private Pingjiaodk pjdk = new Pingjiaodk();
	private boolean fromLx;
	private boolean fromBm;
	
	private int page;
	private int rows;
	
	@Autowired
	private LuxianjcService luxianjcService;
	
	
	
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

	public Gaosucrk getCrk() {
		return crk;
	}

	public void setCrk(Gaosucrk crk) {
		this.crk = crk;
	}

	public Pingjiaodk getPjdk() {
		return pjdk;
	}

	public void setPjdk(Pingjiaodk pjdk) {
		this.pjdk = pjdk;
	}

	public String index(){
		return "jc_index";
	}
	
	/**
	 * 路线交叉 之 出入口
	 * @return
	 */
	public String churukou(){
		return "jc_churukou";
	}
	
	/**
	 * 路线交叉之平交道口
	 * @return
	 */
	public String pingjiaodk(){
		return "jc_pingjiaodk";
	}
	// ------------------------
	
	
	/**
	 * 高速出入口 列表
	 */
	public void gaosucrkRows(){
		try {
			
			crk.setPage(page);
			crk.setRows(rows);
			List<Gaosucrk> rows =  luxianjcService.gaosucrkRows(crk);
			int total = luxianjcService.gaosucrkCount(crk);
			
			EasyUIPage<Gaosucrk> epage = new EasyUIPage<Gaosucrk>();
			epage.setRows(rows);
			epage.setTotal(total);
			
			JsonUtils.write(epage, ServletActionContext.getResponse().getWriter());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * 平交道口列表 
	 */
	public void pingjiaodkRows(){
		try {
			
			pjdk.setPage(page);
			pjdk.setRows(rows);
			
			List<Pingjiaodk> rows = luxianjcService.pingjiaodkRows(pjdk);
			int total = luxianjcService.pingjiaodkCount(pjdk);
			
			EasyUIPage<Pingjiaodk> epage = new EasyUIPage<Pingjiaodk>();
			epage.setRows(rows);
			epage.setTotal(total);
			
			JsonUtils.write(epage, ServletActionContext.getResponse().getWriter());
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
