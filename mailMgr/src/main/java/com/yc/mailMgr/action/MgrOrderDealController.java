package com.yc.mailMgr.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yc.mailMgr.bean.PageData;
import com.yc.mailMgr.bean.Result;
import com.yc.mailMgr.bean.Uorder;
import com.yc.mailMgr.biz.BizException;
import com.yc.mailMgr.biz.MgrOrderDealBiz;

@Controller
public class MgrOrderDealController {
	
	@Resource
	private MgrOrderDealBiz odBiz;
	
	
	@PostMapping("AllOrder")
	@ResponseBody
	public PageData toOrderMgr(Uorder order,Model model,Integer page,Integer rows) {
		//model.addAttribute("AllOrderList", odBiz.findOrderBy(order));
		return odBiz.findOrderBy(order,page,rows);
	}
	
	@PostMapping("dealOrder")
	@ResponseBody
	public Uorder dealOrder(Integer id) {
		return odBiz.dealOrder(id);
	}
	
	@PostMapping("sendOrder")
	@ResponseBody
	public Result sendOrder(Integer id) {
		try {
			return odBiz.sendOrder(id);
		} catch (BizException e) {
			e.printStackTrace();
			return Result.failure(e.getMessage());
		}
	}
	@PostMapping("doSearch")
	@ResponseBody
	public PageData doSearch(Uorder order,Integer page,Integer rows) {
		return odBiz.findOrderBy(order,page,rows);
	}
	
}
