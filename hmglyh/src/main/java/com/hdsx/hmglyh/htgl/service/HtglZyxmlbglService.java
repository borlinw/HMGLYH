package com.hdsx.hmglyh.htgl.service;

import java.util.List;

import com.hdsx.hmglyh.htgl.bean.HtglDeb;
import com.hdsx.hmglyh.htgl.bean.HtglYhlxb;
import com.hdsx.hmglyh.util.Combotree;

/**  
 *  后台管理 - 作业项目类别管理
 * @author LiRui
 * @created 2015年6月11日 下午8:34:38 
 */

public interface HtglZyxmlbglService {

	/**
	 * 添加（养护类型）
	 */
	boolean addOneYhlxb(HtglYhlxb yhlx);

	/**
	 * 删除（养护类型）
	 */
	boolean deleteOneYhlxb(HtglYhlxb yhlx);

	/**
	 * 修改（养护类型）
	 */
	boolean updateOneYhlxb(HtglYhlxb yhlx);

	/**
	 * 修改（养护类型“启用/禁用”）
	 */
	boolean updateOneYhlxbQyzt(HtglYhlxb yhlx);

	/**
	 * 根据条件查询全部“养护类型”
	 */
	List<HtglYhlxb> queryAllBySomeOfYhlx(HtglYhlxb yhlx);

	/**
	 * 根据条件统计“养护类型”
	 */
	int countNumBySomeOfYhlx(HtglYhlxb yhlx);

	/**
	 * 创建“养护类型”树
	 */
	List<HtglYhlxb> createYhlxTree();

	/**
	 * 将“养护类型”数据转化成Tree数据
	 */
	List<Combotree> createListOfCombotree(List<HtglYhlxb> yhlxList);

	/**
	 * 修改（养护类型“定额状态”）
	 */
	boolean updateOneYhlxbDezt(HtglYhlxb yhlx);

	/**
	 * 修改（养护类型“定额启动状态”）
	 */
	boolean updateOneYhlxbDeqdzt(HtglYhlxb yhlx);

	/**
	 * 修改（养护类型“是否裂缝修补”）
	 */
	boolean updateOneYhlxbIslfxb(HtglYhlxb yhlx);

	/**
	 * 修改（养护类型“是否沥青路面修补”）
	 */
	boolean updateOneYhlxbIslqlmxb(HtglYhlxb yhlx);

	/**
	 * 添加一系列的定额信息
	 */
	boolean addDe(List<HtglDeb> deList);

	/**
	 * 根据Yhid删除一系列定额信息
	 */
	boolean deleteDeOfYhid(HtglDeb de);

	/**
	 * 根据Yhid查询其下的定额信息
	 * 用于：查看某Yhid下的所有定额
	 */
	List<HtglDeb> queryAllDeByYhid(HtglDeb de);

}
