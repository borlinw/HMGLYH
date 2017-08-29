package com.hdsx.hmglyh.rcyh.controller;

import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.hdsx.hmglyh.login.bean.LoginUser;
import com.hdsx.hmglyh.rcyh.base.BaseAction;
import com.hdsx.hmglyh.rcyh.dao.model.HtglBhlx;
import com.hdsx.hmglyh.rcyh.dao.model.RcyhBhjlb;
import com.hdsx.hmglyh.rcyh.service.BhService;
import com.hdsx.hmglyh.util.JsonUtils;

@Controller
public class CxtjController extends BaseAction{
	/*
	private RcyhBhjlb bhjl = new RcyhBhjlb();
	
	
	
	public RcyhBhjlb getBhjl() {
		return bhjl;
	}
	public void setBhjl(RcyhBhjlb bhjl) {
		this.bhjl = bhjl;
	}
	
	@Autowired
	private BhService bhService;
	
	
	
	*//**
	 * 查询统计首页
	 *//*
	public String index(){ 
		return this.getResultname();
	}
	*//**
	 * 
	 * 病害信息查询
	 *//*
	public String bhxxcx(){ 
		return this.getResultname();
	}
	
	*//**
	 * 病害类型combotree
	 *//*
	public void bhlxCombotree(){
		List<HtglBhlx> bhlxs = bhService.selectBhlxs();
		try {
			JsonUtils.write(bhlxs, ServletActionContext.getResponse().getWriter());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	*//**
	 * 病害信息
	 *//*
	public void bhxx(){
		List<RcyhBhjlb> bhxx = bhService.listBh(bhjl);
		try {
			JsonUtils.write(bhxx, ServletActionContext.getResponse().getWriter());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/
	
}
