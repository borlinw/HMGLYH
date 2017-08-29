package com.hdsx.hmglyh.gis.jichusj.guanyangdw.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hdsx.hmglyh.dao.Mapper;
import com.hdsx.hmglyh.gis.jichusj.guanyangdw.dao.model.HtglBmb;
import com.hdsx.hmglyh.util.Combotree;
@Mapper
public interface HtglBmbMapper {
    HtglBmb selectByPrimaryKey(String bmcode);
    HtglBmb bumenList(HtglBmb bm);
	List<HtglBmb> bumenChildren(HtglBmb bmb);
	HtglBmb bumenParents(String bmcode);
	/**
	 * 各种类型部门 登录 获取 派工对象
	 * @param bmcode
	 * @return
	 */
	List<HtglBmb> getZjPgdx(String bmcode);
	List<HtglBmb> getFjPgdx(String bmcode);
	List<HtglBmb> getYhzPgdx(String bmcode);
	/**
	 * 分局用户 得到 所管辖下的 所有的养护站
	 * @param bmcode
	 * @return
	 */
	List<HtglBmb> getYhzs(String bmcode);
	
	Combotree selectBmCombotree(@Param("id") String id);
	
	/**
	 * 通过部门编码 查询 部门对象
	 * @param bmcode
	 * @return
	 */
	HtglBmb selectBmbByBmcode(@Param("bmcode") String bmcode);
}