package com.drq.service.impl;

import java.util.List;

import com.drq.dao.impl.GoodsDaoImpl;
import com.drq.dao.inter.GoodsDaoInter;
import com.drq.dto.Goods;
import com.drq.dto.PageBean;
import com.drq.service.interfaces.GoodsSericeInter;

public class GoodsServiceImpl implements GoodsSericeInter{

	GoodsDaoInter goodsDao=new GoodsDaoImpl();
	@Override
	public List<Goods> showGoodsList(PageBean page,String time,String userSelect) {
		return goodsDao.showGoodsList(page,time,userSelect);
	}
	
	@Override
	public Integer getGoodsRecordCount(String time,String userSelect) {
		return goodsDao.getGoodsRecordCount(time,userSelect);
	}

	@Override
	public Integer addGoods(Goods goods) {
		return goodsDao.addGoods(goods);
	}

	@Override
	public Goods getGoodsById(Integer id) {
		return goodsDao.getGoodsById(id);
	}

	@Override
	public Integer upDataGoods(Goods goods) {
		return goodsDao.upDataGoods(goods);
	}

	@Override
	public Integer deleteGoods(Integer[] ids) {
		return goodsDao.deleteGoods(ids);
	}

	@Override
	public List<Goods> getGoodsTitile(String minTypeCode) {
		return goodsDao.getGoodsTitile(minTypeCode);
	}

	@Override
	public List<Goods> getGoodsListByMinCode(String minCode,PageBean page) {
		return goodsDao.getGoodsListByMinCode(minCode,page);
	}

	@Override
	public Integer getGoodsListCount(String maxCode,PageBean page) {
		return goodsDao.getGoodsListCount(maxCode,page);
	}

	@Override
	public List<Goods> getGoodsListByIds(List<Integer> gids) {
		return goodsDao.getGoodsListByIds(gids);
	}

	@Override
	public List<Goods> getGoodsListByGids(Integer[] ids) {
		return goodsDao.getGoodsListByGids(ids);
	}

}
