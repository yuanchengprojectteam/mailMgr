package com.yc.mailMgr.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller 
public class IndexController {
	
	@GetMapping("index")
	public String toIndex() {
		return "index";
	}
	
	
	
	@GetMapping("orderMgr")
	public String toOrderMgr() {
		return "orderMgr";
	}
	
}
