
 /**
 * 北京恒达时讯科技有限公司版权所有
 * Copyright (C) HDSX Corporation. All Rights Reserved
 */
package com.hdsx.hmglyh.basicData.service;

import com.hdsx.hmglyh.htgl.bean.HtglBm;
import com.hdsx.hmglyh.util.Combotree;

/**
 * 
 * @author jason
 *
 */

public interface DgyldBmService {
	/**
	 * 获取部门树
	 * @param bm
	 * @return
	 */
	Combotree getBmCombo(HtglBm bm);
}
