package com.hdsx.hmglyh.rcyh.dao;

import java.util.List;

import com.hdsx.hmglyh.dao.Mapper;
import com.hdsx.hmglyh.rcyh.dao.model.RcyhWxzg;

/**  
 *  日常养护 - 维修整改（通知单+回复单）
 * @author LiRui
 * @created 2015年6月24日 下午2:57:21 
 */
@Mapper
public interface RcyhWxzgMapper {

	/**
	 * 添加一条“整改通知单”信息
	 */
	int addOneTzd(RcyhWxzg zgtzd);

	/**
	 * 删除一条“整改通知单”信息
	 */
	int deleteOneTzd(RcyhWxzg zgtzd);

	/**
	 * 修改一条“整改通知单”信息
	 */
	int updateOneTzd(RcyhWxzg zgtzd);

	/**
	 * 修改
	 * 描述：“整改通知单”的接单操作
	 * 修改通知单的接单人，接单时间，通知单状态=1
	 */
	int updateOneTzdOfJd(RcyhWxzg zgtzd);

	/**
	 * 按条件查询“维修整改通知单”信息
	 */
	List<RcyhWxzg> queryZgtzdBySome(RcyhWxzg zgtzd);

	/**
	 * 按条件统计“维修整改通知单”数量
	 */
	int countZgtzdNumBySome(RcyhWxzg zgtzd);

	/**
	 * 添加一条“整改回复单”信息
	 */
	int addOneHfd(RcyhWxzg zghfd);

	/**
	 * 删除一条“整改回复单”信息
	 */
	int deleteOneHfd(RcyhWxzg zghfd);

	/**
	 * 修改一条“整改回复单”信息
	 */
	int updateOneHfd(RcyhWxzg zghfd);

	/**
	 * 按条件查询“维修整改回复单”信息
	 */
	List<RcyhWxzg> queryZghfdBySome(RcyhWxzg zghfd);

	/**
	 * 按条件统计“维修整改回复单”数量
	 */
	int countZghfdNumBySome(RcyhWxzg zghfd);

	/**
	 * 根据“维修整改通知单”tzdid查询通知单的信息，用于：回复单中“查看”操作
	 */
	RcyhWxzg queryOneZgtzdByTzdid(RcyhWxzg zgtzd);

	/**
	 * 修改通知单状态
	 */
	int updateTzdzt(RcyhWxzg zgtzd);

	/**
	 * 审核某回复单
	 * 修改回复单的检查人等信息
	 */
	int updateOneHfdOfSh(RcyhWxzg zgtzd);

	/**
	 * 根据“维修整改通知单”tzdid查询其对应“回复单”的信息，用于：审核回复单
	 */
	RcyhWxzg queryZghfdByTzdid(RcyhWxzg zgtzd);

	/**
	 * 返工“回复单”的修改
	 * 描述：修改sjwctime，zgcs，zgjg
	 */
	int fgOfHfd(RcyhWxzg zgtzd);

	/**
	 * 根据通知单ID查询数据
	 * 描述：用于导出Excel
	 */
	RcyhWxzg queryTzdToExport(RcyhWxzg zgtzd);

	/**
	 * 根据回复单ID查询数据
	 * 描述：用于导出Excel
	 */
	RcyhWxzg queryHfdToExport(RcyhWxzg zgtzd);

}
