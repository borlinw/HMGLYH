package com.hdsx.hmglyh.gis.jichusj.luxianjc.service;

import java.util.List;

import com.hdsx.hmglyh.gis.jichusj.luxianjc.dao.model.Gaosucrk;
import com.hdsx.hmglyh.gis.jichusj.luxianjc.dao.model.Pingjiaodk;

public interface LuxianjcService {
	
	/**
	 * 高速出入口 列表
	 * @param crk
	 * @return
	 */
	public List<Gaosucrk> gaosucrkRows(Gaosucrk crk);
	public int gaosucrkCount(Gaosucrk crk);
	
	/**
	 * 平交道口列表
	 * @param pjdk
	 * @return
	 */
	public List<Pingjiaodk> pingjiaodkRows(Pingjiaodk pjdk);
	public int pingjiaodkCount(Pingjiaodk pjdk);
}
