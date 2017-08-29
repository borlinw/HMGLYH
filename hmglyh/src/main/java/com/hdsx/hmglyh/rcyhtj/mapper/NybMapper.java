/**
 * 北京恒达时讯科技有限公司版权所有
 * Copyright (C) HDSX Corporation. All Rights Reserved
 */
package com.hdsx.hmglyh.rcyhtj.mapper;


import java.util.HashMap;
import java.util.List;

import com.hdsx.hmglyh.dao.Dao;
import com.hdsx.hmglyh.dao.Mapper;
import com.hdsx.hmglyh.rcyhtj.bean.Nyb;

/**
 * 
 * @author jason
 *
 */
@Mapper
public interface NybMapper extends Dao<NybMapper> {
	
	List<Nyb> getNy();
	
	/**
	 * 得到作业验收的年月
	 * @return
	 */
	List<Nyb> getZyysNy(HashMap<String,String> hashmap);
	/**
	 * 查询本月之前的月份
	 * 描述
	 * @return
	 */
	List<Nyb> getYf();
	
}
