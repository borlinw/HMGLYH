package com.hdsx.hmglyh.gis;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.hdsx.hmglyh.rcyh.base.BaseAction;

@Controller
@Scope("request")
public class IndexController extends BaseAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public String index(){		
		return "index";
	}
	
	public String rcyhMap(){
		return "rcyhMap";
	}
	
	public String setTheme(){
		return "setTheme";
	}
	
}
