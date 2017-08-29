package com.hdsx.hmglyh.gis.util;

import org.apache.commons.lang.StringUtils;

import com.hdsx.hmglyh.gis.jichusj.gouzaowu.dao.GouzaowuMapper;
import com.hdsx.hmglyh.util.SpringContextUtil;

public class GisUtil {
	
	/**
	 * 通过桥梁编码获取桥梁名称
	 * @return
	 */
	public static String getQlname(String code){
		if(StringUtils.isBlank(code)) {
			return "";
		}
		GouzaowuMapper gzwMapper = (GouzaowuMapper) SpringContextUtil.getBean("gouzaowuMapper");
		return gzwMapper.getQlname(code);
	}
	
	/**
	 * 通过隧道编码获取隧道名称
	 * @return
	 */
	public static String getSdname(String code){
		if(StringUtils.isBlank(code)) {
			return "";
		}
		GouzaowuMapper gzwMapper = (GouzaowuMapper) SpringContextUtil.getBean("gouzaowuMapper");
		return gzwMapper.getSdname(code);
	}
	
	/**
	 * 通过涵洞编码获取涵洞名称
	 * @return
	 */
	public static String getHdname(String code){
		if(StringUtils.isBlank(code)) {
			return "";
		}
		GouzaowuMapper gzwMapper = (GouzaowuMapper) SpringContextUtil.getBean("gouzaowuMapper");
		return gzwMapper.getHdname(code);
	}
	
}
