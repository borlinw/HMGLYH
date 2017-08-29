/**
 * 北京恒达时讯科技有限公司版权所有
 * Copyright (C) HDSX Corporation. All Rights Reserved
 */
package com.hdsx.hmglyh.jcpd.service.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hdsx.hmglyh.jcpd.bean.Lkldhfb;
import com.hdsx.hmglyh.jcpd.mapper.LkldhfbMapper;
import com.hdsx.hmglyh.jcpd.service.LkldhfbService;

/**
 * 
 * @author jason
 *
 */
@Transactional
@Service
public class LkldhfbServiceImpl implements LkldhfbService {
	@Resource(name="lkldhfbMapper")
	private LkldhfbMapper lkldhfbMapper;
	
	@Override
	public List<Lkldhfb> getYsld(Lkldhfb lkldhfb) {
		return lkldhfbMapper.getYsld(lkldhfb);
	}
	
	@Override
	public int getYsldCount(Lkldhfb lkldhfb) {
		return lkldhfbMapper.getYsldCount(lkldhfb);
	}

	@Override
	public boolean addYsld(Lkldhfb lkldhfb) {
		lkldhfbMapper.addYsld(lkldhfb);
		return true;
	}

	@Override
	public boolean dropYsld(Lkldhfb lkldhfb) {
		lkldhfbMapper.dropYsld(lkldhfb);
		return true;
	}

	@Override
	public boolean change(Lkldhfb lkldhfb) {
		lkldhfbMapper.change(lkldhfb);
		return true;
	}

	
	

}
