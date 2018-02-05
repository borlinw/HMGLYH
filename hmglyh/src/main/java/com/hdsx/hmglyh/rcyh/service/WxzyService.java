package com.hdsx.hmglyh.rcyh.service;

import java.util.List;

import com.hdsx.hmglyh.rcyh.dao.model.RcyhRwdjlb;
import com.hdsx.hmglyh.rcyh.dao.model.RcyhWxzyjlb;
import com.hdsx.hmglyh.rcyh.dao.model.RcyhZyysjlb;


public interface WxzyService {
	
	/**
	 * 任务单 datagrid
	 * @param rwd
	 * @return
	 */
	List<RcyhRwdjlb> listRwd(RcyhRwdjlb rwd);
	
	/**
	 * 任务单 datagrid count
	 * @param rwd
	 * @return
	 */
	int listRwdCount(RcyhRwdjlb rwd);
	
	/**
	 * 任务单 datagrid
	 * @param rwd
	 * @return
	 */
	List<RcyhRwdjlb> listRwdForYdjh(RcyhRwdjlb rwd);
	int listRwdForYdjhCount(RcyhRwdjlb rwd);

	/**
	 * 根据 key 值 查询 任务单
	 * @param rwdid
	 * @return
	 */
	RcyhRwdjlb queryRwdByKey(String rwdid);
	
	/**
	 * 查询  包含 和 任务单 关联的机械材料消耗的 任务单
	 * @return
	 */
	RcyhRwdjlb selectByPrimaryKeyWithClxh(String rwdid);
	
	/**
	 * 维修作业 列表
	 * @param wxzy
	 * @return
	 */
	List<RcyhWxzyjlb> listWxzy(RcyhWxzyjlb wxzy);
	/**
	 * 维修作业 列表 总数
	 * @param wxzy
	 * @return
	 */
	int listWxzyCount(RcyhWxzyjlb wxzy);
	
	/**
	 * 通过作业ID 级联 查询 人员 记录和 材料消耗  维修作业 相关信息
	 * @param zyid
	 * @return
	 */
	RcyhWxzyjlb queryWxzyByKey(String zyid);
	
	/**
	 * 维修作业 汇总列表
	 * @param wxzy
	 * @return
	 */
	public List<RcyhWxzyjlb> listWxzyHz(RcyhWxzyjlb wxzy);
	
	/**
	 * 维修作业汇总列表总数
	 * @param wxzy
	 * @return
	 */
	public int listWxzyHzCount(RcyhWxzyjlb wxzy);
	
	/**
	 * 保存验收
	 * @param zyys
	 */
	int saveYs(RcyhZyysjlb zyys);
	
	/**
	 * 通过Key 查询 维修作业 级联查询 只有照片信息
	 * @param bhjlid
	 * @return
	 */
	RcyhWxzyjlb queryWxzyByKeyWithZps(String zyid);
	
	/**
	 * 根据维修作业的键 查询 维修作业的 信息 不使用级联查询 查询 任何的信息
	 * @param zyid
	 * @return
	 */
	RcyhWxzyjlb queryWxzyByKeySimple(String zyid);
	/**
	 * 
	 * @param wx
	 * @return
	 */
	int delWxzy(RcyhWxzyjlb wx);
	
	/**
	 * 更新维修作业
	 * @param wxzy
	 * @return
	 */
	int saveWxzyUpdate(RcyhWxzyjlb wxzy);
	
	/**
	 * 保存维修作业
	 * @param wxzy
	 */
	public int saveWxzy(RcyhWxzyjlb wxzy);
	/**
	 * 任务单列表
	 * @param rwd
	 * @return
	 */
	List<RcyhRwdjlb> listRwdcx(RcyhRwdjlb rwd);
	int listRwdcxCount(RcyhRwdjlb rwd);
	List<RcyhWxzyjlb> listWxzycx(RcyhWxzyjlb wxzy);
	int listWxzycxCount(RcyhWxzyjlb wxzy);
	int saveWxzyWithoutRwd(RcyhWxzyjlb wxzy);

	RcyhWxzyjlb selectByPrimaryKeySimple(String zyid);

	int saveTsbmys(RcyhWxzyjlb wxzy);
	
	
	/*
	 * 任务单查看状态更新
	 */
	int updateByCkzt(String rwdid);
	
	
}
