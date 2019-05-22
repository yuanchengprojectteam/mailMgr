package com.yc.mailMgr.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.annotation.JsonCreator.Mode;
import com.fasterxml.jackson.databind.deser.std.DateDeserializers.DateDeserializer;
import com.yc.mailMgr.bean.PageData;
import com.yc.mailMgr.bean.ShopReturnGoods;
import com.yc.mailMgr.biz.MgrShopReturnBiz;

@Controller
public class MgrIndexController {
	
	@Resource
	private  MgrShopReturnBiz  srBiz;
	
	@GetMapping("index")
	public String toIndex() {
		return "index";
	}
	
	
	
	@GetMapping("orderMgr")
	public String toOrderMgr() {
		return "orderMgr";
	}
	
	@GetMapping("WaitDeal")
	public String toWaitDeal(int  sid,Model model) {
		List<ShopReturnGoods> list=srBiz.selectBySid(sid);
		model.addAttribute("ShopReturnGoods", list);
		return "WaitDeal";
	}
	
	@PostMapping("query")
	@ResponseBody
	public  PageData  query(int sid,@RequestParam(defaultValue="",name="startdate")String startdate,@RequestParam(defaultValue="",name="enddate")String enddate,@RequestParam(defaultValue="待处理",name="statu")String  statu,int rows,int page ){
		return 	srBiz.selectToDeal(sid, startdate, enddate,statu,rows,page);
	}
	
	@PostMapping("query1")
	@ResponseBody
	public  PageData  query1(int sid,@RequestParam(defaultValue="",name="startdate")String startdate,@RequestParam(defaultValue="",name="enddate")String enddate,@RequestParam(defaultValue="已完成",name="statu")String  statu,int rows,int page ){
		return 	srBiz.selectToDeal(sid, startdate, enddate,statu,rows,page);
	}
	
	@PostMapping(path="deal",produces="text/html;charset=utf-8")
	public String  Deal(int rid) {
		System.out.println("rid="+rid);
		srBiz.Save(rid);
		return "售后成功";
	}
	
	@PostMapping(path="deal1",produces="text/html;charset=utf-8")
	public String  Deal1(int rid) {
		System.out.println("rid="+rid);
		srBiz.Save1(rid);
		return "确认成功";
	}
	
	@GetMapping("AllReturn")
	public String toAllReturn(int sid,Model  model) {
		List<ShopReturnGoods> list=srBiz.selectBySid(sid);
		model.addAttribute("ShopReturnGoods", list);
		return "AllReturn";
	}
}
