package com.hdsx.hmglyh.gis.jichusj.luxianjc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hdsx.hmglyh.gis.jichusj.luxianjc.dao.LuxianjcMapper;
import com.hdsx.hmglyh.gis.jichusj.luxianjc.dao.model.Gaosucrk;
import com.hdsx.hmglyh.gis.jichusj.luxianjc.dao.model.Pingjiaodk;
import com.hdsx.hmglyh.gis.jichusj.luxianjc.service.LuxianjcService;

@Service
public class LuxianjcServiceImpl implements LuxianjcService {

	@Autowired
	private LuxianjcMapper luxianjcMapper;
	
	@Override
	public List<Gaosucrk> gaosucrkRows(Gaosucrk crk) {
		
		return luxianjcMapper.gaosucrkList(crk);
	}

	@Override
	public int gaosucrkCount(Gaosucrk crk) {
		
		return luxianjcMapper.gaosucrkCount(crk);
	}

	@Override
	public List<Pingjiaodk> pingjiaodkRows(Pingjiaodk pjdk) {
		
		return luxianjcMapper.pingjiaodkList(pjdk);
	}

	@Override
	public int pingjiaodkCount(Pingjiaodk pjdk) {
		
		return luxianjcMapper.pingjiaodkCount(pjdk);
	}

}
