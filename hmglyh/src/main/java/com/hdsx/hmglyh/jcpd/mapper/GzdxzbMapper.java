/**
 * 北京恒达时讯科技有限公司版权所有
 * Copyright (C) HDSX Corporation. All Rights Reserved
 */
package com.hdsx.hmglyh.jcpd.mapper;

import com.hdsx.hmglyh.dao.Dao;
import com.hdsx.hmglyh.dao.Mapper;
import com.hdsx.hmglyh.jcpd.bean.Gzdxzb;

/**  
 *  
 * @author Baiyy
 * @created 2015年5月27日 下午11:51:15 
 */
@Mapper
public interface GzdxzbMapper extends Dao<Gzdxzb> {
	/**
	 * 添加工资主表
	 * @param kqzb
	 * @return
	 */
	int addZb(Gzdxzb gzdxzb);
	/**
	 * 查询工资主表是否存在
	 * @param kqzb
	 * @return
	 */
	Gzdxzb getZb(Gzdxzb gzdxzb);
	/**
	 * 添加工资附表
	 * @param kqfb
	 * @return
	 */
	int addFb(Gzdxzb gzdxzb);
}
