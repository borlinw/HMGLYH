package com.hdsx.hmglyh.rcyh.service;

import java.util.List;

import com.hdsx.hmglyh.rcyh.dao.model.HtglBhlx;
import com.hdsx.hmglyh.rcyh.dao.model.RcyhBhjlb;

public interface BhService {
	
	/**
	 * 通过病害记录ID 查询 病害 
	 * @param bhjlid
	 * @return
	 */
	public RcyhBhjlb queryBhByKey(String bhjlid);
	
	/**
	 * 病害列表
	 * @param bhjl
	 * @return
	 */
	public List<RcyhBhjlb> listBh(RcyhBhjlb bhjl);
	
	/**
	 * 总数
	 * @param bhjl
	 * @return
	 */
	public int listBhCount(RcyhBhjlb bhjl);
	
	/**
	 * 病害类型树
	 * @return
	 */
	public List<HtglBhlx> selectBhlxs();
	
	
	/**
	 * 更新病害
	 * @param bhjl
	 */
	public int updateBh(RcyhBhjlb bhjl);
	
	/**
	 * 删除一条病害
	 * @param bhjl
	 */
	public int delBh(RcyhBhjlb bhjl);
	
	/**
	 * 同时删除 多条病害
	 * @param bhjl
	 * @return
	 */
	public void delBhs(RcyhBhjlb bhjl);

	/**
	 * 根据任务单ID 查询 病害 带 分页
	 * @param rwdid
	 * @return
	 */
	public List<RcyhBhjlb> listBhByRwdIdWithPage(int page,int rows,String rwdid);

	/**
	 * 根据任务单ID 查询 病害 带分页 对应的 总数
	 * @param rwdid
	 * @return
	 */
	public int listBhByRwdIdWithPageCount(String rwdid);
	
	/**
	 * 病害查询模块中的病害列表 
	 * @param bhjl
	 * @return
	 */
	public List<RcyhBhjlb> bhcxList(RcyhBhjlb bhjl);

	/**
	 * 病害查询中的病害列表的总数
	 * @param bhjl
	 * @return
	 */
	public int bhcxListCount(RcyhBhjlb bhjl);
	
	

}
