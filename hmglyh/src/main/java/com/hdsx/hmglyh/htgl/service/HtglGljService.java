package com.hdsx.hmglyh.htgl.service;

import java.util.List;

import com.hdsx.hmglyh.htgl.bean.HtglGlj;
import com.hdsx.hmglyh.util.Combobox;
import com.hdsx.hmglyh.util.Combotree;

/**  
 *  后台管理 - 工料机Service
 * @author LiRui
 * @created 2015年6月4日 下午2:44:12 
 */

public interface HtglGljService {

	/**
	 * 根据条件查询所有工料机数据
	 * 描述：用于创建工料机Tree
	 * @return HtglGlj
	 */
	public HtglGlj queryDataToCreateTree(HtglGlj glj);

	/**
	 * 将处理好的“工料机”数据转换成Combotree数据
	 */
	public Combotree dataToCombotree(HtglGlj glj);

	/**
	 * 工料机的主键生成规则
	 * 描述：根据父层级的bhid生成子节点的下一个可用id
	 * 数据类型：0101
	 */
	public String generationPK(HtglGlj glj);

	/**
	 * 查询工料机
	 */
	public List<HtglGlj> queryGljByLxidAndBmcode(HtglGlj glj);

	/**
	 * 查询工料机数量
	 */
	public int countNumBySome(HtglGlj glj);

	/**
	 * 添加（类型）
	 */
	public boolean gljlxAddOne(HtglGlj glj);

	/**
	 * 删除（类型）
	 */
	public boolean gljlxDeleteOne(HtglGlj glj);

	/**
	 * 修改（类型）
	 */
	public boolean gljlxUpdateOne(HtglGlj glj);

	/**
	 * 更改“启用/禁用”状态
	 */
	public boolean gljlxUpdateOneQyzt(HtglGlj glj);

	/**
	 * 添加（价格）
	 */
	public boolean gljjgAddOne(HtglGlj glj);

	/**
	 * 修改（价格）
	 */
	public boolean gljjgUpdateOne(HtglGlj glj);

	/**
	 * 查询全部非“类型”类的“工料机”
	 * 用于：作业项目类别管理中的“添加定额”
	 * 2016-06-16（从addDe功能废弃）
	 */
	List<Combobox> queryAllToCreateComboboxToDeb();

	/**
	 * 查询全部非“类型”类的“工料机”
	 * 用于：作业项目类别管理中的“添加定额”
	 * 新版方法（2016-06-16新建）
	 */
	List<HtglGlj> queryAllToCreateComboboxToDeb2();

	/**
	 * 将“工料机”数据转化成Tree数据
	 * 描述：添加“定额”专用
	 */
	Combotree createCombotreeToInsertDe(HtglGlj glj);

	/**
	 * 验证编号是否存在
	 */
	boolean verifyBm(HtglGlj glj);

}
