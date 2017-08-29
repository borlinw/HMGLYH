
 /**
 * 北京恒达时讯科技有限公司版权所有
 * Copyright (C) HDSX Corporation. All Rights Reserved
 */
package com.hdsx.hmglyh.basicData.service.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hdsx.hmglyh.basicData.mapper.BbMapper;
import com.hdsx.hmglyh.basicData.service.BbService;
import com.hdsx.hmglyh.util.Combotree;

/**
 * 
 * @author jason
 *
 */
@Service
public class BbServiceImpl implements BbService {
	
	@Resource(name="bbMapper")
	private BbMapper bbMapper;

	

	@Override
	public List<Combotree> getChildren() {
		List<Combotree> children = bbMapper.getChildren();
		return children;
	}

}
