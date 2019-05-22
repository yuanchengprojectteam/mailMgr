package com.yc.mailMgr.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.yc.mailMgr.bean.Goods;
import com.yc.mailMgr.bean.GoodsExample;
import com.yc.mailMgr.bean.GoodsExample.Criteria;
import com.yc.mailMgr.bean.Gtype;
import com.yc.mailMgr.bean.GtypeExample;
import com.yc.mailMgr.bean.GtypeSelect;
import com.yc.mailMgr.bean.PageData;
import com.yc.mailMgr.bean.Shop;
import com.yc.mailMgr.bean.User;
import com.yc.mailMgr.bean.successMsg;
import com.yc.mailMgr.biz.AboutGoodsMethod;
import com.yc.mailMgr.dao.GoodsMapper;
import com.yc.mailMgr.dao.GtypeMapper;
import com.yc.mailMgr.util.OssUtil;

@Controller
@Transactional
public class AboutGoodsController {
	
	@Resource
	GoodsMapper gm;
	
	@Resource
	GtypeMapper gtym;
	
	@Resource
	AboutGoodsMethod agm;

	@Autowired
	OssUtil ou;

	@RequestMapping("addGoods")
	public String addGoods() {
		
		return "addGoods";
	}
	
	
	@RequestMapping("query")
	@ResponseBody
	public PageData query(@SessionAttribute("loginedAdmin") User user,Goods goods,int page,int rows){
		GoodsExample ge = new GoodsExample();
		PageData pag = new PageData();
		Shop shop = agm.byUidQueryShop(user.getId());
		Criteria c = ge.createCriteria();
		c.andSidEqualTo(shop.getId());
		
		if(goods.getName() != null && goods.getName().trim().isEmpty() == false) {
			c.andNameLike("%"+goods.getName().trim()+"%");
		}
		if(goods.getPrice() != null) {
			c.andPriceEqualTo(goods.getPrice());
		}
		//System.out.println(goods.getTypeName()+"================");
		if(goods.getTypeName() != null && goods.getTypeName().trim().isEmpty() == false 
				&& "0".equals(goods.getTypeName()) == false){
			int tid = Integer.parseInt(goods.getTypeName());
			c.andTidEqualTo(tid);
		}
		Page<Goods> p = PageHelper.startPage(page,rows,true);
		gm.selectByExample(ge);
	
		System.out.println("======"+p.size());
		pag.setRows(p.getResult());
		pag.setTotal(p.getTotal());
		return pag;
		
	}
	
	//getdata
	
	@RequestMapping("getdata")
	@ResponseBody
	public List<GtypeSelect> getdata(){
		List<Gtype> list = gtym.selectByExample(null);
		List<GtypeSelect> set = new ArrayList<GtypeSelect>();
		GtypeSelect one = new GtypeSelect();
		one.setId("0");
		one.setText("请选择--类型");
		one.setSelected(true);
		set.add(one);
		GtypeSelect gs ;
		for(int i=0;i<list.size();i++) {
			gs = new GtypeSelect();
			gs.setId(""+list.get(i).getId());
			gs.setText(list.get(i).getName());
			set.add(gs);
		}
		
		
		return set;
		
	}
	
	@RequestMapping("save")
	@ResponseBody
	public successMsg save(@SessionAttribute("loginedAdmin")User user,Goods good) {
		successMsg msg = new successMsg();
		Shop shop = agm.queryShop(user);
		good.setSid(shop.getId());
		int count = agm.insertGoods(good);
		msg.setStatu(count);
		msg.setMsg("添加成功！");
		return msg;
	}
	
	//delectGood
	
	@RequestMapping("delectGood")
	@ResponseBody
	public successMsg delectGood(String gid) {
		successMsg msg = new successMsg();
		int id = Integer.parseInt(gid);
		agm.delectGoods(id);
		msg.setMsg("删除成功！");
		return msg;
	}
	
	//updateGoods
	
	@RequestMapping("updateGoods")
	@ResponseBody
	public successMsg updateGoods(Goods good) {
		successMsg msg = new successMsg();
		System.out.println("=========================="+good.getImage());
		good.setImage(null);
		agm.updateGoods(good);
		
		msg.setMsg("修改成功！");
		return msg;
	}
	
	/*
	 * 类别管理
	 * 
	 * */
	
	@RequestMapping("addGoodsType")
	public String addGoodsType() {
		return "addGoodsType";
	}
	
	@RequestMapping("queryGtype")
	@ResponseBody
	public PageData queryGtype( int page , int rows) {
		PageData pd = new PageData();
		Page<Gtype> pag = PageHelper.startPage(page,rows,true);
		agm.queryAllGtype();
		pd.setRows(pag);
		pd.setTotal(pag.getTotal());
		return pd;
	}
	
	//saveType
	
	@RequestMapping("saveType")
	@ResponseBody
	public successMsg saveType(String newName,int pid) {
		//System.out.println(newName+":"+pid);
		successMsg msg = new successMsg();
		Gtype gtype = new Gtype();
		Integer sunid = agm.querySunid(pid);
		//System.out.println("============="+sunid);
		gtype.setName(newName);
		gtype.setPid(pid);
		gtype.setSunid(sunid);
		agm.insertGtype(gtype);
		
		return msg;
	}
	
	//deleteType
	@RequestMapping("deleteType")
	@ResponseBody
	public successMsg deleteType(int id) {
		successMsg msg = new successMsg();
		agm.delectType(id);
		msg.setMsg("删除成功！");
		return msg;
	}
	
	//updateType
	@RequestMapping("updateType")
	@ResponseBody
	public successMsg updateType(Gtype gtype) {
		successMsg msg = new successMsg();
		agm.updateType(gtype);
		msg.setMsg("修改成功！");
		return msg;
	}
	
}
