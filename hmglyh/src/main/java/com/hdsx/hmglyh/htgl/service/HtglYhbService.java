package com.hdsx.hmglyh.htgl.service;

import java.util.List;

import com.hdsx.hmglyh.htgl.bean.HtglYhb;

/**  
 *  后台管理 - 用户表Service
 * @author LiRui
 * @created 2015年6月11日 下午1:31:37 
 */

public interface HtglYhbService {

	/**
	 * 添加
	 */
	boolean addOneYh(HtglYhb yh);

	/**
	 * 删除
	 */
	boolean deleteOneYh(HtglYhb yh);

	/**
	 * 修改
	 */
	boolean updateOneYh(HtglYhb yh);

	/**
	 * 修改某用户的“启用/禁用”
	 */
	boolean updateOneYhQyzt(HtglYhb yh);

	/**
	 * 查询全部
	 */
	List<HtglYhb> queryAllBySome(HtglYhb yh);

	/**
	 * 统计数据
	 */
	int countNumBySome(HtglYhb yh);

	/**
	 * 验证用户名是否存在
	 */
	boolean verifyUsername(HtglYhb yh);

}
