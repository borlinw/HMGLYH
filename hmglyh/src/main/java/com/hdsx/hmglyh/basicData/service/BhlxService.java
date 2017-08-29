/**
 * 北京恒达时讯科技有限公司版权所有
 * Copyright (C) HDSX Corporation. All Rights Reserved
 */
package com.hdsx.hmglyh.basicData.service;

import java.util.List;

import com.hdsx.hmglyh.basicData.bean.Bhlx;
import com.hdsx.hmglyh.util.Combotree;

/**
 * 病害类型
 * @author jason
 *
 */

public interface BhlxService {
	/**
	 * @return
	 */
	List<Bhlx> getAllBhlx();
	/**
	 * 根据条件查询所有病害信息
	 * 描述:用于创建病害tree
	 * @param bh
	 * @return
	 */
	public List<Bhlx> queryDataToCreatetree();
	/**
	 * 将处理好的病害信息转换成ComboTree数据
	 * @param bh
	 * @return
	 */
	public Combotree dataToComboTree(Bhlx bh);
}
