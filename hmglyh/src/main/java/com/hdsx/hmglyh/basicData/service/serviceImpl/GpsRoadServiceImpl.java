/**
 * 北京恒达时讯科技有限公司版权所有
 * Copyright (C) HDSX Corporation. All Rights Reserved
 */
package com.hdsx.hmglyh.basicData.service.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hdsx.hmglyh.basicData.bean.GpsRoad;
import com.hdsx.hmglyh.basicData.mapper.GpsRoadMapper;
import com.hdsx.hmglyh.basicData.service.GpsRoadService;

/**  
 *  
 * @author Baiyy
 * @created 2015年5月27日 下午10:43:27 
 */
@Service
public class GpsRoadServiceImpl implements GpsRoadService {

	@Autowired
	private GpsRoadMapper gpsRoadMapper;
	
	/**   
	 * @return  
	 * @see com.hdsx.hmglyh.basicData.service.GpsRoadService#getAllLd()  
	 */
	@Override
	public List<GpsRoad> getAllLd() {
		return gpsRoadMapper.getAllLd();
		//return null;
	}

}
