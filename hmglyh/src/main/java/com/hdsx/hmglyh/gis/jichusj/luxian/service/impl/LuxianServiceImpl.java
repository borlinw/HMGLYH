package com.hdsx.hmglyh.gis.jichusj.luxian.service.impl;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.hdsx.hmglyh.gis.jichusj.luxian.dao.GpsmailroadMapper;
import com.hdsx.hmglyh.gis.jichusj.luxian.dao.HtglLxbMapper;
import com.hdsx.hmglyh.gis.jichusj.luxian.dao.model.HtglLdb;
import com.hdsx.hmglyh.gis.jichusj.luxian.dao.model.HtglLxb;
import com.hdsx.hmglyh.gis.jichusj.luxian.dao.model.Luduan;
import com.hdsx.hmglyh.gis.jichusj.luxian.service.LuxianService;
import com.hdsx.hmglyh.gis.util.Combobox;
import com.hdsx.hmglyh.htgl.mapper.HtglLdbMapper;

@Service
public class LuxianServiceImpl implements LuxianService{
	
	@Autowired
	HtglLxbMapper htglLxbMapper;
	@Resource(name="gpsmailroadMapper")
	GpsmailroadMapper gpsmailroadMapper;

	@Override
	public List<Combobox> luxianCombobox(HashMap<String,Object> map) {
		return htglLxbMapper.luxianCombobox(map);
	}

	@Override
	public List<HtglLxb> luxianRows(HtglLxb lxb) {
		return htglLxbMapper.luxianRows(lxb);
	}

	@Override
	public List<Luduan> luduanRows(Luduan ldb) {
		return gpsmailroadMapper.luduanRows(ldb);
	}

	@Override
	public int luxianCount(HtglLxb lxb) {
		return htglLxbMapper.luxianCount(lxb);
	}

	@Override
	public int luduanCount(Luduan ldb) {
		return gpsmailroadMapper.luduanCount(ldb);
	}

	@Override
	public List<HashMap<String, Object>> jishudjRows(HashMap<String, Object> params) {
		return gpsmailroadMapper.jishudjChart(params);
	}

	@Override
	public List<HashMap<String, Object>> roadRows(HashMap<String, Object> params) {
		return gpsmailroadMapper.roadList(params);
	}

	@Override
	public List<HashMap<String, Object>> lumianlxChart(
			HashMap<String, Object> param) {
		
		return gpsmailroadMapper.lumianlxChart(param);
	}

	@Override
	public List<HashMap<String, Object>> chedaotzChart(
			HashMap<String, Object> param) {
		
		return gpsmailroadMapper.chedaotzChart(param);
	}

	@Override
	public List<HtglLdb> htglLdRows(HtglLdb ldb) {
		return htglLxbMapper.luduanRows(ldb);
	}

	@Override
	public int htglLdCount(HtglLdb ldb) {
		return htglLxbMapper.luduanCount(ldb);
	}

	@Override
	public List<Combobox> luxianComboboxForBm(HashMap<String, Object> map) {
		return htglLxbMapper.luxianComboboxForBm(map);
	}

	@Override
	public HashMap<String, Object> zhuanghaoByLxcodeAndBmcode(
			HashMap<String, Object> map) {
		return htglLxbMapper.zhuanghaoByLxcodeAndBmcode(map);
	}

	@Override
	public List<HtglLdb> luduanCombobox(String bmcode) {
		return htglLxbMapper.luduanCombobox(bmcode);
	}
}
