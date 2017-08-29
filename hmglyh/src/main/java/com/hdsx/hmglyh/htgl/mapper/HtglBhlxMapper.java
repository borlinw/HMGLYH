/**
 * 北京恒达时讯科技有限公司版权所有
 * Copyright (C) Hdsx Corporation. All Rights Reserved
 */
package com.hdsx.hmglyh.htgl.mapper;

import java.util.List;

import com.hdsx.hmglyh.dao.Mapper;
import com.hdsx.hmglyh.htgl.bean.HtglBhlx;

/**  
 *  后台管理 - 病害类型
 * @author LiRui
 * @created 2015年5月28日 上午9:50:12 
 */
@Mapper
public interface HtglBhlxMapper{

	/**
	 * 增加
	 */
	public int bhlxAddOne(HtglBhlx bhlx);

	/**
	 * 删除
	 */
	public int bhlxDeleteOne(HtglBhlx bhlx);

	/**
	 * 修改
	 */
	public int bhlxUpdateOne(HtglBhlx bhlx);

	/**
	 * 更改某信息的启用状态
	 */
	public int bhlxUpdateOneQyzt(HtglBhlx bhlx);

	/**
	 * 根据条件查询全部
	 */
	public List<HtglBhlx> queryAllBySome(HtglBhlx bhlx);

	/**
	 * 根据查询全部的参数统计数据数量
	 */
	public int countNumBySome(HtglBhlx bhlx);

	/**
	 * 查询病害类型（父节点）
	 */
	public HtglBhlx selectFather(HtglBhlx bhlx);

	/**
	 * 查询病害类型（子节点）
	 */
	public List<HtglBhlx> selectChildren(HtglBhlx bhlx);

	/**
	 * 主键生成规则
	 * 描述：根据父层级的Bhid查询下一层级的下一个可用主键
	 * 主键类型：0101..
	 */
	public HtglBhlx generationPK(HtglBhlx bhlx);

}
