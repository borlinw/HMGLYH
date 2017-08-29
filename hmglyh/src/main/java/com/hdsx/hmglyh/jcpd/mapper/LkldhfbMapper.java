/**
 * 北京恒达时讯科技有限公司版权所有
 * Copyright (C) HDSX Corporation. All Rights Reserved
 */
package com.hdsx.hmglyh.jcpd.mapper;

import java.util.List;

import com.hdsx.hmglyh.dao.Dao;
import com.hdsx.hmglyh.dao.Mapper;
import com.hdsx.hmglyh.jcpd.bean.Lkldhfb;
import com.hdsx.hmglyh.rcyhtj.bean.RcyhNdxxjlb;
/**
 * 
 * @author jason
 *
 */
@Mapper
public interface LkldhfbMapper extends Dao<Lkldhfb> {
	/**
	 * 添加原始路段
	 */
	int addYsld(Lkldhfb lkldhfb);
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
	int dropYsld(Lkldhfb lkldhfb);
	/**
	 * 修改一条原始路段
	 */
	int change(Lkldhfb lkldhfb);
}












