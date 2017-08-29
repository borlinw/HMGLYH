/**
 * 北京恒达时讯科技有限公司版权所有
 * Copyright (C) HDSX Corporation. All Rights Reserved
 */
package com.hdsx.hmglyh.jcpd.service;

import java.util.List;

import com.hdsx.hmglyh.basicData.bean.GpsRoad;
import com.hdsx.hmglyh.jcpd.bean.Qmldb;

/**  
 *  
 * @author Baiyy
 * @created 2015年5月28日 下午7:48:12 
 */

public interface QmldbService {
	/**
	 * 生成千米路段并插入到数据库中
	 * @param list
	 * @return
	 */
	boolean createQmld(List<GpsRoad> list,int bbid);
	/**
	 * 查询千米路段
	 * @param qmldb:版本号
	 * @return
	 */
	List<Qmldb> getQmld(Qmldb qmldb);
	/**
	 * 查询千米路段的条数
	 * @param qmldb
	 * @return
	 */
	int getQmldCount(Qmldb qmldb);
	/**
	 * 清空千米路段
	 * @param qmldb：版本号
	 * @return
	 */
	int dropQmld(Qmldb qmldb);
	/**
	 * 路况调查用，查询千米路段及其对应的调查主表
	 * @param qmldb
	 * @return
	 */
	List<Qmldb> getQmldForLkdc(Qmldb qmldb);
	/**
	 * 路况调查用，查询千米路段的条数
	 * @param qmldb
	 * @return
	 */
	int getQmldCountForLkdc(Qmldb qmldb);
	/**
	 * 生成路况评定明细表
	 * @param qmldb 路线编码，起止点桩号，路况评定bbid，路面检测bbid，路况调查bbid
	 * @return
	 */
	boolean createMxb(Qmldb qmldb);
	/**
	 * 查询路况评定明细
	 * @param qmldb 评定版本，路线编码，起止点桩号
	 * @return
	 */
	List<Qmldb> queryMxb(Qmldb qmldb);
	/**
	 * 查询路况评定明细条数
	 * @param qmldb 评定版本，路线编码，起止点桩号
	 * @return
	 */
	int getMxbCount(Qmldb qmldb);
	/**
	 * 查询统计路面类型
	 */
	List<Qmldb> getLmlx(Qmldb qmldb);
	/**
	 * 查询统计技术等级
	 */
	List<Qmldb> getJsdj(Qmldb qmldb);
	/**
	 * 路况调查路面导出
	 * @param qmldb
	 * @return
	 */
	List<Qmldb> getLmdcForExport(Qmldb qmldb);
	/**
	 * 路况调查路基导出
	 * @param qmldb
	 * @return
	 */
	List<Qmldb> getLjdcForExport(Qmldb qmldb);
	/**
	 * 路况调查沿线设施导出
	 * @param qmldb
	 * @return
	 */
	List<Qmldb> getYxssdcForExport(Qmldb qmldb);
	/**
	 * 路况调查桥隧涵导出
	 * @param qmldb
	 * @return
	 */
	List<Qmldb> getQshdcForExport(Qmldb qmldb);
	/**
	 * 区段划分用，各区段病害分类统计
	 * @param qmldb
	 * @return
	 */
	List<Qmldb> getBhfltj(Qmldb qmldb);
	
}
