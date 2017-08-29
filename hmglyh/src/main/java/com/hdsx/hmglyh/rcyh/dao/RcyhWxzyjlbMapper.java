package com.hdsx.hmglyh.rcyh.dao;

import java.util.HashMap;
import java.util.List;

import com.hdsx.hmglyh.dao.Mapper;
import com.hdsx.hmglyh.rcyh.dao.model.RcyhWxzyjlb;
@Mapper
public interface RcyhWxzyjlbMapper {
    int deleteByPrimaryKey(String zyid);

    int insert(RcyhWxzyjlb record);

    int insertSelective(RcyhWxzyjlb record);

    RcyhWxzyjlb selectByPrimaryKey(String zyid);

    int updateByPrimaryKeySelective(RcyhWxzyjlb record);

    int updateByPrimaryKey(RcyhWxzyjlb record);

    /**
     * 维修作业 列表
     * @param wxzy
     * @return
     */
	List<RcyhWxzyjlb> listWxzy(RcyhWxzyjlb wxzy);
	/**
	 * 维修作业 总数
	 * @param wxzy
	 * @return
	 */
	int listWxzyCount(RcyhWxzyjlb wxzy);
	
	List<RcyhWxzyjlb> listWxzycx(RcyhWxzyjlb wxzy);
	int listWxzycxCount(RcyhWxzyjlb wxzy);
	
	/**
	 * 维修作业汇总列表
	 * @param wxzy
	 * @return
	 */
	List<RcyhWxzyjlb> listWxzyHz(RcyhWxzyjlb wxzy);
	
	/**
	 * 
	 * 
	 * 维修作业汇总 总数
	 * @param wxzy
	 * @return
	 */
	public int listWxzyHzCount(RcyhWxzyjlb wxzy);

	/**
	 * 根据养护ID 和 路段编码 查询 所有的 维修记录
	 * @param variable
	 * @return
	 */
	List<RcyhWxzyjlb> wxjlByYhidAndLd(HashMap<String, Object> variable);

	RcyhWxzyjlb queryWxzyByKeyWithZps(String zyid);

	/**
	 * 通过 维修作业 ID 查询维修作业的信息  不使用 级联 查询  任何
	 * @param zyid
	 * @return
	 */
	RcyhWxzyjlb queryWxzyByKeySimple(String zyid);

	/**
	 * 特殊部门维修作业的汇总
	 * @param wxzy
	 * @return
	 */
	List<RcyhWxzyjlb> listTsbmWxzyHz(RcyhWxzyjlb wxzy);
	int listTsbmWxzyHzCount(RcyhWxzyjlb wxzy);

	RcyhWxzyjlb selectByPrimaryKeySimple(String zyid);
}