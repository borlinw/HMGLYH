package com.hdsx.hmglyh.rcyh.dao;

import java.util.List;

import com.hdsx.hmglyh.dao.Mapper;
import com.hdsx.hmglyh.rcyh.dao.model.RcyhBasicRoad;
import com.hdsx.hmglyh.rcyh.dao.model.RcyhDjcx;

/**  
 *  日常养护 - 冬季除雪
 * @author LiRui
 * @created 2015年7月26日 上午9:09:29 
 */
@Mapper
public interface RcyhDjcxMapper {

	/**
	 * 添加
	 */
	int addOneDjcx(RcyhDjcx cx);

	/**
	 * 删除
	 */
	int deldeteOneDjcx(RcyhDjcx cx);

	/**
	 * 修改
	 */
	int updateOneDjcx(RcyhDjcx cx);

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
	 * 计算折算里程
	 */
	RcyhBasicRoad selectAllRoadByRoadcode(RcyhBasicRoad rode);

	/**
	 * 计算除雪面积
	 */
	RcyhBasicRoad countCxmj(RcyhBasicRoad rode);

	/**
	 * 修改State值
	 * 描述：操作是否允许编辑
	 */
	int updateDjcxState(RcyhDjcx cx);

}
