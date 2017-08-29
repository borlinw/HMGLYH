/**
 * 北京恒达时讯科技有限公司版权所有
 * Copyright (C) HDSX Corporation. All Rights Reserved
 */
package com.hdsx.hmglyh.jcpd.service;

import java.util.List;

import com.hdsx.hmglyh.jcpd.bean.Bbkzb;

/**  
 *  
 * @author Baiyy
 * @created 2015年5月28日 下午11:20:26 
 */

public interface BbkzbService {
	/**
	 * 添加版本库
	 * @param b
	 * @return
	 */
	boolean addBbkzb(Bbkzb b);
	/**
	 * 修改版本库
	 * @param b
	 * @return
	 */
	boolean changeBbkzb(Bbkzb b);
	/**
	 * 查询版本库
	 * @param b
	 * @return
	 */
	List<Bbkzb> queryBb(Bbkzb b);
	/**
	 * 查询版本库的条数
	 * @param b
	 * @return
	 */
	int getBbCount(Bbkzb b);
	/**
	 * 删除版本库
	 * @param b
	 * @return
	 */
	boolean dropBb(Bbkzb b);
	/**
	 * 路况评定用，获取路况调查以及路面检测的版本
	 * @param b
	 * @return
	 */
	List<Bbkzb> getBbid(Bbkzb b);
	/**
	 * 统计分析版本库
	 */
	List<Bbkzb> getBb(Bbkzb b);
	/**
	 * 路面检测沿用之前路面检测数据专用
	 * @param bbkzb
	 * @return
	 */
	List<Bbkzb> getBbForLmjc(Bbkzb bbkzb);
	/**
	 * 区段划分用，带有上报状态
	 * @param bbkzb
	 * @return
	 */
	List<Bbkzb> getBbForQdhf(Bbkzb bbkzb);
}
