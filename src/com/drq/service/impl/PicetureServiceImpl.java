package com.drq.service.impl;

import java.util.List;

import com.drq.dao.impl.PicetureDaoImpl;
import com.drq.dao.inter.PicetureDaoInter;
import com.drq.dto.PageBean;
import com.drq.dto.Picturcarousel;
import com.drq.service.interfaces.PicetureServiceInter;

public class PicetureServiceImpl implements PicetureServiceInter{

	PicetureDaoInter piceDao=new PicetureDaoImpl();
	@Override
	public List<Picturcarousel> showPicetureList(PageBean page,String userSelect) {
		return piceDao.showPicetureList(page,userSelect);
	}
	
	@Override
	public Integer getRecordCount(String userSelect) {
		return piceDao.getRecordCount(userSelect);
	}

	@Override
	public Integer addPiceRoute(Picturcarousel pic) {
		return piceDao.addPiceRoute(pic);
	}

	@Override
	public Picturcarousel getPicByid(String id) {
		return piceDao.getPicByid(id);
	}

	@Override
	public Integer upDatePiceRoute(Picturcarousel pic) {
		return piceDao.upDatePiceRoute(pic);
	}

	@Override
	public Integer deletePic(Integer[] ids) {
		return piceDao.deletePic(ids);
	}

}
