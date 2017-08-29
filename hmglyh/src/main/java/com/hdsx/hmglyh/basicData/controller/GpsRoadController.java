/**
 * 北京恒达时讯科技有限公司版权所有
 * Copyright (C) HDSX Corporation. All Rights Reserved
 */
package com.hdsx.hmglyh.basicData.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.hdsx.hmglyh.base.BaseActionSupport;
import com.hdsx.hmglyh.basicData.bean.GpsRoad;
import com.hdsx.hmglyh.basicData.service.GpsRoadService;
import com.hdsx.hmglyh.util.JsonUtils;

/**  
 *  
 * @author Baiyy
 * @created 2015年5月28日 下午4:37:16 
 */
@Controller
public class GpsRoadController extends BaseActionSupport<GpsRoad> {
	private static final long serialVersionUID = 2407181557326014616L;
	
	@Resource(name="gpsRoadServiceImpl")
	private GpsRoadService gpsRoadService;
	
	private GpsRoad gpsRoad = new GpsRoad();
	
	
	public GpsRoad getGpsRoad() {
		return gpsRoad;
	}

	public void setGpsRoad(GpsRoad gpsRoad) {
		this.gpsRoad = gpsRoad;
	}
	
	public void getAllLd() throws Exception{
		List<GpsRoad> list = gpsRoadService.getAllLd();
		JsonUtils.write(list, this.getResponse().getWriter());
	}
	
	
	@Override
	protected void prepareModel() throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public GpsRoad getModel() {
		// TODO Auto-generated method stub
		return gpsRoad;
	}
	
}
