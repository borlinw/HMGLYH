package com.hdsx.hmglyh.gis.debug;

import org.springframework.stereotype.Controller;

@Controller
public class DebugController {
	
	public String console(){
		return "de_console";
	}
	
	public String map(){
		return "de_map";
	}
	
	public String ui(){
		return "de_ui";
	}
}
