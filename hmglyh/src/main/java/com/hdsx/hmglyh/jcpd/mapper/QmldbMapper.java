/**
 * 北京恒达时讯科技有限公司版权所有
 * Copyright (C) HDSX Corporation. All Rights Reserved
 */
package com.hdsx.hmglyh.jcpd.mapper;

import java.util.List;

import com.hdsx.hmglyh.dao.Dao;
import com.hdsx.hmglyh.dao.Mapper;
import com.hdsx.hmglyh.jcpd.bean.Lkdcfb;
import com.hdsx.hmglyh.jcpd.bean.Qmldb;

/**  
 *  
 * @author Baiyy
 * @created 2015年5月27日 下午11:51:15 
 */
@Mapper
public interface QmldbMapper extends Dao<Qmldb> {
	/**
	 * 插入千米路段
	 * @param qmldb
	 * @return
	 */
	int addQmld(Qmldb qmldb);
	/**
	 * 查询千米路段
	 * @param qmldb：版本号
	 * @return
	 */
	List<Qmldb> getQmld(Qmldb qmldb);
	/**
	 * 查询千米路段的条数
	 * @param qmldb：版本号
	 * @return
	 */
	int getQmldCount(Qmldb qmldb);
	/**
	 * 清空千米路段
	 * @param qmldb：版本
	 * @return
	 */
	int dropQmld(Qmldb qmldb);
	/**
	 * 查询千米路段是否被使用
	 * @param qmldb：千米路段版本号
	 * @return
	 */
	List<Qmldb> isUsed(Qmldb qmldb);
	/**
	 * 路况调查用，查询主表信息
	 * @param qmldb
	 * @return
	 */
	List<Qmldb> getQmldForLkdc(Qmldb qmldb);
	/**
	 * 路况调查用，查询千米路段条数
	 * @param qmldb
	 * @return
	 */
	int getQmldCountForLkdc(Qmldb qmldb);
	/**
	 * 查询一条主表对应的调查附表
	 * @param dcid
	 * @return
	 */
	List<Lkdcfb> getLkdcfb(String dcid);
	/**
	 * 获取千米路段同时获取路面四项指标的数据
	 * @param qmldb 路线，桩号范围，路面检测bbid
	 * @return
	 */
	List<Qmldb> getLmjc(Qmldb qmldb);
	/**
	 * 获取pci
	 * @param qmldb 调查类型，路段id，调查bbid
	 * @return
	 */
	double getPci(Qmldb qmldb);
	/**
	 * 获取sci
	 * @param qmldb 路段id，调查bbid
	 * @return
	 */
	double getSci(Qmldb qmldb);
	/**
	 * 获取bci
	 * @param qmldb 路段id，调查bbid
	 * @return
	 */
	double getBci(Qmldb qmldb);
	/**
	 * 获取tci
	 * @param qmldb 路段id，调查bbid
	 * @return
	 */
	double getTci(Qmldb qmldb);
	/**
	 * 
	 * 查询明细表数据
	 * @param qmldb
	 * @return
	 */
	List<Qmldb> queryMxb(Qmldb qmldb);
	/**
	 * 
	 * 查询明细表条数
	 * @param qmldb
	 * @return
	 */
	int getMxbCount(Qmldb qmldb);
	/**
	 * 添加明细表数据
	 * @param qmldb
	 * @return
	 */
	int addMxb(Qmldb qmldb);
	/**
	 * 清空某个版本某个路段上的评定明细数据
	 * @param qmldb
	 * @return
	 */
	int dropMxb(Qmldb qmldb);
	/**
	 * 查询统计路面类型
	 */
	List<Qmldb> getLmlx(Qmldb qmldb);
	/**
	 * 查询统计技术等级
	 */
	List<Qmldb> getJsdj(Qmldb qmldb);
	/**
	 * 区段划分用，各区段病害分类统计
	 * @param qmldb
	 * @return
	 */
	List<Qmldb> getBhfltj(Qmldb qmldb);
	
}












