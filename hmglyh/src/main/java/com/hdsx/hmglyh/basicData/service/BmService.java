
 /**
 * 北京恒达时讯科技有限公司版权所有
 * Copyright (C) HDSX Corporation. All Rights Reserved
 */
package com.hdsx.hmglyh.basicData.service;

import java.util.List;

import com.hdsx.hmglyh.htgl.bean.HtglBm;
import com.hdsx.hmglyh.util.Combobox;
import com.hdsx.hmglyh.util.Combotree;

/**  
 *  
 * @author Baiyy
 * @created 2015年7月20日 上午11:18:06 
 */

public interface BmService {
	/**
	 * 获取部门树
	 * @param bm
	 * @return
	 */
	Combotree getBmCombo(HtglBm bm);
	/**
	 * 查询巡道记录用，若为管理局则查询分局，若为分局则查询管辖的巡道队
	 * @param bmCode
	 * @return
	 */
	List<Combobox> getBmForXd(String bmCode);
}
