package com.yc.mailMgr.biz;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.yc.mailMgr.bean.PageData;
import com.yc.mailMgr.bean.Retgoods;
import com.yc.mailMgr.bean.RetgoodsExample;
import com.yc.mailMgr.bean.ReturnExample;
import com.yc.mailMgr.bean.ShopReturnGoods;
import com.yc.mailMgr.bean.Uorder;
import com.yc.mailMgr.dao.RetgoodsMapper;
import com.yc.mailMgr.dao.ShopReturnG;


@Service 

public class MgrShopReturnBiz {

	@Resource
	private  ShopReturnG  sr;
	@Resource
	private  RetgoodsMapper  rg;
	
	public List<ShopReturnGoods> selectBySid(Integer sid) {
		return  sr.selectBySid(sid);
	}

	public PageData selectToDeal(Integer sid,String  startdate , String enddate,String statu,int rows,int page) {
		Page<ShopReturnGoods>  p = PageHelper.startPage(page, rows);
		List<ShopReturnGoods>  list=new ArrayList<ShopReturnGoods>();
		if("所有".equals(statu)) {
			 if(!"".equals(startdate) && !"".equals(enddate) ) {
					list= sr.selectToDeal3(sid, startdate, enddate);
				}else if(!"".equals(startdate) && "".equals(enddate)) {
					Date d=new Date(); 
					SimpleDateFormat   sdf=new SimpleDateFormat("YYYY/M/dd");
					list=	 sr.selectToDeal5(sid,startdate,sdf.format(d));
				}else if("".equals(startdate) && !"".equals(enddate)) {
					list=	  sr.selectToDeal6(sid,enddate);
				}else if("".equals(startdate) && "".equals(enddate)){
					list=	  sr.selectToDeal7(sid);
				}
		}else {
			if(!"".equals(startdate) && !"".equals(enddate) &&!"".equals(statu)) {
				System.out.println("1=======");
				list=	sr.selectToDeal(sid, startdate, enddate, statu);
			}else if("".equals(startdate) && !"".equals(enddate) &&!"".equals(statu)) {
				System.out.println("2======="); 
				list= sr.selectToDeal2(sid, enddate, statu);
			}else if(!"".equals(startdate) && "".equals(enddate) &&!"".equals(statu)) {
				System.out.println("3======="); 
				Date d=new Date();  
				SimpleDateFormat   sdf=new SimpleDateFormat("YYYY/M/dd");
				list=	  sr.selectToDeal1(sid, startdate,sdf.format(d), statu);
			}else if(!"".equals(startdate) && !"".equals(enddate) &&"".equals(statu)) {
				System.out.println("4=======");
				list= sr.selectToDeal3(sid, startdate, enddate);
			}else if("".equals(startdate) && "".equals(enddate) &&!"".equals(statu)) {
				System.out.println("5=======");
				list=	  sr.selectToDeal4(sid,statu);
			}else if(!"".equals(startdate) && "".equals(enddate) &&"".equals(statu)) {
				System.out.println("6======="); 
				Date d=new Date(); 
				SimpleDateFormat   sdf=new SimpleDateFormat("YYYY/M/dd");
				list=	 sr.selectToDeal5(sid,startdate,sdf.format(d));
			}else if("".equals(startdate) && !"".equals(enddate) &&"".equals(statu)) {
				System.out.println("7=======");
				list=	  sr.selectToDeal6(sid,enddate);
			}else if("".equals(startdate) && "".equals(enddate) &&"".equals(statu)){
				System.out.println("8=======");
				list=	  sr.selectToDeal7(sid);
			}
		}
		
		PageData  pag = new PageData();
		pag.setRows(p.getResult());
		pag.setTotal(p.getTotal());
		
		return pag;
		
	}


	public void Save(int rid) {
		RetgoodsExample example=new RetgoodsExample();
		example.createCriteria().andIdEqualTo(rid);
		Retgoods  r=new Retgoods();
		r.setStatu("处理中");
		rg.updateByExampleSelective(r, example);
	}
	
	public void Save1(int rid) {
		RetgoodsExample example=new RetgoodsExample();
		example.createCriteria().andIdEqualTo(rid);
		Retgoods  r=new Retgoods();
		r.setStatu("已完成");
		rg.updateByExampleSelective(r, example);
	}

}
