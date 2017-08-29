package com.hdsx.hmglyh.gis.jichusj.yingjiqx.service;

import java.util.List;

import com.hdsx.hmglyh.gis.jichusj.yingjiqx.dao.model.Dizhizhd;
import com.hdsx.hmglyh.gis.jichusj.yingjiqx.dao.model.Wuziku;
import com.hdsx.hmglyh.gis.jichusj.yingjiqx.dao.model.Yingjibzd;
import com.hdsx.hmglyh.gis.jichusj.yingjiqx.dao.model.Zaihaiyfld;

public interface YingjiqxService {
	/**
	 * 地质灾害点列表
	 * @param dzzhd
	 * @return
	 */
	public List<Dizhizhd> dizhizhdRows(Dizhizhd dzzhd);
	public int dizhizhdCount(Dizhizhd dzzhd);
	/**
	 * 灾害易发路段 列表
	 * @param zhyfld
	 * @return
	 */
	public List<Zaihaiyfld> zaihaiyfldRows(Zaihaiyfld zhyfld);
	public int zaihaiyfldCount(Zaihaiyfld zhyfld);
	
	/**
	 * 物资库列表
	 * @param wzk
	 * @return
	 */
	public List<Wuziku> wuzikuRows(Wuziku wzk);
	public int wuzikuCount(Wuziku wzk);
	
	/**
	 * 应急保障点 列表
	 * @param yjbzd
	 * @return
	 */
	public List<Yingjibzd> yingjibzdRows(Yingjibzd yjbzd);
	public int yingjibzdCount(Yingjibzd yjbzd);
	
}
