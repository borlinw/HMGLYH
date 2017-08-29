package com.hdsx.hmglyh.basicData.mapper;

import java.util.List;

import com.hdsx.hmglyh.dao.Mapper;
import com.hdsx.hmglyh.htgl.bean.HtglBm;
import com.hdsx.hmglyh.util.Combobox;
import com.hdsx.hmglyh.util.Combotree;

@Mapper
public interface BmMapper {
	/**
	 * 获取部门根节点
	 * @param bmCode
	 * @return
	 */
	Combotree getParent(String bmCode);
	/**
	 * 获取子节点
	 * @param bm
	 * @return
	 */
	List<Combotree> getChildren(HtglBm bm);
	/**
	 * 查询巡道记录用，若为管理局则查询分局，若为分局则查询管辖的巡道队
	 * @param bmCode
	 * @return
	 */
	List<Combobox> getBmForXd(String bmCode);
}
