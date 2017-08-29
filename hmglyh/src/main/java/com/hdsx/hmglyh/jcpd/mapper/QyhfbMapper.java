
 /**
 * 北京恒达时讯科技有限公司版权所有
 * Copyright (C) HDSX Corporation. All Rights Reserved
 */
package com.hdsx.hmglyh.jcpd.mapper;

import java.util.List;

import com.hdsx.hmglyh.dao.Dao;
import com.hdsx.hmglyh.dao.Mapper;
import com.hdsx.hmglyh.jcpd.bean.Bbkzb;
import com.hdsx.hmglyh.jcpd.bean.Qyhfb;
import com.hdsx.hmglyh.jcpd.bean.Qyhfxxb;

/**  
 *  
 * @author Baiyy
 * @created 2015年7月3日 下午4:26:54 
 */
@Mapper
public interface QyhfbMapper extends Dao<Qyhfb> {
	/**
	 * 添加区域划分
	 * @param qyhfb
	 * @return
	 */
	int addQyhfb(Qyhfb qyhfb);
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
	int isUsed(Qyhfb qyhfb);
	/**
	 * 查询某一区域中技术等级
	 * @param qyhfb lxcode:路线编码  szhh：起点桩号  ezhh：止点桩号
	 * @return
	 */
	List<Qyhfb> getJsdj(Qyhfb qyhfb);
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
	int copy(Qyhfb qyhfb);
	
	/**
	 * 区域划分详细表
	 */
	int addXxb(Qyhfxxb qyhfxxb);
	
	int dropXxb(Qyhfb qyhfb);
	
	List<Qyhfxxb> getXxb(Qyhfb qyhfb);
	
	int copyXxb(Qyhfb qyhfb);
}












