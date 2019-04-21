package com.drq.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.drq.dto.PageBean;
import com.drq.dto.User;

public interface UserMapper {

	//用户登录
	User userLogin(@Param("userId") String userId, @Param("passWord") String passWord);

	//显示用户
	List<User> showUserList(@Param("page") PageBean page,@Param("time") String time,@Param("userSelect") String userSelect);

	//判断用户名是否存在
	Integer compareNameByAdd(String userId);

	//添加用户
	Integer addAdmin(User user);

	
	User toUpDateUser(String id);

	//修改管理用户
	Integer upDateUser(User user);

	//修改用户
	Integer upDateCustomer(User user);
	
	//根据id删除用户
	Integer deleteUserById(Integer[] id);

	//查询总记录数
	Integer getRecordCountByPage(@Param("time") String time,@Param("userSelect") String userSelect);
    //查询用户是否存在
	Integer checkIfUserExit(User user);
}
