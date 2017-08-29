package com.hdsx.hmglyh.gis.jichusj.yingjiqx.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hdsx.hmglyh.gis.jichusj.yingjiqx.dao.YingjiqxMapper;
import com.hdsx.hmglyh.gis.jichusj.yingjiqx.dao.model.Dizhizhd;
import com.hdsx.hmglyh.gis.jichusj.yingjiqx.dao.model.Wuziku;
import com.hdsx.hmglyh.gis.jichusj.yingjiqx.dao.model.Yingjibzd;
import com.hdsx.hmglyh.gis.jichusj.yingjiqx.dao.model.Zaihaiyfld;
import com.hdsx.hmglyh.gis.jichusj.yingjiqx.service.YingjiqxService;
@Service
public class YingjiqxServiceImpl implements YingjiqxService {

	@Autowired
	private YingjiqxMapper yingjiqxMapper;
	
	@Override
	public List<Dizhizhd> dizhizhdRows(Dizhizhd dzzhd) {
		
		return yingjiqxMapper.dizhizhdList(dzzhd);
	}

	@Override
	public int dizhizhdCount(Dizhizhd dzzhd) {
		
		return yingjiqxMapper.dizhizhdCount(dzzhd);
	}

	@Override
	public List<Zaihaiyfld> zaihaiyfldRows(Zaihaiyfld zhyfld) {
		
		return yingjiqxMapper.zaihaiyfldList(zhyfld);
	}

	@Override
	public int zaihaiyfldCount(Zaihaiyfld zhyfld) {
		
		return yingjiqxMapper.zaihaiyfldCount(zhyfld);
	}

	@Override
	public List<Wuziku> wuzikuRows(Wuziku wzk) {
		
		return yingjiqxMapper.wuzikuList(wzk);
	}

	@Override
	public int wuzikuCount(Wuziku wzk) {
		
		return yingjiqxMapper.wuzikuCount(wzk);
	}

	@Override
	public List<Yingjibzd> yingjibzdRows(Yingjibzd yjbzd) {
		
		return yingjiqxMapper.yingjibzdList(yjbzd);
	}

	@Override
	public int yingjibzdCount(Yingjibzd yjbzd) {
		
		return yingjiqxMapper.yingjibzdCount(yjbzd);
	}

}
