package com.drq.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.drq.dto.PageBean;
import com.drq.dto.Picturcarousel;


public interface PicetureMapper {

	//显示图片路径列表
	List<Picturcarousel> showPicetureList(@Param("page") PageBean page,@Param("userSelect") String userSelect);

	//获取图片路径的总记录数
	Integer getRecordCount(@Param("userSelect") String userSelect);

	//添加轮播图
	Integer addPiceRoute(Picturcarousel pic);

	//通过ID获得轮播图
	Picturcarousel getPicByid(String id);

	//修改轮播图
	Integer upDatePiceRoute(Picturcarousel pic);

	//删除轮播图
	Integer deletePic(Integer[] ids);

	
}
