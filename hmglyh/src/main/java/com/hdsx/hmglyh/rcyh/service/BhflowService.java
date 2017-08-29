package com.hdsx.hmglyh.rcyh.service;
import java.util.List;


/**
 * 病害工作流
 */

import com.hdsx.hmglyh.rcyh.dao.model.RcyhBhjlb;
import com.hdsx.hmglyh.rcyh.dao.model.RcyhRwdjlb;
import com.hdsx.hmglyh.rcyh.dao.model.RcyhWxzyjlb;

public interface BhflowService {
	/**
	 * 保存一条病害
	 * 流程 开启
	 * @param bhjl
	 */
	public int saveBh(RcyhBhjlb bhjl);
	
	/**
	 * 病害上报 
	 * @param bhjlb
	 */
	public void shangbaoBh(RcyhBhjlb bhjlb);

	/**
	 * 保存派工状态
	 * @param bhjl
	 * @param user
	 * @return
	 */
	public int savepg(RcyhRwdjlb rwd);
	
	/**
	 * 更新维修作业信息
	 * @param ids
	 * @param wxzy
	 */
	public int saveSb(List<RcyhWxzyjlb> wxzys);

	public int delRwd(String rwdid);

	public int saveEditRwd(RcyhRwdjlb rwd);

	
}
