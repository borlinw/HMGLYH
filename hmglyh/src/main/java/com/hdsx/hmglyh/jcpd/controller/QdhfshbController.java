
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
import com.hdsx.hmglyh.jcpd.bean.Qdhfb;
import com.hdsx.hmglyh.jcpd.bean.Qdhfshb;
import com.hdsx.hmglyh.jcpd.service.QdhfshbService;
import com.hdsx.hmglyh.util.EasyUIPage;
import com.hdsx.hmglyh.util.JsonUtils;
import com.hdsx.hmglyh.util.ResponseUtils;

/**  
 *  
 * @author Baiyy
 * @created 2015年8月8日 下午2:48:50 
 */
@Controller
@Scope(value="request")
public class QdhfshbController extends BaseActionSupport<Qdhfshb> {
	private static final long serialVersionUID = -4228035548512432022L;
	
	@Resource(name="qdhfshbServiceImpl")
	private QdhfshbService qdhfshbService;
	
	private Qdhfshb qdhfshb = new Qdhfshb();
	
	
	public Qdhfshb getQdhfshb() {
		return qdhfshb;
	}
	public void setQdhfshb(Qdhfshb qdhfshb) {
		this.qdhfshb = qdhfshb;
	}

	public void report() throws Exception{
		if(qdhfshbService.report(qdhfshb))
			ResponseUtils.write(getResponse(), "true");
		else
			ResponseUtils.write(getResponse(), "false");
	}
	
	public void reReport() throws Exception{
		if(qdhfshbService.reReport(qdhfshb))
			ResponseUtils.write(getResponse(), "true");
		else
			ResponseUtils.write(getResponse(), "false");
	}
	
	public void check(){
		if(qdhfshbService.check(qdhfshb))
			ResponseUtils.write(getResponse(), "true");
		else
			ResponseUtils.write(getResponse(), "false");
	}
	
	public void getShb() throws Exception{
		List<Qdhfshb> list = qdhfshbService.getShb(qdhfshb);
		for(Qdhfshb q:list){
			q.setBmCode1(q.getBmCode());
			q.setBbid1(q.getBbid());
		}
		EasyUIPage<Qdhfshb> ep = new EasyUIPage<Qdhfshb>();
		ep.setRows(list);
		JsonUtils.write(ep, this.getResponse().getWriter());
	}
	
	public void getShbForReport() throws Exception{
		List<Qdhfshb> list = qdhfshbService.getShbForReport(qdhfshb);
		EasyUIPage<Qdhfshb> ep = new EasyUIPage<Qdhfshb>();
		ep.setRows(list);
		JsonUtils.write(ep, this.getResponse().getWriter());
	}
	
	public void getQdhf() throws Exception{
		List<Qdhfb> list = qdhfshbService.getQdhf(qdhfshb);
		int total = qdhfshbService.getQdhfCount(qdhfshb);
		EasyUIPage<Qdhfb> ep = new EasyUIPage<Qdhfb>();
		ep.setRows(list);
		ep.setTotal(total);
		JsonUtils.write(ep, this.getResponse().getWriter());
	}
	
	@Override
	public Qdhfshb getModel() {
		return qdhfshb;
	}
	@Override
	protected void prepareModel() throws Exception {
		// TODO Auto-generated method stub
		
	}

}
