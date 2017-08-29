
 /**
 * 北京恒达时讯科技有限公司版权所有
 * Copyright (C) HDSX Corporation. All Rights Reserved
 */
package com.hdsx.hmglyh.basicData.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.hdsx.hmglyh.base.BaseActionSupport;
import com.hdsx.hmglyh.basicData.service.BbService;
import com.hdsx.hmglyh.jcpd.bean.Bbkzb;
import com.hdsx.hmglyh.util.Combotree;
import com.hdsx.hmglyh.util.JsonUtils;

/**
 * 
 * @author jason
 *
 */
@Controller
@Scope(value="request")
public class BbController extends BaseActionSupport<Bbkzb> {
	private static final long serialVersionUID = -516159422370006442L;

	@Resource(name="bbServiceImpl")
	private BbService bbService;
	
	private Bbkzb bbkzb = new Bbkzb();


	public Bbkzb getBbkzb() {
		return bbkzb;
	}


	public void setBbkzb(Bbkzb bbkzb) {
		this.bbkzb = bbkzb;
	}







	public void getBbCombotree() throws Exception{
		List<Combotree> tree= new ArrayList<Combotree>();
		List<Combotree> list = bbService.getChildren();
		for(Combotree p :list){
			Combotree c = new Combotree();
			c.setId(p.getId());
			c.setText(p.getText());
			tree.add(c);
		}
		
		Combotree comtree = new Combotree();
		comtree.setChildren(tree);
		comtree.setId("");
		comtree.setText("全部");
		List<Combotree> trees= new ArrayList<Combotree>();
		trees.add(comtree);
		JsonUtils.write(trees, this.getResponse().getWriter());
	}







	@Override
	public Bbkzb getModel() {
		return bbkzb;
	}

	@Override
	protected void prepareModel() throws Exception {
		// TODO Auto-generated method stub
		
	}

}
