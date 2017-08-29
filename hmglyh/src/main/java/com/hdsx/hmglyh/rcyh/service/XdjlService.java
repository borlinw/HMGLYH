package com.hdsx.hmglyh.rcyh.service;

import java.util.List;

import com.hdsx.hmglyh.rcyh.dao.model.RcyhGlxcsjb;

public interface XdjlService {
	
	/**
	 *  高速公路巡视单
	 */
	public RcyhGlxcsjb queryglxcsjbByUsername(String username);
	
	/**
	 * 根据 巡查id 查询 巡查数据表 关联 了 部门表
	 * @param xcsj
	 * @return
	 */
	public RcyhGlxcsjb selectGlxcsjb(RcyhGlxcsjb xcsj);
	
	
	/**
	 * 寻道记录列表
	 * @param xdjl
	 * @return
	 */
	public List<RcyhGlxcsjb> listXdsj(RcyhGlxcsjb xdjl);
	/**
	 * 总数
	 * @param xcsj
	 * @return
	 */
	public int listXdsjCount(RcyhGlxcsjb xcsj);
	/**
	 * 根据 寻道记录的编码查询 数据
	 * @param xcsj
	 * @return
	 */
	public RcyhGlxcsjb queryXdsjByKey(RcyhGlxcsjb xcsj);
	/**
	 * 保存一条寻道记录
	 * @param xdjl
	 */
	public int saveXdjl(RcyhGlxcsjb xdjl);
	
	/**
	 * 判断 此寻道记录 关联的病害记录表 是否已经 拥有了 记录
	 * @return
	 */
	public boolean canDelXdjl(RcyhGlxcsjb xdjl);
	
	/**
	 * 删除一条寻道记录
	 * @param xdjl
	 */
	public void delXdjl(RcyhGlxcsjb xdjl);
	
	/**
	 * 同时删除多条病害
	 * @param xdjl
	 */
	public void delXdjls(RcyhGlxcsjb xdjl);
	
	/**
	 * 更新一条寻道记录
	 * @param xdjl
	 */
	public int updateXdjl(RcyhGlxcsjb xdjl);
	/**
	 * 查询统计巡道记录信息表用，按条件查询巡道记录
	 * @param xdjl
	 * @return
	 */
	List<RcyhGlxcsjb> getXdjlForXdcx(RcyhGlxcsjb xdjl);
	/**
	 * 查询统计巡道记录信息表用，按条件查询巡道记录条数
	 * @param xdjl
	 * @return
	 */
	int getXdjlCountForXdcx(RcyhGlxcsjb xdjl);
	
	/**
	 * 根据巡查id查询巡道信息，用于导出
	 * @param xcid
	 * @return
	 */
	RcyhGlxcsjb getXcsjForExport(String xcid);
	
}
