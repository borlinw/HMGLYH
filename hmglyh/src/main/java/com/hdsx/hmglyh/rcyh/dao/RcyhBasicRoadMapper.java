package com.hdsx.hmglyh.rcyh.dao;

import com.hdsx.hmglyh.dao.Mapper;
import com.hdsx.hmglyh.rcyh.dao.model.RcyhBasicRoad;

/**  
 *  日常养护 - 基础库的路线表（添加除雪快报表数据的时候查询统计折合成二级公路的里程数）
 * @author LiRui
 * @created 2015年7月26日 上午9:09:29 
 */
@Mapper
public interface RcyhBasicRoadMapper {

	/**
	 * 根据路线编码和起止点桩号查询其中“高速公路、一级公路”的总里程
	 * 描述：用于计算折合成二级公路之后的里程（当前里程+折合之后的里程）
	 */
	RcyhBasicRoad selectAllRoadByRoadcode(RcyhBasicRoad road);

}
