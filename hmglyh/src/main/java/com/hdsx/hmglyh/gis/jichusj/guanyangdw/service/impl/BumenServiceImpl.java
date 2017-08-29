package com.hdsx.hmglyh.gis.jichusj.guanyangdw.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hdsx.hmglyh.gis.jichusj.guanyangdw.dao.HtglBmbMapper;
import com.hdsx.hmglyh.gis.jichusj.guanyangdw.dao.model.HtglBmb;
import com.hdsx.hmglyh.gis.jichusj.guanyangdw.service.BumenService;
import com.hdsx.hmglyh.util.Combotree;

@Service
public class BumenServiceImpl implements BumenService {

	@Autowired
	HtglBmbMapper hbMapper;
	
	@Override
	public HtglBmb bumenRows(HtglBmb bm) {
		HtglBmb bmb = hbMapper.bumenList(bm);
		bmb.setBmcode(bm.getBmcode());
		for( HtglBmb hb : bmb.getChildren() ) {
			getBmchilren(hb);
		}
		return bmb;
	}
	
	public void getBmchilren(HtglBmb bmb) {
		HtglBmb bm = hbMapper.bumenList(bmb);
		if( bm.getChildren() == null ) {
			return;
		}else{
			bmb.setChildren(bm.getChildren());
		}
	}

	@Override
	public Combotree bumenCombotree(String id) {
		return hbMapper.selectBmCombotree(id);
	}

}
