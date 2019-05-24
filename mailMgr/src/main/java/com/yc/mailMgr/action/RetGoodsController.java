package com.yc.mailMgr.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller 
public class RetGoodsController {
	
	@RequestMapping("WaitDeal")
	public String waitDeal() {
		return "WaitDeal";
	}
	
	@RequestMapping("AllReturn")
	public String allReturn() {
		return "AllReturn";
	}
	
}
