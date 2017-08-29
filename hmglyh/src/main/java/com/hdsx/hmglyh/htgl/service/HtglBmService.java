package com.hdsx.hmglyh.htgl.service;

import java.util.List;

import com.hdsx.hmglyh.htgl.bean.HtglBm;
import com.hdsx.hmglyh.util.Combotree;

/**  
 *  部门信息Service
 * @author LiRui
 * @created 2015年6月5日 上午11:01:32 
 */

public interface HtglBmService {

	/**
	 * 根据条件查询所有部门信息
	 * 描述：用于创建部门Tree
	 * @return HtglBm
	 */
	public HtglBm queryDataToCreateTree(HtglBm bm);

	/**
	 * 将处理好的“部门信息”转换成Combotree数据
	 */
	public Combotree dataToCombotree(HtglBm bm);

	/**
	 * 根据部门编码查询全部部门信息
	 */
	public List<HtglBm> queryAllBySome(HtglBm bm);

	/**
	 * 根据部门编码统计部门数量
	 */
	public int countNumBySome(HtglBm bm);

	/**
	 * 添加
	 */
	public boolean bmAddOne(HtglBm bm);

	/**
	 * 删除部门
	 */
	public boolean bmDeleteOne(HtglBm bm);

	/**
	 * 修改
	 */
	public boolean bmUpdateOne(HtglBm bm);

	/**
	 * 修改“启用/禁用”
	 */
	public boolean bmUpdateOneQyzt(HtglBm bm);

	/**
	 * 根据部门编码查询其下所有bmcode.length=6的部门
	 * 描述：用于点击“工料机”Tree上的查询条件
	 * @param bm
	 * @return
	 */
	public List<HtglBm> queryBmToGlj(HtglBm bm);

	/**
	 * 根据部门编码查询部门名称
	 */
	String queryBmnameByBmcode(HtglBm bm);

}
