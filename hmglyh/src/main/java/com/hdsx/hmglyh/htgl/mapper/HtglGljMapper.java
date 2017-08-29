package com.hdsx.hmglyh.htgl.mapper;

import java.util.List;

import com.hdsx.hmglyh.dao.Mapper;
import com.hdsx.hmglyh.htgl.bean.HtglGlj;

/**  
 *  工料机Mapper
 * @author LiRui
 * @created 2015年6月4日 下午1:40:54 
 */
@Mapper
public interface HtglGljMapper {

	/**
	 * 增加（类型）
	 */
	public int gljlxAddOne(HtglGlj blj);

	/**
	 * 删除（类型）
	 */
	public int gljlxDeleteOne(HtglGlj blj);

	/**
	 * 修改（类型）
	 */
	public int gljlxUpdateOne(HtglGlj blj);

	/**
	 * 更改启用状态
	 */
	public int gljlxUpdateOneQyzt(HtglGlj blj);

	/**
	 * 根据条件查询全部
	 */
	public List<HtglGlj> queryAllBySome(HtglGlj blj);

	/**
	 * 根据查询全部的参数统计数据数量
	 */
	public int countNumBySome(HtglGlj blj);

	/**
	 * 查询病害类型（父节点）
	 */
	public HtglGlj selectFather(HtglGlj blj);

	/**
	 * 查询病害类型（子节点）
	 */
	public List<HtglGlj> selectChildren(HtglGlj blj);

	/**
	 * 主键生成规则
	 * 描述：根据父层级的Bhid查询下一层级的下一个可用主键
	 * 主键类型：0101..
	 */
	public HtglGlj generationPK(HtglGlj blj);

	/**
	 * 根据Lxid和Bmcode查询“工料机”的价格
	 */
	public HtglGlj queryJgByLxidAndBmcode(HtglGlj glj);

	/**
	 * 根据Lxid批量删除“工料机价格”信息
	 */
	public int gljjgDelete(HtglGlj glj);

	/**
	 * 添加（价格）
	 */
	public int gljjgAddOne(HtglGlj glj);

	/**
	 * 修改（价格）
	 */
	public int gljjgUpdateOne(HtglGlj glj);

	/**
	 * 查询全部非“类型”类的“工料机”
	 * 用于：作业项目类别管理中的“添加定额”
	 */
	List<HtglGlj> queryAllToCreateComboboxToDeb();

	/**
	 * 查询“材料”的工料机（父类）
	 */
	HtglGlj queryClToInsertDeb();

	/**
	 * 查询“机械”的工料机（父类）
	 */
	HtglGlj queryJxToInsertDeb();

	/**
	 * 获取children（用于添加定额）
	 */
	List<HtglGlj> selectChildrenOfInsertDe(HtglGlj glj);

	/**
	 * 验证编号是否存在
	 */
	int verifyBm(HtglGlj glj);

}
