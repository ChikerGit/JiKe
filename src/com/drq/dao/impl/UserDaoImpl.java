package com.drq.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.drq.dao.BaseDao;
import com.drq.dao.inter.UserDaoInter;
import com.drq.dto.PageBean;
import com.drq.dto.User;
import com.drq.mapper.UserMapper;

public class UserDaoImpl extends BaseDao implements UserDaoInter{

	@Override
	public User userLogin(String userId, String passWord) {
		//获取sqlsession
		SqlSession sqlsession=getSqlSession();
		//接口映射
		UserMapper userMapper=sqlsession.getMapper(UserMapper.class);
		//调用接口方法
		User user=userMapper.userLogin(userId,passWord);
		//关闭资源
		closeSqlSession();
		return user;
	}

	//显示所有用户
	@Override
	public List<User> showUserList(PageBean page,String time,String userSelect) {
		SqlSession sqlSession=getSqlSession();
		UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
		List<User> userList=userMapper.showUserList(page,time,userSelect);
		closeSqlSession();
		return userList;
	}

	@Override
	public Integer compareNameByAdd(String userId) {
		SqlSession sqlSession=getSqlSession();
		UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
		int count=userMapper.compareNameByAdd(userId);
		closeSqlSession();
		return count;
	}

	//添加用户
	@Override
	public Integer addAdmin(User user) {
		SqlSession sqlSession=getSqlSession();
		UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
		Integer count=userMapper.addAdmin(user);
		sqlSession.commit();
		closeSqlSession();
		return count;
	}

	
	@Override
	public Integer checkIfUserExit(User user) {
		SqlSession sqlSession=getSqlSession();
		UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
		Integer sum=userMapper.checkIfUserExit(user);
		closeSqlSession();
		return sum;
	}

	@Override
	public User toUpDateUser(String id) {
		SqlSession sqlSession=getSqlSession();
		UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
		User user=userMapper.toUpDateUser(id);
		closeSqlSession();
		return user;
	}

	//修改管理用户
	@Override
	public Integer upDateUser(User user) {
		SqlSession sqlSession=getSqlSession();
		UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
		Integer count=userMapper.upDateUser(user);
		sqlSession.commit();
		closeSqlSession();
		return count;
	}
	
	//修改普通用户
	@Override
	public Integer upDateCustomer(User user) {
		SqlSession sqlSession=getSqlSession();
		UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
		Integer count=userMapper.upDateCustomer(user);
		sqlSession.commit();
		closeSqlSession();
		return count;
	}

	//根据id删除用户
	@Override
	public Integer deleteUserById(Integer[] id) {
        SqlSession sqlSession=getSqlSession();
        UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
        Integer count=userMapper.deleteUserById(id);
        sqlSession.commit();
		closeSqlSession();
		return count;
	}

	@Override
	public Integer getRecordCountByPage(String time,String userSelect) {
		SqlSession sqlSession=getSqlSession();
		UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
		Integer recordCount=userMapper.getRecordCountByPage(time,userSelect);
		closeSqlSession();
		return recordCount;
	}

}
