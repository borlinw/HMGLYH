/**
 * 北京恒达时讯科技有限公司版权所有
 * Copyright (C) HDSX Corporation. All Rights Reserved
 */
package com.hdsx.hmglyh.jcpd.mapper;


import java.util.List;

import com.hdsx.hmglyh.dao.Dao;
import com.hdsx.hmglyh.dao.Mapper;
import com.hdsx.hmglyh.jcpd.bean.Qdhfb;
import com.hdsx.hmglyh.jcpd.bean.Qdhfshb;

/**  
 *  
 * @author Baiyy
 * @created 2015年5月27日 下午11:51:15 
 */
@Mapper
public interface QdhfshbMapper extends Dao<Qdhfshb> {
	/**
	 * 添加区段划分审核信息
	 * @param qdhfshb
	 * @return
	 */
	int addShb(Qdhfshb qdhfshb);
	/**
	 * 上报
	 * @param qdhfshb
	 * @return
	 */
	int report(Qdhfshb qdhfshb);
	/**
	 * 审核
	 * @param qdhfshb
	 * @return
	 */
	int check(Qdhfshb qdhfshb);
	/**
	 * 查询上报的路段划分审核信息
	 * @param qdhfshb
	 * @return
	 */
	List<Qdhfshb> getShb(Qdhfshb qdhfshb);
	/**
	 * 查询需要上报或者已经上报的路段划分信息
	 * @param qdhfshb
	 * @return
	 */
	List<Qdhfshb> getShbForReport(Qdhfshb qdhfshb);
	/**
	 * 查询是否满足上报条件
	 * @param qdhfshb
	 * @return
	 */
	boolean isAbleToReport(Qdhfshb qdhfshb);
	/**
	 * 查询某个版本的路段划分信息
	 * @param qdhfshb
	 * @return
	 */
	List<Qdhfb> getQdhf(Qdhfshb qdhfshb);
	/**
	 * 
	 * @param qdhfshb
	 * @return
	 */
	int getQdhfCount(Qdhfshb qdhfshb);
}













