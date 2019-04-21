package com.drq.dao.impl;

import org.apache.ibatis.session.SqlSession;

import com.drq.dao.BaseDao;
import com.drq.dao.inter.GoodsDetailDaoInter;
import com.drq.dto.GoodsDetailDto;
import com.drq.mapper.GoodsDetailMapper;

public class GoodsDetailsDaoImpl extends BaseDao implements GoodsDetailDaoInter{

	@Override
	public GoodsDetailDto getGoodsDetailById(Integer id) {
		SqlSession sqlSession=getSqlSession();
		GoodsDetailMapper goodsDetailMapper=sqlSession.getMapper(GoodsDetailMapper.class);
		GoodsDetailDto goodsDetailDto = goodsDetailMapper.getGoodsDetailById(id);
		closeSqlSession();
		return goodsDetailDto;
	}
	

}
