package com.hdsx.hmglyh.gis.yewusj.lukuangpd.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.hdsx.hmglyh.rcyh.base.BaseAction;

@Controller
@Scope(value="request")
public class LukuangpdController extends BaseAction{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String lkpd(){
		System.out.println("hello action");
		return "yw_lkpd";
	}
}
