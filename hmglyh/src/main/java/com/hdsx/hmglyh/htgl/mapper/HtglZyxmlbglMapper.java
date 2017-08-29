package com.hdsx.hmglyh.htgl.mapper;

import java.util.List;

import com.hdsx.hmglyh.dao.Mapper;
import com.hdsx.hmglyh.htgl.bean.HtglDeb;
import com.hdsx.hmglyh.htgl.bean.HtglYhlxb;

/**  
 *  后台管理 - 作业项目类别管理
 * @author LiRui
 * @created 2015年6月11日 下午8:13:38 
 */
@Mapper
public interface HtglZyxmlbglMapper {

	/**
	 * 添加（养护类型）
	 * 描述：定额状态和定额启动状态在添加“养护类型”时均默认为0
	 */
	int addOneYhlxb(HtglYhlxb yhlx);

	/**
	 * 删除（养护类型）
	 */
	int deleteOneYhlxb(HtglYhlxb yhlx);

	/**
	 * 修改（养护类型）
	 */
	int updateOneYhlxb(HtglYhlxb yhlx);

	/**
	 * 修改（养护类型“启用/禁用”）
	 */
	int updateOneYhlxbQyzt(HtglYhlxb yhlx);

	/**
	 * 获取养护类型主键
	 */
	String generationPKOfYhlx(HtglYhlxb yhlx);

	/**
	 * 根据条件查询全部“养护类型”
	 */
	List<HtglYhlxb> queryAllBySomeOfYhlx(HtglYhlxb yhlx);

	/**
	 * 根据条件统计“养护类型”
	 */
	int countNumBySomeOfYhlx(HtglYhlxb yhlx);

	/**
	 * 获取“养护类型”父节点
	 */
	List<HtglYhlxb> selectFatherOfYhlx();

	/**
	 * 获取“养护类型”子节点
	 */
	List<HtglYhlxb> selectChildrenOfYhlx(HtglYhlxb yhlx);

	/**
	 * 修改（养护类型“定额状态”）
	 */
	int updateOneYhlxbDezt(HtglYhlxb yhlx);

	/**
	 * 修改（养护类型“定额启动状态”）
	 */
	int updateOneYhlxbDeqdzt(HtglYhlxb yhlx);

	/**
	 * 修改（养护类型“是否裂缝修补”）
	 */
	int updateOneYhlxbIslfxb(HtglYhlxb yhlx);

	/**
	 * 修改（养护类型“是否沥青路面修补”）
	 */
	int updateOneYhlxbIslqlmxb(HtglYhlxb yhlx);

	/**
	 * 添加一系列的定额信息
	 */
	int addOneDe(HtglDeb de);

	/**
	 * 根据Yhid删除一系列定额信息
	 */
	int deleteDeOfYhid(HtglDeb de);

	/**
	 * 根据Yhid查询定额信息
	 * 用于：（前台页面删除定额时）验证原本是否有定额
	 * 用于：查看某“养护类型”下的定额信息
	 */
	List<HtglDeb> queryDeByYhid(HtglDeb de);

}
