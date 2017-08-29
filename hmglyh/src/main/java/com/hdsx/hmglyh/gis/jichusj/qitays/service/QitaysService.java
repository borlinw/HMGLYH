package com.hdsx.hmglyh.gis.jichusj.qitays.service;

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

public interface QitaysService {
	/**
	 * 建制村列表
	 * @param jzc
	 * @return
	 */
	public List<Jianzhicun> jianzhicunRows(Jianzhicun jzc);
	public int jianzhicunCount(Jianzhicun jzc);
	
	/**
	 * 居民点列表
	 * @param jmd
	 * @return
	 */
	public List<Jumindian> jumindianRows(Jumindian jmd);
	public int jumindianCount(Jumindian jmd);
	
	/**
	 * 乡镇列表
	 * @param xz
	 * @return
	 */
	public List<Xiangzhen> xiangzhenRows(Xiangzhen xz);
	public int xiangzhenCount(Xiangzhen xz);
	
	
	/**
	 * 自然村列表
	 * @param zrc
	 * @return
	 */
	public List<Zirancun> zirancunRows(Zirancun zrc);
	public int zirancunCount(Zirancun zrc);
	
	/**
	 * 旅游景点列表
	 * @param lyjd
	 * @return
	 */
	public List<Lvyoujd> lvyoujdRows(Lvyoujd lyjd);
	public int lvyoujdCount(Lvyoujd lyjd);
	
	/**
	 * 学校列表
	 * @param xx
	 * @return
	 */
	public List<Xuexiao> xuexiaoRows(Xuexiao xx);
	public int xuexiaoCount(Xuexiao xx);
	
	/**
	 * 其他类型点列表
	 * @param qtlxd
	 * @return
	 */
	public List<Qitalxd> qitalxdRows(Qitalxd qtlxd);
	public int qitalxdCount(Qitalxd qtlxd);
	
	/**
	 * 过水路面列表
	 * @param gslm
	 * @return
	 */
	public List<Guoshuilm> guoshuilmRows(Guoshuilm gslm);
	public int guoshuilmCount(Guoshuilm gslm);
	
	/**
	 * 避险车道列表
	 * @param bxcd
	 * @return
	 */
	public List<Bixiancd> bixiancdRows(Bixiancd bxcd);
	public int bixiancdCount(Bixiancd bxcd);
	
	/**
	 * 停车道列表
	 * @param tcd
	 * @return
	 */
	public List<Tingchedao> tingchedaoRows(Tingchedao tcd);
	public int tingchedaoCount(Tingchedao tcd);
	
	/**
	 * 绿化列表
	 * @param lh
	 * @return
	 */
	public List<Lvhua> lvhuaRows(Lvhua lh);
	public int lvhuaCount(Lvhua lh);
	
	/**
	 *  穿城路段 
	 */
	public List<Chuanchengld> ChuanchengldList(Chuanchengld chuanchengld);
	
	public int ChuanchengldCount(Chuanchengld chuanchengld);
	
	
}
