
 /**
 * 北京恒达时讯科技有限公司版权所有
 * Copyright (C) HDSX Corporation. All Rights Reserved
 */
package com.hdsx.hmglyh.jcpd.mapper;

import java.util.List;

import com.hdsx.hmglyh.dao.Dao;
import com.hdsx.hmglyh.dao.Mapper;
import com.hdsx.hmglyh.jcpd.bean.Lmjcb;

/**  
 *  
 * @author Baiyy
 * @created 2015年6月25日 下午3:42:53 
 */
@Mapper
public interface LmjcbMapper extends Dao<Lmjcb> {
	/**
	 * 路面检测查询
	 * @param l
	 * @return
	 */
	List<Lmjcb> getLmjc(Lmjcb l);
	/**
	 * 路面检测条数查询
	 * @param l
	 * @return
	 */
	int getLmjcCount(Lmjcb l);
	/**
	 * 沿用之前的数据
	 * @param lmjcb
	 * @return
	 */
	int copy(Lmjcb lmjcb);
	/**
	 * 根据版本清空数据
	 * @param lmjcb
	 * @return
	 */
	int clear(Lmjcb lmjcb);
}
