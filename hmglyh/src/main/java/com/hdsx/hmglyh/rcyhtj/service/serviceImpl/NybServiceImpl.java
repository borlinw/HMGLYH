/**
 * 北京恒达时讯科技有限公司版权所有
 * Copyright (C) HDSX Corporation. All Rights Reserved
 */
package com.hdsx.hmglyh.rcyhtj.service.serviceImpl;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hdsx.hmglyh.rcyhtj.bean.Nyb;
import com.hdsx.hmglyh.rcyhtj.mapper.NybMapper;
import com.hdsx.hmglyh.rcyhtj.service.NybService;
/**
 * 
 * @author jason
 *
 */
@Transactional
@Service
public class NybServiceImpl implements NybService {
	@Resource(name="nybMapper")
	private NybMapper nybMapper;
	/**
	 * 查询年月
	 */
	@Override
	public List<Nyb> getNy() {
		return nybMapper.getNy();
	}
	
	@Override
	public List<Nyb> getZyysNy(HashMap<String,String> map) {
		return nybMapper.getZyysNy(map);
	}
	@Override
	public List<Nyb> getYf() {
		return nybMapper.getYf();
	}

}
