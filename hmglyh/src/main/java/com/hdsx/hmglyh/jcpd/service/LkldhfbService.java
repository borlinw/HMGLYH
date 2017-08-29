/**
 * 北京恒达时讯科技有限公司版权所有
 * Copyright (C) HDSX Corporation. All Rights Reserved
 */
package com.hdsx.hmglyh.jcpd.service;

import java.util.List;

import com.hdsx.hmglyh.jcpd.bean.Lkldhfb;

/**
 * 
 * @author jason
 *
 */

public interface LkldhfbService {
	/**
	 * 添加原始路段
	 */
	boolean addYsld(Lkldhfb lkldhfb);
	/**
	 * 查询原始路段
	 */
	List<Lkldhfb> getYsld(Lkldhfb lkldhfb);
	/**
	 * 查询原始路段的条数
	 */
	int getYsldCount(Lkldhfb lkldhfb);
	/**
	 * 删除一条原始路段
	 */
	boolean dropYsld(Lkldhfb lkldhfb);
	
	/**
	 * 修改一条原始路段
	 */
	boolean change(Lkldhfb lkldhfb);
}
