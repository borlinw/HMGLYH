
 /**
 * 北京恒达时讯科技有限公司版权所有
 * Copyright (C) HDSX Corporation. All Rights Reserved
 */
package com.hdsx.hmglyh.jcpd.controller;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.hdsx.hmglyh.base.BaseActionSupport;
import com.hdsx.hmglyh.jcpd.bean.Gzdxzb;
import com.hdsx.hmglyh.jcpd.service.GzdxzbService;
import com.hdsx.hmglyh.util.JsonUtils;

/**  
 *  
 * @author Baiyy
 * @created 2015年7月15日 下午5:37:17 
 */
@Controller
@Scope(value="request")
public class GzdxzbController extends BaseActionSupport<Gzdxzb> {
	private static final long serialVersionUID = 7143641730344887959L;
	
	@Resource(name="gzdxzbServiceImpl")
	private GzdxzbService gzdxzbService;

	private Gzdxzb gzdxzb = new Gzdxzb();
	

	public Gzdxzb getGzdxzb() {
		return gzdxzb;
	}
	public void setGzdxzb(Gzdxzb gzdxzb) {
		this.gzdxzb = gzdxzb;
	}


	public void getZbid() throws Exception{
		String id = gzdxzbService.getZbid(gzdxzb);
		Gzdxzb g = new Gzdxzb();
		g.setGzid(id);
		JsonUtils.write(g, this.getResponse().getWriter());
	}
	

	@Override
	public Gzdxzb getModel() {
		return gzdxzb;
	}

	@Override
	protected void prepareModel() throws Exception {
		// TODO Auto-generated method stub
		
	}

}
