package com.hdsx.hmglyh.htgl.mapper;

import java.util.List;

import com.hdsx.hmglyh.dao.Mapper;
import com.hdsx.hmglyh.htgl.bean.HtglRyb;

/**  
 *  后台管理 - 人员Mapper
 * @author LiRui
 * @created 2015年6月10日 下午5:57:46 
 */
@Mapper
public interface HtglRybMapper {

	/**
	 * 添加
	 */
	int addOneRy(HtglRyb ry);

	/**
	 * 删除
	 */
	int deleteOneRy(HtglRyb ry);

	/**
	 * 修改
	 */
	int updateOneRy(HtglRyb ry);

	/**
	 * 查询全部
	 */
	List<HtglRyb> queryAllBySome(HtglRyb ry);

	/**
	 * 按条件统计数据
	 */
	int countNumBySome(HtglRyb ry);

	/**
	 * 获取新的主键（Ryid）
	 */
	int generationPK();

	/**
	 * 查询没有用户名的人员信息
	 */
	List<HtglRyb> queryAllWithNoUsername(HtglRyb ry);

	/**
	 * 查询人员的入职年份（用于筛选人员）
	 */
	List<HtglRyb> queryYear();
	/**
	 * 修改启用禁用状态
	 * @param ry
	 * @return
	 */
	int changeState(HtglRyb ry);

}
