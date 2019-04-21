package com.drq.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.drq.dto.PageBean;
import com.drq.dto.Timlimited;


public interface TimeGoodsMapper {

	//获取限时抢购的记录数
	Integer getRecordCount(@Param("time") String time,@Param("userSelect") String userSelect);

	//显示限时抢购列表
	List<Timlimited> showTimeList(@Param("page") PageBean page,@Param("time") String time,@Param("userSelect") String userSelect);

	//添加限时抢购
	Integer addTimeGoods(@Param("time") Timlimited time);

	//通过ID获取限时抢购信息
	Timlimited getTimeGoodsById(Integer id);

	//修改限时抢购
	Integer upDateTimeGoods(@Param("time") Timlimited time);

	//删除限时抢购
	Integer deleteTimeGoods(Integer[] ids);

	
}
