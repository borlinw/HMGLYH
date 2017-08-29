
 /**
 * 北京恒达时讯科技有限公司版权所有
 * Copyright (C) HDSX Corporation. All Rights Reserved
 */
package com.hdsx.hmglyh.basicData.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.hdsx.hmglyh.base.BaseActionSupport;
import com.hdsx.hmglyh.util.Combobox;
import com.hdsx.hmglyh.util.JsonUtils;

/**  
 *  
 * @author Baiyy
 * @created 2016年4月28日 下午3:37:58 
 */
@Controller
@Scope(value="request")
public class YearController extends BaseActionSupport<Combobox> {
	private static final long serialVersionUID = 2163020031978238944L;
	
	public void getYearCombo() throws Exception{
		Date current_date = new Date();
		List<Combobox> list = new ArrayList<Combobox>();
		for(int i=(current_date.getYear()+1900);i>=2011;i--){
			Combobox combo = new Combobox();
			combo.setId(i+"");
			combo.setText(i+"年");
			list.add(combo);
		}
		JsonUtils.write(list, this.getResponse().getWriter());
	}

	@Override
	protected void prepareModel() throws Exception {
		// TODO Auto-generated method stub
		
	}

}
