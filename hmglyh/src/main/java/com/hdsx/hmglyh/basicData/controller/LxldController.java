/**
 * 北京恒达时讯科技有限公司版权所有
 * Copyright (C) HDSX Corporation. All Rights Reserved
 */
package com.hdsx.hmglyh.basicData.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.hdsx.hmglyh.base.BaseActionSupport;
import com.hdsx.hmglyh.basicData.bean.Lxld;
import com.hdsx.hmglyh.basicData.service.LxldService;
import com.hdsx.hmglyh.util.JsonUtils;

/**  
 *  
 * @author Baiyy
 * @created 2015年6月8日 下午1:25:50 
 */
@Controller
public class LxldController extends BaseActionSupport<Lxld> {
	private static final long serialVersionUID = -8647794432955176026L;
	@Resource(name="lxldServiceImpl")
	private LxldService lxldService;
	
	private Lxld lxld = new Lxld();

	public Lxld getLxld() {
		return lxld;
	}
	public void setLxld(Lxld lxld) {
		this.lxld = lxld;
	}
	
	public void getLxldCombo() throws Exception{
		System.out.println(lxld.getBmCode()+"======================");
		List<Lxld> list = lxldService.getLdCombo(lxld);
		JsonUtils.write(list, this.getResponse().getWriter());
	}
	
	// 筛选只有记录的结果  
	public void getLxldCombo2() throws Exception{
		System.out.println(lxld.getBmCode()+"======================");
		List<Lxld> list = lxldService.getLdCombo2(lxld);
		JsonUtils.write(list, this.getResponse().getWriter());
	}
	
	/**
	 * 交安设施 获取 路段 
	 * @throws Exception
	 */
	public void getTsbmLxldCombo() throws Exception{
		System.out.println(lxld.getBmCode()+"======================");
		List<Lxld> list = lxldService.getTsbmLxldCombo(lxld);
		JsonUtils.write(list, this.getResponse().getWriter());
	}

	public void getLxCombo() throws Exception{
		List<Lxld> list = lxldService.getLxCombo();
		JsonUtils.write(list, this.getResponse().getWriter());
	}
	
	public void getLxldComboForLkdc() throws Exception{
		System.out.println(lxld.getBmCode()+"======================");
		List<Lxld> list = lxldService.getLdCombo(lxld);
		List<Lxld> result = new ArrayList<Lxld>();
		Lxld lx = new Lxld();
		lx.setId("");
		lx.setText("全部");
		result.add(lx);
		result.addAll(list);
		JsonUtils.write(result, this.getResponse().getWriter());
	}
	
	@Override
	public Lxld getModel() {
		return lxld;
	}

	@Override
	protected void prepareModel() throws Exception {
		// TODO Auto-generated method stub
		
	}

}
