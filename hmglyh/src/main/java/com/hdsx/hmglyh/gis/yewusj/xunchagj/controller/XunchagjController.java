package com.hdsx.hmglyh.gis.yewusj.xunchagj.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller
@Scope(value="prototype")
public class XunchagjController {
	public String index(){
		return "yw_index";
	}
}
