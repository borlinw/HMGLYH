
 /**
 * 北京恒达时讯科技有限公司版权所有
 * Copyright (C) HDSX Corporation. All Rights Reserved
 */
package com.hdsx.hmglyh.gis.jichusj.pub.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hdsx.hmglyh.gis.jichusj.pub.dao.PublicBeanMapper;
import com.hdsx.hmglyh.gis.jichusj.pub.dao.model.PublicBean;
import com.hdsx.hmglyh.gis.jichusj.pub.service.PublicBeanService;

/**  
 *  
 * @author Baiyy
 * @created 2016年5月25日 上午10:08:43 
 */
@Service
@Transactional
public class PublicBeanServiceImpl implements PublicBeanService {
	@Resource(name="publicBeanMapper")
	private PublicBeanMapper pbMapper;

	@Override
	public List<String> getData(PublicBean pb) {
		return pbMapper.getData(pb);
	}

}
