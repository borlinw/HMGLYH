package com.hdsx.hmglyh.gis.jichusj.yingjiqx.dao;

import java.util.List;

import com.hdsx.hmglyh.gis.jichusj.yingjiqx.dao.model.Dizhizhd;
import com.hdsx.hmglyh.gis.jichusj.yingjiqx.dao.model.Wuziku;
import com.hdsx.hmglyh.gis.jichusj.yingjiqx.dao.model.Yingjibzd;
import com.hdsx.hmglyh.gis.jichusj.yingjiqx.dao.model.Zaihaiyfld;


public interface YingjiqxMapper {

	List<Dizhizhd> dizhizhdList(Dizhizhd dzzhd);

	int dizhizhdCount(Dizhizhd dzzhd);

	List<Zaihaiyfld> zaihaiyfldList(Zaihaiyfld zhyfld);

   
	int zaihaiyfldCount(Zaihaiyfld zhyfld);

	List<Wuziku> wuzikuList(Wuziku wzk);

	int wuzikuCount(Wuziku wzk);

	List<Yingjibzd> yingjibzdList(Yingjibzd yjbzd);

	int yingjibzdCount(Yingjibzd yjbzd);
}