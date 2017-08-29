package com.hdsx.hmglyh.rcyh.service;

import java.util.List;

import com.hdsx.hmglyh.rcyh.dao.model.RcyhBasicRoad;
import com.hdsx.hmglyh.rcyh.dao.model.RcyhDjcx;

/**  
 *  日常养护 - 冬季除雪Service
 * @author LiRui
 * @created 2015年7月26日 下午12:50:05 
 */

public interface RcyhDjcxService {

	/**
	 * 添加
	 */
	boolean addOneDjcx(RcyhDjcx cx);

	/**
	 * 删除
	 */
	boolean deldeteOneDjcx(RcyhDjcx cx);

	/**
	 * 修改
	 */
	boolean updateOneDjcx(RcyhDjcx cx);

	/**
	 * 根据条件查询全部“冬季除雪快报”信息
	 */
	List<RcyhDjcx> selectAllDjcxBySome(RcyhDjcx cx);

	/**
	 * 根据条件统计冬季除雪快报信息数量
	 */
	int countAllDjcxBySome(RcyhDjcx cx);

	/**
	 * 根据“KBID”查询数据
	 * 描述：用于“查看”
	 */
	RcyhDjcx queryOneCxkbByKbid(RcyhDjcx cx);

	/**
	 * 根据路线编码和起止点桩号查询其中“高速公路、一级公路”的总里程
	 * 描述：用于计算折合成二级公路之后的里程（当前里程+折合之后的里程）
	 */
	RcyhBasicRoad selectAllRoadByRoadcode(RcyhBasicRoad road);

	/**
	 * 计算除雪面积
	 */
	RcyhBasicRoad countCxmj(RcyhBasicRoad rode);

	/**
	 * 修改State值
	 * 描述：操作是否允许编辑
	 */
	boolean updateDjcxState(RcyhDjcx cx);

}
