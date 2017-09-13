package com.hdsx.hmglyh.gis.jichusj.gouzaowu.controller;
/**
 * TODO 
 * 构造物 controlller 还没有 添加 部门 条件 ， 权限 控制 
 */
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.hdsx.hmglyh.gis.jichusj.gouzaowu.dao.MediasMapper;
import com.hdsx.hmglyh.gis.jichusj.gouzaowu.dao.model.Handong;
import com.hdsx.hmglyh.gis.jichusj.gouzaowu.dao.model.Lujifh;
import com.hdsx.hmglyh.gis.jichusj.gouzaowu.dao.model.Medias;
import com.hdsx.hmglyh.gis.jichusj.gouzaowu.dao.model.Qiaoliang;
import com.hdsx.hmglyh.gis.jichusj.gouzaowu.dao.model.Suidao;
import com.hdsx.hmglyh.gis.jichusj.gouzaowu.service.GouzaowuService;
import com.hdsx.hmglyh.gis.jichusj.luxian.service.LuxianService;
import com.hdsx.hmglyh.gis.util.Combobox;
import com.hdsx.hmglyh.gis.util.EasyUIPage;
import com.hdsx.hmglyh.gis.util.MapCatchUtil;
import com.hdsx.hmglyh.rcyh.base.BaseAction;
import com.hdsx.hmglyh.util.JsonUtils;

@Controller
@Scope("request")
public class GouzaowuController extends BaseAction{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	private MediasMapper mMapper;
	@Autowired
	private GouzaowuService gouzaowuService;
	@Autowired
	private LuxianService luxianService;
	public static String upload = "upload"; 
	private Qiaoliang ql = new Qiaoliang();
	private Suidao sd = new Suidao();
	private Handong hd = new Handong();
	private Lujifh lj = new Lujifh();
	private List<String> roadcodes;
	private HashMap<String,Object> resultMap;
	private List<HashMap<String,Object>> roads;
	private List<HashMap<String,Object>> chartRows;
	private String q; // combobox 条件查询 条件
	private String code;
	private String xzqh;
	private Medias m;
	
	private boolean fromQl = false;
	private boolean fromSd = false;
	private boolean fromHd = false;
	private boolean fromLx = false;
	private boolean fromBm = false;
	private boolean fromLj = false;
	
	private String bmCode;


	
	public String getBmCode() {
		return bmCode;
	}

	public void setBmCode(String bmCode) {
		this.bmCode = bmCode;
	}

	public boolean isFromLj() {
		return fromLj;
	}

	public void setFromLj(boolean fromLj) {
		this.fromLj = fromLj;
	}

	public boolean isFromLx() {
		return fromLx;
	}

	public void setFromLx(boolean fromLx) {
		this.fromLx = fromLx;
	}

	public boolean isFromBm() {
		return fromBm;
	}

	public void setFromBm(boolean fromBm) {
		this.fromBm = fromBm;
	}

	public boolean isFromQl() {
		return fromQl;
	}

	public void setFromQl(boolean fromQl) {
		this.fromQl = fromQl;
	}

	public boolean isFromSd() {
		return fromSd;
	}

	public void setFromSd(boolean fromSd) {
		this.fromSd = fromSd;
	}

	public boolean isFromHd() {
		return fromHd;
	}

	public void setFromHd(boolean fromHd) {
		this.fromHd = fromHd;
	}

	public Medias getM() {
		return m;
	}

