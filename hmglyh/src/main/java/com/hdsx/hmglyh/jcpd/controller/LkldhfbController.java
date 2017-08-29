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
import com.hdsx.hmglyh.jcpd.bean.Lkldhfb;
import com.hdsx.hmglyh.jcpd.dto.Result;
import com.hdsx.hmglyh.jcpd.service.LkldhfbService;
import com.hdsx.hmglyh.util.EasyUIPage;
import com.hdsx.hmglyh.util.JsonUtils;
import com.hdsx.hmglyh.util.ResponseUtils;
/**
 * 
 * @author jason
 *
 */
@Controller
@Scope(value="request")
public class LkldhfbController extends BaseActionSupport<Lkldhfb> {
	private static final long serialVersionUID = -7805855083368587522L;
	
	@Resource(name="lkldhfbServiceImpl")
	private LkldhfbService lkldhfbService;
	
	private Lkldhfb lkldhfb = new Lkldhfb();
	
	public Lkldhfb getLkldhfb() {
		return lkldhfb;
	}
	public void setLkldhfb(Lkldhfb lkldhfb) {
		this.lkldhfb = lkldhfb;
	}
	
	/**
	 * 查询原始路段
	 */
	public void getYsld() throws Exception{
		List<Lkldhfb> list = lkldhfbService.getYsld(lkldhfb);
		int total = lkldhfbService.getYsldCount(lkldhfb);
		EasyUIPage<Lkldhfb> ep = new EasyUIPage<Lkldhfb>();
		ep.setRows(list);
		ep.setTotal(total);
		JsonUtils.write(ep, this.getResponse().getWriter());
	}
	
	/**
	 * 添加
	 */
	public void addYsld(){
		try {
			lkldhfbService.addYsld(lkldhfb);
			ResponseUtils.write(getResponse(), "true");
			}catch (Exception e) {
				e.printStackTrace();
				ResponseUtils.write(getResponse(), "false");
			}
		}
	
	/**
	 * 删除一条路段数据
	 */
	public void dropYsld() throws Exception{
		int result = 0;
		try {
			boolean msg = lkldhfbService.dropYsld(lkldhfb);
			if(msg){
				result= 1;
			}else{
				result= -1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		Result r = new Result();
		r.setResult(result);
		JsonUtils.write(r, this.getResponse().getWriter());
	}
	/**
	 * 修改
	 * @throws Exception
	 */
	public void change() throws Exception{
	//	lkldhfbService.change(lkldhfb);
		int result = 0;
		try {
		boolean msg=lkldhfbService.change(lkldhfb);
		if(msg)
			result = 1;
		else
			result = -1;
	}catch (Exception e) {
		e.printStackTrace();
	}
		Result r = new Result();
		r.setResult(result);
		JsonUtils.write(r, this.getResponse().getWriter());
	}
	
	
	
	@Override
	protected void prepareModel() throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Lkldhfb getModel() {
		return lkldhfb;
	}
	
}
