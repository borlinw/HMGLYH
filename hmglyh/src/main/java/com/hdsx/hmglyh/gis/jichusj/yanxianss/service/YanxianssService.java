package com.hdsx.hmglyh.gis.jichusj.yanxianss.service;

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

public interface YanxianssService {
	/**
	 * 交安设施列表
	 * @param jass
	 * @return
	 */
	public List<Jiaoanss> jiaoanssRows(Jiaoanss jass);
	public int jiaoanssCount(Jiaoanss jass);
	
	/**
	 * 交通标志列表
	 * @param jtbz
	 * @return
	 */
	public List<Jiaotongbz> jiaotongbzRows(Jiaotongbz jtbz);
	public int jiaotongbzCount(Jiaotongbz jtbz);
	
	/**
	 * 天桥列表
	 * @param tq
	 * @return
	 */
	public List<Tianqiao> tianqiaoRows(Tianqiao tq);
	public int tianqiaoCount(Tianqiao tq);
	
	/**
	 * 检查站列表
	 * @param jcz
	 * @return
	 */
	public List<Jianchazhan> jianchazhanRows(Jianchazhan jcz);
	public int jianchazhanCount(Jianchazhan jcz);
	
	/**
	 * 交通量观测站 列表
	 * @param gcz
	 * @return
	 */
	public List<Jiaotonglianggcz> jiaotonglianggczRows(Jiaotonglianggcz gcz);
	public int jiaotonglainggczCount(Jiaotonglianggcz gcz);
	
	/**
	 * 多媒体列表
	 * @param dmt
	 * @return
	 */
	public List<Luxiandmtd> luxiandmtdRows(Luxiandmtd dmt);
	public int luxiandmtCount(Luxiandmtd dmt);
	
	/**
	 * 服务区列表
	 * @param fwq
	 * @return
	 */
	public List<Fuwuqu> fuwuquRows(Fuwuqu fwq);
	public int fuwuquCount(Fuwuqu fwq);
	
	
	/**
	 * 沿线服务设施 列表
	 * @param fwss
	 * @return
	 */
	public List<Yanxianfwss> yanxianfwssRows(Yanxianfwss fwss);
	public int yanxianfwssCount(Yanxianfwss fwss);
	
	/**
	 * 收费站 列表
	 */
	public List<Shoufeizhan> shoufeizhanRows(Shoufeizhan sfz);
	public int shoufeizhanCount(Shoufeizhan sfz);
	
	/**
	 * 管理机构
	 * @param gljg
	 * @return
	 */
	public List<Guanlijg> guanlijgRows(Guanlijg gljg);
	public int guanlijgCount(Guanlijg gljg);
	
	/**
	 *  养护站及养护工区
	 * @return
	 */
	public List<Yanghudaoban> yanghudaobanList(Yanghudaoban yanghudaoban);

	public int yanghudaobanCount(Yanghudaoban yanghudaoban);
	
	/**
	 * 路面标线
	 * @param lumianbx
	 * @return
	 */
	public List<LuMianbx> lumianbxList(LuMianbx lumianbx);
	
	public int lumianbxCount(LuMianbx lumianbx);
	/**
	 * 防护工程
	 * @param fanghugc
	 * @return
	 */
	public List<Fanghugc> fanghugcList(Fanghugc fanghugc);
	
	public int fanghugcCount(Fanghugc fanghugc);
}
