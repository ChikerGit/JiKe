package com.drq.dao;

import java.io.InputStream;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/***
 * 数据库的连接与关闭
 *
 */
public class BaseDao {

	//通过ThreadLocal线程来管理SqlSession保证1个线程只有1个SqlSession
	private static ThreadLocal<SqlSession> threadLocal=new ThreadLocal<SqlSession>();
	private static SqlSessionFactory sessionFactory=null;
	
	static{
		InputStream is=BaseDao.class.getResourceAsStream("/mybatis-config.xml");
		sessionFactory=new SqlSessionFactoryBuilder().build(is);
	}
	
	//获取sqlsession
	public static SqlSession getSqlSession(){
		SqlSession sqlSession=threadLocal.get();
		if(sqlSession==null){
			sqlSession=sessionFactory.openSession();
		}
		//把sqlsession存回到threadLocal
		threadLocal.set(sqlSession);
		return sqlSession;
	}
	
	//关闭sqlSession
	public static void closeSqlSession(){
		SqlSession sqlSession=threadLocal.get();
		if(sqlSession!=null){
			sqlSession.close();
		}
		threadLocal.remove();
	}
}
