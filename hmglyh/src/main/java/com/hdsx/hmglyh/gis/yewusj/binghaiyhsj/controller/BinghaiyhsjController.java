package com.hdsx.hmglyh.gis.yewusj.binghaiyhsj.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.hdsx.hmglyh.rcyh.base.BaseAction;

@Controller
@Scope(value="request")
public class BinghaiyhsjController extends BaseAction{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String index(){
		return "yw_index";
	}
}
