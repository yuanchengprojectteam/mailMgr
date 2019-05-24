package com.yc.mailMgr.biz;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yc.mailMgr.bean.Goods;
import com.yc.mailMgr.bean.GoodsExample;
import com.yc.mailMgr.bean.Goodsmsg;
import com.yc.mailMgr.bean.GoodsmsgExample;
import com.yc.mailMgr.bean.Gtype;
import com.yc.mailMgr.bean.GtypeExample;
import com.yc.mailMgr.bean.Image;
import com.yc.mailMgr.bean.ImageExample;
import com.yc.mailMgr.bean.Shop;
import com.yc.mailMgr.bean.ShopExample;
import com.yc.mailMgr.bean.User;
import com.yc.mailMgr.dao.GoodsMapper;
import com.yc.mailMgr.dao.GoodsmsgMapper;
import com.yc.mailMgr.dao.GtypeMapper;
import com.yc.mailMgr.dao.ImageMapper;
import com.yc.mailMgr.dao.ShopMapper;

@Service
public class AboutGoodsMethod {
	
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
	
	@Resource
	QueryNewAdd qna;

	public int byTnameQueryTid(String typeName) {
		// TODO Auto-generated method stub
		GtypeExample ge = new GtypeExample();
		ge.createCriteria().andNameEqualTo(typeName);
		return tm.selectByExample(ge).get(0).getId();
	}

	public int insertGoods(Goods good) {
		// TODO Auto-generated method stub
		String regtime = qna.formatTime();
		good.setRegtime(regtime);
		int i = gm.insert(good);
		Goodsmsg msg = new Goodsmsg();
		Goods goods = qna.queryNewGoods();
		msg.setColor(goods.getColor());
		msg.setGid(goods.getId());
		msg.setSid(goods.getSid());
		msg.setSize(goods.getSize());
		msg.setTid(goods.getTid());
		gmsgM.insert(msg);
		
		Image image = new Image();
		msg = qna.queryNewGoodsmsg();
		image.setGid(msg.getId());
		image.setPath(good.getMsgImage());
		im.insert(image);
		return i;
	}

	public Shop byUidQueryShop(int uid) {
		// TODO Auto-generated method stub
		ShopExample se = new ShopExample();
		se.createCriteria().andUidEqualTo(uid);
		return sm.selectByExample(se).get(0);
	}

	public Shop queryShop(User user) {
		// TODO Auto-generated method stub
		ShopExample se = new ShopExample();
		se.createCriteria().andUidEqualTo(user.getId());
		List<Shop> list = sm.selectByExample(se);
		return list.get(0);
	}

	public void delectGoods(int id) {
		// TODO Auto-generated method stub
		
		GoodsmsgExample ge = new GoodsmsgExample();
		ge.createCriteria().andGidEqualTo(id);
		List<Goodsmsg> list = gmsgM.selectByExample(ge);
		gm.deleteByPrimaryKey(id);
		gmsgM.deleteByExample(ge);
		for(Goodsmsg g : list) {
			ImageExample ie = new ImageExample();
			ie.createCriteria().andGidEqualTo(g.getId());
			im.deleteByExample(ie);
		}
		
	}

	public void updateGoods(Goods good) {
		// TODO Auto-generated method stub
		GoodsExample ge = new GoodsExample();
		ge.createCriteria().andIdEqualTo(good.getId());
		gm.updateByExampleSelective(good, ge);
		
	}

	public List<Gtype> queryAllGtype() {
		// TODO Auto-generated method stub
		List<Gtype> list = tm.selectByExample(null);
		
		for(Gtype g : list) {
			if(g.getPid() != null) {
				Gtype type = tm.selectByPrimaryKey(g.getPid());
				g.setPname(type.getName());
			}
			if(g.getSunid() != null) {
				Gtype type = tm.selectByPrimaryKey(g.getSunid());
				g.setSunname(type.getName());
			}
		}
		return list;
		
	}

	public Integer querySunid(int pid) {
		// TODO Auto-generated method stub
		Gtype gt = tm.selectByPrimaryKey(pid);
		Integer sunid = null;
		if(gt.getPid() != null) {
			sunid = gt.getPid();
		}
		return sunid;
	}


	public void insertGtype(Gtype gtype) {
		// TODO Auto-generated method stub
		tm.insert(gtype);
	}

	public void delectType(int id) {
		// TODO Auto-generated method stub
		tm.deleteByPrimaryKey(id);
		
	}

	public void updateType(Gtype gtype) {
		// TODO Auto-generated method stub
		GtypeExample ge = new GtypeExample();
		ge.createCriteria().andIdEqualTo(gtype.getId());
		tm.updateByExampleSelective(gtype, ge);
		
	}
	
	

	
}
