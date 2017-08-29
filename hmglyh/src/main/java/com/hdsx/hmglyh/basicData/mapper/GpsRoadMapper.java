package com.hdsx.hmglyh.basicData.mapper;

import java.util.List;

import com.hdsx.hmglyh.basicData.bean.GpsRoad;
import com.hdsx.hmglyh.dao.Dao;
import com.hdsx.hmglyh.dao.Mapper;
@Mapper
public interface GpsRoadMapper extends Dao<GpsRoad> {
	/**
	 * 获取全部的最小路段，用于生成千米路段
	 * 描述
	 * @return
	 */
	List<GpsRoad> getAllLd();
}
