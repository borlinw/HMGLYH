
 /**
 * 北京恒达时讯科技有限公司版权所有
 * Copyright (C) HDSX Corporation. All Rights Reserved
 */
package com.hdsx.hmglyh.jcpd.service;

import java.util.List;

import com.hdsx.hmglyh.jcpd.bean.Bbkzb;
import com.hdsx.hmglyh.jcpd.bean.Qyhfb;
import com.hdsx.hmglyh.jcpd.bean.Qyhfxxb;

/**  
 *  
 * @author Baiyy
 * @created 2015年7月3日 下午4:53:13 
 */

public interface QyhfbService {
	/**
	 * 添加区域划分
	 * @param list
	 * @return
	 */
	int addQyhfb(List<Qyhfb> list);
	
	boolean addQyhfXxb(List<Qyhfb> qybList,List<Qyhfxxb> xxbList);
	/**
	 * 查询区域划分信息
	 * @param qyhfb
	 * @return
	 */
	List<Qyhfb> queryQyhfb(Qyhfb qyhfb);
	/**
	 * 清空某种版本某条管养路段的区域划分
	 * @param qyhfb
	 * @return
	 */
	int dropQyhfb(Qyhfb qyhfb);
	/**
	 * 查询区域划分信息条数
	 * @param qyhfb
	 * @return
	 */
	int getQyhfbCount(Qyhfb qyhfb);
	/**
	 * 区域划分是否已经被使用
	 * @param qyhfb
	 * @return
	 */
	boolean isUsed(Qyhfb qyhfb);
	/**
	 * 查询区域划分信息，用于导出
	 * @param qyhfb bmCode：部门编码   bbid：区域区段划分版本id
	 * @return
	 */
	List<Qyhfb> exportQyhfb(Qyhfb qyhfb);
	/**
	 * 查询之前在该路段有划分的区域划分版本
	 * @param qyhfb
	 * @return
	 */
	List<Bbkzb> getQybb(Qyhfb qyhfb);
	/**
	 * 沿用之前版本添加区域划分
	 * @param qyhfb
	 * @return
	 */
	boolean copy(Qyhfb qyhfb);
	/**
	 * 获取需要更新的数据
	 * @param qyhfb
	 * @return
	 */
	Qyhfb getDataForUpdate(Qyhfb qyhfb);
	/**
	 * 获取需要更新的区域划分详细信息
	 * @param qyhfb
	 * @return
	 */
	List<Qyhfxxb> getXxbForUpdate(Qyhfb qyhfb);
	
}











