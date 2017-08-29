
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
import com.hdsx.hmglyh.basicData.service.BmService;
import com.hdsx.hmglyh.htgl.bean.HtglBm;
import com.hdsx.hmglyh.util.Combobox;
import com.hdsx.hmglyh.util.Combotree;
import com.hdsx.hmglyh.util.JsonUtils;

/**  
 *  
 * @author Baiyy
 * @created 2015年7月20日 上午11:28:39 
 */
@Controller
@Scope(value="request")
public class BmController extends BaseActionSupport<HtglBm> {
	private static final long serialVersionUID = 851470201968627998L;
	
	@Resource(name="bmServiceImpl")
	private BmService bmService;
	
	private HtglBm htglBm = new HtglBm();

	public HtglBm getHtglBm() {
		return htglBm;
	}

	public void setHtglBm(HtglBm htglBm) {
		this.htglBm = htglBm;
	}


	public void getBmCombotree() throws Exception{
		List<Combotree> list = new ArrayList<Combotree>();
		list.add(bmService.getBmCombo(htglBm));
		JsonUtils.write(list, this.getResponse().getWriter());
	}

	public void getBmForXd() throws Exception{
		List<Combobox> list = bmService.getBmForXd(htglBm.getBmcode());
		JsonUtils.write(list, this.getResponse().getWriter());
	}





	@Override
	public HtglBm getModel() {
		return htglBm;
	}

	@Override
	protected void prepareModel() throws Exception {
		// TODO Auto-generated method stub
		
	}

}
