package com.hdsx.hmglyh.htgl.service;

import java.util.List;

import com.hdsx.hmglyh.htgl.bean.HtglMjlx;

/**  
 *  枚举Service
 * @author LiRui
 * @created 2015年6月5日 上午10:22:37 
 */

public interface HtglMjService {

	/**
	 * 根据type查询数据
	 * 描述：用于创建枚举类型下拉框
	 */
	public List<HtglMjlx> queryDateToCreateCombobox(HtglMjlx mj);

}
