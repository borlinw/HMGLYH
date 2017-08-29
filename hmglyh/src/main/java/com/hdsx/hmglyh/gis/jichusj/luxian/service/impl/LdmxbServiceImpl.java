
 /**
 * 北京恒达时讯科技有限公司版权所有
 * Copyright (C) HDSX Corporation. All Rights Reserved
 */
package com.hdsx.hmglyh.gis.jichusj.luxian.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hdsx.hmglyh.gis.jichusj.luxian.dao.LdmxbMapper;
import com.hdsx.hmglyh.gis.jichusj.luxian.dao.model.Ldmxb;
import com.hdsx.hmglyh.gis.jichusj.luxian.service.LdmxbService;

/**  
 *  
 * @author Baiyy
 * @created 2016年6月13日 下午6:50:23 
 */
@Service
public class LdmxbServiceImpl implements LdmxbService {
	@Resource(name="ldmxbMapper")
	private LdmxbMapper ldmxbMapper;

	@Override
	public List<Ldmxb> getMxb(Ldmxb ldmxb) {
		return ldmxbMapper.getMxb(ldmxb);
	}

	@Override
	public int getMxbCount(Ldmxb ldmxb) {
		return ldmxbMapper.getMxbCount(ldmxb);
	}

}
