package com.drq.dao.inter;

import java.util.List;

import com.drq.dto.PageBean;
import com.drq.dto.Picturcarousel;

public interface PicetureDaoInter {

	//显示轮播图路径列表
	List<Picturcarousel> showPicetureList(PageBean page,String userSelect);

	//获取轮播图路径的总记录数
	Integer getRecordCount(String userSelect);

	//添加轮播图
	Integer addPiceRoute(Picturcarousel pic);

	//通过ID获得轮播图
	Picturcarousel getPicByid(String id);

	//修改轮播图
	Integer upDatePiceRoute(Picturcarousel pic);

	//删除轮播图
	Integer deletePic(Integer[] ids);

}
