package com.hdsx.hmglyh.gis.jichusj.gouzaowu.service;

import java.util.HashMap;
import java.util.List;

import com.hdsx.hmglyh.gis.jichusj.gouzaowu.dao.model.Handong;
import com.hdsx.hmglyh.gis.jichusj.gouzaowu.dao.model.Lujifh;
import com.hdsx.hmglyh.gis.jichusj.gouzaowu.dao.model.Qiaoliang;
import com.hdsx.hmglyh.gis.jichusj.gouzaowu.dao.model.Suidao;
import com.hdsx.hmglyh.gis.util.Combobox;

public interface GouzaowuService {
	
	/**
	 * 桥梁列表
	 * @return
	 */
	public List<Qiaoliang> qiaoliangRows(Qiaoliang ql);
	public int qiaoliangCount(Qiaoliang ql);
	
	/**
	 * 隧道列表
	 * @param sd
	 * @return
	 */
	public List<Suidao> suidaoRows(Suidao sd);
	public int suidaoCount(Suidao sd);
	/**
	 * 涵洞列表
	 * @param hd
	 * @return
	 */
	public List<Handong> handongRows(Handong hd);
	public int handongCount(Handong hd);
	
	/**
	 * 路基防护列表
	 * @param lj
	 * @return
	 */
	public List<Lujifh> LujifhRows(Lujifh lj);
	public int LujifhCount(Lujifh lj);
	
	
	/**
	 * 桥梁相关的 三个统计图
	 */
	public List<HashMap<String,Object>> qlkjflChart(HashMap<String,Object> param);
	public List<HashMap<String,Object>> qljsdjChart(HashMap<String,Object> param);
	public List<HashMap<String,Object>> qlxzChart(HashMap<String,Object> param);
	
	/**
	 * 隧道相关 两个 统计图
	 */
	public List<HashMap<String,Object>> sdjsdjChart(HashMap<String,Object> param);
	public List<HashMap<String,Object>> sdflChart(HashMap<String,Object> param);
	
	/**
	 * 涵洞相关 两个统计图 
	 */
	public List<HashMap<String,Object>> hdflChart(HashMap<String,Object> param);
	public List<HashMap<String,Object>> hdkjflChart(HashMap<String,Object> param);
	
	/**
	 * 路基防护构造物 按照防护类型 统计
	 */
	public List<HashMap<String,Object>> ljfhlxChart(HashMap<String,Object> param);
	
	/**
	 * 桥梁combobox
	 * @param q
	 * @return
	 */
	public List<Combobox> qlCombobox(String q);
	/**
	 * 隧道combobox
	 * @param q
	 * @return
	 */
	public List<Combobox> sdCombobox(String q);
	
	/**
	 * 涵洞combobox
	 * @param q
	 * @return
	 */
	public List<Combobox> hdCombobox(String q);
	
	public List<Combobox> qlCombobox(Qiaoliang ql);
	public List<Combobox> sdCombobox(Suidao sd);
	public List<Combobox> hdCombobox(Handong hd);
	public List<Combobox> sdComboboxByld(Suidao sd);
	public List<Combobox> hdComboboxByld(Handong hd);
	public List<Combobox> qlComboboxByld(Qiaoliang ql);
	
	
	/**
	 * 通过部门查询构造物图表数据
	 * @param param
	 * @return
	 */
	public List<HashMap<String,Object>> getChartData(HashMap<String,Object> param);
	
}
