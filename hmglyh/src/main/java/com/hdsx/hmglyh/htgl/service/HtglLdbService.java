package com.hdsx.hmglyh.htgl.service;

import java.util.List;

import com.hdsx.hmglyh.htgl.bean.HtglLdb;
import com.hdsx.hmglyh.util.Combobox;

/**  
 *  后台管理 - 路段表
 * @author LiRui
 * @created 2015年6月10日 上午10:49:58 
 */

public interface HtglLdbService {

	/**
	 * 根据条件查询全部路段信息
	 */
	List<HtglLdb> selectAllLdBySome(HtglLdb ld);

	/**
	 * 统计数据
	 * 描述：DataGrid用
	 * 参数：bmcode，lxcode（非必须）
	 */
	int countNumBySome(HtglLdb ld);

	/**
	 * 查询全部信息（路线）
	 * 描述：查询条件/添加路段
	 */
	List<Combobox> queryLxToCreateCombobox(String lxQueryType);

	/**
	 * 添加
	 */
	boolean addOneLd(HtglLdb ld);

	/**
	 * 删除
	 */
	boolean deleteOneLd(HtglLdb ld);

	/**
	 * 修改
	 * 描述：根据ldcode对ldname，szhh，ezhh，mileage，bz进行修改
	 */
	boolean updateOneLd(HtglLdb ld);

	/**
	 * 主键生成策略
	 * 描述：当前层级最大的ID+1（Action层除将Ldcode截去两位）
	 */
	String generationPK(HtglLdb ld);

	/**
	 * 根据部门编码查询其下的路段数据
	 * 描述：用于创建某部门下的路段下拉树
	 */
	List<Combobox> queryLdByBmcodeAndCreateCombobox(HtglLdb ld);

}
