
 /**
 * 北京恒达时讯科技有限公司版权所有
 * Copyright (C) HDSX Corporation. All Rights Reserved
 */
package com.hdsx.hmglyh.jcpd.service;

import java.util.List;

import com.hdsx.hmglyh.jcpd.bean.Bbkzb;
import com.hdsx.hmglyh.jcpd.bean.Ldb;
import com.hdsx.hmglyh.jcpd.bean.Qdhfb;
import com.hdsx.hmglyh.jcpd.dto.HighChart;

/**  
 *  
 * @author Baiyy
 * @created 2015年7月3日 下午4:53:13 
 */

public interface QdhfbService {
	/**
	 * 添加区域划分
	 * @param list
	 * @return
	 */
	int addQdhfb(List<Qdhfb> list);
	/**
	 * 查询区域划分信息
	 * @param Qdhfb
	 * @return
	 */
	List<Qdhfb> queryQdhfb(Qdhfb qdhfb);
	/**
	 * 清空某种版本某条管养路段的区域划分
	 * @param Qdhfb
	 * @return
	 */
	int dropQdhfb(Qdhfb qdhfb);
	/**
	 * 查询区域划分信息条数
	 * @param Qdhfb
	 * @return
	 */
	int getQdhfbCount(Qdhfb qdhfb);
	/**
	 * 区段划分用，查询pci与iri
	 * @param qdhfb
	 * @return
	 */
	HighChart getPciIri(Qdhfb qdhfb);
	/**
	 * 获取区域区段划分的版本信息以及某一区域上该版本的区段划分信息
	 * @param qdhfb
	 * @return
	 */
	Bbkzb getBb(Qdhfb qdhfb);
	/**
	 * 导出区段划分表信息
	 * @param qdhfb bmCode：部门编码  bbid：区域区段划分版本
	 * @return
	 */
	List<Ldb> exportQdhf(Qdhfb qdhfb);
	/**
	 * 根据路况调查版本,区段划分版本，路线编码，起止桩号获取病害分类统计表内容
	 * @param qdhbf
	 * @return
	 */
	List<Qdhfb> getBhfl(Qdhfb qdhbf);
}