	public void setM(Medias m) {
		this.m = m;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getXzqh() {
		return xzqh;
	}

	public void setXzqh(String xzqh) {
		this.xzqh = xzqh;
	}

	private int page;
	private int rows;
	
	
	
	public String getQ() {
		return q;
	}

	public void setQ(String q) {
		this.q = q;
	}

	public List<String> getRoadcodes() {
		return roadcodes;
	}

	public void setRoadcodes(List<String> roadcodes) {
		this.roadcodes = roadcodes;
	}


	public HashMap<String, Object> getResultMap() {
		return resultMap;
	}

	public void setResultMap(HashMap<String, Object> resultMap) {
		this.resultMap = resultMap;
	}

	public List<HashMap<String, Object>> getRoads() {
		return roads;
	}

	public void setRoads(List<HashMap<String, Object>> roads) {
		this.roads = roads;
	}

	public List<HashMap<String, Object>> getChartRows() {
		return chartRows;
	}

	public void setChartRows(List<HashMap<String, Object>> chartRows) {
		this.chartRows = chartRows;
	}

	public Suidao getSd() {
		return sd;
	}

	public void setSd(Suidao sd) {
		this.sd = sd;
	}

	public Handong getHd() {
		return hd;
	}

	public void setHd(Handong hd) {
		this.hd = hd;
	}

	public Lujifh getLj() {
		return lj;
	}

	public void setLj(Lujifh lj) {
		this.lj = lj;
	}

	public Qiaoliang getQl() {
		return ql;
	}

	public void setQl(Qiaoliang ql) {
		this.ql = ql;
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

	
	
	public GouzaowuService getGouzaowuService() {
		return gouzaowuService;
	}

	public void setGouzaowuService(GouzaowuService gouzaowuService) {
		this.gouzaowuService = gouzaowuService;
	}
	
	public String showPicAndUpload(){
		m = mMapper.selectByKey(code+"-"+xzqh);
		if( m != null ) {
			m.setPicUrl(com.hdsx.hmglyh.util.Constants.PicUrl2);
		}
	
		return upload;
	}
	
	/**
	 * 桥梁窗口
	 * @return
	 */
	public String qiaoliang(){
		
		// 如果 桥梁实体中的部门编码 不为空 ， 表示 从 部门模块 发出的 请求 ， 通过部门 编码 查出 属于该部门的第一条 路线 作为 默认 的数据 
		if(ql.getBmcode() != null ) {
			HashMap<String,Object> map = new HashMap<String,Object>();
			map.put("bmcode", ql.getBmcode());
			List<Combobox> list = luxianService.luxianComboboxForBm(map);
			ql.setRoadcode(list.get(0).getValueField());
			ql.setStartzh(list.get(0).getSzhh());
			ql.setEndzh(list.get(0).getEzhh());
		}
		
		return "jc_qiaoliang";
	}
	
	/**
	 * 桥梁列表
	 * @return
	 */
	public String qiaolianglb(){
		return "jc_qiaolianglb";
	}
	
	/**
	 * 隧道窗口
	 * @return
	 */
	public String suidao(){
		return "jc_suidao";
	}
	
	
	/**
	 * 隧道列表
	 * @return
	 */
	public String suidaolb(){
		return "jc_suidaolb";
	}
	
	/**
	 * 沿线设施 之 涵洞 
	 * @return
	 */
	public String handong(){
		return "jc_handong";
	}
	
	/**
	 * 涵洞列表 
	 * @return
	 */
	public String handonglb(){
		return "jc_handonglb";
	}
	
	/**
	 * 路基防护构造物
	 * @return
	 */
	public String lujifh(){
		return "jc_lujifh";
	}
	
	/**
	 * 路基防护列表
	 * @return
	 */
	public String lujifhlb() {
		return "jc_lujifhlb";
	}
	
	public String ljtongjitu(){
		return "jc_ljtongjitu";
	}
	
	/**
	 * 桥梁按跨径分类 统计 
	 */
	public String qlkjfl(){
		HashMap<String,Object> param = new HashMap<String,Object>();
		roads = luxianService.roadRows(param);
		chartRows = gouzaowuService.qlkjflChart(param);
		return "jc_qlkjfl";
	}
	
	public String qlkjfl_pre(){
		HashMap<String,Object> param = new HashMap<String,Object>();
		param.put("roadcodes",roadcodes);
		roads = luxianService.roadRows(param);
		if(fromBm){
			param.put("bmCode", bmCode);
			param.put("rowName","qlkjfl");
			param.put("tableName", "qiaoliang");
			chartRows = gouzaowuService.getChartData(param);
		}else{
			chartRows = gouzaowuService.qlkjflChart(param);
		}
		return "jc_qlkjfl_pre";
	}
	
	public void qlkjflChart(){
		HashMap<String,Object> params = new HashMap<String,Object>();
		params.put("roadcodes", roadcodes);
		List<HashMap<String,Object>> rows = gouzaowuService.qlkjflChart(params);
		List<HashMap<String,Object>> roads = luxianService.roadRows(params);
		HashMap<String,Object> resultMap = new HashMap<String,Object>();
		resultMap.put("rows",rows);
		resultMap.put("roads", roads);
		try {
			JsonUtils.write(resultMap, ServletActionContext.getResponse().getWriter());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String qlkjfl2(){
		
		HashMap<String,Object> param = new HashMap<String,Object>();
		roads = luxianService.roadRows(param);
		
		resultMap = new HashMap<String,Object>();
		
		//TODO 此处 循环查了 8 次 ， 如果 不优化 sql 请 配置 Mybaties 缓存
		for(HashMap<String,Object> hm : roads ) {
			String roadcode = (String) hm.get("name");
			HashMap<String,Object> p = new HashMap<String,Object>();
			List<String> l = new ArrayList<String>();
			l.add(roadcode);
			p.put("roadcodes", l);
			List<HashMap<String,Object>> rows = gouzaowuService.qlkjflChart(p);
			resultMap.put(roadcode, rows);
			
		}
		
		return "jc_qlkjfl2";
	}
	

	
	/**
	 * 桥梁 技术等级
	 * @return
	 */
	public String qljsdj(){
		
		HashMap<String,Object> param = new HashMap<String,Object>();
		roads = luxianService.roadRows(param);
		chartRows = gouzaowuService.qljsdjChart(param);
		
		return "jc_qljsdj";
	}
	
	public String qljsdj_pre(){
		HashMap<String,Object> param = new HashMap<String,Object>();
		param.put("roadcodes",roadcodes);
		roads = luxianService.roadRows(param);
		if(fromBm){
			param.put("bmCode", bmCode);
			param.put("rowName","jspddj");
			param.put("tableName", "qiaoliang");
			chartRows = gouzaowuService.getChartData(param);
		}else{
			chartRows = gouzaowuService.qljsdjChart(param);
		}
		return "jc_qljsdj_pre";
	}
	
	public void qljsdjChart(){
		HashMap<String,Object> params = new HashMap<String,Object>();
		params.put("roadcodes", roadcodes);
		List<HashMap<String,Object>> rows = gouzaowuService.qljsdjChart(params);
		List<HashMap<String,Object>> roads = luxianService.roadRows(params);
		HashMap<String,Object> resultMap = new HashMap<String,Object>();
		resultMap.put("rows",rows);
		resultMap.put("roads", roads);
		try {
			JsonUtils.write(resultMap, ServletActionContext.getResponse().getWriter());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String qljsdj2(){
		
		HashMap<String,Object> param = new HashMap<String,Object>();
		roads = luxianService.roadRows(param);
		
		resultMap = new HashMap<String,Object>();
		
		//TODO 此处 循环查了 8 次 ， 如果 不优化 sql 请 配置 Mybaties 缓存
		for(HashMap<String,Object> hm : roads ) {
			String roadcode = (String) hm.get("name");
			HashMap<String,Object> p = new HashMap<String,Object>();
			List<String> l = new ArrayList<String>();
			l.add(roadcode);
			p.put("roadcodes", l);
			List<HashMap<String,Object>> rows = gouzaowuService.qljsdjChart(p);
			resultMap.put(roadcode, rows);
			
		}
		
		return "jc_qljsdj2";
	}
	
	/**
	 * 桥梁性质
	 */
	public String qlxz(){
		HashMap<String,Object> param = new HashMap<String,Object>();
		roads = luxianService.roadRows(param);
		chartRows = gouzaowuService.qlxzChart(param);
		return "jc_qlxz";
	}
	
	public String qlxz_pre(){
		HashMap<String,Object> param = new HashMap<String,Object>();
		param.put("roadcodes",roadcodes);
		roads = luxianService.roadRows(param);
		if(fromBm){
			param.put("bmCode", bmCode);
			param.put("rowName","qlxz");
			param.put("tableName", "qiaoliang");
			chartRows = gouzaowuService.getChartData(param);
		}else{
			chartRows = gouzaowuService.qlxzChart(param);
		}
		return "jc_qlxz_pre";
	}
	
	public void qlxzChart(){
		HashMap<String,Object> params = new HashMap<String,Object>();
		params.put("roadcodes", roadcodes);
		List<HashMap<String,Object>> rows = gouzaowuService.qlxzChart(params);
		List<HashMap<String,Object>> roads = luxianService.roadRows(params);
		HashMap<String,Object> resultMap = new HashMap<String,Object>();
		resultMap.put("rows",rows);
		resultMap.put("roads", roads);
		try {
			JsonUtils.write(resultMap, ServletActionContext.getResponse().getWriter());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String qlxz2(){
		HashMap<String,Object> param = new HashMap<String,Object>();
		roads = luxianService.roadRows(param);
		
		resultMap = new HashMap<String,Object>();
		
		//TODO 此处 循环查了 8 次 ， 如果 不优化 sql 请 配置 Mybaties 缓存
		for(HashMap<String,Object> hm : roads ) {
			String roadcode = (String) hm.get("name");
			HashMap<String,Object> p = new HashMap<String,Object>();
			List<String> l = new ArrayList<String>();
			l.add(roadcode);
			p.put("roadcodes", l);
			List<HashMap<String,Object>> rows = gouzaowuService.qlxzChart(p);
			resultMap.put(roadcode, rows);
			
		}
		
		return "jc_qlxz2";
	}
	
	
	
	public String qltongjitu1(){
		return "jc_qltongjitu1";
	}
	
	public String qltongjitu2(){
		return "jc_qltongjitu2";
	}
	
	public String qltongjitu3(){
		return "jc_qltongjitu3";
	}
	
	public String sdtongjitu1(){
		return "jc_sdtongjitu1";
	}
	
	public String sdtongjitu2(){
		return "jc_sdtongjitu2";
	}
	
	public String hdtongjitu1(){
		return "jc_hdtongjitu1";
	}
	
	public String hdtongjitu2(){
		return "jc_hdtongjitu2";
	}
		
	/**
	 * 隧道 技术等级 
	 */
	
	public String sdjsdj(){
		HashMap<String,Object> param = new HashMap<String,Object>();
		roads = luxianService.roadRows(param);
		chartRows = gouzaowuService.sdjsdjChart(param);
		return "jc_sdjsdj";
	}
	
	public String sdjsdj_pre(){
		HashMap<String,Object> param = new HashMap<String,Object>();
		param.put("roadcodes",roadcodes);
		roads = luxianService.roadRows(param);
		if(fromBm){
			param.put("bmCode", bmCode);
			param.put("rowName","jspddj");
			param.put("tableName", "suidao");
			chartRows = gouzaowuService.getChartData(param);
		}else{
			chartRows = gouzaowuService.sdjsdjChart(param);
		}
		return "jc_sdjsdj_pre";
	}
	
	public void sdjsdjChart(){
		HashMap<String,Object> params = new HashMap<String,Object>();
		params.put("roadcodes", roadcodes);
		List<HashMap<String,Object>> rows = gouzaowuService.sdjsdjChart(params);
		List<HashMap<String,Object>> roads = luxianService.roadRows(params);
		HashMap<String,Object> resultMap = new HashMap<String,Object>();
		resultMap.put("rows",rows);
		resultMap.put("roads", roads);
		try {
			JsonUtils.write(resultMap, ServletActionContext.getResponse().getWriter());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String sdjsdj2(){
		
		HashMap<String,Object> param = new HashMap<String,Object>();
		roads = luxianService.roadRows(param);
		
		resultMap = new HashMap<String,Object>();
		
		//TODO 此处 循环查了 8 次 ， 如果 不优化 sql 请 配置 Mybaties 缓存
		for(HashMap<String,Object> hm : roads ) {
			String roadcode = (String) hm.get("name");
			HashMap<String,Object> p = new HashMap<String,Object>();
			List<String> l = new ArrayList<String>();
			l.add(roadcode);
			p.put("roadcodes", l);
			List<HashMap<String,Object>> rows = gouzaowuService.sdjsdjChart(p);
			resultMap.put(roadcode, rows);
			
		}
		
		return "jc_sdjsdj2";
	}
	
	/**
	 * 隧道分类
	 */
	public String sdfl(){
		
		HashMap<String,Object> param = new HashMap<String,Object>();
		roads = luxianService.roadRows(param);
		chartRows = gouzaowuService.sdflChart(param);
		
		return "jc_sdfl";
	}
	
	public String sdfl_pre(){
		HashMap<String,Object> param = new HashMap<String,Object>();
		param.put("roadcodes",roadcodes);
		roads = luxianService.roadRows(param);
		if(fromBm){
			param.put("bmCode", bmCode);
			param.put("rowName","sdfl");
			param.put("tableName", "suidao");
			chartRows = gouzaowuService.getChartData(param);
		}else{
			chartRows = gouzaowuService.sdflChart(param);
		}
		return "jc_sdfl_pre";
	}
	
	public void sdflChart(){
		HashMap<String,Object> params = new HashMap<String,Object>();
		params.put("roadcodes", roadcodes);
		List<HashMap<String,Object>> rows = gouzaowuService.sdflChart(params);
		List<HashMap<String,Object>> roads = luxianService.roadRows(params);
		HashMap<String,Object> resultMap = new HashMap<String,Object>();
		resultMap.put("rows",rows);
		resultMap.put("roads", roads);
		try {
			JsonUtils.write(resultMap, ServletActionContext.getResponse().getWriter());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String sdfl2(){
		
		HashMap<String,Object> param = new HashMap<String,Object>();
		roads = luxianService.roadRows(param);
		
		resultMap = new HashMap<String,Object>();
		
		//TODO 此处 循环查了 8 次 ， 如果 不优化 sql 请 配置 Mybaties 缓存
		for(HashMap<String,Object> hm : roads ) {
			String roadcode = (String) hm.get("name");
			HashMap<String,Object> p = new HashMap<String,Object>();
			List<String> l = new ArrayList<String>();
			l.add(roadcode);
			p.put("roadcodes", l);
			List<HashMap<String,Object>> rows = gouzaowuService.sdflChart(p);
			resultMap.put(roadcode, rows);
			
		}
		
		return "jc_sdfl2";
	}
	
	/**
	 * 涵洞按 涵洞类型统计
	 */
	public String hdlx(){
		HashMap<String,Object> param = new HashMap<String,Object>();
		roads = luxianService.roadRows(param);
		chartRows = gouzaowuService.hdflChart(param);
		return "jc_hdlx";
	}
	
	public String hdlx_pre(){
		HashMap<String,Object> param = new HashMap<String,Object>();
		param.put("roadcodes",roadcodes);
		roads = luxianService.roadRows(param);
		chartRows = gouzaowuService.hdflChart(param);
		return "jc_hdlx_pre";
	}
	
	public void hdlxChart(){
		HashMap<String,Object> params = new HashMap<String,Object>();
		params.put("roadcodes", roadcodes);
		List<HashMap<String,Object>> rows = gouzaowuService.hdflChart(params);
		List<HashMap<String,Object>> roads = luxianService.roadRows(params);
		HashMap<String,Object> resultMap = new HashMap<String,Object>();
		resultMap.put("rows",rows);
		resultMap.put("roads", roads);
		try {
			JsonUtils.write(resultMap, ServletActionContext.getResponse().getWriter());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String hdlx2(){
		
		HashMap<String,Object> param = new HashMap<String,Object>();
		roads = luxianService.roadRows(param);
		
		resultMap = new HashMap<String,Object>();
		
		//TODO 此处 循环查了 8 次 ， 如果 不优化 sql 请 配置 Mybaties 缓存
		for(HashMap<String,Object> hm : roads ) {
			String roadcode = (String) hm.get("name");
			HashMap<String,Object> p = new HashMap<String,Object>();
			List<String> l = new ArrayList<String>();
			l.add(roadcode);
			p.put("roadcodes", l);
			List<HashMap<String,Object>> rows = gouzaowuService.hdflChart(p);
			resultMap.put(roadcode, rows);
			
		}
		
		return "jc_hdlx2";
	}
	
	/**
	 * 涵洞按涵洞跨径分类 统计
	 */
	public String hdkjfl(){
		
		HashMap<String,Object> param = new HashMap<String,Object>();
		roads = luxianService.roadRows(param);
		chartRows = gouzaowuService.hdkjflChart(param);
		return "jc_hdkjfl";
	}
	
	public String hdkjfl_pre(){
		HashMap<String,Object> param = new HashMap<String,Object>();
		param.put("roadcodes", roadcodes);
		roads = luxianService.roadRows(param);
		chartRows = gouzaowuService.hdkjflChart(param);
		return "jc_hdkjfl_pre";
	}
	
	public void hdkjflChart(){
		HashMap<String,Object> params = new HashMap<String,Object>();
		params.put("roadcodes", roadcodes);
		List<HashMap<String,Object>> rows = gouzaowuService.hdkjflChart(params);
		List<HashMap<String,Object>> roads = luxianService.roadRows(params);
		HashMap<String,Object> resultMap = new HashMap<String,Object>();
		resultMap.put("rows",rows);
		resultMap.put("roads", roads);
		try {
			JsonUtils.write(resultMap, ServletActionContext.getResponse().getWriter());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String hdkjfl2(){
		HashMap<String,Object> param = new HashMap<String,Object>();
		roads = luxianService.roadRows(param);
		
		resultMap = new HashMap<String,Object>();
		
		//TODO 此处 循环查了 8 次 ， 如果 不优化 sql 请 配置 Mybaties 缓存
		for(HashMap<String,Object> hm : roads ) {
			String roadcode = (String) hm.get("name");
			HashMap<String,Object> p = new HashMap<String,Object>();
			List<String> l = new ArrayList<String>();
			l.add(roadcode);
			p.put("roadcodes", l);
			List<HashMap<String,Object>> rows = gouzaowuService.hdkjflChart(p);
			resultMap.put(roadcode, rows);
			
		}
		return "jc_hdkjfl2";
	}
	
	/**
	 * 按 路基防护类统计
	 */
	public String ljfhlx(){
		HashMap<String,Object> param = new HashMap<String,Object>();
		roads = luxianService.roadRows(param);
		chartRows = gouzaowuService.ljfhlxChart(param);
		return "jc_ljfhlx";
	}
	
	public String ljfhlx_pre(){
		HashMap<String,Object> param = new HashMap<String,Object>();
		param.put("roadcodes", roadcodes);
		roads = luxianService.roadRows(param);
		chartRows = gouzaowuService.ljfhlxChart(param);
		return "jc_ljfhlx_pre";
	}
	
	public void ljfhlxChart(){
		HashMap<String,Object> params = new HashMap<String,Object>();
		params.put("roadcodes", roadcodes);
		List<HashMap<String,Object>> rows = gouzaowuService.ljfhlxChart(params);
		List<HashMap<String,Object>> roads = luxianService.roadRows(params);
		HashMap<String,Object> resultMap = new HashMap<String,Object>();
		resultMap.put("rows",rows);
		resultMap.put("roads", roads);
		try {
			JsonUtils.write(resultMap, ServletActionContext.getResponse().getWriter());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String ljfhlx2(){
		
		HashMap<String,Object> param = new HashMap<String,Object>();
		roads = luxianService.roadRows(param);
		
		resultMap = new HashMap<String,Object>();
		
		//TODO 此处 循环查了 8 次 ， 如果 不优化 sql 请 配置 Mybaties 缓存
		for(HashMap<String,Object> hm : roads ) {
			String roadcode = (String) hm.get("name");
			HashMap<String,Object> p = new HashMap<String,Object>();
			List<String> l = new ArrayList<String>();
			l.add(roadcode);
			p.put("roadcodes", l);
			List<HashMap<String,Object>> rows = gouzaowuService.ljfhlxChart(p);
			resultMap.put(roadcode, rows);
			
		}
		
		return "jc_ljfhlx2";
	}
	
	/**
	 * 查询 桥梁 列表 
	 * 条件 ： 路线 编码 可选  不传 查询 所有的桥梁
	 * 		桥梁名称
	 */
	public void qiaoliangRows(){
		try {
			
			if( ql.getName() != null ) {
				ql.setName(URLDecoder.decode(ql.getName(),"UTF-8"));
			}
			ql.setPage(page);
			ql.setRows(rows);
			List<Qiaoliang> list = gouzaowuService.qiaoliangRows(ql);
			int count = gouzaowuService.qiaoliangCount(ql);
			
			EasyUIPage<Qiaoliang> epage = new EasyUIPage<Qiaoliang>();
			epage.setRows(list);
			epage.setTotal(count);
			
			JsonUtils.write(epage, ServletActionContext.getResponse().getWriter());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * 查询 隧道列表
	 * 条件 ： 路线编码 可选 不传 查询所有的隧道
	 * 	           隧道名称
	 */
	public void suidaoRows(){
		try {
			
			if( sd.getName() != null ) {
				sd.setName(URLDecoder.decode(sd.getName(),"UTF-8"));
			}
			
			sd.setPage(page);
			sd.setRows(rows);
			
			List<Suidao> list = gouzaowuService.suidaoRows(sd);
			int count = gouzaowuService.suidaoCount(sd);
			EasyUIPage<Suidao> epage = new EasyUIPage<Suidao>();
			epage.setRows(list);
			epage.setTotal(count);
			JsonUtils.write(epage, ServletActionContext.getResponse().getWriter());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * 涵洞列表
	 * 
	 */
	public void handongRows(){
		try {
			
			hd.setPage(page);
			hd.setRows(rows);
			
			if( hd.getCode() != null ) {
				hd.setCode(URLDecoder.decode(hd.getCode(), "UTF-8"));
			}
			
			List<Handong> rows = gouzaowuService.handongRows(hd);
			int total = gouzaowuService.handongCount(hd);
			EasyUIPage<Handong> epage = new EasyUIPage<Handong>();
			
			epage.setRows(rows);
			epage.setTotal(total);
			
			JsonUtils.write(epage, ServletActionContext.getResponse().getWriter());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * 查询  路基防护构造物
	 * 条件 ： 路线编码 可选 不传 查询 所有的 防护构造物
	 * 	           构造物名称
	 */
	public void lujifhRows(){
		try {
			
			lj.setPage(page);
			lj.setRows(rows);
			
			List<Lujifh> rows = gouzaowuService.LujifhRows(lj);
			int total = gouzaowuService.LujifhCount(lj);
			
			EasyUIPage<Lujifh> epage = new EasyUIPage<Lujifh>();
			epage.setRows(rows);
			epage.setTotal(total);
			
			JsonUtils.write(epage, ServletActionContext.getResponse().getWriter());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 桥梁名称 combobx
	 * 支持 条件查询 q
	 */
	public void qlCombobox(){	
		try {
			List<Combobox> list = gouzaowuService.qlCombobox(q);
			JsonUtils.write(list, ServletActionContext.getResponse().getWriter());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void qlCombobox100(){	
		try {
			ql.setRoadcode(MapCatchUtil.getRoadcodeByld(ql.getRoadcode()));
			List<Combobox> list = gouzaowuService.qlCombobox(ql);
			if(list.size() > 0 ) {
				list.get(0).setSelected(true);
			}
 			JsonUtils.write(list, ServletActionContext.getResponse().getWriter());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void qlComboboxByld(){	
		try {
			List<Combobox> list = gouzaowuService.qlComboboxByld(ql);
			if(list.size() > 0 ) {
				list.get(0).setSelected(true);
			}
 			JsonUtils.write(list, ServletActionContext.getResponse().getWriter());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 隧道名称combobox 
	 * 支持条件 查询 q
	 */
	public void sdCombobox(){
		try {
			List<Combobox> list = gouzaowuService.sdCombobox(q);
			JsonUtils.write(list, ServletActionContext.getResponse().getWriter());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void sdCombobox100(){	
		try {
			sd.setRoadcode(MapCatchUtil.getRoadcodeByld(sd.getRoadcode()));
			List<Combobox> list = gouzaowuService.sdCombobox(sd);
			if(list.size() > 0 ) {
				list.get(0).setSelected(true);
			}
			JsonUtils.write(list, ServletActionContext.getResponse().getWriter());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void sdComboboxByld(){	
		try {
			List<Combobox> list = gouzaowuService.sdComboboxByld(sd);
			if(list.size() > 0 ) {
				list.get(0).setSelected(true);
			}
			JsonUtils.write(list, ServletActionContext.getResponse().getWriter());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * 涵洞名称 comboboxob
	 * 支持条件查询 q
	 */
	public void hdCombobox(){
		try {
			List<Combobox> list = gouzaowuService.hdCombobox(q);
			JsonUtils.write(list, ServletActionContext.getResponse().getWriter());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void hdCombobox100(){
		try {
			hd.setRoadcode(MapCatchUtil.getRoadcodeByld(hd.getRoadcode()));
			List<Combobox> list = gouzaowuService.hdCombobox(hd);
			if(list.size() > 0 ) {
				list.get(0).setSelected(true);
			}
			JsonUtils.write(list, ServletActionContext.getResponse().getWriter());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void hdComboboxByld(){
		try {
			List<Combobox> list = gouzaowuService.hdComboboxByld(hd);
			if(list.size() > 0 ) {
				list.get(0).setSelected(true);
			}
			JsonUtils.write(list, ServletActionContext.getResponse().getWriter());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 构造物病害
	 * @return
	 */
	public String bhs(){
		return "jc_bhs";
	}
	
	/**
	 * 维修作业病害
	 * @return
	 */
	public String wxs(){
		return "jc_wxs";
	}
}
