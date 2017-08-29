package com.hdsx.hmglyh.rcyh.service;

import java.util.List;

import com.hdsx.hmglyh.rcyh.dao.model.RcyhRwdjlb;
import com.hdsx.hmglyh.rcyh.dao.model.RcyhYdjhshb;

/**
 * 月度计划审核
 * @author Administrator
 *
 */
public interface YdjhshService {
	
	/**
	 * 提交审核
	 * @param rwds
	 * @param ydjhsh
	 * @return
	 */
	int tijiaoShenhe(RcyhYdjhshb ydjhsh);

	/**
	 * 分局执行 审核的操作
	 * @param rwds
	 * @param ydjhsh
	 * @return
	 */
	int shenhe(RcyhYdjhshb ydjhsh);
	
	/**
	 * 根据部门编码,路段,所属年月 查询 月度计划审核
	 * @param ydjhsh
	 * @return
	 */
	RcyhYdjhshb queryYhjhshByCondition(String bmcode,String ldcode,String ssny);

	boolean canTijiaosh(String bmcode, String ldcode, String ssny);
}
