
 /**
 * 北京恒达时讯科技有限公司版权所有
 * Copyright (C) HDSX Corporation. All Rights Reserved
 */
package com.hdsx.hmglyh.jcpd.service.serviceImpl;

import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hdsx.hmglyh.jcpd.bean.Gzdxzb;
import com.hdsx.hmglyh.jcpd.mapper.GzdxzbMapper;
import com.hdsx.hmglyh.jcpd.service.GzdxzbService;

/**  
 *  
 * @author Baiyy
 * @created 2015年7月17日 上午9:52:07 
 */
@Transactional
@Service
public class GzdxzbServiceImpl implements GzdxzbService {
	@Resource(name="gzdxzbMapper")
	private GzdxzbMapper gzdxzbMapper;
	
	@Override
	public String getZbid(Gzdxzb gzdxzb) {
		Gzdxzb g = gzdxzbMapper.getZb(gzdxzb);
		if(g != null)
			return g.getGzid();
		else{
			gzdxzb.setGzid(UUID.randomUUID().toString());
			System.out.println(gzdxzb.getGzid()+"=="+gzdxzb.getBmCode()+"=="+gzdxzb.getSsny()+"==");
			gzdxzbMapper.addZb(gzdxzb);
			gzdxzbMapper.addFb(gzdxzb);
			return gzdxzb.getGzid();
		}
	}

}
