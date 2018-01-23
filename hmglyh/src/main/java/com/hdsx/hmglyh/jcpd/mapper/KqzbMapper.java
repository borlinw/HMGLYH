/**
 * 北京恒达时讯科技有限公司版权所有
 * Copyright (C) HDSX Corporation. All Rights Reserved
 */
package com.hdsx.hmglyh.jcpd.mapper;



import java.util.List;

import com.hdsx.hmglyh.dao.Dao;
import com.hdsx.hmglyh.dao.Mapper;
import com.hdsx.hmglyh.jcpd.bean.Kqfb;
import com.hdsx.hmglyh.jcpd.bean.Kqzb;

/**  
 *  
 * @author Baiyy
 * @created 2015年5月27日 下午11:51:15 
 */
@Mapper
public interface KqzbMapper extends Dao<Kqzb> {
	/**
	 * 添加考勤主表
	 * @param kqzb
	 * @return
	 */
	int addZb(Kqzb kqzb);
	/**
	 * 查询考勤主表是否存在
	 * @param kqzb
	 * @return
	 */
	Kqzb getZb(Kqzb kqzb);
	/**
	 * 添加考勤附表
	 * @param kqfb
	 * @return
	 */
	int addFb(Kqfb kqfb);
	/**
	 * 获取养护站或养护队生成考勤附表的信息
	 * @param kqzb
	 * @return
	 */
	List<Kqfb> getFbxxNew(Kqzb kqzb);
	
	/**
	 * 获取养护站或养护队生成考勤附表的信息
	 * @param kqzb
	 * @return
	 */
	List<Kqfb> getFbxx(Kqzb kqzb);
	/**
	 * 获取巡道队生成考勤附表的信息
	 * @param kqzb
	 * @return
	 */
	List<Kqfb> getXcFbxx(Kqzb kqzb);
	/**
	 * 获取部门类型
	 * @param bmCode
	 * @return
	 */
	List<String> getBmlx(String bmCode);
}
