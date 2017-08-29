package com.hdsx.hmglyh.htgl.mapper;

import java.util.List;

import com.hdsx.hmglyh.dao.Mapper;
import com.hdsx.hmglyh.htgl.bean.HtglJs;

/**  
 *  后台管理 - 角色Mapper
 * @author LiRui
 * @created 2015年6月11日 上午10:13:24 
 */
@Mapper
public interface HtglJsMapper {

	/**
	 * 添加角色
	 */
	int addOneJs(HtglJs js);

	/**
	 * 获取当前可供添加的角色的ID（角色表主键）
	 */
	int generationPK();

	/**
	 * 删除角色
	 */
	int deleteOneJs(HtglJs js);

	/**
	 * 修改角色
	 */
	int updateOneJs(HtglJs js);

	/**
	 * 查询全部
	 */
	List<HtglJs> queryAllJs(HtglJs js);

	/**
	 * 查询全部
	 * 用于：创建角色下拉框
	 */
	List<HtglJs> queryAllJsToYh();

	/**
	 * 统计当前角色数量
	 */
	int countNum();

	/**
	 * 添加角色模块对应信息
	 */
	int addJsMk(HtglJs jsmk);

	/**
	 * 删除角色模块对应信息
	 */
	int delereJsMk(HtglJs jsmk);

	/**
	 * 根据Jsid查询其下对应的所有的模块信息
	 */
	String queryJsMkByJsid(HtglJs jsmk);

	/**
	 * 获取模块父节点
	 */
	List<HtglJs> selectFatherOfMk();

	/**
	 * 获取模块子节点
	 */
	List<HtglJs> selectChildrenOfMk(HtglJs mk);

}
