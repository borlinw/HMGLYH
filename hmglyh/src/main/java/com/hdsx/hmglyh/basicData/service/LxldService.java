/**
 * 北京恒达时讯科技有限公司版权所有
 * Copyright (C) HDSX Corporation. All Rights Reserved
 */
package com.hdsx.hmglyh.basicData.service;

import java.util.List;

import com.hdsx.hmglyh.basicData.bean.Lxld;

/**  
 *  
 * @author Baiyy
 * @created 2015年6月8日 上午10:33:30 
 */

public interface LxldService {
	/**
	 * 获取路线路段下拉列表
	 * @param l
	 * @return
	 */
	List<Lxld> getLdCombo(Lxld l);
	
	/**
	 * 获取路线路段下拉列表 筛选只有未验收的结果的记录
	 * @param l
	 * @return
	 */
	List<Lxld> getLdCombo2(Lxld l);
	
	/**
	 * 获取路线下拉列表
	 * @return
	 */
	List<Lxld> getLxCombo();
	
	List<Lxld> getTsbmLxldCombo(Lxld lxld);
}
