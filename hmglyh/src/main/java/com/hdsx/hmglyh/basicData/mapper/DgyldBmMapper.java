package com.hdsx.hmglyh.basicData.mapper;

import java.util.List;

import com.hdsx.hmglyh.dao.Mapper;
import com.hdsx.hmglyh.htgl.bean.HtglBm;
import com.hdsx.hmglyh.util.Combotree;

@Mapper
public interface DgyldBmMapper {
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
}
