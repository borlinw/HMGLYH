package com.hdsx.hmglyh.gis.jichusj.qitays.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hdsx.hmglyh.gis.jichusj.qitays.dao.QitaysMapper;
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
import com.hdsx.hmglyh.gis.jichusj.qitays.service.QitaysService;
@Service
public class QitaysServiceImpl implements QitaysService {

	@Autowired
	private QitaysMapper qitaysMapper;	
	
	@Override
	public List<Jianzhicun> jianzhicunRows(Jianzhicun jzc) {
		
		return qitaysMapper.jianzhicunList(jzc);
	}

	@Override
	public int jianzhicunCount(Jianzhicun jzc) {
		
		return qitaysMapper.jianzhicunCount(jzc);
	}

	@Override
	public List<Jumindian> jumindianRows(Jumindian jmd) {
		
		return qitaysMapper.jumindianList(jmd);
	}

	@Override
	public int jumindianCount(Jumindian jmd) {
		
		return qitaysMapper.jumindianCount(jmd);
	}

	@Override
	public List<Xiangzhen> xiangzhenRows(Xiangzhen xz) {
		
		return qitaysMapper.xiangzhenList(xz);
	}

	@Override
	public int xiangzhenCount(Xiangzhen xz) {
		
		return qitaysMapper.xiangzhenCount(xz);
	}

	@Override
	public List<Zirancun> zirancunRows(Zirancun zrc) {
		
		return qitaysMapper.zirancunList(zrc);
	}

	@Override
	public int zirancunCount(Zirancun zrc) {
		
		return qitaysMapper.zirancunCount(zrc);
	}

	@Override
	public List<Lvyoujd> lvyoujdRows(Lvyoujd lyjd) {
		
		return qitaysMapper.lvyoujdList(lyjd);
	}

	@Override
	public int lvyoujdCount(Lvyoujd lyjd) {
		
		return qitaysMapper.lvyoujdCount(lyjd);
	}

	@Override
	public List<Xuexiao> xuexiaoRows(Xuexiao xx) {
		
		return qitaysMapper.xuexiaoList(xx);
	}

	@Override
	public int xuexiaoCount(Xuexiao xx) {
		
		return qitaysMapper.xuexiaoCount(xx);
	}

	@Override
	public List<Qitalxd> qitalxdRows(Qitalxd qtlxd) {
		
		return qitaysMapper.qitalxdList(qtlxd);
	}

	@Override
	public int qitalxdCount(Qitalxd qtlxd) {
		
		return qitaysMapper.qitalxdCount(qtlxd);
	}

	@Override
	public List<Guoshuilm> guoshuilmRows(Guoshuilm gslm) {
		
		return qitaysMapper.guoshuilmList(gslm);
	}

	@Override
	public int guoshuilmCount(Guoshuilm gslm) {
		
		return qitaysMapper.guoshuilmCount(gslm);
	}

	@Override
	public List<Bixiancd> bixiancdRows(Bixiancd bxcd) {
		
		return qitaysMapper.bixiancdList(bxcd);
	}

	@Override
	public int bixiancdCount(Bixiancd bxcd) {
		
		return qitaysMapper.bixiancdCount(bxcd);
	}

	@Override
	public List<Tingchedao> tingchedaoRows(Tingchedao tcd) {
		
		return qitaysMapper.tingchedaoList(tcd);
	}

	@Override
	public int tingchedaoCount(Tingchedao tcd) {
		
		return qitaysMapper.tingchedaoCount(tcd);
	}

	@Override
	public List<Lvhua> lvhuaRows(Lvhua lh) {
		
		return qitaysMapper.lvhuaList(lh);
	}

	@Override
	public int lvhuaCount(Lvhua lh) {
		
		return qitaysMapper.lvhuaCount(lh);
	}

	@Override
	public List<Chuanchengld> ChuanchengldList(Chuanchengld chuanchengld) {
		// TODO Auto-generated method stub
		return qitaysMapper.ChuanchengldList(chuanchengld);
	}

	@Override
	public int ChuanchengldCount(Chuanchengld chuanchengld) {
		// TODO Auto-generated method stub
		return qitaysMapper.ChuanchengldCount(chuanchengld);
	}

}
