package com.drq.service.impl;

import java.util.Date;
import java.util.List;

import com.drq.dao.impl.UserDaoImpl;
import com.drq.dao.inter.UserDaoInter;
import com.drq.dto.PageBean;
import com.drq.dto.User;
import com.drq.service.interfaces.UserInter;

public class UserImpl implements UserInter{
    
	UserDaoInter u=new UserDaoImpl();
	@Override
	public Integer checkIfUserExit(User user) {
		// TODO Auto-generated method stub
		return u.checkIfUserExit(user);
	}

	
	//用户登录验证
	@Override
	public User userLogin(String userId, String passWord) {
		
		return u.userLogin(userId,passWord);
	}

	//显示所有用户
	@Override
	public List<User> showUserList(PageBean page,String time,String userSelect) {
		return u.showUserList(page,time,userSelect);
	}

	//判断用户名是否存在
	@Override
	public Integer compareNameByAdd(String userId) {
		return u.compareNameByAdd(userId);
	}

	//添加用户
	@Override
	public Integer addAdmin(User user) {
		/*user.setPassWord("123456");*/
		user.setCreateDate(new Date());
		return u.addAdmin(user);
	}

	
	@Override
	public User toUpDateUser(String id) {
		User user=u.toUpDateUser(id);
		return user;
	}

	//修改管理员
	@Override
	public Integer upDateUser(User user) {
		Integer count=u.upDateUser(user);
		return count;
	}
 

	//修改普通用户
		@Override
		public Integer upDateCustomer(User user) {
			Integer count=u.upDateCustomer(user);
			return count;
		}
	 
	//根据用户ID删除用户
	@Override
	public Integer deleteUserById(Integer[] id) {
		return u.deleteUserById(id);
	}

	@Override
	public Integer getRecordCountByPage(String time,String userSelect) {
		
		return u.getRecordCountByPage(time,userSelect);
	}

}
