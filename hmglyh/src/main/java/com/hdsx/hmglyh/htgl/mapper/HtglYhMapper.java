package com.hdsx.hmglyh.htgl.mapper;

import java.util.List;

import com.hdsx.hmglyh.dao.Mapper;
import com.hdsx.hmglyh.htgl.bean.HtglYhb;

/**  
 *  后台管理 - 用户Mapper
 * @author LiRui
 * @created 2015年6月11日 下午1:00:58 
 */
@Mapper
public interface HtglYhMapper {

	/**
	 * 添加
	 */
	int addOneYh(HtglYhb yh);

	/**
	 * 删除
	 */
	int deleteOneYh(HtglYhb yh);

	/**
	 * 修改
	 */
	int updateOneYh(HtglYhb yh);

	/**
	 * 修改某用户的“启用/禁用”
	 */
	int updateOneYhQyzt(HtglYhb yh);

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
	int verifyUsername(HtglYhb yh);

}
