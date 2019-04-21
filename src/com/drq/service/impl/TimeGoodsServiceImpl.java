package com.drq.service.impl;

import java.util.List;

import com.drq.dao.impl.TimeGoodsDaoImpl;
import com.drq.dao.inter.TimeGoodsDaoInter;
import com.drq.dto.Goods;
import com.drq.dto.PageBean;
import com.drq.dto.Timlimited;
import com.drq.service.interfaces.TimeGoodsServiceInter;

public class TimeGoodsServiceImpl implements TimeGoodsServiceInter{

	TimeGoodsDaoInter timeDao=new TimeGoodsDaoImpl();
	@Override
	public Integer getRecordCount(String time,String userSelect) {
		return timeDao.getRecordCount(time,userSelect);
	}
	
	@Override
	public List<Timlimited> showTimeList(PageBean page,String time,String userSelect) {
		return timeDao.showTimeList(page,time,userSelect);
	}

	@Override
	public Integer addTimeGoods(Timlimited time,Integer gid) {
		Goods goods=new Goods();
		goods.setId(gid);
		time.setGoods(goods);
		return timeDao.addTimeGoods(time);
	}

	@Override
	public Timlimited getTimeGoodsById(Integer id) {
		return timeDao.getTimeGoodsById(id);
	}

	@Override
	public Integer upDateTimeGoods(Timlimited time, Integer gid) {
		Goods goods=new Goods();
		goods.setId(gid);
		time.setGoods(goods);
		return timeDao.upDateTimeGoods(time);
	}

	@Override
	public Integer deleteTimeGoods(Integer[] ids) {
		return timeDao.deleteTimeGoods(ids);
	}

}
