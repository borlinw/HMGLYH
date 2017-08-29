/**
 * 北京恒达时讯科技有限公司版权所有
 * Copyright (C) HDSX Corporation. All Rights Reserved
 */
package com.hdsx.hmglyh.rcyhtj.service;

import java.util.HashMap;
import java.util.List;

import com.hdsx.hmglyh.rcyhtj.bean.Nyb;

/**
 * 查询年月
 * @author jason
 *
 */

public interface NybService {

	List<Nyb> getNy();
	
	List<Nyb> getYf();

	List<Nyb> getZyysNy(HashMap<String, String> map);
}
