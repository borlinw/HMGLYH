
 /**
 * 北京恒达时讯科技有限公司版权所有
 * Copyright (C) HDSX Corporation. All Rights Reserved
 */
package com.hdsx.hmglyh.jcpd.service;

import java.util.List;

import com.hdsx.hmglyh.jcpd.bean.Qdhfb;
import com.hdsx.hmglyh.jcpd.bean.Qdhfshb;

/**  
 *  
 * @author Baiyy
 * @created 2015年8月8日 下午1:53:25 
 */

public interface QdhfshbService {
	/**
	 * 上报
	 * @param qdhfshb
	 * @return
	 */
	boolean report(Qdhfshb qdhfshb);
	/**
	 * 被打回后重新上报
	 * @param qdhfshb
	 * @return
	 */
	boolean reReport(Qdhfshb qdhfshb);
	/**
	 * 审核
	 * @param qdhfshb
	 * @return
	 */
	boolean check(Qdhfshb qdhfshb);
	/**
	 * 查询需要审核的路段划分信息
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
	 * 查询某个版本的路段划分信息
	 * @param qdhfshb
	 * @return
	 */
	List<Qdhfb> getQdhf(Qdhfshb qdhfshb);
	/**
	 * 查询某个版本的路段划分条数
	 * @param qdhfshb
	 * @return
	 */
	int getQdhfCount(Qdhfshb qdhfshb);
}













