/**
 * 北京恒达时讯科技有限公司版权所有
 * Copyright (C) HDSX Corporation. All Rights Reserved
 */
package com.hdsx.hmglyh.basicData.mapper;

import java.util.List;

import com.hdsx.hmglyh.basicData.bean.Lxld;
import com.hdsx.hmglyh.dao.Dao;
import com.hdsx.hmglyh.dao.Mapper;

/**  
 *  
 * @author Baiyy
 * @created 2015年6月8日 上午10:20:15 
 */
@Mapper
public interface LxldMapper extends Dao<Lxld> {
	/**
	 * 获取所有的路线
	 * @return
	 */
	List<Lxld> getLx();
	/**
	 * 获取部门的管养路段
	 * @param l 部门编码
	 * @return
	 */
	List<Lxld> getLd(Lxld l);
	
	/**
	 * 获取部门的管养路段 zlm 有维修作业 
	 * @param l 部门编码
	 * @return
	 */
	List<Lxld> getLd2(Lxld l);
	/**
	 * 获取部门的部门类型
	 * @param bmCode
	 * @return
	 */
	String getBmlx(String bmCode);
	
	List<Lxld> getTsbmLxldCombo(Lxld lxld);
}
