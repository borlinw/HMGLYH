package com.hdsx.hmglyh.gis.jichusj.gouzaowu.dao;

import java.util.List;

import com.hdsx.hmglyh.dao.Mapper;
import com.hdsx.hmglyh.gis.jichusj.gouzaowu.dao.model.Hddqjcb;
import com.hdsx.hmglyh.gis.jichusj.gouzaowu.dao.model.Hdjcxjcb;
import com.hdsx.hmglyh.gis.jichusj.gouzaowu.dao.model.Qhjc;
import com.hdsx.hmglyh.gis.jichusj.gouzaowu.dao.model.Qlbjqstpb;
import com.hdsx.hmglyh.gis.jichusj.gouzaowu.dao.model.Qldqjcb;
import com.hdsx.hmglyh.gis.jichusj.gouzaowu.dao.model.Qljcxjcb;
@Mapper
public interface QhjcMapper {
	
	//桥梁定期检查
	int addQldqjc(Qhjc q);
	
	List<Qldqjcb> queryQldqjc(Qhjc q);
	
	int getQldqjcCount(Qhjc q);
	
	int dropTpbm(String qljcxjcid);
	
	int addTpbm(Qlbjqstpb q);
	
	List<Qlbjqstpb> getTpbm(String qldqjcid);
	
	
	//桥梁经常经检查
	int addQljcxjc(Qhjc q);
	
	List<Qljcxjcb> queryQljcxjc(Qhjc q);
	
	int getQljcxjcCount(Qhjc q);
	
	//涵洞定期检查
	int addHddqjc(Qhjc q);
	
	List<Hddqjcb> queryHddqjc(Qhjc q);
	
	int getHddqjcCount(Qhjc q);
	
	
	//涵洞经常性检查
	int addHdjcxjc(Qhjc q);
	
	List<Hdjcxjcb> queryHdjcxjc(Qhjc q);
	
	int getHdjcxjcCount(Qhjc q);
	
}