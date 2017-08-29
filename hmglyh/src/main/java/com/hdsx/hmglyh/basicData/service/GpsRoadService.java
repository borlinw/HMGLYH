/**
 * 北京恒达时讯科技有限公司版权所有
 * Copyright (C) HDSX Corporation. All Rights Reserved
 */
package com.hdsx.hmglyh.basicData.service;

import java.util.List;

import com.hdsx.hmglyh.basicData.bean.GpsRoad;

/**  
 *  
 * @author Baiyy
 * @created 2015年5月27日 下午10:41:18 
 */

public interface GpsRoadService {
	/**
	 * 获取全部最小路段，用于划分千米路段
	 * @return
	 */
	List<GpsRoad> getAllLd();
}
