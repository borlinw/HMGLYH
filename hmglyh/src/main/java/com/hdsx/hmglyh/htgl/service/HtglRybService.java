package com.hdsx.hmglyh.htgl.service;

import java.util.List;

import com.hdsx.hmglyh.htgl.bean.HtglRyb;
import com.hdsx.hmglyh.util.Combobox;

/**  
 *  后台管理 - 人员表Service
 * @author LiRui
 * @created 2015年6月10日 下午7:27:15 
 */

public interface HtglRybService {

	/**
	 * 添加
	 */
	boolean addOneRy(HtglRyb ry);

	/**
	 * 删除
	 */
	boolean deleteOneRy(HtglRyb ry);

	/**
	 * 修改
	 */
	boolean updateOneRy(HtglRyb ry);

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
	 * 查询没有用户名的人员
	 */
	List<HtglRyb> queryAllWithNoUsername(HtglRyb ry);

	/**
	 * 查询人员的入职年份（用于筛选人员）
	 */
	List<Combobox> queryYear();
	/**
	 * 修改启用禁用状态
	 * @param ry
	 * @return
	 */
	boolean changeState(HtglRyb ry);

}
