package com.yc.mailMgr;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.yc.mailMgr.bean.Uorder;
import com.yc.mailMgr.biz.MgrOrderDealBiz;
import com.yc.mailMgr.dao.UorderMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MailMgrApplicationTests {

	
	@Resource
	private UorderMapper uom;
	
	@Resource
	private MgrOrderDealBiz odBiz;
	@Test
	public void contextLoads() {
		Uorder uorder = new Uorder();
		System.out.println(odBiz.findOrderBy(uorder,1,10).getRows().get(0));
	}

}
