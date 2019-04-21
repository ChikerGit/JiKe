package com.drq.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.drq.dao.BaseDao;
import com.drq.dao.inter.PicetureDaoInter;
import com.drq.dto.PageBean;
import com.drq.dto.Picturcarousel;
import com.drq.mapper.PicetureMapper;

public class PicetureDaoImpl extends BaseDao implements PicetureDaoInter{

	@Override
	public List<Picturcarousel> showPicetureList(PageBean page,String userSelect) {
		SqlSession sqlSession=getSqlSession();
		PicetureMapper piceMapper=sqlSession.getMapper(PicetureMapper.class);
		List<Picturcarousel> piceList=piceMapper.showPicetureList(page,userSelect);
		closeSqlSession();
		return piceList;
	}

	@Override
	public Integer getRecordCount(String userSelect) {
		SqlSession sqlSession=getSqlSession();
		PicetureMapper piceMapper=sqlSession.getMapper(PicetureMapper.class);
		Integer count=piceMapper.getRecordCount(userSelect);
		closeSqlSession();
		return count;
	}

	@Override
	public Integer addPiceRoute(Picturcarousel pic) {
		SqlSession sqlSession=getSqlSession();
		PicetureMapper picMapper=sqlSession.getMapper(PicetureMapper.class);
		Integer count=picMapper.addPiceRoute(pic);
		sqlSession.commit();
		closeSqlSession();
		return count;
	}

	@Override
	public Picturcarousel getPicByid(String id) {
		SqlSession sqlSession=getSqlSession();
		PicetureMapper picMapper=sqlSession.getMapper(PicetureMapper.class);
		Picturcarousel pic=picMapper.getPicByid(id);
		closeSqlSession();
		return pic;
	}

	@Override
	public Integer upDatePiceRoute(Picturcarousel pic) {
		SqlSession sqlSession=getSqlSession();
		PicetureMapper picMapper=sqlSession.getMapper(PicetureMapper.class);
		Integer count=picMapper.upDatePiceRoute(pic);
		sqlSession.commit();
		closeSqlSession();
		return count;
	}

	@Override
	public Integer deletePic(Integer[] ids) {
		SqlSession sqlSession=getSqlSession();
		PicetureMapper picMapper=sqlSession.getMapper(PicetureMapper.class);
		Integer count=picMapper.deletePic(ids);
		sqlSession.commit();
		closeSqlSession();
		return count;
	}

}
