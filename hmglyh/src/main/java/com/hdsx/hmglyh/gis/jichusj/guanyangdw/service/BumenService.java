package com.hdsx.hmglyh.gis.jichusj.guanyangdw.service;

import com.hdsx.hmglyh.gis.jichusj.guanyangdw.dao.model.HtglBmb;
import com.hdsx.hmglyh.util.Combotree;

public interface BumenService {
	
	HtglBmb bumenRows(HtglBmb bm);
	
	/**
	 * 部门下拉树
	 * @param id
	 * @return
	 */
	Combotree bumenCombotree(String id);
	
}
