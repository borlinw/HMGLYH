package com.hdsx.hmglyh.gis.jichusj.luxian.dao;

import java.util.HashMap;
import java.util.List;

import com.hdsx.hmglyh.dao.Mapper;
import com.hdsx.hmglyh.gis.jichusj.luxian.dao.model.Gpsmailroad;
import com.hdsx.hmglyh.gis.jichusj.luxian.dao.model.Luduan;

public interface GpsmailroadMapper {
 
	public List<Gpsmailroad> selectRoadMapInfo(Gpsmailroad mailroad);
	public List<Luduan> luduanRows(Luduan luduan);
	public int luduanCount(Luduan luduan);
	public List<HashMap<String, Object>> jishudjChart(
			HashMap<String, Object> params);
	public List<HashMap<String, Object>> roadList(HashMap<String, Object> params);
	public List<HashMap<String, Object>> lumianlxChart(
			HashMap<String, Object> param);
	public List<HashMap<String, Object>> chedaotzChart(
			HashMap<String, Object> param);
	public List<Gpsmailroad> selectRoadByCondition(Gpsmailroad gmr);
}