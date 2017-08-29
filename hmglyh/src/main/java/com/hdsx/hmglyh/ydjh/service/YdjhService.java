/**
 * 北京恒达时讯科技有限公司版权所有
 * Copyright (C) HDSX Corporation. All Rights Reserved
 */
package com.hdsx.hmglyh.ydjh.service;

import java.util.List;

import com.hdsx.hmglyh.ydjh.bean.RcyhRwdjlb;

/**
 * 
 * @author jason
 *
 */

public interface YdjhService {
	
	
	/**
	 * 按条件查询任务单
	 * @return
	 */
	List<RcyhRwdjlb> getRwdBytj(RcyhRwdjlb rcyhRwdjlb);
	/**
	 * 按条件查询任务单条数
	 * @return
	 */
	int getRwdBytjCount(RcyhRwdjlb rcyhRwdjlb);
	
}
