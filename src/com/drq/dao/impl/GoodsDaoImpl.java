package com.drq.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.drq.dao.BaseDao;
import com.drq.dao.inter.GoodsDaoInter;
import com.drq.dto.Goods;
import com.drq.dto.PageBean;
import com.drq.mapper.GoodsMapper;

public class GoodsDaoImpl extends BaseDao implements GoodsDaoInter{

	@Override
	public List<Goods> showGoodsList(PageBean page,String time,String userSelect) {
		SqlSession sqlSession=getSqlSession();
		GoodsMapper goodsMapper=sqlSession.getMapper(GoodsMapper.class);
		List<Goods> goodsList=goodsMapper.showGoodsList(page,time,userSelect);
		closeSqlSession();
		return goodsList;
	}

	@Override
	public Integer getGoodsRecordCount(String time,String userSelect) {
		SqlSession sqlSession=getSqlSession();
		GoodsMapper goodsMapper=sqlSession.getMapper(GoodsMapper.class);
		Integer count=goodsMapper.getGoodsRecordCount(time,userSelect);
		closeSqlSession();
		return count;
	}

	@Override
	public Integer addGoods(Goods goods) {
		SqlSession sqlSession=getSqlSession();
		GoodsMapper goodMapper=sqlSession.getMapper(GoodsMapper.class);
		Integer couont=goodMapper.addGoods(goods);
		sqlSession.commit();
	    closeSqlSession();
		return couont;
	}

	@Override
	public Goods getGoodsById(Integer id) {
		SqlSession sqlSession=getSqlSession();
		GoodsMapper goodsMapper=sqlSession.getMapper(GoodsMapper.class);
		Goods goods=goodsMapper.getGoodsById(id);
		closeSqlSession();
		return goods;
	}

	@Override
	public Integer upDataGoods(Goods goods) {
		SqlSession sqlSession=getSqlSession();
		GoodsMapper goodsMapper=sqlSession.getMapper(GoodsMapper.class);
		Integer count=goodsMapper.upDataGoods(goods);
		sqlSession.commit();
		closeSqlSession();
		return count;
	}

	@Override
	public Integer deleteGoods(Integer[] ids) {
		SqlSession sqlSession=getSqlSession();
		GoodsMapper goodsMapper=sqlSession.getMapper(GoodsMapper.class);
		Integer count=goodsMapper.deleteGoods(ids);
		sqlSession.commit();
		closeSqlSession();
		return count;
	}

	@Override
	public List<Goods> getGoodsTitile(String minTypeCode) {
		SqlSession sqlSession=getSqlSession();
		GoodsMapper goodsMapper=sqlSession.getMapper(GoodsMapper.class);
		List<Goods> goodsList=goodsMapper.getGoodsTitile(minTypeCode);
		closeSqlSession();
		return goodsList;
	}

	@Override
	public List<Goods> getGoodsListByMinCode(String minCode,PageBean page) {
		SqlSession sqlSession=getSqlSession();
		GoodsMapper goodsMapper=sqlSession.getMapper(GoodsMapper.class);
		List<Goods> goodsList=goodsMapper.getGoodsListByMinCode(minCode,page);
		closeSqlSession();
		return goodsList;
	}

	@Override
	public Integer getGoodsListCount(String minCode,PageBean page) {
		SqlSession sqlSession=getSqlSession();
		GoodsMapper goodMapper=sqlSession.getMapper(GoodsMapper.class);
		Integer count=goodMapper.getGoodsListCount(minCode,page);
		closeSqlSession();
		return count;
	}

	@Override
	public List<Goods> getGoodsListByIds(List<Integer> gids) {
		SqlSession sqlSession=getSqlSession();
		GoodsMapper goodsMapper=sqlSession.getMapper(GoodsMapper.class);
		List<Goods> goodsList=goodsMapper.getGoodsListByIds(gids);
		closeSqlSession();
		return goodsList;
	}

	@Override
	public List<Goods> getGoodsListByGids(Integer[] ids) {
		SqlSession sqlSession=getSqlSession();
		GoodsMapper goodsMapper=sqlSession.getMapper(GoodsMapper.class);
		List<Goods> goodsList=goodsMapper.getGoodsListByGids(ids);
		closeSqlSession();
		return goodsList;
	}

}
