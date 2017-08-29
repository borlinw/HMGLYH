package com.hdsx.hmglyh.gis.jichusj.gouzaowu.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hdsx.hmglyh.gis.jichusj.gouzaowu.dao.model.Handong;
import com.hdsx.hmglyh.gis.jichusj.gouzaowu.dao.model.Lujifh;
import com.hdsx.hmglyh.gis.jichusj.gouzaowu.dao.model.Qiaoliang;
import com.hdsx.hmglyh.gis.jichusj.gouzaowu.dao.model.Suidao;
import com.hdsx.hmglyh.gis.util.Combobox;

public interface GouzaowuMapper {

	List<Combobox> qlComboboxByld = null;

	List<Qiaoliang> qiaoliangList(Qiaoliang ql);

	int qiaoliangCount(Qiaoliang ql);

	List<Suidao> suidaoList(Suidao sd);

	int suidaoCount(Suidao sd);

	List<Handong> handongList(Handong hd);

	int handongCount(Handong hd);

	List<Lujifh> lujifhList(Lujifh lj);

	int lujifhCount(Lujifh lj);

	List<HashMap<String, Object>> qlkjflChart(HashMap<String, Object> param);

	List<HashMap<String, Object>> qljsdjChart(HashMap<String, Object> param);

	List<HashMap<String, Object>> qlxzChart(HashMap<String, Object> param);

	List<HashMap<String, Object>> sdjsdjChart(HashMap<String, Object> param);

	List<HashMap<String, Object>> ljfhlxChart(HashMap<String, Object> param);

	List<HashMap<String, Object>> sdflChart(HashMap<String, Object> param);

	List<HashMap<String, Object>> hdflChart(HashMap<String, Object> param);

	List<HashMap<String, Object>> hdkjflChart(HashMap<String, Object> param);

	List<Combobox> qlCombobox(HashMap<String,Object> cond);

	List<Combobox> sdCombobox(HashMap<String,Object> cond);

	List<Combobox> hdCombobox(HashMap<String,Object> cond);

	List<Combobox> qlCombobox100(Qiaoliang ql);
	List<Combobox> sdCombobox100(Suidao sd);
	List<Combobox> hdCombobox100(Handong hd);
	String getQlname(@Param("code") String code);
	String getSdname(@Param("code") String code);
	String getHdname(@Param("code") String code);

	List<Combobox> sdComboboxByld(Suidao sd);

	List<Combobox> hdComboboxByld(Handong hd);

	List<Combobox> qlComboboxByld(Qiaoliang ql);
	

	List<HashMap<String, Object>> getChartData(HashMap<String, Object> param);
}