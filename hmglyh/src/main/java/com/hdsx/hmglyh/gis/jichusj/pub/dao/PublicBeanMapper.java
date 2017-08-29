
 /**
 * 北京恒达时讯科技有限公司版权所有
 * Copyright (C) HDSX Corporation. All Rights Reserved
 */
package com.hdsx.hmglyh.gis.jichusj.pub.dao;

import java.util.List;

import com.hdsx.hmglyh.gis.jichusj.pub.dao.model.PublicBean;

/**  
 *  
 * @author Baiyy
 * @created 2016年5月24日 下午3:41:09 
 */

public interface PublicBeanMapper {
	/**
	 * 通用方法，用于导出数据
	 * @param pb
	 * @return
	 */
	List<String> getData(PublicBean pb);
}
