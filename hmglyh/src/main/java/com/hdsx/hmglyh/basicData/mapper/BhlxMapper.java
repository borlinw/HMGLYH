/**
 * 北京恒达时讯科技有限公司版权所有
 * Copyright (C) HDSX Corporation. All Rights Reserved
 */
package com.hdsx.hmglyh.basicData.mapper;

import java.util.List;

import com.hdsx.hmglyh.basicData.bean.Bhlx;
import com.hdsx.hmglyh.basicData.bean.Lxld;
import com.hdsx.hmglyh.dao.Dao;
import com.hdsx.hmglyh.dao.Mapper;

/**
 * 
 * @author jason
 *
 */
@Mapper
public interface BhlxMapper extends Dao<Bhlx> {
	/**
	 * 获取所有的病害
	 * @return
	 */
	List<Bhlx> getAllBhlx();
	/**
	 * 查询病害信息(父节点)
	 */
	public List<Bhlx> selectFather();
	/**
	 * 查询病害信息(子节点)
	 */
	public List<Bhlx> selectChildren(Bhlx bh);
}
