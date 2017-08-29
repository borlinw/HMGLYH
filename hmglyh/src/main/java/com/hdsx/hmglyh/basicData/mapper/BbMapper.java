package com.hdsx.hmglyh.basicData.mapper;

import java.util.List;

import com.hdsx.hmglyh.dao.Mapper;
import com.hdsx.hmglyh.util.Combotree;

@Mapper
public interface BbMapper {
	/**
	 * 
	 * @param bb
	 * @return
	 */
	List<Combotree> getChildren();
}
