package com.hdsx.hmglyh.gis.jichusj.qitays.dao;

import java.util.List;

import com.hdsx.hmglyh.gis.jichusj.qitays.dao.model.Bixiancd;
import com.hdsx.hmglyh.gis.jichusj.qitays.dao.model.Chuanchengld;
import com.hdsx.hmglyh.gis.jichusj.qitays.dao.model.Guoshuilm;
import com.hdsx.hmglyh.gis.jichusj.qitays.dao.model.Jianzhicun;
import com.hdsx.hmglyh.gis.jichusj.qitays.dao.model.Jumindian;
import com.hdsx.hmglyh.gis.jichusj.qitays.dao.model.Lvhua;
import com.hdsx.hmglyh.gis.jichusj.qitays.dao.model.Lvyoujd;
import com.hdsx.hmglyh.gis.jichusj.qitays.dao.model.Qitalxd;
import com.hdsx.hmglyh.gis.jichusj.qitays.dao.model.Tingchedao;
import com.hdsx.hmglyh.gis.jichusj.qitays.dao.model.Xiangzhen;
import com.hdsx.hmglyh.gis.jichusj.qitays.dao.model.Xuexiao;
import com.hdsx.hmglyh.gis.jichusj.qitays.dao.model.Zirancun;

public interface QitaysMapper {

	List<Jianzhicun> jianzhicunList(Jianzhicun jzc);

	int jianzhicunCount(Jianzhicun jzc);

	List<Jumindian> jumindianList(Jumindian jmd);

	int jumindianCount(Jumindian jmd);

	List<Xiangzhen> xiangzhenList(Xiangzhen xz);

	int xiangzhenCount(Xiangzhen xz);

	List<Zirancun> zirancunList(Zirancun zrc);

	int zirancunCount(Zirancun zrc);

	List<Lvyoujd> lvyoujdList(Lvyoujd lyjd);

  
	int lvyoujdCount(Lvyoujd lyjd);

	List<Xuexiao> xuexiaoList(Xuexiao xx);

	int xuexiaoCount(Xuexiao xx);

	List<Qitalxd> qitalxdList(Qitalxd qtlxd);

	int qitalxdCount(Qitalxd qtlxd);

	List<Guoshuilm> guoshuilmList(Guoshuilm gslm);

	int guoshuilmCount(Guoshuilm gslm);

	List<Bixiancd> bixiancdList(Bixiancd bxcd);

	int bixiancdCount(Bixiancd bxcd);

	List<Tingchedao> tingchedaoList(Tingchedao tcd);

	int tingchedaoCount(Tingchedao tcd);

	List<Lvhua> lvhuaList(Lvhua lh);

	int lvhuaCount(Lvhua lh);
	
	List<Chuanchengld> ChuanchengldList(Chuanchengld chuanchengld);
	
	int ChuanchengldCount(Chuanchengld chuanchengld);
}