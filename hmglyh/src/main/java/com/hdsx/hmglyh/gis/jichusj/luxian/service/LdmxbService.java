
 /**
 * 北京恒达时讯科技有限公司版权所有
 * Copyright (C) HDSX Corporation. All Rights Reserved
 */
package com.hdsx.hmglyh.gis.jichusj.luxian.service;

import java.util.List;

import com.hdsx.hmglyh.gis.jichusj.luxian.dao.model.Ldmxb;

/**  
 *  
 * @author Baiyy
 * @created 2016年6月13日 下午6:48:29 
 */

public interface LdmxbService {
	/**
	 * 获取路段明细表详细信息
	 * @param ldmxb
	 * @return
	 */
	List<Ldmxb> getMxb(Ldmxb ldmxb);
	/**
	 * 获取路段明细表条数
	 * @param ldmxb
	 * @return
	 */
	int getMxbCount(Ldmxb ldmxb);
}
