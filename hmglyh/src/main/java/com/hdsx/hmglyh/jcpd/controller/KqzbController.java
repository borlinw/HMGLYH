
 /**
 * 北京恒达时讯科技有限公司版权所有
 * Copyright (C) HDSX Corporation. All Rights Reserved
 */
package com.hdsx.hmglyh.jcpd.controller;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.hdsx.hmglyh.base.BaseActionSupport;
import com.hdsx.hmglyh.jcpd.bean.Kqzb;
import com.hdsx.hmglyh.jcpd.service.KqzbService;
import com.hdsx.hmglyh.util.JsonUtils;

/**  
 *  
 * @author Baiyy
 * @created 2015年7月15日 下午5:37:17 
 */
@Controller
@Scope(value="request")
public class KqzbController extends BaseActionSupport<Kqzb> {
	private static final long serialVersionUID = 7143641730344887959L;
	
	@Resource(name="kqzbServiceImpl")
	private KqzbService kqzbService;

	private Kqzb kqzb = new Kqzb();
	
	public Kqzb getKqzb() {
		return kqzb;
	}

	public void setKqzb(Kqzb kqzb) {
		this.kqzb = kqzb;
	}

	public void getZbid() throws Exception{
		Kqzb k = kqzbService.getZbid(kqzb);
		JsonUtils.write(k, this.getResponse().getWriter());
	}
	

	@Override
	public Kqzb getModel() {
		return kqzb;
	}

	@Override
	protected void prepareModel() throws Exception {
		// TODO Auto-generated method stub
		
	}

}
