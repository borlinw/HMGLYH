package com.hdsx.hmglyh.rcyh.dao;

import java.util.List;

import com.hdsx.hmglyh.dao.Mapper;
import com.hdsx.hmglyh.rcyh.dao.model.RcyhCxbbb;

/**  
 *  日常养护 - 除雪版本表
 * @author LiRui
 * @created 2015年8月21日 下午12:53:19 
 */
@Mapper
public interface RcyhCxbbbMapper {

	/**
	 * 添加“除雪版本”信息
	 */
	int addOneCxbbb(RcyhCxbbb cxbb);

	/**
	 * 删除“除雪版本”信息
	 */
	int deleteOneCxbbb(RcyhCxbbb cxbb);

	/**
	 * 修改“除雪版本”信息
	 */
	int updateOneCxbbb(RcyhCxbbb cxbb);

	/**
	 * 查询全部
	 */
	List<RcyhCxbbb> queryAll(RcyhCxbbb cxbb);

	/**
	 * 统计“除雪版本”信息条数
	 */
	int countNum(RcyhCxbbb cxbb);

	/**
	 * 获取主键
	 * 描述：去数据库中主键数值最大的加1
	 */
	int generationPK();

	/**
	 * 根据bbid查询一条数据
	 * 描述：用于查看、编辑
	 */
	RcyhCxbbb queryOneByBBID(RcyhCxbbb cxbb);

	/**
	 * 根据bbid和bmcode查询当前部门版本的除雪年报是否已添加
	 * 用于：添加、查看除雪年报
	 */
	RcyhCxbbb queryCxnbByBBIDAndBmcode(RcyhCxbbb cxbb);

}
