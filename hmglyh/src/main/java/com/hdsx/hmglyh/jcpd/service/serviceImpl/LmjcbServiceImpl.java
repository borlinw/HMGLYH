
 /**
 * 北京恒达时讯科技有限公司版权所有
 * Copyright (C) HDSX Corporation. All Rights Reserved
 */
package com.hdsx.hmglyh.jcpd.service.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hdsx.hmglyh.jcpd.bean.Lmjcb;
import com.hdsx.hmglyh.jcpd.mapper.LmjcbMapper;
import com.hdsx.hmglyh.jcpd.service.LmjcbService;

/**  
 *  
 * @author Baiyy
 * @created 2015年6月25日 下午3:58:21 
 */
@Transactional
@Service
public class LmjcbServiceImpl implements LmjcbService {
	@Resource(name="lmjcbMapper")
	private LmjcbMapper lmjcbMapper;
	
	
	@Override
	public List<Lmjcb> getLmjc(Lmjcb l) {
		return lmjcbMapper.getLmjc(l);
	}

	@Override
	public int getLmjcCount(Lmjcb l) {
		return lmjcbMapper.getLmjcCount(l);
	}

	@Override
	public boolean copy(Lmjcb lmjcb) {
		lmjcbMapper.clear(lmjcb);
		System.out.println(lmjcb.getBbid()+"===旧==="+lmjcb.getJcbbid());
		if(lmjcbMapper.copy(lmjcb) == -1)
			return false;
		return true;
	}

}
