/**
 * 北京恒达时讯科技有限公司版权所有
 * Copyright (C) HDSX Corporation. All Rights Reserved
 */
package com.hdsx.hmglyh.rcyhtj.service;

import java.util.List;

import com.hdsx.hmglyh.rcyhtj.bean.RcyhNdxxjlb;

/**
 * 
 * @author jason
 *
 */

public interface RcyhNdxxjlbService {

	//查询学习记录
	List<RcyhNdxxjlb> queryXxjl(RcyhNdxxjlb r);
	//学习记录条数
	int  getXxCount(RcyhNdxxjlb r);
	//查询年份
	List<RcyhNdxxjlb> getNf(RcyhNdxxjlb r);
	//添加
	boolean add(RcyhNdxxjlb r);
	//修改
	boolean change(RcyhNdxxjlb r);
	//删除
	boolean drop(RcyhNdxxjlb r);
	//查询一条数据
	RcyhNdxxjlb queryByid(RcyhNdxxjlb r);
}
