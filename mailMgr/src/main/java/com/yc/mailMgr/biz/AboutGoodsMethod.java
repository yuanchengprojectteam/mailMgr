package com.yc.mailMgr.biz;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSSException;
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
import com.yc.mailMgr.util.OssUtil;

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
	
	@Autowired
	OssUtil oss;

	public int byTnameQueryTid(String typeName) {
		// TODO Auto-generated method stub
		GtypeExample ge = new GtypeExample();
		ge.createCriteria().andNameEqualTo(typeName);
		return tm.selectByExample(ge).get(0).getId();
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

	public int insertGoods(Goods good, MultipartFile file, MultipartFile file1) throws OSSException, ClientException, IOException {
		// TODO Auto-generated method stub
		
			String s = oss.upload(file, 2);
			good.setImage(s);
			gm.insert(good);
			
			/*GoodsExample ge1 = new GoodsExample();
			String name1 = good.getName();
			int sid1 = good.getSid();
			ge1.createCriteria().andNameEqualTo(name1).andSidEqualTo(sid1);
			List<Goods> list1 = gm.selectByExample(ge1);
			Goodsmsg msg1 = new Goodsmsg();
			msg1.setColor(good.getColor());
			msg1.setGid(list1.get(0).getId());
			msg1.setSid(sid);
			msg1.setTid(list1.get(0).getTid());
			msg1.setSize(good.getSize());
			gmsgM.insert(msg1);*/
	
		return 0;
	}


	public void addImage(Goods good, MultipartFile file) throws OSSException, ClientException, IOException {
		// TODO Auto-generated method stub
		String s = oss.upload(file, 2);
		Image image = new Image();
		image.setGid(good.getId());
		image.setPath(s);
		im.insert(image);
		
	}


	public boolean queryMany(String name) {
		// TODO Auto-generated method stub
		boolean flag = false;
		GtypeExample ge = new GtypeExample();
		ge.createCriteria().andNameEqualTo(name);
		List<Gtype> list = tm.selectByExample(ge);
		if(list.size()>0) {
			flag = true;
		}
		return flag;
	}


	/*public void upFile(MultipartFile file, MultipartFile file1, String name, User user) throws OSSException, ClientException, IOException {
		// TODO Auto-generated method stub
		
		String s = oss.upload(file1, 2);
		String s1 = oss.upload(file, 2);
		
		GoodsExample ge = new GoodsExample();
		
		//System.out.println("====================="+s+":"+s1);
		
	}*/
	
	

	
}
