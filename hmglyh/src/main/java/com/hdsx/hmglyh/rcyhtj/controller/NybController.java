/**
 * 北京恒达时讯科技有限公司版权所有
 * Copyright (C) HDSX Corporation. All Rights Reserved
 */
package com.hdsx.hmglyh.rcyhtj.controller;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;

import com.hdsx.hmglyh.base.BaseActionSupport;
import com.hdsx.hmglyh.rcyhtj.bean.Nyb;
import com.hdsx.hmglyh.rcyhtj.service.NybService;
import com.hdsx.hmglyh.util.JsonUtils;

/**
 * 
 * @author jason
 *
 */
@Controller
public class NybController extends BaseActionSupport<Nyb> {

	private static final long serialVersionUID = -5307387331887316738L;

	@Resource(name="nybServiceImpl")
	private NybService nybService;
	
	private String bmcode; //部门 编码
	private String ldcode; //路线编码
	
	
	public String getBmcode() {
		return bmcode;
	}
	public void setBmcode(String bmcode) {
		this.bmcode = bmcode;
	}
	public String getLdcode() {
		return ldcode;
	}
	public void setLdcode(String ldcode) {
		this.ldcode = ldcode;
	}
	private Nyb nyb = new Nyb();
	
	public Nyb getNyb() {
		return nyb;
	}
	public void setNyb(Nyb nyb) {
		this.nyb = nyb;
	}
	/**
	 * 查询年月
	 */
	public void getNy() throws Exception{
		List<Nyb> list = nybService.getNy();
		JsonUtils.write(list, this.getResponse().getWriter());
	}
	
	/**
	 * 查询年月(只显示有作业验收的年月)
	 */
	public void getZyysNy() throws Exception{
		if(StringUtils.isNotBlank(bmcode) && StringUtils.isNotBlank(ldcode)) {
			HashMap<String,String> map = new HashMap<String,String>();
			map.put("bmcode", bmcode);
			map.put("ldcode", ldcode);
			List<Nyb> list = nybService.getZyysNy(map);
			JsonUtils.write(list, this.getResponse().getWriter());
		}else{
			//JsonUtils.write(new Object(), null);
		}
	}
	public void getYf() throws Exception{
		List<Nyb> list = nybService.getYf();
		JsonUtils.write(list, this.getResponse().getWriter());
	}
	
	
	@Override
	protected void prepareModel() throws Exception {
		// TODO Auto-generated method stub
		
	}
	@Override
	public Nyb getModel() {
		return nyb;
	}
	
}
