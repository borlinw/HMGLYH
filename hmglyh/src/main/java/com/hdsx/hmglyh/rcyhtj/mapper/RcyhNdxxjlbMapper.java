/**
 * 北京恒达时讯科技有限公司版权所有
 * Copyright (C) HDSX Corporation. All Rights Reserved
 */
package com.hdsx.hmglyh.rcyhtj.mapper;


import java.util.List;

import com.hdsx.hmglyh.dao.Dao;
import com.hdsx.hmglyh.dao.Mapper;
import com.hdsx.hmglyh.rcyhtj.bean.RcyhNdxxjlb;

/**
 * 
 * @author jason
 *
 */
@Mapper
public interface RcyhNdxxjlbMapper extends Dao<RcyhNdxxjlb> {
	//查询学习记录
	List<RcyhNdxxjlb> queryXxjl(RcyhNdxxjlb r);
	//学习记录条数
	int  getXxCount(RcyhNdxxjlb r);
	//查询年份
	List<RcyhNdxxjlb> getNf(RcyhNdxxjlb r);
	//添加学习记录
	int add(RcyhNdxxjlb r);
	//修改
	int change(RcyhNdxxjlb r);
	//删除
	int drop (RcyhNdxxjlb r);
	//查询一条数据
	RcyhNdxxjlb queryByid(RcyhNdxxjlb r);
}
