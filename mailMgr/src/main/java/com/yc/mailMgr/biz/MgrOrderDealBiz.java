package com.yc.mailMgr.biz;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.yc.mailMgr.bean.PageBean;
import com.yc.mailMgr.bean.PageData;
import com.yc.mailMgr.bean.Result;
import com.yc.mailMgr.bean.Uorder;
import com.yc.mailMgr.bean.UorderExample;
import com.yc.mailMgr.dao.UorderMapper;

@Service 
@Transactional(rollbackFor=BizException.class)
public class MgrOrderDealBiz {
	
	@Resource
	private UorderMapper uom;
	
	public PageData findOrderBy(Uorder order,int currentPage,int pageSize) {
		if(("".equals(order.getOrderstatu()) && order.getOrderstatu().isEmpty()) || "全部".equals(order.getOrderstatu())) {
			order.setOrderstatu(null);
		}
		if("".equals(order.getOrdertime()) && order.getOrdertime().isEmpty()) {
			order.setOrdertime(null);
		}
		if("".equals(order.getEndtime()) && order.getEndtime().isEmpty()) {
			order.setEndtime(null);
		}
		Page<Uorder>  page = PageHelper.startPage(currentPage, pageSize);
		uom.selectOrderBy(order);
		PageData  pageData = new PageData();
		pageData.setRows(page.getResult());
		pageData.setTotal(page.getTotal());
		return pageData;
	}

	public Uorder dealOrder(Integer orderid) {
		return uom.selectByOrderId(orderid);
	}

	public Result sendOrder(Integer id) throws BizException{
		UorderExample example = new UorderExample();
		example.createCriteria().andIdEqualTo(id);
		List<Uorder> ret = uom.selectByExample(example);
		if("待支付".equals(ret.get(0).getPaystatu())) {
			return Result.failure("该用户尚未支付,无法为用户发货!!!");
		}
		if("待发货".equals(ret.get(0).getOrderstatu())) {
			Uorder order = new Uorder();
			order.setOrderstatu("待收货");
			uom.updateByExampleSelective(order, example);
			return Result.success("订单已发货!!!");
		}else {
			return Result.failure("订单已完成发货,请勿重复操作!!!");
		}
	}
	
}
