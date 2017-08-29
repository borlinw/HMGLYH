package com.hdsx.hmglyh.gis.jichusj.gouzaowu.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hdsx.hmglyh.gis.jichusj.gouzaowu.dao.GouzaowuMapper;
import com.hdsx.hmglyh.gis.jichusj.gouzaowu.dao.model.Handong;
import com.hdsx.hmglyh.gis.jichusj.gouzaowu.dao.model.Lujifh;
import com.hdsx.hmglyh.gis.jichusj.gouzaowu.dao.model.Qiaoliang;
import com.hdsx.hmglyh.gis.jichusj.gouzaowu.dao.model.Suidao;
import com.hdsx.hmglyh.gis.jichusj.gouzaowu.service.GouzaowuService;
import com.hdsx.hmglyh.gis.util.Combobox;

@Service
public class GouzaowuServiceImpl implements GouzaowuService {

	@Autowired
	private GouzaowuMapper gouzaowuMapper;
	
	@Override
	public List<Qiaoliang> qiaoliangRows(Qiaoliang ql) {
		
		return gouzaowuMapper.qiaoliangList(ql);
	}

	@Override
	public int qiaoliangCount(Qiaoliang ql) {
		
		return gouzaowuMapper.qiaoliangCount(ql);
	}

	@Override
	public List<Suidao> suidaoRows(Suidao sd) {
		
		return gouzaowuMapper.suidaoList(sd);
	}

	@Override
	public int suidaoCount(Suidao sd) {
		
		return gouzaowuMapper.suidaoCount(sd);
	}

	@Override
	public List<Handong> handongRows(Handong hd) {
		
		return gouzaowuMapper.handongList(hd);
	}

	@Override
	public int handongCount(Handong hd) {
		
		return gouzaowuMapper.handongCount(hd);
	}

	@Override
	public List<Lujifh> LujifhRows(Lujifh lj) {
		
		return gouzaowuMapper.lujifhList(lj);
	}

	@Override
	public int LujifhCount(Lujifh lj) {
		
		return gouzaowuMapper.lujifhCount(lj);
	}

	@Override
	public List<HashMap<String, Object>> qlkjflChart(
			HashMap<String, Object> param) {
		
		return gouzaowuMapper.qlkjflChart(param);
	}

	@Override
	public List<HashMap<String, Object>> qljsdjChart(
			HashMap<String, Object> param) {
		
		return gouzaowuMapper.qljsdjChart(param);
	}

	@Override
	public List<HashMap<String, Object>> qlxzChart(HashMap<String, Object> param) {
		
		return gouzaowuMapper.qlxzChart(param);
	}

	@Override
	public List<HashMap<String, Object>> sdjsdjChart(
			HashMap<String, Object> param) {
		
		return gouzaowuMapper.sdjsdjChart(param);
	}

	@Override
	public List<HashMap<String, Object>> sdflChart(HashMap<String, Object> param) {
		
		return gouzaowuMapper.sdflChart(param);
	}

	@Override
	public List<HashMap<String, Object>> ljfhlxChart(
			HashMap<String, Object> param) {
		
		return gouzaowuMapper.ljfhlxChart(param);
	}

	@Override
	public List<HashMap<String, Object>> hdflChart(HashMap<String, Object> param) {
	
		return gouzaowuMapper.hdflChart(param);
	}

	@Override
	public List<HashMap<String, Object>> hdkjflChart(
			HashMap<String, Object> param) {
	
		return gouzaowuMapper.hdkjflChart(param);
	}

	@Override
	public List<Combobox> qlCombobox(String q) {
		HashMap<String,Object> cond = new HashMap<String,Object>();
		cond.put("q", q);
		return gouzaowuMapper.qlCombobox(cond);
	}

	@Override
	public List<Combobox> sdCombobox(String q) {
		HashMap<String,Object> cond = new HashMap<String,Object>();
		return gouzaowuMapper.sdCombobox(cond);
	}

	@Override
	public List<Combobox> hdCombobox(String q) {
		HashMap<String,Object> cond  = new HashMap<String,Object>();
		cond.put("q", q);
		return gouzaowuMapper.hdCombobox(cond);
	}

	@Override
	public List<Combobox> qlCombobox(Qiaoliang ql) {
		return gouzaowuMapper.qlCombobox100(ql);
	}

	@Override
	public List<Combobox> sdCombobox(Suidao sd) {
		return gouzaowuMapper.sdCombobox100(sd);
	}

	@Override
	public List<Combobox> hdCombobox(Handong hd) {
		return gouzaowuMapper.hdCombobox100(hd);
	}

	@Override
	public List<Combobox> sdComboboxByld(Suidao sd) {
		return gouzaowuMapper.sdComboboxByld(sd);
	}

	@Override
	public List<Combobox> hdComboboxByld(Handong hd) {
		return gouzaowuMapper.hdComboboxByld(hd);
	}

	@Override
	public List<Combobox> qlComboboxByld(Qiaoliang ql) {
		return gouzaowuMapper.qlComboboxByld(ql);
	}

	@Override
	public List<HashMap<String, Object>> getChartData(
			HashMap<String, Object> param) {
		return gouzaowuMapper.getChartData(param);
	}

}
