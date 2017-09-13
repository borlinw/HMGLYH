package com.hdsx.hmglyh.gis.jichusj.gouzaowu.service;

import java.util.List;

import com.hdsx.hmglyh.gis.jichusj.gouzaowu.dao.model.Hddqjcb;
import com.hdsx.hmglyh.gis.jichusj.gouzaowu.dao.model.Hdjcxjcb;
import com.hdsx.hmglyh.gis.jichusj.gouzaowu.dao.model.Qhjc;
import com.hdsx.hmglyh.gis.jichusj.gouzaowu.dao.model.Qlbjqstpb;
import com.hdsx.hmglyh.gis.jichusj.gouzaowu.dao.model.Qldqjcb;
import com.hdsx.hmglyh.gis.jichusj.gouzaowu.dao.model.Qljcxjcb;

/**  
 *  
 * @author Baiyy
 * @created 2017年9月4日 下午11:11:35 
 */

public interface QhjcService {
	
	//桥梁定期检查
	boolean addQldqjc(Qhjc q);
	
	List<Qldqjcb> queryQldqjc(Qhjc q);
	
	int getQldqjcCount(Qhjc q);
	
	boolean addTpbm(List<Qlbjqstpb> list);
	
	List<Qlbjqstpb> getTpbm(String qldqjcid);
	
	
	//桥梁经常性检查
	boolean addQljcxjc(Qhjc q);
	
	List<Qljcxjcb> queryQljcxjc(Qhjc q);
	
	int getQljcxjcCount(Qhjc q);
	
	//涵洞定期检查
	boolean addHddqjc(Qhjc q);
	
	List<Hddqjcb> queryHddqjc(Qhjc q);
	
	int getHddqjcCount(Qhjc q);
	
	//涵洞经常性检查
	boolean addHdjcxjc(Qhjc q);
	
	List<Hdjcxjcb> queryHdjcxjc(Qhjc q);
	
	int getHdjcxjcCount(Qhjc q);
	
	
}
