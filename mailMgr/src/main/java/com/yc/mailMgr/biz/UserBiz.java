package com.yc.mailMgr.biz;

import java.util.List;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.yc.mailMgr.bean.User;
import com.yc.mailMgr.bean.UserExample;
import com.yc.mailMgr.dao.UserMapper;

@Service 
@Transactional(rollbackFor=BizException.class)
public class UserBiz {

	@Resource
	private  UserMapper   uMapper;

	public User login( User u) throws BizException {
		UserExample  example=new UserExample();
		if(u.getAccount()==null || "".equals(u.getAccount())) {
			throw  new  BizException("用户名不能为空");
		}
		if(u.getPwd()==null || "".equals(u.getPwd())) {
			throw  new  BizException("密码不能为空！");
		}
		example.createCriteria()
					.andAccountEqualTo(u.getAccount())
					.andPwdEqualTo(u.getPwd())
					.andTypeEqualTo("管理员");
		List<User>  list=uMapper.selectByExample(example);
		if(list.size()<1) {
			throw  new  BizException("用户名或密码错误！");
		}
		return   list.get(0);
	}
	
	
}
