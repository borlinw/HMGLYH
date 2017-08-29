package com.hdsx.hmglyh.gis.jichusj.yanxianss.dao;

import java.util.List;

import com.hdsx.hmglyh.gis.jichusj.yanxianss.dao.model.Fanghugc;
import com.hdsx.hmglyh.gis.jichusj.yanxianss.dao.model.Fuwuqu;
import com.hdsx.hmglyh.gis.jichusj.yanxianss.dao.model.Guanlijg;
import com.hdsx.hmglyh.gis.jichusj.yanxianss.dao.model.Jianchazhan;
import com.hdsx.hmglyh.gis.jichusj.yanxianss.dao.model.Jiaoanss;
import com.hdsx.hmglyh.gis.jichusj.yanxianss.dao.model.Jiaotongbz;
import com.hdsx.hmglyh.gis.jichusj.yanxianss.dao.model.Jiaotonglianggcz;
import com.hdsx.hmglyh.gis.jichusj.yanxianss.dao.model.LuMianbx;
import com.hdsx.hmglyh.gis.jichusj.yanxianss.dao.model.Luxiandmtd;
import com.hdsx.hmglyh.gis.jichusj.yanxianss.dao.model.Shoufeizhan;
import com.hdsx.hmglyh.gis.jichusj.yanxianss.dao.model.Tianqiao;
import com.hdsx.hmglyh.gis.jichusj.yanxianss.dao.model.Yanghudaoban;
import com.hdsx.hmglyh.gis.jichusj.yanxianss.dao.model.Yanxianfwss;


public interface YanxianssMapper {

	List<Jiaoanss> jiaoanssList(Jiaoanss jass);

	int jiaoanssCount(Jiaoanss jass);

	List<Jiaotongbz> jiaotongbzList(Jiaotongbz jtbz);

	int jiaotongbzCount(Jiaotongbz jtbz);

	List<Tianqiao> tianqiaoList(Tianqiao tq);

	int tianqiaoCount(Tianqiao tq);

	List<Jianchazhan> jianchazhanList(Jianchazhan jcz);

	int jianchazhanCount(Jianchazhan jcz);

	List<Jiaotonglianggcz> jiaotonglianggczList(Jiaotonglianggcz gcz);

	int jiaotonglianggczCount(Jiaotonglianggcz gcz);

	List<Luxiandmtd> luxiandmtdList(Luxiandmtd dmt);

	int luxiandmtdCount(Luxiandmtd dmt);

	List<Fuwuqu> fuwuquList(Fuwuqu fwq);

	int fuwuquCount(Fuwuqu fwq);

	List<Yanxianfwss> yanxianfwssList(Yanxianfwss fwss);

	int yanxianfwssCount(Yanxianfwss fwss);

	List<Shoufeizhan> shoufeizhanList(Shoufeizhan sfz);

	int shoufeizhanCount(Shoufeizhan sfz);

	List<Guanlijg> guanlijgList(Guanlijg gljg);

	int guanlijgCount(Guanlijg gljg);
	
	 
    List<Yanghudaoban> yanghudaobanList(Yanghudaoban yanghudaoban);

	int yanghudaobanCount(Yanghudaoban yanghudaoban);
	
	List<LuMianbx> lumianbxList(LuMianbx lumianbx);
	
	int lumianbxCount(LuMianbx lumianbx);
	
	List<Fanghugc> fanghugcList(Fanghugc fanghugc);
	
	int fanghugcCount(Fanghugc fanghugc);
}