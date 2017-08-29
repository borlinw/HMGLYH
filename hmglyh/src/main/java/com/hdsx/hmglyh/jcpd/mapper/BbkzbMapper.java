/**
 * 北京恒达时讯科技有限公司版权所有
 * Copyright (C) HDSX Corporation. All Rights Reserved
 */
package com.hdsx.hmglyh.jcpd.mapper;


import java.util.List;

import com.hdsx.hmglyh.dao.Dao;
import com.hdsx.hmglyh.dao.Mapper;
import com.hdsx.hmglyh.jcpd.bean.Bbkzb;

/**  
 *  
 * @author Baiyy
 * @created 2015年5月27日 下午11:51:15 
 */
@Mapper
public interface BbkzbMapper extends Dao<Bbkzb> {
	/**
	 * 添加版本库
	 * @param b
	 * @return
	 */
	int addBbkzb(Bbkzb b);
	/**
	 * 修改版本库
	 * @param b
	 * @return
	 */
	int changeBbkzb(Bbkzb b);
	/**
	 * 查询版本库
	 * @param b
	 * @return
	 */
	List<Bbkzb> queryBb(Bbkzb b);
	/**
	 * 查询版本库条数
	 * @param b
	 * @return
	 */
	int getBbCount(Bbkzb b);
	/**
	 * 删除版本库
	 * @param b
	 * @return
	 */
	int dropBb(Bbkzb b);
	/**
	 * 版本库是否已经被使用
	 * @param b
	 * @return
	 */
	List<Bbkzb> isUsed(Bbkzb b);
	/**
	 * 根据千米路段改变，修改千米版本时间
	 * @param b
	 * @return
	 */
	int changeQmbb(Bbkzb b);
	/**
	 * 路况评定用，获取路况调查以及路面检测的版本
	 * @param b
	 * @return
	 */
	List<Bbkzb> getBbid(Bbkzb b);
	/**
	 * 统计分析版本
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
