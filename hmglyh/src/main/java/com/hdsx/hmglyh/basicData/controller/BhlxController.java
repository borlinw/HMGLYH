/**
 * 北京恒达时讯科技有限公司版权所有
 * Copyright (C) HDSX Corporation. All Rights Reserved
 */
package com.hdsx.hmglyh.basicData.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.hdsx.hmglyh.base.BaseActionSupport;
import com.hdsx.hmglyh.basicData.bean.Bhlx;
import com.hdsx.hmglyh.basicData.service.BhlxService;
import com.hdsx.hmglyh.util.Combotree;
import com.hdsx.hmglyh.util.JsonUtils;

/**
 * 
 * @author jason
 *
 */
@Controller
public class BhlxController extends BaseActionSupport<Bhlx> {
	private static final long serialVersionUID = 4500249726059828844L;

	@Resource(name="bhlxServiceImpl")
	private BhlxService bhlxService;
	
	private Bhlx htglbhlx = new Bhlx();
	
	public Bhlx getHtglbhlx() {
		return htglbhlx;
	}


	public void setHtglbhlx(Bhlx htglbhlx) {
		this.htglbhlx = htglbhlx;
	}


	public void getAllBhlx() throws Exception{
		List<Bhlx> list = bhlxService.getAllBhlx();
		JsonUtils.write(list, this.getResponse().getWriter());
	}
	
	public void createBhlxTree(){
		//查询需要创建tree的病害信息
		try {
			List<Bhlx> bhxx=bhlxService.queryDataToCreatetree();
			//将查询出来的数据转换成Combotree数据
			List<Combotree> result = new ArrayList<Combotree>();
			for(Bhlx b:bhxx){
				Combotree combo = bhlxService.dataToComboTree(b);
				result.add(combo);
			}
			JsonUtils.write(result, this.getResponse().getWriter());
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	
	
	@Override
	protected void prepareModel() throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Bhlx getModel() {
		// TODO Auto-generated method stub
		return htglbhlx;
	}
	
}
