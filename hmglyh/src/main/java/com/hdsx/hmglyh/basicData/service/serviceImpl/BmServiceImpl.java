
 /**
 * 北京恒达时讯科技有限公司版权所有
 * Copyright (C) HDSX Corporation. All Rights Reserved
 */
package com.hdsx.hmglyh.basicData.service.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hdsx.hmglyh.basicData.mapper.BmMapper;
import com.hdsx.hmglyh.basicData.service.BmService;
import com.hdsx.hmglyh.htgl.bean.HtglBm;
import com.hdsx.hmglyh.util.Combobox;
import com.hdsx.hmglyh.util.Combotree;

/**  
 *  
 * @author Baiyy
 * @created 2015年7月20日 上午11:19:29 
 */
@Service
public class BmServiceImpl implements BmService {
	
	@Resource(name="bmMapper")
	private BmMapper bmMapper;

	@Override
	public Combotree getBmCombo(HtglBm bm) {
		Combotree parent = bmMapper.getParent(bm.getBmcode());
		parent.setChildren(getChildren(bm));
		return parent;
	}
	
	
	private List<Combotree> getChildren(HtglBm bm){
		System.out.println(bm.getBmcode()+"============"+bm.getBmlx());
		List<Combotree> children = bmMapper.getChildren(bm);
		for(Combotree c:children){
			HtglBm b = new HtglBm();
			b.setBmcode(c.getId());
			b.setBmlx(bm.getBmlx());
			List<Combotree> child = bmMapper.getChildren(b);
			c.setChildren(child);
		}
		return children;
	}


	@Override
	public List<Combobox> getBmForXd(String bmCode) {
		String bmcode = bmCode;
		if(bmCode.length() > 6)
			bmcode = bmCode.substring(0, 6);
		
		return bmMapper.getBmForXd(bmcode);
	}
}
