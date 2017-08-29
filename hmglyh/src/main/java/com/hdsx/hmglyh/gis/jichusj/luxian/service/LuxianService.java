package com.hdsx.hmglyh.gis.jichusj.luxian.service;

import java.util.HashMap;
import java.util.List;

import com.hdsx.hmglyh.gis.jichusj.luxian.dao.model.HtglLdb;
import com.hdsx.hmglyh.gis.jichusj.luxian.dao.model.HtglLxb;
import com.hdsx.hmglyh.gis.jichusj.luxian.dao.model.Luduan;
import com.hdsx.hmglyh.gis.util.Combobox;

public interface LuxianService {

	// 路线combobox
	public List<Combobox> luxianCombobox(HashMap<String,Object> map);
	public List<Combobox> luxianComboboxForBm(HashMap<String,Object> map);
	public HashMap<String,Object> zhuanghaoByLxcodeAndBmcode(HashMap<String,Object> map);
	
	// 查询 路线列表
	public List<HtglLxb> luxianRows(HtglLxb lxb);
	public int luxianCount(HtglLxb lxb);
	
	// 查询 路段列表
	public List<Luduan> luduanRows(Luduan ldb);
	public int luduanCount(Luduan ldb);

	public List<HashMap<String, Object>> jishudjRows(HashMap<String, Object> params);

	public List<HashMap<String, Object>> roadRows(HashMap<String, Object> params);
	
	
	public List<HashMap<String,Object>> lumianlxChart(HashMap<String,Object> param);
	public List<HashMap<String,Object>> chedaotzChart(HashMap<String,Object> param);
	
	
	// 管养单位 查询 路线 
	public List<HtglLdb> htglLdRows(HtglLdb ldb);

	public int htglLdCount(HtglLdb ldb);
	
	public List<HtglLdb> luduanCombobox(String bmcode);
	
}
