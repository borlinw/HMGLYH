/**
 * 北京恒达时讯科技有限公司版权所有
 * Copyright (C) HDSX Corporation. All Rights Reserved
 */
package com.hdsx.hmglyh.jcpd.controller;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.hdsx.hmglyh.base.BaseActionSupport;
import com.hdsx.hmglyh.jcpd.bean.Bbkzb;
import com.hdsx.hmglyh.jcpd.dto.Result;
import com.hdsx.hmglyh.jcpd.service.BbkzbService;
import com.hdsx.hmglyh.util.EasyUIPage;
import com.hdsx.hmglyh.util.JsonUtils;
import com.hdsx.hmglyh.util.ResponseUtils;

/**  
 *  
 * @author Baiyy
 * @created 2015年5月28日 下午11:44:04 
 */
@Controller
@Scope(value="request")
public class BbkzbController extends BaseActionSupport<Bbkzb> {
	private static final long serialVersionUID = 2587642116767524321L;
	
	@Resource(name="bbkzbServiceImpl")
	private BbkzbService bbkzbService;
	
	private Bbkzb bbkzb = new Bbkzb();
	
	public Bbkzb getBbkzb() {
		return bbkzb;
	}
	public void setBbkzb(Bbkzb bbkzb) {
		this.bbkzb = bbkzb;
	}
	/**
	 * 添加版本库
	 * 返回值：true、添加成功，false、添加失败
	 */
	public void addBbkzb(){
		try {
			bbkzb.setBbsj(new Date());
			bbkzbService.addBbkzb(bbkzb);
			ResponseUtils.write(getResponse(), "true");
		} catch (Exception e) {
			e.printStackTrace();
			ResponseUtils.write(getResponse(), "false");
		}
	}
	/**
	 * 修改版本库
	 * 返回值：-1、版本库已经被使用，不能修改；0、修改失败；1、修改成功
	 */
	public void changeBbkzb() throws Exception{
		int result = 0;
		try {
			boolean msg = bbkzbService.changeBbkzb(bbkzb);
			if(msg)
				result = 1;
			else
				result = -1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		Result r = new Result();
		r.setResult(result);
		JsonUtils.write(r, this.getResponse().getWriter());
	}
	/**
	 * 查询版本库
	 */
	public void queryBb() throws Exception{
		List<Bbkzb> list = bbkzbService.queryBb(bbkzb);
		int total = bbkzbService.getBbCount(bbkzb);
		EasyUIPage<Bbkzb> ep = new EasyUIPage<Bbkzb>();
		ep.setRows(list);
		ep.setTotal(total);
		JsonUtils.write(ep, this.getResponse().getWriter());
	}
	/**
	 * 删除版本库
	 * 返回值：-1、版本库已经被使用，不能删除；0、删除失败；1、删除成功
	 */
	public void dropBb() throws Exception{
		int result = 0;
		try {
			boolean msg = bbkzbService.dropBb(bbkzb);
			if(msg)
				result = 1;
			else
				result = -1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		Result r = new Result();
		r.setResult(result);
		JsonUtils.write(r, this.getResponse().getWriter());
	}
	
	public void getQmbb() throws Exception{
		List<Bbkzb> list = bbkzbService.queryBb(bbkzb);
		JsonUtils.write(list, this.getResponse().getWriter());
	}
	
	public void getBbid() throws Exception{
		System.out.println(bbkzb.getBbid()+"==="+bbkzb.getBblx());
		List<Bbkzb> list = bbkzbService.getBbid(bbkzb);
		JsonUtils.write(list, this.getResponse().getWriter());
	}
	/**
	 * 统计分析版本
	 * @throws Exception
	 */
	public void getBb() throws Exception{
		List<Bbkzb> list = bbkzbService.getBb(bbkzb);
		JsonUtils.write(list, this.getResponse().getWriter());
	}
	/**
	 * 路面检测沿用之前路面检测数据专用
	 * @throws Exception
	 */
	public void getBbForLmjc() throws Exception{
		List<Bbkzb> list = bbkzbService.getBbForLmjc(bbkzb);
		JsonUtils.write(list, this.getResponse().getWriter());
	}
	
	/**
	 * 区段划分用，带有上报状态
	 * @throws Exception
	 */
	public void getBbForQdhf() throws Exception{
		List<Bbkzb> list = bbkzbService.getBbForQdhf(bbkzb);
		JsonUtils.write(list, this.getResponse().getWriter());
	}
	
	@Override
	protected void prepareModel() throws Exception {
		// TODO Auto-generated method stub
		
	}
	@Override
	public Bbkzb getModel() {
		return bbkzb;
	}
	
}
