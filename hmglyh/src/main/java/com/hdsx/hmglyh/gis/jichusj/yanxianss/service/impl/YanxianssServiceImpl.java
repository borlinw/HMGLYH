package com.hdsx.hmglyh.gis.jichusj.yanxianss.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hdsx.hmglyh.gis.jichusj.yanxianss.dao.YanxianssMapper;
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
import com.hdsx.hmglyh.gis.jichusj.yanxianss.service.YanxianssService;
@Service
public class YanxianssServiceImpl implements YanxianssService {

	@Autowired
	private YanxianssMapper yanxianssMapper;
	
	@Override
	public List<Jiaoanss> jiaoanssRows(Jiaoanss jass) {
		
		return yanxianssMapper.jiaoanssList(jass);
	}

	@Override
	public int jiaoanssCount(Jiaoanss jass) {
		
		return yanxianssMapper.jiaoanssCount(jass);
	}

	@Override
	public List<Jiaotongbz> jiaotongbzRows(Jiaotongbz jtbz) {
		
		return yanxianssMapper.jiaotongbzList(jtbz);
	}

	@Override
	public int jiaotongbzCount(Jiaotongbz jtbz) {
		
		return yanxianssMapper.jiaotongbzCount(jtbz);
	}

	@Override
	public List<Tianqiao> tianqiaoRows(Tianqiao tq) {
		
		return yanxianssMapper.tianqiaoList(tq);
	}

	@Override
	public int tianqiaoCount(Tianqiao tq) {
		
		return yanxianssMapper.tianqiaoCount(tq);
	}

	@Override
	public List<Jianchazhan> jianchazhanRows(Jianchazhan jcz) {
		
		return yanxianssMapper.jianchazhanList(jcz);
	}

	@Override
	public int jianchazhanCount(Jianchazhan jcz) {
		
		return yanxianssMapper.jianchazhanCount(jcz);
	}

	@Override
	public List<Jiaotonglianggcz> jiaotonglianggczRows(Jiaotonglianggcz gcz) {
		
		return yanxianssMapper.jiaotonglianggczList(gcz);
	}

	@Override
	public int jiaotonglainggczCount(Jiaotonglianggcz gcz) {
		
		return yanxianssMapper.jiaotonglianggczCount(gcz);
	}

	@Override
	public List<Luxiandmtd> luxiandmtdRows(Luxiandmtd dmt) {
		
		return yanxianssMapper.luxiandmtdList(dmt);
	}

	@Override
	public int luxiandmtCount(Luxiandmtd dmt) {
		
		return yanxianssMapper.luxiandmtdCount(dmt);
	}

	@Override
	public List<Fuwuqu> fuwuquRows(Fuwuqu fwq) {
		
		return yanxianssMapper.fuwuquList(fwq);
	}

	@Override
	public int fuwuquCount(Fuwuqu fwq) {
		
		return yanxianssMapper.fuwuquCount(fwq);
	}

	@Override
	public List<Yanxianfwss> yanxianfwssRows(Yanxianfwss fwss) {
		
		return yanxianssMapper.yanxianfwssList(fwss);
	}

	@Override
	public int yanxianfwssCount(Yanxianfwss fwss) {
		
		return yanxianssMapper.yanxianfwssCount(fwss);
	}

	@Override
	public List<Shoufeizhan> shoufeizhanRows(Shoufeizhan sfz) {
		
		return yanxianssMapper.shoufeizhanList(sfz);
	}

	@Override
	public int shoufeizhanCount(Shoufeizhan sfz) {
		
		return yanxianssMapper.shoufeizhanCount(sfz);
	}

	@Override
	public List<Guanlijg> guanlijgRows(Guanlijg gljg) {
		
		return yanxianssMapper.guanlijgList(gljg);
	}

	@Override
	public int guanlijgCount(Guanlijg gljg) {
		
		return yanxianssMapper.guanlijgCount(gljg);
	}

	@Override
	public List<Yanghudaoban> yanghudaobanList(Yanghudaoban yanghudaoban) {
		return yanxianssMapper.yanghudaobanList(yanghudaoban);
	}

	@Override
	public int yanghudaobanCount(Yanghudaoban yanghudaoban) {
		return yanxianssMapper.yanghudaobanCount(yanghudaoban);
	}

	@Override
	public List<LuMianbx> lumianbxList(LuMianbx lumianbx) {
		return yanxianssMapper.lumianbxList(lumianbx);
	}

	@Override
	public int lumianbxCount(LuMianbx lumianbx) {
		return yanxianssMapper.lumianbxCount(lumianbx);
	}

	@Override
	public List<Fanghugc> fanghugcList(Fanghugc fanghugc) {
		return yanxianssMapper.fanghugcList(fanghugc);
	}

	@Override
	public int fanghugcCount(Fanghugc fanghugc) {
		return yanxianssMapper.fanghugcCount(fanghugc);
	}

}
