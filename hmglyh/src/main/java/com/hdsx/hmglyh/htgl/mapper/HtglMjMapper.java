package com.hdsx.hmglyh.htgl.mapper;

import java.util.List;

import com.hdsx.hmglyh.dao.Mapper;
import com.hdsx.hmglyh.htgl.bean.HtglMjlx;

/**  
 *  后台管理 - 枚举Mapper
 * @author LiRui
 * @created 2015年6月5日 上午10:03:42 
 */
@Mapper
public interface HtglMjMapper {

	/**
	 * 根据枚举“type”查询数据
	 * 描述：用于创建枚举类型下拉框
	 */
	public List<HtglMjlx> queryMjByTypeToCreateCombobox(HtglMjlx mj);

}
