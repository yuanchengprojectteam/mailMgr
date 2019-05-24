package com.yc.mailMgr.action;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.yc.mailMgr.bean.PageData;
import com.yc.mailMgr.bean.Shop;
import com.yc.mailMgr.bean.ShopExample;
import com.yc.mailMgr.bean.ShopReturnGoods;
import com.yc.mailMgr.bean.User;
import com.yc.mailMgr.biz.BizException;
import com.yc.mailMgr.biz.ShopReturnBiz;
import com.yc.mailMgr.biz.UserBiz;
import com.yc.mailMgr.dao.ShopMapper;

@Controller 
@SessionAttributes(names= {"loginedAdmin"})

public class MgrIndexController {
	
	@Resource
	private  ShopReturnBiz  srBiz;
	@Resource
	private  UserBiz  uBiz;
	@Resource
	private  ShopMapper  sMapper;
	
	@GetMapping("login")
	public  String  toLogin() {
		return  "login";
	}
	
	@ModelAttribute
	public void Init(Model model) {
		User user=new User();
		model.addAttribute("user", user);
	}
	
	@PostMapping("tologin")
	public String  Login(@ModelAttribute @Valid User u, Errors errors, Model model, String check,
			HttpServletRequest request, HttpServletResponse response) {
		System.out.println("====================");
		Cookie cookie1 = new Cookie("name", u.getAccount());
		Cookie cookie2 = new Cookie("pwd", u.getPwd());
		if ("on".equals(check)) {

			cookie1.setMaxAge(60 * 60 * 24 * 7);
			cookie2.setMaxAge(60 * 60 * 24 * 7);
			response.addCookie(cookie1);
			response.addCookie(cookie2);

		} else {
			cookie1.setMaxAge(0);
			cookie2.setMaxAge(0);
			response.addCookie(cookie1);
			response.addCookie(cookie2);
		}
		if (errors.hasErrors()) {
			return "login";
		}
		
		try {
			System.out.println("============================"+u);
			User  user=uBiz.login(u);
			System.out.println("+======================================"+user);
			ShopExample  example=new ShopExample();
			example.createCriteria().andUidEqualTo(user.getId());
			List<Shop> shop=sMapper.selectByExample(example);
			model.addAttribute("loginedAdmin", user);
			model.addAttribute("shop", shop.get(0));
			return "index";
		} catch (BizException e) {
			e.printStackTrace();
			model.addAttribute("msg", e.getMessage());
			return "login";
		}
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
