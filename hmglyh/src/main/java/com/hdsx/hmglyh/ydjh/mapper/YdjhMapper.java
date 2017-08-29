package com.hdsx.hmglyh.ydjh.mapper;

import java.util.List;

import com.hdsx.hmglyh.dao.Dao;
import com.hdsx.hmglyh.dao.Mapper;
import com.hdsx.hmglyh.ydjh.bean.RcyhRwdjlb;

@Mapper
public interface YdjhMapper extends Dao<RcyhRwdjlb>   {
	/**
	 * 按条件查询任务单
	 * @return
	 */
	List<RcyhRwdjlb> getRwdBytj(RcyhRwdjlb rcyhRwdjlb);
	/**
	 * 按条件查询任务单条数
	 * @return
	 */
	int getRwdBytjCount(RcyhRwdjlb rcyhRwdjlb);
	
	
}
