package com.yc.mailMgr.biz;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yc.mailMgr.bean.Uorder;
import com.yc.mailMgr.dao.UorderMapper;

@Service 
public class OrderDealBiz {
	
	@Resource
	private UorderMapper uom;
	
	public List<Uorder> findOrderBy(Uorder order) {
		return uom.selectOrderBy(order);
	}
	
}
