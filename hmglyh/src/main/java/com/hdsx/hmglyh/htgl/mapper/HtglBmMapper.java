package com.hdsx.hmglyh.htgl.mapper;

import java.util.List;

import com.hdsx.hmglyh.dao.Mapper;
import com.hdsx.hmglyh.htgl.bean.HtglBm;

/**  
 *  后台管理 - 部门Mapper
 * @author LiRui
 * @created 2015年6月5日 上午10:45:41 
 */
@Mapper
public interface HtglBmMapper {

	/**
	 * 查询部门信息（父节点）
	 */
	public HtglBm selectFather(HtglBm bm);

	/**
	 * 查询部门信息（子节点）
	 */
	public List<HtglBm> selectChildren(HtglBm bm);

	/**
	 * 根据部门编码查询全部部门信息
	 */
	public List<HtglBm> queryAllBySome(HtglBm bm);

	/**
	 * 根据部门编码统计部门数量
	 */
	public int countNumBySome(HtglBm bm);

	/**
	 * 查询添加“部门”信息所需要的主键
	 */
	public HtglBm generationPK(HtglBm bm);

	/**
	 * 添加部门
	 */
	public int bmAddOne(HtglBm bm);

	/**
	 * 删除部门
	 */
	public int bmDeleteOne(HtglBm bm);

	/**
	 * 修改
	 */
	public int bmUpdateOne(HtglBm bm);

	/**
	 * 修改“启用/禁用”
	 */
	public int bmUpdateOneQyzt(HtglBm bm);

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
