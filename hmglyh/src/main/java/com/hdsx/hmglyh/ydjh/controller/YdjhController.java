/**
 * 北京恒达时讯科技有限公司版权所有
 * Copyright (C) HDSX Corporation. All Rights Reserved
 */
package com.hdsx.hmglyh.ydjh.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.hdsx.hmglyh.base.BaseActionSupport;
import com.hdsx.hmglyh.util.EasyUIPage;
import com.hdsx.hmglyh.util.JsonUtils;
import com.hdsx.hmglyh.ydjh.bean.RcyhRwdjlb;
import com.hdsx.hmglyh.ydjh.service.YdjhService;

/**
 * 
 * @author jason
 *
 */
@Controller
@Scope(value="request")
public class YdjhController extends BaseActionSupport<RcyhRwdjlb> {

	private static final long serialVersionUID = 8057157708296446306L;

	@Resource(name="ydjhServiceImpl")
	private YdjhService ydjhService;
	
	private RcyhRwdjlb rcyhRwdjlb = new RcyhRwdjlb();
	
	public RcyhRwdjlb getRcyhRwdjlb() {
		return rcyhRwdjlb;
	}
	public void setRcyhRwdjlb(RcyhRwdjlb rcyhRwdjlb) {
		this.rcyhRwdjlb = rcyhRwdjlb;
	}
	/**
	 * 按条件查询任务单
	 */
	public void getRwdBytj() throws Exception{
		List<RcyhRwdjlb> list = ydjhService.getRwdBytj(rcyhRwdjlb);
		int total = ydjhService.getRwdBytjCount(rcyhRwdjlb);
		EasyUIPage<RcyhRwdjlb> ep = new EasyUIPage<RcyhRwdjlb>();
		ep.setRows(list);
		ep.setTotal(total);
		JsonUtils.write(ep, this.getResponse().getWriter());
	}
	

	@Override
	protected void prepareModel() throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public RcyhRwdjlb getModel() {
		return rcyhRwdjlb;
	}
}
