
 /**
 * 北京恒达时讯科技有限公司版权所有
 * Copyright (C) HDSX Corporation. All Rights Reserved
 */
package com.hdsx.hmglyh.gis.jichusj.luxian.dao;

import java.util.List;

import com.hdsx.hmglyh.gis.jichusj.luxian.dao.model.Attachment;
import com.hdsx.hmglyh.gis.jichusj.luxian.dao.model.Lishiweixiujl;

/**  
 *  
 * @author Baiyy
 * @created 2016年6月15日 下午4:18:48 
 */

public interface LishiweixiujlMapper {
	
	int add(Lishiweixiujl lswxjl);
	
	int change(Lishiweixiujl lswxjl);
	
	int deleteById(Lishiweixiujl lswxjl);
	
	List<Lishiweixiujl> getMxb(Lishiweixiujl lswxjl);
	
	int getMxbCount(Lishiweixiujl lswxjl);
	
	Lishiweixiujl getMxbById(Lishiweixiujl lswxjl);
	
	int addAttachment(Attachment attachment);
	
	List<Attachment> getAttachment(Lishiweixiujl lswxjl);
	
	int dropAttachment(String id);
}
