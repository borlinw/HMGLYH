/**
 * 北京恒达时讯科技有限公司版权所有
 * Copyright (C) HDSX Corporation. All Rights Reserved
 */
package com.hdsx.hmglyh.basicData.service.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hdsx.hmglyh.basicData.bean.Lxld;
import com.hdsx.hmglyh.basicData.mapper.LxldMapper;
import com.hdsx.hmglyh.basicData.service.LxldService;

/**  
 *  
 * @author Baiyy
 * @created 2015年6月8日 上午11:21:14 
 */
@Service
public class LxldServiceImpl implements LxldService {
	@Resource(name="lxldMapper")
	private LxldMapper lxldMapper;
	
	@Override
	public List<Lxld> getLdCombo(Lxld l) {
		String bmlx = lxldMapper.getBmlx(l.getBmCode());
		l.setBmlx(bmlx);
		return lxldMapper.getLd(l);
	}
	
	@Override
	public List<Lxld> getLdCombo2(Lxld l) {
		String bmlx = lxldMapper.getBmlx(l.getBmCode());
		l.setBmlx(bmlx);
		return lxldMapper.getLd2(l);
	}

	@Override
	public List<Lxld> getLxCombo() {
		return lxldMapper.getLx();
	}

	@Override
	public List<Lxld> getTsbmLxldCombo(Lxld lxld) {
			String bmlx = lxldMapper.getBmlx(lxld.getBmCode());
			lxld.setBmlx(bmlx);
		return lxldMapper.getTsbmLxldCombo(lxld);
	}

}
