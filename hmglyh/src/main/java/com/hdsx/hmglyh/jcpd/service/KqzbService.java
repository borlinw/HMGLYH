
 /**
 * 北京恒达时讯科技有限公司版权所有
 * Copyright (C) HDSX Corporation. All Rights Reserved
 */
package com.hdsx.hmglyh.jcpd.service;

import com.hdsx.hmglyh.jcpd.bean.Kqzb;

/**  
 *  
 * @author Baiyy
 * @created 2015年7月15日 下午4:58:48 
 */

public interface KqzbService {
	/**
	 * 当出表存在时返回主表id，当主表不存在时生成主表与附表并返回主表id
	 * @param kqzb 部门编码，所属年月
	 * @return
	 */
	Kqzb getZbid(Kqzb kqzb);
}
