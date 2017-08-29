
 /**
 * 北京恒达时讯科技有限公司版权所有
 * Copyright (C) HDSX Corporation. All Rights Reserved
 */
package com.hdsx.hmglyh.basicData.service.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hdsx.hmglyh.basicData.mapper.DgyldBmMapper;
import com.hdsx.hmglyh.basicData.service.DgyldBmService;
import com.hdsx.hmglyh.htgl.bean.HtglBm;
import com.hdsx.hmglyh.util.Combotree;

/**
 * 
 * @author jason
 *
 */
@Service
public class DgyldBmServiceImpl implements DgyldBmService {
	
	@Resource(name="dgyldBmMapper")
	private DgyldBmMapper dgyldBmMapper;

	@Override
	public Combotree getBmCombo(HtglBm bm) {
		Combotree parent = dgyldBmMapper.getParent(bm.getBmcode());
		parent.setChildren(getChildren(bm));
		return parent;
	}
	
	
	private List<Combotree> getChildren(HtglBm bm){
		List<Combotree> children = dgyldBmMapper.getChildren(bm);
		for(Combotree c:children){
			HtglBm b = new HtglBm();
			b.setBmcode(c.getId());
			List<Combotree> child = dgyldBmMapper.getChildren(b);
			c.setChildren(child);
		}
		return children;
	}
}
