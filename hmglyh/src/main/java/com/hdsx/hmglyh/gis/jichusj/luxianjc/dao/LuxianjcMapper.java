package com.hdsx.hmglyh.gis.jichusj.luxianjc.dao;

import java.util.List;

import com.hdsx.hmglyh.gis.jichusj.luxianjc.dao.model.Gaosucrk;
import com.hdsx.hmglyh.gis.jichusj.luxianjc.dao.model.Pingjiaodk;

public interface LuxianjcMapper {

	List<Gaosucrk> gaosucrkList(Gaosucrk crk);

	int gaosucrkCount(Gaosucrk crk);

	List<Pingjiaodk> pingjiaodkList(Pingjiaodk pjdk);

	int pingjiaodkCount(Pingjiaodk pjdk);
    
}