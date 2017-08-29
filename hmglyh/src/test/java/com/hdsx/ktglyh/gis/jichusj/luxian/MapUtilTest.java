package com.hdsx.hmglyh.gis.jichusj.luxian;

import java.util.HashMap;
import java.util.List;

import com.hdsx.hmglyh.gis.jichusj.luxian.dao.model.Gpsmailroad;
import com.hdsx.hmglyh.gis.util.MapCatchUtil;

public class MapUtilTest {
	
	public static void main(String[] args) {
		Gpsmailroad mailroad = new Gpsmailroad();
		
		mailroad.setRoadcode("G217");	
		HashMap<String,Object> m = MapCatchUtil.getRoadShapeByRoadCode(mailroad);
		System.out.println(m);
		
	}

}
