package com.hdsx.hmglyh.htgl.service;

import java.util.List;

import com.hdsx.hmglyh.htgl.bean.HtglBhlx;
import com.hdsx.hmglyh.util.Combotree;

/**  
 *  后台管理 - 病害类型 - Service
 * @author LiRui
 * @created 2015年5月28日 上午10:30:12 
 */

public interface HtglBhlxService {

	/**
	 * 添加
	 */
	public boolean bhlxAddOne(HtglBhlx bhlx);

	/**
	 * 删除
	 */
	public boolean bhlxDeleteOne(HtglBhlx bhlx);

	/**
	 * 修改
	 */
	public boolean bhlxUpdateOne(HtglBhlx bhlx);

	/**
	 * 更改某信息的启用状态
	 */
	public boolean bhlxUpdateOneQyzt(HtglBhlx bhlx);

	/**
	 * 根据条件查询全部
	 */
	public List<HtglBhlx> queryAllBySome(HtglBhlx bhlx);

	/**
	 * 根据查询全部的参数统计数据数量
	 */
	public int countNumBySome(HtglBhlx bhlx);

	/**
	 * 根据条件查询所有病害类型数据
	 * 描述：用于创建病害类型Tree
	 * @return HtglBhlx
	 */
	public HtglBhlx queryBhlxDataToCreateTree(HtglBhlx bhlx);

	/**
	 * 将处理好的“病害”数据转换成Combotree数据
	 */
	public Combotree bhlxToCombotree(HtglBhlx bhlx);

	/**
	 * 病害的主键生成规则
	 * 描述：根据父层级的bhid生成子节点的下一个可用id
	 * 数据类型：0101
	 * @return bhid
	 */
	public String generationPK(HtglBhlx bhlx);

}
