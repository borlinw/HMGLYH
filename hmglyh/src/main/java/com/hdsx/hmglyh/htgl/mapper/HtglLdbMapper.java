package com.hdsx.hmglyh.htgl.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hdsx.hmglyh.dao.Mapper;
import com.hdsx.hmglyh.htgl.bean.HtglLdb;

/**  
 *  后台管理 - 路段表/路线表 - Mapper
 * @author LiRui
 * @created 2015年6月9日 下午6:36:23 
 */
@Mapper
public interface HtglLdbMapper {

	/**
	 * 查询全部信息（路线）
	 * 描述：查询条件/添加路段
	 */
	List<HtglLdb> queryLxToCreateCombobox();

	/**
	 * 添加
	 */
	int addOneLd(HtglLdb ld);

	/**
	 * 删除
	 */
	int deleteOneLd(HtglLdb ld);

	/**
	 * 修改
	 * 描述：根据ldcode对ldname，szhh，ezhh，mileage，bz进行修改
	 */
	int updateOneLd(HtglLdb ld);

	/**
	 * 根据条件查询全部路段信息
	 */
	List<HtglLdb> selectAllLdBySome(HtglLdb ld);

	/**
	 * 统计数据
	 * 描述：DataGrid用
	 */
	int countNumBySome(HtglLdb ld);

	/**
	 * 查询父节点（路段）
	 */
	HtglLdb selectFatherLd(HtglLdb ld);

	/**
	 * 查询子节点（路段）
	 */
	List<HtglLdb> selectChildrenLd(HtglLdb ld);

	/**
	 * 主键生成策略
	 * 描述：当前层级最大的ID+1（Action层除将Ldcode截去两位）
	 */
	HtglLdb generationPK(HtglLdb ld);

	/**
	 * 根据部门编码查询其下的路段数据
	 * 描述：用于创建某部门下的路段下拉树
	 */
	List<HtglLdb> queryLdByBmcodeToCreateCombobox(HtglLdb ld);
	
}
