package com.yc.mailMgr.biz;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yc.mailMgr.bean.Goods;
import com.yc.mailMgr.bean.Goodsmsg;
import com.yc.mailMgr.dao.GoodsMapper;
import com.yc.mailMgr.dao.GoodsmsgMapper;
import com.yc.mailMgr.dao.GtypeMapper;
import com.yc.mailMgr.dao.ImageMapper;
import com.yc.mailMgr.dao.ShopMapper;

@Service
public class QueryNewAdd {
	
	@Resource
	GtypeMapper tm;
	
	@Resource
	 GoodsMapper gm;
	
	@Resource
	ShopMapper sm;
	
	@Resource
	GoodsmsgMapper gmsgM;
	
	@Resource
	ImageMapper im;

	public  Goods queryNewGoods() {
		
		List<Goods> list = gm.selectByExample(null);
		return list.get(list.size()-1);
	}
	
	public  Goodsmsg queryNewGoodsmsg() {
	
		List<Goodsmsg> list = gmsgM.selectByExample(null);
		return list.get(list.size()-1);
	}
	
	public String formatTime() {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		
		return df.format(System.currentTimeMillis());
	}
}
