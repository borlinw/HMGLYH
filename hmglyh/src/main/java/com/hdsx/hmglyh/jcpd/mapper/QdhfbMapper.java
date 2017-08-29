
 /**
 * 北京恒达时讯科技有限公司版权所有
 * Copyright (C) HDSX Corporation. All Rights Reserved
 */
package com.hdsx.hmglyh.jcpd.mapper;

import java.util.List;

import com.hdsx.hmglyh.dao.Dao;
import com.hdsx.hmglyh.dao.Mapper;
import com.hdsx.hmglyh.jcpd.bean.Bbkzb;
import com.hdsx.hmglyh.jcpd.bean.Ldb;
import com.hdsx.hmglyh.jcpd.bean.Qdhfb;
import com.hdsx.hmglyh.jcpd.bean.Qyhfb;

/**  
 *  
 * @author Baiyy
 * @created 2015年7月5日 下午3:56:22 
 */
@Mapper
public interface QdhfbMapper extends Dao<Qdhfb> {
	/**
	 * 添加区域划分
	 * @param Qdhfb
	 * @return
	 */
	int addQdhfb(Qdhfb qdhfb);
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
	 * 审核表插入
	 * @param qdhfb
	 * @return
	 */
	int addShb(Qdhfb qdhfb);
	/**
	 * 查询是否已上报
	 * 描述
	 * @param qdhfb
	 * @return
	 */
	Qdhfb isSb(Qdhfb qdhfb);
	/**
	 * 区段划分用，查询pci与iri
	 * @param qdhfb
	 * @return
	 */
	List<Qdhfb> getPciIri(Qdhfb qdhfb);
	/**
	 * 查询某个版本的区段划分是否有数据
	 * @param bbid :区域区段划分版本
	 * @return 区段划分条数
	 */
	int getCountByBb(int bbid);
	/**
	 * 修改版本对应的路况调查版本
	 * @param qdhfb bbid:区域区段划分版本；dcbbid：路况评定版本id
	 * @return
	 */
	int changeDcbb(Qdhfb qdhfb);
	/**
	 * 查询区域区段划分对应的版本信息
	 * @param bbid 版本id
	 * @return
	 */
	Bbkzb getBb(int bbid);
	/**
	 * 查询管辖路段
	 * @param qdhfb bmCode：部门编码   bbid：区域区段划分版本
	 * @return
	 */
	List<Ldb> getLdb(Qdhfb qdhfb);
	/**
	 * 根据管辖路段查询区域划分
	 * @param ldb
	 * @return
	 */
	List<Qyhfb> getQyhfByLd(Ldb ldb);
	/**
	 * 根据区域划分查询区段划分信息
	 * @param qyhfb
	 * @return
	 */
	List<Qdhfb> getQdhfByQyhf(Qyhfb qyhfb);
	/**
	 * 添加区段节点
	 * @param qyhfb
	 * @return
	 */
	int addJd(Qdhfb q);
	/**
	 * 获取区段节点
	 * @param q
	 * @return
	 */
	String getJd(Qdhfb q);
	
	/**
	 * 根据路况调查版本,区段划分版本，路线编码，起止桩号获取病害分类统计表内容
	 * @param qdhbf
	 * @return
	 */
	List<Qdhfb> getBhfl(Qdhfb qdhbf);
}
