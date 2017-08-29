package com.hdsx.hmglyh.gis.jichusj.luxian.controller;

/**
 * TODO 
 * 路线 controlller 还没有 添加 部门 条件 ， 权限 控制 
 */

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.hdsx.hmglyh.gis.jichusj.luxian.dao.model.Gpsmailroad;
import com.hdsx.hmglyh.gis.jichusj.luxian.dao.model.HtglLdb;
import com.hdsx.hmglyh.gis.jichusj.luxian.dao.model.HtglLxb;
import com.hdsx.hmglyh.gis.jichusj.luxian.dao.model.Ldmxb;
import com.hdsx.hmglyh.gis.jichusj.luxian.dao.model.Luduan;
import com.hdsx.hmglyh.gis.jichusj.luxian.service.LdmxbService;
import com.hdsx.hmglyh.gis.jichusj.luxian.service.LuxianService;
import com.hdsx.hmglyh.gis.util.Combobox;
import com.hdsx.hmglyh.gis.util.EasyUIPage;
import com.hdsx.hmglyh.gis.util.MapCatchUtil;
import com.hdsx.hmglyh.rcyh.base.BaseAction;
import com.hdsx.hmglyh.util.JsonUtils;

@Controller
@Scope(value="request")
public class LuxianController extends BaseAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6028476600264421604L;
	
	@Resource(name="ldmxbServiceImpl")
	private LdmxbService ldmxbService;
	
	private String q; // 路线 combobox 动态查询  条件
	private int page; // 页数
	private int rows; // 行数	
	private Gpsmailroad gmr = new Gpsmailroad();
	private HtglLxb lxb  = new HtglLxb();
	private HtglLdb ldb = new HtglLdb();
	private Luduan ld = new Luduan();
	private Ldmxb ldmxb = new Ldmxb();
	private String roadcode;
	private String bmcode;
	private List<String> roadcodes;
	private HashMap<String,Object> resultMap;
	private boolean fromLx;
	private boolean fromBm;
	
	
	List<HashMap<String,Object>> jsdjRows;
	List<HashMap<String,Object>> roadRows;
	List<HashMap<String,Object>> lmlxChart;
	List<HashMap<String,Object>> cdtzChart;
	
	

	public Ldmxb getLdmxb() {
		return ldmxb;
	}

	public void setLdmxb(Ldmxb ldmxb) {
		this.ldmxb = ldmxb;
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

	@Autowired
	private LuxianService luxianService;
	
	private String ldcode;
	
	public String getLdcode() {
		return ldcode;
	}

	public void setLdcode(String ldcode) {
		this.ldcode = ldcode;
	}
	
	public String getBmcode() {
		return bmcode;
	}

	public void setBmcode(String bmcode) {
		this.bmcode = bmcode;
	}

	public String getRoadcode() {
		return roadcode;
	}

	public void setRoadcode(String roadcode) {
		this.roadcode = roadcode;
	}

	public HashMap<String, Object> getResultMap() {
		return resultMap;
	}

	public void setResultMap(HashMap<String, Object> resultMap) {
		this.resultMap = resultMap;
	}

	public Gpsmailroad getGmr() {
		return gmr;
	}
	
	public List<String> getRoadcodes() {
		return roadcodes;
	}

	public void setRoadcodes(List<String> roadcodes) {
		this.roadcodes = roadcodes;
	}


	public void setGmr(Gpsmailroad gmr) {
		this.gmr = gmr;
	}

	public HtglLxb getLxb() {
		return lxb;
	}

	public void setLxb(HtglLxb lxb) {
		this.lxb = lxb;
	}

	
	
	public HtglLdb getLdb() {
		return ldb;
	}

	public void setLdb(HtglLdb ldb) {
		this.ldb = ldb;
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
	
	public String getQ() {
		return q;
	}

	public void setQ(String q) {
		this.q = q;
	}


	public List<HashMap<String, Object>> getJsdjRows() {
		return jsdjRows;
	}

	public void setJsdjRows(List<HashMap<String, Object>> jsdjRows) {
		this.jsdjRows = jsdjRows;
	}

	public List<HashMap<String, Object>> getRoadRows() {
		return roadRows;
	}

	public void setRoadRows(List<HashMap<String, Object>> roadRows) {
		this.roadRows = roadRows;
	}

	public Luduan getLd() {
		return ld;
	}

	public void setLd(Luduan ld) {
		this.ld = ld;
	}

	
	public List<HashMap<String, Object>> getLmlxChart() {
		return lmlxChart;
	}

	public void setLmlxChart(List<HashMap<String, Object>> lmlxChart) {
		this.lmlxChart = lmlxChart;
	}

	public List<HashMap<String, Object>> getCdtzChart() {
		return cdtzChart;
	}

	public void setCdtzChart(List<HashMap<String, Object>> cdtzChart) {
		this.cdtzChart = cdtzChart;
	}

	public String test(){
		return "jc_test";
	}
	
	/**
	 * 通过 路线编码 和 路段类型 查询  shape 数据
	 */
	public void getRoadMapInfo(){
		try {
			JsonUtils.write(MapCatchUtil.getRoadShapeByRoadCode(gmr), ServletActionContext.getResponse().getWriter());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void queryGpsmailroad(){
		try {
			JsonUtils.write(MapCatchUtil.queryGqlmailroad(gmr), ServletActionContext.getResponse().getWriter());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 路线列表 combobox 可以 使用 路线名称或者 路线编码 模糊查询  
	 * 注意 兼容IE 中文 乱码问题
	 * @param t 动态 查询 参数 
	 */
	public void luxianCombobox(){
		
		HashMap<String,Object> map = new HashMap<String,Object>();
		
		map.put("q", q);
		//map.put("bmcode", bmcode);
		
		List<Combobox> list = luxianService.luxianCombobox(map);

		try {
			JsonUtils.write(list, ServletActionContext.getResponse().getWriter());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * 部门模块的 路线下拉列表
	 * 条件 部门ID q 查询 条件 
	 */
	public void luxianComboboxForBm(){
		HashMap<String,Object> map = new HashMap<String,Object>();
		map.put("q", q);
		map.put("bmcode", ldb.getBmcode());
		List<Combobox> list = luxianService.luxianComboboxForBm(map);
		list.get(0).setSelected(true);
		try {
			JsonUtils.write(list, ServletActionContext.getResponse().getWriter());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 部门的路段 下拉框， 以部门编码 为 条件 ， 返回所需的信息 有 路线编码  路段的起止点 桩号
	 * @throws Exception 
	 * @throws IOException 
	 */
	public void  luduanCombobox() throws IOException, Exception{
		List<HtglLdb> list = luxianService.luduanCombobox(bmcode);
		JsonUtils.write(list, getResponse().getWriter());
	} 
	
	
	/**
	 * 通过部门ID 和 路线 编码 查询 桩号
	 * 条件 部门ID 路线编码
	 */
	public void zhuanghaoByLxcodeAndBmcode(){
		HashMap<String,Object> map = new HashMap<String,Object>();
		map.put("lxcode", ldb.getLxcode());
		map.put("bmcode", ldb.getBmcode());
		HashMap<String,Object> res= luxianService.zhuanghaoByLxcodeAndBmcode(map);
		try {
			JsonUtils.write(res, ServletActionContext.getResponse().getWriter());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 路线 之 路线列表
	 * @return
	 */
	public String luxian(){
		return "jc_luxian";
	}
	
	/**
	 * 根据 条件 查询 路线 数据
	 * 可以 通过 路线编码 或者 路线 名称 进行模糊筛选
	 */
	public void luxianRows(){
		lxb.setPage(page);
		lxb.setRows(rows);
		List<HtglLxb> rows = luxianService.luxianRows(lxb);
		int count = luxianService.luxianCount(lxb);
		EasyUIPage<HtglLxb> epage = new EasyUIPage<HtglLxb>();
		epage.setTotal(count);
		epage.setRows(rows);
		try {
			JsonUtils.write(epage, ServletActionContext.getResponse().getWriter());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 路线 专题图 窗口
	 * 条件 ： 路线编码 可选 不传 统计 所有路线 
	 * @return
	 */
	/*public String zhuantitu(){
		return "jc_zhuantitu";
	}*/
	
	/**
	 * 路线按 技术等级统计
	 * @return
	 */
	public String tongjitu1(){
		return "jc_tongjitu1";
	}
	
	/**
	 * 路线按路面类型统计 
	 * @return
	 */
	public String tongjitu2(){
		return "jc_tongjitu2";
	}
	
	/**
	 * 路线按车道特征
	 * @return
	 */
	public String tongjitu3(){
		return "jc_tongjitu3";
	}
	
	/**
	 * 路线 路段 窗口
	 * 条件 ： 路线编码 必须有 
	 * @return
	 */
	public String luduan(){
		return "jc_luduan";
	}
	
	public String htglld(){
		return "jc_htglld";
	}
	
	public void htglldRows(){
		try {
			
			ldb.setPage(page);
			ldb.setRows(rows);
			
			List<HtglLdb> rows = luxianService.htglLdRows(ldb);
			int total = luxianService.htglLdCount(ldb);
			
			EasyUIPage<HtglLdb> epage = new EasyUIPage<HtglLdb>();
			epage.setRows(rows);
			epage.setTotal(total);
			
			JsonUtils.write(epage, ServletActionContext.getResponse().getWriter());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 根据条件 查询 路段  
	 * 条件 ： 路线编码
	 */
	public void luduanRows(){
		try {
			
			ldmxb.setPage(page+"");
			ldmxb.setRows(rows+"");
		
			List<Ldmxb> rows = ldmxbService.getMxb(ldmxb);
			int count = ldmxbService.getMxbCount(ldmxb);
			
			EasyUIPage<Ldmxb> epage = new EasyUIPage<Ldmxb>();
			epage.setTotal(count);
			epage.setRows(rows);
			
			try {
				JsonUtils.write(epage, ServletActionContext.getResponse().getWriter());
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 路线按技术等级 统计 图 
	 * @return
	 */
	public String jsdj(){
		
		HashMap<String,Object> params = new HashMap<String,Object>();
		 params.put("roadcodes", roadcodes);
		 jsdjRows = luxianService.jishudjRows(params);
		 roadRows = luxianService.roadRows(params);
		
		return "jc_jsdj";
	}
	
	/**
	 * 单条 路线 
	 * @return
	 */
	public String jsdj_pre(){
		
		HashMap<String,Object> params = new HashMap<String,Object>();
		 params.put("roadcodes", roadcodes);
		 jsdjRows = luxianService.jishudjRows(params);
		 roadRows = luxianService.roadRows(params);
		
		return "jc_jsdj_pre";
	}
	
	/**
	 * 路线按技术等级统计图 2  
	 * @return
	 */
	public String jsdj2(){
		HashMap<String,Object> params = new HashMap<String,Object>();
		roadRows = luxianService.roadRows(params);
		
		resultMap = new HashMap<String,Object>();
		
		//TODO 此处 循环查了 8 次 ， 如果 不优化 sql 请 配置 Mybaties 缓存
		for(HashMap<String,Object> hm : roadRows ) {
			String roadcode = (String) hm.get("name");
			HashMap<String,Object> p = new HashMap<String,Object>();
			List<String> l = new ArrayList<String>();
			l.add(roadcode);
			p.put("roadcodes", l);
			List<HashMap<String,Object>> jsdjRows = luxianService.jishudjRows(p);
			resultMap.put(roadcode, jsdjRows);
			
		}
		
		return "jc_jsdj2";
	}

	/**
	 * 路线技术等级统计图表 饼状图
	 * 条件 ： 路线编码 可选 不传 统计 全部数据
	 */
	public void jsdjChart(){
		HashMap<String,Object> params = new HashMap<String,Object>();
		params.put("roadcodes", roadcodes);
		List<HashMap<String,Object>> jsdjRows = luxianService.jishudjRows(params);
		List<HashMap<String,Object>> roadRows = luxianService.roadRows(params);
		HashMap<String,Object> resultMap = new HashMap<String,Object>();
		resultMap.put("jsdjRows",jsdjRows);
		resultMap.put("roadRows", roadRows);
		try {
			JsonUtils.write(resultMap, ServletActionContext.getResponse().getWriter());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 路面类型 统计图
	 * @return
	 */
	public String lmlx(){
		
		HashMap<String,Object> params = new HashMap<String,Object>();
		params.put("roadcodes", roadcodes);
		lmlxChart = luxianService.lumianlxChart(params);
		roadRows = luxianService.roadRows(params);
		
		return "jc_lmlx";
	}
	
	/**
	 * 单条路线
	 * @return
	 */
	public String lmlx_pre(){
		
		HashMap<String,Object> params = new HashMap<String,Object>();
		params.put("roadcodes", roadcodes);
		lmlxChart = luxianService.lumianlxChart(params);
		roadRows = luxianService.roadRows(params);
		
		return "jc_lmlx_pre";
	}
	
	public String lmlx2(){
		
		HashMap<String,Object> params = new HashMap<String,Object>();
		roadRows = luxianService.roadRows(params);
		
		resultMap = new HashMap<String,Object>();
		
		//TODO 此处 循环查了 8 次 ， 如果 不优化 sql 请 配置 Mybaties 缓存
		for(HashMap<String,Object> hm : roadRows ) {
			String roadcode = (String) hm.get("name");
			HashMap<String,Object> p = new HashMap<String,Object>();
			List<String> l = new ArrayList<String>();
			l.add(roadcode);
			p.put("roadcodes", l);
			List<HashMap<String,Object>> cdtzRows = luxianService.lumianlxChart(p);
			resultMap.put(roadcode, cdtzRows);
		}
		
		return "jc_lmlx2";
	}
	
	/**
	 * 路线按照路面类型 统计图 饼状图 
	 * 条件 ： 路线编码 可选 不传 统计 全部数据
	 */
	public void lmlxChart(){
		HashMap<String,Object> params = new HashMap<String,Object>();
		params.put("roadcodes", roadcodes);
		List<HashMap<String,Object>> lmlxChart = luxianService.lumianlxChart(params);
		List<HashMap<String,Object>> roadRows = luxianService.roadRows(params);
		HashMap<String,Object> resultMap = new HashMap<String,Object>();
		resultMap.put("lmlxChart",lmlxChart);
		resultMap.put("roadRows", roadRows);
		try {
			JsonUtils.write(resultMap, ServletActionContext.getResponse().getWriter());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 车道特征
	 * @return
	 */
	public String cdtz(){
		
		HashMap<String,Object> params = new HashMap<String,Object>();
		params.put("roadcodes", roadcodes);
		cdtzChart = luxianService.chedaotzChart(params);
		roadRows = luxianService.roadRows(params);
		
		return "jc_cdtz";
	}
	
	/**
	 * 车道特征  单条路线 
	 * @return
	 */
	public String cdtz_pre(){
		HashMap<String,Object> params = new HashMap<String,Object>();
		params.put("roadcodes", roadcodes);
		cdtzChart = luxianService.chedaotzChart(params);
		roadRows = luxianService.roadRows(params);
		return "jc_cdtz_pre";
	}
	
	public String cdtz2(){
		
		HashMap<String,Object> params = new HashMap<String,Object>();
		roadRows = luxianService.roadRows(params);
		
		resultMap = new HashMap<String,Object>();
		
		//TODO 此处 循环查了 8 次 ， 如果 不优化 sql 请 配置 Mybaties 缓存
		for(HashMap<String,Object> hm : roadRows ) {
			String roadcode = (String) hm.get("name");
			HashMap<String,Object> p = new HashMap<String,Object>();
			List<String> l = new ArrayList<String>();
			l.add(roadcode);
			p.put("roadcodes", l);
			List<HashMap<String,Object>> cdtzRows = luxianService.chedaotzChart(p);
			resultMap.put(roadcode, cdtzRows);
			
		}
		
		return "jc_cdtz2";
	}
	
	/**
	 * 路线 车道类型 统计图 饼状图
	 * 条件 ： 路线编码 可选 不传 统计 全部数据
	 */
	public void cdtzChart(){
		HashMap<String,Object> params = new HashMap<String,Object>();
		params.put("roadcodes", roadcodes);
		List<HashMap<String,Object>> cdtzChart = luxianService.chedaotzChart(params);
		List<HashMap<String,Object>> roadRows = luxianService.roadRows(params);
		HashMap<String,Object> resultMap = new HashMap<String,Object>();
		resultMap.put("cdtzChart",cdtzChart);
		resultMap.put("roadRows", roadRows);
		try {
			JsonUtils.write(resultMap, ServletActionContext.getResponse().getWriter());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	//路线关联业务数据信息
	public String bhs(){
		return "jc_bhs";
	}
	
	/**
	 * 与路线相关的 维修业务信息
	 * @return
	 */
	public String wxs(){
		return "jc_wxs";
	}
	
	public void getTestLine() throws IOException, Exception{
		JsonUtils.write(MapCatchUtil.getTestLine(gmr), getResponse().getWriter());
	}
	

}
