package com.drq.service.interfaces;

import java.util.List;

import com.drq.dto.PageBean;
import com.drq.dto.User;

public interface UserInter {

	//用户登录验证
	User userLogin(String userId, String passWord);
    //显示所有用户
	List<User> showUserList(PageBean page,String time,String userSelect);
	//判断用户名是否存在
	Integer compareNameByAdd(String userId);
	//添加用户
	Integer addAdmin(User user);
	
	User toUpDateUser(String id);
	//修改后台用户
	Integer upDateUser(User user);
	//修改前台用户
	Integer upDateCustomer(User user);
	//根据用户ID删除用户
	Integer deleteUserById(Integer[] id);
	//查询总记录数
	Integer getRecordCountByPage(String time,String userSelect);
	//查询用户是否存在
	Integer checkIfUserExit(User user);
	

}
