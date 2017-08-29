
 /**
 * 北京恒达时讯科技有限公司版权所有
 * Copyright (C) HDSX Corporation. All Rights Reserved
 */
package com.hdsx.hmglyh.gis.jichusj.luxian.service;

import java.util.List;

import com.hdsx.hmglyh.gis.jichusj.luxian.dao.model.Lishiweixiujl;

/**  
 *  
 * @author Baiyy
 * @created 2016年6月18日 下午2:00:01 
 */

public interface LishiweixiujlService {
	/**
	 * 添加维修记录
	 * @param lswxjl
	 * @return
	 */
	boolean add(Lishiweixiujl lswxjl);
	/**
	 * 修改维修记录
	 * @param lswxjl
	 * @return
	 */
	boolean change(Lishiweixiujl lswxjl);
	/**
	 * 获取符合条件的维修记录
	 * @param lswxjl
	 * @return
	 */
	List<Lishiweixiujl> getMxb(Lishiweixiujl lswxjl);
	/**
	 * 获取维修记录条数
	 * @param lswxjl
	 * @return
	 */
	int getMxbCount(Lishiweixiujl lswxjl);
	/**
	 * 通过id查询详细信息
	 * @param lswxjl
	 * @return
	 */
	Lishiweixiujl getMxbById(Lishiweixiujl lswxjl);
}
