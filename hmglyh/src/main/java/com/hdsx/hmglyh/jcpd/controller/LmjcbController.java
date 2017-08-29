
 /**
 * 北京恒达时讯科技有限公司版权所有
 * Copyright (C) HDSX Corporation. All Rights Reserved
 */
package com.hdsx.hmglyh.jcpd.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.hdsx.hmglyh.base.BaseActionSupport;
import com.hdsx.hmglyh.jcpd.bean.Lmjcb;
import com.hdsx.hmglyh.jcpd.service.LmjcbService;
import com.hdsx.hmglyh.util.EasyUIPage;
import com.hdsx.hmglyh.util.JsonUtils;
import com.hdsx.hmglyh.util.ResponseUtils;

/**  
 *  
 * @author Baiyy
 * @created 2015年6月25日 下午4:01:40 
 */
@Controller
@Scope(value="request")
public class LmjcbController extends BaseActionSupport<Lmjcb> {
	private static final long serialVersionUID = 2917219769260565714L;
	@Resource(name="lmjcbServiceImpl")
	private LmjcbService lmjcbService;
	
	private Lmjcb lmjcb = new Lmjcb();
	

	public Lmjcb getLmjcb() {
		return lmjcb;
	}
	public void setLmjcb(Lmjcb lmjcb) {
		this.lmjcb = lmjcb;
	}
	/**
	 * 路面检测查询
	 */
	public void getLmjc() throws Exception{
		List<Lmjcb> list = lmjcbService.getLmjc(lmjcb);
		int total = lmjcbService.getLmjcCount(lmjcb);
		EasyUIPage<Lmjcb> ep = new EasyUIPage<Lmjcb>();
		ep.setRows(list);
		ep.setTotal(total);
		JsonUtils.write(ep, this.getResponse().getWriter());
	}
	/**
	 * 沿用之前的数据
	 * @throws Exception
	 */
	public void copy() throws Exception{
		if(lmjcbService.copy(lmjcb))
			ResponseUtils.write(this.getResponse(), "true");
		else
			ResponseUtils.write(getResponse(), "false");
	}
	

	@Override
	protected void prepareModel() throws Exception {
		// TODO Auto-generated method stub
		
	}
	@Override
	public Lmjcb getModel() {
		return lmjcb;
	}
	
	
}
