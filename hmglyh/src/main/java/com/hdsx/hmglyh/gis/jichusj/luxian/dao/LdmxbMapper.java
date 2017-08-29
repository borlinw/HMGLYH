
 /**
 * 北京恒达时讯科技有限公司版权所有
 * Copyright (C) HDSX Corporation. All Rights Reserved
 */
package com.hdsx.hmglyh.gis.jichusj.luxian.dao;

import java.util.List;

import com.hdsx.hmglyh.gis.jichusj.luxian.dao.model.Ldmxb;

/**  
 *  
 * @author Baiyy
 * @created 2016年6月13日 下午6:28:42 
 */

public interface LdmxbMapper {
	List<Ldmxb> getMxb(Ldmxb ldmxb);
	
	int getMxbCount(Ldmxb ldmxb);
}
