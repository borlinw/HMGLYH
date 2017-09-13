
 /**
 * 北京恒达时讯科技有限公司版权所有
 * Copyright (C) HDSX Corporation. All Rights Reserved
 */
package com.hdsx.hmglyh.gis.jichusj.luxian.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.hdsx.hmglyh.base.BaseActionSupport;
import com.hdsx.hmglyh.gis.jichusj.luxian.dao.model.Attachment;
import com.hdsx.hmglyh.gis.jichusj.luxian.dao.model.Lishiweixiujl;
import com.hdsx.hmglyh.gis.jichusj.luxian.service.LishiweixiujlService;
import com.hdsx.hmglyh.gis.util.EasyUIPage;
import com.hdsx.hmglyh.util.JsonUtils;
import com.hdsx.hmglyh.util.ResponseUtils;

/**  
 *  
 * @author Baiyy
 * @created 2016年6月19日 下午6:50:18 
 */
@Controller
@Scope(value="request")
public class LishiweixiujlController extends BaseActionSupport<Lishiweixiujl> {
	private static final long serialVersionUID = -722518485395449693L;
	@Resource(name="lishiweixiujlServiceImpl")
	private LishiweixiujlService lswxjlService;
	
	private Lishiweixiujl lswxjl = new Lishiweixiujl();
	
	private String[] name;
	private String[] wz;
	private int[] type;
	
	
	public int[] getType() {
		return type;
	}

	public void setType(int[] type) {
		this.type = type;
	}

	public String[] getName() {
		return name;
	}

	public void setName(String[] name) {
		this.name = name;
	}

	public String[] getWz() {
		return wz;
	}

	public void setWz(String[] wz) {
		this.wz = wz;
	}

	public Lishiweixiujl getLswxjl() {
		return lswxjl;
	}

	public void setLswxjl(Lishiweixiujl lswxjl) {
		this.lswxjl = lswxjl;
	}
	/**
	 * 添加或修改
	 * @throws Exception
	 */
	public void add() throws Exception{
		if(lswxjl.getId()==null || lswxjl.getId().equals("")){
			lswxjl.setId(UUID.randomUUID().toString());
		}
		List<Attachment> attachment = new ArrayList<Attachment>();
		if(name != null){
			for(int i=0;i<name.length;i++){
				Attachment a = new Attachment();
				a.setLswxjlid(lswxjl.getId());
				a.setName(name[i]);
				a.setWz(wz[i]);
				a.setType(type[i]);
				attachment.add(a);
			}
		}
		System.out.println(lswxjl);
		lswxjl.setAttachment(attachment);
		System.out.println(lswxjl);
		
		if(lswxjlService.add(lswxjl))
			ResponseUtils.write(getResponse(), "true");
		else
			ResponseUtils.write(getResponse(), "false");
	}
	/**
	 * 获取维修记录列表
	 * @throws Exception
	 */
	public void getMxb() throws Exception{
//		lswxjl.setWxlx(new String(lswxjl.getWxlx().getBytes("ISO-8859-1"),"UTF-8"));
		List<Lishiweixiujl> list = lswxjlService.getMxb(lswxjl);
		int total = lswxjlService.getMxbCount(lswxjl);
		
		EasyUIPage<Lishiweixiujl> ep = new EasyUIPage<Lishiweixiujl>();
		ep.setRows(list);
		ep.setTotal(total);
		JsonUtils.write(ep, this.getResponse().getWriter());
	}
	/**
	 * 根据id查询维修记录用于修改
	 * @return
	 * @throws Exception
	 */
	public String getMxbById() throws Exception{
		if(lswxjl.getLx().equals("ql"))
			lswxjl.setQlname(new String(lswxjl.getQlname().getBytes("ISO-8859-1"),"UTF-8"));
		if(lswxjl.getId() != null && !lswxjl.getId().equals("")){
			lswxjl = lswxjlService.getMxbById(lswxjl);
		}else{
			lswxjl.setWxlx("日常养护");
		}
		return SUCCESS;
	}
	
	
	@Override
	public Lishiweixiujl getModel() {
		return lswxjl;
	}

	@Override
	protected void prepareModel() throws Exception {
		// TODO Auto-generated method stub
		
	}

}
