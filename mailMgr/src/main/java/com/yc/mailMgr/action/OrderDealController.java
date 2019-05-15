package com.yc.mailMgr.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yc.mailMgr.bean.Uorder;
import com.yc.mailMgr.biz.OrderDealBiz;

@Controller 
public class OrderDealController {
	
	@Resource
	private OrderDealBiz odBiz;
	
	
	@PostMapping("AllOrder")
	@ResponseBody
	public List<Uorder> toOrderMgr(Uorder order,Model model) {
		//model.addAttribute("AllOrderList", odBiz.findOrderBy(order));
		return odBiz.findOrderBy(order);
	}
	
}
