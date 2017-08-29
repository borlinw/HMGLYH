
 /**
 * 北京恒达时讯科技有限公司版权所有
 * Copyright (C) HDSX Corporation. All Rights Reserved
 */
package com.hdsx.hmglyh.gis.jichusj.luxian.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hdsx.hmglyh.gis.jichusj.luxian.dao.LishiweixiujlMapper;
import com.hdsx.hmglyh.gis.jichusj.luxian.dao.model.Attachment;
import com.hdsx.hmglyh.gis.jichusj.luxian.dao.model.Lishiweixiujl;
import com.hdsx.hmglyh.gis.jichusj.luxian.service.LishiweixiujlService;

/**  
 *  
 * @author Baiyy
 * @created 2016年6月18日 下午2:11:07 
 */
@Service
@Transactional
public class LishiweixiujlServiceImpl implements LishiweixiujlService {
	@Resource(name="lishiweixiujlMapper")
	private LishiweixiujlMapper lswxjlMapper;
	
	
	@Override
	public boolean add(Lishiweixiujl lswxjl) {
		lswxjlMapper.deleteById(lswxjl);
		if(lswxjlMapper.add(lswxjl) != -1){
			for(Attachment a:lswxjl.getAttachment()){
				if(lswxjlMapper.addAttachment(a) == -1)
					return false;
			}
			return true;
		}
		return false;
	}

	@Override
	public boolean change(Lishiweixiujl lswxjl) {
		if(lswxjlMapper.change(lswxjl)==-1)
			return false;
		return true;
	}

	@Override
	public List<Lishiweixiujl> getMxb(Lishiweixiujl lswxjl) {
		List<Lishiweixiujl> list = lswxjlMapper.getMxb(lswxjl);
		for(Lishiweixiujl l:list){
			l.setAttachment(lswxjlMapper.getAttachment(l));
		}
		return list;
	}

	@Override
	public int getMxbCount(Lishiweixiujl lswxjl) {
		return lswxjlMapper.getMxbCount(lswxjl);
	}

	@Override
	public Lishiweixiujl getMxbById(Lishiweixiujl lswxjl) {
		Lishiweixiujl l = lswxjlMapper.getMxbById(lswxjl);
		l.setAttachment(lswxjlMapper.getAttachment(l));
		return l;
	}

}
