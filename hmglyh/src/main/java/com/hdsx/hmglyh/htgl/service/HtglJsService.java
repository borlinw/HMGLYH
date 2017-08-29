package com.hdsx.hmglyh.htgl.service;

import java.util.List;

import com.hdsx.hmglyh.htgl.bean.HtglJs;
import com.hdsx.hmglyh.util.Combobox;
import com.hdsx.hmglyh.util.Combotree;

/**  
 *  后台管理 - 角色Service
 * @author LiRui
 * @created 2015年6月11日 上午11:04:04 
 */

public interface HtglJsService {

	/**
	 * 添加角色
	 */
	boolean addOneJs(HtglJs js);

	/**
	 * 获取当前可供添加的角色的ID（角色表主键）
	 */
	int generationPK();

	/**
	 * 删除角色
	 */
	boolean deleteOneJs(HtglJs js);

	/**
	 * 修改角色
	 */
	boolean updateOneJs(HtglJs js);

	/**
	 * 查询全部
	 */
	List<HtglJs> queryAllJs(HtglJs js);

	/**
	 * 统计当前角色数量
	 */
	int countNum();

	/**
	 * 创建页面（模块）树
	 */
	List<HtglJs> queryDataToCreateYmTree();

	/**
	 * 将List转换成Combotree
	 */
	Combotree dataToCombotree(HtglJs js);

	/**
	 * 创建角色Combobox
	 */
	List<Combobox> createJsCombobox(HtglJs js);

}
