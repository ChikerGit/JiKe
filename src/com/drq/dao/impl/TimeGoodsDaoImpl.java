package com.drq.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.drq.dao.BaseDao;
import com.drq.dao.inter.TimeGoodsDaoInter;
import com.drq.dto.PageBean;
import com.drq.dto.Timlimited;
import com.drq.mapper.TimeGoodsMapper;

public class TimeGoodsDaoImpl extends BaseDao implements TimeGoodsDaoInter{

	@Override
	public Integer getRecordCount(String time,String userSelect) {
		SqlSession sqlSession=getSqlSession();
		TimeGoodsMapper timeMapper=sqlSession.getMapper(TimeGoodsMapper.class);
		Integer count=timeMapper.getRecordCount(time,userSelect);
		closeSqlSession();
		return count;
	}

	@Override
	public List<Timlimited> showTimeList(PageBean page,String time,String userSelect) {
		SqlSession sqlSession=getSqlSession();
		TimeGoodsMapper timeMapper=sqlSession.getMapper(TimeGoodsMapper.class);
		List<Timlimited> timeList=timeMapper.showTimeList(page,time,userSelect);
		closeSqlSession();
		return timeList;
	}

	@Override
	public Integer addTimeGoods(Timlimited time) {
		SqlSession sqlSession=getSqlSession();
		TimeGoodsMapper timeMapper=sqlSession.getMapper(TimeGoodsMapper.class);
		Integer count=timeMapper.addTimeGoods(time);
		sqlSession.commit();
		closeSqlSession();
		return count;
	}

	@Override
	public Timlimited getTimeGoodsById(Integer id) {
		SqlSession sqlSession=getSqlSession();
		TimeGoodsMapper timeMapper=sqlSession.getMapper(TimeGoodsMapper.class);
		Timlimited time=timeMapper.getTimeGoodsById(id);
		closeSqlSession();
		return time;
	}

	@Override
	public Integer upDateTimeGoods(Timlimited time) {
		SqlSession sqlSession=getSqlSession();
		TimeGoodsMapper timeMapper=sqlSession.getMapper(TimeGoodsMapper.class);
		Integer count=timeMapper.upDateTimeGoods(time);
		sqlSession.commit();
		closeSqlSession();
		return count;
	}

	@Override
	public Integer deleteTimeGoods(Integer[] ids) {
		SqlSession sqlSession=getSqlSession();
		TimeGoodsMapper time=sqlSession.getMapper(TimeGoodsMapper.class);
		Integer count=time.deleteTimeGoods(ids);
		sqlSession.commit();
		closeSqlSession();
		return count;
	}

}
